<script setup>
const email = 'contact@accessability.com';
</script>

<template>
    <v-container>
      <v-card>
        <v-card-title class="headline">Privacy Policy</v-card-title>
        <v-card-text>
          <p>Welcome to Accessability's Privacy Policy!</p>
          <p>
            At Accessability, we are committed to protecting your privacy. This Privacy Policy outlines how we collect, use, and protect your personal information when you use our website.
          </p>
  
          <ol>
            <li>
              <strong aria-label="Information We Collect:">Information We Collect</strong>
              <ul>
                <li aria-label="We may collect personal information, such as your name, email address, and location, when you use our website.">
                  We may collect personal information, such as your name, email address, and location, when you use our website.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="How We Use Your Information:">How We Use Your Information</strong>
              <ul>
                <li aria-label="We use your information to provide and improve our services, customize your experience, and send periodic emails.">
                  We use your information to provide and improve our services, customize your experience, and send periodic emails.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Security:">Security</strong>
              <ul>
                <li aria-label="We are committed to ensuring that your information is secure. We have implemented suitable physical, electronic, and managerial procedures to safeguard and secure the information we collect online.">
                  We are committed to ensuring that your information is secure. We have implemented suitable physical, electronic, and managerial procedures to safeguard and secure the information we collect online.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Cookies:">Cookies</strong>
              <ul>
                <li aria-label="Our website uses cookies to analyze browsing preferences. You can choose to accept or decline cookies.">
                  Our website uses cookies to analyze browsing preferences. You can choose to accept or decline cookies.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Third-Party Links:">Third-Party Links</strong>
              <ul>
                <li aria-label="Our website may contain links to other websites. We have no control over the content and privacy practices of these sites.">
                  Our website may contain links to other websites. We have no control over the content and privacy practices of these sites.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Data Retention:">Data Retention</strong>
              <ul>
                <li aria-label="We retain your personal information for as long as necessary to fulfill the purposes outlined in this Privacy Policy unless a longer retention period is required by law.">
                  We retain your personal information for as long as necessary to fulfill the purposes outlined in this Privacy Policy unless a longer retention period is required by law.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Changes to the Privacy Policy:">Changes to the Privacy Policy</strong>
              <ul>
                <li aria-label="We may update this Privacy Policy from time to time. Please review this page periodically to ensure you are familiar with any changes.">
                  We may update this Privacy Policy from time to time. Please review this page periodically to ensure you are familiar with any changes.
                </li>
              </ul>
            </li>
  
            <li>
              <strong aria-label="Contact Information:">Contact Information</strong>
              <ul>
                <li aria-label="For any questions regarding our Privacy Policy, please contact us at [contact@accessability.com].">
                  For any questions regarding our Privacy Policy, please contact us at <a :href="'mailto:' + email">[contact@accessability.com]</a>.
                </li>
              </ul>
            </li>
          </ol>
        </v-card-text>
      </v-card>
    </v-container>
  </template>
  
  
  
  