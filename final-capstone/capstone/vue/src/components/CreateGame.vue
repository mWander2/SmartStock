<template>
  <div id="form-container">
      <form v-on:submit.prevent="createGame">
          <h1>Create Your Game</h1>
          <div class="form-input-group">
            <label for="name">Game Name</label>
            <input type="text" id="text" v-model="newGame.name"> 
          </div>
          <div class="form-input-group">
            <label for="date">End Date</label>
            <input type="date" id="date" v-model="newGame.date">
          </div>
          <div>
              <button type="submit">Create</button>
          </div>
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

<style scoped>

/* #form-container {
  display: flex;
  justify-content: center;
  align-items: center;
  align-self: center;
  flex-basis: 100%;
  text-align: center;
  width: 60%;
  background-color: #9daac8;
  color: rgb(31, 31, 56);
  border-radius: 10px;
} */

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

#form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 40vh;

    text-align: center;
    background-color: #9daac8;
    color: rgb(31, 31, 56);
    border-radius: 10px;
}

</style>