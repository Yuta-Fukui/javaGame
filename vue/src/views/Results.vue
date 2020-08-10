<template>
  <div class="results">
    <h1 class="title">
      結果発表！！！
    </h1>
    <h2 class="result">
      あなたの結果は {{ result }} %
    </h2>
    <button class=" start-btn" @click="backTop()">
      スタートに戻る
    </button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      result: ' '
    }
  },
  computed: {
    getCount () {
      return this.$store.state.answer.correctCount
    }
  },
  created () {
    this.isResults()
  },
  methods: {
    isResults () {
      const count = this.$store.state.answer.correctCount
      this.result = count / 5 * 100
    },

    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.results {
  text-align: center;
}

.result {
  font-weight: bold;
  font-size: 30px;
}
</style>
