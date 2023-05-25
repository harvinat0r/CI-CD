<template>
  <div class="container">
    <h2>사용자 목록</h2>
    <h4>등록된 사용자의 수 : {{ userCnt }}</h4>
    <div class="overflow-auto" v-if="userCnt">
      <b-table-simple hover fixed id="user-table" :itemps="users" :per-page="perPage"
      :current-page="currentPage">
        <b-thead head-variant="dark">
          <b-tr>
            <b-th>번호</b-th>
            <b-th>아이디</b-th>
            <b-th>이름</b-th>
            <b-th>이메일</b-th>
            <b-th>나이</b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <b-tr v-for="(user, index) in pageBoardList" :key="index">
            <b-td>{{ index + (currentPage - 1) * perPage + 1}}</b-td>
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
      <b-pagination
        v-model="currentPage"
        :total-rows="userCnt"
        :per-page="perPage"
        align="center"
        aria-controls="user-table"
    ></b-pagination>
    </div>
    <div v-else>등록된 사용자가 없습니다.</div>
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "UserList",
  data() {
    return {
      currentPage:1,
      perPage: 10,
      mode: 1,
      keyword: '',
    };
  },
  methods: {},
  computed: {
    ...mapState(["users"]),
    ...mapGetters(["userCnt"]),
    pageBoardList(){
      const start = (this.currentPage-1) * this.perPage;
      const end = this.currentPage*this.perPage;
      
      return this.users.slice(start, end);
    },
  },
  created() {
    this.$store.dispatch("setUsers");
  },
};
</script>
