<template>
  <div>
    <h2>리뷰 수정</h2>
    <fieldset>
      <legend>수정</legend>
      <label for="title">제목 : </label>
      <input type="text" id="title" v-model="review.title" /><br />
      <label for="writer">쓴이 : </label>
      <input type="text" id="writer" readonly v-model="review.userId" /><br />
      <label for="content">내용 : </label>
      <textarea
        id="content"
        cols="30"
        rows="10"
        v-model="review.content"
      ></textarea>
      <button @click="updateReview">수정</button>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'ReviewUpdate',
  computed: {
    ...mapState(['review']),
  },
  methods: {
    updateReview() {
      // let Review = {
      //   reviewNum: this.review.reviewNum,
      //   title: this.review.title,
      //   content: this.review.content,
      // };
      this.$store.dispatch('updateReview', this.review);
    },
  },
};
</script>

<style></style>
