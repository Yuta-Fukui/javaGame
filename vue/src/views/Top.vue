<template>
  <div class="top">
    <div class="title">
      気軽GAMES
    </div>
    <p class="explain">
      Team20の４択クイズ!!!
    </p>
    <button class="start-btn" @click="question()">
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

</style>
