<script setup>
import { ref, onBeforeMount } from 'vue'
import ApiConnection from "@/services/ApiConnection";
import { useField, useForm } from "vee-validate";

const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    name(value) {
      if (value?.length >= 2) return true;

      return "Name needs to be at least 2 characters.";
    },
    type(value) {
      if (value?.length >= 2) return true;

      return "Must introduce a valid city.";
    },
    address(value) {
      if (value?.length >= 2) return true;

      return "Must be a valid address.";
    },
    // email(value) {
    //   if (/^[a-z.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true;

    //   return "Must be a valid e-mail.";
    // },
    select(value) {
      if (value) return true;

      return "Select an item.";
    },
    checkbox(value) {
      if (value === "1") return true;

      return "Must be checked.";
    },
  },
});
const name = useField("name");
const type = useField("type");
const city = useField("city")
const address = useField("address");
const checkbox = useField("checkbox");
const characteristics = ref([])
const characteristic = ref({
    id: '',
    icon: "",
    title: ""
})

const submit = handleSubmit((values) => {
  alert(JSON.stringify(values, null, 2));
});

const getAllCharacteristics = async () => {
    let response = await ApiConnection.getAllCharacteristics()
    characteristics.value = response.data
    console.log(characteristics.value);
    return characteristics.value
}

onBeforeMount(() => {
    getAllCharacteristics()
})
</script>

<template>

    <div>
        <button><router-link to="/">cambiar vista</router-link></button>
    </div>


  <form @submit.prevent="submit">
    <v-text-field
      v-model="name.value.value"
      :counter="10"
      :error-messages="name.errorMessage.value"
      label="Name"
    ></v-text-field>

    <v-text-field
      v-model="city.value.value"
      :counter="7"
      :error-messages="city.errorMessage.value"
      label="City"
      placeholder="Gijón, Oviedo, Avilés..."
    ></v-text-field>

    <v-text-field
      v-model="address.value.value"
      :error-messages="address.errorMessage.value"
      label="Address"
      placeholder="Calle Principal..."
    ></v-text-field>

    <v-text-field
      v-model="type.value.value"
      :error-messages="type.errorMessage.value"
      label="Type"
      placeholder="email@dominio.com"
    ></v-text-field>

    <v-checkbox
      v-for="characteristic in characteristics" :key="characteristic.id"
      v-model="characteristic.title.value"
      :error-messages="checkbox.errorMessage.value"
      value="1"
      label="option"
      type="checkbox"
    ></v-checkbox>

    <!-- <v-checkbox
      v-model="checkbox.value.value"
      :error-messages="checkbox.errorMessage.value"
      value="1"
      label="Option"
      type="checkbox"
    ></v-checkbox> -->

    

    <v-btn class="me-4" type="submit"> submit </v-btn>

    <v-btn @click="handleReset"> clear </v-btn>
  </form>
</template>
