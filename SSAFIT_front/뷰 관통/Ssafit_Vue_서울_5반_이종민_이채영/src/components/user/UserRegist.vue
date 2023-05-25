<template>
  <div class="container">
    <h2>회원 가입</h2>
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
      <label for="nick_name">이름</label>
      <input type="text" id="nick_name" v-model="nick_name" class="view" /><br />
      <label for="email_address">이메일</label>
      <input type="email" id="email_address" v-model="email_address" class="view" /><br />
      <label for="phone_number">전화번호</label>
      <input type="text" id="phone_number" v-model="phone_number" class="view" /><br />
      <button class="btn" @click="regist">등록</button>
    </fieldset>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "UserList",
  data() {
    return {
      id: "",
      password: "",
      nick_name: "",
      email_address: "",
      phone_number: "",
    };
  },
  methods: {
    async getInfoFromAPI() {
      await this.$store.dispatch("setRandomUser");
      this.id = this.randomUser.id;
      this.password = this.randomUser.password;
      this.nick_name = this.randomUser.nick_name;
      this.email_address = this.randomUser.email_address;
      this.phone_number = this.randomUser.phone_number;
    },
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.nick_name === "" ||
        this.email_address === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        id: this.id,
        password: this.password,
        nick_name: this.nick_name,
        email_address: this.email_address,
        phone_number: this.phone_number,
      };

      this.$store.dispatch("createUser", user);
    },
  },
  computed: {
    ...mapState(["randomUser"]),
  },
};
</script>
