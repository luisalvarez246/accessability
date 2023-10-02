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
      if (value?.length >= 5) return true;

      return "Must enter a valid web.";
    },
  },
});
const name = useField("name");
const type = useField("type");
const city = useField("city");
const phone = useField("phone");
const web = useField("web");
const description = useField("description");
const address = useField("address");
const checkbox = useField("checkbox");
const email = useField("email");
const characteristics = ref([]);
const store = ref({
  storeName: "",
  city: "",
  phone: "",
  address: "",
  type: "",
  email: "",
  description: "",
  web: "",
  characteristicIds: [],
});

const items = ref([
  "restaurant",
  "museum",
  "hotel",
  "shops",
  "clinic",
  "cinema",
  "hairdresser",
]);

const checkboxValues = ref([]);

const updateCheckbox = (id, value) => {
  checkboxValues.value[id] = value;
  console.log(checkboxValues.value);
};

const addStore = async () => {
  const newStore = {
    ...store.value,
    characteristicIds: checkboxValues.value,
    image: store.value.image[0].name,
    type: items.value.id,
  };
  try {
    let response = await ApiConnection.saveStore(newStore);
    console.log(response);
    console.log(newStore);
    alert("Store successfully created");
    location.reload()
  } catch (error) {
    alert("Cannot add the store: " + error);
  }
};

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
  <div
    class="mainContainer bg-deep-purple-lighten-5 w-100 h-auto d-flex justify-center"
  >
    <form @submit.prevent="">
      <div
        class="d-flex flex-column align-center bg-white rounded w-75 mt-10 ml-auto mr-auto pt-10"
      >
        <v-text-field
          class="w-75 v-label"
          v-model="store.storeName"
          :error-messages="name.errorMessage.value"
          label="Name"
        ></v-text-field>

        <v-text-field
          class="w-75 v-label"
          v-model="store.city"
          :error-messages="city.errorMessage.value"
          label="City"
        ></v-text-field>

        <v-text-field
          class="w-75 v-label"
          v-model="store.phone"
          :error-messages="phone.errorMessage.value"
          label="Phone"
        ></v-text-field>

        <v-text-field
          class="w-75 v-label"
          v-model="store.address"
          :error-messages="address.errorMessage.value"
          label="Address"
        ></v-text-field>

        <!-- <v-text-field
          class="w-75 v-label"
          v-model="store.type"
          :error-messages="type.errorMessage.value"
          label="Type of bussiness"
        ></v-text-field> -->

        <v-text-field
          class="w-75 v-label"
          v-model="store.email"
          :error-messages="email.errorMessage.value"
          label="Email"
        ></v-text-field>

        <v-text-field
          class="w-75 v-label"
          v-model="store.web"
          :error-messages="web.errorMessage.value"
          label="Web"
        ></v-text-field>

        <v-select
          class="w-75 v-label"
          label="Type of businnes"
          v-model="items.id"
          :items="items"
          item-value="id"
        >
        </v-select>

        <v-file-input
          class="w-50 v-label"
          v-model="store.image"
          label="Image"
          variant="filled"
          prepend-icon="mdi-camera"
        ></v-file-input>
      </div>

      
      <v-container class="bg-white w-75 mt-10 rounded mb-10 py-10 pl-15">
        <v-col
          class=""
          v-for="(characteristic, index) in characteristics"
          :key="characteristic.id"
        >
          <v-row v-if="index % 5 === 0">
            <v-col class="pr-10" v-for="i in 5" :key="index + i">
              <template v-if="index + i - 1 < characteristics.length">
                <v-checkbox
                  class="checkboxes"
                  v-model="store.characteristics"
                  :model-value="
                    checkboxValues[characteristics[index + i - 1].id]
                  "
                  @update:model-value="
                    updateCheckbox(characteristics[index + i - 1].id, $event)
                  "
                  :error-messages="checkbox.errorMessage.value"
                  :value="characteristics[index + i - 1].id"
                  :label="characteristics[index + i - 1].title"
                  type="checkbox"
                  ><v-img
                    class="characteristicsIcon"
                    :src="characteristics[index + i - 1].icon"
                    :aria-label="characteristics[index + i - 1].icon"
                  ></v-img
                ></v-checkbox>
              </template>
            </v-col>
          </v-row>
        </v-col>
      </v-container>
      <div class="areaBtns bg-white w-75 rounded ml-auto mr-auto mb-10">
        <v-textarea
          label="Characteristics description"
          v-model="store.description"
          class="w-75 ml-auto mr-auto pt-10 v-label"
        ></v-textarea>
        <div class="btnsContainer d-flex justify-center pb-10">
          <v-btn
            rounded-sm
            class="me-4 bg-green-darken-3"
            type="submit"
            @click="addStore()"
            >submit
          </v-btn>

          <v-btn rounded-sm class="bg-red-accent-4" @click="handleReset">
            clear
          </v-btn>
        </div>
      </div>
    </form>
  </div>
</template>
<style scoped>
.characteristicsIcon {
  width: 50px;
  height: 50px;
}

.cityInput {
  font-weight: 500;
}

.v-label {
  opacity: 1;
  font-weight: 900;
}

.checkboxes {
  font-weight: 900 !important;
  color: black !important;
}
</style>
