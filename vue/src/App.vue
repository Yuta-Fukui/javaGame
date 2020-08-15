<template>
  <div id="app">
    <html>
      <head></head>
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
  metaInfo: {
    title: '20クイズ',
    name: 'robots',
    content: 'noindex'
  },
  methods: {
    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
