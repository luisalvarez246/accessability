import { defineStore } from "pinia";

export const useLaunchStore = defineStore("launch", {
	state: () =>
	(
		{
			types: {},
			cities: {},
			randomStores: {},
		}
	),
	getters:
	{
		getTypes: (state) => state.types,
		getCities: (state) => state.cities,
		getRandomStores: (state) => state.randomStores,
	},
	actions:
	{
		setTypes(fetchedTypes)
		{
			this.types = fetchedTypes;
		},
		setCities(fetchedCities)
		{
			this.cities = fetchedCities;
		},
		setRandomStores(fetchedStores)
		{
			this.randomStores = fetchedStores;
		}
	}
})