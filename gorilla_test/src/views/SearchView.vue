<script setup>
import Card from "../components/Card.vue";
import ApiConnection from "../services/ApiConnection";
import { ref, onBeforeMount } from 'vue'

const stores = ref([])

const getStores = async () => {
    let response = await ApiConnection.getAllStores()
    stores.value = response.data
    return stores.value
}

onBeforeMount(() => {
    getStores()
})
</script>

<template>
    <v-container>
        <h1>Searched Bussiness</h1>
    </v-container>

  <v-container
    class="my-10 bg-deep-purple-lighten-5 rounded-lg"
  >
    <v-row>
      <v-col class="d-flex justify-center align-center mx-auto mt-10" v-for="store in stores" :key="store.id" cols="12" sm="6" md="4" lg="6">
        <Card :store-name="store.storeName"
			:type="store.type"
			:city="store.city"
			:category="store.categories"
			:address="store.address"
			:phone="store.phone"
			:email="store.email"
			:description="store.description"
			:web="store.web"
			:image="store.image" 
            :width="400"
            />
            
      </v-col>
    </v-row>
  </v-container>
</template>

<style scoped></style>
