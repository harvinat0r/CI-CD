<template>
    <div class="container">
      <img src="@/assets/main.png" />
      <h2>{{ message }}</h2>
      <router-view></router-view>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HomeView',
    data() {
        return {
            message: "NO pain, No gain!",
        };
    },
  };
  </script>

  <style></style>