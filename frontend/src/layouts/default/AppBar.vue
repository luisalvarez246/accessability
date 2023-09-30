<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" app temporary location="right">
      <v-list>
        <v-list-item v-for="(item, index) in navItems" :key="index" @click="goToPage(item.to)">
          <RouterLink :to="item.to" class="text-decoration-none">
            <v-list-item-title>{{ item.label }}</v-list-item-title>
          </RouterLink>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar app class="d-flex" color="navbar">
    
      <router-link to="/" class="d-flex align-center text-white text-decoration-none mx-4">
        <v-img src="../../assets/images/Logo.png" class="mr-2" width="56" alt="Logotipo de Accessability."></v-img>
        <p>Accessability</p>
      </router-link>

      <v-spacer></v-spacer>

      <v-app-bar-nav-icon @click="drawer = true" class="d-flex d-md-none"></v-app-bar-nav-icon>

      <v-btn-group density="compact" class="d-none d-md-flex">
        <v-btn v-for="(item, index) in navItems" :key="index" :to="item.to" class="text-none text-subtitle-1 mr-6" variant="flat" rounded="lg" color="navbarbtns" :aria-label="item.label" :tabindex="index">
          {{ item.label }}
        </v-btn>
      </v-btn-group>
    </v-app-bar>
  </v-app>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const drawer = ref(false);
const navItems = [
  { label: 'Accessibility', to: '/accessability' },
  { label: 'About us', to: '/about-us' },
  { label: 'Register a new site', to: '/register-new-site' },
];

const isDesktop = ref(window.innerWidth >= 600);

const goToPage = (route) => {
  if (route) {
    this.$router.push(route);
    drawer.value = false; // Cerrar el menú después de hacer clic en un elemento
  }
};

onMounted(() => {
  window.addEventListener('resize', () => {
    isDesktop.value = window.innerWidth >= 600;
  });
});
</script>

<style scoped>
</style>
