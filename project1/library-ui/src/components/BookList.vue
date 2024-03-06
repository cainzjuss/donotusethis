<template>
  <div>
    <h1>Raamatute Nimekiri</h1>
    <ul>
      <li v-for="book in books" :key="book.id">{{ book.title }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'BookList',
  data() {
    return {
      books: []
    }
  },
  created() {
    this.fetchBooks();
  },
  methods: {
    fetchBooks() {
      axios.get('http://localhost:8080/books')
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.error("There was an error fetching the books:", error);
        });
    }
  }
}
</script>

<style scoped>
/* Siia lisage oma stiilid */
</style>