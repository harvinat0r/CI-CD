<template>
  <div>
    <div>{{ review.viewCnt }}</div>
    <div>{{ review.title }}</div>
    <div>{{ review.writer }}</div>
    <div>{{ review.regDate }}</div>
    <div>{{ review.content }}</div>

  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'ReviewDetail',
  computed : {
    ...mapState(['review']),
  },
  created(){

  }
}
</script>

<style>

</style>