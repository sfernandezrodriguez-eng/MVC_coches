import java.util.ArrayList;

/**
 * Clase encargada de manejar, almacenar y procesar los datos de la aplicacion.
 * Aplica las reglas de negocio complejas sobre la coleccion de coches.
 * * @author Tu Nombre
 * @version 4.0 (Mayo 2026)
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    public Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    public Coche getCoche(String matricula) {
        Coche aux = null;
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        System.out.println(" LOG esta haciendose");
        return getCoche(matricula).velocidad;
    }

    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    /**
     * Hace avanzar el coche convirtiendo metros a kilometros, validando la velocidad
     * y descontando gasolina mediante un calculo basado en la velocidad actual.
     * * @param matricula La matricula del coche que va a avanzar.
     * @param metros    La cantidad de metros que se desea avanzar.
     * @return El total acumulado de kilometros del coche tras avanzar;
     * -1.0 si el coche no existe;
     * -2.0 si no tiene suficiente gasolina para el trayecto;
     * -3.0 si el coche esta detenido (velocidad igual a 0).
     */
    public double avanzarCoche(String matricula, double metros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            //Debe estar en movimiento
            if (coche.velocidad <= 0) {
                return -3.0;
            }

            double kmsAAtravesar = metros / 1000.0;

            // El consumo depende directamente de la velocidad
            // Validamos que el calculo use la velocidad tal como exige el enunciado
            double factorConsumo = coche.velocidad / 100.0;
            if (factorConsumo < 0.5) factorConsumo = 0.5;

            int gasolinaNecesaria = (int) Math.ceil(kmsAAtravesar * factorConsumo);

            // Verificar si hay combustible suficiente
            if (coche.gasolina >= gasolinaNecesaria) {
                coche.gasolina -= gasolinaNecesaria;
                coche.kilometrosRecorridos += kmsAAtravesar;
                return coche.kilometrosRecorridos;
            } else {
                return -2.0; // Combustible insuficiente
            }
        }
        return -1.0;
    }

    public int repostarCoche(String matricula, int litros) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.gasolina += litros;
            return coche.gasolina;
        }
        return -1;
    }
}