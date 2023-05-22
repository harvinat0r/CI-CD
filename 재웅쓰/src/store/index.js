import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
import router from "@/router";
import axios from "axios";

Vue.use(Vuex);

const REST_API = `http://localhost:8080`;

export default new Vuex.Store({
  state: {
    reviews: [],
    review: {},
    videos: [],
    video: [],
  },
  getters: {},
  mutations: {
    GET_REVIEWS(state, payload) {
      state.reviews = payload;
    },
    CREATE_REVIEW(state, payload) {
      state.reviews.push(payload);
    },

    UPDATE_REVIEW(state, payload) {
      state.reviews = payload;
    },
    GET_REVIEW(state, payload){
      state.review = payload;
    },
    GET_VIDEOS(state, payload) {
      state.videos = payload;
    },
    GET_VIDEO(state, payload) {
      state.video = payload;
    },
  },
  actions: {
    getReviews({ commit }, videoId) {
      http.get(`/api-review/review`,videoId)
        .then((res) => {
          commit("GET_REVIEWS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    createReview({ commit }, review) {
      const API_URL = `${REST_API}/api-review/review`;
      axios({
        url: API_URL,
        method: "POST",
        params: review,
      })
        .then(() => {
          commit("CREATE_REVIEW", review);
          router.push("./reviewlist");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getReview({ commit }, reviewNum) {
      http.get(`/api-review/review/${reviewNum}`)
        .then((res) => {
          commit("GET_REVIEW", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateReview({ commit }, review) {

      console.log(review)
      const API_URL = `${REST_API}/api-review/review`;
      axios({
        url: API_URL,
        method: "PUT",
        params: review,
      }).then(() => {
        commit("UPDATE_REVIEW", review);
        router.push(`../reviewdetail/${review.reviewNum}`);
      })
      .catch((err) => {
        console.log(err);
      });
    },

    getVideos({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API}/api-video/video`;
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
        .then((res) => {
          commit("GET_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getVideo({ commit }, id) {
      const API_URL = `${REST_API}/video/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("GET_VIDEO", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
