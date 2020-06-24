<template>
  <div class="answer">
    <h1 class="true">
      正解!
    </h1>
    <h1 class="answer">
      答えは + {{ selectAnswer }}
    </h1>
    <h2>
      解説： + {{ selectExplain }}
    </h2>
    <router-link to="/question" class="btn_to_question">
      次の問題へ
    </router-link>
  </div>
</template>

<script>
// import answer from '../store/modules/answer'
export default {
  computed: {
    selectAnswer () {
      return this.$store.state.answer.correctAnswer
    },
    selectExplain () {
      return this.$store.state.answer.explanation
    }

  }
}
</script>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
