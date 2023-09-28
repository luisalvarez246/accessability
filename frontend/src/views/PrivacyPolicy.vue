<script setup>
const email = "contact@accessability.com";
</script>

<template>
  <v-container
    class="privacy-policy-container"
    style="background-color: #f6f3fa"
  >
    <v-card variant="flat" style="background-color: transparent">
      <v-card-title class="font-weight-bold" aria-label="privacy policy"
        >Privacy Policy</v-card-title
      >
      <v-card-item aria-label="Welcome to accessability's privacy policy!"
        >Welcome to Accessability's Privacy Policy!</v-card-item
      >
      <v-card-item
        aria-label="At Accessability, we are committed to protecting your privacy. This Privacy Policy outlines how we collect, use, and protect your personal information when you use our website"
      >
        At Accessability, we are committed to protecting your privacy. This
        Privacy Policy outlines how we collect, use, and protect your personal
        information when you use our website.
      </v-card-item>

      <v-list bg-color="#F6F3FA">
        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="Information we collect:"
            >1. Information we collect</v-list-item-title
          >
          <v-list-item
            aria-label="We may collect personal information, such as your name, email address, and location, when you use our website."
          >
            We may collect personal information, such as your name, email
            address, and location, when you use our website.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="How we use your information:"
            >2. How we use your information:</v-list-item-title
          >
          <v-list-item
            aria-label="We use your information to provide and improve our services, customize your experience, and send periodic emails."
          >
            We use your information to provide and improve our services,
            customize your experience, and send periodic emails.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title class="font-weight-bold" aria-label="Security:"
            >3. Security
          </v-list-item-title>
          <v-list-item
            aria-label="We are committed to ensuring that your information is secure. We have implemented suitable physical, electronic, and managerial procedures to safeguard and secure the information we collect online."
          >
            We are committed to ensuring that your information is secure. We
            have implemented suitable physical, electronic, and managerial
            procedures to safeguard and secure the information we collect
            online.vices, customize your experience, and send periodic emails.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title class="font-weight-bold" aria-label="Cookies:"
            >4. Cookies</v-list-item-title
          >
          <v-list-item
            aria-label="Our website uses cookies to analyze browsing preferences. You can choose to accept or decline cookies."
          >
            Our website uses cookies to analyze browsing preferences. You can
            choose to accept or decline cookies.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="Third-party links:"
            >5. Third-party links</v-list-item-title
          >
          <v-list-item
            aria-label="Our website may contain links to other websites. We have no control over the content and privacy practices of these sites."
          >
            Our website may contain links to other websites. We have no control
            over the content and privacy practices of these sites.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="Data retention:"
            >6. Data retention</v-list-item-title
          >
          <v-list-item
            aria-label="We retain your personal information for as long as necessary to fulfill the purposes outlined in this Privacy Policy unless a longer retention period is required by law."
          >
            We retain your personal information for as long as necessary to
            fulfill the purposes outlined in this Privacy Policy unless a longer
            retention period is required by law.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="Changes to the privacy policy:"
            >7. Changes to the Privacy Policy</v-list-item-title
          >
          <v-list-item
            aria-label="We may update this Privacy Policy from time to time. Please review this page periodically to ensure you are familiar with any changes."
          >
            We may update this Privacy Policy from time to time. Please review
            this page periodically to ensure you are familiar with any changes.
          </v-list-item>
        </v-list-item>

        <v-list-item>
          <v-list-item-title
            class="font-weight-bold"
            aria-label="Contact information:"
            >8. Contact Information</v-list-item-title
          >
          <v-list-item
            aria-label="For any questions regarding our Privacy Policy, please contact us at [contact@accessability.com]."
          >
            For any questions regarding our Privacy Policy, please contact us at
            <a :href="'mailto:' + email">[contact@accessability.com]</a>.
          </v-list-item>
        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
</template>

<style scoped>
.privacy-policy-container {
  font-size: 1rem;
  line-height: 1.5;
  padding: 2rem;
  max-width: 80ch;
  border-radius: 0.5em;
}
</style>
