<template>
  <div class="profile-page">
    <section class="section-profile-cover section-shaped my-0">
      <div class="shape shape-style-1 shape-primary shape-skew alpha-4">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
    </section>
    <section class="section section-skew">
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                  <a href="#">
                    <img
                      v-if="loginUser.sbd <= 100"
                      v-lazy="'img/theme/pokemon/꼬마돌.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else-if="loginUser.sbd <= 200"
                      v-lazy="'img/theme/pokemon/데구리.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else-if="loginUser.sbd <= 300"
                      v-lazy="'img/theme/pokemon/딱구리.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else-if="loginUser.sbd <= 400"
                      v-lazy="'img/theme/pokemon/알통몬.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else-if="loginUser.sbd <= 500"
                      v-lazy="'img/theme/pokemon/근육몬.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else-if="loginUser.sbd <= 600"
                      v-lazy="'img/theme/pokemon/괴력몬.webp'"
                      class="rounded-circle"
                    />
                    <img
                      v-else
                      v-lazy="'img/theme/pokemon/피카츄.webp'"
                      class="rounded-circle"
                    />
                  </a>
                </div>
              </div>
              <div
                class="col-lg-4 order-lg-3 text-lg-right align-self-lg-center"
              >
                <div class="card-profile-actions py-4 mt-lg-0">
                  <base-button type="info" size="sm" class="mr-4"
                    >회원 정보 수정</base-button
                  >
                </div>
              </div>
              <div class="col-lg-4 order-lg-1">
                <div class="card-profile-stats d-flex justify-content-center">
                  <div>
                    <span class="heading">{{ loginUser.squat }}</span>
                    <span class="description">Squat</span>
                  </div>
                  <div>
                    <span class="heading">{{ loginUser.bench_press }}</span>
                    <span class="description">Bench-Press</span>
                  </div>
                  <div>
                    <span class="heading">{{ loginUser.dead_lift }}</span>
                    <span class="description">Dead-lift</span>
                  </div>
                </div>
              </div>
            </div>
            <div class="text-center mt-5">
              <h3>
                {{ loginUser.user_nickname }}
                <span class="font-weight-light">, {{ loginUser.birth }}</span>
              </h3>
              <div class="h6 font-weight-300">
                <i class="ni location_pin mr-2" v-if="loginUser.gender">남</i>
                <i class="ni location_pin mr-2" v-else>여</i>
              </div>
              <!-- <div class="h6 mt-4">
                <i class="ni business_briefcase-24 mr-2"></i>3분할
              </div>
              <div><i class="ni education_hat mr-2"></i>가슴 등 어깨</div> -->
            </div>
            <div class="mt-5 py-5 border-top text-center">
              <div class="row justify-content-center">
                <div class="col-lg-9">
                  <p>
                    운동하기 좋은 날입니다
                  </p>
                  <a href="http://localhost:8080">메인 페이지</a>
                </div>
              </div>
            </div>
          </div>
        </card>
      </div>
    </section>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "ProfileView",
  computed: {
    ...mapState(["loginUser"]),
  },
  created() {},
  methods: {
    updateUser() {
      this.$router.push({ name: "updateUser" });
    },
    age() {
      let birth_year = new Date(this.loginUser.birth);
      let year = birth_year.getFullYear();
      let age = 2023 - year + 1;
    },
  },
};
</script>
<style></style>
