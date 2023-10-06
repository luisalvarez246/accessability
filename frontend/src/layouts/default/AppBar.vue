<template>
  <v-app class="appbar">
    <v-app-bar 
      class="d-flex"
      color="navbar">
      <router-link
        to="/"
        :class="{
          'd-flex': true,
          'align-center': true,
          'text-white': true,
          'text-decoration-none': true,
          'mx-4': true,
          'active-home': isHomeActive
        }"
        >
        <v-img src="../../assets/images/Logo.png"
          class="mr-1"
          width="56"
          alt="Accessability Logo">
        </v-img>
        <p>Accessability</p>
      </router-link>

      <v-spacer></v-spacer>

      <v-btn-group
        class="d-none d-sm-flex"
        density="compact"
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
            'px-2': true,
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
        <v-list-item
          v-for="(item, index) in navItems"
          :key="index"
          @click="goToPage(item.to)"
          class="custom-list-item"
          >
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
import { ref, computed, } from 'vue';
import { useRouter } from 'vue-router';


const drawer = ref(false);

const navItems = [
  { label: 'Accessibility', to: '/accessability' },
  { label: 'About us', to: '/about-us' },
  { label: 'Register your site', to: '/register-new-site' },
];

const router = useRouter();

const goToPage = (route) => {
  if (route) {
    router.push(route);
    drawer.value = false;
  }
};

const isHomeActive = computed(() => isActiveButton('/'));
const isActiveButton = (route) => router.currentRoute.value.path === route;
</script>

<style scoped>
.appbar {
  height: 3.2rem;
}
.active-home {
  text-decoration: underline;
  font-weight: 700;
}
.active-button {
  background: #4A148C !important;
  border-bottom: 0.125rem #FFD740 solid !important;
  color: #FFD740 !important;
}
.custom-button:focus {
  background-color: #4A148C !important;
  color: #FFD740 !important;
  border: 2px solid #FFD740 !important;
}
.v-list-item:hover {
  background-color: #FFD740 !important;
}
.v-list-item:active {
  background-color: #FFD740 !important;
  color: white;
}
.v-list-item-title {
  color: #4A148C !important;
}
.v-list-item-title:hover, .v-list-item-title:active {
  font-weight: 600;  
  font-size: 1.1rem;
}

.v-list-item--variant-plain, .v-list-item--variant-outlined, .v-list-item--variant-text, .v-list-item--variant-tonal {
  background: transparent;
  color: #FFD740;
}

</style>
