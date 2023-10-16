import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import AppBar from "../components/AppBar.vue";
import { createRouter, createMemoryHistory } from "vue-router";

const vuetify = createVuetify({
	components,
	directives,
  })
global.ResizeObserver = require("resize-observer-polyfill");

describe("AppBar.vue", () => {
	const router = createRouter({
		history: createMemoryHistory(),
		routes: [
      { path: "/", component: { template: "" } },
		],
  });
  
  test("should render the logo", () => {
    const wrapper = mount(AppBar,
    {
        props: {},
        global: 
      {
          plugins: [vuetify, router],
        }
    });
	  const logo = wrapper.find("img[alt='AccessAbility Logo']");
    expect(logo.exists()).toBe(true);
  });

  test("should render the navigation links", () => {
    const wrapper = mount(AppBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const navigationLinks = wrapper.findAll(".appbar a.v-btn");
    expect(navigationLinks.length).toBe(3);
  });

  test("should render the navigation drawer", () => {
    const wrapper = mount(AppBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const drawer = wrapper.find(".appbar .v-navigation-drawer");
    expect(drawer.exists()).toBe(true);
  });

  test("should navigate to Accessibility page", async () => {
      await router.push("/accessibility");
      expect(router.currentRoute.value.path).toBe("/accessibility");
  });

  test("should navigate to About us page", async () => {
    await router.push("/about-us");
    expect(router.currentRoute.value.path).toBe("/about-us");
  });

  test("should navigate to Register your site page", async () => {
      await router.push("/register");
      expect(router.currentRoute.value.path).toBe("/register");
  });

  test("should highlight the active button", () => {
    const wrapper = mount(AppBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const activeButton = wrapper.find(".appbar a.v-btn:active");
    expect(activeButton.exists()).toBe(true);
  });

  test("should toggle the drawer when menu icon is clicked", async () => {
    const wrapper = mount(AppBar,
      {
          props: {},
          global: 
        {
            plugins: [vuetify, router],
          }
      });
    const menuIcon = wrapper.find(".appbar .v-app-bar-nav-icon");
    await menuIcon.trigger("click");
    expect(wrapper.vm.drawer).toBe(true);
  });
});
