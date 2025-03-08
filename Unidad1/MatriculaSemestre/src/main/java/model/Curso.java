package model;

public class Curso {
    String nombre;
    int creditos;
    int id;

    public Curso(String nombre, int creditos, int idP) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.id = idP;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
