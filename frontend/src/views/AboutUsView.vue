<template>
    <v-container fluid>
      <v-responsive>
        <v-card class="my-10 mx-auto" max-width="688" color="#FED636" elevation="8">
            <v-card-title class="text-center">
              About Us
            </v-card-title>
            <v-card-text>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ac est eget quam scelerisque scelerisque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.
            </v-card-text>
        </v-card>
      </v-responsive>    
      <v-responsive>
        <v-container>
          <v-row>
            <v-col cols="12">
              <v-card
                color="#59029F"
                elevation="8"
                class="d-flex flex-column"
              >
                <v-row>
                  <v-col v-for="author in authors" :key="author.id" cols="4" class="d-flex justify-center align-center">
                    <v-card
                      color="#59029F"
                    >
                      <v-img :src="author.photo" />
                      <v-card-title>{{ author.name }}</v-card-title>
                    </v-card>
                  </v-col>
                </v-row>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-responsive>
    </v-container>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  
  const authors = ref([
    {
      id: 1,
      name: "John Doe",
      photo: "https://example.com/johndoe.jpg",
    },
    {
      id: 2,
      name: "Jane Doe",
      photo: "https://example.com/janedoe.jpg",
    },
    {
      id: 3,
      name: "Peter Smith",
      photo: "https://example.com/petersmith.jpg",
    },
    {
      id: 4,
      name: "Mary Johnson",
      photo: "https://example.com/maryjohnson.jpg",
    },
    {
      id: 5,
      name: "David Williams",
      photo: "https://example.com/davidwilliams.jpg",
    },
    {
      id: 6,
      name: "Susan Brown",
      photo: "https://example.com/susanbrown.jpg",
    },
  ]);
  </script>
  