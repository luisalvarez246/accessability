<!-- eslint-disable vue/multi-word-component-names -->
<script setup>
const email = 'contact@accessability.com';
</script>

<template>
    <v-container class="cookie-policy-container">
      <v-card class="cookie-policy-card">
        <v-card-title class="headline">Cookie Policy</v-card-title>
        <v-card-text>
          <p>Welcome to Accessability's Cookie Policy!</p>
  
          <ol>
            <li>
              <strong aria-label="What are Cookies:">What are Cookies</strong>
              <ul>
                <li aria-label="Cookies are small files that are stored on your computer's hard drive. They help analyze web traffic and allow web applications to respond to you as an individual.">
                  Cookies are small files that are stored on your computer's hard drive. They help analyze web traffic and allow web applications to respond to you as an individual.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="How We Use Cookies:">How We Use Cookies</strong>
              <ul>
                <li aria-label="We use traffic log cookies to identify which pages are being used. This helps us analyze data about webpage traffic and improve our website.">
                  We use traffic log cookies to identify which pages are being used. This helps us analyze data about webpage traffic and improve our website.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Types of Cookies:">Types of Cookies</strong>
              <ul>
                <li aria-label="We use both session and persistent cookies. Session cookies are deleted when you close your browser, while persistent cookies remain stored on your device for a set period.">
                  We use both session and persistent cookies. Session cookies are deleted when you close your browser, while persistent cookies remain stored on your device for a set period.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Controlling Cookies:">Controlling Cookies</strong>
              <ul>
                <li aria-label="You can choose to accept or decline cookies. Most web browsers automatically accept cookies, but you can usually modify your browser setting to decline cookies if you prefer.">
                  You can choose to accept or decline cookies. Most web browsers automatically accept cookies, but you can usually modify your browser setting to decline cookies if you prefer.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Third-Party Cookies:">Third-Party Cookies</strong>
              <ul>
                <li aria-label="Our website may use third-party services that employ cookies. We have no control over these cookies.">
                  Our website may use third-party services that employ cookies. We have no control over these cookies.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Links to Other Websites:">Links to Other Websites</strong>
              <ul>
                <li aria-label="Our website may contain links to other websites. Once you use these links to leave our site, we do not have control over that other website. Therefore, we cannot be responsible for the protection and privacy of any information which you provide while visiting such sites.">
                  Our website may contain links to other websites. Once you use these links to leave our site, we do not have control over that other website. Therefore, we cannot be responsible for the protection and privacy of any information which you provide while visiting such sites.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Contact Information:">Contact Information</strong>
              <ul>
                <li aria-label="For any questions regarding our Cookie Policy, please contact us at [contact@accessability.com].">
                  For any questions regarding our Cookie Policy, please contact us at <a :href="'mailto:' + email">[contact@accessability.com]</a>.
                </li>
              </ul>
            </li>
          </ol>
        </v-card-text>
      </v-card>
    </v-container>
  </template>

<!-- <style scoped>
.cookie-policy-card {
    background-color: #F6F3FA;
    font-size: 1rem;
    line-height: 1.5;
    margin-bottom: 2rem; 
    max-width: 75ch;
}
</style> -->

<style scoped>
.cookie-policy-container {
  background-color: #F6F3FA;
  font-size: 1rem; /* 16px */
  line-height: 1.5; /* Interlineado de 1.5 */
  padding: 2rem; /* Añadido para espaciado alrededor del contenido */
  max-width: 75ch;
}

.cookie-policy-card {
  width: 100%; /* Ocupar todo el ancho disponible */
  max-width: none; /* Ancho máximo ilimitado */
  background-color: transparent; /* Fondo transparente para que se aplique el color del contenedor */
}

.cookie-policy-card .v-card-text p {
  margin-bottom: 2rem; /* Separación entre párrafos de 2rem */
  /* Longitud máxima de caracteres por línea */
}
</style>