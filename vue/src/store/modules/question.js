import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default {
  state: {
    choices: [],
    // 画面遷移のタイミングを操作する
    loaded: false,
    // 問題数を数える
    count: 0,
    // 問題文
    questionStatement: '',
    // 問題の番号
    questionId: '',
    // 用意する問題数
    amountQuestion: 0,
    // 出題者の名前
    name: ''
  },

  mutations: {
    // 問題を準備する
    question (state, payload) {
      state.choices = [payload.answer1, payload.answer2, payload.answer3, payload.answer4]
      state.questionStatement = payload.questionStatement
      state.questionId = payload.id
      state.name = payload.name
      state.loaded = true
      state.count++
    },
    // 初期化
    initCount (state) {
      state.count = 0
    },
    // 問題数を設定する
    setQuestions (state, params) {
      state.amountQuestion = params
    }
  },

  actions: {
    getQuestion ({ commit }) {
      const url = '/api/getQuestion'
      axios.get(url)
        .then(res => commit('question', res.data))
    },
    updateQuestion ({ commit }) {
      const url = '/api/updatedQuestion'
      axios.get(url)
        .then(res => commit('question', res.data))
    }
  }
}
