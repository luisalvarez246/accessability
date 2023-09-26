<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-container
    width="90%">
    <v-card
      color="#59029F"
      class="mx-auto rounded-lg py-10 mt-10"
      min-width="auto"
    >
      <v-card-title class="text-center">
        Discover the best accessible places
      </v-card-title>
      <v-card class="mx-auto rounded-lg pa-10" color="background" width="90%" >
        <v-card-text>
          <v-row>
            <v-col cols="9">
              <v-row align="center">
                <v-col cols="auto">
                  <span class="font-weight-bold">Location</span>
                </v-col>
                <v-col cols="auto">
                  <v-icon size="xx-large" aria-hidden="true" aria-label="Search Location">mdi-map-marker</v-icon>
                </v-col>
                <v-col cols="8">
                  <v-text-field bg-color="#FED63673" color="text" variant="outlined" dense rounded="lg" label="Search location" role="textbox"/>
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto" >
                  <span class="font-weight-bold">Type of site</span>
                </v-col>
                <v-col class="pl-1" cols="auto">
                  <v-icon
                  size="xx-large" aria-hidden="true" aria-label="Search accessibility">mdi-magnify</v-icon>
                </v-col>
                <v-col cols="8">
                  <v-text-field bg-color="#FED63673" variant="outlined" dense rounded="lg" label="Search type of site" role="textbox"/>
                </v-col>
              </v-row>
            </v-col>
            <v-col class="d-flex align-center justify-center" cols="3">
              <v-btn 
                text
                class="text-none px-12 mt-0"
                color="#FED636"
                rounded="lg"
                size="x-large"
              >
                Search
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-text>
          <v-row class="mx-auto">
            <div class="d-flex pa-4">
              <v-icon 
              size="xx-large"
              class="mt-2"
              >
              mdi-heart
              </v-icon>
              <v-checkbox
                label="PRM (People with reduced mobility"
                color="green"
                value="green"
                hide-details
                class="pe-2"
                aria-checked="false"
              ></v-checkbox>
            </div>
            <div class="d-flex pa-4">
              <v-icon 
              size="xx-large"
              class="mt-2"
              >
              mdi-heart
              </v-icon>
              <v-checkbox
                label="Visually impaired"
                color="green"
                value="green"
                hide-details
                class="pe-2"
                aria-checked="false"
              ></v-checkbox>
            </div>
            <div class="d-flex pa-4">
              <v-icon 
              size="xx-large"
              class="mt-2"
              >
              mdi-heart
              </v-icon>
              <v-checkbox
                label="Impaired hearing"
                color="green"
                value="green"
                hide-details
                class="pe-2"
                aria-checked="false"
              ></v-checkbox>
            </div>
          </v-row>
        </v-card-text>
      </v-card>
    </v-card>
  </v-container>
</template>

<script setup>
</script>

<style>
</style>
