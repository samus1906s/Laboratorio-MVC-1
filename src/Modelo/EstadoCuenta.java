/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author Valdelomaar
 */
public enum EstadoCuenta {
      ACTIVA("Activa"),
      INACTIVA("Inactiva");

    private final String nombre;

    EstadoCuenta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    @Override
    public String toString() { return nombre; }
}
