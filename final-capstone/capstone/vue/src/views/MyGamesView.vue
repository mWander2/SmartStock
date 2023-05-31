<template>
  <div>
      <h2>My Games</h2>
      <div class="game-container">
          <div v-for="game in gamesList" v-bind:key="game.id">
            <h2>{{game.name}}</h2>
            <router-link v-bind:to="{name: 'view-game', params: {id: game.id}}">
                  View Game
            </router-link>
          </div>
      </div>
      

  </div>
</template>

<script>
import stockService from '../services/StockService.js'
export default {
    name: "my-games",
    data() {
        return {
            gamesList : []
        }
    },
    created() {
        stockService.getAllGames().then(
            response => {
                this.gamesList = response.data;
            }
        )
    }
    
}
</script>

<style>

</style>