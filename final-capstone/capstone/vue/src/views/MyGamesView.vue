<template>
  <div class="games">
    <h2>My Games</h2>
    <div class="game-container" v-for="game in myGames" v-bind:key="game.gameId">
        <h2>{{game.gameName}}</h2>
        <p>{{game}}</p>
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
            gamesList : [],
            myGames : [],
            user : this.$route.params.user
        }
    },
    created() {
        stockService.getAllGames().then(
            response => {
                this.gamesList = response.data;
            }
        ),
        stockService.showMyGames(this.user).then(
            response => {
                this.myGames = response.data;
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