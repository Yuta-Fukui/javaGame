<template>
  <div v-if="loaded" class="title-top">
    <h1 class="title">
      問題{{ isCounted() }}
    </h1>
    <p class="question countdown">
      残り {{ timerCount }}秒
    </p>
    <p class="question">
      出題者：{{ setName }}
      <br>
      問題：{{ setQuestion }}
    </p>
    <div>
      <template v-for="item in computedChoices" id="question-btn">
        <button id="btn" :key="item" @click="answer(item)">
          {{ item }}
        </button>
      </template>
    </div>
  </div>
</template>

<script>
export default {
  metaInfo: {
    title: '20クイズ',
    name: 'robots',
    content: 'noindex'
  },
  data () {
    return {
      count: 0,
      timerCount: 30
    }
  },
  created () {
    setInterval(() => { this.timerCount-- }, 1000)
  },
  watch: {
    timerCount: function (val) {
      if (val <= 0) {
        this.answer()
      }
    }
  },
  computed: {
    setName () {
      return this.$store.state.question.name
    },
    setQuestion () {
      return this.$store.state.question.questionStatement
    },
    loaded () {
      return this.$store.state.question.loaded
    },
    computedChoices () {
      return this.$store.state.question.choices
    }
  },
  methods: {
    answer (answer) {
      const selectedAnswer = answer
      const questionId = this.$store.state.question.questionId
      // 正解と解説をDBから持ってくる
      this.$store.dispatch('getAnswer', questionId)
        .then(() => {
          this.$router.push('/answer')
        })
      // 次の画面に回答した答えを持っていく
      this.$store.commit('setAnswer', selectedAnswer)
    },

    // 何回問題を解いたかを数える
    isCounted () {
      this.count = this.$store.state.question.count
      return this.count
    },

    // topに戻る
    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
