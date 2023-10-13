import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import FooterBar from "../components/FooterBar.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
	components,
	directives,
  })
global.ResizeObserver = require("resize-observer-polyfill");

describe("FooterBar.vue", () => {
	const router = createRouter({
		history: createMemoryHistory(),
		routes: [
      { path: "/", component: { template: "" } },
		],
  });

  test("should render 3 social icons", () => {
    const wrapper = mount(FooterBar,
    {
        props: {},
        global: 
      {
          plugins: [vuetify, router],
        }
    });
	  //const socialinks = wrapper.findAll(".footerbar a.v-icon");
    expect(socialinks.length).toBe(3);
  });
/*
  test("should render the navigation links", () => {
    const wrapper = mount(FooterBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const navigationLinks = wrapper.findAll(".footerbar a.v-btn");
    expect(navigationLinks.length).toBe(3);
  });

  test("should render the navigation drawer", () => {
    const wrapper = mount(FooterBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const drawer = wrapper.find(".footerbar .v-navigation-drawer");
    expect(drawer.exists()).toBe(true);
  });

  test("should highlight the active button", () => {
    const wrapper = mount(FooterBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    
    const activeButton = wrapper.find(".footerbar a.v-btn:active");
    expect(activeButton.exists()).toBe(true);
  });

  test("should toggle the drawer when menu icon is clicked", async () => {
    const wrapper = mount(FooterBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const menuIcon = wrapper.find(".footerbar .v-app-bar-nav-icon");
    await menuIcon.trigger("click");
    expect(wrapper.vm.drawer).toBe(true);
  });
*/
});
