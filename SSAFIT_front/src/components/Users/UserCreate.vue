<template>
    <div class="container">
      <h2 class="text-center">회원 가입</h2>
      <fieldset class="text-center">
        <label for="id">아이디</label>
        <input type="text" id="id" v-model="id" class="view" /><br />
        <label for="password">비밀번호</label>
        <input
          type="password"
          id="password"
          v-model="password"
          class="view"
        /><br />
        <label for="name">이름</label>
        <input type="text" id="name" v-model="name" class="view" /><br />
        <b-button variant="success" @click="regist">등록</b-button>
      </fieldset>
    </div>
  </template>
  <script>
  export default {
    name: "userCreate",
    data() {
      return {
        id: "",
        password: "",
        name: "",
      };
    },
    methods: {
      regist() {
        if (
          this.id.trim === "" ||
          this.password.trim === "" ||
          this.name.trim === ""
         ) {
          alert("모든 내용을 입력해주세요");
          return;
        }
  
        let user = {
          id: this.id,
          password: this.password,
          name: this.name,
        };
  
        this.$store.dispatch("createUser", user);
      },
    },
  };
  </script>
  