import axios from 'axios';

const API_URL = 'http://localhost:8080/books';

export default {
    getBooks() {
        return axios.get(API_URL);
    },
    // Lisage meetodid raamatu lisamiseks, laenutamiseks ja tagastamiseks
};