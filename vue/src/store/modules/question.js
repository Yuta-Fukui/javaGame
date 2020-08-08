import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    contents: {},
    loaded: false,
    count: 0
  },
  mutations: {
    question (state, payload) {
      state.contents = payload
      state.loaded = true
      state.count++
    },
    initCount (state) {
      state.count = 0
    }
  },
  actions: {
    getQuestion ({ commit }) {
      const url = '/api/question'
      axios.get(url)
        .then(res => commit('question', res.data))
    }
  }
}
