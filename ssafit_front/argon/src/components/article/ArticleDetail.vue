<template>
  <div class="container">
    <h2>게시글 상세</h2>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "ArticleDetail",
  methods: {
    updateUser() {
      this.$store.dispatch("updateUser", this.article);
    },
    deleteUser() {
      this.$store.dispatch("deleteUser", this.article.article_id);
    },
  },
  computed: {
    ...mapState(["article"]),
  },
  created() {
    const pathName = new URL(document.location).href.split("/");
    const article_id = pathName[pathName.length - 1];
    console.log(new URL(document.location));
    this.$store.dispatch("setArticle", article_id);
  },
};
</script>
<style></style>
