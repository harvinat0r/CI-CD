<template>
  <div>
    <view-detail />
  </div>
</template>

<script>
import ViewDetail from "@/components/review/include/ViewDetail.vue";

export default {
  name: "MovieDetail",
  components: {
    ViewDetail
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];

    this.$store.dispatch("setMovie", id);
  },
};
</script>

<style></style>