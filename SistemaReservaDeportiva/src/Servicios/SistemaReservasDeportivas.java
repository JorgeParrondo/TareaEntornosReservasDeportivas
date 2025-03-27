package Servicios;

import java.util.ArrayList;
import java.util.List;

import entidades.Reserva;

/**
 * @author Jorge Parrondo
 * Sistema de gestión de reservas deportivas.
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private GestorIluminacion gestorIluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor que inicializa el sistema de reservas.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion(MAX_PISTAS);
    }

    /**
     * Reserva una pista usando un objeto Reserva.
     * 
     * @param reserva Objeto Reserva con los datos de la reserva.
     * @return true si la reserva fue exitosa, false en caso contrario.
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == reserva.getIdPista() && r.getFecha().equals(reserva.getFecha())) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva según su identificador.
     * 
     * @param idReserva Identificador de la reserva.
     * @return true si la reserva fue cancelada, false si no se encontró.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha y hora específica.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha Fecha de la reserva en formato "YYYY-MM-DD".
     * @param hora Hora de la reserva en formato "HH:MM".
     * @return true si la pista está disponible, false en caso contrario.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && fechadisponible(fecha, r)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

    private boolean fechadisponible(String fecha, Reserva r) {
        return r.getFecha().equals(fecha);
    }

    // Métodos delegados a GestorIluminacion
    public boolean encenderLuces(int idPista) {
        return gestorIluminacion.encenderLuces(idPista);
    }

    public boolean apagarLuces(int idPista) {
        return gestorIluminacion.apagarLuces(idPista);
    }
}

/**
 * Clase encargada de gestionar la iluminación de las pistas.
 */
class GestorIluminacion {
    private boolean[] iluminacion;

    /**
     * Constructor que inicializa el gestor de iluminación.
     * 
     * @param maxPistas Número máximo de pistas.
     */
    public GestorIluminacion(int maxPistas) {
        iluminacion = new boolean[maxPistas];
    }

    /**
     * Activa la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue activada, false en caso contrario.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Desactiva la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue desactivada, false en caso contrario.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= iluminacion.length) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
}
