<template>
    <div class="min-h-screen bg-pattern flex flex-col items-center justify-center text-center px-4 py-20 text-slate-800">
      <!-- Título -->
      <h2 class="section-title mb-6">🔢 Aprendamos los Números</h2>
  
      <!-- Tarjeta del número -->
      <div class="card max-w-md w-full">
        <h1 class="text-6xl font-bold mb-4 text-indigo-700">{{ numeroActual.numero }}</h1>
  
        <img
          :src="`/img/${contenido.imagen}`"
          alt="Imagen del número"
          class="img-letra"
        />
  
        <p class="text-xl font-semibold flex justify-center items-center gap-2 mb-2">
          {{ contenido.palabra }}
          <button @click="reproducirAudio" class="px-4 py-1 bg-emerald-500 hover:bg-emerald-600 text-white rounded-full shadow transition">
            🔊
          </button>
        </p>
  
        <p v-if="contenido.traduccion" class="text-gray-600 text-sm italic">
          ({{ contenido.traduccion }})
        </p>
      </div>
  
      <!-- Navegación -->
      <div class="btn-group mt-10">
        <button
          @click="anterior"
          :disabled="indice === 0"
          class="cta-button"
        >
          ⬅️ Anterior
        </button>
  
        <button
          @click="siguiente"
          :disabled="indice === numerosFiltrados.length - 1"
          class="cta-button"
        >
          Siguiente ➡️
        </button>
      </div>
  
      <!-- Volver -->
      <div class="btn-group mt-6">
        <button @click="router.push('/')" class="cta-button bg-gray-400 hover:bg-gray-500">
          🔙 Volver al inicio
        </button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed, watch } from 'vue'
  import { useRoute, useRouter } from 'vue-router'
  import { numeros } from '../data/numeros.js'
  
  const route = useRoute()
  const router = useRouter()
  
  const idioma = route.query.idioma || 'es'
  
  const numerosFiltrados = computed(() =>
    numeros.filter(n => n.disponibleEn.includes(idioma))
  )
  
  const indice = ref(0)
  const numeroActual = computed(() => numerosFiltrados.value[indice.value])
  const contenido = computed(() => numeroActual.value.idiomas[idioma])
  
  function siguiente() {
    if (indice.value < numerosFiltrados.value.length - 1) {
      indice.value++
    }
  }
  
  function anterior() {
    if (indice.value > 0) {
      indice.value--
    }
  }
  
  function reproducirAudio() {
    const path = `/audio/numeros/${numeroActual.value.numero}-${idioma}.mp3`
    const audio = new Audio(path)
    audio.play()
  }
  
  watch(() => route.query.idioma, () => {
    indice.value = 0
  })
  </script>
  
  <style scoped>
  .bg-pattern {
    background-color: #fffefc;
    background-image: linear-gradient(#e6e8ec 1px, transparent 1px);
    background-size: 100% 30px;
  }
  
  .section-title {
    font-size: 2rem;
    font-weight: 800;
    color: #3b82f6;
    font-family: 'Comic Neue', cursive;
    text-shadow: 1px 1px 0 #e0f2fe;
  }
  
  .card {
    background-color: #ffffff;
    border-radius: 1rem;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.08);
    padding: 2rem;
  }
  
  .btn-group {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 1.5rem;
  }
  
  .cta-button {
    background-color: #10b981;
    color: white;
    font-weight: bold;
    padding: 0.8rem 1.8rem;
    font-size: 1.125rem;
    border-radius: 0.75rem;
    box-shadow: 0 4px 0 #0f766e;
    transition: all 0.2s ease-in-out;
  }
  .cta-button:hover {
    transform: scale(1.05);
  }
  .cta-button:disabled {
    background-color: #d1d5db;
    box-shadow: none;
    cursor: not-allowed;
  }
  .img-letra {
  width: 200px;
  height: 200px;
  object-fit: contain;
  border-radius: 1rem;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.08);
  margin-bottom: 1rem;
}
  </style>
  