import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "./router.js";

Vue.use(Vuex);

const REST_API = `http://localhost:9999`;

export default new Vuex.Store({
  state: {
    loginUser: null,
    users: [],
    videos: [],
    video: {},
    searchVideos: [],
    reviews: [],
    review: {},
  },
  getters: {},
  mutations: {
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
      console.log("여기까진돼?");
      console.log(user.id);
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          // res.data하면 db자료가 가져와지네
          let resUser = res.data;
          if (
            resUser.user_id === user.id &&
            resUser.user_password === user.password
          ) {
            alert("로그인 성공!");
            commit("SET_LOGIN_USER", resUser);
            router.push("/");
          } else {
            console.log(resUser.id);
            console.log(resUser.password);
            console.log(res);
            console.log(res.data.user_id);

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
    updateReview({ commit }, review) {
      console.log(review);
      const API_URL = `${REST_API}/review/review`;
      axios({
        url: API_URL,
        method: "PUT",
        params: review,
      })
        .then(() => {
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
  modules: {},
});
