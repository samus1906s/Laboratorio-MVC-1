/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author je110
 */
public class Transaccion {
    
    // estan con "final" porque en este caso ninguna se podra cambiar o modificar al hacer la transacción ningun dato podra cambiar.
    private final Date fecha;
    private final String cuentaOrigen;
    private final String cuentaDestino; // null si no aplica
    private final double monto;
    private final double saldoFinal;
    private final TipoTransaccion tipo;

    public Transaccion(String cuentaOrigen, String cuentaDestino, double monto, double saldoFinal, TipoTransaccion tipo) {
        this.fecha = new Date();
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.saldoFinal = saldoFinal;
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public TipoTransaccion getTipotransaccion() {
        return tipo;
    }
    
}
