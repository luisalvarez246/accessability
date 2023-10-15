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

  test("renders all 6 team member cards", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const vCardItemElements = wrapper.findAll(".team_members_item");
  
    expect(vCardItemElements.length).toBe(6);
});

  test("renders the 'Carmen' team member card", async () => {
    const wrapper = mount(AboutUsView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const carmenCard = wrapper.find(".v-card:has(img[alt='Carmen photo'])");

    expect(carmenCard.exists()).toBe(true);
  });

  test("renders the correct name in the 'Carmen' team member card", async () => {
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
  
});