<template>
  <section class="section section-lg section-shaped overflow-hidden my-0">
    <div class="shape shape-style-1 shape-default shape-skew">
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
  </section>
</template>

<script>
export default {
  name: "VideoList",
  data() {
    return {
      videos: [],
      mode: 1,
      keyword: "",
    };
  },
  created() {
    const REST_API = `http://localhost:9999`;

    axios({
        url: `${REST_API}/`,
        method: "GET",
        params,
      })
        .then((res) => {
          commit("GET_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
  },
  methods: {
  },
};
</script>

<style></style>
