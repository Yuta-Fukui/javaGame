<template>
  <div class="top">
    <div class="title">
      気軽GAMES
    </div>
    <p class="explain">
      Team20の４択クイズ!!!
    </p>
    <p class="explain">
      今回の設問数は{{ question }}問でチャレンジ！！
    </p>
    <div class="btn-list">
      <select v-model="question" class="list">
        <option v-for="(item, index) in checkboxItems" :key="index" :value="checkboxItems[index]">
          {{ item }}
        </option>
      </select>
      <button class="start-btn" @click="questions(checkboxItems[index])">
        START!!!
      </button>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      question: 5,
      checkboxItems: [5, 10, 15, 20]
    }
  },
  methods: {
    questions () {
      const amountQuestions = this.question
      this.$store.commit('setQuestions', amountQuestions)
      this.$store.dispatch('getQuestion')
        .then(() => {
          this.$router.push('/question')
        })
    }
  }
}
</script>

<style>
.top {
  text-align: center;
}

.title{
  font-weight: bold;
  font-size: 50px;
  padding-top: 40px;
  color: #2c3e50;
  text-align: center;
}

.explain {
  font-weight: bold;
  font-size: 30px;
}

.btn-list {
  display: flex;
  align-items: center;
  justify-content: center;
}

.list {
  margin-right: 2vw;
  text-align: center;
  width: 100px;
  border: none;
  padding: 15px 20px;
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
  border-radius: 5px;
  opacity: 1;
  font-size: 2vw;
}
</style>
