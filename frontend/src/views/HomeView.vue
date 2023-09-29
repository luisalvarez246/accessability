<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-container
    width="90%">
    <v-card
      color="cardbackground"
      class="mx-auto rounded-lg pt-5 pb-10 mt-10"
    >
      <v-card-title class="text-center pb-5">
        Discover the best accessible places in Asturias
      </v-card-title>
      <v-card class="mx-auto rounded-lg" color="mainbackground" width="90%" >
        <v-card-text class="ma-4">
          <v-row>
            <v-col cols="9">
              <v-row align="center">
                <v-col cols="auto">
                  <span class="font-weight-bold">Location</span>
                </v-col>
                <v-col cols="auto">
                  <v-icon 
                    class="mb-2" size="44" aria-hidden="true" aria-label="Search Location">mdi-map-marker</v-icon>
                </v-col>
                <v-col cols="8">
                  <v-text-field
                  bg-color="input"
                  color='text'
                  variant="outlined"
                  dense
                  rounded="lg"
                  label="Search location"
                  role="textbox"/>
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto" >
                  <span class="font-weight-bold">Type of site</span>
                </v-col>
                <v-col class="pl-1" cols="auto">
                  <v-icon
                    class="mb-" size="44" aria-hidden="true" aria-label="Search accessibility">mdi-magnify</v-icon>
                </v-col>
                <v-col cols="8">
                  <v-text-field 
                    bg-color="input"
                    variant="outlined"
                    dense
                    rounded="lg"
                    label="Search type of site"
                    role="textbox"/>
                </v-col>
              </v-row>
            </v-col>
            <v-col class="d-flex align-center justify-center" cols="3">
              <v-btn 
                text
                class="text-none px-12"
                color="searchbtn"
                rounded="lg"
                size="x-large"
              >
                Search
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-item>
          <v-row>
            <v-col cols="4" class="d-flex justify-center pa-0">
              <v-icon 
                size="48"
                class="mt-2"
              >
                mdi-heart
              </v-icon>
            </v-col>
            <v-col cols="4" class="d-flex justify-center pa-0">
              <v-icon 
                size="48"
                class="mt-2"
              >
                mdi-heart
              </v-icon>
            </v-col>
            <v-col cols="4" class="d-flex justify-center pa-0">
              <v-icon 
                size="48"
                class="mt-2"
              >
                mdi-heart
              </v-icon>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="4" class="pt-0">
              <v-checkbox
                label="PRM (People with reduced mobility)"
                color="green"
                value="green"
                hide-details
                aria-checked="false"
                class="d-flex justify-center align-center"
              ></v-checkbox>
            </v-col>
            <v-col cols="4" class="pt-0">
              <v-checkbox
                label="Visually impaired"
                color="green"
                value="green"
                hide-details
                aria-checked="false"
                class="d-flex justify-center"
              ></v-checkbox>
            </v-col>
            <v-col cols="4" class="pt-0">
              <v-checkbox
                label="Impaired hearing"
                color="green"
                value="green"
                hide-details
                aria-checked="false"
                class="d-flex justify-center align-center"
              ></v-checkbox>
            </v-col>
          </v-row>
        </v-card-item>
      </v-card>
    </v-card>
  </v-container>
</template>

<script setup>
//
</script>

<style scoped>
</style>
