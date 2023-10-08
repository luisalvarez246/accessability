<template>
  <v-sheet height="250" width="100%" class="d-flex justify-center mt-3 mb-2" color="mainbackground" rounded="lg">
    <v-img src="../assets/images/hero.jpg" alt="girl whitout hands holding a cellphone" cover
      max-width="1140" max-height="250">
      <div class="title">
        <h1 class="underline pl-4">Welcome to Accessability</h1>
      </div>
    </v-img>
  </v-sheet>
  <v-container id="section_search" class="pt-0">
    <v-card color="cardbackground1" elevation="2" rounded="lg" class="pt-4 pb-10 mx-auto" max-width="1140">
      <v-card-title class="text-center text-wrap pb-4">
        Discover the best accessible places in Asturias
      </v-card-title>
      <v-card class="mx-auto rounded-lg" color="cardbackground2" width="90%">
        <v-card-text class="ma-4">
          <v-row>
            <v-col cols="12" lg="9">
              <v-row align="center">
                <v-col cols="auto">
                  <p class="font-weight-medium pl-0">Location</p>
                </v-col>
                <v-col cols="auto">
                  <v-icon class="mb-1" size="36" aria-hidden="true" aria-label="Search Location">
                    mdi-map-marker
                  </v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field id="search-location" bg-color="white" color="navbar" base-color="navbar"
                    variant="outlined" clearable rounded="lg" :rules="[rules.required]" hint="Enter your city here"
                    label="Search location" persistent-hint type="input" role="textbox" />
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto">
                  <v-card-text class="font-weight-medium pl-0">Type of site</v-card-text>
                </v-col>
                <v-col class="pl-1" cols="auto">
                  <v-icon class="mb-" size="36" aria-hidden="true" aria-label="Search accessibility">
                    mdi-magnify
                  </v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field id="search-type-of-site" bg-color="white" color="navbar" base-color="navbar"
                    variant="outlined" clearable rounded="lg" :rules="[rules.required]" hint="Enter your site here"
                    label="Search type of site" persistent-hint type="input" role="textbox" />
                </v-col>
              </v-row>
            </v-col>
            <v-col class="d-flex align-center" cols="12" md="0" lg="3">
              <v-btn text class="text-none mx-auto" color="searchbtn" rounded="lg" size="x-large">
                Search
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-item class="justify-space-between">
          <v-row>
            <v-col v-for="(item, index) in [
              { icon: 'mdi-wheelchair', label: 'PRM (People with reduced mobility)' },
              { icon: 'mdi-eye-off-outline', label: 'Visually impaired' },
              { icon: 'mdi-ear-hearing-off', label: 'Impaired hearing' }
            ]" :key="index" cols="12" md="4" sm="6" xs="12" class="d-flex align-center">
              <v-icon size="56">
                {{ item.icon }}
              </v-icon>
              <v-checkbox :label="item.label" color="cardbackground" aria-checked="false"
                class="d-flex align-center font-weight-medium"></v-checkbox>
            </v-col>
          </v-row>
        </v-card-item>
      </v-card>
    </v-card>
  </v-container>
</template>

<script setup>
const rules = {
  required: value => !!value || 'Field is required',
}
</script>

<style scoped>
.title {
  position: relative;
  color: #59029F;
}
div.title {
  background-color: #fed636;
  width: 25rem;
  height: 4.2rem;
  bottom: 0;
  content: "";
  display: block;
  left: 0;
  position: absolute;
}
.underline {
  position: relative;
}

h1.underline::after {
  background: #14CAC9;
  bottom: 0;
  content: "";
  display: block;
  height: .25rem;
  left: 5;
  position: absolute;
  width: 5rem;
}

:deep(.v-label.v-field-label.v-field-label--floating) {
  --v-field-label-scale: 1rem;
}
</style>
