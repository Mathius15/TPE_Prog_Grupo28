package Parte_1;

import java.util.*;

public class Servicios {
    private HashMap<String, Tarea> hashTareas;
    private List<Tarea> tareasCriticas = new ArrayList<>();
    private List<Tarea> tareasNoCriticas = new ArrayList<>();



    // AGREGAR COMPLEJIDAD

    public Servicios(String pathProcesadores, String pathTareas) {
        CSVReader reader = new CSVReader();
        reader.readProcessors(pathProcesadores);
        hashTareas = reader.readTasks(pathTareas);

        dividirTareas();
    }

    //Complejidad: O(1)
    public Tarea servicio1(String ID) {
        if (!hashTareas.isEmpty())
            return hashTareas.get(ID);
        else return null;
    }



    //Complejidad: 0(1)
    public List<Tarea> servicio2(boolean esCritica) {
        if (esCritica) {
            return tareasCriticas;
        } else {
            return tareasNoCriticas;
        }
    }

    //Complejidad: 0(n)
    public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {
        Collection<Tarea> cole = getTareas();
        List<Tarea> rta = new LinkedList<>();
        if (!cole.isEmpty()) {
            for (Tarea tarea : cole) {
                if(tarea.getPrioridad() <= prioridadSuperior && tarea.getPrioridad() >= prioridadInferior) {
                    rta.add(tarea);
                }
            }
        }
        return rta;
    }

    private void dividirTareas() {
        Collection<Tarea> cole = getTareas();

        if (!cole.isEmpty()) {
            for (Tarea tarea : cole) {
                if (tarea.isEsCritica()) {
                    tareasCriticas.add(tarea);
                } else {
                    tareasNoCriticas.add(tarea);
                }
            }
        }

    }

    public Collection<Tarea> getTareas() {
        return hashTareas.values();
    }

}

