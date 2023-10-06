<template>
  <v-footer app class="d-flex no-wrap" color="footer" role="navigation">
    <v-row justify="center" no-gutters>
      <router-link
        v-for="link in links"
        :key="link.text"
        :to="{ name: link.route }"
        class="mx-3 text-h6 custom-button link-content"
        role="link"
        :class="{ 'active-button': isLinkActive(link.route) }"
        :aria-label="link.text"
        :aria-current="isLinkActive(link.route) ? 'page' : null"
      >
        <v-list-item-title class="link-title">{{ link.text }}</v-list-item-title>
      </router-link>
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
        <span class="copyright text-yellow-accent-2">
          © Copyright {{ new Date().getFullYear() }} - Accessibility
        </span>
      </v-col>
    </v-row>
  </v-footer>
</template>

<script setup>
import { ref } from "vue";
import { useRoute } from "vue-router";

const links = ref([
  { text: "Terms of Use", route: "terms-of-use" },
  { text: "Privacy Policy", route: "privacy-policy" },
  { text: "Cookies", route: "cookies" },
]);

const icons = ref(["mdi-twitter", "mdi-linkedin", "mdi-instagram"]);

const getAriaLabel = (icon) => {
  const socialLabels = {
    "mdi-twitter": "Follow us on Twitter",
    "mdi-linkedin": "Connect with us on LinkedIn",
    "mdi-instagram": "Discover our photos on Instagram",
  };
  return socialLabels[icon] || "Social media icons";
};

const router = useRoute();

const isLinkActive = (route) => router.name === route;

</script>

<style scoped>
.link-content {
  color: white;
  text-decoration: none;
}

.link-title {
  transition: color 0.3s, border 0.3s;
}

.link-content:hover .link-title {
  color: #FED636;
  opacity: 2;
  font-size: 1.1rem;
}

.link-content:active .link-title {
  color: #FED636;
}

.custom-button {
  transition: color 0.3s;
  font-size: 1.1rem; 
  padding: 0.5rem 0.5rem; 
}

.custom-button:hover {
  color: #FED636;
}

.active-button {
  color: #FED636;
  font-size: 1.1rem;  
}
</style>

