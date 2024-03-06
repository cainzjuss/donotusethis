<template>
  <form @submit.prevent="addBook">
    <input v-model="title" placeholder="Pealkiri">
    <input v-model="author" placeholder="Autor">
    <button type="submit">Lisa raamat</button>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      title: '',
      author: ''
    };
  },
  methods: {
    addBook() {
      axios.post('http://localhost:8080/books', {
        title: this.title,
        author: this.author
      })
      .then(() => {
        this.title = '';
        this.author = '';
        // Võib-olla soovite siin teavitada kasutajat või värskendada nimekirja
      })
      .catch(error => {
        console.error("There was an error adding the book:", error);
      });
    }
  }
}
</script>