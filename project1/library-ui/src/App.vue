<template>
  <div id="app">
    <BookList/>
  </div>
</template>

<script>
import BookList from './components/BookList.vue'

export default {
  name: 'App',
  components: {
    BookList
  }
}
</script>

<style scoped>
h1 {
  color: blue;
}
</style>