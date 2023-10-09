import { defineStore } from "pinia";

export const useTypeStore = defineStore("types", {
	state: () =>
	(
		{
			types: {},
		}
	),
	getters:
	{
		getTypes: (state) => state.types,
	},
	actions:
	{
		setTypes(fetchedTypes)
		{
			this.types = fetchedTypes;
		}
	}
})