<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <router-link :to="`movie/detail/${id}`">{{ title }}</router-link>
    </td>
    <td>{{ director }}</td>
    <td>{{ genre }}</td>
    <td>{{ runningTime }} 분</td>
  </tr>
</template>

<script>
export default {
  name: "ListRow",
  props: {
    no: String,
    id: Number,
    title: String,
    director: String,
    genre: String,
    runningTime: Number
  },
  methods: {
  }
}
</script>

<style></style>