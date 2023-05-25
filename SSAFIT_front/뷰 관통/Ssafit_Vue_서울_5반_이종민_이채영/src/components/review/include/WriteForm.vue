<template>
  <div class="container">
    <h2>영화 등록</h2>
    <fieldset class="text-center">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="director">감독</label>
      <input type="text" id="director" v-model="director" class="view" /><br />
      <label for="genre">장르</label>
      <input type="text" id="genre" v-model="genre" class="view" /><br />
      <label for="runningTime">상영시간</label>
      <input type="number" id="runningTime" v-model="runningTime" class="view" /><br />
      <button class="btn" @click="create">등록</button>
      <button class="btn" @click="moveToList">목록</button>
    </fieldset>
  </div>
</template>

<script>
import { mapGetters, mapState } from 'vuex';
export default {
  name: "WriteForm",
  data() {
    return {
      id: 0,
      title: "",
      director: "",
      genre: "",
      runningTime: 0,
    };
  },
  methods: {
    create() {
      if (
        this.title === "" ||
        this.director === "" ||
        this.genre === "" ||
        this.runningTime === 0
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let lastreview = this.reviews[this.reviews.length - 1];
      let newId = 0;
      if (lastreview) {
        newId = lastreview.id + 1;
      }
      let review = {
        id: newId,
        title: this.title,
        director: this.director,
        genre: this.genre,
        runningTime: this.runningTime,
      };

      this.$store.dispatch("createreview", review);
    },
    moveToList() {
      this.$router.push("/review");
    },
  },
  computed: {
    ...mapGetters(["reviewCnt"]),
    ...mapState(["reviews"]),
  },
}
</script>

<style></style>