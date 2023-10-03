<template>
    <v-container>
        <v-card class="my-10 mx-auto" max-width="688" color="#FED636" rounded="lg" elevation="8">
            <v-card-title class="text-center">
              About Us
            </v-card-title>
            <v-card-text>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac est eget quam scelerisque scelerisque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
            </v-card-text>
        </v-card>
        <v-container>   
          <v-row justify="center">
            <v-col cols="12" xs="12" sm="12" md="12" lg="9" xl="9">
              <v-card
                color="#59029F"
                elevation="8"
                rounded="lg"
                class="py-5"
              >
                <v-row>
                  <v-col v-for="author in authors" :key="author.id" cols="6" xs="4" sm="4" md="4" lg="4" xl="4">
                    <v-card-item
                      class="text-center justify-center align-center"
                      color="#59029F"
                    >
                      <v-img :src="author.photo" :alt="author.name + ' ' + 'photo'" :width="100"/>
                      <v-card-title class="text-wrap">{{ author.name }}</v-card-title>
                    </v-card-item>
                  </v-col>
                </v-row>
              </v-card>
            </v-col>
          </v-row>
        </v-container>  
    </v-container>
    <v-container class="d-flex flex-column">
        <v-card
            color="#59029F"
            elevation="8"
            class="mb-10"
        >
          <v-card-title
          >
            Contact
          </v-card-title>
          <v-divider></v-divider>
          <v-card-item>
            <v-form
              max-width="200"
            >
              <v-text-field
                label="Name"
                hide-details
                class="my-6"
              >
              </v-text-field>
              <v-text-field
                label="Email"
                hide-details
              >
              </v-text-field>
            </v-form>
              <v-card-item>
                <v-textarea
                label="Send us your thoughts"
                variant="outlined"
                bg-color="#EDE7F6"
                class="mt-10"
                >
                </v-textarea>
            </v-card-item>
          </v-card-item> 
        </v-card>
        <v-btn
          class="mx-auto text-none"
          size="x-large"
          color="#FED636"
        >
          Submit
        </v-btn>
    </v-container>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  
  const authors = ref([
    {
      id: 1,
      name: "Carmen",
      photo: "/aboutus/images/Carmen.jpg",
    },
    {
      id: 2,
      name: "César",
      photo: "/aboutus/images/César.jpg",
    },
    {
      id: 3,
      name: "Leolo",
      photo: "/aboutus/images/Leolo.jpg",
    },
    {
      id: 4,
      name: "Luis",
      photo: "/aboutus/images/Luis.jpg",
    },
    {
      id: 5,
      name: "Miguel",
      photo: "/aboutus/images/Miguel.jpg",
    },
    {
      id: 6,
      name: "Sonia",
      photo: "/aboutus/images/Sonia.jpg",
    },
  ]);
  </script>
  <style scoped>
  .v-card-title {
    font-size: 1rem !important;
    font-weight: 500 !important;
  }
  :deep(.v-label.v-field-label.v-field-label--floating){
    --v-field-label-scale: 1em;
  }
  </style>