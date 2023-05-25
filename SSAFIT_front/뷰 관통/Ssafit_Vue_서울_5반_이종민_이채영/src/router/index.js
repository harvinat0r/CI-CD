import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import ReviewView from "@/views/ReviewView.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewCreate from "@/components/review/ReviewCreate.vue";
import ReviewDetail from "@/components/review/ReviewDetail.vue";
import ReviewModify from "@/components/review/ReviewModify.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import VideoList from "@/components/main/VideoList.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeView",
    component: HomeView,
    children:[
      {
        path:"",
        name:"VideoList",
        component: VideoList,
      }
    ]
  },

  {
    path: "/Review",
    component: ReviewView,
    children: [
      {
        path: "",
        name: "List",
        component: ReviewList,
      },
      {
        path: "create",
        name: "Create",
        component: ReviewCreate,
      },
      {
        path: "detail/:id",
        name: "Detail",
        component: ReviewDetail,
      },
      {
        path: "modify/:id",
        name: "Modify",
        component: ReviewModify,
      },
      {
        path: "regist",
        name: "Regist",
        component: UserRegist,
      },
      {
        path: "login",
        name: "Login",
        component: LoginForm,
      },
    ],
  },
  {
    path: "/user",
    children: [
      
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
