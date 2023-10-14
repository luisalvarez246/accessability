<template>
	<v-container class="d-flex justify-center align-center mt-10">
	  <h1>Searched Business</h1>
	</v-container>
  
	<v-container class="my-10 bg-deep-purple-lighten-5 rounded-lg">
	  <v-row>
		<v-col class="d-flex justify-center align-center mx-auto mt-10" v-for="(store, index) in displayedStores" :key="store.id" cols="12" sm="6" md="4" lg="6">
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
  
	<v-pagination v-model="currentPage" :length="totalPages"></v-pagination>
  </template>
  
  <script setup>
  import Card from "../components/Card.vue";
  import ApiConnection from "../services/ApiConnection";
  import { ref, onBeforeMount, computed, watch } from 'vue';
  import { useRoute } from "vue-router";
  import { useSearchStore } from "../store/searchStore";
  
  const stores = ref([]);
  const route = useRoute();
  const searchStore = useSearchStore();
  const city = route.params.city;
  const type = route.params.type;
  const categories = route.params.categories;
  
  const currentPage = ref(1);
  const itemsPerPage = 4; // Cambia esto al número deseado por página
  
  const hasBeenSearched = (newSearch) => {
	const searchHistory = searchStore.getSearchHistory;
	return searchHistory.includes(newSearch);
  };
  
  const queryStores = async () => {
	let response;
	const newSearch = `${city},${type},${categories}`;
	
	if (searchStore.getSearchHistory.length !== 0 && hasBeenSearched(newSearch)) {
	  const searchIndex = searchStore.getSearchHistory.indexOf(newSearch);
	  stores.value = searchStore.getSearchResults[searchIndex];
	} else {
	  response = await ApiConnection.searchStores(city, type, categories);
	  searchStore.setSearchHistory(newSearch);
	  searchStore.setSearchResults(response.data);
	  stores.value = response.data;
	}
  };
  
  onBeforeMount(() => {
	queryStores();
  });
  
  const displayedStores = computed(() => {
	const start = (currentPage.value - 1) * itemsPerPage;
	const end = start + itemsPerPage;
	return stores.value.slice(start, end);
  });
  
  const totalPages = computed(() => {
	return Math.ceil(stores.value.length / itemsPerPage);
  });
  
//   watch(currentPage, () => {
//   });
  </script>
  

