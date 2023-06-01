<template>
  <div class="games">
    <h2>My Games</h2>
    <div class="game-container" v-for="game in gamesList" v-bind:key="game.gameId">
        <h2>{{game.gameName}}</h2>
        <router-link v-bind:to="{name: 'view-game', params: {id: game.gameId}}">
            View Game
        </router-link>
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
        stockService.showMyGames().then(
            (response) => {
                this.gamesList = response.data;

            }
        )
    }
    
}
</script>

<style scope>

.games {
    display: flex;
    flex-direction: column;
    height: 100%;
}

</style>