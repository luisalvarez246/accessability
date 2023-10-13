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
		  // Define other routes as needed for your component.
		],
	  });
  test("should render the logo", () => {
    //const wrapper = mount(AppBar);
	const wrapper = mount(AppBar,
	{
    	props: {},
    	global: 
		{
    	  plugins: [vuetify, router],
    	}
	});
	const logo = wrapper.find("img[alt='AccessAbility Logo']");
	// console.log(wrapper.html());
	// console.log("I am the logo" + logo);
    expect(logo.exists()).toBe(true);
  });
/*
  test("should render the navigation links", () => {
    const wrapper = mount(AppBar);
    const navigationLinks = wrapper.findAll(".appbar .custom-button");
    expect(navigationLinks.length).toBe(3);
  });

  test("should render the navigation drawer", () => {
    const wrapper = mount(AppBar);
    const drawer = wrapper.find(".appbar .v-navigation-drawer");
    expect(drawer.exists()).toBe(true);
  });

  test("should navigate to Accessibility page", async () => {
    const wrapper = mount(AppBar);
    await wrapper.find(".appbar .custom-button").trigger("click");
    expect(wrapper.vm.$route.path).toBe("/accessibility");
  });

  test("should navigate to About us page", async () => {
    const wrapper = mount(AppBar);
    await wrapper.find(".appbar .custom-button").trigger("click");
    expect(wrapper.vm.$route.path).toBe("/about-us");
  });

  test("should navigate to Register your site page", async () => {
    const wrapper = mount(AppBar);
    await wrapper.find(".appbar .custom-button").trigger("click");
    expect(wrapper.vm.$route.path).toBe("/register");
  });

  test("should highlight the active button", () => {
    const wrapper = mount(AppBar, {
      global: { plugins: [vuetify] },
      props: { currentRoute: "/about-us" },
    });
    const activeButton = wrapper.find(".appbar .active-button");
    expect(activeButton.exists()).toBe(true);
  });

  test("should toggle the drawer when menu icon is clicked", async () => {
    const wrapper = mount(AppBar);
    const menuIcon = wrapper.find(".appbar .v-app-bar-nav-icon");
    await menuIcon.trigger("click");
    expect(wrapper.vm.drawer).toBe(true);
  });*/
});
