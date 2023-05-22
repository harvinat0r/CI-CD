<template>
  <div>
    <div>영상 상세</div>
    <video-detail></video-detail>
    <router-link to="/video/gMaB-fG4u4g/reviewcreate">리뷰등록</router-link>

    <router-view></router-view>
  </div>
</template>

<script>
import VideoDetail from '@/components/video/VideoDetail.vue';

export default {

  components: {
    VideoDetail,
  }

};
</script>

<style></style>
