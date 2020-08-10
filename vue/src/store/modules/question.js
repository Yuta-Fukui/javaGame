import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    choices: [],
    loaded: false,
    count: 0,
    questionStatement: '',
    questionId: '',
    amountQuestion: 0
  },
  mutations: {
    question (state, payload) {
      state.choices = [payload.answer1, payload.answer2, payload.answer3, payload.answer4]
      state.questionStatement = payload.questionStatement
      state.questionId = payload.id
      state.loaded = true
      state.count++
    },
    initCount (state) {
      state.count = 0
    },
    setQuestions (state, params) {
      state.amountQuestion = params
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
