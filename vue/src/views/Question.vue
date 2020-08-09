<template>
  <!-- // 見本問題を出力する -->
  <div v-if="loaded" class="question">
    <h1>問題{{ isCounted() }}</h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <router-link to="/answer">
      <button @click="answer(selectAnswer1)">
        {{ selectAnswer1 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer(selectAnswer2)">
        {{ selectAnswer2 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer(selectAnswer3)">
        {{ selectAnswer3 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer(selectAnswer4)">
        {{ selectAnswer4 }}
      </button>
    </router-link>
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
      return this.$store.state.question.contents.questionStatement
    },
    selectAnswer1 () {
      return this.$store.state.question.contents.answer1
    },
    selectAnswer2 () {
      return this.$store.state.question.contents.answer2
    },
    selectAnswer3 () {
      return this.$store.state.question.contents.answer3
    },
    selectAnswer4 () {
      return this.$store.state.question.contents.answer4
    },
    loaded () {
      return this.$store.state.question.loaded
    }
  },
  methods: {
    answer (answer) {
      const selectedAnswer = answer
      const questionId = this.$store.state.question.contents.id
      // 正解と解説をDBから持ってくる
      this.$store.dispatch('getAnswer', questionId)

      // 次の画面に回答した答えを持っていく
      this.$store.commit('getAnswer', selectedAnswer)
    },
    // 何回問題を解いたかを数える
    isCounted () {
      this.count = this.$store.state.question.count
      return this.count
    }
  }
}
</script>
