/**
 * plugins/vuetify.js
 *
 * Framework documentation: https://vuetifyjs.com`
 */

// Styles
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'

// Composables
import { createVuetify } from 'vuetify'

// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
export default createVuetify({
  theme: {
    themes: {
      light: {
        colors: {
          primary: '#1867C0',
          secondary: '#5CBBF6',
          navbar: '#4A148C', //purple-darken-4
          navbarbtns: '#26C6DA', //cyan-lighten-1
          mainbackground: '#EDE7F6', //deep-purple-lighten-5
          cardbackground: '#6200EA', //deep-purple-accent-4
          searchbtn: '#FFD740', //amber-accent-2
          input: '#FFF9C4', //yellow-lighten-4
          footer: '#4A148C', //purple-darken-4
          
        },
      },
    },
  },
})
