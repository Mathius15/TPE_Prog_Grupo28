import Parte2.Backtraking;
import Parte_1.CSVReader;
import Parte_1.Procesador;
import Parte_1.Servicios;
import Parte_1.Tarea;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pathProcesadores = "C:\\Users\\Mati\\Desktop\\Tpe_Prog_3_28\\Dataset\\Procesadores.csv";
        String pathTareas = "C:\\Users\\Mati\\Desktop\\Tpe_Prog_3_28\\Dataset\\Tareas.csv";

        Servicios servicios = new Servicios(pathProcesadores, pathTareas);
        /*
        if (servicios.servicio1("T1") == null) {
            System.out.println("LA TAREA NO EXISTE");
        } else {
            System.out.println(servicios.servicio1("T1"));
        }
        System.out.println("-----");
        System.out.println(servicios.servicio2(false));
        System.out.println("-----");
        System.out.println(servicios.servicio3(60, 70));
        */

        //Parte 2
        CSVReader csv = new CSVReader();
        List<Procesador> procesadores;
        List<Tarea> tareas = new ArrayList<>(servicios.servicio2(true));
        tareas.addAll(servicios.servicio2(false));




        procesadores = csv.readProcessors(pathProcesadores);
        Backtraking backPrueba = new Backtraking(procesadores,tareas);
        backPrueba.backtracking();

    }
}