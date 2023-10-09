<template>
  <v-container height="250" width="100%" class="hero_section d-flex justify-center pb-0" color="mainbackground"
    rounded="lg">
    <v-img src="../assets/images/hero.jpg" alt="girl whitout hands holding a cellphone" cover max-width="1140"
      max-height="250">
      <div class="title">
        <h1 class="underline pl-4">Welcome to Accessability</h1>
      </div>
    </v-img>
  </v-container>
  <v-container class="section_search pt-0" id="section_search" role="combobox" aria-labelledby="section_search">
    <v-card color="cardbackground1" class="pt-4 pb-10 mx-auto" elevation="2" max-width="1140">
      <v-card-title class="text-center text-wrap pb-4">
        Discover accessible places in Asturias to go
      </v-card-title>
      <v-card class="mx-auto" color="cardbackground2" width="90%">
        <v-card-text>
          <v-row>
            <v-col cols="12" lg="9">
              <v-row align="center">
                <v-col cols="auto">
                  <p class="font-weight-bold text-subtitle-1 text-cardbackground1 pl-0 pr-6">Near to...</p>
                </v-col>
                <v-col cols="auto">
                  <v-icon color="cardbackground1" size="36" aria-hidden="true" aria-label="Search Place or Town">
                    mdi-map-marker
                  </v-icon>
                </v-col>
                <v-col cols="12" class="pt-0">
                  <v-text-field id="search-location" bg-color="white" color="cardbackground1" base-color="navbar"
                    variant="outlined" clearable :rules="[rules.required]"
                    label="Search place or town" type="input" role="textbox" class="custom_messages" />
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto">
                  <v-card-text class="font-weight-bold text-subtitle-1 text-cardbackground1 px-0">I'm looking
                    for...</v-card-text>
                </v-col>
                <v-col cols="auto" class="pl-0">
                  <v-icon size="36" color="cardbackground1" aria-hidden="true" aria-label="Search accessibility">
                    mdi-magnify
                  </v-icon>
                </v-col>
                <v-col cols="12" class="pt-0">
                  <v-text-field id="search-type-of-site" bg-color="white" color="cardbackground1" base-color="navbar"
                    variant="outlined" clearable :rules="[rules.required]"
                    label="Search for coffe-shops, restaurants, hotels..." type="input" role="textbox" />
                </v-col>
              </v-row>
            </v-col>
            <v-col class="d-flex align-center pb-0" cols="12" md="0" lg="3">
              <v-btn text class="text-none mx-auto" color="searchbtn" rounded="xl" flat :block="xs"
                :size="xs ? '' : 'x-large'" :height="xs ? 52 : ''" :class="{ 'text-h6': xs }">
                Search
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-item class="justify-space-between">
          <v-row>
            <v-col v-for="(item, index) in [
              {
                icon: 'mdi-wheelchair',
                label: 'PRM (People with reduced mobility)',
              },
              { icon: 'mdi-eye-off-outline', label: 'Visually impaired' },
              { icon: 'mdi-ear-hearing-off', label: 'Impaired hearing' },
            ]" :key="index" cols="12" md="4" sm="6" xs="12" class="d-flex align-center">
              <v-icon size="48" color="cardbackground1">
                {{ item.icon }}
              </v-icon>
              <v-checkbox :label="item.label" color="cardbackground1" aria-checked="false"
                class="d-flex align-center font-weight-bold text-cardbackground1"></v-checkbox>
            </v-col>
          </v-row>
        </v-card-item>
      </v-card>
    </v-card>
  </v-container>
</template>

<script setup>
import { useDisplay } from "vuetify";

const { xs } = useDisplay();

const rules = {
  required: (value) => !!value || "Field is required",
};
</script>

<style scoped>
.title {
  position: relative;
  color: #59029f;
  text-wrap: wrap;
}
div.title {
  background-color: #fed636;
  width: auto;
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
h1.underline::after {
  background: #14cac9;
  bottom: 0;
  content: "";
  display: block;
  height: 0.25rem;
  left: 5;
  position: absolute;
  width: 5rem;
}
.v-text-field .v-input__details {
  font-size: 1rem !important;
  font-weight: 600 !important;
}
.v-input__details {
  font-weight: 600;
}
.v-label {
  --v-high-emphasis-opacity:1 !important;
}
:deep(.v-label.v-field-label.v-field-label--floating) {
  --v-field-label-scale: 1rem;
}
</style>
