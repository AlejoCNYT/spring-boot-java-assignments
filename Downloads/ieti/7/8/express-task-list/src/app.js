// src/app.js
const express = require("express");
const listViewRouter = require("./routers/list-view-router");
const listEditRouter = require("./routers/list-edit-router");

const app = express();
const PORT = process.env.PORT || 3000;

// Middlewares
app.use(express.json());

// Salud
app.get("/health", (_req, res) => res.json({ status: "ok" }));

// Routers solicitados
// Nota: puedes cambiar el prefijo '/api' por '/', según prefieras.
app.use("/api", listViewRouter);
app.use("/api", listEditRouter);

// Manejo 404 genérico
app.use((_req, res) => res.status(404).json({ error: "Ruta no encontrada" }));

app.listen(PORT, () => {
    console.log(`Servidor escuchando en http://localhost:${PORT}`);
});
