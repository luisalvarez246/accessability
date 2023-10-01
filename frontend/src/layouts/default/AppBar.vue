<template>
  <v-app class="appbar">
    <v-app-bar 
      class="d-flex"
      color="navbar">
      <router-link
        to="/"
        class="d-flex align-center text-white text-decoration-none mx-4">
        <v-img src="../../assets/images/Logo.png"
          class="mr-1"
          width="56"
          alt="Accessability Logo">
        </v-img>
        <p>Accessability</p>
      </router-link>

      <v-spacer></v-spacer>

      <v-btn-group
        density="compact"
        class="d-none d-sm-flex"
        color="navbarbtns"
        variant="flat"
        >
        <v-btn
          v-for="(item, index) in navItems"
          :key="index"
          :to="item.to"
          @click="goToPage(item.to)"
          :class="{
            'custom-button': true,
            'active-button': isActiveButton(item.to),
            'text-none': true,
            'mr-6': true,
            'px-2': true
          }"
          rounded="lg"
        >
          {{ item.label }}
        </v-btn>
      </v-btn-group>

      <v-app-bar-nav-icon
        @click.stop="drawer = !drawer"
        aria-label="Menu"
        class="d-flex d-sm-none">
      </v-app-bar-nav-icon>
    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      location="top"
      temporary
      class="h-auto">
      <v-list>
        <v-list-item v-for="(item, index) in navItems" :key="index" @click="goToPage(item.to)">
          <router-link :to="item.to"
            class="text-decoration-none">
            <v-list-item-title>{{ item.label }}</v-list-item-title>
          </router-link>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-app>
</template>

<script setup>
import { ref, watch } from 'vue';
import { useRouter } from 'vue-router';

const drawer = ref(false);
const group = ref(null);

const navItems = [
  { label: 'Accessibility', to: '/accessability' },
  { label: 'About us', to: '/about-us' },
  { label: 'Register a new site', to: '/register-new-site' },
];

watch(group, () => {
    drawer.value = false
  })

const router = useRouter();

const goToPage = (route) => {
  if (route) {
    router.push(route);
    drawer.value = false;
  }
};

const isActiveButton = (route) => router.currentRoute.value.path === route;
</script>

<style scoped>
.appbar {
  height: 3.2rem;
}
.active-button {
  background: #4A148C !important;
  border-width: 0.125rem !important;
  border-bottom-color: #26C6DA !important;
  border-radius: 0rem !important;
  color: #26C6DA !important;
}
</style>
