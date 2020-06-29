<template>
  <div v-if="loaded" class="question">
    <h1>問題{{ count() }}</h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <router-link to="/answer">
      <button @click="answer()">
        {{ selectAnswer1 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer()">
        {{ selectAnswer2 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer()">
        {{ selectAnswer3 }}
      </button>
    </router-link>
    <router-link to="/answer">
      <button @click="answer()">
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
    answer () {
    // const id = this.$store.state.answer.id
      const questionId = this.$store.state.question.contents.id
      this.$store.dispatch('getAnswer', questionId)
    },
    count () {
      return this.$store.state.question.count
    }
  }
}
</script>
