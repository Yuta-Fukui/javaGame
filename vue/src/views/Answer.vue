<template>
  <div v-if="loaded" class="title-top">
    <p class="title">
      {{ comment }}
    </p>
    <div>
      <h1 class="result">
      正解：{{ correctAnswers }}
      </h1>
      <h2 class="ex explain">
        解説：{{ selectExplain }}
      </h2>
    </div>
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
      this.$store.dispatch('updateQuestion')
        .then(() => {
          // 回答数によって画面遷移を変更する
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
      // 回答数によってボタンを変更する
      if (count === amountQuestions) {
        this.show = !this.show
        // 問題を解き終わったら結果画面に移動する
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

    // 初期化してtopに戻る
    backTop () {
      this.$store.commit('initCount')
      this.$store.commit('initCorrectCount')
      this.$router.push('/')
    }
  }
}
</script>
