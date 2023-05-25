<template>
  <div class="container-fluid text-center">
    <h2>싸핏에 오신것을 환영합니다</h2>
    <div>
      <video-part :videoData="body" :part="전신"></video-part>
      <video-part :videoData="top" :part="상체"></video-part>
      <video-part :videoData="bottom" :part="하체"></video-part>
      <video-part :videoData="stomach" :part="복부"></video-part>
    </div>
  </div>
</template>

<script>
import VideoPart from "@/components/main/VideoPart.vue";
import { mapState } from "vuex";

export default {
  name: "videoList",
  components: {
    VideoPart,
  },
  created: {
    ...mapState(["videos"]),
  },
  computed: {
    body() {
      let videoList = this.videos;
      let data = [];
      for (let video in videoList) {
        if (video.part === "전신") {
          data.push(video);
        }
      }
      return data;
    },
    top() {
      let data = [];
      for (let video in this.videos) {
        if (video.part === "상체") {
          data.push(video);
        }
      }
      return data;
    },
    bottom() {
      let data = [];
      for (let video in this.videos) {
        if (video.part === "하체") {
          data.push(video);
        }
      }
      return data;
    },
    stomach() {
      let data = [];
      for (let video in this.videos) {
        if (video.part === "복부") {
          data.push(video);
        }
      }
      return data;
    },
  },
};
</script>

<style></style>
