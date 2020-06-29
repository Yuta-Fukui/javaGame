<template>
  <div v-if="loaded" class="answer">
    <h1 class="true">
      正解!
    </h1>
    <h1 class="answer">
      正解：{{ selectAnswer }}
    </h1>
    <h2>
      解説：{{ selectExplain }}
    </h2>
    <div v-if="returnIf">
      <router-link to="/question" class="btn_to_question">
        <button @click="question()">
          次の問題へ
          {{ count }}
        </button>
      </router-link>
    <!-- <router-link to="/result" class="btn_to_question">
      <button @click="question()">
        結果画面へ
      </button>
    </router-link> -->
    </div>
  </div>
</template>

<script>
// import answer from '../store/modules/answer'
export default {
  data () {
    return {
      count: 0
    }
  },
  computed: {
    selectAnswer () {
      return this.$store.state.answer.contents[0].correctAnswer
    },
    selectExplain () {
      return this.$store.state.answer.contents[0].explanation
    },
    loaded () {
      return this.$store.state.answer.loaded
    },
    returnIf () {
      return this.created !== 4
    }
  },
  created () {
    this.count++
    this.$store.commit('addCount')
    console.log(this.count)
    return this.count
  },
  // mounted: {
  //   // getCount () {
  //   //   this.count++
  //   //   console.log('動け！')
  //   //   if (this.count === 5) {
  //   //     return false
  //   //   } else {
  //   //     return true
  //   //   }
  //   // }
  // },
  // watch: {
  //   getCount: function () {
  //     console.log('動！')
  //     this.judgedCount()
  //   }
  // },
  methods: {
    question () {
      this.$store.dispatch('getQuestion')
      // const count = this.$store.state.question.count
      // console.log(count)
      // if (count % 4 === 0) {
      //   this.countCheck = false
      //   console.log('71は' + this.countCheck + 'です')
      //   return false
      // } else {
      //   this.countCheck = true
      //   return true
      // }
      // return count
    }
    // console () {
    //   console.log('79は' + this.countCheck + 'です')
    // }
  }
  // created: {
  //   answer () {
  //     return this.selectAnswer
  //   },
  //   explanation () {
  //     return this.selectExplain
  //   }
  // }

}
</script>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
