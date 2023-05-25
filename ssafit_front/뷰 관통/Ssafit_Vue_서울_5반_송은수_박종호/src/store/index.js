import Vue from 'vue'
import Vuex from 'vuex'
import http from "../util/http-common"
import axios from "axios"
import VueCookies from 'vue-cookies';
import router from "../router"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    videos: [],
    video: null,
    // loginUser: null,
    randomUser: null,
    reviews: [],
    review: null,
    accessToken: null,
    refreshToken: null,
    loginUser: null,
  },
  getters: {
    popularVideos: function (state) {
      return state.videos.slice(0,5)
    },
    getToken(state) {
      console.log(state)
      let ac = VueCookies.get('accessToken');
      let rf = VueCookies.get('refreshToken');
      return {        
        access: ac,
        refresh: rf
      };
    },
  },
  mutations: {
    SET_VIDEOS: function (state, videos) {
      state.videos = videos
    },
    SET_VIDEO: function (state, video) {
      state.video = video
    },
    // SET_LOGIN_USER: function (state, user) {
    //   state.loginUser = user;
    // },
    // LOGOUT: function (state) {
    //   state.loginUser = null;
    // },
    SET_RANDOM_USER: function (state, user) {
      state.randomUser = user;
    },
    SET_REVIEWS: function (state, reviews) {
      state.reviews = reviews
    },
    SET_REVIEW: function (state, review) {
      state.review = review
    },
    SET_LOGIN_USER (state, payload) {
      VueCookies.set('accessToken', payload.accessToken, '60s');
      VueCookies.set('refreshToken', payload.refreshToken, '1h');
      state.accessToken = payload.accessToken;
      state.refreshToken = payload.refreshToken;
      state.loginUser = payload.loginUser;
    },
    refreshToken(state, payload) { //accessToken 재셋팅
      VueCookies.set('accessToken', payload.accessToken, '60s');
      VueCookies.set('refreshToken', payload.refreshToken, '1h');
      state.accessToken = payload;
    },
    LOGOUT () {
      VueCookies.remove('accessToken');
      VueCookies.remove('refreshToken');
  },
  },
  actions: {
    setVideos: function ({ commit }) {
      http.get("api-video/list").then((res) => {
        commit("SET_VIDEOS",res.data)
      })
    },
    setVideo: function ({ commit },id) {
      http.get(`api-video/${id}`).then((res) => {
        commit("SET_VIDEO",res.data)
      })
    },
    createUser: function ({ commit }, user) {
      http.post("api-user/signup", user).then((res) => {
        if (res.status === 200) {
          alert("회원가입이 완료되었습니다.")
          commit("SET_LOGIN_USER",user.nickName)
        }
      })
    },
    setReviews: function ({ commit }, id) {
      const params = {videoId: id}
      http.get("api-review/", {params}).then((res) => {
        commit("SET_REVIEWS",res.data)
      })
    },
    setReview: function ({ commit },id) {
      http.get(`api-review/${id}`).then((res) => {
        commit("SET_REVIEW",res.data)
      })
    },
    setLoginUser: ({commit}, user) => {
      http.post("api-user/login",user)
      .then((res) => {
        if (res.status == 202) {
          alert("로그인 성공!");
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
    setRandomUser: async function ({ commit }) {
      const API_URL = `https://random-data-api.com/api/users/random_user`;

      try {
        const res = await axios.get(API_URL);
        let user = {
          id: res.data.username,
          password: res.data.password,
          name: res.data.first_name,
          email: res.data.email,
          age: Math.floor(Math.random() * (99 - 20)) + 20,
        };
        commit("SET_RANDOM_USER", user);
      } catch (err) {
        console.log(err);
      }
    },
    createReview: function ({ commit }, review) {
      console.log(commit)
      http.post("api-review/", review)
        .then((res) => {
          if (res.status === 201) {
            alert("등록완료")
        }
      })
    },
    updateReview: function ({commit}, review) {
      console.log(commit);
      http.put("api-review",review)
        .then(() => {
          alert("수정 완료!");
          router.push("/user");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteReview: function ({ state }, id) {
      console.log(state)
      http.delete(`api-review/${id}`)
        .then(() => {
          alert("삭제 완료!");
          router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // refreshToken: ({commit}) => { // accessToken 재요청
    //   //accessToken 만료로 재발급 후 재요청시 비동기처리로는 제대로 처리가 안되서 promise로 처리함
    //   return new Promise((resolve, reject) => {
    //     axios.post('/v1/auth/certify').then(res => {
    //       commit('refreshToken', res.data.auth_info);
    //       resolve(res.data.auth_info);
    //     }).catch(err => {
    //       console.log('refreshToken error : ', err.config);
    //       reject(err.config.data);
    //     })
    //   })
    // },
    // logout: ({commit}) => { // 로그아웃
    //   commit('removeToken');
    //   location.reload();
    // }
  },
  modules: {
  }
})
