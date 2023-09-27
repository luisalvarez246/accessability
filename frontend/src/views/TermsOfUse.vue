<script setup>
const email = "contact@accessability.com";
</script>

<template>
  <v-container background-color: F6F3FA>
    <v-card>
      <v-card-title class="headline">Terms of Use</v-card-title>
      <v-card-text>
        <p>Welcome to Accessability!</p>
        <p>
          By accessing and using the Accessability website, you agree to comply
          with and be bound by the following terms and conditions of use. If you
          disagree with any part of these terms, please do not use our website.
        </p>

        <ol>
          <li>
            <strong aria-label="Acceptance of Terms:"
              >Acceptance of Terms</strong
            >
            <ul>
              <li
                aria-label="By using our website, you agree to be legally bound by these Terms of Use. If you do not agree to these terms, please do not use our website."
              >
                By using our website, you agree to be legally bound by these
                Terms of Use. If you do not agree to these terms, please do not
                use our website.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Use of the Website:"
              >Use of the Website</strong
            >
            <ul>
              <li
                aria-label="The content of the pages of this website is for your general information and use only. It is subject to change without notice."
              >
                The content of the pages of this website is for your general
                information and use only. It is subject to change without
                notice.
              </li>
              <li
                aria-label="Your use of any information or materials on this website is entirely at your own risk, for which we shall not be liable."
              >
                Your use of any information or materials on this website is
                entirely at your own risk, for which we shall not be liable.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="User Responsibilities:"
              >User Responsibilities</strong
            >
            <ul>
              <li
                aria-label="You are responsible for ensuring that any information or services available through this website meet your specific requirements."
              >
                You are responsible for ensuring that any information or
                services available through this website meet your specific
                requirements.
              </li>
              <li
                aria-label="Unauthorized use of this website may give rise to a claim for damages and/or be a criminal offense."
              >
                Unauthorized use of this website may give rise to a claim for
                damages and/or be a criminal offense.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Intellectual Property:"
              >Intellectual Property</strong
            >
            <ul>
              <li
                aria-label="This website contains material which is owned by or licensed to us. This material includes, but is not limited to, the design, layout, look, appearance, and graphics."
              >
                This website contains material which is owned by or licensed
                to us. This material includes, but is not limited to, the
                design, layout, look, appearance, and graphics.
              </li>
              <li
                aria-label="Reproduction is prohibited unless otherwise stated."
              >
                Reproduction is prohibited unless otherwise stated.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Limitation of Liability:">Limitation of Liability</strong
            >
            <ul>
              <li
                aria-label="Your use of any information or materials on this website is entirely at your own risk, for which we shall not be liable."
              >
                Your use of any information or materials on this website is
                entirely at your own risk, for which we shall not be liable.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="User Conduct:">User Conduct</strong>
            <ul>
              <li
                aria-label="You agree to use the website in accordance with all applicable laws and regulations. You also agree not to:"
              >
                You agree to use the website in accordance with all applicable
                laws and regulations. You also agree not to:
              </li>
              <li aria-label="Use the website for any unlawful purpose.">
                Use the website for any unlawful purpose.
              </li>
              <li
                aria-label="Engage in any conduct that could damage, disable, or overburden the website."
              >
                Engage in any conduct that could damage, disable, or
                overburden the website.
              </li>
              <li
                aria-label="Attempt to gain unauthorized access to any part of the website."
              >
                Attempt to gain unauthorized access to any part of the
                website.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Termination of Access:"
              >Termination of Access</strong
            >
            <ul>
              <li
                aria-label="Accessability reserves the right to terminate or restrict access to the website for any reason, without notice."
              >
                Accessibility reserves the right to terminate or restrict
                access to the website for any reason, without notice.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Privacy Policy:">Privacy Policy</strong>
            <ul>
              <li
                aria-label="Please review our Privacy Policy to understand our practices regarding personal information."
              >
                Please review our Privacy Policy to understand our practices
                regarding personal information.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Changes to Terms:">Changes to Terms</strong>
            <ul>
              <li
                aria-label="Accessability reserves the right to change these terms at any time by updating this page. You should check this page periodically to ensure that you are aware of any changes."
              >
                Accessability reserves the right to change these terms at any
                time by updating this page. You should check this page
                periodically to ensure that you are aware of any changes.
              </li>
            </ul>
          </li>

          <li>
            <strong aria-label="Contact Information:"
              >Contact Information</strong
            >
            <ul>
              <li
                aria-label="For any questions regarding these terms, please contact us at [contact@accessability.com]."
              >
                For any questions regarding these terms, please contact us at
                <a :href="'mailto:' + email">[contact@accessability.com]</a>.
              </li>
            </ul>
          </li>
        </ol>
      </v-card-text>
    </v-card>
  </v-container>
</template>