// src/data/tasks.js
// Sencilla "DB" en memoria

let nextId = 4;

const tasks = new Map([
    [1, { id: 1, title: "Estudiar Express Router", completed: false }],
    [2, { id: 2, title: "Armar endpoints CRUD", completed: true }],
    [3, { id: 3, title: "Escribir README de pruebas", completed: false }]
]);

function toList() {
    return Array.from(tasks.values());
}

function getById(id) {
    return tasks.get(id);
}

function filterByCompleted(flag) {
    return toList().filter(t => t.completed === flag);
}

function createTask({ title, completed = false }) {
    const id = nextId++;
    const task = { id, title: String(title), completed: Boolean(completed) };
    tasks.set(id, task);
    return task;
}

function updateTask(id, { title, completed }) {
    const current = tasks.get(id);
    if (!current) return null;
    // PUT/PATCH flexible
    const updated = {
        ...current,
        ...(title !== undefined ? { title: String(title) } : {}),
        ...(completed !== undefined ? { completed: Boolean(completed) } : {})
    };
    tasks.set(id, updated);
    return updated;
}

function deleteTask(id) {
    return tasks.delete(id);
}

module.exports = {
    toList,
    getById,
    filterByCompleted,
    createTask,
    updateTask,
    deleteTask
};
