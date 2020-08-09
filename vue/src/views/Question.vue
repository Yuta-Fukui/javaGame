<template>
  <div v-if="loaded">
    <h1 class="title">問題{{ isCounted() }}</h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <template v-for="(item, index) in computedChoices">
      <button :key="index" @click="answer(item)">
        {{ item }}
      </button>
    </template>
    <button @click="backTop()">
          Topへ戻る
    </button>
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
      this.$router.push('/')
    }
  }
}
</script>

<style>
.title{
  font-weight: bold;
  font-size: 50px;
  color: black;
  padding-top: 40px;
}
.question {
  font-weight: bold;
  font-size: 30px;
  margin-top: 5vw;
}

button {
  display: inline-block;
  padding: 7px 20px;
  border-radius: 25px;
  text-decoration: none;
  color: #FFF;
  background-color: black;
  transition: .4s;
  margin:3vw 5vw 0 5vw;
}
</style>
