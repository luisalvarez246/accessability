<script setup>
import Card from "../components/Card.vue";
import ApiConnection from "../services/ApiConnection";
import { ref, onBeforeMount } from 'vue'
import { useRoute } from "vue-router";
import { useSearchStore } from "../store/searchStore";

const stores = ref([])
const route = useRoute();
const searchStore = useSearchStore();
const city = route.params.city;
const type = route.params.type;
const categories = route.params.categories;

const hasBeenSearched = (newSearch) =>
{
	let searchHistory;

	searchHistory = searchStore.getSearchHistory;
	for (const search of searchHistory)
	{
		if (search.localeCompare(newSearch) === 0)
			return (true);
	}
	return (false);
}

const queryStores = async () =>
{
	let response;
	let	newSearch;
	let searchIndex;
	
	newSearch = city.concat(",", type, ",", categories);
	if (searchStore.getSearchHistory.length !== 0 && hasBeenSearched(newSearch))
	{
		console.log('enters cache');
		searchIndex = searchStore.getSearchHistory.indexOf(newSearch);
		console.log(searchStore.getSearchResults[searchIndex]);
		stores.value = searchStore.getSearchResults[searchIndex];
	}
	else
	{
		console.log('enters DB');
		response = await ApiConnection.searchStores(city, type, categories);
		searchStore.setSearchHistory(newSearch);
		searchStore.setSearchResults(response.data);
		console.log(response);
		stores.value = response.data;
	}
}

onBeforeMount(() => 
{
	queryStores();
})
</script>

<template>
    <v-container class="d-flex justify-center align-center mt-10">
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
