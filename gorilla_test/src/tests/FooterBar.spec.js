import { describe, test} from "vitest";
import { use, expect } from 'chai';
import chaiDom from 'chai-dom';
import { mount } from "@vue/test-utils";
import { createVuetify } from "vuetify";
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import FooterBar from "./FooterWrapper.vue";
import { createRouter, createMemoryHistory } from "vue-router";
import TermsOfUseView from '@/views/TermsOfUseView.vue';
import CookiesView from '@/views/CookiesView.vue'
import PrivacyPolicyView from '@/views/PrivacyPolicyView.vue'

const vuetify = createVuetify({
	components,
	directives,
  })

global.ResizeObserver = require("resize-observer-polyfill");
use(chaiDom);

describe("FooterBar.vue", () => {
    const router = createRouter({
		history: createMemoryHistory(),
		routes: [
            {
                path: "/",
                name:'home',
                component: { template: "" }
            },
            {
                path: '/terms-of-use',
                component: TermsOfUseView,
                name: 'terms-of-use'
              },
              {
                path: '/privacy-policy',
                component: PrivacyPolicyView,
                name: 'privacy-policy'
              },
              {
                path: '/cookies',
                component: CookiesView,
                name: 'cookies'
              },
		],
    });

    test("should render the navigation links", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });

        const links = wrapper.findAll(".link-title");
        expect(links.length).toBe(3);
    });

    test("should navigate to Terms of Use page", async () => {
        await router.push("/terms-of-use");
        expect(router.currentRoute.value.path).toBe("/terms-of-use");
    });
    
    test("should navigate to Privacy Policy page", async () => {
        await router.push("/privacy-policy");
        expect(router.currentRoute.value.path).toBe("/privacy-policy");
    });

    test("should navigate to Cookies page", async () => {
        await router.push("/cookies");
        expect(router.currentRoute.value.path).toBe("/cookies");
    });

    test("renders 3 social icons ", async () => {
        const wrapper = mount(FooterBar,
            {
                props: {},
                global:
                {
                    plugins: [vuetify, router],
                }
            });

        const icons = wrapper.findAll(".social-icon");
        expect(icons.length).toBe(3);
    });
    
 
    test("renders copyright text with the current year", async () => {
        const wrapper = mount(FooterBar, {
          props: {},
          global: {
            plugins: [vuetify, router],
          },
        });
      
        const copyright = wrapper.get("span.copyright");
        const currentYear = new Date().getFullYear();
        const expectedText = `© Copyright ${currentYear} - AccessAbility`;

        expect(copyright.text()).to.include(expectedText);
    });

    test("applies link highlighting for active route", async () => {
        const wrapper = mount(FooterBar,
        {
            props: {},
            global:
            {
                plugins: [vuetify, router],
            }
        });

        const activeButton = wrapper.find(".footerbar .active-button");
        expect(activeButton.exists()).toBe(true);
    });
});
