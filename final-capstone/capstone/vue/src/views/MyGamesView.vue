<template>
  <div class="games">
    <!-- <h2>My Games</h2> -->
    <!-- <div class="game-container" v-for="game in gamesList" v-bind:key="game.gameId">
      <h2>{{ game.gameName }}</h2>
      <h3>Ends: {{ game.endDate }}</h3>
      <router-link v-bind:to="{ name: 'view-game', params: { id: game.gameId } }">
        View Game
      </router-link>
    </div> -->
    <table class="game-table">
        <tr class="head">
            <th>Name</th>
            <th>End Date</th>
            <th class="right">Go</th>
        </tr>
        <tr class="row" v-for="game in gamesList" v-bind:key="game.gameId">
            <td>{{game.gameName}}</td>
            <td>{{game.endDate}}</td>
            <td class="right">
                <router-link v-bind:to="{ name: 'view-game', params: { id: game.gameId } }">
                    View Game
                </router-link>
            </td>
        </tr>
    </table>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
export default {
  name: "my-games",
  data() {
    return {
      gamesList: [],
      user : this.$store.state.user.username
    };
  },
  created() {
    stockService.getAllGames().then((response) => {
      const games = response.data;
      this.gamesList = games.filter(g => g.organizerName === this.user);
    });
  },
};
</script>

<style scope>

.games {
   flex-grow: 1;
   color:  rgb(31, 31, 56);
}

.game-table tr:nth-child(odd) {
    background-color: #fff;
}

.game-table tr:nth-child(even) {
    background-color: #f1f1f1;
}

.game-table tr {
    border-bottom: 1px solid #ddd;
}

.game-table th:first-child, 
.game-table td:first-child {
    padding-left: 20px;
}

.game-table td, 
.game-table th {
    padding: 10px 10px;
    display: table-cell;
    text-align: left;
    vertical-align: top;
}

.game-table th {
    font-weight: bold;
}
 
.game-table {
    font-size: 16px!important;
    border: 1px solid #ccc;
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    display: table;
}
</style>