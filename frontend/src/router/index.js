// Composables
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/Home.vue'),
      },
      { 
        path: '/terms-of-use', 
        name: 'terms-of-use', 
        component: () => import('@/views/TermsOfUseView.vue'),
      },
      { 
        path: '/privacy-policy', 
        name: 'privacy-policy', 
        component: () => import('@/views/PrivacyPolicyView.vue'),
      },
      { 
        path: '/cookies', 
        name: 'cookies', 
        component: () => import('@/views/CookiesView.vue'),
      },

    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
