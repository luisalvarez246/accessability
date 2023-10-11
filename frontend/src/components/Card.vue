<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <v-card
    color="#59029F"
    class="mb-7"
    min-width="300"
    max-width="400"
  >
    <v-img
      src="https://hips.hearstapps.com/hmg-prod/images/los-mejores-restaurantes-que-tienes-que-probar-en-madrid-1644914076.jpeg?crop=0.753xw:1.00xh;0.125xw,0&resize=1200:*"
    ></v-img>
    <v-card-title>
      <!-- <h2>Casa Pepe</h2> -->
     {{ props.type }} {{ props.storeName }}
    </v-card-title>
    <v-card-text>
      <p>
        {{ props.city }} 
      </p>

      <p>Category: {{ props.category }}</p>
    </v-card-text>

    <v-card-actions>
      <v-btn
        @click="toggleShow(cardIndex)"
        class="text-none text-subtitle-1 mx-auto"
        variant="flat"
        color="#7ED057"
        block
      >
        {{ show[cardIndex] ? "HIDE INFO" : "MORE INFO" }}
      </v-btn>
    </v-card-actions>
    <v-expand-transition>
      <div v-if="show[cardIndex]">
        <v-divider></v-divider>

        <v-card-text>
          <p>
            Address: {{ props.address }}
          </p>
          <p>
            Phone: {{ props.phone }}
          </p>
          <p>
            Email: {{ props.email }}
          </p>
          <p>
            Web: {{ props.web }}
          </p>
           
          <p class="descriptionField">
            {{ props.description }}
          </p>
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</template>

<script setup>
import ApiConnection from "@/services/ApiConnection";
import { ref, onBeforeMount } from "vue";

const props = defineProps({
  storeName: String,
  type: String,
  city: String,
  category: String,
  address: String,
  phone: String,
  email: String,
  description: String,
  web: String
})


const show = ref(Array(3).fill(false));
const stores = ref([]);
const cardIndex = ref()


function toggleShow(cardIndex) {
  show.value[cardIndex] = !show.value[cardIndex];
}

const getStores = async () => {
  let response = await ApiConnection.getAllStores();
  stores.value = response.data;
  return stores.value;
};

onBeforeMount(() => {
  getStores();
});
</script>

<style>
.v-carousel {
  display: flex;
  justify-content: center;
  align-items: center;
}

.v-carousel .v-carousel-control__item.v-carousel-indicator__item--active {
  box-shadow: none !important;
}

.descriptionField {
  margin-top: 0.625rem;
}
</style>

<!-- <template>
    
    <v-container grid-list-md>
    <v-sheet class="mx-auto" elevation="10" max-width="1580">
      <v-slide-group
        v-model="model"
        class="pa-10"
        center-active
        show-arrows
        :visible-count="3"
        :cycle="true" 
        :min-per-page="3"
      >
        <v-slide-group-item class="slide-group" v-for="n in 15" :key="n" v-slot="{ isSelected }">
          <v-card color="#59029F" class="mr-4 mb-7" min-width="400" max-width="450">
            <v-img
              src="https://hips.hearstapps.com/hmg-prod/images/los-mejores-restaurantes-que-tienes-que-probar-en-madrid-1644914076.jpeg?crop=0.753xw:1.00xh;0.125xw,0&resize=1200:*"
            ></v-img>
            <v-card-title>
              <h2>Restaurante Casa Pepe</h2>
            </v-card-title>
            <v-card-text>
              <p>
                La mejor casa de comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de
                todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de
                comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de todo Gijón
              </p>
            </v-card-text>
            <v-card-actions>
              <v-btn class="text-none text-subtitle-1 mx-auto" variant="flat" color="#7ED057" block>MORE INFO</v-btn>
            </v-card-actions>
          </v-card>
        </v-slide-group-item>
      </v-slide-group>
    </v-sheet>
  </v-container>
  --/> 
</template>


<style scoped>
@media (min-width: 1280px) {
  .custom-lg-container-width {
    max-width: 1280px;
    margin: 0 auto;
  }
}

</style> -->
