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
      // state.explanation = payload.explanation
      // debugger
      state.loaded = true
      state.count++
    }
    // addCount (state, payload) {
    //   state.count++
    // }
  },
  actions: {
    async getQuestion ({ commit }) {
      const url = '/api/question'
      await axios.get(url)
        .then(res => commit('question', res.data))
    }
  }
}
