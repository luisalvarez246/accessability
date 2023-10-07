<template>
    <v-container>
      <v-container>
        <v-sheet class="mt-2 mx-auto" max-width="33dvw" color="searchbtn" rounded="lg" elevation="8">
          <h1 class="text-center">
            About Us
          </h1>
        </v-sheet>
        <v-container>
          <v-row justify="center">
            <v-col cols="12" xs="12" sm="12" md="12" lg="8">
              <v-card color="cardbackground1" max-width="1140" elevation="8" rounded="lg" class="py-5">
                <v-row>
                  <v-col v-for="author in authors" :key="author.id" cols="6" sm="4" lg="4">
                    <v-card-item class="text-center justify-center align-center" color="cardbackground1">
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
      <v-container>
        <v-row justify="center" class="mx-auto">
          <v-col cols="12" xs="12" sm="12" md="12" lg="8">
            <v-card color="cardbackground1" max-width="1140" elevation="2">
              <v-card-title class="pl-16">
                Contact
              </v-card-title>
              <v-divider></v-divider>
              <v-card-item>
                <v-form role="form">
                  <v-row>
                    <v-col cols="11" class="mx-auto">
                      <v-text-field label="Name" id="input-9" bg-color="white" color="navbar" base-color="navbar"
                        clearable :rules="[rules.required]" hint="Enter your name & surname here" persistent-hint
                        type="input" :role="'textbox'"></v-text-field>
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col cols="11" class="mt-2 mx-auto">
                      <v-text-field label="Email" id="input-11" bg-color="white" color="navbar" base-color="navbar"
                        clearable :rules="[rules.required]" hint="Enter your email here" persistent-hint type="input"
                        :role="'textbox'"></v-text-field>
                    </v-col>
                  </v-row>
                </v-form>
                <v-row>
                  <v-col cols="11" class="mt-4 mx-auto">
                    <v-textarea id="send-us-your-thoughts" name="send-us-your-thoughts" type="text"
                      label="Send us your thoughts" auto-grow bg-color="white"></v-textarea>
                  </v-col>
                </v-row>
              </v-card-item>
              <v-card-item class="d-flex justify-center pb-4">
              <v-btn class="text-none" size="x-large" color="searchbtn">
                Submit
              </v-btn>
            </v-card-item>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
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
    photo: "/aboutus/images/Luis.png",
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
const rules = {
  required: value => !!value || 'Field is required',
}
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
