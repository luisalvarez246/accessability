import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import RegisterView from "../views/RegisterView.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
	components,
	directives,
  })
global.ResizeObserver = require("resize-observer-polyfill");

describe('RegisterView.vue', () => {
    const router = createRouter({
        history: createMemoryHistory(),
        routes: [
            { path: "/", component: { template: "" } },
        ],
    });

    test('renders the form fields correctly', async () => {
        const wrapper = mount(RegisterView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });

        await wrapper.vm.$nextTick();

        expect(wrapper.find('#storeName').exists()).toBe(true);
        expect(wrapper.find('#phone').exists()).toBe(true);
        expect(wrapper.find('#address').exists()).toBe(true);
        expect(wrapper.find('#email').exists()).toBe(true);
        expect(wrapper.find('#web').exists()).toBe(true);
        expect(wrapper.find('#city').exists()).toBe(true);
        expect(wrapper.find('#type').exists()).toBe(true);
        expect(wrapper.find('#image').exists()).toBe(true);
        expect(wrapper.find('#description').exists()).toBe(true);
    });

    test('validates form input', async () => {
        const wrapper = mount(RegisterView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });

        await wrapper.vm.$nextTick();

        const nameInput = wrapper.find('#storeName');
        await nameInput.setValue('My Store');

        const phoneInput = wrapper.find('#phone');
        await phoneInput.setValue('123456789');

        const addressInput = wrapper.find('#address');
        await addressInput.setValue('123 Main St');

        await wrapper.vm.$nextTick();

        expect(wrapper.vm.store.storeName).toBe('My Store');
        expect(wrapper.vm.store.phone).toBe('123456789');
        expect(wrapper.vm.store.address).toBe('123 Main St');
    });

    test('performs form submission', async () => {
        const wrapper = mount(RegisterView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });

        await wrapper.vm.$nextTick();

        const nameInput = wrapper.find('#storeName');
        await nameInput.setValue('My Store');

        const selectInput = wrapper.find("#city"); 
        await wrapper.vm.$nextTick();

        await selectInput.setValue('Ribadesella');

        const selectType = wrapper.find("#type"); 
        await wrapper.vm.$nextTick();

        await selectType.setValue('restaurant');

        const checkboxes = wrapper.findAll(".characteristicCheckbox");
        if (checkboxes.length > 0) {
            checkboxes.wrappers.forEach(async (checkbox) => {
              checkbox.vm.$emit("input", true); 
              await wrapper.vm.$nextTick(); 
            });
        };
        await wrapper.vm.$nextTick(); 
        await wrapper.find('form').trigger('submit.prevent');
    });
});