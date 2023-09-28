<!-- eslint-disable vue/multi-word-component-names -->
<script setup>
const email = 'contact@accessability.com';
</script>

<template>
    <v-container class="cookie-policy-container" style="background-color:#F6F3FA">
      <v-card class="cookie-policy-card" variant="flat" style="background-color: transparent">
        <v-card-title class="font-weight-bold" aria-label="cookie oolicy">Cookie Policy</v-card-title>
        <v-card-item aria-label="Welcome to accessability's cookie policy!">Welcome to Accessability's Cookie Policy!</v-card-item>
  
        <v-list bg-color="#F6F3FA">
        
        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="What are cookies:">1. What are cookies</v-list-item-title>
            <v-list-item aria-label="Cookies are small files that are stored on your computer's hard drive. They help analyze web traffic and allow web applications to respond to you as an individual.">
              Cookies are small files that are stored on your computer's hard drive. They help analyze web traffic and allow web applications to respond to you as an individual.
            </v-list-item>
        </v-list-item>

        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="How we use cookies:">2. How we use cookies</v-list-item-title>
            <v-list-item aria-label="We use traffic log cookies to identify which pages are being used. This helps us analyze data about webpage traffic and improve our website.">
              We use traffic log cookies to identify which pages are being used. This helps us analyze data about webpage traffic and improve our website.
            </v-list-item>
        </v-list-item>
            
        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="Types of cookies:">3. Types of cookies</v-list-item-title>
            <v-list-item aria-label="We use both session and persistent cookies. Session cookies are deleted when you close your browser, while persistent cookies remain stored on your device for a set period.">
              We use both session and persistent cookies. Session cookies are deleted when you close your browser, while persistent cookies remain stored on your device for a set period.
            </v-list-item>
        </v-list-item>
            
        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="Controlling cookies:">4. Controlling cookies</v-list-item-title>
            <v-list-item aria-label="You can choose to accept or decline cookies. Most web browsers automatically accept cookies, but you can usually modify your browser setting to decline cookies if you prefer.">
              You can choose to accept or decline cookies. Most web browsers automatically accept cookies, but you can usually modify your browser setting to decline cookies if you prefer.
            </v-list-item>
        </v-list-item>
            
        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="Third-party cookies:">5. Third-party cookies</v-list-item-title>
            <v-list-item aria-label="Our website may use third-party services that employ cookies. We have no control over these cookies.">
              Our website may use third-party services that employ cookies. We have no control over these cookies.
            </v-list-item>
        </v-list-item>
    
        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="Links to other websites:">6. Links to other websites</v-list-item-title>
            <v-list-item aria-label="Our website may contain links to other websites. Once you use these links to leave our site, we do not have control over that other website. Therefore, we cannot be responsible for the protection and privacy of any information which you provide while visiting such sites.">
              Our website may contain links to other websites. Once you use these links to leave our site, we do not have control over that other website. Therefore, we cannot be responsible for the protection and privacy of any information which you provide while visiting such sites.
            </v-list-item>
        </v-list-item>

        <v-list-item>
            <v-list-item-title class="font-weight-bold" aria-label="Contact information:">7. Contact information</v-list-item-title>
            <v-list-item aria-label="For any questions regarding our Cookie Policy, please contact us at [contact@accessability.com].">
              For any questions regarding our Cookie Policy, please contact us at <a :href="'mailto:' + email">[contact@accessability.com]</a>.
            </v-list-item>
        </v-list-item>
          
        </v-list>    
      </v-card>
    </v-container>
  </template>


<style scoped>
.cookie-policy-container {
  font-size: 1rem; 
  line-height: 1.5; 
  padding: 2rem; 
  max-width: 80ch;
  border-radius: 0.5em;
}
</style>