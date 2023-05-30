<template>
  <div>
      <form v-on:submit.prevent="createGame">
          <label for="name">Game Name </label>
          <input type="text" v-model="newGame.name"> <br>
          <label for="date">End Date </label>
          <input type="date" v-model="newGame.date"> <br>
          <button>Create</button>
      </form>
  </div>
</template>

<script>
import stockService from '../services/StockService.js'
export default {
    
    data() {
        return {
            newGame : {}
        }
    },
    methods: {
        createGame() {
            stockService.createGame(this.newGame).then(
                response => {
                    if(response.status === 200) {
                        this.newGame = {};
                        this.$router.push({name: 'home'})
                    }
                }
            )
        }
    }

}
</script>

<style>

</style>