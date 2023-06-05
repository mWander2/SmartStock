<template class="test">
  <div class="game-card">
    <div class="game-info">
      <h1>{{ game.gameName }}</h1>
      <p>Account Value:</p>
      <h2>Organized By: <br />{{ game.organizerName }}</h2>
    </div>
    <div class="buy-info">
      <span>Available Funds: ${{portfolio.cashBalance}}</span>
      <form class="buy-form" v-on:submit.prevent="buy">
        <input type="text" placeholder="AAPL" v-model="stock.ticker"/>
        <input type="number" placeholder="Quantity" v-model="stock.quantity"/>
        <button type="submit" class="buy">Buy</button>
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
        <tr class="row" v-for="stockPortfolio in stockList" v-bind:key="stockPortfolio.id">
          <td>{{stockPortfolio.ticker}}</td>
          <td>{{stockPortfolio.quantity}}</td>
          <td>$$$$$$</td>
          <td class="sell-row">
            <button class="sell" v-on:click="sell(stockPortfolio)">Sell</button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
// import polygonService from "../services/PolygonService.js"
export default {
  data() {
    return {
      gameId : this.$route.params.id,
      game : {},
      portfolio : {},
      stockList : [],
      stock : {
        ticker : "",
        quantity : "",
      },
    };
  },
  methods: {
    buy() { //COST CURRENTLY HARDCODED
      stockService.buy(this.stock, 500, this.gameId).then(
        response => {
          if(response.status == 200) {
            alert('Your purchase was successful!');
            this.$router.go();
          }
        }
      );
    },
    sell(stockPortfolio) { //COST CURRENTLY HARDCODED
      stockService.sell(500, this.gameId, stockPortfolio.id).then(
        response => {
          if(response.status == 200) {
            alert('Your sale was succesful!');
            this.$router.go();
          }
        }
      )
    }
  },
  created() {
    stockService.getGame(this.gameId).then(
      response => {
        this.game = response.data;
    });
    
    stockService.getPortfolio(this.gameId).then(
      response => {
        this.portfolio = response.data;
    });

    stockService.getPortfolioStocks(this.gameId).then(
      response => {
        this.stockList = response.data;
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