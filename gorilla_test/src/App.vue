<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { ref, onUpdated } from 'vue'
import AppBar from './components/AppBar.vue';
import FooterBar from './components/FooterBar.vue'
import Modal from './components/NavHelp.vue'

const	showModal = ref(false);

</script>

<template>
	<v-app>
		<AppBar @modal="(data) => showModal = data"/>
			<RouterView />
		<FooterBar />
		<Teleport to="body">
    		<modal :show="showModal" @close="showModal = false">
    		  <template #header>
    		    <h3 class="text-center">Keyboard Navigation Help</h3>
				<v-container class="d-flex">
					<v-icon class="mr-4" color="#340458">
						mdi-keyboard-tab
					</v-icon>
					<p class="modal-text">Tab to navigate</p>
				</v-container>
				<v-container class="d-flex">
					<v-icon class="mr-4" color="#340458">
						mdi-arrow-up-bold
					</v-icon>
					<p class="modal-text">Arrow up, scroll up in dropdowns</p>
				</v-container>
				<v-container class="d-flex">
					<v-icon class="mr-4" color="#340458">
						mdi-arrow-down-bold
					</v-icon>
					<p class="modal-text">Arrow down, scroll down in dropdowns</p>
				</v-container>
				<v-container class="d-flex">
					<v-icon class="mr-4" color="#340458">
						mdi-keyboard-space
					</v-icon>
					<p class="modal-text">Space, to select/deselect checkboxes</p>
				</v-container>
				<v-container class="d-flex">
					<v-icon class="mr-4" color="#340458">
						mdi-keyboard-return
					</v-icon>
					<p class="modal-text">Enter, to click buttons and links</p>
				</v-container>
    		  </template>
    		</modal>
  		</Teleport>
	</v-app>
</template>

<style scoped>

.modal-text
{
	color: #340458;
}
</style>
