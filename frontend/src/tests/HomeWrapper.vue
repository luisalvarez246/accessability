<template>
  <v-container
    height="auto"
    width="100%"
    class="hero_section d-flex justify-center pb-0"
    color="mainbackground"
    rounded="lg"
  >
    <v-img
      src="../assets/images/hero.avif"
      lazy-src="../assets/images/hero.avif"
      alt=""
      cover
      max-width="1140"
      max-height="290"
    >
      <div class="title">
        <h1 class="underline pl-4">Welcome to AccessAbility</h1>
      </div>
    </v-img>
  </v-container>
  <v-container
    class="section_search pt-0"
    id="section_search"
    role="combobox"
    aria-labelledby="section_search"
  >
    <v-card
      color="cardbackground1"
      class="pt-4 pb-10 mx-auto"
      elevation="2"
      max-width="1140"
    >
      <v-card-title class="text-center text-wrap pb-4">
        Discover accessible places in Asturias
      </v-card-title>
      <v-card class="mx-auto" color="cardbackground2" width="90%">
        <v-card-text>
          <v-row>
            <v-col cols="12" lg="11">
              <v-row align="center" class="ml-16">
                <v-col cols="auto">
                  <p
                    class="font-weight-bold text-subtitle-1 text-cardbackground1 pl-0 pr-6"
                  >
                    Near to...
                  </p>
                </v-col>
                <v-col cols="auto">
                  <v-icon
                    color="cardbackground1"
                    size="36"
                    aria-hidden="true"
                    aria-label="Search Place"
                    alt="Search"
                  >
                    mdi-map-marker
                  </v-icon>
                </v-col>
                <v-col cols="12" class="pt-0">
                  <v-select
                    id="search-location"
                    bg-color="white"
                    color="cardbackground1"
                    base-color="navbar"
                    variant="outlined"
                    clearable
                    label="Search location..."
                    class="custom_messages"
                    :items="citiesInStore"
                  />
                </v-col>
              </v-row>
              <v-row align="center" class="ml-16">
                <v-col class="pr-0" cols="auto">
                  <v-card-text
                    class="font-weight-bold text-subtitle-1 text-cardbackground1 px-0"
                  >
                    I'm looking for...
                  </v-card-text>
                </v-col>
                <v-col cols="auto" class="pl-0">
                  <v-icon
                    size="36"
                    color="cardbackground1"
                    aria-hidden="true"
                    aria-label="Search accessibility"
                    alt="Search"
                  >
                    mdi-magnify
                  </v-icon>
                </v-col>
                <v-col cols="12" class="pt-0">
                  <v-select
                    id="search-type-of-site"
                    bg-color="white"
                    color="cardbackground1"
                    base-color="navbar"
                    variant="outlined"
                    clearable
                    label="Search by type..."
                    :items="typesInStore"
                  />
                </v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-item class="justify-space-between">
          <v-row>
            <v-col
              v-for="(item, index) in [
                {
                  icon: 'mdi-wheelchair',
                  label: 'PRM (People with reduced mobility)',
                  value: 'prm',
                },
                {
                  icon: 'mdi-eye-off-outline',
                  label: 'Visually impaired',
                  value: 'visual',
                },
                {
                  icon: 'mdi-ear-hearing-off',
                  label: 'Impaired hearing',
                  value: 'hearing',
                },
              ]"
              :key="index"
              cols="12"
              md="4"
              sm="6"
              xs="12"
              class="d-flex align-center"
            >
              <v-icon size="48" color="cardbackground1">
                {{ item.icon }}
              </v-icon>
              <v-checkbox
                :label="item.label"
                :value="item.value"
                color="cardbackground1"
                aria-checked="false"
                class="d-flex align-center font-weight-bold text-cardbackground1"
              >
              </v-checkbox>
            </v-col>
          </v-row>
        </v-card-item>
        <v-col class="d-flex mx-auto pb-5" cols="12" md="0" lg="3">
          <v-btn
            text
            class="text-none mx-auto searchButton"
            rounded="xl"
            flat
            :block="xs"
            :size="xs ? '' : 'x-large'"
            :height="xs ? 52 : ''"
            :class="{ 'text-h6': xs }"
            @click="makeSearch()"
          >
            Search
          </v-btn>
        </v-col>
      </v-card>
    </v-card>
  </v-container>

  <v-container touchDrag="true" class="w-75 mb-10 rounded-lg" max-width="1140">
    <Carousel :wrapAround="true" :transition="500" :breakpoints="breakpoints">
      <Slide v-for="store in stores" :key="store.id">
        <div class="carousel__item">
          <Card
            :store-name="store.storeName"
            :type="store.type"
            :city="store.city"
            :category="store.categories"
            :address="store.address"
            :phone="store.phone"
            :email="store.email"
            :description="store.description"
            :web="store.web"
            :image="store.image"
          />
        </div>
      </Slide>

      <template #addons>
        <Navigation />
        <Pagination />
      </template>
    </Carousel>
  </v-container>
</template>

<script setup>
import { useDisplay } from "vuetify";
import { ref, onBeforeMount, onUpdated } from "vue";
import Card from "../components/Card.vue";
import ApiConnection from "@/services/ApiConnection";
import { Carousel, Pagination, Slide, Navigation } from "vue3-carousel";
import { useRouter } from "vue-router";
import "vue3-carousel/dist/carousel.css";

const stores = ref([]);
const citiesInStore = ref();
const typesInStore = ref();
const search = ref({
  city: "",
  type: "",
  categories: [],
});
const router = useRouter();

const getStores = async () => {
  let response = await ApiConnection.getAllStores();
  stores.value = response.data;
  console.log(stores.value);
  return stores.value;
};

onBeforeMount(() => {
  getStores();
});

const { xs } = useDisplay();

const rules = {
  required: (value) => !!value || "Field is required",
};

const breakpoints = ref({
  480: {
    itemsToShow: 1,
  },
  768: {
    itemsToShow: 2,
  },
  1024: {
    itemsToShow: 2.3,
  },
});

const sortCategories = () => {
  if (
    search.value.categories.includes("visual") &&
    search.value.categories.includes("hearing")
  ) {
    let aux;
    let firstIndex;
    let lastIndex;

    firstIndex = search.value.categories.indexOf("visual");
    lastIndex = search.value.categories.indexOf("hearing");
    aux = search.value.categories[firstIndex];
    search.value.categories[firstIndex] = search.value.categories[lastIndex];
    search.value.categories[lastIndex] = aux;
  }
};

const parseCategories = () => {
  let categories;
  let filtereUnchecked;

  if (
    search.value.categories.length > 0 &&
    !search.value.categories.every((value) => value === false)
  ) {
    sortCategories();
    filtereUnchecked = search.value.categories.filter((x) => x !== false);
    categories = filtereUnchecked.reduce(
      (acc, currentValue) => acc + "," + currentValue
    );
    return categories;
  }
  return null;
};

const makeSearch = () => {
  let categories;

  categories = parseCategories();
  router.push({
    name: "search",
    params: {
      city: search.value.city,
      type: search.value.type,
      categories: categories,
    },
  });
};
</script>

<style scoped>
.title {
  position: relative;
  color: #59029f;
  text-wrap: wrap;
}

div.title {
  background-color: #fed636;
  width: auto;
  height: auto;
  bottom: 0;
  content: "";
  display: block;
  left: 0;
  position: absolute;
  padding: 0 1rem 0.5rem 0.25rem;
}

.underline {
  position: relative;
}

h1.underline::after {
  background: #14cac9;
  bottom: 0;
  content: "";
  display: block;
  height: 0.25rem;
  left: 5;
  position: absolute;
  width: 5rem;
}

:deep(.v-label) {
  opacity: var(--v-high-emphasis-opacity);
}

:deep(.v-label.v-field-label.v-field-label--floating) {
  --v-field-label-scale: 1rem;
}

.searchButton {
  color: #340458;
  background-color: #fed636;
}

.carousel__slide {
  padding: 5px;
}

.carousel__viewport {
  perspective: 2000px;
}

.carousel__track {
  transform-style: preserve-3d;
}

.carousel__slide--sliding {
  transition: 0.5s;
}

.carousel__slide {
  opacity: 0.9;
  transform: rotateY(-20deg) scale(0.9);
}

.carousel__slide--active ~ .carousel__slide {
  transform: rotateY(20deg) scale(0.9);
}

.carousel__slide--prev {
  opacity: 1;
  transform: rotateY(-10deg) scale(0.95);
}

.carousel__slide--next {
  opacity: 1;
  transform: rotateY(10deg) scale(0.95);
}

.carousel__slide--active {
  opacity: 1;
  transform: rotateY(0) scale(1.1);
}

:deep(.carousel__prev) {
  color: #59029f;
  width: 3.75rem;
  height: 3.75rem;
  background-color: #fed636;
  border-radius: 3.125rem;
  border: 2px solid #59029f;
}

:deep(.carousel__next) {
  color: #59029f;
  width: 3.75rem;
  height: 3.75rem;
  background-color: #fed636;
  border-radius: 3.125rem;
  border: 2px solid #59029f;
}

:deep(.carousel__icon) {
  width: 5rem;
  height: 5rem;
}
</style>
