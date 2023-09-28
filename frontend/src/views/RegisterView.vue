<!-- eslint-disable no-unused-vars -->
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
    city(value) {
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
    phone(value) {
      if (value?.length >= 9) return true;

      return "Must enter a valid phone number.";
    },
    type(value) {
      if (value?.length >= 2) return true;

      return "Must enter a valid type of bussiness.";
    },
    web(value) {
      if(value?.length >= 5) return true;

      return "Must enter a valid web."
    }
  },
});
const name = useField("name");
const type = useField("type");
const city = useField("city");
const phone = useField("phone");
const web = useField("web")
const description = useField("description");
const address = useField("address");
const checkbox = useField("checkbox");
const email = useField("email");
const characteristics = ref([]);
const store = ref({
  storeName: '',
  city: '',
  phone: '',
  address: '',
  type: '',
  email: '',
  description: '',
  web: '',
  characteristicIds: []
})

const checkboxValues = ref([]);

const updateCheckbox = (id, value) => {
  checkboxValues.value[id] = value;
  console.log(checkboxValues.value);
};


const addStore = async () => {
  const newStore = {
    ...store.value,
    characteristicIds: checkboxValues.value
  }
   try {
    let response = await ApiConnection.saveStore(newStore);
    console.log(response);
    console.log(newStore);
    alert("Store successfully created")
   } catch (error) {
    alert("Cannot add the store: " + error)
   }


}

const getAllCharacteristics = async () => {
  let response = await ApiConnection.getAllCharacteristics();
  characteristics.value = response.data;
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

  <form @submit.prevent="">
    <div class="d-flex flex-column align-center">
      <v-text-field
      class="w-50"
      v-model="store.storeName"
      :counter="10"
      :error-messages="name.errorMessage.value"
      label="Name"
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.city"
      :counter="7"
      :error-messages="city.errorMessage.value"
      label="City"
      placeholder="Gijón, Oviedo, Avilés..."
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.phone"
      :counter="7"
      :error-messages="phone.errorMessage.value"
      label="Phone"
      placeholder="667123456..."
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.address"
      :error-messages="address.errorMessage.value"
      label="Address"
      placeholder="Calle Principal..."
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.type"
      :error-messages="type.errorMessage.value"
      label="Type"
      placeholder="Restaurant, Hotel..."
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.email"
      :error-messages="email.errorMessage.value"
      label="Email"
      placeholder="name@domain.com"
    ></v-text-field>

    <v-text-field
      class="w-50"
      v-model="store.web"
      :error-messages="web.errorMessage.value"
      label="Web"
      placeholder="domain.com"
    ></v-text-field>

    </div>
    

    <!-- <div
      class="col-12"
      v-for="characteristic in characteristics"
      :key="characteristic.id"
    >
      <v-img class="characteristicsIcon" :src="characteristic.icon"></v-img>

      <v-checkbox
        :model-value="checkboxValues[characteristic.id]"
        @update:model-value="updateCheckbox(characteristic.id, $event)"
        :error-messages="checkbox.errorMessage.value"
        :value="characteristic.id"
        :label="characteristic.title"
        type="checkbox"
      ></v-checkbox>
    </div> -->

    <v-container>
      <v-row>
        <v-col
          class="col-lg-4 col-md-6 col-sm-12"
          v-for="characteristic in characteristics"
          :key="characteristic.id"
        >
          <v-img class="characteristicsIcon" :src="characteristic.icon"></v-img>

          <v-checkbox
          v-model="store.characteristics"
            :model-value="checkboxValues[characteristic.id]"
            @update:model-value="updateCheckbox(characteristic.id, $event)"
            :error-messages="checkbox.errorMessage.value"
            :value="characteristic.id"
            :label="characteristic.title"
            type="checkbox"
          ></v-checkbox>
      </v-col>
      </v-row>
    </v-container>

    <v-textarea
      label="Description"
      v-model="store.description"
      class="w-75"
      placeholder="Enter a detailed description of the characteristics..."
    ></v-textarea>

    <v-btn rounded-sm class="me-4 bg-green-lighten-1" type="submit" @click="addStore()">
      submit
    </v-btn>

    <v-btn rounded-sm class="bg-red-accent-4" @click="handleReset">
      clear
    </v-btn>
  </form>
</template>
<style scoped>
.characteristicsIcon {
  width: 50px;
  height: 50px;
}
</style>
