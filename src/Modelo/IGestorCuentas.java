/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;


/**
 *
 * @author josep
 */
public interface IGestorCuentas {
    void crearCuenta(String titularid, TipoCuenta tipo);
    void eliminar(String numero);
    void actualizar(String numero, EstadoCuenta estado);
    Cuenta buscar(String numero);
    List<Cuenta> listar();
    void depositar(String numero, double monto);
    void retirar(String numero, double monto);
    void tranferir(String origen, String destino, double saldo);
}
