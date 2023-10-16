<template>
<v-card
	color="#59029F"
	class="mb-7"
	width="300"
>
	<v-img 
	:src="`${imagesUrl}/${props.image}`"
	:alt="props.alt"
	></v-img>
	<v-card-title>
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
			class="text-none text-subtitle-1 mx-auto active"
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
web: String,
image: String,
alt: String
})

const show = ref(Array(3).fill(false));
const stores = ref([]);
const cardIndex = ref()
const imagesUrl = "http://localhost:8080/images/"


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