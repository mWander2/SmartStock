import axios from "axios";

export default {

    getAllGames() {
        return axios.get("/games")
    },

    createGame(game) {
        return axios.post('/games/new', game)
    },

    getGame(id) {
        return axios.get(`/games/${id}`)
    }
    
}