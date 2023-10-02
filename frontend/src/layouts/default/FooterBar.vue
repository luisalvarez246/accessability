<script setup>
import { ref } from "vue";

const links = ref([
  { text: "Terms of Use", route: "terms-of-use" },
  { text: "Privacy Policy", route: "privacy-policy" },
  { text: "Cookies", route: "cookies" },
]);

const icons = ref(["mdi-facebook", "mdi-linkedin", "mdi-instagram"]);

const getAriaLabel = (icon) => {
  const socialLabels = {
    "mdi-facebook": "Follow us on Facebook",
    "mdi-linkedin": "Connect with us on LinkedIn",
    "mdi-instagram": "Discover our photos on Instagram",
  };
  return socialLabels[icon] || "Social media icons";
};
</script>

<template>
  <v-footer app class="d-flex no-wrap" color="footer">
    <v-row justify="center" no-gutters>
      <v-btn
        v-for="link in links"
        :key="link"
        color="white"
        variant="text"
        class="mx-3 text-h6"
        rounded="xl"
        role="link"
      >
        <router-link :to="{ name: link.route }">
          <span class="link-content"> {{ link.text }}</span>
        </router-link>
      </v-btn>
    </v-row>

    <v-row justify="start" no-gutters>
      <v-icon
        v-for="icon in icons"
        :key="icon"
        class="mx-5 my-2 social-icon"
        :icon="icon"
        variant="plain"
        size="30"
        color="yellow-accent-2"
        :aria-label="getAriaLabel(icon)"
      ></v-icon>
    </v-row>

    <v-row justify="center" no-gutters>
      <v-col class="text-center mt-4" cols="12">
        <span class="copyright text-yellow-accent-2 text-h7">
          © Copyright {{ new Date().getFullYear() }} - Accessability</span
        >
      </v-col>
    </v-row>
  </v-footer>
</template>

<style scoped>
.link-content {
  color: white;
  }

.link-content:hover {
  color: #26c6da;
}

</style>
