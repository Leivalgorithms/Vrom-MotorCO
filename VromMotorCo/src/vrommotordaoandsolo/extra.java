/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotordaoandsolo;

/**
 *
 * @author leiva
 */
public class extra {
    
    private int id;
    private String nombre;
    private int costo;
    
    public extra(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto$() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
