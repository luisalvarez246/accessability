<template>
  <v-app-bar app color="#340458">
    <v-container class="container d-flex align-center mr-8" aria-label="Volver a la página de inicio" tabindex="0">
      <v-img src="../../assets/images/Logo.png" height="48" alt="Logotipo de Accessability."></v-img>
        <span>Accessability</span>
      </v-container>
        
    <v-spacer></v-spacer>
    <v-btn class="accessability_btn text-none text-subtitle-1 mr-4" to="/accessability" color="14CAC9" key="1" aria-label="Accessability" tabindex="0">
      Accessibility
    </v-btn>
    <v-btn class="aboutus_btn text-none text-subtitle-1 mr-4" to="/about-us" key="1" aria-label="About us" tabindex="0">
      About us
    </v-btn>
    <v-btn class="register_btn text-none text-subtitle-1 mr-4" to="/register-new-site" key="1" aria-label="Register a new site" tabindex="0">
      Register a new site
    </v-btn>
  </v-app-bar>
</template>

<script setup>
  //
</script>

<style scoped>
.container {
  max-width: 240px;
  margin: 0;
}
.accessability_btn {
  background-color: #14CAC9;
  color: #340458;
}

.aboutus_btn {
  background-color: #14CAC9;
  color: #340458;
}

.register_btn {
  background-color: #14CAC9;
  color: #340458;
}
</style>
