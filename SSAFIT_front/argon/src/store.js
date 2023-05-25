import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "./router.js";
import videos from "./store/modules/videos.js";

Vue.use(Vuex);

const REST_API = `http://localhost:9999`;

export default new Vuex.Store({
  state: {
    reviews: [],
    exercises: [],
    articles: [],
    article: {},
    loginUser: null,
    users: [],
    videos: [],
    video: {},
    searchVideos: [],
    reviews: [],
    review: {},
  },
  getters: {
    articleCnt: function(state) {
      return state.articles.length;
    },
  },
  mutations: {
    SET_ARTICLE_REVIEWS: function(state, reviews) {
      state.reviews = reviews;
    },
    SET_EXERCISES: function(state, exercises) {
      state.exercises = exercises;
    },
    SET_ARTICLES: function(state, articles) {
      state.articles = articles;
    },
    SET_ARTICLE: function(state, article) {
      state.article = article;
    },
    CREATE_USER: function(state, user) {
      state.users.push(user);
    },
    SET_USERS: function(state, users) {
      state.users = users;
    },
    SET_USER: function(state, user) {
      state.user = user;
    },
    SEARCH_NAME: function(state, users) {
      state.searchUsers = users;
    },
    SET_LOGIN_USER: function(state, user) {
      state.loginUser = user;
    },
    LOGOUT: function(state) {
      state.loginUser = null;
    },

    GET_REVIEWS(state, payload) {
      state.reviews = payload;
    },
    CREATE_REVIEW(state, payload) {
      state.reviews.push(payload);
    },

    UPDATE_REVIEW(state, payload) {
      state.reviews = payload;
    },
    GET_REVIEW(state, payload) {
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
    updateReview: function ({}, review) {
      const API_URL = `${REST_API}/review/update`;
      axios({
        url: API_URL,
        method: "PUT",
        data: review,
      })
        .then((res) => {
          console.log(res.data);
          alert("수정 완료!");
        })
        .catch((err) => {
          console.log(err);
          console.log("세상이 밉다...");
        });
    },
    deleteReview: function ({ state }, review_id) {
      const API_URL = `${REST_API}/review/delete/${review_id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then((res) => {
          console.log(res.data);
          alert("삭제 완료!");
          let index;
          for (let i = 0; i < state.reviews.length; i++) {
            if (state.reviews[i].review_id === review_id) {
              index = i;
            }
          }
          state.reviews.splice(index, 1);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setArticleReviews: function ({ commit }, article_id) {
      const API_URL = `${REST_API}/review/article/${article_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("SET_ARTICLE_REVIEWS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setExercises: function({ commit }) {
      const API_URL = `${REST_API}/exercise/bySearch`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("SET_EXERCISES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setArticles: function({ commit }, article_property) {
      console.log(article_property);
      const API_URL = `${REST_API}/article/list/${article_property}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("SET_ARTICLES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    setArticle: function({ commit }, article_id) {
      console.log(article_id);
      const API_URL = `${REST_API}/article/detail/${article_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          commit("SET_ARTICLE", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    createUser: function({ commit }, user) {
      console.log(user);
      const API_URL = `${REST_API}/user/regist`;
      axios({
        url: API_URL,
        method: "POST",
        data: user,
      })
        .then(() => {
          commit("CREATE_USER", user);
          alert("축하합니다! 가입되었습니다");
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateUser: function({ commit }, user) {
      console.log(commit);
      const API_URL = `${REST_API}/user/${this.$store.state.loginUser.id}`;
      axios({
        url: API_URL,
        method: "PUT",
        data: user,
      })
        .then(() => {
          alert("수정 완료되었습니다");
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteUser: function({ state }, id) {
      const API_URL = `${REST_API}/user/withdrawal/${
        this.$store.state.loginUser.id
      }`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          alert("탈퇴되었습니다");
          let index;
          for (let i = 0; i < state.users.length; i++) {
            if (state.users[i].id === id) {
              index = i;
            }
          }
          state.users.splice(index, 1);
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setUsers: function({ commit }) {
      const API_URL = `${REST_API}/user/ranking`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("user setting...");
          console.log(res.data);
          commit("SET_USERS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setUser: function({ commit }, id) {
      const API_URL = `${REST_API}/user/${
        this.$store.state.loginUser.id
      }/my-page`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("SET_USER", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchName: function({ commit }, name) {
      const API_URL = `${REST_API}/user/${
        this.$store.state.loginUser.id
      }/search`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "name",
          word: name,
        },
      })
        .then((res) => {
          commit("SEARCH_NAME", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setLoginUser: function({ commit }, user) {
      const API_URL = `${REST_API}/user/login`;

      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          let resUser = res.data;
          console.log(res.data);
          if (
            resUser.user_id === user.id &&
            resUser.user_password === user.password
          ) {
            alert("로그인 성공!");
            commit("SET_LOGIN_USER", resUser);
            router.push("/");
          } else {
            alert("로그인 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getReviews({ commit }, videoId) {
      http
        .get(`/review/review`, videoId)
        .then((res) => {
          commit("GET_REVIEWS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    createReview({ commit }, review) {
      const API_URL = `${REST_API}/review/review`;
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
      http
        .get(`/review/review/${reviewNum}`)
        .then((res) => {
          commit("GET_REVIEW", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getVideos({ commit }, payload) {
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API}/video/video`;
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
  modules: {
    videos,
  },
});
