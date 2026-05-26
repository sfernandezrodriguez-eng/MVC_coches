/**
 * Clase controladora que sirve de puente entre la Vista y el Modelo.
 * Controla el flujo de las operaciones y valida las respuestas del modelo.
 * * @author Tu Nombre
 * @version 3.0 (Mayo 2026)
 */
public class Controller {
    static View miView = new View();
    Model miModel = new Model();

    /**
     * Metodo principal que arranca la aplicacion mostrando el menu interactivo.
     * * @param args Argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        miView.menu();
    }

    /**
     * Solicita al modelo la creacion de un coche y verifica si se añadio correctamente.
     * * @param modelo    El modelo del automovil.
     * @param matricula La matricula identificadora.
     * @return true si se creo con exito, false en caso contrario.
     */
    public boolean añadirCoche(String modelo, String matricula) {
        Coche creado = miModel.crearCoche(modelo, matricula);
        if (creado == miModel.getCoche(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Modifica la velocidad de un coche y ordena a la vista mostrar el cambio.
     * * @param matricula La matricula del coche.
     * @param velocidad La nueva velocidad.
     * @return El estado de exito de la visualizacion.
     */
    public boolean newVelocidad(String matricula, int velocidad) {
        int nuevaVelocidad = miModel.cambiarVelocidad(matricula, velocidad);
        boolean hecho = miView.muestraVelocidad(matricula, miModel.getVelocidad(matricula));
        return hecho;
    }

    /**
     * Gestiona el flujo para avanzar un coche validando combustible y velocidad de movimiento.
     * * @param matricula La matricula del coche.
     * @param metros    Los metros a avanzar.
     * @return true si la operacion fue exitosa, false si fallo por alguna restriccion.
     */
    public boolean avanzar(String matricula, double metros) {
        double totalKms = miModel.avanzarCoche(matricula, metros);
        if (totalKms == -1.0) {
            return false;
        } else if (totalKms == -2.0) {
            miView.mostrarErrorGasolina(matricula);
            return false;
        } else if (totalKms == -3.0) {
            miView.mostrarErrorVelocidad(matricula); // <-- NUEVA RESPUESTA
            return false;
        } else {
            miView.mostrarKilometros(matricula, totalKms);
            return true;
        }
    }

    /**
     * Coordina la adicion de gasolina a un vehiculo entre el modelo y la vista.
     * * @param matricula La matricula del coche.
     * @param litros    Los litros a repostar.
     * @return true si se realizo correctamente, false si el coche no existe.
     */
    public boolean ponerGasolina(String matricula, int litros) {
        int totalGasolina = miModel.repostarCoche(matricula, litros);
        if (totalGasolina != -1) {
            miView.mostrarGasolina(matricula, totalGasolina);
            return true;
        }
        return false;
    }
}