<template>
  <div id="the-top" class="ui container">
    <h1 class="ui header center">Youtube Search App</h1>
    <div class="ui centered stackable grid">
      <div class="row">
        <div class="nine wide column">
          <VideoDetail></VideoDetail>
        </div>
        <div class="seven wide column">
          <div class="row">
            <SearchBar></SearchBar>
          </div>
          <div class="row">
            <VideoList></VideoList>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SearchBar from "./Youtube/SearchBar.vue";
import VideoList from "./Youtube/VideoList.vue";
import VideoDetail from "./Youtube/VideoDetail.vue";

export default {
  name: "YoutubeSearch",
  components: {
    SearchBar,
    VideoList,
    VideoDetail,
  },
};
</script>

<style scoped>
#the-top {
  padding: 20px 0px;
}
</style>
