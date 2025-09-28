/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author je110
 */
public enum TipoTransaccion {
    DEPOSITO ("Deposito"), RETIRO ("Retiro"), TRANSFERENCIA ("Transferencia");
    
    private String transacciones;

    private TipoTransaccion(String transacciones) {
        this.transacciones = transacciones;
    }

    public String getTransacciones() {
        return transacciones;
    }
    
}
