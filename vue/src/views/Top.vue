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
