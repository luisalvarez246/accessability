<script setup>
const email = "contact@accessability.com";
</script>

<template>
  <div class="main-container">
    <v-container class="privacy-policy-container bg-white">
      <v-card class="privacy-policy-card bg-transparent" variant="flat">
        <v-card-title class="font-weight-bold text-purple-darken-4"
          >Privacy Policy</v-card-title
        >
        <v-card-item>Welcome to Accessability's Privacy Policy!</v-card-item>
        <v-card-item>
          At Accessability, we are committed to protecting your privacy. This
          Privacy Policy outlines how we collect, use, and protect your personal
          information when you use our website.
        </v-card-item>

        <v-list>
          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >1. Information we collect</v-list-item-title
            >
            <v-list-item>
              We may collect personal information, such as your name, email
              address, and location, when you use our website.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >2. How we use your information:</v-list-item-title
            >
            <v-list-item>
              We use your information to provide and improve our services,
              customize your experience, and send periodic emails.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >3. Security
            </v-list-item-title>
            <v-list-item>
              We are committed to ensuring that your information is secure. We
              have implemented suitable physical, electronic, and managerial
              procedures to safeguard and secure the information we collect
              online.vices, customize your experience, and send periodic emails.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >4. Cookies</v-list-item-title
            >
            <v-list-item>
              Our website uses cookies to analyze browsing preferences. You can
              choose to accept or decline cookies.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >5. Third-party links</v-list-item-title
            >
            <v-list-item>
              Our website may contain links to other websites. We have no
              control over the content and privacy practices of these sites.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >6. Data retention</v-list-item-title
            >
            <v-list-item>
              We retain your personal information for as long as necessary to
              fulfill the purposes outlined in this Privacy Policy unless a
              longer retention period is required by law.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >7. Changes to the Privacy Policy</v-list-item-title
            >
            <v-list-item>
              We may update this Privacy Policy from time to time. Please review
              this page periodically to ensure you are familiar with any
              changes.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar"
              >8. Contact Information</v-list-item-title
            >
            <v-list-item>
              For any questions regarding our Privacy Policy, please contact us
              at
              <a :href="'mailto:' + email">[contact@accessability.com]</a>.
            </v-list-item>
          </v-list-item>
        </v-list>
      </v-card>
    </v-container>
  </div>
</template>

<style scoped>
.privacy-policy-container {
  padding: 2rem;
  max-width: 80ch;
}
</style>
