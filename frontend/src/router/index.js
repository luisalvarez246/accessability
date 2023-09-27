// Composables
import { createRouter, createWebHistory } from 'vue-router'
import TermsOfUse from '../views/TermsOfUse.vue'
import PrivacyPolicy from '../views/PrivacyPolicy.vue'
import Cookies from '../views/Cookies.vue'

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
      },
      { 
        path: '/terms-of-use', 
        name: 'terms-of-use', 
        component: TermsOfUse, 
      },
      { 
        path: '/privacy-policy', 
        name: 'privacy-policy', 
        component: PrivacyPolicy,
      },
      { 
        path: '/cookies', 
        name: 'cookies', 
        component: Cookies,
      },

    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
