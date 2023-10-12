<template>
  <v-app class="appbar">
    <v-app-bar class="d-flex position-sticky" :elevation="1" color="navbar">
      <router-link to="/" @click="goToPage('/')" :class="{
        'd-flex': true,
        'align-center': true,
        'text-white': true,
        'text-decoration-none': true,
        'mx-4': true,
        'active-home': isHomeActive
      }">
        <v-img src="../../assets/images/logo.png" class="mr-1" width="56" alt="AccessAbility Logo"></v-img>
        <span class="textlogo">AccessAbility</span>
      </router-link>

      <v-spacer></v-spacer>

      <v-btn-group class="d-none d-md-flex" density="compact"  variant="flat">
        <v-btn v-for="(item, index) in navItems" :key="index" :to="item.to" @click="goToPage(item.to)" class="navButtons" :class="{
          'active-button': isActiveButton(item.to),
          'text-none': true,
          'font-weight-bold': true,
          'mr-6': true,
          'px-2': smAndDown,
          'px-4': !smAndDown,
          'd-none': sm,
        }" rounded="xl">
          {{ item.label }}
        </v-btn>
      </v-btn-group>

      <v-app-bar-nav-icon @click.stop="drawer = !drawer" aria-label="Menu" class="d-flex d-md-none">
      </v-app-bar-nav-icon>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" location="top" temporary class="h-auto">
      <v-list>
        <v-list-item v-for="(item, index) in navItems" :key="index" @click="goToPage(item.to)">
          <v-list-item-title class="text-decoration-none">{{ item.label }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-app>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useDisplay } from "vuetify";

const { sm, smAndDown } = useDisplay();

const drawer = ref(false);

const navItems = [
  { label: 'Accessibility', to: '/accessibility' },
  { label: 'About us', to: '/about-us' },
  { label: 'Register your site', to: '/register' },
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
  height: 3rem;
}

.active-home{
  color:#FED636 !important;
}
.textlogo {
  font-size: 1.5rem;
}
.textlogo:hover {
  color: #FED636;
  font-weight: 600;
}

.navButtons {
  color: #340458;
  background-color: #14CAC9;
}

.v-btn:hover,
.v-btn:focus {
  background-color: #FED636 !important;
  opacity: 0.85 !important;
  border-color: #340458 !important;
  color: #340458;
  font-weight: 600 !important;
}

.v-list-item:hover {
  background-color: #FED636 !important;
}

.v-list-item:focus,
.v-list-item:active {
  background-color: #FED636 !important;
  color: white !important;
}

.v-list-item-title {
  color: #340458 !important;
}

.v-list-item-title:hover,
.v-list-item-title:active {
  font-weight: 600 !important;
  font-size: 1.1rem !important;
}

</style>