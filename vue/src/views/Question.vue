<template>
  <div v-if="loaded" class="question">
    <h1>問題{{ count() }}</h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <router-link to="/answer">
      <button @click="answer('answer1')">
        {{ selectAnswer1 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer('answer2')">
        {{ selectAnswer2 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer('answer3')">
        {{ selectAnswer3 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer('answer4')">
        {{ selectAnswer4 }}
      </button>
    </router-link>
  </div>
</template>

<script>
export default {
  data () {
    return {
      URI: "location.href='/answer'"
    }
  },
  computed: {
    selectQuestion () {
      return this.$store.state.question.contents.questionStatement
    },
    selectAnswer1 () {
      return this.$store.state.question.contents.answer1 == 'answer1';
    },
    selectAnswer2 () {
      return this.$store.state.question.contents.answer2 === 'answer2'
    },
    selectAnswer3 () {
      return this.$store.state.question.contents.answer3 === 'answer3'
    },
    selectAnswer4 () {
      return this.$store.state.question.contents.answer4 === 'answer4'
    },
    loaded () {
      return this.$store.state.question.loaded
    }
  },
  methods: {
    answer (answer) {
      const selectedAnswer = answer
      const questionId = this.$store.state.question.contents.id
      console.log(selectedAnswer)
      this.$store.dispatch('getAnswer', questionId)
      this.$store.commit('getAnswer', selectedAnswer)
    },
    count () {
      const count = this.$store.state.question.count
      return count
    }
  }
}
</script>
