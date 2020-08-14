<template>
  <div id="app">
    <!-- <div class="bg"></div>
    <div class="bg bg2"></div>
    <div class="bg bg3"></div> -->
    <html>
      <body>
        <button class="back start-btn" @click="backTop()">
          TOP
        </button>
        <div id="nav" />
        <router-view />
      </body>
    </html>
  </div>
</template>

<script>
export default {
  methods: {
    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
