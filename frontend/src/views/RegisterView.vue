<script setup>
import { ref, onBeforeMount } from "vue";
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
    email(value) {
      if (/^[a-z.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true;

      return "Must be a valid e-mail.";
    },
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
const city = useField("city");
const phone = useField("phone")
const description = useField("description")
const address = useField("address");
const checkbox = useField("checkbox");
const email = useField("email")
const characteristics = ref([]);
// const characteristic = ref({
//     id: '',
//     icon: "",
//     title: ""
// })

const checkboxValues = ref({});

const updateCheckbox = (id, value) => {
  checkboxValues.value[id] = value;
};

const submit = handleSubmit((values) => {
  alert(JSON.stringify(values, null, 2));
  
});

const getAllCharacteristics = async () => {
  let response = await ApiConnection.getAllCharacteristics();
  characteristics.value = response.data;
  console.log(characteristics.value);
  return characteristics.value;
};

onBeforeMount(() => {
  getAllCharacteristics();
});
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
      aria-label="Field for name of bussiness"
    ></v-text-field>

    <v-text-field
      v-model="city.value.value"
      :counter="7"
      :error-messages="city.errorMessage.value"
      label="City"
      placeholder="Gijón, Oviedo, Avilés..."
      aria-label="Field for city of bussiness"
    ></v-text-field>

    <v-text-field
      v-model="phone.value.value"
      :counter="7"
      :error-messages="phone.errorMessage.value"
      label="Phone"
      placeholder="667123456..."
      aria-label="Field for phone of bussiness"
    ></v-text-field>

    <v-text-field
      v-model="address.value.value"
      :error-messages="address.errorMessage.value"
      label="Address"
      placeholder="Calle Principal..."
      aria-label="Field for address of bussiness"
    ></v-text-field>

    <v-text-field
      v-model="type.value.value"
      :error-messages="type.errorMessage.value"
      label="Type"
      placeholder="Restaurant, Hotel..."
      aria-label="Field for type of bussiness"
    ></v-text-field>

    <v-text-field
      v-model="email.value.value"
      :error-messages="email.errorMessage.value"
      label="Email"
      placeholder="name@domain.com"
      aria-label="Field for email of bussiness"
    ></v-text-field>

    <!-- <v-checkbox
    class="d-flex "
      v-for="characteristic in characteristics" :key="characteristic.id"
      v-model="characteristic.title.value"
      :error-messages="checkbox.errorMessage.value"
      value="1"
      :label="characteristic.title"
      type="checkbox"
    ></v-checkbox> -->

    <v-checkbox
      v-for="characteristic in characteristics"
      :key="characteristic.id"
      :model-value="checkboxValues[characteristic.id]"
      @update:model-value="updateCheckbox(characteristic.id, $event)"
      :error-messages="checkbox.errorMessage.value"
      :value="characteristic.id"
      :label="characteristic.title"
      type="checkbox"
      aria-label="Checkbox of Characteristics of the bussiness"
    ></v-checkbox>

    <v-textarea
    v-model="description.value"
     label="Description"
     aria-label="Area for a detailed description of the characteristics of the bussiness"
     ></v-textarea>

    <v-btn class="me-4" type="submit"> submit </v-btn>

    <v-btn @click="handleReset"> clear </v-btn>
  </form>
</template>
