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
                    <span class="heading">200</span>
                    <span class="description">Squat</span>
                  </div>
                  <div>
                    <span class="heading">200</span>
                    <span class="description">Bench-Press</span>
                  </div>
                  <div>
                    <span class="heading">200</span>
                    <span class="description">Dead-lift</span>
                  </div>
                </div>
              </div>
            </div>
            <div class="text-center mt-5">
              <h3>
                피까피까
                <span class="font-weight-light">, 1997-02-10 </span>
              </h3>
              <div class="h6 font-weight-300">
                <i class="ni location_pin mr-2" >남</i>
              </div>
              <div class="h6 mt-4">
                <i class="ni business_briefcase-24 mr-2"></i>커리어
              </div>
              <div><i class="ni education_hat mr-2"></i>2014 세계남자클래식보디빌딩선수권대회 -168cm급 1위
 </div>
              <div><i class="ni education_hat mr-2"></i>2015 전국체육대회 일반 -65kg급 1위
 </div>

              <div><i class="ni education_hat mr-2"></i>2015 세계남자클래식보디빌딩선수권대회 -168cm급 1위
 </div>

              <div><i class="ni education_hat mr-2"></i>2016 세계남자클래식보디빌딩선수권대회 클래식 보디빌딩 -168cm급 1위
 </div>

              <div><i class="ni education_hat mr-2"></i>2016 Mr.YMCA 선발대회 일반 -70kg급 1위
 </div>

              <div><i class="ni education_hat mr-2"></i>2018 세계남자클래식보디빌딩선수권대회 클래식 보디빌딩 -168cm급 1위 
 </div>

              <div><i class="ni education_hat mr-2"></i>2019 제 71회 Mr.Korea 선발대회 보디빌딩 일반-70kg급 1위
 </div>

              <div><i class="ni education_hat mr-2"></i>2019 제100회 전국체육대회 -70kg급 1위
</div>

              <div><i class="ni education_hat mr-2"></i>2020 제 72회 Mr.Korea 선발대회 보디빌딩 일반-75kg급 1위
</div>

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
  name: "Inbeom",
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
