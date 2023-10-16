import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import HomeView from "./HomeWrapper.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
	components,
	directives,
  })
global.ResizeObserver = require("resize-observer-polyfill");

globalThis.matchMedia =
  globalThis.matchMedia ||
  function () {
    return {
      addListener: function () {},
      removeListener: function () {},
    };
  };

describe('HomeView.vue', () => {
    const router = createRouter({
        history: createMemoryHistory(),
        routes: [
            { path: "/", component: { template: "" } },
        ],
    });

    test('renders correctly', () => {
        const wrapper = mount(HomeView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });
        console.log(wrapper.html());
        expect(wrapper.exists()).toBe(true);
    });

    test("renders an h1 with correct text", async () => {
        const wrapper = mount(HomeView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });
    
        await wrapper.vm.$nextTick();
    
        const h1Element = wrapper.find(".underline");
    
        console.log(wrapper.html());
        expect(h1Element).toBeDefined();
        expect(h1Element.text()).toBe("Welcome to AccessAbility");
        
    });

    test("renders a search location field", async () => {
        const wrapper = mount(HomeView, {
            props: {
                show: true,
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });
    
        await wrapper.vm.$nextTick();
    
        const searchLocationField = wrapper.find("#search-location");
    
        expect(searchLocationField).toBeDefined();
    });
    
    test("renders a search type of site field with correct attributes", async () => {
        const wrapper = mount(HomeView, {
          global: {
            plugins: [vuetify, router],
          },
        });
    
        await wrapper.vm.$nextTick();
    
        const searchTypeOfSiteField = wrapper.find("#search-type-of-site");
    
        expect(searchTypeOfSiteField).toBeDefined();
    
        expect(searchTypeOfSiteField.attributes("aria-describedby")).toBe(
          "search-type-of-site-messages"
        );
    });
    
    test("renders checkboxes with correct labels", async () => {
        const wrapper = mount(HomeView, {
          global: {
            plugins: [vuetify, router],
          },
        });
    
        await wrapper.vm.$nextTick();
    
        const checkboxes = wrapper.findAll(".v-checkbox");
    
        expect(checkboxes).toHaveLength(3);
        expect(checkboxes[0].text()).toBe("PRM (People with reduced mobility)");
        expect(checkboxes[1].text()).toBe("Visually impaired");
        expect(checkboxes[2].text()).toBe("Impaired hearing");
    });
    
    test("search button is rendered", async () => {
        const wrapper = mount(HomeView, {
          global: {
            plugins: [vuetify, router],
          },
        });
      
        await wrapper.vm.$nextTick();
      
        const searchButton = wrapper.find(".searchButton");
    
        expect(searchButton.exists()).toBe(true);
      });
    
});
