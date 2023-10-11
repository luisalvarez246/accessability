<template>
  <div class="main-container py-6">
    <v-container class="accessibility-container">
      <v-card class="accessibility-card" variant="flat">
        <h2 class="font-weight-bold text-navbar underline pl-5 py-5 mx-6">
          Website accessibility statement
        </h2>
        <v-list>
          <v-list-item>
            <v-list-item-title
              class="font-weight-bold text-navbar text-h6 pl-5 py-4"
              >AccessAbility's commitment</v-list-item-title
            >
            <v-list-item>
              At AccessAbility, we are deeply committed to ensuring the utmost
              accessibility of our website.
            </v-list-item>
            <v-list-item>
              We undergo thorough accessibility testing every four months to
              guarantee an inclusive online experience for all users.
            </v-list-item>
            <v-list-item>
              Our aim is to make our website usable by everyone, regardless of
              their impairments or the technologies they rely on.
            </v-list-item>
            <v-list-item>
              In developing the site, we have diligently adhered to best
              practice web accessibility guidelines, including
              <a
                href="https://www.w3.org/TR/WCAG22/"
                aria-describedby="new-window-1"
                rel="no-follow"
                >WCAG 2.2</a
              >.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title
              class="font-weight-bold text-navbar text-h6 pl-5 py-4"
              >Customising your experience to your needs</v-list-item-title
            >
            <v-list-item>
              We have designed the site to be user-friendly, but you can improve
              your experience by adjusting your computer settings to fit your
              preferences.
            </v-list-item>
            <v-list-item>
              For example consider modifying the site's colors, increasing text
              size, or having the content spoken aloud.
            </v-list-item>
            <v-list-item>
              To explore further customization using accessibility features on
              your computer or by installing additional assistive technologies,
              consult the following resources:
            </v-list-item>
            <v-list-item>
              Web Accessibility Initiative's:
              <a
                href="https://www.w3.org/WAI/users/browsing"
                aria-describedby="new-window-1"
                rel="nofollow"
                >Better web browsing: Tips for customizing your computer</a
              >.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title
              class="font-weight-bold text-navbar text-h6 pl-5 py-4"
              >Known accessibility issues</v-list-item-title
            >
            <v-list-item>
              We acknowledge that there are some existing accessibility issues
              with our site, and we are actively working to rectify them.
            </v-list-item>
            <v-list-item>
              Our current focus includes addressing the following concerns:
            </v-list-item>
            <v-list-item class="custom-list-item">
              Some websites we link may not have undergone accessibility
              testing.
            </v-list-item>
            <v-list-item class="custom-list-item">
              The cookies banner may remain accessible to screen readers when
              closed and visually unnoticeable.
            </v-list-item>
            <v-list-item>
              If any of these issues hinder your access to the information or
              services you seek, please contact us, and we will promptly assist
              you.
            </v-list-item>
          </v-list-item>

          <v-list-item>
            <v-list-item-title
              class="font-weight-bold text-navbar text-h6 pl-5 py-4"
              >Contact us for support</v-list-item-title
            >
            <v-list-item>
              We are dedicated to continual improvement in the accessibility of
              our site. If you encounter any challenges while using our site,
              please contact us at
              <a :href="'mailto:' + email">contact@accessability.com</a>.
            </v-list-item>
            <v-list-item>
              We welcome all constructive feedback regarding the accessibility
              and usability of our site and assure you that we will thoroughly
              consider and act upon it.
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
.accessibility-container {
  max-width: 80ch;
  letter-spacing: 0.0125rem;
}

.underline {
  position: relative;
}

h2.underline::after {
  background: #fed636;
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
