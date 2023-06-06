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

*, html {
    font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  }

.view-game {
  background-color: #052641;
    color: white;
  
    text-align: center;
    /* border-radius: 10px; */
    border: solid 1px #052641;
}

.leaderboard {
  margin-bottom: 10px;
  border: solid 1px #052641;
  color: #052641
}

.game{
  background-color: #052641;
    color: white;
    text-align: center;
    /* border-radius: 10px; */
}

button{
  border-radius: 5px;
  background-color: #052641;
    font-weight: bold;
    color: white;
    border: solid 1px;
    cursor: pointer;
    padding: 5px 10px;
    font-size: 14px;
    text-decoration: none;
    margin-left: 10px;
}

</style>