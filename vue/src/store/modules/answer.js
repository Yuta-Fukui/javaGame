import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    contents: {},
    loaded: false,
    correctCount: 0,

    // 画面で回答した値を受け取る箱
    answer: ''
  },
  mutations: {
    answer (state, payload) {
      state.contents = payload
      // state.explanation = payload.explanation
      // debugger
      state.loaded = true
      state.correctCount++
    },
    getAnswer (state, payload) {
      state.answer = payload
    }
  },
  actions: {
    async getAnswer ({ commit }, questionId) {
      const url = '/api/answer/' + questionId
      await axios.get(url)
        .then(res => commit('answer', res.data))
    }
  }
}
