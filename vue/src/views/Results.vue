<template>
  <div class="results">
    <h1>結果発表！！</h1>
    <div class="result">
      <h2>あなたの結果は</h2>
      <h3>{{ result }} %</h3>
      <h3>{{ comment }}</h3>
    </div>
    <router-link to="/">
      <button class="button">
        スタートに戻る
      </button>
    </router-link>
  </div>
</template>

<script>
export default {
  data () {
    return {
      result: ' ',
      comment: ' '
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
      if (count === 5) {
        this.comment = '天才かよ'
      } else if (count >= 3 && count < 5) {
        this.comment = 'まだまだだね（越前リョーマ風）'
      } else {
        this.comment = 'くそ！！'
      }
    }
  }
}
</script>

<style scoped>
  h1 {
    font-size:100px;
    margin: 0 auto;
  }
  .result {
    margin: 0 auto;
  }
  .button {
   padding: 20px;
   margin: 0 auto;
  }

</style>
