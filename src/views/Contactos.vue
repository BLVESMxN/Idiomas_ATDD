<template>
    <div class="min-h-screen bg-pattern text-center text-slate-800 pt-20 px-4">
      <!-- Título -->
      <h1 class="main-title">📞 Contáctanos</h1>
      <p class="mb-10 text-lg max-w-3xl mx-auto font-medium">
        Si deseas conocer más sobre el proyecto, colaborar o dejarnos tus sugerencias, no dudes en contactarnos.
      </p>
  
      <!-- Contenedor principal -->
      <div class="contact-card max-w-3xl mx-auto">
        <!-- Foto del desarrollador -->
        <img src="/img/desarrollador.png" alt="Desarrollador" class="contact-img" />
  
        <!-- Información -->
        <h2 class="text-2xl font-bold text-blue-600 mb-2 font-mono">Serapio Rojas Orosco</h2>
        <p class="text-slate-700 mb-6">
          Desarrollador principal de "Aprendo Jugando 3L" <br />
          Profesor de Computación, Unidad Educativa Luís Espinal Camps <br />
          Fe y Alegría – El Alto
        </p>
  
        <!-- Redes sociales -->
        <div class="redes-container grid grid-cols-2 sm:grid-cols-4 gap-6 mt-8">
          <div class="red-social">
            <a href="https://www.facebook.com/share/19gzSgTyfS/" target="_blank">
              <img src="/img/facebook.png" alt="Facebook" class="icono-red" />
              <p class="nombre-red">Serapio Rojas</p>
            </a>
          </div>
  
          <div class="red-social">
            <a href="https://www.instagram.com/rojas.serapio?igsh=MTgwd3l3dHlqdTNvcg==" target="_blank">
              <img src="/img/instagram.png" alt="Instagram" class="icono-red" />
              <p class="nombre-red">@rojas.serapio</p>
            </a>
          </div>
  
          <div class="red-social">
            <a href="https://www.tiktok.com/@serapio.rojas" target="_blank">
              <img src="/img/tiktok.png" alt="TikTok" class="icono-red" />
              <p class="nombre-red">@serapiorojas</p>
            </a>
          </div>
  
          <div class="red-social">
            <a href="https://wa.me/59175292296" target="_blank">
              <img src="/img/whatsapp.png" alt="WhatsApp" class="icono-red" />
              <p class="nombre-red">+591 75292296</p>
            </a>
          </div>
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
  
  .contact-card {
    background-color: white;
    padding: 2.5rem;
    border-radius: 1rem;
    box-shadow: 0 8px 18px rgba(0, 0, 0, 0.06);
    text-align: center;
  }
  
  .contact-img {
    width: 200px;
    height: 200px;
    object-fit: cover;
    border-radius: 9999px;
    margin-bottom: 1rem;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  }
  
  /* Redes sociales */
  .redes-container {
    justify-items: center;
    text-align: center;
  }
  
  .red-social a {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-decoration: none;
  }
  
  .icono-red {
    width: 60px;
    height: 60px;
    object-fit: contain;
    transition: transform 0.2s ease-in-out;
  }
  
  .icono-red:hover {
    transform: scale(1.1);
  }
  
  .nombre-red {
    margin-top: 0.5rem;
    font-size: 0.95rem;
    color: #334155;
    font-weight: 600;
  }
  </style>
  