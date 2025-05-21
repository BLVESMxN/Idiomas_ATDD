<template>
    <nav class="navbar">
      <div class="logo">🌈 Aprendo Jugando 3L</div>
      <ul class="nav-links">
        <li>
          <RouterLink to="/">🏠 Inicio</RouterLink>
        </li>
        <li>
          <RouterLink to="/idiomas">🌍 Idiomas</RouterLink>
        </li>
        <li>
          <RouterLink :to="{ path: '/idioma', query: { opcion: 'abecedario' } }">
            🅰️ Abecedario
          </RouterLink>
        </li>
        <li>
          <RouterLink :to="{ path: '/idioma', query: { opcion: 'numeros' } }">
            🔢 Números
          </RouterLink>
        </li>
        <li>
          <RouterLink to="/contactos">📞 Contactos</RouterLink>
        </li>
      </ul>
      <button class="dark-mode-btn" @click="toggleDarkMode" :aria-pressed="isDarkMode" :title="isDarkMode ? 'Modo claro' : 'Modo oscuro'">
        <span v-if="isDarkMode">🌙</span>
        <span v-else>☀️</span>
      </button>
    </nav>
  </template>
  
  <script setup>
  import { RouterLink } from 'vue-router'
  import { ref, onMounted } from 'vue'
  
  const isDarkMode = ref(false)
  
  const toggleDarkMode = () => {
    isDarkMode.value = !isDarkMode.value
    document.body.classList.toggle('dark-mode', isDarkMode.value)
  }
  
  // Mantener el modo al recargar
  onMounted(() => {
    if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
      isDarkMode.value = true
      document.body.classList.add('dark-mode')
    }
  })
  </script>
  
  <style scoped>
  .navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: linear-gradient(to right, #10b981, #34d399);
    padding: 1rem 2rem;
    color: white;
    font-family: 'Comic Neue', cursive;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    position: sticky;
    top: 0;
    z-index: 100;
  }
  
  .logo {
    font-size: 1.7rem;
    font-weight: bold;
    text-shadow: 1px 1px 0 #00000022;
    transition: transform 0.2s ease-in-out;
  }
  
  .logo:hover {
    transform: scale(1.05);
  }
  
  .nav-links {
    display: flex;
    gap: 1.8rem;
    list-style: none;
  }
  
  .nav-links a {
    color: white;
    font-weight: 600;
    text-decoration: none;
    font-size: 1.1rem;
    position: relative;
    padding-bottom: 2px;
  }
  
  .nav-links a::after {
    content: "";
    position: absolute;
    width: 0%;
    height: 2px;
    bottom: 0;
    left: 0;
    background-color: white;
    transition: width 0.3s;
  }
  
  .nav-links a:hover::after {
    width: 100%;
  }
  
  .dark-mode-btn {
    background: none;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
    margin-left: 1.5rem;
    color: white;
    transition: transform 0.2s;
  }
  .dark-mode-btn:hover {
    transform: scale(1.2);
  }
  </style>
  
  <style>
  /* Estilos globales para modo oscuro */
  body.dark-mode {
    background: #18181b !important;
    color: #f1f5f9 !important;
  }
  body.dark-mode .navbar {
    background: linear-gradient(to right, #334155, #0f766e) !important;
    color: #f1f5f9 !important;
  }
  body.dark-mode .nav-links a {
    color: #f1f5f9 !important;
  }
  </style>
