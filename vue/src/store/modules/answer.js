import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    contents: {},
    // 画面遷移のタイミングを操作する
    loaded: false,
    // 正解数をカウントする
    correctCount: 0,

    // 画面で回答した値を受け取る箱
    answer: ''
  },
  mutations: {
    // DBからデータを受け取る時に動く
    answer (state, payload) {
      state.contents = payload
      state.loaded = true
    },

    // 画面で選択された解答を受け取る
    setAnswer (state, payload) {
      state.answer = payload
    },

    // 正解数を数える
    addCount (state) {
      state.correctCount++
    },
    // 初期化
    initCorrectCount (state) {
      state.correctCount = 0
    }
  },
  actions: {
    // APIと接続する（答えと解説を持ってくる）
    async getAnswer ({ commit }, questionId) {
      const url = '/api/answer/' + questionId
      await axios.get(url)
        .then(res => {
          commit('answer', res.data)
        })
    }
  }
}
