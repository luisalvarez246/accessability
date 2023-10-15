import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import FooterBar from "./FooterWrapper.vue";
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

    test("renders links with correct text and attributes", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });

        const links = wrapper.getAll("a.link-content");
        expect(links.length).toBe(3);
    });

    test("renders links with correct text and attributes", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });
        const linkTexts = ["Terms of Use", "Privacy Policy", "Cookies"];
        const links = wrapper.getAll(i.route);
        for (let i = 0; i < 3; i++) {
            expect(links[i]).toHaveText(linkTexts[i]);
            expect(links[i]).toHaveAttribute("href", `/${linkTexts[i].toLowerCase()}`);
            expect(links[i]).toHaveAttribute("role", "link");
            expect(links[i]).toHaveAttribute("aria-label", linkTexts[i]);
            expect(links[i]).toHaveAttribute("aria-current", "false");
        }
    });
    
    test("renders social icons with correct attributes", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });

        const icons = wrapper.getAll("i.social-icon");
        expect(icons.length).toBe(3);
    });
    
    test("attributes icons are correct", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });

        const iconLabels = ["Follow us on Twitter", "Connect with us on LinkedIn", "Discover our photos on Instagram"];
        const icons = wrapper.getAll("i.social-icon");
        for (let i = 0; i < 3; i++) {
            expect(icons[i]).toHaveAttribute("aria-label", iconLabels[i]);
        }
    });
    
 
  test("renders copyright text with the current year", async () => {
    const wrapper = mount(FooterBar,
        {
            props: {},
            global:
            {
                plugins: [vuetify, router],
            }
        });

    const copyright = wrapper.get("span.copyright");
    const currentYear = new Date().getFullYear();

    expect(copyright).toHaveText(`© Copyright ${currentYear} - AccessAbility`);
  });

  test("applies link highlighting for active route", async () => {
    const router = {
      currentRoute: {
        value: { name: "terms-of-use" }, 
      },
    };
    const wrapper = mount(FooterBar,
        {
            props: {},
            global:
            {
                plugins: [vuetify, router],
            }
        });

    const activeLink = wrapper.get("a.link-content.active-button");
    expect(activeLink).not.toBeNull();
  });
});
