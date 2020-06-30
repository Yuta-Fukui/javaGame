<template>
  <div v-if="loaded" class="answer">
    <h1 v-if="answerShow" class="true">
      正解!
    </h1>
    <h1 v-if="!answerShow" class="false">
      不正解・・・
    </h1>
    <h1 class="answer">
      正解：{{ selectAnswer }}
    </h1>
    <h2>
      解説：{{ selectExplain }}
    </h2>
    <div>
      <router-link to="/question" class="btn_to_question">
        <button v-if="show" @click="question()">
          次の問題へ
        </button>
      </router-link>
      <router-link to="/results" class="btn_to_question">
        <button v-if="!show" @click="question()">
          結果画面へ
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  // data: () => ({
  //   show: true
  // }),
  data () {
    return {
      show: true,
      answerShow: true
    }
  },
  computed: {
    selectAnswer () {
      return this.$store.state.answer.contents[0].correctAnswer
    },
    selectExplain () {
      return this.$store.state.answer.contents[0].explanation
    },
    loaded () {
      return this.$store.state.answer.loaded
    }
  },
  created () {
    const count = this.$store.state.question.count
    const correctAnswer = this.$store.state.answer.contents[0].correctAnswer
    const answer = this.$store.state.answer.answer
    console.log(correctAnswer)
    if (count % 5 === 0) {
      this.show = !this.show
    }
    if (this.correctAnswer !== answer) {
      this.answerShow = false
    }
  },

  methods: {
    question () {
      this.$store.dispatch('getQuestion')
    }
  }
}
</script>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
