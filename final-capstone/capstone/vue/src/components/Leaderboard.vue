<template>
  <div class="container">
      <h1>Leaderboard</h1>
      <table class="leaderboard-table">
          <tr class="head">
              <th>Player</th>
              <th>Account Value</th>
          </tr>
          <tr class="row" v-for="user in userList" v-bind:key="user.id">
              <td>{{user.username}}</td>
              <td>$$$$$$</td>
          </tr>
      </table>
  </div>
</template>

<script>
import userService from '../services/AuthService.js'
export default {
    data() {
        return {
            gameId : this.$route.params.id,
            userList : []
        }
    },
    created() {
        userService.getUsers(this.gameId).then(
            response => {
                this.userList = response.data;
            }
        )
    }
}
</script>

<style scope>

h1 {
    text-align: center;
}

.leaderboard-table tr:nth-child(odd) {
    background-color: #fff;
}

.leaderboard-table tr:nth-child(even) {
    background-color: #f1f1f1;
}

.leaderboard-table tr {
    border-bottom: 1px solid #ddd;
}

.leaderboard-table th:first-child, 
.leaderboard-table td:first-child {
    padding-left: 20px;
}

.leaderboard-table td, 
.leaderboard-table th {
    padding: 10px 10px;
    display: table-cell;
    text-align: left;
    vertical-align: top;
}

.leaderboard-table th {
    font-weight: bold;
}
 
.leaderboard-table {
    font-size: 16px!important;
    border: 1px solid #ccc;
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    display: table;
}

</style>