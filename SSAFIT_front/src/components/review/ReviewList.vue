<template>
    <div>
    <h3>리뷰 목록</h3>
    <hr />
    <div>
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>쓰니</th>
          <th>등록일</th>
        </tr>
        <tr v-for="review in reviews" :key="review.id">
          <td>{{ review.reviewNum }}</td>
          <td>
            <router-link :to="`reviewdetail/${review.reviewNum}`">{{
              review.title
            }}</router-link>
          </td>
          <td>{{ review.userId }}</td>
          <td>{{ review.viewCnt }}</td>
          <td>{{ review.regDate }}</td>
        </tr>
      </table>
    </div>
    <div>
      <select v-model="mode">
        <option value="1">제목</option>
        <option value="2">내용</option>
        <option value="3">제목+내용</option>
      </select>
      <input type="text" v-model="keyword" />
      <button @click="search">검색</button>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
    name: 'ReviewList',
  data() {
    return {
      mode: 1,
      keyword: '',
    };
  },
  computed: {
    ...mapState(['reviews']),
  },
  created() {
    this.$store.dispatch('getReviews');
  },
  methods: {
    search() {
      const payload = {
        mode: this.mode,
        keyword: this.keyword,
      };
      this.$store.dispatch('getReviews', payload);
    },
  },
}
</script>

<style>

</style>