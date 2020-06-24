import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    correctAnswer: [],
    explanation: []
  },
  mutations: {
    answer (state, payload) {
      state.correctAnswer = payload.correctAnswer
      state.explanation = payload.explanation
    }
  },
  actions: {
    getAnswer ({ commit }, id) {
      console.log('OK!!')
      const url = '/answer/' + id
      axios.get(url)
        .then(res => commit('answer', res.data))
    }
  }
}
