<template>
    <div class="min-h-screen bg-pattern text-center text-slate-800 pt-20 px-4">
      <!-- Título principal -->
      <h1 class="main-title">🌐 Idiomas en la Plataforma</h1>
      <p class="mb-10 text-lg max-w-3xl mx-auto font-medium">
        Nuestra aplicación educativa está diseñada para fomentar el aprendizaje temprano en tres idiomas clave:
        <strong>Español</strong>, <strong>Inglés</strong> y <strong>Aymara</strong>, promoviendo la diversidad cultural y lingüística desde la infancia.
      </p>
  
      <!-- Idiomas -->
      <div class="grid md:grid-cols-3 gap-10 max-w-6xl mx-auto mb-16">
        <!-- Español -->
        <div class="idioma-card">
          <img src="/img/espanol.png" alt="Español" class="idioma-img" />
          <h2 class="idioma-title text-red-500">🇪🇸 Español</h2>
          <p>
            El idioma oficial en la mayoría de países de América Latina. Enseñar español fortalece la comunicación y comprensión lectora en el entorno cotidiano del niño.
          </p>
        </div>
  
        <!-- Inglés -->
        <div class="idioma-card">
          <img src="/img/ingles.png" alt="Inglés" class="idioma-img" />
          <h2 class="idioma-title text-green-500">🇺🇸 English</h2>
          <p>
            El idioma universal. Introducir el inglés desde edad temprana mejora las oportunidades académicas y profesionales, y facilita el acceso a la ciencia y tecnología.
          </p>
        </div>
  
        <!-- Aymara -->
        <div class="idioma-card">
          <img src="/img/aymara.png" alt="Aymara" class="idioma-img" />
          <h2 class="idioma-title text-yellow-500">🏔️ Aymara</h2>
          <p>
            Una lengua originaria del altiplano andino. Enseñar Aymara no solo preserva el patrimonio cultural, sino que también fortalece la identidad de las comunidades indígenas.
          </p>
        </div>
      </div>    
    </div>
  </template>
  
  <script setup>
  import { useRouter } from 'vue-router'
  const router = useRouter()
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
    margin-bottom: 1.5rem;
  }
  
  .idioma-card {
    background-color: white;
    padding: 2rem;
    border-radius: 1rem;
    box-shadow: 0 8px 18px rgba(0, 0, 0, 0.06);
    transition: transform 0.2s ease-in-out;
  }
  .idioma-card:hover {
    transform: translateY(-6px);
  }
  
  .idioma-img {
    width: 5.5rem;
    height: 5.5rem;
    margin: 0 auto 1rem;
    border-radius: 9999px;
    object-fit: cover;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.08);
  }
  
  .idioma-title {
    font-size: 1.3rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
    font-family: 'Comic Neue', cursive;
  }
  
  .cta-button {
    margin-top: 1rem;
    padding: 0.75rem 2rem;
    font-weight: bold;
    font-size: 1.125rem;
    border-radius: 0.75rem;
    box-shadow: 0 4px 0 #cbd5e1;
    transition: all 0.2s ease-in-out;
  }
  .cta-button:hover {
    transform: scale(1.05);
  }
  </style>
  