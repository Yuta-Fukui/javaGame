import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    contents: {},
    loaded: false,
    correctCount: 0
  },
  mutations: {
    answer (state, payload) {
      state.contents = payload
      // state.explanation = payload.explanation
      // debugger
      state.loaded = true
      state.correctCount++
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
