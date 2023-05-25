<template>
  <section class="section section-lg section-shaped overflow-hidden my-0">
    <div class="shape shape-style-1 shape-default shape-skew">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container py-0 pb-lg">
      <div class="row justify-content-between align-items-center">
        <div class="col-lg-5 mb-5 mb-lg-0">
          <h1 class="text-white font-weight-light">주목해야 할 운동</h1>
          <p class="lead text-white mt-2">{{ time }} 기준</p>
          <p class="lead text-white mt-4">
            태어날때 돼지(멸치)로 태어난 것은 당신의 잘못이 아니지만 죽을때
            돼지(멸치)로 죽는 것은 당신의 잘못이다.
          </p>
          <div class="container mb-5">
            <!-- Inputs -->
            <h3 class="h4 text-success font-weight-bold mb-4">Inputs</h3>
            <fieldset class="row col-lg-12 col-sm-6">
              <base-input
                placeholder="운동 이름 검색. ex) 벤치프레스"
                addon-left-icon="ni ni-zoom-split-in"
              >
              </base-input>
              <base-button type="primary" @click="search">Button</base-button>
            </fieldset>
          </div>
        </div>
        <div class="col-lg-6 mb-lg-auto">
          <div
            class="rounded shadow-lg overflow-hidden transform-perspective-right"
          >
            <b-carousel id="carousel1" controls indicators>
              <!-- Text slides with image -->
              <b-carousel-slide
                v-for="(exercise, index) in exercises"
                :key="index"
                :img-src="`img/theme/exercise/${exercise.exercise_name}.jpg`"
                >{{ exercise.exercise_name }}</b-carousel-slide
              >
            </b-carousel>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { BCarousel } from "bootstrap-vue/esm/components/carousel/carousel";
import { BCarouselSlide } from "bootstrap-vue/esm/components/carousel/carousel-slide";
import { mapState } from "vuex";

export default {
  components: {
    BCarousel,
    BCarouselSlide,
  },
  data() {
    return {
      time: "",
    };
  },
  computed: {
    ...mapState(["exercises"]),
  },
  created() {
    // 시간 세팅
    let today = new Date();
    this.time = today.toLocaleDateString();

    // 주목해야 할 운동 설정
    this.$store.dispatch("setExercises");
  },
};
</script>
<style></style>
