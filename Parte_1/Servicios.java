package Parte_1;

import java.util.*;

public class Servicios {
    private  static ArrayList<Tarea> tareas = new ArrayList<>();
    private HashMap<String, Tarea> hashTareas;

    // AGREGAR COMPLEJIDAD

    public Servicios(String pathProcesadores, String pathTareas)
    {
        CSVReader reader = new CSVReader();
        reader.readProcessors(pathProcesadores);
         hashTareas = reader.readTasks(pathTareas);

    }

    public Tarea servicio1(String ID) {
        if (!hashTareas.isEmpty())
            return hashTareas.get(ID);
        else return null;
    }

    public List<Tarea> servicio2(boolean esCritica) {
        return null;
    }

    public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
        return null;
    }

    public Collection<Tarea> getTareas() {
        return hashTareas.values();
    }

}

