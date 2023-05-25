<template>
  <div class="container">
    <h2>루틴연구소</h2>
    <h4>등록된 사용자의 수 : {{ articleCnt }}</h4>
    <div v-if="articleCnt">
      <table class="user-list">
        <colgroup>
          <col style="width: 10%" />
          <col style="width: 25%" />
          <col style="width: 15%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 30%" />
        </colgroup>
        <thead head-variant="dark">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>좋아요</th>
            <th>싫어요</th>
            <th>조회수</th>
            <th>등록날짜</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(article, index) in articles" :key="index">
            <td>{{ index + 1 }}</td>
            <td>
              <router-link
                class="article-link"
                :to="`detail/${article.article_id}`"
                >{{ article.article_title }}</router-link
              >
            </td>
            <td>{{ article.user_id }}</td>
            <td>{{ article.article_like_cnt }} 개</td>
            <td>{{ article.article_unlike_cnt }} 개</td>
            <td>{{ article.article_view_cnt }} 번</td>
            <td>{{ article.article_reg_date }}</td>
          </tr>
        </tbody>
      </table>
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
    this.$store.dispatch("setArticles", 0);
  },
};
</script>

<style></style>
