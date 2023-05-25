<template>
  <div class="container">
    <h2>영화 목록</h2>
    <h4>등록된 영화의 수 : {{ reviewCnt }}</h4>
    <hr />
    <div v-if="reviews.length">
      <table class="review-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>감독</th>
            <th>내용</th>
            <th>상영 시간</th>
          </tr>
        </thead>
        <tbody>
          <list-row v-for="(review, index) in reviews" :key="index" :no="`${index + 1}`" :id="review.id" :title="review.title"
            :director="review.director" :genre="review.genre" :runningTime="review.runningTime" />
        </tbody>

      </table>
    </div>
    <div v-else>등록된 영화가 없습니다.</div>
    <button @click="moveToPage">영화 등록</button>
  </div>
</template>

<script>
import ListRow from "@/components/review/include/ListRow.vue";
import { mapGetters, mapState } from 'vuex';
export default {
  components: {
    ListRow
  },
  computed: {
    ...mapGetters(['reviewCnt']),
    ...mapState(['reviews'])
  },
  created() {
    this.$store.dispatch("setreviews");
  },
  methods: {
    moveToPage() {
      this.$router.push({ name: "Create" });
    },
  }

};
</script>

<style></style>