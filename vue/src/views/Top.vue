<template>
  <div class="title-top">
    <div class="title">
      お気軽クイズ
    </div>
    <div class="space"></div>
    <p class="explain">
      Team20の４択クイズ
    </p>
    <p class="explain">
      今回は{{ question }}問でチャレンジ！！
    </p>
    <div class="space"></div>
    <div class="btn-list">
      <select v-model="question" class="list">
        <option v-for="(item, index) in checkboxItems" :key="index" :value="checkboxItems[index]">
          {{ item }}
        </option>
      </select>
      <button class="start-btn" @click="questions(checkboxItems[index])">
        START
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
    metaInfo: {
      title: '20クイズ',
      name: 'robots',
      content: 'noindex'
    },
    // 問題を出力する
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
