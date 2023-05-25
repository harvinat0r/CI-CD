<template>
  <div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "Article",
};
</script>

<style>
.article-link {
  color: black;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

/* 테이블 CSS */
.article-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.article-list td,
.article-list th {
  border: 1px solid black;
}
</style>
