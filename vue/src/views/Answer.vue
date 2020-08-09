<template>
  <div v-if="loaded" class="answer">
    <h1>
      {{ comment }}
    </h1>
    <h1 class="answer">
      正解：{{ correctAnswers }}
    </h1>
    <h2>
      解説：{{ selectExplain }}
    </h2>
    <div v-if="show">
      <router-link to="/question" class="btn_to_question">
        <button @click="question()">
          次の問題へ
        </button>
      </router-link>
    </div>
    <div v-else>
      <router-link to="/results" class="btn_to_question">
        <button @click="question()">
          結果画面へ
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      show: true,
      answerShow: true,
      correctAnswer: '',
      answer: '',
      comment: ''
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
    this.getAnswer()
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
      if (count === 5) {
        this.show = !this.show
      }
    },

    // 正解かどうかを判断し、正解ならばカウントする
    getAnswer () {
      this.correctAnswer = this.$store.state.answer.contents[0].correctAnswer
      this.answer = this.$store.state.answer.answer
      if (this.correctAnswer !== this.answer) {
        this.answerShow = false
      } else {
        this.answerShow = true
        this.$store.commit('addCount')
      }

      this.isShow()

      // console.log('answerShow:' + this.show)
      console.log('正しい答えは' + this.correctAnswer)
      console.log('あなたの答えは' + this.answer)

      this.answerShow ? this.comment = '正解' : this.comment = '不正解'
      return this.comment
    }
  }
}
</script>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
