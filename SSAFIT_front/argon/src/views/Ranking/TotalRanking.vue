<template>
  <!-- 아래꺼가 색깔임 -->
  <div>
    <div class="shape shape-style-1 bg-gradient-default">
      <section class="section section-skew"></section>
    </div>
    <!-- <div v-for="(user, index) in users" :key="user.user_id" class="ranking">
      <div class="ranking-no">{{ index + 1 }}</div>
      <div class="picture">
        <img :src="streamer.picture" />
      </div>
      <div class="sbd">{{ user.sbd }}</div>
      <div class="sqaut">{{ user.squat }}</div>
    </div> -->
    <!-- <tbody>
      <tr v-for="user in users" :key="user.user_id">
        <td>
          <router-link class="TotalRanking" :to="`/ranking`">{{
            user.user_nickname
          }}</router-link>
        </td>
      </tr>
    </tbody> -->
    <br />
    <br />
    <br />
    <br />
    <div>
      <b-table-simple hover :items="users">
        <b-thead class="text-center">
          <b-tr>
            <b-th>순위</b-th>
            <b-th>닉네임</b-th>
            <b-th>SBD</b-th>
            <b-th>Squat</b-th>
            <b-th>Bench-Press</b-th>
            <b-th>Dead-Lift</b-th>
          </b-tr>
        </b-thead>
        <b-tbody class="text-center">
          <b-tr v-for="(user, index) in users" :key="user.user_id">
            <b-td>{{ index + 1 }}</b-td>
            <b-td>
              <b-link :to="`/user/${user.user_id}`">{{
                user.user_nickname
              }}</b-link>
            </b-td>
            <b-td>{{ user.sbd }}</b-td>
            <b-td>{{ user.squat }}</b-td>
            <b-td>{{ user.bench_press }}</b-td>
            <b-td>{{ user.dead_lift }}</b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";

export default {
  name: "TotalRanking",
  computed: {
    ...mapState(["users"]),
    ...mapState(["loginUser"]),
  },
  props: {},
  created() {
    this.$store.dispatch("setUsers");
  },
};
</script>
