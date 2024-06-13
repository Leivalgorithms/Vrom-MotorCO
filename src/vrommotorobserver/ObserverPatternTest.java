/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorobserver;

/**
 *
 * @author leiva
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Crear una instancia de Subject
        Subject subject = new Subject();

        // Crear instancias de EmailNotification (observadores)
        EmailNotification emailNotification1 = new EmailNotification("email@gmail.com");
        

        // Agregar observadores al Subject
        subject.addObserver(emailNotification1);
        //subject.addObserver(emailNotification2);

        // Realizar una acción importante que notificará a los observadores
        subject.performImportantAction("This is an important action!");
    }
}
