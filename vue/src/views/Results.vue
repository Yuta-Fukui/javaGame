<template>
  <div class="results">
    <h1>結果発表！！</h1>
    <div class="result">
      <h2>あなたの結果は</h2>
      <h3>〇〇</h3>
    </div>
    <router-link to="/">
      <button class="button">
        スタートに戻る
      </button>
    </router-link>
  </div>
</template>

<style scoped>
  h1 {
    font-size:100px;
    margin: 0 auto;
  }
  .result {
    margin: 0 auto;
  }
  .button {
   padding: 20px;
   margin: 0 auto;
  }

</style>
