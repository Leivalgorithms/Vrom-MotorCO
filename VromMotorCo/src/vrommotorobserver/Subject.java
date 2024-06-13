/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vrommotorobserver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leiva
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void performImportantAction(String message) {
        // Realiza una acción importante y notifica a los observadores
        System.out.println("Performing important action: " + message);
        notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}
