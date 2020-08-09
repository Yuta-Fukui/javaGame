<template>
  <div class="top">
    <div class="title">
      気軽GAMES
    </div>
    <p class="explain">
      Team20の４択クイズを作ろうとしています。
    </p>
      <button @click="question()">
        START!!!
      </button>
  </div>
</template>

<script>
export default {
  methods: {
    question () {
      this.$store.dispatch('getQuestion')
        .then(() => {
          this.$router.push('/question')
        })
    }
  }
}
</script>

<style>

.title{
  font-weight: bold;
}
</style>
