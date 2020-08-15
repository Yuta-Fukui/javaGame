import Vue from 'vue'
import VueRouter from 'vue-router'
import VueMeta from 'vue-meta'
import Top from '../views/Top.vue'
import Question from '../views/Question.vue'
import Answer from '../views/Answer.vue'
import Results from '../views/Results.vue'

Vue.use(VueRouter)
Vue.use(VueMeta, {
  // optional pluginOptions
  refreshOnceOnNavigation: true
})

const routes = [
  {
    path: '/',
    name: 'Top',
    component: Top
  },
  {
    path: '/question',
    name: 'Question',
    component: Question
  },
  {
    path: '/answer',
    name: 'Answer',
    component: Answer
  },
  {
    path: '/results',
    name: 'Results',
    component: Results
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
