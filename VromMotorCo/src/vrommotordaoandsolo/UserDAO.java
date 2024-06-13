/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vrommotordaoandsolo;

import java.util.List;

/**
 *
 * @author leiva
 */
public interface UserDAO {
    
     List<user> obtenerTodos();
    public int insertarcarro(String cliente, int cedula, String email, String modelo, String marca, String version);
    void actualizar(user usuario);
    void eliminar(int id);
    
}
