<template>
  <div class="top">
    <div class="title">
      気軽GAMES
    </div>
    <p class="explain">
      Team20の４択クイズを作ろうとしています。
    </p>
    <router-link to="/question">
      <button>
        START!!!
      </button>
    </router-link>
  </div>
</template>

<script>
// export default {
//   methods: {
//     question () {
//       this.$store.dispatch('getQuestion')
//     }
//   }
// }
</script>

<style>

.title{
  font-weight: bold;
}
</style>
