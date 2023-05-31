import axios from "axios";

export default {

    getAllGames() {
        return axios.get("/allGames")
    },

    createGame(game) {
        return axios.post('/games', game)
    }

}