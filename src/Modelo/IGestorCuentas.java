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
    void crearCuenta(String titularId, TipoCuenta tipo) throws Exception;
    void eliminar(String numero) throws Exception;;
    void actualizar(String numero, EstadoCuenta estado) throws Exception;;
    Cuenta buscar(String numero) throws Exception;;
    List<Cuenta> listar();
    void depositar(String numero, double monto) throws Exception;;
    void retirar(String numero, double monto) throws Exception;;
    void tranferir(String origen, String destino, double monto) throws Exception;;
}
