import { createRouter, createWebHistory } from 'vue-router'
import { useLaunchStore } from '../store/launchStore'
import ApiConnection from '../services/ApiConnection'
import HomeView from '../views/HomeView.vue'
import AccessibilityView from '../views/AccessibilityView.vue'
import AboutUsView from '../views/AboutUsView.vue'
import RegisterView from '../views/RegisterView.vue'
import TermsOfUseView from '../views/TermsOfUseView.vue'
import PrivacyPolicyView from '../views/PrivacyPolicyView.vue'
import CookiesView from '../views/CookiesView.vue'
import SearchView from '../views/SearchView.vue'

const	loadSearchData = async () =>
{
	const typesInStore = await ApiConnection.getTypesInStore()
	const citiesInStore = await ApiConnection.getCitiesInStore();

	useLaunchStore().setTypes(typesInStore.data.sort());
	useLaunchStore().setCities(citiesInStore.data.sort());
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
	  beforeEnter: [loadSearchData],
    },
    {
      path: '/accessibility',
      name: 'Accessibility',
      component: AccessibilityView,
    },
    {
      path: '/about-us',
      name: 'AboutUs',
      component: AboutUsView,
    },
    {
      path: '/register',
      name: 'RegisterView',
      component: RegisterView,
    },
    {
      path: '/terms-of-use',
      name: 'terms-of-use',
      component: TermsOfUseView,
    },
    {
      path: '/privacy-policy',
      name: 'privacy-policy',
      component: PrivacyPolicyView,
    },
    {
      path: '/cookies',
      name: 'cookies',
      component: CookiesView,
    },
    {
      path: '/search',
      name: 'search',
      component: SearchView,
    }
  ]
})
export default router