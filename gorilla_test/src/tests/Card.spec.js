import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import Card from "@/components/Card.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
    components,
    directives,
});

global.ResizeObserver = require("resize-observer-polyfill");

describe("Card.vue", () => {
    const router = createRouter({
        history: createMemoryHistory(),
        routes: [
            { path: "/", component: { template: "" } },
        ],
    });

    test("handles missing props gracefully", () => {
    const wrapper = mount(Card, {
        global: {
        plugins: [vuetify, router],
        },
    });
    
    expect(wrapper.exists()).toBe(true);
    expect(wrapper.find(".v-card-actions button").exists()).toBe(true);
    });

    test("renders the store name and type", () => {
        const wrapper = mount(Card,
        {
            props: {
                storeName: "Casa Pepe",
                type: "restaurant",
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });

        const title = wrapper.find(".v-card-title");

        expect(title.text()).toContain("Casa Pepe");
        expect(title.text()).toContain("restaurant");
    });
  
    
    test("displays images correctly", () => {
        const wrapper = mount(Card, {
          props: {
            storeName: "Casa Pepe",
            type: "restaurant",
            image: "http://localhost:8080/images//default.png",
          },
          global: {
            plugins: [vuetify, router],
          },
        });
       
        const img = wrapper.find(".v-img__img--contain");
        expect(img.exists()).toBe(true);
        expect(img.attributes("src")).toContain("default.png");
    });
   

    test("displays dynamic content correctly", async() => {
        const wrapper = mount(Card, {
            props: {
            storeName: "Casa Pepe",
            type: "restaurant",
            description: "A great place to enjoy delicious food!",
            },
            global: {
            plugins: [vuetify, router],
            },
        });
    
        const toggleButton = wrapper.find(".active");
        
        await toggleButton.trigger("click");
        await wrapper.vm.$nextTick();
            
        const description = wrapper.find(".descriptionField");

        expect(description.text()).toContain("A great place to enjoy delicious food!");
    });
      
    test("applies styles and design correctly", () => {
        const wrapper = mount(Card, {
          props: {
            storeName: "Casa Pepe",
            type: "restaurant",
          },
          global: {
            plugins: [vuetify, router],
          },
        });
      
        const card = wrapper.findComponent({ name: "v-card" });

        expect(card.props("color")).toBe("#59029F"); 
      
        const button = wrapper.findComponent({ name: "v-btn" });
        expect(button.props("color")).toBe("#7ED057"); 
      
    });
      
    test("toggles show more info", async () => {
        const wrapper = mount(Card,
        {
            props: {
                storeName: "Casa Pepe",
                type: "restaurant",
            },
            global: 
            {
                plugins: [vuetify, router],
            }
        });
     
        const toggleButton = wrapper.find(".active");
        
        expect(wrapper.find(".v-expand-transition").exists()).toBe(false);
    
        await toggleButton.trigger("click");
        await wrapper.vm.$nextTick();
    
        expect(wrapper.find(".v-card__underlay").exists()).toBe(true);
    });

});
  