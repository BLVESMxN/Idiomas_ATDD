<template>
  <div class="bg-pattern min-h-screen text-center text-slate-800 pt-20">
    <section id="inicio" class="py-12 px-4">
      <h1 class="main-title">🌟 Bienvenido a Aprendo Jugando 3L</h1>
      <p class="mb-6 text-lg max-w-3xl mx-auto text-slate-700 font-semibold">
        Una plataforma educativa e inclusiva donde los niños exploran el <strong>abecedario</strong> y los <strong>números</strong> en <strong>Español</strong>, <strong>Inglés</strong> y <strong>Aymara</strong>, ¡mientras se divierten!
      </p>
      <img src="/img/hero-ilustracion.png" alt="Niños aprendiendo"
           class="mx-auto rounded-3xl shadow-lg max-w-2xl h-[280px] object-cover border-4 border-blue-100" />
    </section>

    <section class="py-16 px-6 bg-sky-50">
      <h2 class="section-title">💡 ¿Por qué es importante?</h2>
      <div class="max-w-4xl mx-auto text-lg text-slate-700 leading-relaxed bg-white rounded-2xl p-6 shadow-md">
        <p class="mb-4">
          Esta plataforma impulsa la <strong>alfabetización multilingüe</strong>, fortaleciendo habilidades cognitivas, lingüísticas y culturales.
        </p>
        <p>
          Fomentamos el <strong>juego como herramienta de aprendizaje</strong> y la preservación de lenguas originarias en un entorno visual y auditivo.
        </p>
      </div>
    </section>

    <section id="beneficios" class="py-16 px-6">
      <h2 class="section-title">✨ Beneficios de la Plataforma</h2>

      <div class="grid md:grid-cols-2 items-center gap-10 mb-16">
        <img src="/img/beneficio1.png" alt="Multilingüe" class="benefit-img" />
        <p class="benefit-text">🧠 Estimula el aprendizaje <strong>multilingüe</strong> desde temprana edad.</p>
      </div>

      <div class="grid md:grid-cols-2 items-center gap-10 mb-16 md:flex-row-reverse">
        <img src="/img/beneficio2.png" alt="Interactivo" class="benefit-img order-last md:order-first" />
        <p class="benefit-text">🎮 Aprende jugando con <strong>imágenes, sonidos</strong> y dinámicas visuales.</p>
      </div>

      <div class="grid md:grid-cols-2 items-center gap-10">
        <img src="/img/beneficio3.png" alt="Diversidad" class="benefit-img" />
        <p class="benefit-text">🌍 Fomenta la <strong>diversidad cultural</strong> y la <strong>inclusión lingüística</strong>.</p>
      </div>
    </section>

    <section class="py-16 px-6 bg-slate-100">
      <h2 class="section-title">🛠️ ¿Cómo funciona?</h2>
      <div class="max-w-4xl mx-auto grid md:grid-cols-2 gap-12 text-left text-lg text-slate-700">
        <div class="step-card">📘 Paso 1: <strong>Escoge qué aprender</strong><br />Desde el menú superior.</div>
        <div class="step-card">🌐 Paso 2: <strong>Selecciona el idioma</strong><br />Español, Inglés o Aymara.</div>
        <div class="step-card">🎧 Paso 3: <strong>Explora y escucha</strong><br />Con imágenes y sonidos nativos.</div>
        <div class="step-card">🔁 Paso 4: <strong>Repite y refuerza</strong><br />Aprendizaje ilimitado.</div>
      </div>
    </section>

    <section class="my-16">
      <h3 class="text-xl font-bold mb-4 text-blue-600 font-mono">🎯 ¿Listo para empezar?</h3>
      <p class="mb-6 font-medium text-slate-700">Elige una opción para comenzar tu aventura educativa.</p>
      <router-link to="/idioma?opcion=abecedario">
        <button class="cta-button bg-red-400 hover:bg-red-500">🅰️ Abecedario</button>
      </router-link>
      <router-link to="/idioma?opcion=numeros">
        <button class="cta-button bg-blue-400 hover:bg-blue-500">🔢 Números</button>
      </router-link>
    </section>
  </div>
</template>

<script setup>
// La línea "import { useRouter } from 'vue-router'" ha sido eliminada ya que no se utiliza
// la constante 'router' en este componente al usar <router-link> directamente en el template.
</script>

<style scoped>
.bg-pattern {
  background-color: #fffefc;
  background-image: linear-gradient(#e6e8ec 1px, transparent 1px);
  background-size: 100% 30px;
}

.main-title {
  font-size: 3rem;
  line-height: 1.2;
  color: #3b82f6;
  text-shadow: 1px 1px 0 #e0f2fe;
  font-family: 'Comic Neue', cursive;
}

.section-title {
  font-size: 1.9rem;
  font-weight: 700;
  color: #3b82f6;
  margin-bottom: 2.5rem;
  font-family: 'Comic Neue', cursive;
  text-shadow: 1px 1px 0 #e0f2fe;
}

.benefit-img {
  border-radius: 1rem;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
  object-fit: cover;
  height: 220px;
  max-width: 400px;
  width: 100%;
  margin: auto;
}

.benefit-text {
  font-size: 1.125rem;
  font-weight: 500;
  text-align: center;
}

.step-card {
  background-color: #ecfdf5;
  padding: 1.5rem;
  border-radius: 1rem;
  box-shadow: 0 5px 12px rgba(0, 0, 0, 0.05);
  border-left: 5px solid #10b981;
  margin-bottom: 1.5rem;
}

.step-card:hover {
  transform: translateY(-4px);
}

.cta-button {
  margin: 0 0.5rem;
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
</style>