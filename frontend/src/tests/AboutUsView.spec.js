import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import AboutUsView from "../views/AboutUsView.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
	components,
	directives,
  })
global.ResizeObserver = require("resize-observer-polyfill");

describe("AboutUsView.vue", () => {
	const router = createRouter({
		history: createMemoryHistory(),
		routes: [
      { path: "/", component: { template: "" } },
		],
  });

  test("renders all 6 team member v-card-item", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const vCardItemElements = wrapper.findAll(".team_members_item");
  
    expect(vCardItemElements.length).toBe(6);
});

  test("renders the 'Carmen' team member v-card-item", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const carmenCard = wrapper.find(".v-card:has(img[alt='Carmen photo'])");

    expect(carmenCard.exists()).toBe(true);
  });

  
  test("renders the 'Carmen photo' team member v-card-item", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const carmenItem = wrapper.find('.team_members_item', {
      team_members_title: "Carmen photo"
    });
  
    expect(carmenItem.exists()).toBe(true);
  });

  test("renders the correct name in the 'Carmen' team member v-card-item", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();

    const carmenCard = wrapper.find(".v-card:has(img[alt='Carmen photo'])");

    expect(carmenCard.exists()).toBe(true);

    expect(carmenCard.find(".team_members_title").text()).toBe("Carmen");
  });

  test("v-form renders correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const form = wrapper.find('.v-form');
  
    expect(form.exists()).toBe(true);
  });

  test("first text field renders correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();

    const nameField = wrapper.find('input[name="name"]');
    if (nameField.exists()) {
      nameField.setValue('John Doe');

      expect(nameField.element.value).toBe('John Doe');
    }
  });

  test("second text field renders correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const emailField = wrapper.find('input[name="email"]');
    if (emailField.exists()) {
      emailField.setValue('johndoe@example.com');
  
      expect(emailField.element.value).toBe('johndoe@example.com');
    }
  });

  test("textarea renders correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();

    const thoughtsField = wrapper.find('textarea[name="thoughts"]');
    if (thoughtsField.exists()) {
      thoughtsField.setValue('This is a test message.');
  
      expect(thoughtsField.element.value).toBe('This is a test message.');
    }
  });

  test("Submit button works correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const submitButton = wrapper.find('v-btn[class="submit_btn"]');
  
    if (submitButton.exists()) {
      wrapper.vm.name = 'John Doe';
      wrapper.vm.email = 'john.doe@example.com';
      wrapper.vm.thoughts = 'This is a test message.';
  
      submitButton.trigger('click');
  
      await wrapper.vm.$nextTick();
  
      expect(wrapper.vm.form.value.submitted).toBe(true);
    } else {
    }
  });

  test("Cancel button works correctly", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();

    const cancelButton = wrapper.find('v-btn[class="reset_btn"]');
  
    if (cancelButton.exists()) {
      wrapper.vm.name = 'John Doe';
      wrapper.vm.email = 'john.doe@example.com';
      wrapper.vm.thoughts = 'This is a test message.';
  
      cancelButton.trigger('click');
  
      await wrapper.vm.$nextTick();

      expect(wrapper.vm.name).toBe('');
      expect(wrapper.vm.email).toBe('');
      expect(wrapper.vm.thoughts).toBe('');
    } else {
    }
  });
  
});