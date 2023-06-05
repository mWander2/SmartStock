import axios from "axios";

export default {

    getResults(ticker) {
        return axios.get('/resultsObject', ticker);
    }

}