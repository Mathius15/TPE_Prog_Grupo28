import Parte_1.Servicios;
import Parte_1.Tarea;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String pathProcesadores = "C:\\Users\\Nataliia\\Desktop\\Caro\\TPE_Prog3-main\\TPE_Prog3_G28\\Dataset\\Procesadores.csv";
        String pathTareas = "C:\\Users\\Nataliia\\Desktop\\Caro\\TPE_Prog3-main\\TPE_Prog3_G28\\Dataset\\Tareas.csv";

        Servicios servicios = new Servicios(pathProcesadores, pathTareas);


    }
}