import axios from "axios";

export default {

    createGame(game) {
        return axios.post('/games', game)
    }

}