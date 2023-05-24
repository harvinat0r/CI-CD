<template>
  <div>
    <h2>유튜브 뷰</h2>
    <!-- 링크를 여러개를 만들면 좋겠다. -->
    <router-link to="/tmdb/popular">인기순위</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "YoutubeView",
};
</script>

<style></style>
