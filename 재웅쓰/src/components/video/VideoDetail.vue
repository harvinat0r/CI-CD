<template>
  <div>
    <h3>비됴 상세보기</h3>

    <div>
      <b-embed v-model="uId" type="iframe" aspect="16by9" :src= "videoURL"
        allowfullscreen></b-embed>
    </div>

    <div>{{ video.title }}</div>
    <div>{{ video.viewCnt }}</div>
    <div>{{ video.writer }}</div>
    <div>{{ video.regDate }}</div>
    <div>{{ video.content }}</div>

    <button @click="moveUpdate">수정</button>
    <button @click="deleteBoard">삭제</button>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideoDetail",
  data(){
    return {
      uId: "",
      
    }
  },


  computed : {
    ...mapState(['video']),
    videoURL(){

      return `https://www.youtube.com/embed/${this.uId}`;
    }

  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    console.log(pathName.length);
    const id = pathName[pathName.length - 2];
    this.uId = pathName[pathName.length - 2];
    console.log(this.uId)
    this.$store.dispatch("getVideo", id);
  },
  methods: {
    moveUpdate() {
      this.$router.push({ name: "videoUpdate" });
    },
    deleteBoard() {
      this.$store.dispatch("deleteVideo", this.video.id);
    },
  },
};
</script>

<style></style>
