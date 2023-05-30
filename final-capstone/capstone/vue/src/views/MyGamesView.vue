<template>
  <div>
      <game v-for="i in 3" v-bind:key="i"/>
  </div>
</template>

<script>
import Game from '../components/Game.vue'
export default {
    components: {
        Game
    }
}
</script>

<style>

</style>