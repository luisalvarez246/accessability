<template>
  <v-container fluid max-width="1140" class="pt-0 mx-auto">
    <v-container height="250" width="100%" class="hero_section d-flex justify-center pb-0 mb-0" color="mainbackground"
      rounded="lg">
      <v-img src="../assets/images/hero.jpg" alt="" cover max-width="1140" max-height="250">
        <div class="title">
          <h2 class="underline pl-4">About Us</h2>
        </div>
      </v-img>
    </v-container>
    <v-container fluid class="pt-0">
      <v-card class="team_members mx-auto" max-width="1140" color="cardbackground1">
        <v-card-title>The team</v-card-title>
        <v-row justify="center">
          <v-col cols="12" xs="12" sm="12" md="12" lg="8" xl="8">
            <v-row>
              <v-col v-for="author in authors" :key="author.id" cols="6" sm="4" lg="4">
                <v-card-item class="text-center justify-center align-center" color="cardbackground1">
                  <v-img :src="author.photo" :alt="author.name + ' ' + 'photo'" :width="120" />
                  <v-card-title class="team_members text-wrap pt-2">{{ author.name }}</v-card-title>
                </v-card-item>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-card>
      <v-card class="mt-4 mx-auto" max-width="1140" color="cardbackground1">
        <v-card-title class="w-75 mx-auto">
          Contact
        </v-card-title>
        <v-divider></v-divider>
        <v-card-item class="w-75 mx-auto">
          <v-form role="form" class="pt-4">
            <v-text-field label="Fullname" id="input-9" bg-color="white" color="navbar" base-color="navbar" clearable
              :rules="[rules.required]" type="input" :role="'textbox'"></v-text-field>
            <v-text-field label="Email" id="input-11" bg-color="white" color="navbar" base-color="navbar" clearable
              :rules="[rules.required]" type="input" :role="'textbox'"></v-text-field>
          </v-form>
          <v-textarea id="send-us-your-thoughts" name="send-us-your-thoughts" type="text" label="Send us your thoughts"
            auto-grow bg-color="white"></v-textarea>
        </v-card-item>
        <v-card-actions class="w-100 px-4 mx-auto d-flex justify-center" align="center">
          <v-btn @click="submitForm" class="submit_btn text-none mb-4" rounded="xl" :block="xs" :size="xs ? '' : 'x-large'"
            :height="xs ? 52 : ''" :class="{ 'text-h6': xs }" color="navbar">
            Submit
          </v-btn>
          <v-snackbar v-model="snackbar" color="success">
            Form send succesfully
          </v-snackbar>
        </v-card-actions>
      </v-card>
    </v-container>
  </v-container>
</template>
  
<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useDisplay } from "vuetify";

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
};

const { xs } = useDisplay();

const formData = ref({
  fullname: '',
  email: '',
  thoughts: ''
});

const snackbar = ref(false);
const snackbarMessage = ref('');
const snackbarColor = ref('');

const submitForm = () => {
  axios.post('/api/submit-form', formData.value)
    .then(response => {
      console.log(response.data);
      showSnackbar('Form submitted successfully', 'success');
    })
    .catch(error => {
      console.error(error);
      showSnackbar('Error processing the form', 'error');
    });
};

const showSnackbar = (message, color) => {
  snackbarMessage.value = message;
  snackbarColor.value = color;
  snackbar.value = true;
};
</script>
<style scoped>
.title {
  position: relative;
  color: #59029f;
}

div.title {
  background-color: #fed636;
  width: 25.5rem;
  height: 3.5rem;
  bottom: 0;
  content: "";
  display: block;
  left: 0;
  position: absolute;
  padding-top: .25rem;
}

.underline {
  position: relative;
}

h2.underline::after {
  background: #14cac9;
  bottom: 4;
  content: "";
  display: block;
  height: 0.25rem;
  left: 5;
  position: absolute;
  width: 5rem;
}

.v-card-title {
  font-size: 1.3rem;
  font-weight: 700;
}

.v-card-title.team_members {
  font-size: 1.2rem;
  font-weight: 500;
}

.v-btn.submit_btn {
  background: #fed636;
}
</style>
