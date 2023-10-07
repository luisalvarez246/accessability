<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <h1 class="text-center pt-10">Welcome to Accessability</h1>
  <v-container
    id="section_search"
  >
    <v-card
      color="cardbackground"
      class="rounded-lg pt-5 pb-10 mx-auto"
      max-width="1140"
    >
      <v-card-title class="text-center text-wrap pb-5">
        Discover the best accessible places in Asturias
      </v-card-title>
      <v-card
        class="mx-auto rounded-lg"
        color="mainbackground"
        width="90%"
        >
        <v-card-text class="ma-4">
          <v-row>
            <v-col cols="12" lg="9">
              <v-row align="center">
                <v-col cols="auto">
                  <p class="font-weight-bold pl-0">Location</p>
                </v-col>
                <v-col cols="auto">
                  <v-icon 
                    class="mb-1"
                    size="36"
                    aria-hidden="true"
                    aria-label="Search Location"
                    >
                    mdi-map-marker
                  </v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    id="search-location"
                    bg-color="white"
                    color="navbar"
                    base-color="navbar"
                    variant="outlined"
                    clearable
                    rounded="lg"
                    :rules="[rules.required]"
                    hint="Enter your city here"
                    label="Search location"
                    persistent-hint
                    type="input"
                    role="textbox"
                    />
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto" >
                  <v-card-text class="font-weight-bold pl-0">Type of site</v-card-text>
                </v-col>
                <v-col class="pl-1" cols="auto">
                  <v-icon
                    class="mb-"
                    size="36"
                    aria-hidden="true"
                    aria-label="Search accessibility"
                    >
                    mdi-magnify
                  </v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    id="search-type-of-site" 
                    bg-color="white"
                    color="navbar"
                    base-color="navbar"
                    variant="outlined"
                    clearable
                    rounded="lg"
                    :rules="[rules.required]"
                    hint="Enter your site here"
                    label="Search type of site"
                    persistent-hint
                    type="input"
                    role="textbox"
                  />
                </v-col>
              </v-row>
            </v-col>
            <v-col
              class="d-flex align-center"
              cols="12" md="0" lg="3"
            >
              <v-btn 
                text
                class="text-none mx-auto"
                color="searchbtn"
                rounded="lg"
                size="x-large"
              >
                Search
              </v-btn>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-item class="justify-space-between">
          <v-row>
            <v-col
              v-for="(item, index) in [
                { icon: 'mdi-wheelchair', label: 'PRM (People with reduced mobility)' },
                { icon: 'mdi-eye-off-outline', label: 'Visually impaired' },
                { icon: 'mdi-ear-hearing-off', label: 'Impaired hearing' }
              ]"
              :key="index"
              cols="12"
              md="4"
              sm="6"
              xs="12"
              class="d-flex align-center"
            >
              <v-icon size="56">
                {{ item.icon }}
              </v-icon>
              <v-checkbox
                :label="item.label"
                color="cardbackground"
                aria-checked="false"
                class="d-flex align-center font-weight-medium"
              ></v-checkbox>
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
:deep(.v-label.v-field-label.v-field-label--floating){
  --v-field-label-scale: 1rem;
}
</style>
