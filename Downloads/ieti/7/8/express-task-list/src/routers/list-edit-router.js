// src/routers/list-edit-router.js
const express = require("express");
const {
    createTask,
    updateTask,
    deleteTask,
    getById
} = require("../data/tasks");

const router = express.Router();

/**
 * POST /tasks
 *   - Crear una tarea: { "title": "...", "completed": false? }
 */
router.post("/tasks", (req, res) => {
    const { title, completed } = req.body || {};
    if (!title || typeof title !== "string") {
        return res.status(400).json({ error: "El campo 'title' es requerido y debe ser string" });
    }
    const task = createTask({ title, completed });
    return res.status(201).json(task);
});

/**
 * PUT /tasks/:id
 *   - Actualiza COMPLETAMENTE una tarea (title y completed)
 */
router.put("/tasks/:id", (req, res) => {
    const id = Number(req.params.id);
    if (Number.isNaN(id)) return res.status(400).json({ error: "ID inválido" });

    const { title, completed } = req.body || {};
    if (title === undefined || completed === undefined) {
        return res.status(400).json({ error: "PUT requiere 'title' y 'completed'" });
    }
    if (typeof title !== "string") {
        return res.status(400).json({ error: "'title' debe ser string" });
    }

    const updated = updateTask(id, { title, completed });
    if (!updated) return res.status(404).json({ error: "Tarea no encontrada" });
    return res.json(updated);
});

/**
 * PATCH /tasks/:id
 *   - Actualiza PARCIALMENTE una tarea (cualquiera de los campos)
 */
router.patch("/tasks/:id", (req, res) => {
    const id = Number(req.params.id);
    if (Number.isNaN(id)) return res.status(400).json({ error: "ID inválido" });

    const { title, completed } = req.body || {};
    if (title === undefined && completed === undefined) {
        return res.status(400).json({ error: "PATCH requiere 'title' y/o 'completed'" });
    }

    const updated = updateTask(id, { title, completed });
    if (!updated) return res.status(404).json({ error: "Tarea no encontrada" });
    return res.json(updated);
});

/**
 * DELETE /tasks/:id
 *   - Elimina una tarea por ID
 */
router.delete("/tasks/:id", (req, res) => {
    const id = Number(req.params.id);
    if (Number.isNaN(id)) return res.status(400).json({ error: "ID inválido" });

    // Verifica si existe antes de borrar para responder 404 correctamente
    if (!getById(id)) return res.status(404).json({ error: "Tarea no encontrada" });

    deleteTask(id);
    return res.status(204).send();
});

module.exports = router;
