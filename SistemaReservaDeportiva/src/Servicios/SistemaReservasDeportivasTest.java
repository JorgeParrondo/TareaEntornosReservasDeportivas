package Servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Clase que contiene las pruebas para el sistema de reservas deportivas.
 * Las pruebas verifican el funcionamiento de las funcionalidades principales
 * del sistema de reservas, como la reserva de pistas.
 */
class SistemaReservasDeportivasTest {

    static SistemaReservasDeportivas sistemaReservas;

    /**
     * Método que se ejecuta antes de todas las pruebas, y que inicializa el sistema de reservas.
     * Este método se ejecuta una sola vez antes de que se ejecuten las pruebas.
     * 
     * @throws Exception Si ocurre algún error al inicializar el sistema de reservas.
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        sistemaReservas = new SistemaReservasDeportivas();
    }

    /**
     * Prueba para verificar la funcionalidad de reserva de pista.
     * 
     * Se comprueba si es posible reservar una pista en una fecha específica, 
     * así como la validación de la disponibilidad de la pista.
     */
    @Test
    void test() {
        // Se reserva la pista 1 para el 11 de abril de 2020 durante 60 minutos.
        assertTrue(sistemaReservas.reservarPista(1, "11-04-2020", 60));
        
        // Intento de reservar la misma pista 1 para el mismo día y hora, lo que debería fallar.
        assertFalse(sistemaReservas.reservarPista(1, "11-04-2020", 60));
        
        // Se reserva una pista diferente (pista 3) para el mismo día.
        assertTrue(sistemaReservas.reservarPista(3, "11-04-2020", 60));
        
        // Intento de reservar una pista fuera del rango válido (pista 10, que es mayor que el máximo permitido).
        assertFalse(sistemaReservas.reservarPista(10, "11-04-2020", 60));
    }
}

