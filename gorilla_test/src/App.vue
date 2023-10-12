<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { onMounted } from 'vue';
import AppBar from './components/AppBar.vue';
import FooterBar from './components/FooterBar.vue';
import ApiConnection from './services/ApiConnection.js'
import { useLaunchStore } from './store/launchStore.js'

const searchFields = useLaunchStore();
onMounted(async () =>
{
	const typesInStore = await ApiConnection.getTypesInStore()
	const citiesInStore = await ApiConnection.getCitiesInStore();

	searchFields.setTypes(typesInStore);
	searchFields.setCities(citiesInStore);
	console.log(typesInStore);
	console.log(citiesInStore);
})

</script>

<template>
	<v-app>
		<AppBar />
			<RouterView />
		<FooterBar />
	</v-app>
</template>

<style scoped>
</style>
