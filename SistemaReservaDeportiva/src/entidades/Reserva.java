package entidades;

/**
 * Representa una reserva de una pista en un sistema de reservas.
 */
public class Reserva {
    private int idPista;
    private String fecha;
    private int duracion;

    /**
     * Crea una nueva reserva con los detalles especificados.
     * 
     * @param idPista Identificador de la pista reservada.
     * @param fecha Fecha de la reserva en formato "YYYY-MM-DD".
     * @param duracion Duración de la reserva en horas.
     */
    public Reserva(int idPista, String fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * Obtiene el identificador de la pista reservada.
     * 
     * @return El identificador de la pista.
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return La fecha de la reserva en formato "YYYY-MM-DD".
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la reserva.
     * 
     * @return La duración de la reserva en horas.
     */
    public int getDuracion() {
        return duracion;
    }
}
