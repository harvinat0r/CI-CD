<template>
  <header class="header-global">
    <base-nav class="navbar-main" transparent type="" effect="light" expand>
      <router-link slot="brand" class="navbar-brand mr-lg-5" to="/">
        <img
          src="img/brand/STEROID.png"
          alt="logo"
          href="http://localhost:8080"
        />
      </router-link>

      <div class="row" slot="content-header" slot-scope="{ closeMenu }">
        <div class="col-6 collapse-brand">
          <a
            href="https://demos.creative-tim.com/vue-argon-design-system/documentation/"
          >
            <img src="img/brand/blue.png" />
          </a>
        </div>
        <div class="col-6 collapse-close">
          <close-button @click="closeMenu"></close-button>
        </div>
      </div>

      <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
        <base-dropdown class="nav-item" menu-classes="dropdown-menu-xl">
          <a
            slot="title"
            href="#"
            class="nav-link"
            data-toggle="dropdown"
            role="button"
          >
            <i class="ni ni-ui-04 d-lg-none"></i>
            <span class="nav-link-inner--text">관장님</span>
          </a>
          <div class="dropdown-menu-inner">
            <a
              href="https://demos.creative-tim.com/vue-argon-design-system/documentation/"
              class="media d-flex align-items-center"
            >
              <div
                class="icon icon-shape bg-gradient-primary rounded-circle text-white"
              >
                <i class="ni ni-spaceship"></i>
              </div>
              <div class="media-body ml-3">
                <h6 class="heading text-primary mb-md-1">소개</h6>
                <p class="description d-none d-md-inline-block mb-0">
                  그는 전설이다.
                </p>
              </div>
            </a>
            <router-link
              :to="{ name: 'Test' }"
              class="media d-flex align-items-center"
            >
              <div
                class="icon icon-shape bg-gradient-warning rounded-circle text-white"
              >
                <i class="ni ni-ui-04"></i>
              </div>
              <div class="media-body ml-3">
                <h5 class="heading text-warning mb-md-1">동기부여</h5>
                <p class="description d-none d-md-inline-block mb-0">
                  자극 받는 말들
                </p>
              </div>
            </router-link>
          </div>
        </base-dropdown>
        <li class="nav-item">
          <router-link
            :to="{ name: 'search' }"
            class="nav-item nav-link-icon white_word"
            >부위별</router-link
          >
        </li>

        <base-dropdown tag="li" class="nav-item">
          <a
            slot="title"
            href="#"
            class="nav-link"
            data-toggle="dropdown"
            role="button"
          >
            <i class="ni ni-collection d-lg-none"></i>
            <span class="nav-link-inner--text">프로그램</span>
          </a>
          <router-link to="/landing" class="dropdown-item"
            >파워리프팅</router-link
          >
          <router-link to="/profile" class="dropdown-item"
            >보디빌딩</router-link
          >
        </base-dropdown>

        <base-dropdown tag="li" class="nav-item">
          <a
            slot="title"
            href="#"
            class="nav-link"
            data-toggle="dropdown"
            role="button"
          >
            <i class="ni ni-collection d-lg-none"></i>
            <span class="nav-link-inner--text">커뮤니티</span>
          </a>
          <router-link
            :to="{ name: 'ArticleRoutineResearch' }"
            class="dropdown-item"
            >루틴연구소</router-link
          >
          <router-link :to="{ name: 'ArticleFree' }" class="dropdown-item"
            >자유게시판</router-link
          >
          <router-link
            :to="{ name: 'ArticleFindFriends' }"
            class="dropdown-item"
            >헬스친구찾기</router-link
          >
        </base-dropdown>

        <li class="nav-item">
          <a class="nav-link nav-link-icon" href="#">
            랭킹
          </a>
        </li>

        <li class="nav-item">
          <a class="nav-link nav-link-icon" href="#">
            헬스장
          </a>
        </li>
      </ul>

      <ul class="navbar-nav navbar-nav-hover align-items-lg-center ml-lg-auto">
        <li class="nav-item">
          <a
            class="nav-item white_word"
            href="http://localhost:8080"
            v-if="getUser"
            @click="logout"
            >로그아웃</a
          >

          <router-link
            :to="{ name: 'profile' }"
            class="nav-item white_word"
            v-if="getUser"
            >마이페이지</router-link
          >
          <router-link to="/user/login" v-else class="white_word"
            >로그인</router-link
          >
        </li>
      </ul>
    </base-nav>
  </header>
</template>
<script>
import BaseNav from "@/components/BaseNav";
import BaseDropdown from "@/components/BaseDropdown";
import CloseButton from "@/components/CloseButton";
import { mapState } from "vuex";
export default {
  name: "AppHeader",
  components: {
    BaseNav,
    CloseButton,
    BaseDropdown,
  },
  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    },
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      console.log(this.loginUser);
      if (this.loginUser) {
        console.log(this.loginUser);
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>
<style>
.white_word {
  color: white;
}
</style>
