<template>
  <div>
    <h3>동영상 목록</h3>
    <hr />
    <div>
      <table>
        <tr>
          <th>채널 이름</th>
          <th>제목</th>
          <th>부위</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="video in videos" :key="video.youtubeId">
          <td>{{ video.channelName }}</td>
          <td>{{ video.id }}</td>
          <td>
            <router-link :to="`/video/${video.youtubeId}/reviewlist`">{{
              video.title
            }}</router-link>
          </td>
          <td>{{ video.part }}</td>
          <td>{{ video.viewCnt }}</td>
          <td>{{ video.regDate }}</td>
        </tr>
      </table>
    </div>
    <!-- <div>
      <select v-model="mode">
        <option value="1">제목</option>
        <option value="2">내용</option>
        <option value="3">제목+내용</option>
      </select>
      <input type="text" v-model="keyword" />
      <button @click="search">검색</button>
    </div> -->
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideoList",
  data() {
    return {
      mode: 1,
      keyword: "",
    };
  },
  computed: {
    ...mapState(["videos"]),
  },
  created() {
    this.$store.dispatch("getVideos");
  },
  methods: {
    search() {
      const payload = {
        mode: this.mode,
        keyword: this.keyword,
      };
      this.$store.dispatch("getVideos", payload);
    },
  },
};
</script>

<style></style>
