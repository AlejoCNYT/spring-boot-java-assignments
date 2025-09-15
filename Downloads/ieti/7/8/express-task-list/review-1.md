> # ¿Qué es mi producto y para qué sirve?

**Econexión** es una aplicación web y móvil que facilita el reciclaje para todos. Conecta a ciudadanos, recolectores y empresas para que **reciclar sea tan fácil como pedir un domicilio**: escaneas el producto, agendas la recolección en tu casa y ganas puntos que puedes redimir. Además, te mostramos tu **impacto ambiental** de forma clara y motivante.

---

# ¿Cuáles son las funcionalidades más importantes y por qué los usuarios las amarían?

- **Agendar recolecciones en minutos:** eliges día y hora; un recolector confiable pasa por tu reciclaje. *Ahorra tiempo y evita desplazamientos.*
- **Escáner de productos y guía de separación:** identifica el material y te dice cómo disponerlo. *Menos dudas, más reciclaje correcto.*
- **Puntos y recompensas (gamificación):** ganas EcoPuntos por peso, material y calidad; luego los cambias por beneficios. *Reciclar se vuelve un hábito divertido y útil.*
- **Seguimiento en tiempo real:** ves el estado de tu solicitud y recibes notificaciones. *Transparencia y tranquilidad.*
- **Calidad del material y calificaciones:** mejoras tus puntajes aprendiendo a entregar limpio y seco. *Mejor calidad = más puntos.*
- **Rutas optimizadas para recolectores:** más paradas en menos tiempo y con ahorro de combustible. *Eficiencia y más ingresos.*
- **Paneles para empresas (fase 2):** métricas, mapas de calor y reportes de cumplimiento. *Datos claros para decisiones sostenibles.*

---

# ¿Qué tecnologías usaste y por qué?

- **Aplicación Web (Front): React + Vite + Tailwind.** Rápido, moderno y fácil de mantener; ideal para crecer y recibir nuevas funciones.
- **Aplicación Móvil: React Native (Expo).** Un solo código para Android/iOS, lo que acelera las entregas y reduce costos.
- **Backend: Java Spring Boot 3.** Confiable, seguro y con gran ecosistema; perfecto para APIs sólidas y escalables.
- **Base de datos: PostgreSQL (producción) / H2 (desarrollo).** PostgreSQL guarda la información de forma segura; H2 nos permite probar rápido sin instalar nada extra.
- **Seguridad: JWT (tokens).** Ingresos y permisos simples y seguros para ciudadanos, recolectores y empresas.
- **Mapas: Google Maps.** Geocodificación y rutas para una logística eficiente.
- **Infraestructura en Azure.** Despliegues estables y automáticos, con bases de datos administradas y llaves seguras (Key Vault).
- **Automatización y calidad: GitHub Actions + Flyway.** Entregas continuas y control de versiones de la base de datos, evitando errores entre ambientes.

**Resultado:** una plataforma **simple para el usuario** y **sólida por dentro**, lista para crecer con más ciudades, aliados y funcionalidades.

---

**Repositorio:** https://github.com/AlejoCNYT/spring-boot-java-assignments
**Rama de esta review:** https://github.com/AlejoCNYT/spring-boot-java-assignments/tree/review-1
EOF
