<template>
  <div class="createGame">
    <div class="instructions">
      <h1>How to Play</h1>
      <ol>
        <li>
          Your initial virtual currency or investment amount is set to $100,000!
          This is the amount of money you will use to buy and sell stocks within
          the game.
        </li>
        <li>
          Research and explore available stocks you are interested. Analyze
          their historical performance, current prices, company news, and any
          other relevant information provided.
        </li>
        <li>
          Use the game's interface to buy stocks. Enter the ticker symbol, the
          quantity of shares you want to buy, and confirm your purchase.
        </li>
        <li>
          Monitor your portfolio. Keep track of the stocks you own, their
          current prices, and the overall value of your holdings to make
          informed decisions to buy or sell stocks.
        </li>
        <li>
          Keep playing! Adjust your investment strategy, buying or selling
          stocks as needed, to maximize your profits and portfolio value.
          Explore our competitions, challenges, and leaderboards to learn more!
        </li>
      </ol>
    </div>
    <div id="form-container">
      <form v-on:submit.prevent="createGame">
        <h1>Create Your Game</h1>
        <div class="form-input-group">
          <label for="name">Game Name</label>
          <input type="text" id="text" v-model="newGame.gameName" />
        </div>
        <div class="form-input-group">
          <label for="date">End Date</label>
          <input type="date" id="date" v-model="newGame.endDate" />
        </div>
        <div>
          <button type="submit">Create</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
export default {
  data() {
    return {
      newGame: {},
    };
  },
  methods: {
    createGame() {
      stockService.createGame(this.newGame).then((response) => {
        if (response.status === 201) {
          this.newGame = {};
          this.$router.push({ name: "home" });
        }
      });
    },
  },
};
</script>

<style scoped>

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
  height: 35vh;

  text-align: center;
  background-color: #9daac8;
  color: rgb(31, 31, 56);
  border-radius: 10px;
  border: 1px solid rgb(31, 31, 56);
}

.instructions {
  background: #cff5ea;
  border-radius: 10px;
  padding: 20px 10px 20px 0px;
  margin-top: -10px;
  margin-bottom: 10px;
  border: 1px solid rgb(31, 31, 56);

  display: flex;
  flex-direction: column;
  align-items: center;
}

.instructions ol {
  line-height: 2;
}
</style>