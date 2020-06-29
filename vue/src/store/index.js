import Vue from 'vue'
import Vuex from 'vuex'
import answer from './modules/answer.js'
import question from './modules/question.js'
import axios from 'axios'

Vue.use(Vuex)

const config = {
  headers: {
    'Access-Control-Allow-Origin': '*'
  }
}

export default new Vuex.Store({
  modules: {
    answer,
    question
  },
  state: {
    account: {
      // TODO: delete because of test
      login: 'ng'
    }
  },
  mutations: {
    // TODO: delete because of test
    setLogin (state, payload) {
      state.login = payload.login
    }
  },
  actions: {
    // TODO: delete because of test
    fetchLogin ({ commit }) {
      const url = '/api/auth/login'
      axios.get(url, config).then((res) => {
        commit('setLogin', res.data)
      })
    }
  }
})
