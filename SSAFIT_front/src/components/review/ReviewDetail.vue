<template>
  <div>
    <div>댓글 상세</div>
    <div>{{ review.title }}</div>
    <div>{{ review.viewCnt }}</div>
    <div>{{ review.writer }}</div>
    <div>{{ review.regDate }}</div>
    <div>{{ review.content }}</div>
    <router-link :to="`../reviewupdate/${review.reviewNum}`"><button>수정</button></router-link>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'ReviewDetail',
  computed : {
    ...mapState(['review']),
  },
  created() {
    const pathName = new URL(document.location).pathname.split('/');
    const id = pathName[pathName.length - 1];
    this.$store.dispatch('getReview', id);
  },
  methods: {
    moveUpdate() {
      this.$router.push({ name: 'reviewUpdate' });
    },
    deleteBoard() {
      this.$store.dispatch('deleteBoard', this.board.id);
    },
  },
}
</script>

<style>

</style>