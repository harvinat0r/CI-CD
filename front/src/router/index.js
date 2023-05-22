import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import UserCreate from "../components/Users/UserCreate.vue";
import UserLogin from "../components/Users/UserLogin.vue";
import VideoView from "../views/VideoView.vue";
import ReviewCreate from "@/components/review/ReviewCreate.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewUpdate from "@/components/review/ReviewUpdate.vue";
import VideoList from "../components/video/VideoList.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },

  {
    path: "/video",
    name: "video",
    component: VideoList,
  },

  {
    path: "/user",
    name: "user",
    component: UserView,
    children: [
      {
        path: "create",
        name: "userCreate",
        component: UserCreate,
      },
      {
        path: "login",
        name: "userLogin",
        component: UserLogin,
      },
    ],
  },

  {
    path: "/video/:youtubeId",
    name: "video",
    component: VideoView,
    children: [
      {
        path: "reviewcreate",
        component: ReviewCreate,
      },
      {
        path: "reviewlist",
        component: ReviewList,
      },
      {
        path: "reviewdetail/:reviewnum",
        component: ReviewDetail,
      },
      {
        path: "reviewupdate/:reviewnum",
        component: ReviewUpdate,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
