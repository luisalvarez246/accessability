<!--<template>
  <v-app-bar app class="d-flex no-wrap" color="navbar">
    <div class="d-flex align-center mx-6">
      <v-img src="../../assets/images/Logo.png" class="mr-2" width="56" alt="Logotipo de Accessability."></v-img>
      <p>Accessability</p>
    </div>
       
    <v-spacer></v-spacer>
    
    <v-btn-group density="compact">
      <v-btn class="text-none text-subtitle-1 mr-4" to="/accessability" variant="flat" rounded="lg" color="navbarbtns" key="1" aria-label="Accessability" tabindex="0">
      Accessibility
      </v-btn>
      <v-btn class="text-none text-subtitle-1 mr-4" to="/about-us" variant="flat" rounded="lg" color="navbarbtns" key="1" aria-label="About us" tabindex="0">
        About us
      </v-btn>
      <v-btn class="text-none text-subtitle-1 mr-8" to="/register-new-site" variant="flat" rounded="lg" color="navbarbtns" key="1" aria-label="Register a new site" tabindex="0">
        Register a new site
      </v-btn>
    </v-btn-group>
  </v-app-bar>
</template>

<script setup>
  //
</script>

<style scoped>
</style>-->

<template>
  <v-app-bar app class="d-flex no-wrap" color="navbar">
    <router-link to="/" class="d-flex align-center mx-6 text-white text-decoration-none">
      <v-img src="../../assets/images/Logo.png" class="mr-2" width="56" alt="Logotipo de Accessability."></v-img>
      <p>Accessability</p>
    </router-link>

    <!-- Menú hamburguesa para dispositivos móviles -->
    <v-btn icon @click="menu = !menu" v-show="!isDesktop">
      <v-icon>mdi-menu</v-icon>
    </v-btn>

    <v-menu v-model="menu" :offset-y="isDesktop ? undefined : -1">
      <v-list>
        <v-list-item v-for="(item, index) in navItems" :key="index" @click="goToPage(item.to)">
          <v-list-item-title>{{ item.label }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <v-spacer></v-spacer>

    <!-- Botones para pantallas grandes -->
    <v-btn-group density="compact" v-show="isDesktop">
      <v-btn v-for="(item, index) in navItems" :key="index" :to="item.to" variant="flat" rounded="lg" color="navbarbtns" :aria-label="item.label" :tabindex="index">
        {{ item.label }}
      </v-btn>
    </v-btn-group>
  </v-app-bar>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const menu = ref(false);
const navItems = [
  { label: 'Accessibility', to: '/accessability' },
  { label: 'About us', to: '/about-us' },
  { label: 'Register a new site', to: '/register-new-site' },
];

const isDesktop = ref(window.innerWidth >= 768);

const goToPage = (route) => {
  if (route) {
    this.$router.push(route);
    menu.value = false; // Cerrar el menú después de hacer clic en un elemento
  }
};

onMounted(() => {
  window.addEventListener('resize', () => {
    isDesktop.value = window.innerWidth >= 768;
  });
});
</script>


<style scoped>
</style>
