<template>
  <div class="question">
    <h1>問題X</h1>
    <p class="question">
      Q : おぼうさんが木魚をたたく意味はなんでしょう？
    </p>
    <button onclick="URI; answer()">
      ① お経にリズムをつけるため
    </button>
    <button onclick="URI; answer()">
      ② 亡くなった人が天国にいけるようにと祈るため
    </button>
    <button onclick="URI; answer()">
      ③ 眠くならないようにするため
    </button>
    <button @click="answer()">
      ④ 悪い霊を寄せ付けないため
    </button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      URI: "location.href='/answer'"
    }
  },
  methods: {
    answer () {
    // const id = this.$store.state.answer.id
      const id = 1
      console.log('start')
      this.$store.dispatch('answer/getAnswer', id)
      console.log('finish')
    }
  }
}
</script>
