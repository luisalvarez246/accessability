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
            <v-col cols="12" xs="12" sm="6" md="6" lg="6">
              <v-card
                color="#59029F"
                elevation="8"
                rounded="lg"
              >
                <v-row>
                  <v-col v-for="author in authors" :key="author.id" cols="12" xs="12" sm="6" md="6" lg="4">
                    <v-card-item
                      class="text-center"  
                      color="#59029F"
                    >
                      <v-img :src="author.photo" :alt="author.name + ' ' + 'photo'"/>
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
            Form
          </v-card-title>
          <v-divider></v-divider>
          <v-card-item>
            <v-form
              max-width="200"
            >
              <v-text-field
                label="Name"
                placeholder="Enter your name"
                hide-details
                variant="outlined"
                class="my-6"
              >
              </v-text-field>
              <v-text-field
                label="Email"
                placeholder="Enter your email"
                hide-details
                variant="outlined"
                class="mb-6"
              >
              </v-text-field>
            </v-form>
            <v-textarea
            label="Send us your thoughts"
            variant="outlined"
          >
          </v-textarea>
          </v-card-item> 
        </v-card>
        <v-btn
          class="mx-auto text-none"
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
      photo: "https://example.com/johndoe.jpg",
    },
    {
      id: 2,
      name: "César",
      photo: "https://example.com/janedoe.jpg",
    },
    {
      id: 3,
      name: "Leolo",
      photo: "https://example.com/petersmith.jpg",
    },
    {
      id: 4,
      name: "Luis",
      photo: "https://example.com/maryjohnson.jpg",
    },
    {
      id: 5,
      name: "Miguel",
      photo: "https://example.com/davidwilliams.jpg",
    },
    {
      id: 6,
      name: "Sonia",
      photo: "https://example.com/susanbrown.jpg",
    },
  ]);
  </script>
  <style scoped>
  .v-card-title {
    font-size: 1rem !important;
    font-weight: 500 !important;
  }
  </style>