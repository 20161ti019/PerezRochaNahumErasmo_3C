package mx.edu.utez.model.tipo;

public class BeanTipo {
    private int idTipo;
    private String nameTipo;

    public BeanTipo() {
    }

    public BeanTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNameTipo() {
        return nameTipo;
    }

    public void setNameTipo(String nameTipo) {
        this.nameTipo = nameTipo;
    }
}
