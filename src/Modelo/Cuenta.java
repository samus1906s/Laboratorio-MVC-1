/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Valdelomaar
 */
public class Cuenta {
     private final String numero;
    private final String titularId;
    private double monto;
    private double saldo;
    private EstadoCuenta estado;
    private final TipoCuenta tipo;

    public Cuenta(String numero, String titularId, TipoCuenta tipo) {
        this.numero = Objects.requireNonNull(numero);
        this.titularId = Objects.requireNonNull(titularId);
        this.tipo = Objects.requireNonNull(tipo);
        this.monto = 0.0;
        this.saldo = 0.0;
        this.estado = EstadoCuenta.ACTIVA;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitularId() {
        return titularId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }
}
