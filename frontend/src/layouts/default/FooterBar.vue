<template>
  <v-footer class="d-flex no-wrap py-4" color="navbar" role="navigation">
    <v-row justify="start" no-gutters >
      <router-link
        v-for="link in links"
        :key="link.text"
        :to="{ name: link.route }"
        class="mx-3 py-2 text-right link-content"
        role="link"
        :class="{ 'active-button': isLinkActive(link.route) }"
        :aria-label="link.text"
        :aria-current="isLinkActive(link.route) ? 'page' : null"
      >
        <v-list-item-title class="link-title">{{ link.text }}</v-list-item-title>
      </router-link>
    </v-row>

    <v-row justify="center" no-gutters>
      <v-icon
        v-for="icon in icons"
        :key="icon"
        tabindex="0"
        class="mx-5 social-icon"
        :icon="icon"
        size="30"
        color="navbarbtns"
        :aria-label="getAriaLabel(icon)"
      ></v-icon>
    </v-row>

    <v-row no-gutters>
      <v-col class="text-right pl-16 pr-4" cols="12">
        <span class="copyright">
          © Copyright {{ new Date().getFullYear() }} - AccessAbility
        </span>
      </v-col>
    </v-row>
  </v-footer>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

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

const router = useRouter();

const isLinkActive = (route) => router.name === route;

</script>

<style scoped>
.link-content {
  color: white;
}
.link-title {
  transition: color 0.3s, border 0.3s;
  letter-spacing: 0.0125rem;
}
.link-content:hover .link-title {
  color: #FED636;
  font-weight: 600;
}
.link-content:active .link-title {
  color: #FED636;
}
.active-button {
  color: #FED636;
}
.copyright {
  letter-spacing: 0.0125rem;
}
</style>

