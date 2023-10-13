import { defineStore } from 'pinia'

export const useSearchStore = defineStore('search',
{
	state: () =>
	(
		{
			history: [],
			result: [],
		} 
	),
	getters:
	{
		getSearchHistory: (state) => state.history,
		getSearchResults: (state) => state.result
	},
	actions:
	{
		setSearchHistory(newSearch)
		{
			this.history.push(newSearch);
		},
		setSearchResults(results)
		{
			this.result.push(results);
		}
	}
})