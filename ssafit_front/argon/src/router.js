import Vue from "vue";
import Router from "vue-router";
import AppHeader from "./layout/AppHeader";
import AppFooter from "./layout/AppFooter";
import Components from "./views/Components.vue";
import Landing from "./views/Landing.vue";
import Login from "./views/Login.vue";
import Register from "./views/Register.vue";
import Profile from "./views/Profile.vue";
import VideoView from "@/views/VideoView.vue";
import VideoList from "@/components/video/VideoList.vue";
import LoginView from "./views/User/LoginView.vue";
import ProfileView from "./views/User/ProfileView.vue";
import RegisterView from "./views/User/RegisterView.vue";
import Test from "./views/Test.vue";
// 게시판(자유, 루틴연구소, 헬스친구찾기)
import ArticleView from "@/views/Article.vue";
import ArticleFree from "@/components/article/Free.vue";
import ArticleRoutineResearch from "@/components/article/RoutineResearch.vue";
import ArticleDetail from "@/components/article/ArticleDetail.vue";
import ArticleFindFriends from "@/components/article/FindFriends.vue";

Vue.use(Router);

export default new Router({
  linkExactActiveClass: "active",
  routes: [
    // 게시판(자유, 루틴연구소, 헬스친구찾기)
    {
      path: "/article",
      name: "Article",
      component: ArticleView,
      children: [
        // 스프링에서 article_property 확인 필수
        {
          path: "",
          name: "ArticleFree",
          component: ArticleFree,
        },
        {
          path: "routineResearch",
          name: "ArticleRoutineResearch",
          component: ArticleRoutineResearch,
        },
        {
          path: "findFriends",
          name: "ArticleFindFriends",
          component: ArticleFindFriends,
        },
        {
          path: "detail/:article_id",
          name: "ArticleDetail",
          component: ArticleDetail,
        },
      ],
    },

    {
      path: "/test",
      name: "Test",
      component: Test,
    },
    {
      path: "/video",
      name: "video",
      component: VideoList,
    },
    {
      path: "/video/:youtubeId",
      name: "video",
      component: VideoView,
    },
    {
      path: "/",
      name: "components",
      components: {
        header: AppHeader,
        default: Components,
        footer: AppFooter,
      },
    },
    {
      path: "/landing",
      name: "landing",
      components: {
        header: AppHeader,
        default: Landing,
        footer: AppFooter,
      },
    },
    {
      path: "/user/login",
      name: "login",
      components: {
        header: AppHeader,
        default: LoginView,
        footer: AppFooter,
      },
    },
    {
      path: "/user/register",
      name: "register",
      components: {
        header: AppHeader,
        default: RegisterView,
        footer: AppFooter,
      },
    },

    {
      path: "/user/my-page",
      name: "profile",
      components: {
        header: AppHeader,
        default: ProfileView,
        footer: AppFooter,
      },
    },
  ],
  scrollBehavior: (to) => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  },
});
