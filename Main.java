import Parte_1.Servicios;
import Parte_1.Tarea;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String pathProcesadores = "C:\\Users\\USUARIO\\Desktop\\TPE_Prog_Grupo28\\Dataset\\Procesadores.csv";
        String pathTareas = "C:\\Users\\USUARIO\\Desktop\\TPE_Prog_Grupo28\\Dataset\\Tareas.csv";

        Servicios servicios = new Servicios(pathProcesadores, pathTareas);
        if (servicios.servicio1("T1") == null) {
            System.out.println("LA TAREA NO EXISTE");
        } else {

            System.out.println(servicios.servicio1("T1"));
        }
        System.out.println("-----");
        System.out.println(servicios.servicio2(false));
        System.out.println("-----");
        System.out.println(servicios.servicio3(60, 70));

    }
}