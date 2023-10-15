<template>
	<v-container fluid max-width="1140" class="pt-0 mx-auto">
	  <v-container height="auto" width="100%" class="hero_section d-flex justify-center pb-0 mb-0" color="mainbackground"
		rounded="lg">
		<v-img lazy-src="../assets/images/aboutus.avif" src="../assets/images/aboutus.avif" alt="" cover max-width="1140"
		  max-height="450">
		  <div class="title">
			<h2 class="underline pl-4">About Us</h2>
		  </div>
		</v-img>
	  </v-container>
	  <v-container class="pt-0">
		<v-card class="team_members mx-auto mb-8" max-width="1140" color="cardbackground1">
		  <v-card-title>The team</v-card-title>
		  <v-row justify="center">
			<v-col cols="12" xs="12" sm="12" md="12" lg="8" xl="8">
			  <v-row>
				<v-col v-for="author in authors" :key="author.id" cols="6" sm="4" lg="4">
				  <v-card-item class="team_members_item text-center justify-center align-center" color="cardbackground1">
					<v-img :lazy-src="author.photo" :src="author.photo" :alt="author.name + ' ' + 'photo'" :width="120"
					  class="zoom-effect" />
					<v-card-title class="team_members_title text-wrap pt-2">{{
					  author.name
					}}</v-card-title>
				  </v-card-item>
				</v-col>
			  </v-row>
			</v-col>
		  </v-row>
		</v-card>
		<v-card class="mt-4 mx-auto" max-width="1140" color="cardbackground1">
		  <v-card-title> Contact </v-card-title>
		  <v-divider></v-divider>
		  <v-sheet class="mx-auto mb-10 px-10" width="90%" color="cardbackground2">
			<div class="mx-auto pt-3">
			  <v-form ref="form" role="form" class="pt-4" @submit.prevent="submit">
				<v-text-field v-model="name" :counter="2" :rules="nameRules" label="Full Name" id="input-9" type="text"
				  autocomplete="name" aria-required="true" required bg-color="white" color="navbar" base-color="navbar"
				  clearable></v-text-field>
				<v-text-field v-model="email" :rules="emailRules" id="input-11" label="Email" type="text"
				  autocomplete="email" aria-required="true" required bg-color="white" color="navbar" base-color="navbar"
				  clearable></v-text-field>
				<v-textarea v-model="thoughts" :rules="[rules.required]" id="send-us-your-thoughts"
				  name="send-us-your-thoughts" type="text" label="Send us your thoughts" aria-required="true" auto-grow
				  bg-color="white"></v-textarea>
			  </v-form>
			  <v-card-actions class="w-100 d-flex justify-center flex-sm-row flex-column">
				<v-btn class="reset_btn text-none mb-4 px-6 mx-auto mx-sm-10" @click="cancel" :size="xs ? '' : 'x-large'"
				  :height="xs ? 52 : ''" :class="{ 'text-h6': xs }" rounded="xl" color="#7A0016">
				  Cancel
				</v-btn>
				<v-btn class="submit_btn mb-4 text-none px-6 mx-auto mx-sm-10" @click.prevent="submit" :size="xs ? '' : 'x-large'"
				  :height="xs ? 52 : ''" :class="{ 'text-h6': xs }" rounded="xl" color="navbar">
				  Submit
				</v-btn>
			  </v-card-actions>
			</div>
		  </v-sheet>
		</v-card>
	  </v-container>
	</v-container>
  </template>
	  
  <script setup>
  import { ref } from 'vue';
  import { useDisplay } from "vuetify";
  
  const authors = ref([
	{
	  id: 1,
	  name: "Carmen",
	  photo: "/aboutus/Carmen.jpg",
	},
	{
	  id: 2,
	  name: "César",
	  photo: "/aboutus/César.jpg",
	},
	{
	  id: 3,
	  name: "Leolo",
	  photo: "/aboutus/Leolo.jpg",
	},
	{
	  id: 4,
	  name: "Luis",
	  photo: "/aboutus/Luis.png",
	},
	{
	  id: 5,
	  name: "Miguel",
	  photo: "/aboutus/Miguel.jpg",
	},
	{
	  id: 6,
	  name: "Sonia",
	  photo: "/aboutus/Sonia.jpg",
	},
  ]);
  
  const nameRules = ref([
	v => !!v || 'Name is required',
	v => (v && v.length >= 2) || 'Name needs to be at least 2 characters',
  ]);
  const rules = {
	required: value => !!value || 'Field is required',
  };
  
  const emailRules = ref([
	v => !!v || 'Email is required',
	v => !v || /^[a-z.-]+@[a-z.-]+\.[a-z]+$/i.test(v) || 'Must be a valid e-mail'
  ])
  
  const { xs } = useDisplay();
  
  const form = ref();
  
  const name = ref('');
  const email = ref('');
  const thoughts = ref('');
  
  async function submit() {
	console.log("Datos del formulario:", { name: name.value, email: email.value, thoughts: thoughts.value });
	const { valid } = await form.value.validate();
  
	if (valid) {
	  alert("Form is valid");
	  form.value.reset();
	} else {
	  alert("Form is not valid");
	}
  }
  function cancel() {
	form.value.reset()
  }
  </script>
  <style scoped>
  .title {
	position: relative;
	color: #59029f;
	text-wrap: wrap;
  }
  
  div.title {
	background-color: #fed636;
	width: 25.5rem;
	height: auto;
	bottom: 0;
	content: "";
	display: block;
	left: 0;
	position: absolute;
	padding: 0 1rem .5rem .25rem;
  }
  
  .underline {
	position: relative;
  }
  
  h2.underline::after {
	background: #14cac9;
	bottom: 0;
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
	font-size: 1.1rem;
	font-weight: 500;
  }
  
  .zoom-effect {
	transition: transform 0.3s ease-in-out;
  }
  
  .zoom-effect:hover {
	transform: scale(1.1);
  }
  
  .v-btn.reset_btn {
	background: #fed636;
  }
  
  .v-btn.submit_btn {
	background: #14cac9;
  }
  </style>
	