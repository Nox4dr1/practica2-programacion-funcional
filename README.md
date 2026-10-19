# Práctica 2 – Programación Funcional (Scala)

Práctica 2 de Programación Funcional en Scala: funciones de orden superior, clases, objetos acompañantes, traits y polimorfismo.

## 📚 Contenido

| Archivo | Descripción |
|---------|-------------|
| `Prac2Pt1.scala` | Parte 1: 10 ejercicios de funciones de orden superior |
| `Prac2Pt2.scala` | Parte 2: Sistema de reservas de cine |
| `Prac2Pt3.scala` | Parte 3: Sistema de biblioteca digital |

---

## 🧩 Parte 1 – Funciones de orden superior

Ejercicios progresivos que cubren:

- Funciones como valores de primera clase.
- Funciones anónimas (lambdas).
- Funciones que reciben otras funciones como parámetros.
- Funciones que retornan funciones.
- Aplicación parcial.
- Currificación.
- Composición de funciones (`andThen` / `compose`).
- Abstracción de operaciones repetitivas.
- Funciones genéricas de sumatoria, producto, transformación y búsqueda.

---

## 🎬 Parte 2 – Sistema de reservas de cine

Sistema que modela películas y funciones de cine aplicando los principios de la programación funcional:

- Clases inmutables con `val`.
- Objetos acompañantes con método `apply`.
- Métodos de fábrica (`funcionEstandar`).
- Validación de datos en el constructor.
- Métodos que devuelven **nuevos objetos** en lugar de modificar los existentes.

### Clases principales

- **`Pelicula`**: título, duración (default 90 min si es inválida) y clasificación.
- **`FuncionCine`**: película, sala, hora, precio de entrada y asientos disponibles.
  - `puedeReservar(cantidad)`: verifica si hay asientos suficientes.
  - `costoReserva(cantidad)`: calcula el costo total.
  - `reservar(cantidad)`: devuelve una nueva `FuncionCine` con los asientos actualizados.
  - `descripcion`: representación textual de la función.

---

## 📖 Parte 3 – Sistema de biblioteca digital

Sistema que modela distintos tipos de recursos usando abstracción y polimorfismo:

- Clase abstracta `RecursoBiblioteca`.
- Cuatro traits: `Prestable`, `Renovable`, `Descargable`, `Reproducible`.
- Herencia y combinación de traits con `with`.
- Polimorfismo mediante el tipo base `RecursoBiblioteca`.
- Inmutabilidad: préstamos y renovaciones devuelven nuevos objetos.

### Clases implementadas

- `LibroFisico`
- `LibroDigital`
- `Audiolibro`
- `RevistaFisica`
- `VideoCurso`

---
