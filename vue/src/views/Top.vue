<template>
  <div class="top">
    <div class="title">
      気軽GAMES
    </div>
    <p class="explain">
      Team20の４択クイズ!!!
    </p>
      <button class="btn" @click="question()">
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
  font-size: 50px;
  color: black;
  padding-top: 40px;
}
.explain {
  font-weight: bold;
  font-size: 30px;
}

.btn {
  display: inline-block;
  padding: 7px 20px;
  border-radius: 25px;
  text-decoration: none;
  color: #FFF;
  background-color: black;
  transition: .4s;
}

.btn:hover {
  background-color: black;
}
</style>
