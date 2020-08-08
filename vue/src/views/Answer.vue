<template>
  <div class="answer">
    <div v-if="!loaded">
      <h1 class="true">
        正解!
      </h1>
      <h1 class="answer">
        正解：A
      </h1>
      <h2>
        解説：こんな感じでいきます
      </h2>
      <router-link to="/question" class="btn_to_question">
        <button @click="question()">
          次の問題へ
        </button>
      </router-link>
    </div>

    <div v-else>
      <h1 v-if="answerShow" class="true">
        正解!
      </h1>
      <h1 v-if="!answerShow" class="false">
        不正解・・・
      </h1>
      <h1 class="answer">
        正解：{{ correctAnswers }}
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
  </div>
</template>

<script>
export default {
  data () {
    return {
      show: true,
      answerShow: true,
      answer: this.$store.state.answer.answer
    }
  },
  computed: {
    correctAnswers () {
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
    return this.getAnswer()
  },

  methods: {
    // 次の問題を出力する
    question () {
      this.$store.dispatch('getQuestion')
      this.$store.commit('clearAnswer')
    },

    // 全ての問題を回答したらボタンを入れ替える
    isShow () {
      const count = this.$store.state.question.count
      if (count % 5 === 0) {
        this.show = !this.show
      }
    },

    // 正解かどうかを判断し、正解ならばカウントする
    getAnswer () {
      if (this.correctAnswers !== this.answer) {
        this.answerShow = false
      } else {
        this.answerShow = true
        this.$store.commit('addCount')
      }
    }
    // confilmAnswer () {
    //   if (this.correctAnswers !== this.answer) {
    //     this.answerShow = false
    //   } else {
    //     this.answerShow = true
    //     this.$store.commit('addCount')
    //   }
    // }
  }
}
</script>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
