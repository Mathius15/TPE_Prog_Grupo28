package Parte_1;

public class Procesador {
    private String id;
    private int codigoProcesador;
    private boolean estaRefrigerado;
    private int anioFuncionamiento;

    public Procesador(String id, int codigoProcesador, boolean estaRefrigerado, int anioFuncionamiento) {
        this.id = id;
        this.codigoProcesador = codigoProcesador;
        this.estaRefrigerado = estaRefrigerado;
        this.anioFuncionamiento = anioFuncionamiento;
    }








    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodigoProcesador() {
        return codigoProcesador;
    }

    public void setCodigoProcesador(int codigoProcesador) {
        this.codigoProcesador = codigoProcesador;
    }

    public boolean isEstaRefrigerado() {
        return estaRefrigerado;
    }

    public void setEstaRefrigerado(boolean estaRefrigerado) {
        this.estaRefrigerado = estaRefrigerado;
    }

    public int getAnioFuncionamiento() {
        return anioFuncionamiento;
    }

    public void setAnioFuncionamiento(int anioFuncionamiento) {
        this.anioFuncionamiento = anioFuncionamiento;
    }
}
