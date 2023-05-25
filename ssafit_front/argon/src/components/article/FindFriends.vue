<template>
  <div class="container">
    <h2>헬스 친구 찾기</h2>
    <h4>등록된 사용자의 수 : {{ articleCnt }}</h4>
    <div v-if="articleCnt">
      <b-table-simple class="user-list">
        <colgroup>
          <col style="width: 10%" />
          <col style="width: 25%" />
          <col style="width: 15%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 30%" />
        </colgroup>
        <b-thead head-variant="text-center">
          <b-tr>
            <b-th>번호</b-th>
            <b-th>제목</b-th>
            <b-th>작성자</b-th>
            <b-th>좋아요</b-th>
            <b-th>싫어요</b-th>
            <b-th>조회수</b-th>
            <b-th>등록날짜</b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <b-tr v-for="(article, index) in articles" :key="index">
            <b-td>{{ index + 1 }}</b-td>
            <b-td>
              <router-link
                class="article-link"
                :to="`detail/${article.article_id}`"
                >{{ article.article_title }}</router-link
              >
            </b-td>
            <b-td>{{ article.user_id }}</b-td>
            <b-td>{{ article.article_like_cnt }} 개</b-td>
            <b-td>{{ article.article_unlike_cnt }} 개</b-td>
            <b-td>{{ article.article_view_cnt }} 번</b-td>
            <b-td>{{ article.article_reg_date }}</b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
    </div>
    <div v-else>등록된 글이 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "Free",
  data() {
    return {};
  },
  methods: {},
  computed: {
    ...mapState(["articles"]),
    ...mapGetters(["articleCnt"]),
  },
  created() {
    this.$store.dispatch("setArticles", 2);
  },
};
</script>

<style></style>
