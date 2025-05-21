<template>
    <div class="min-h-screen bg-pattern flex flex-col items-center justify-center text-center px-4 py-20 text-slate-800">
      <!-- Título -->
      <h1 class="main-title mb-4">🌍 Selecciona un idioma</h1>
      <p class="text-lg text-slate-700 mb-10 font-medium max-w-xl">
        Elige el idioma en el que deseas aprender el contenido seleccionado. Esto permite una experiencia más accesible y enriquecedora para todos los niños.
      </p>
  
      <!-- Botones -->
      <div class="grid grid-cols-1 sm:grid-cols-3 gap-8 w-full max-w-2xl">
        <button
          @click="seleccionarIdioma('es')"
          class="idioma-btn bg-red-400 hover:bg-red-500"
        >
          🇪🇸 Español
        </button>
  
        <button
          @click="seleccionarIdioma('en')"
          class="idioma-btn bg-green-400 hover:bg-green-500"
        >
          🇺🇸 English
        </button>
  
        <button
          @click="seleccionarIdioma('ay')"
          class="idioma-btn bg-yellow-400 hover:bg-yellow-500 text-black"
        >
          🏔️ Aymara
        </button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useRoute, useRouter } from 'vue-router'
  
  const router = useRouter()
  const route = useRoute()
  
  function seleccionarIdioma(codigo) {
    const opcion = route.query.opcion
  
    if (opcion === 'abecedario') {
      router.push({ path: '/abecedario', query: { idioma: codigo } })
    } else if (opcion === 'numeros') {
      router.push({ path: '/numeros', query: { idioma: codigo } })
    } else {
      router.push('/')
    }
  }
  </script>
  
  <style scoped>
  .bg-pattern {
    background-color: #fffefc;
    background-image: linear-gradient(#e6e8ec 1px, transparent 1px);
    background-size: 100% 30px;
  }
  
  .main-title {
    font-size: 2.5rem;
    color: #3b82f6;
    font-family: 'Comic Neue', cursive;
    font-weight: 800;
    text-shadow: 1px 1px 0 #e0f2fe;
  }
  
  .idioma-btn {
    font-weight: bold;
    font-size: 1.25rem;
    padding: 1rem 1.5rem;
    border-radius: 1rem;
    border: none;
    color: white;
    box-shadow: 0 6px 10px rgba(0, 0, 0, 0.1);
    transition: all 0.25s ease-in-out;
  }
  .idioma-btn:hover {
    transform: scale(1.05);
  }
  </style>
  