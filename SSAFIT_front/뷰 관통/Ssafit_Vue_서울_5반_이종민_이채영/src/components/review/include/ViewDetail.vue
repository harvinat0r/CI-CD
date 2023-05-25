<template>
  <div class="container">
    <h2>영화 정보</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input readonly type="text" id="id" v-model="movie.id" class="view" /><br />
      <label for="title">제목</label>
      <input readonly type="text" id="title" v-model="movie.title" class="view" /><br />
      <label for="director">감독</label>
      <input readonly type="text" id="director" v-model="movie.director" class="view" /><br />
      <label for="genre">장르</label>
      <input readonly type="text" id="genre" v-model="movie.genre" class="view" /><br />
      <label for="runningTime">상영시간</label>
      <input readonly type="number" id="runningTime" v-model="movie.runningTime" class="view" /><br />
      <button class="btn" @click="moveToModify">수정하기</button>
      <button class="btn" @click="moveToList">목록가기</button>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "MovieDetail",
  methods: {
    moveToModify() {
      this.$router.push(`/movie/modify/${this.movie.id}`)
    },
    moveToList() {
      this.$router.push(`/movie`)
    },
  },
  computed: {
    ...mapState(["movie"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];

    this.$store.dispatch("setMovie", id);
  },
};
</script>

<style></style>