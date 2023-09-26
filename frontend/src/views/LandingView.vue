<script setup>
import ApiConnection from '../services/ApiConnection'
import { onMounted, ref } from 'vue'

const stores = ref([])
const characteristics = ref([])

const getStores = async () => {
    let response = await ApiConnection.getAllStores()
    stores.value = response.data
    console.log(stores.value);
    return stores
}

const getCharacteristics = async () => {
    let response = await ApiConnection.getAllCharacteristics()
    characteristics.value = response.data
    console.log(characteristics.value);
    return characteristics
}

onMounted(() => {
    getStores()
    getCharacteristics()
})
</script>

<template>
    <div>
        Hola
    </div>

    <button><router-link to="/register">cambiar vista</router-link></button>
    
</template>