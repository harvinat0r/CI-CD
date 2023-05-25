<template>
  <!-- 아래꺼가 색깔임 -->
  <div>
    <div class="shape shape-style-1 bg-gradient-default">
      <section class="section section-skew">

      </section>
    </div>
    <!-- <div v-for="(user, index) in users" :key="user.user_id" class="ranking">
      <div class="ranking-no">{{ index + 1 }}</div>
      <div class="picture">
        <img :src="streamer.picture" />
      </div>
      <div class="sbd">{{ user.sbd }}</div>
      <div class="sqaut">{{ user.squat }}</div>
    </div> -->
    <tbody>
      <tr v-for="(user) in users" :key="user.user_id">
        <td>
          <router-link class="TotalRanking" :to="`/ranking`">{{
            user.user_nickname
          }}</router-link>
        </td>
      </tr>
    </tbody>
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
  props: {

  },
  created() {
    this.$store.dispatch("setUsers"), users;
  },
}
</script>