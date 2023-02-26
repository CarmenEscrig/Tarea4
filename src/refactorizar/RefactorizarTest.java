package refactorizar;

import static org.junit.jupiter.api.Assertions.*;

class RefactorizarTest {

    int[] prueba1= {2,3,5};
    int[] prueba2 = {2,3,5,7};
    int[] prueba3 = {2,3,5,7,11,13,17};
    int[] prueba4 = {2,3,5,7,11,13,17,19,23};
    int[] prueba5= {2,3,5,7,11,13,17,19,23,29};


    @org.junit.jupiter.api.Test
    void generarPrimos() {
        assertArrayEquals(prueba1, Refactorizar.generarPrimos(5));
        assertArrayEquals(prueba2, Refactorizar.generarPrimos(10));
        assertArrayEquals(prueba3, Refactorizar.generarPrimos(18));
        assertArrayEquals(prueba4, Refactorizar.generarPrimos(25));
        assertArrayEquals(prueba5, Refactorizar.generarPrimos(30));

    }
}