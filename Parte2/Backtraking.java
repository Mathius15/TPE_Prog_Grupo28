package Parte2;

import Parte_1.Procesador;
import Parte_1.Tarea;

import java.util.ArrayList;
import java.util.List;

public class Backtraking {

    private List<Tarea> tareas;
    private List<Procesador> procesadores;

    public Backtraking(List<Procesador> pro, List<Tarea> tar){
        this.procesadores = pro;
        this.tareas = tar;
    }

    public void backtracking(){
        //Creo la lista solucion con todos los procesadores cargados
        List<Procesador> solucion = new ArrayList<>(procesadores);
        //Creo la lista que va a ir probando todas las tareas en cada procesador
        List<Procesador> posSolucion = new ArrayList<>(procesadores);


        //Se va a quedar con la mejor combinacion de tareas en cada procesador
        solucion = back(solucion,posSolucion, 0);

        System.out.println("Backtraking");
        System.out.println("Solucion obtenida : ");
        for (Procesador procesador : solucion){
            procesador.imprimirProcesadorconTareas();
        }
        System.out.println("Solucion obtenida : " + tiempoMaximoEjecucion(solucion));
        System.out.println("Metrica para analizar el costo de la solucion (cantidad de estados generados)");
    }

    private int tiempoMaximoEjecucion (List<Procesador> p){
        int tiempoMaximo = 0;
        for (Procesador procesador : p){
            if (tiempoMaximo < procesador.tiempoMaximo()){
                tiempoMaximo = procesador.tiempoMaximo();
            }
        }
        return tiempoMaximo;
    }

    //Metodo privado backtraking
    private List<Procesador> back (List<Procesador> solucion, List<Procesador> posSolucion, int count) {
        //Soluciones
        if (soySolucion(posSolucion)) {
            if (esLaMejorSolucion(solucion, posSolucion)) {
                //solucion ahora tiene tareas asignadas de forma eficiente
                //Problema estoy cargando a solucion la referencia a las tareas de posSolucion
                //por lo que al sacarlas despues pierdo la referencia yo tambien en solucion
                List<Procesador> res = new ArrayList<>(posSolucion);
                solucion = res;
            }
        } else {
            //Iteracion cuando no es solucion
            //Itero cada procesador
            for (Procesador procesador : posSolucion) {
                //asigno tarea a un procesador
                procesador.addTarea(tareas.get(count));
                //llamado recursivo para seguir asignando tareas hasta que esten todas cargadas
                solucion = back(solucion, posSolucion, count + 1);
                //remuevo la tarea asignada para que se pueda usar devuelta en otro lugar
                procesador.removeTarea(tareas.get(count));
            }
        }
        return solucion;
    }

    private boolean soySolucion(List<Procesador> posSolucion) {
        //itero cada tarea
        for (Tarea tarea : tareas) {
            //condicion corte si una tarea no esta en ningun procesador
            boolean estoyAsignado = false;
            //itero cada procesador
            for(Procesador procesador : posSolucion){
                //si un procesador tiene la tarea significa que esta asignada por lo que seguiria las iteraciones
                if (procesador.tengoTarea(tarea)) {
                    estoyAsignado = true;
                }
            }
            //caso de que una tarea no este asignada, posSolucion no es solucion
            if (! estoyAsignado ){
                return false;
            }
        }
        return true;
    }

    private boolean procesadoresSinTareas (List<Procesador> solucion ){
        boolean sinTareas = true;
        for (Procesador p : solucion){
            if (! p.getTareas().isEmpty()){
                sinTareas = false;
            } else {
                return true;
            }
        }
        return sinTareas;
    }

    private boolean esLaMejorSolucion(List<Procesador> solucion, List<Procesador> posSolucion){
        //Primer caso con solucion sin ninguna tarea asignada
        if (this.procesadoresSinTareas(solucion)){
            return true;
        }

        //retorna true si mi posSolucion es mejor que solucion
        return (tiempoMaximoEjecucion(posSolucion) < tiempoMaximoEjecucion(solucion));
    }
}
