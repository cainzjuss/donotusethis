import { createRouter, createWebHistory } from 'vue-router';
import BookList from '../components/BookList.vue';

const routes = [
  {
    path: '/books',
    name: 'Books',
    component: BookList
  },
  // Teised marsruudid...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
