<template>
  <div class="container">
    <div class="text-center">
      <input
        class="view"
        type="text"
        v-model="search"
        placeholder="이름을 입력하세요."
      />
      <b-button variant="success" @click="searchUser">검색</b-button>
    </div>
    <br />
    <hr />
    <div>
      <h2>검색 결과</h2>
      <div v-if="searchUserCnt">
        <b-table-simple hover fixed :items="searchUsers">
          <b-thead>
            <b-tr>
              <b-th>번호</b-th>
              <b-th>아이디</b-th>
              <b-th>이름</b-th>
              <b-th>이메일</b-th>
              <b-th>나이</b-th>
            </b-tr>
          </b-thead>
          <b-tbody>
            <b-tr v-for="(user, index) in searchUsers" :key="index">
              <b-td>{{ index + 1 }}</b-td>
              <b-td>
                <b-link class="user-link" :to="`/${user.id}`">{{
                  user.id
                }}</b-link>
              </b-td>
              <b-td>{{ user.name }}</b-td>
              <b-td>{{ user.email }}</b-td>
              <b-td>{{ user.age }} 세</b-td>
            </b-tr>
          </b-tbody>
        </b-table-simple>
      </div>
      <div v-else>검색 결과가 없습니다.</div>
    </div>
    <br />
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "UserSearch",
  data() {
    return {
      search: "",
    };
  },
  methods: {
    searchUser() {
      this.$store.dispatch("searchName", this.search);
    },
  },
  computed: {
    ...mapState(["searchUsers"]),
    ...mapGetters(["searchUserCnt"]),
  },
};
</script>
