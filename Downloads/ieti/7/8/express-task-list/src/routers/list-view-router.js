// src/routers/list-view-router.js
const express = require("express");
const {
    toList,
    getById,
    filterByCompleted
} = require("../data/tasks");

const router = express.Router();

/**
 * GET /tasks
 *   - Lista todas las tareas
 *   - Soporta filtro por query: /tasks?completed=true|false
 */
router.get("/tasks", (req, res) => {
    const { completed } = req.query;
    if (completed === "true") return res.json(filterByCompleted(true));
    if (completed === "false") return res.json(filterByCompleted(false));
    return res.json(toList());
});

/**
 * GET /tasks/:id
 *   - Ver una tarea específica por ID
 */
router.get("/tasks/:id", (req, res) => {
    const id = Number(req.params.id);
    if (Number.isNaN(id)) return res.status(400).json({ error: "ID inválido" });

    const task = getById(id);
    if (!task) return res.status(404).json({ error: "Tarea no encontrada" });
    return res.json(task);
});

/**
 * GET /tasks/complete  -> solo completas
 * GET /tasks/incomplete -> solo incompletas
 *   - Atajos para filtrar por estado
 */
router.get("/tasks/complete", (_req, res) => {
    return res.json(filterByCompleted(true));
});

router.get("/tasks/incomplete", (_req, res) => {
    return res.json(filterByCompleted(false));
});

module.exports = router;
