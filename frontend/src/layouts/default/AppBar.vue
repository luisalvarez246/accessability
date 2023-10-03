<template>
  <v-app-bar app class="d-flex no-wrap" color="navbar" >
    <router-link to="/" class="d-flex align-center mx-6 text-white text-decoration-none logo">
      <v-img src="../../assets/images/Logo.png" class="mr-2" width="56" alt="Logotipo de Accessability."></v-img>
      <p class="textlogo">Accessability</p>
    </router-link>
       
    <v-spacer></v-spacer>
    
    <v-btn-group density="compact">
      <v-btn class="text-none text-subtitle-1 mr-4" to="/accessability" variant="flat" rounded="lg" color="navbarbtns" key="1"  temaria-label="Accessability" tabindex="0">
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
.container {
  max-width: 180px;
  margin: 0;
}

.v-btn{
  color:#340458!important;
}

.v-btn:hover,:focus{
  background-color:#FED636 !important;
  border-color: #340458 !important;
  opacity: 1 !important;
}

.logo:focus, :hover{
 background-color: #4A148C !important;
 border-color:#FED636 !important;
}

.textlogo:hover {
 color:#FED636;
 font-size:1.1rem;
}

</style>
