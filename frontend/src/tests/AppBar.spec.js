import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import AppBar from "../layouts/default/AppBar.vue";

const vuetify = createVuetify();

global.ResizeObserver = require("resize-observer-polyfill");

describe("AppBar.vue", () => {
  test("should render the logo", () => {
    const wrapper = mount(AppBar);
    const logo = wrapper.find(".appbar img");
    expect(logo.exists()).toBe(true);
  });

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
  });
});
