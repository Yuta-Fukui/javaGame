<template>
  <div class="answer">
    <h1 class="true">
      正解!
    </h1>
    <h1 class="answer">
      答えは〇〇
    </h1>
    <router-link to="/question" class="btn_to_question">
      次の問題へ
    </router-link>
  </div>
</template>

<style scoped>
.answer {
  background-color: #FF9999;
}
</style>
