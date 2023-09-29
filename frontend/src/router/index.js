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
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "home" */ '@/views/HomeView.vue'),
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
        path: '/register-new-site',
        name: 'RegisterNewSite',
        component: () => import('@/views/RegisterNewSiteView.vue'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
