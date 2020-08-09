<template>
  <div v-if="loaded">
    <h1 class="title">
      {{ comment }}
    </h1>
    <h1 class="answer">
      正解：{{ correctAnswers }}
    </h1>
    <h2 class="explain">
      解説：{{ selectExplain }}
    </h2>
    <template class="">
        <button @click="question()" class="btn_to_question">
          {{ btn }}
        </button>
        <button @click="backTop()">
          Topへ戻る
        </button>
    </template>
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
      if (count === 5) {
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

      this.comment = this.answerShow ? '正解' : '不正解'
    },

    backTop () {
      this.$store.commit('initCount')
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
.title{
  font-weight: bold;
  font-size: 50px;
  color: black;
  padding-top: 40px;
}
.answer {
  font-weight: bold;
  font-size: 30px;
}

button {
  display: inline-block;
  padding: 7px 20px;
  border-radius: 25px;
  text-decoration: none;
  color: #FFF;
  background-color: black;
  transition: .4s;
  margin: 0 5vw;
}
</style>
