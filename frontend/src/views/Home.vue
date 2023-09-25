<!-- eslint-disable vue/multi-word-component-names -->
<!--<template>
<v-card
    color="#59029F"
    width="90%"
    class="mx-auto mt-10 rounded-lg py-10"
  >
    <v-card-title
      class="text-center">
      Discover the best accessible places
    </v-card-title>
    <v-card
      color="background"
      width="95%"
      class="mx-auto rounded-lg pa-10"
    >
      <v-card-text>
        <v-row>
          <v-col cols="70">
            <v-row>
              <v-col cols="12">
                <v-text-field label="Location" bg-color="#FED63673" color="text" variant="outlined"/>
              </v-col>
              <v-col cols="12">
                <v-icon size="xx-large">mdi-map-marker</v-icon>
              </v-col>
              <v-col cols="12">
                <v-text-field label="Type of site" bg-color="#FED63673" color="text" variant="outlined"/>
              </v-col>
              <v-col cols="12">
                <v-icon size="xx-large">mdi-magnify</v-icon>
              </v-col>
            </v-row>
          </v-col>
          <v-col cols="30">
            <v-btn 
            text class="text-none px-12"
            color="#FED636"
            size="x-large"
            >
            Search
          </v-btn>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </v-card>
</template>

<script setup>
</script>

<style>
</style>-->

<template>
  <v-card
    color="#59029F"
    width="90%"
    class="mx-auto mt-10 rounded-lg py-10"
  >
    <v-card-title class="text-center">
      Discover the best accessible places
    </v-card-title>
    <v-card color="background" width="95%" class="mx-auto rounded-lg pa-10">
      <v-card-text>
        <v-row>
          <!-- Parte Izquierda -->
          <v-col cols="6"> <!-- Dividir en dos columnas -->
            <!-- Fila Superior -->
            <v-row align="center">
              <v-col cols="auto">
                <span class="font-weight-bold">Location</span>
              </v-col>
              <v-col cols="auto">
                <v-icon size="xx-large">mdi-map-marker</v-icon>
              </v-col>
              <v-col cols="auto">
                <v-text-field bg-color="#FED63673" color="text" variant="outlined" dense/>
              </v-col>
            </v-row>
            <!-- Fila Inferior -->
            <v-row align="center">
              <v-col cols="auto">
                <span class="font-weight-bold">Type of site</span>
              </v-col>
              <v-col cols="auto">
                <v-icon size="xx-large">mdi-magnify</v-icon>
              </v-col>
              <v-col cols="auto">
                <v-text-field bg-color="#FED63673" color="text" variant="outlined" dense/>
              </v-col>
            </v-row>
          </v-col>
          
          <!-- Parte Derecha (Botón de Search centrado verticalmente) -->
          <v-col cols="6" align="center">
            <v-btn 
              text
              class="text-none px-12 mt-10"
              color="#FED636"
              size="x-large"
            >
              Search
            </v-btn>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </v-card>
</template>

<script setup>
</script>

<style>
</style>
