<!-- eslint-disable no-unused-vars -->
<script setup>
import { ref, onBeforeMount } from "vue";
import ApiConnection from "@/services/ApiConnection";
import { useField, useForm } from "vee-validate";

const props = defineProps({
  show: Boolean,
});

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
const validated = ref(false);
const characteristics = ref([]);
const cities = ref([]);
const types = ref([]);
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

const initialStore = {
  storeName: "",
  city: "",
  phone: "",
  address: "",
  type: "",
  email: "",
  description: "",
  web: "",
  characteristicIds: [],
};

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
    type: types.value.id,
    city: cities.value.id,
  };
  try {
    let response = await ApiConnection.saveStore(newStore);
    console.log(response);
    console.log(newStore);
    if (response.status === 200) validated.value = true;
  } catch (error) {
    alert("Cannot add the store: " + error);
  }
};

const getAllCharacteristics = async () => {
  let response = await ApiConnection.getAllCharacteristics();
  characteristics.value = response.data;
  return characteristics.value;
};

const getCities = async () => {
  let response = await ApiConnection.getAllCities();
  cities.value = response.data;
  return cities.value;
};

const getTypes = async () => {
  let response = await ApiConnection.getAllTypes();
  types.value = response.data;
  return types.value;
};

const handleClear = () => {
  Object.assign(store.value, initialStore);
};

const reloadPage = () => {
  location.reload()
}

const ftClose = () => {
  // eslint-disable-next-line vue/no-mutating-props
  props.show = false;
};

onBeforeMount(() => {
  getAllCharacteristics();
  getCities();
  getTypes();
});
</script>

<template>
  <div
    class="mainContainer bg-deep-purple-lighten-5 w-100 h-auto d-flex justify-center"
  >
    <form @submit.prevent="handleSubmit" @reset.prevent="handleReset">
      <div
        class="d-flex flex-column align-center bg-white rounded w-75 mt-10 ml-auto mr-auto pt-10"
      >
        <v-text-field
          class="w-75 v-labelText"
          v-model="store.storeName"
          :error-messages="name.errorMessage.value"
          label="Name"
        ></v-text-field>

        <v-text-field
          class="w-75 v-labelText"
          v-model="store.phone"
          :error-messages="phone.errorMessage.value"
          label="Phone"
        ></v-text-field>

        <v-text-field
          class="w-75 v-labelText"
          v-model="store.address"
          :error-messages="address.errorMessage.value"
          label="Address"
        ></v-text-field>

        <v-text-field
          class="w-75 v-labelText"
          v-model="store.email"
          :error-messages="email.errorMessage.value"
          label="Email"
        ></v-text-field>

        <v-text-field
          class="w-75 v-labelText"
          v-model="store.web"
          :error-messages="web.errorMessage.value"
          label="Web"
        ></v-text-field>

        <v-select
          class="w-75 v-labelText"
          v-model="cities.id"
          label="City"
          :items="cities"
          item-value="id"
        >
        </v-select>

        <v-select
          class="w-75 v-labelText"
          label="Type of businnes"
          v-model="types.id"
          :items="types"
          item-value="id"
        >
        </v-select>

        <v-file-input
          class="w-50 v-labelText"
          v-model="store.image"
          label="Image"
          variant="filled"
          prepend-icon="mdi-camera"
        ></v-file-input>
      </div>
      <v-container class="bg-white w-75 mt-10 rounded mb-10 py-10 pl-15">
        <v-row>
          <v-col
            v-for="characteristic in characteristics"
            :key="characteristic.id"
            cols="12"
            sm="6"
            md="4"
            lg="3"
          >
            <v-checkbox
              class="checkboxes"
              v-model="store.characteristicIds"
              @update:model-value="
                updateCheckbox(
                  characteristics[characteristic.id - 1].id,
                  $event
                )
              "
              :model-value="
                checkboxValues[characteristics[characteristic.id - 1].id]
              "
              :value="characteristic.id"
              :label="characteristic.title"
              type="checkbox"
            >
              <v-img
                class="characteristicsIcon"
                :src="characteristic.icon"
                :alt="`Icon of ${characteristic.icon}`"
              ></v-img>
            </v-checkbox>
          </v-col>
        </v-row>
      </v-container>

      <div class="areaBtns bg-white w-75 rounded ml-auto mr-auto mb-10">
        <v-textarea
          label="Characteristics description"
          v-model="store.description"
          class="w-75 ml-auto mr-auto pt-10 v-labelText"
        ></v-textarea>

        <div class="btnsContainer d-flex justify-center pb-10">
          <v-dialog width="500" close-on-content-click>
            <template v-slot:activator="{ props }">
              <!-- <v-btn v-bind="props" text="Open Dialog"> </v-btn> -->
              <v-btn
                rounded-sm
                v-bind="props"
                class="me-4 bg-green-darken-3"
                type="submit"
                @click="addStore()"
                >submit
              </v-btn>
              <v-btn rounded-sm class="bg-red-accent-4" @click="handleClear">
                clear
              </v-btn>
            </template>

            <template v-slot:default="{ isActive }" v-if="validated">
              <v-card title="Dialog">
                <v-card-text>
                  <v-icon src="https://icons8.com/icon/bE5mRAhk65Br/verified-account">

                  </v-icon>
                  Store Added Successfully!!
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>

                  <v-btn
                    text="Close Dialog"
                    @click="(isActive.value = false), reloadPage()"
                  ></v-btn>
                </v-card-actions>
              </v-card>
            </template>
          </v-dialog>
        </div>
      </div>
    </form>
  </div>
</template>
<style scoped>
.characteristicsIcon {
  width: 3.125rem;
  height: 3.125rem;
}

.cityInput {
  font-weight: 500;
}

.v-labelText {
  opacity: 1;
  font-weight: 900;
}

.checkboxes {
  font-weight: 900 !important;
  color: black !important;
}
</style>
