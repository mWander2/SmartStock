<template>
  <div class ="view-game">
    <game class="game"/>
    <leaderboard class="leaderboard"/>
  </div>
</template>

<script>
import Game from '../components/Game.vue';
import Leaderboard from '../components/Leaderboard.vue';

export default {
  components: {
    Game,
    Leaderboard
  },  
}
</script>

<style scope>

.view-game {
  display: flex;
  flex-direction: column;
}

.leaderboard {
  margin-bottom: 10px;
}

</style>