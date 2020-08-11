<template>
  <div v-if="loaded" class="top-title">
    <h1 class="title">
      問題{{ isCounted() }}
    </h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <div class="space" />
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
  data () {
    return {
      count: 0
    }
  },
  computed: {
    selectQuestion () {
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

    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
