<script setup>
import { RouterLink, RouterView } from 'vue-router'
import AppBar from './components/AppBar.vue';
import FooterBar from './components/FooterBar.vue'
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
