<template>
  <div class="title-top">
    <h1 class="title">
      結果発表！！！
    </h1>
    <h2 class="result">
      あなたの結果は {{ result }} %
    </h2>
    <p class="result">
      {{ comment }}
    </p>
    <button class="start-btn" @click="backTop()">
      スタートに戻る
    </button>
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
    metaInfo: {
      title: '20クイズ',
      name: 'robots',
      content: 'noindex'
    },
    isResults () {
      const count = this.$store.state.answer.correctCount
      const amountQuestions = this.$store.state.question.amountQuestion
      const score = count / amountQuestions * 100
      this.result = Math.floor(score)
      if (this.result === 100) {
        this.comment = 'これで君も20マスターだ!!!'
      } else if (this.result >= 80) {
        this.comment = 'あと少し！次こそ100%だ！'
      } else if (this.result >= 50) {
        this.comment = '諦めないで、もう一度チャレンジだ！'
      } else {
        this.comment = 'あれれ？？今日は体調悪いのかな？'
      }
    },

    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
