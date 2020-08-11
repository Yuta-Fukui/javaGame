<template>
  <div v-if="loaded" class="top-title">
    <h1 class="title">
      {{ comment }}
    </h1>
    <div class="space" />
    <h1 class="result">
      正解：{{ correctAnswers }}
    </h1>
    <h2 class="explain">
      解説：{{ selectExplain }}
    </h2>
    <div>
      <button id="btn" @click="question()">
        {{ btn }}
      </button>
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
      comment: '',
      btn: '次の問題へ'
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
        .then(() => {
          if (this.show === true) {
            this.$router.push('/question')
          } else {
            this.$router.push('/results')
          }
        })
    },

    // 全ての問題を回答したらボタンを入れ替える
    isShow () {
      const count = this.$store.state.question.count
      const amountQuestions = this.$store.state.question.amountQuestion
      if (count === amountQuestions) {
        this.show = !this.show
        this.btn = this.show ? '次の問題へ' : '結果画面へ'
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
      // 回答によって正解、不正解を表示する
      this.comment = this.answerShow ? '正解!!!' : '不正解・・・'
    },

    backTop () {
      // 初期化してtopに戻る
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.answers {
  text-align: center;
}

.answer {
  font-weight: bold;
  font-size: 30px;
}
</style>
