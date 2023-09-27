<script setup>
import { ref } from 'vue';

const links = ref([
  'Terms of Use',
  'Privacy Policy',
  'Cookies',
]);

const icons = ref([
  "mdi-facebook",
  "mdi-linkedin",
  "mdi-instagram",
]);
</script>

<template>
  <v-footer class="custom-footer">
    <v-row justify="center" no-gutters>
      <v-btn
        v-for="link in links"
        :key="link"
        color="white"
        variant="text"
        class="mx-3"
        rounded="xl"
      >
      <template v-slot:default>
        <span class="link-content"> {{ link }}</span>
      </template>
      </v-btn>
    </v-row>

    <v-row justify="center" no-gutters>
      <v-btn
        v-for="icon in icons"
        :key="icon"
        class="mx-2 social-icon"
        :icon="icon"
        variant="plain"
        size="50"
        color="#FED636" 
      ></v-btn>
    </v-row>
    
    <v-row justify="center" no-gutters>
      <v-col class="text-center mt-4" cols="12">
        <span class="yellow-text"> © Copyright {{ new Date().getFullYear() }} - Accessability</span>
      </v-col>
    </v-row>
  </v-footer>
</template>

<style scoped>
.custom-footer {
  background-color: #340458;
}

.custom-footer .v-btn {
  text-transform: capitalize; 
}

.yellow-text {
  color: #FED636;
  font-weight: normal;
  font-size:16px;
}

.link-content {
  font-size: 16px;
}
.link-content:hover {
  color: #14CAC9;
}

.social-icon {
  color: #FED636;
  opacity: 1;
}

/* .social-icon:hover {
  color: #14CAC9;
  opacity: 1; 
} */
</style>