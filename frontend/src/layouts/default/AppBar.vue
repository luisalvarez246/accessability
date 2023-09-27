<template>
  <v-app-bar app color="purple-darken-4">
    <div class="d-flex align-center ml-6">
      <v-img src="../../assets/images/Logo.png" class="mr-2" width="56" alt="Logotipo de Accessability."></v-img>
      <p>Accessability</p>
    </div>
       
    <v-spacer></v-spacer>
      <v-btn class="text-none text-subtitle-1 mr-4" to="/accessability" variant="flat" color="cyan-lighten-1" key="1" aria-label="Accessability" tabindex="0">
      Accessibility
      </v-btn>
      <v-btn class="text-none text-subtitle-1 mr-4" to="/about-us" variant="flat" color="cyan-lighten-1" key="1" aria-label="About us" tabindex="0">
        About us
      </v-btn>
      <v-btn class="text-none text-subtitle-1 mr-8" to="/register-new-site" variant="flat" color="cyan-lighten-1" key="1" aria-label="Register a new site" tabindex="0">
        Register a new site
    </v-btn>
  </v-app-bar>
</template>

<script setup>
  //
</script>

<style scoped>
.container {
  max-width: 180px;
  margin: 0;
}
</style>
