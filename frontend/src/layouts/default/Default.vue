<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-app>
    <default-bar />

    <default-view />
  
    <v-footer app color="#340458">
      <FooterBar />
    </v-footer>
  </v-app>
</template>

<script setup>
  import DefaultBar from './AppBar.vue'
  import DefaultView from './View.vue'
  import FooterBar from './FooterBar.vue'
</script>








