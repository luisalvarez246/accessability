<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <h1 class="text-center mt-10">Welcome to Accessability</h1>
  <v-container>
    <v-card
      color="cardbackground"
      class="rounded-lg pt-5 pb-10 mx-auto"
      max-width="1144"
    >
      <v-card-title class="text-center text-wrap pb-5">
        Discover the best accessible places in Asturias
      </v-card-title>
      <v-card class="mx-auto rounded-lg" color="mainbackground" width="90%" >
        <v-card-text class="ma-4">
          <v-row>
            <v-col cols="12" lg="9">
              <v-row align="center">
                <v-col cols="auto">
                  <p class="font-weight-bold pl-0">Location</p>
                </v-col>
                <v-col cols="auto">
                  <v-icon 
                    class="mb-1" size="36" aria-hidden="true" aria-label="Search Location">mdi-map-marker</v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    id="search-location"
                    bg-color="white"
                    color="#4A148C"
                    base-color="#4A148C"
                    variant="outlined"
                    dense
                    rounded="lg"
                    label="Search location"
                    placeholder="Avilés, Gijón, Oviedo..."
                    role="textbox"
                    input-props="{ tabindex: 0 }"
                    />
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="pr-0" cols="auto" >
                  <v-card-text class="font-weight-bold pl-0">Type of site</v-card-text>
                </v-col>
                <v-col class="pl-1" cols="auto">
                  <v-icon
                    class="mb-" size="36" aria-hidden="true" aria-label="Search accessibility">mdi-magnify</v-icon>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    id="search-type-of-site" 
                    bg-color="white"
                    color="#4A148C"
                    base-color="#4A148C"
                    variant="outlined"
                    dense
                    rounded="lg"
                    label="Search type of site"
                    placeholder="Hotel, Restaurant, Bar..."
                    role="textbox"
                    input-props="{ tabindex: 0 }"
                  />
                </v-col>
              </v-row>
            </v-col>
            <v-col
              class="d-flex align-center" md="0" lg="3"
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
                color="#4A148C"
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
</script>

<style scoped>
:deep(.v-label.v-field-label.v-field-label--floating){
  --v-field-label-scale: 1rem;
}
</style>
