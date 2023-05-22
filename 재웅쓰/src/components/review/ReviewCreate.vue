<template>
  <div>
    <h3>리뷰 등록</h3>
    <fieldset>
      <legend>등록</legend>
      <label for="title">제목 : </label>
      <input type="text" id="title" v-model="title" /><br />
      <label for="content">내용 : </label>
      <textarea id="content" cols="30" rows="10" v-model="content"></textarea>
      <button @click="ReviewCreate">등록</button>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: 'ReviewCreate',
  data() {
    return {
      title: '',
      content: '',
    };
  },
  methods: {
    ReviewCreate() {
      // const pathName = new URL(document.location).pathname.split('/');
    // const id = pathName[pathName.length - 1];
      // let VideoID = 


      let Review = {
        reviewNum: 0,
        title: this.title,
        userId: 'ssafy',
        content: this.content,
        youtubeId : 'gMaB-fG4u4g',
      };

      this.$store.dispatch('createReview', Review);
    },
  },
};
</script>

<style></style>
