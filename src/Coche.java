/**
 * Clase que representa a la entidad Coche dentro del sistema de gestion.
 * Contiene el estado de la velocidad, kilometraje y combustible del vehiculo.
 * * @author Tu Nombre
 * @version 3.0 (Mayo 2026)
 */
public class Coche {
    /** Matricula unica del vehiculo. */
    String matricula;
    /** Modelo o marca del vehiculo. */
    String modelo;
    /** Velocidad actual en km/h. */
    Integer velocidad;
    /** Kilometros totales recorridos por el vehiculo. */
    Double kilometrosRecorridos;
    /** Litros de gasolina actuales en el tanque. */
    Integer gasolina;

    /**
     * Constructor completo para instanciar un nuevo Coche.
     * Inicializa la velocidad en 0, los kilometros en 0.0 y la gasolina en 0.
     * * @param modelo    El nombre del modelo del vehiculo.
     * @param matricula La matricula unica del vehiculo.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0.0;
        this.gasolina = 0;
    }
}