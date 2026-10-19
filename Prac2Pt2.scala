class  Pelicula (
    val titulo: String,
    val duracionMinutos: Int,
    val clasificacion: String
)

object Pelicula {
    def apply (
        titulo: String,
        duracionMinutos: Int,
        clasificacion: String
    ): Pelicula = 
        if duracionMinutos <= 0  then new Pelicula (titulo, 90, clasificacion)
        else new  Pelicula (titulo, duracionMinutos, clasificacion)
}

class FuncionCine (
    val pelicula: Pelicula,
    val sala: Int,
    val hora: String,
    val precioEntrada: Double,
    val asientosDisponibles: Int
) {
    def puedeReservar (cantidad: Int): Boolean = {
        if asientosDisponibles > 0 && asientosDisponibles >= cantidad  then true else false
    }

    def costoReserva (cantidad: Int): Double = {
        cantidad * precioEntrada
    }

    def reservar (cantidad: Int): FuncionCine = {
        if puedeReservar(cantidad) then FuncionCine(pelicula, sala, hora, precioEntrada, asientosDisponibles - cantidad)
        else FuncionCine(pelicula, sala, hora, precioEntrada, asientosDisponibles)
    }

    def descripcion: String = {
        s"${pelicula.titulo}\nSala: $sala\nHora: $hora\nPrecio: $precioEntrada Bs\nAsientos disponibles: $asientosDisponibles"
    }
}

object FuncionCine {
    def apply (
        pelicula: Pelicula,
        sala: Int,
        hora: String,
        precioEntrada: Double,
        asientosDisponibles: Int
    ): FuncionCine =
        if precioEntrada >= 0.0 && asientosDisponibles >= 0 && sala >= 1 then new FuncionCine(pelicula,sala,hora,precioEntrada,asientosDisponibles)
        else {
            if precioEntrada < 0.0 then FuncionCine(pelicula, sala, hora, 0.0, asientosDisponibles)
            else if asientosDisponibles < 0 then FuncionCine(pelicula, sala, hora, precioEntrada, 0)
            else FuncionCine(pelicula, 1, hora, precioEntrada, asientosDisponibles)
        }
    
    def funcionEstandar(
        pelicula: Pelicula,
        sala: Int,
        hora: String
    ): FuncionCine = {
        FuncionCine(pelicula, sala, hora, 30.0, 50)
    }
}


object Prac2Pt2 {

    def main (args: Array[String]): Unit = {
        /** Pruebas
        val pelicula1 = Pelicula("Interstellar", 169,"PG-13")
        println(s"${pelicula1.titulo} dura ${pelicula1.duracionMinutos} minutos y se clasifica como: ${pelicula1.clasificacion}")
        println(FuncionCine(pelicula1, 3, "18:30", 55.0, 40).descripcion)
        val funcion2 = FuncionCine.funcionEstandar(pelicula1, 2,"18:30")
        println(s"La función de ${funcion2.pelicula.titulo} en la sala ${funcion2.sala} a las ${funcion2.hora} cuesta ${funcion2.precioEntrada} por entrada y tiene ${funcion2.asientosDisponibles} asientos disponibles.")
        **/

        val pelicula1 = Pelicula("Dune", 155, "PG-13")
        val funcion1 =FuncionCine(pelicula1, 3, "20:30", 35.0, 40)
        val funcion2 = FuncionCine.funcionEstandar(pelicula1, 1, "16:00")
        println(funcion2.descripcion)
        println(funcion1.descripcion)
        println(funcion1.puedeReservar(5))
        println(funcion1.costoReserva(5))
        val funcionReservada = funcion1.reservar(5)
        println(funcion1.asientosDisponibles)
        println(funcionReservada.asientosDisponibles)
    }
}