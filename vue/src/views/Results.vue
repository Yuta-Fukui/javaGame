<template>
  <div>
    <h1 class="title"> 結果発表！！！</h1>
    <h2 class="result"> あなたの結果は {{ result }} %</h2>
    <button @click="backTop()">
      スタートに戻る
    </button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      result: ' '
    }
  },
  computed: {
    getCount () {
      return this.$store.state.answer.correctCount
    }
  },
  created () {
    this.isResults()
  },
  methods: {
    isResults () {
      const count = this.$store.state.answer.correctCount
      this.result = count / 5 * 100
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
.result {
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
