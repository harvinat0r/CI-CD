<template>
  <header class="text-center">
	<nav class="row my-5 d-flex align-items-center">
		<div id="logo" class="col-3 fs-2">
			<router-link to="/" class="btn btn-default"><h3>SSAFIT</h3></router-link>
		</div>
		<div class="col-6 search">
			<input id="search" type="search" class="form-control p-6"
				placeholder="검색어를 입력하세요" />
		</div>
		<div class="row-3 col">
			<span class="mx-3 col-4">
        <a href="#" v-if="getUser" @click="logout">로그아웃</a>
      <router-link to="/login" v-else>로그인</router-link>
      </span> 
        <span class="mx-3 col-4">
            <router-link :to="{ name: 'Regist' }">회원가입</router-link>
        </span> 
		</div>
	</nav>
</header>
</template>

<script>
import {mapState} from "vuex"

export default {
  name: "HeaderNav",
    methods: {
      logout() {
        this.$store.dispatch("LOGOUT");
      },
    },
    computed: {
      ...mapState(["loginUser"]),
      getUser() {
        if (this.loginUser) {
          return true;
        } else {
          return false;
        }
      },
    },
}
</script>

<style>

</style>