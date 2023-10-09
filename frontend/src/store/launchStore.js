import { defineStore } from "pinia";

export const useLaunchStore = defineStore("launch", {
	state: () =>
	(
		{
			types: {},
			cities: {},
		}
	),
	getters:
	{
		getTypes: (state) => state.types,
		getCities: (state) => state.cities,
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
		}
	}
})