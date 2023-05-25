<template>
  <section class="section section-shaped section-lg my-0">
    <div class="shape shape-style-1 bg-gradient-default">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container pt-lg-md">
      <div class="row justify-content-center">
        <div class="col-lg-5">
          <card type="secondary" shadow header-classes="bg-white pb-5" body-classes="px-lg-5 py-lg-5" class="border-0">
            <template>
              <div class="text-muted text-center mb-3">
                <small>회원 정보 수정</small>
              </div>

            </template>
            <template>

              <form role="form">
                
                <base-input alternative class="mb-3" placeholder="Squat" addon-left-icon="ni ni-hat-3" v-model = "loginUser.squat"></base-input>
                <base-input alternative class="mb-3" placeholder="Bench Press" addon-left-icon="ni ni-hat-3" v-model = "loginUser.bench_press"></base-input>
                <base-input alternative class="mb-3" placeholder="Dead Lift" addon-left-icon="ni ni-hat-3" v-model = "loginUser.dead_lift"></base-input>
                
                <div class="text-muted font-italic">
                  <small>당신의 근육:
                    <span class="text-success font-weight-700">부족해</span>
                  </small>
                </div>
               
                <div class="text-center">
                  <base-button type="primary" class="my-4" @click ="updateUser">3대 수정</base-button>
                </div>
              </form>
            </template>
          </card>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { mapState } from 'vuex';
export default {

  name: 'UpdateView',
  computed: {
    ...mapState(['loginUser']),
  },
  methods: {
    updateUser() {
      
      this.$store.dispatch('updateUser', this.loginUser);
    },
  },

};
</script>
<style></style>
