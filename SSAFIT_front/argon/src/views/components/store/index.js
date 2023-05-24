import Vuex from "vuex";
import Vue from "vue";

Vue.use(vuex);

const store = new Vuex.Store({ state: (check = 21) });

export default store;
