import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import customTheme from './plugins/customTheme'

const vuetify = createVuetify({
  components,
  directives,
  theme: customTheme,
})

app.use(createPinia())
app.use(router)
app.use(vuetify).mount('#app')
