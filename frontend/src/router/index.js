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
        component: () => import('@/views/HomeView.vue'),
      },
      {
        path: '/accessability',
        name: 'Accessability',
        component: () => import('@/views/AccessabilityView.vue'),
      },
      {
        path: '/about-us',
        name: 'AboutUs',
        component: () => import('@/views/AboutUsView.vue'),
      },
      {
        path: '/register',
        name: 'RegisterView',
        component: () => import('@/views/RegisterView.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
