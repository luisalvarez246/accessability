<template>
  <v-container>
    <v-sheet class="mt-10 mx-auto" max-width="33dvw" color="#FED636" rounded="lg" elevation="8">
      <v-card-title class="text-center">
        About Us
      </v-card-title>
    </v-sheet>
    <v-container>
      <v-row justify="center">
        <v-col cols="12" xs="12" sm="11" md="9" lg="8" xl="8">
          <v-card color="#59029F" elevation="8" rounded="lg" class="py-5">
            <v-row>
              <v-col v-for="author in authors" :key="author.id" cols="6" sm="4" lg="4">
                <v-card-item class="text-center justify-center align-center" color="#59029F">
                  <v-img :src="author.photo" :alt="author.name + ' ' + 'photo'" :width="120" />
                  <v-card-title class="text-wrap pt-2">{{ author.name }}</v-card-title>
                </v-card-item>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-container>
  <v-container class="d-flex flex-column">
    <v-row justify="center">
      <v-col cols="12" xs="12" sm="11" md="9" lg="8" xl="8">
        <v-card color="#59029F" elevation="8" class="mb-10">
          <v-card-title class="ml-2">
            Contact
          </v-card-title>
          <v-divider></v-divider>
          <v-card-item>
            <v-form role="form">
              <v-row>
                <v-col cols="12" md="10" class="mx-auto">
                  <v-text-field label="Name" id="input-9" bg-color="white"
                    :role="'textbox'"></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" md="10" class="mt-2 mx-auto">
                  <v-text-field label="Email" id="input-11" bg-color="white"
                    :role="'textbox'"></v-text-field>
                </v-col>
              </v-row>
            </v-form>
            <v-row>
              <v-col cols="12" md="10" class="mt-4 mx-auto">
                <v-textarea id="send-us-your-thoughts" name="send-us-your-thoughts" type="text" label="Send us your thoughts"
                  auto-grow bg-color="white"></v-textarea>
              </v-col>
            </v-row>
          </v-card-item>
        </v-card>
      </v-col>
    </v-row>
    <v-btn class="text-none mx-auto" size="x-large" width="148" color="#FED636">
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
  font-size: 1.1rem;
  font-weight: 600;
}

:deep(.v-label.v-field-label.v-field-label--floating) {
  --v-field-label-scale: 1em;
}
</style>