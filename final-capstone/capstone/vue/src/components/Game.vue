<template class="test">
  <div class="game-card">
    <div class="game-info">
      <h1>{{ game.gameName }}</h1>
      <p>Account Value:</p>
      <h2>Organized By: <br />{{ game.organizerName }}</h2>
    </div>
    <div class="buy-info">
      <span>Available Funds: $$$$$$</span>
      <form class="buy-form">
        <input type="text" placeholder="AAPL" />
        <input type="number" placeholder="Quantity" />
        <button class="buy">Buy</button>
      </form>
    </div>
    <div class="portfolio-container">
      <table class="portfolio">
        <tr class="head">
          <th>Ticker</th>
          <th>Quantity</th>
          <th>Value</th>
          <th></th>
        </tr>
        <tr class="row" v-for="i in 10" v-bind:key="i">
          <td>Ticker {{ i }}</td>
          <td>###</td>
          <td>$$$$$$</td>
          <td class="sell-row"><button class="sell">Sell</button></td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
export default {
  data() {
    return {
      game: {},
    };
  },
  created() {
    const id = this.$route.params.id;
    stockService.getGame(id).then((response) => {
      this.game = response.data;
    });
  },
};
</script>

<style scope>
.game-card {
  background: #9daac8;
  border-radius: 5px;

  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.game-info {
  display: flex;
  justify-content: space-between;
  padding: 0px 20px;
  font-size: 14px;
}

.game-info h2 {
  text-align: center;
  font-size: 16px;
}

.buy,
.sell {
  border-radius: 5px;
}

.buy-info {
  padding: 0px 20px 20px 20px;
  display: flex;
  justify-content: space-between;
}

.buy-form input {
  margin: 0px 5px;
}

.portfolio-container {
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
}

.portfolio {
  font-size: 13px !important;
  border: 1px solid #ccc;
  border-collapse: collapse;
  border-spacing: 0;
  width: 98%;
  display: table;
}

.portfolio tr:nth-child(odd) {
  background-color: #fff;
}

.portfolio tr:nth-child(even) {
  background-color: #f1f1f1;
}

.portfolio tr {
  border-bottom: 1px solid #ddd;
}

.portfolio th:first-child,
.portfolio td:first-child {
  padding-left: 20px;
}

.portfolio td,
.portfolio th {
  padding: 10px 10px;
  display: table-cell;

  vertical-align: top;
}

.portfolio th {
  font-weight: bold;
  text-align: left;
}

.sell-row {
  text-align: right;
}
</style>