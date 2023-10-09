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
          navbar: '#340458',
          navbarbtns: '#14CAC9',
          mainbackground: '#F9F7FB', 
          cardbackground1: '#59029F',
          cardbackground2: '#F6F3FA',
          searchbtn: '#FED636',
        },
      },
    },
  },
})
