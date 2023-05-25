import Vue from "vue";
import Vuex from "vuex";
import router from "@/router";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    startWord: "SSAFY 영화 관리 사이트",
    reviews: [],
    review: {},
    user: {},
    loginUser: null,
    videos: [],
  },
  getters: {
    CREATE_review: function (state, payload) {
      state.reviews.push(payload);
    },
    reviews(state) {
      return state.reviews;
    },
    review(state) {
      return state.review;
    },
    reviewCnt(state) {
      return state.reviews.length;
    },
  },
  mutations: {
    SET_reviewS(state, payload) {
      state.reviews = payload;
    },
    SET_review(state, payload) {
      state.review = payload;
    },
    CREATE_USER(state, user) {
      state.users.push(user);
    },
    SET_LOGIN_USER(state, user) {
      state.loginUser = user;
    },
    LOGOUT(state) {
      state.loginUser = null;
    },
    VIDEODATA(state, videodata) {
      state.videos = videodata;
    },
  },
  actions: {
    createUser({ commit }, payload) {
      console.log(payload);
      http
        .post("userapi/user", payload)
        .then((res) => {
          commit("CREATE_USER", res.data);
          alert("등록되었습니다.");
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setLoginUser({ commit }, user) {
      http
        .get(`userapi/user/${user.id}`)
        .then((res) => {
          let resUser = res.data;
          if (
            resUser !== null &&
            resUser.id === user.id &&
            resUser.password === user.password
          ) {
            alert("로그인 성공!");
            res.data.password = null;
            commit("SET_LOGIN_USER", res.data);
            router.push("/");
          } else {
            alert("로그인 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createreview({ commit }, review) {
      http
        .post("/reviewapi/review", review)
        .then(() => {
          commit("CREATE_review", review);
          alert("등록되었습니다.");
          router.push("/review");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setreviews({ commit }) {
      http
        .get("/reviewapi/review")
        .then((res) => {
          commit("SET_reviewS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setreview({ commit }, id) {
      http
        .get("/reviewapi/review/" + id)
        .then((res) => {
          commit("SET_review", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updatereview({ state }, review) {
      http
        .put("/reviewapi/review/" + review.id, review)
        .then(() => {
          alert("수정 완료!");
          state;
          router.push("/review");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deletereview({ state }, id) {
      http
        .delete("/reviewapi/review/" + id)
        .then(() => {
          alert("삭제 완료!");
          state;
          router.push("/review");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getVideoData({ commit }) {
      http.get("/videoapi/video").then((res) => {
        commit("VIDEODATA", res.data);
      });
    },
  },
  modules: {},
});
