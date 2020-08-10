<template>
  <div v-if="loaded" id="questions">
    <h1 class="title">
      問題{{ isCounted() }}
    </h1>
    <p class="question">
      {{ selectQuestion }}
    </p>
    <div class="space" />
    <div>
      <template v-for="(item, index) in computedChoices" id="question-btn">
        <button id="btn" :key="index" @click="answer(item)">
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

<style>
.questions {
  text-align: center;
}

.question {
  font-weight: bold;
  font-size: 30px;
  text-align: center;
}

#btn {
    text-align: center;
    width: 300px;
    border: none;
    padding: 15px 20px;
    margin: 15px auto;
    letter-spacing: 1px;
    font-weight: 700;
    display: block;
    outline: none;
    position: relative;
    -webkit-transition: all 0.3s;
    -moz-transition: all 0.3s;
    transition: all 0.3s;
    background: #f78d1b;
    color: #fff;
    box-shadow: 0 6px #b45f0a;
    -webkit-transition: none;
    -moz-transition: none;
    transition: none;
    border-radius: 5px;
    opacity: 0.8;
}

#btn:hover {
  opacity: 1;
}

.space {
  height: 3vw;
}
</style>
