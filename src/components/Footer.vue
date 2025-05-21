<template>
    <footer class="footer">
      <div class="footer-content">
        <p class="titulo">💻 Proyecto: <strong>Aprendo Jugando 3L</strong></p>
        <p class="autor">Desarrollado con ❤️ por Serapio Rojas Orosco — 2025</p>
      </div>
  
      <div class="footer-contacto">
        <p>📧 Correo: 
          <a href="mailto:rojasoroscoserapio@gmail.com">rojasoroscoserapio@gmail.com</a>
        </p>
      </div>

      <div class="footer-social">
        <span>Sígueme: </span>
        <a href="https://twitter.com/" target="_blank" rel="noopener" aria-label="Twitter">🐦</a>
        <a href="https://www.linkedin.com/" target="_blank" rel="noopener" aria-label="LinkedIn">💼</a>
        <a href="https://github.com/" target="_blank" rel="noopener" aria-label="GitHub">🐙</a>
      </div>

      <div class="footer-copy">
        <p>© 2025 Aprendo 3L. Todos los derechos reservados.</p>
      </div>
    </footer>
  </template>
  
  <style scoped>
  .footer {
    background: linear-gradient(to right, #10b981, #34d399);
    color: white;
    text-align: center;
    padding: 2rem 1rem;
    font-family: 'Comic Neue', cursive;
    border-top: 4px solid #0f766e;
    margin-top: 3rem;
    box-shadow: 0 -4px 12px rgba(0, 0, 0, 0.05);
  }
  
  .footer-content {
    margin-bottom: 1rem;
  }
  
  .footer .titulo {
    font-size: 1.2rem;
    font-weight: bold;
  }
  
  .footer .autor {
    font-size: 0.95rem;
  }
  
  .footer-contacto {
    margin: 0.5rem 0;
    font-size: 0.95rem;
  }
  
  .footer-contacto a {
    color: white;
    font-weight: 600;
    text-decoration: underline;
  }
  
  .footer-contacto a:hover {
    color: #d1fae5;
  }

  .footer-social {
    margin: 0.5rem 0;
    font-size: 1.3rem;
  }
  .footer-social a {
    margin: 0 0.3rem;
    text-decoration: none;
    transition: transform 0.2s;
  }
  .footer-social a:hover {
    transform: scale(1.2);
    filter: brightness(1.3);
  }
  
  .footer-copy {
    font-size: 0.85rem;
    opacity: 0.8;
    margin-top: 1rem;
  }
  </style>
