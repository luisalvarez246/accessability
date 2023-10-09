<!-- eslint-disable vue/multi-word-component-names -->
<!-- <script>
export default {
  data() {
    return {
      model: 0,
      cardData: Array.from({ length: 45 }, (_, index) => index),
    };
  },
};
</script> -->

<template>
  <div>
    <div class="d-flex justify-space-around align-center py-4">
      <v-btn
        variant="text"
        icon="mdi-minus"
        @click="model = Math.max(model - 1, 0)"
      ></v-btn>
      {{ model }}
      <v-btn
        variant="text"
        icon="mdi-plus"
        @click="model = Math.min(model + 1, 4)"
      ></v-btn>
    </div>
    <v-carousel
      v-model="model"
      :height="calculateCarouselHeight()"
      :cycle="false"
      :continuous="true"
      hide-delimiter-background
    >
      <v-carousel-item v-for="(color, i) in colors" :key="color" :value="i">
        <v-sheet :color="color" height="100%" tile>
          <div class="d-flex fill-height justify-center align-center">
            <v-container fluid>
              <v-row justify="center" align-center>
                <v-col v-for="cardIndex in 3" :key="cardIndex" cols="4">
                  <v-card
                    color="#59029F"
                    class="mb-7"
                    min-width="300"
                    max-width="400"
                  >
                    <v-img
                      src="https://hips.hearstapps.com/hmg-prod/images/los-mejores-restaurantes-que-tienes-que-probar-en-madrid-1644914076.jpeg?crop=0.753xw:1.00xh;0.125xw,0&resize=1200:*"
                    ></v-img>
                    <v-card-title>
                      <h2>Casa Pepe</h2>
                    </v-card-title>
                    <v-card-text>
                      <p>
                        Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM Aviles Calle Invierno N21
                        PRM
                      </p>
                    </v-card-text>

                    <v-card-actions>
                      <v-btn
                        @click="toggleShow(cardIndex)"
                        class="text-none text-subtitle-1 mx-auto"
                        variant="flat"
                        color="#7ED057"
                        block
                      >
                        {{ show[cardIndex] ? 'HIDE INFO' : 'MORE INFO' }}
                      </v-btn>
                    </v-card-actions>
                    <v-expand-transition>
                      <div v-if="show[cardIndex]">
                        <v-divider></v-divider>

                        <v-card-text>
                          I'm a thing. But, like most politicians, he promised
                          more than he could deliver. You won't have time for
                          sleeping, soldier, not with all the bed making you'll
                          be doing. Then we'll go with that data file! Hey, you
                          add a one and two zeros to that or we walk! You're
                          going to do his laundry? I've got to find a way to
                          escape.
                        </v-card-text>
                      </div>
                    </v-expand-transition>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </div>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      colors: ["primary", "secondary", "yellow darken-2", "red", "orange"],
      model: 0,
      show: Array(3).fill(false),
    };
  },
  methods: {
    calculateCarouselHeight() {
      const cardHeight = 350;
      const numRows = Math.ceil(this.colors.length / 3);
      return numRows * cardHeight;
    },
    toggleShow(cardIndex) {
      this.show[cardIndex] = !this.show[cardIndex];
    },
  },
};
</script>


<style>
.v-carousel {
  display: flex;
  justify-content: center;
  align-items: center;
}

.v-carousel .v-carousel-control__item.v-carousel-indicator__item--active {
  box-shadow: none !important;
}
</style>

<!-- <template>
    
    <v-container grid-list-md>
    <v-sheet class="mx-auto" elevation="10" max-width="1580">
      <v-slide-group
        v-model="model"
        class="pa-10"
        center-active
        show-arrows
        :visible-count="3"
        :cycle="true" 
        :min-per-page="3"
      >
        <v-slide-group-item class="slide-group" v-for="n in 15" :key="n" v-slot="{ isSelected }">
          <v-card color="#59029F" class="mr-4 mb-7" min-width="400" max-width="450">
            <v-img
              src="https://hips.hearstapps.com/hmg-prod/images/los-mejores-restaurantes-que-tienes-que-probar-en-madrid-1644914076.jpeg?crop=0.753xw:1.00xh;0.125xw,0&resize=1200:*"
            ></v-img>
            <v-card-title>
              <h2>Restaurante Casa Pepe</h2>
            </v-card-title>
            <v-card-text>
              <p>
                La mejor casa de comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de
                todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de
                comidas de todo GijónLa mejor casa de comidas de todo GijónLa mejor casa de comidas de todo Gijón
              </p>
            </v-card-text>
            <v-card-actions>
              <v-btn class="text-none text-subtitle-1 mx-auto" variant="flat" color="#7ED057" block>MORE INFO</v-btn>
            </v-card-actions>
          </v-card>
        </v-slide-group-item>
      </v-slide-group>
    </v-sheet>
  </v-container>
  --/> 
</template>


<style scoped>
@media (min-width: 1280px) {
  .custom-lg-container-width {
    max-width: 1280px;
    margin: 0 auto;
  }
}

</style> -->
