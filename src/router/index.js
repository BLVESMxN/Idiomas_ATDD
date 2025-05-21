import { createRouter, createWebHistory } from 'vue-router'
import Inicio from '../views/Inicio.vue'
import Abecedario from '../components/Abecedario.vue'
import Numeros from '../components/Numeros.vue'
import SeleccionIdioma from '../components/SeleccionIdioma.vue'
import Idiomas from '../views/Idiomas.vue'
import Contactos from '../views/Contactos.vue'

const routes = [
  { path: '/', name: 'Inicio', component: Inicio },
  { path: '/idioma', name: 'SeleccionIdioma', component: SeleccionIdioma },
  { path: '/idiomas', name: 'Idiomas', component: Idiomas },
  { path: '/abecedario', name: 'Abecedario', component: Abecedario },
  { path: '/numeros', name: 'Numeros', component: Numeros },
  { path: '/contactos', name: 'Contactos', component: Contactos }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
