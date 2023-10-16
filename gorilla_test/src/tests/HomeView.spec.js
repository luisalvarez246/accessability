import { describe, test, expect, waitFor } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import HomeView from "../views/HomeView.vue";
import { createRouter, createMemoryHistory } from "vue-router";
import { ref } from 'vue';

const vuetify = createVuetify({
  components,
  directives,
});
global.ResizeObserver = require("resize-observer-polyfill");
globalThis.matchMedia =
  globalThis.matchMedia ||
  function () {
    return {
      addListener: function () {},
      removeListener: function () {},
    };
  };

describe("HomeView.vue", () => {
  const router = createRouter({
    history: createMemoryHistory(),
    routes: [{ path: "/", component: { template: "" } }],
  });

  test("renders an h1 with correct text", async () => {
    const search = ref({
      city: "",
      type: "",
      categories: [],
    });
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
      props: {
        search,
      },
    });

    await wrapper.vm.$nextTick();

    const h1Element = wrapper.find("h1");

    expect(h1Element).toBeDefined();
    expect(h1Element.text()).toBe("Welcome to AccessAbility");
  });

  test("renders a search location field", async () => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const searchLocationField = wrapper.find("#search-location");

    expect(searchLocationField).toBeDefined();
  });

  test.each(["Oviedo", "Gijón", "Avilés"])(
    "search location field handles input for %s",
    async (municipality) => {
      const wrapper = mount(HomeView, {
        global: {
          plugins: [vuetify, router],
        },
      });

      await wrapper.vm.$nextTick();

      const searchLocationField = wrapper.find("#search-location");

      await searchLocationField.setValue(municipality);

      expect(searchLocationField.element.value).toBe(municipality);
    }
  );

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

  test.each([
    "restaurant",
    "museum",
    "hotel",
    "shops",
    "clinic",
    "cinema",
    "hairdresser",
    "coffee-shops",
  ])("search type of site field handles input for %s", async (siteType) => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const searchTypeOfSiteField = wrapper.find("#search-type-of-site");

    expect(searchTypeOfSiteField).toBeDefined();

    await searchTypeOfSiteField.setValue(siteType);

    expect(searchTypeOfSiteField.element.value).toBe(siteType);
  });

  test("both search location and type of site fields are required", async () => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const searchLocationField = wrapper.find("#search-location");
    const searchTypeOfSiteField = wrapper.find("#search-type-of-site");

    await searchLocationField.setValue("Llanes");
    await searchTypeOfSiteField.setValue("hotel");

    expect(searchLocationField.element.value).toBeTruthy();
    expect(searchTypeOfSiteField.element.value).toBeTruthy();
  });

  test("shows required error message when search location field is left empty", async () => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });

    await wrapper.vm.$nextTick();

    const searchLocationField = wrapper.find("#search-location");

    await searchLocationField.setValue("");

    await searchLocationField.trigger("blur");

    await wrapper.vm.$nextTick();

    const errorMessage = wrapper.find(".v-messages__message");

    expect(errorMessage.exists()).toBe(true);
    expect(errorMessage.text()).toBe("Field is required");
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

  test("checks and unchecks checkboxes", async () => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const checkbox = wrapper.find(".v-checkbox input");
    checkbox.element.checked = true;
    await checkbox.trigger("change");
  
    expect(wrapper.find(".v-checkbox input").element.checked).toBe(true);
  
    checkbox.element.checked = false;
    await checkbox.trigger("change");
  
    expect(wrapper.find(".v-checkbox input").element.checked).toBe(false);
  });

  test("specific checkbox must be checked for search", async () => {
    const wrapper = mount(HomeView, {
      global: {
        plugins: [vuetify, router],
      },
    });
  
    await wrapper.vm.$nextTick();
  
    const checkbox = wrapper.find(".v-checkbox[label='PRM (People with reduced mobility)']");
  
    expect(checkbox.exists()).toBe(true);
  
    await checkbox.trigger("click");
  
    expect(wrapper.vm.$data.checkedCheckboxes).toContain("PRM (People with reduced mobility)");
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
