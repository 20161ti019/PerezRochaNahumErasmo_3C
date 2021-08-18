package mx.edu.utez.model.cartas;

import mx.edu.utez.model.tipo.BeanTipo;

public class BeanCartas {
    private int idCartas;
    private String name;
    private String fechaDeRegistro;
    private BeanTipo tipo_idTipo;
    private int status;

    public BeanCartas() {
    }

    public BeanCartas(int idCartas, String name, String fechaDeRegistro, BeanTipo tipo_idTipo, int status) {
        this.idCartas = idCartas;
        this.name = name;
        this.fechaDeRegistro = fechaDeRegistro;
        this.tipo_idTipo = tipo_idTipo;
        this.status = status;
    }

    public int getIdCartas() {
        return idCartas;
    }

    public void setIdCartas(int idCartas) {
        this.idCartas = idCartas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public BeanTipo getTipo_idTipo() {
        return tipo_idTipo;
    }

    public void setTipo_idTipo(BeanTipo tipo_idTipo) {
        this.tipo_idTipo = tipo_idTipo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
