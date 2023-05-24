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
          <card
            type="secondary"
            shadow
            header-classes="bg-white pb-5"
            body-classes="px-lg-5 py-lg-5"
            class="border-0"
          >
            <template>
              <div class="text-center text-muted mb-4">
                <small>Login</small>
              </div>
              <br role="form" />
              <base-input
                alternative
                class="mb-3"
                placeholder="Id"
                addon-left-icon="ni ni-email-83"
                id = "id"
                v-model = "id"
              >
              </base-input>
              <base-input
                alternative
                type="password"
                placeholder="Password"
                addon-left-icon="ni ni-lock-circle-open"
                id = "password"
                v-model = "password"
              >
              </base-input>
              <base-checkbox>
                Remember me
              </base-checkbox>

              <div class="text-center">
                <base-button type="primary" class="my-4" @click = "login">로그인</base-button>
              </div>
            </template>
          </card>
          <div class="row mt-3">
            <div class="col-6">
              <a href="#" class="text-light">
                <small>Forgot password?</small>
              </a>
            </div>
            <div class="col-6 text-right">
              <router-link to="/user/register" class="text-light"
                ><small>Create new account</small></router-link
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
export default {
  name: "LoginForm",
    data() {
      return {
        id: "",
        password: "",
      };
    },
    methods: {
      login() {
        if (
          this.id.trim() === "" ||
          this.password.trim() === ""
         ) {
          alert("아이디와 비밀번호를 모두 입력해주세요");
          return;
        }

        let user = {
          id: this.id,
          password: this.password,
        };
  
        this.$store.dispatch("setLoginUser", user);
      },
    },
};
</script>
<style></style>
