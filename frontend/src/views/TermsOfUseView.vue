<script setup>
const email = "contact@accessability.com";
</script>

<template>
  <main-container class="main-container py-6">
    <v-container class="terms-use-container">
      <v-card class="privacy-policy-card" variant="flat">
        <h3 class="font-weight-bold text-navbar underline pl-5 py-6">Terms of Use</h3>
        <v-card-item> Welcome to AccessAbility!</v-card-item>

        <v-card-item>
          By accessing and using the AccessAbility website, you agree to comply
          with and be bound by the following terms and conditions of use. If you
          disagree with any part of these terms, please do not use our
          website.</v-card-item>

        <v-list>
          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">1. Acceptance of terms</v-list-item-title>
            <v-list-item>
              By using our website, you agree to be legally bound by these Terms
              of Use. If you do not agree to these terms, please do not use our
              website.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">
              2. Use of the website</v-list-item-title>

            <v-list-item>
              The content of the pages of this website is for your general
              information and use only. It is subject to change without notice.
            </v-list-item>

            <v-list-item>
              Your use of any information or materials on this website is
              entirely at your own risk, for which we shall not be liable.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">3. User responsibilities</v-list-item-title>

            <v-list-item>
              You are responsible for ensuring that any information or services
              available through this website meet your specific requirements.
            </v-list-item>

            <v-list-item>
              Unauthorized use of this website may give rise to a claim for
              damages and/or be a criminal offense.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">4. Intellectual property</v-list-item-title>

            <v-list-item>
              This website contains material which is owned by or licensed to
              us. This material includes, but is not limited to, the design,
              layout, look, appearance, and graphics.
            </v-list-item>

            <v-list-item>
              Reproduction is prohibited unless otherwise stated.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">5. Limitation of liability</v-list-item-title>

            <v-list-item>
              Your use of any information or materials on this website is
              entirely at your own risk, for which we shall not be liable.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">6. User conduct</v-list-item-title>
            <v-list-item>
              You agree to use the website in accordance with all applicable
              laws and regulations.
            </v-list-item>
                <v-list-item> 
              You also agree not to:
            </v-list-item>

            <v-list-item class="custom-list-item">
              Use the website for any unlawful purpose.
            </v-list-item>

            <v-list-item class="custom-list-item">
              Engage in any conduct that could damage, disable, or overburden
              the website.
            </v-list-item>

            <v-list-item class="custom-list-item">
              Attempt to gain unauthorized access to any part of the website.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">7. Termination of access</v-list-item-title>

            <v-list-item>
              Accessibility reserves the right to terminate or restrict access
              to the website for any reason, without notice.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">8. Privacy Policy</v-list-item-title>

            <v-list-item>
              Please review our Privacy Policy to understand our practices
              regarding personal information.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">8. Changes to Terms
            </v-list-item-title>

            <v-list-item>
              Accessability reserves the right to change these terms at any time
              by updating this page. You should check this page periodically to
              ensure that you are aware of any changes.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title class="font-weight-bold text-navbar">9. Contact information
            </v-list-item-title>

            <v-list-item>
              For any questions regarding these terms, please contact us at
              <a :href="'mailto:' + email">[contact@accessability.com]</a>.
            </v-list-item>
          </v-list-item>
        </v-list>
      </v-card>
    </v-container>
</main-container>
</template>

<style scoped>
.terms-use-container {
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
  background: #FED636;
  bottom: 0.25rem;
  content: "";
  display: block;
  height: 0.25rem;
  left: 5;
  position: absolute;
  width: 4rem;
}
.custom-list-item::before {
  content: "•";
  margin-right: 1rem;
  color: #340458;
  font-size: 2rem;
  vertical-align: text-top;
}
</style>
