<template>
  <div class="main-container py-6">
    <v-container class="cookie-policy-container">
      <v-card class="cookie-policy-card" variant="flat">
        <h3 class="font-weight-bold text-navbar underline pl-5 py-6">
          Cookies policy
        </h3>
        <v-card-item> Welcome to AccessAbility's Cookies policy!</v-card-item>

        <v-list>
          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >1. What are cookies</v-list-item-title
            >
            <v-list-item>
              Cookies are small files that are stored on your computer's hard
              drive. They help analyze web traffic and allow web applications to
              respond to you as an individual.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >2. How we use cookies</v-list-item-title
            >
            <v-list-item>
              We use traffic log cookies to identify which pages are being used.
              This helps us analyze data about webpage traffic and improve our
              website.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >3. Types of cookies</v-list-item-title
            >
            <v-list-item>
              We use both session and persistent cookies. Session cookies are
              deleted when you close your browser, while persistent cookies
              remain stored on your device for a set period.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >4. Controlling cookies</v-list-item-title
            >
            <v-list-item>
              You can choose to accept or decline cookies. Most web browsers
              automatically accept cookies, but you can usually modify your
              browser setting to decline cookies if you prefer.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >5. Third-party cookies</v-list-item-title
            >
            <v-list-item>
              Our website may use third-party services that employ cookies. We
              have no control over these cookies.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >6. Links to other websites</v-list-item-title
            >
            <v-list-item>
              Our website may contain links to other websites. Once you use
              these links to leave our site, we do not have control over that
              other website. Therefore, we cannot be responsible for the
              protection and privacy of any information which you provide while
              visiting such sites.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >7. Contact information</v-list-item-title
            >
            <v-list-item>
              For any questions regarding our Cookies policy, please contact us
              at <a :href="'mailto:' + email">contact@accessability.com</a>.
            </v-list-item>
          </v-list-item>
        </v-list>
      </v-card>
    </v-container>
  </div>
</template>

<script setup>
const email = "contact@accessability.com";
</script>

<style scoped>
.cookie-policy-container {
  max-width: 80ch;
  letter-spacing: 0.0125rem;
}

.underline {
  position: relative;
}

h3 {
  font-size: 1.5rem;
}

h3.underline::after {
  background: #fed636;
  bottom: 0.25rem;
  content: "";
  display: block;
  height: 0.25rem;
  left: 5;
  position: absolute;
  width: 4rem;
}
</style>
