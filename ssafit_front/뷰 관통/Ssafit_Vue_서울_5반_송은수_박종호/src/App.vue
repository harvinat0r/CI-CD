<template>
  <div id="app">
    <header-nav />
    <router-view />
  </div>
</template>
<script>
import HeaderNav from "./components/HeaderNav.vue";
export default {
  name: "App",
  components: {
    HeaderNav,
  },
  created() {
    //메인 컴포넌트를 렌더링하면서 토큰체크
    let token = this.$store.getters.getToken;
    console.log(token)
    if (token.access == null && token.refresh == null) { //다 없으면 로그인 페이지로
      //이미 로그인 페이지가 떠있는 상태에서 새로 고침하면 중복 에러 떠서 이렇게 처리함
      this.$router.push({name: 'Login'}).catch(() => {}); 
    }
  },
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}
</style>
