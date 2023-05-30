<template>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{name: 'create-game'}">
        Create Game
    </router-link>
    <br>
    <router-link v-bind:to="{name: 'my-games'}">
      My Games
    </router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

</style>
