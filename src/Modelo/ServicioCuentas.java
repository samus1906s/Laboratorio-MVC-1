/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author josep
 */
public class ServicioCuentas {
    private final IGestorCuentas gestor;

    public ServicioCuentas(IGestorCuentas gestor) {
        this.gestor = gestor;
    }
    
    public void crearCuenta(String titularId, TipoCuenta tipo) throws Exception{
        validarRequeridos(titularId);
        gestor.crearCuenta(titularId, tipo);
    }
    public void eliminarCuenta(String numero) throws Exception{
        validarRequeridos(numero);
        gestor.eliminar(numero);
    }
    
    public void actualizarCuenta(String numero, EstadoCuenta estado) throws Exception{
        validarRequeridos(numero);
        gestor.actualizar(numero, estado);
    }
    
    public Cuenta buscarCuenta(String numero) throws Exception{
        validarRequeridos(numero);
        return gestor.buscar(numero);
    }
    
    public List<Cuenta> listarCuentas(){
        return gestor.listar();
    }
    
    public void depositar(String numero, double monto) throws Exception{
         validarRequeridos(numero);
         if (monto<=0) throw new Exception("El monto debe ser positivo o mayor a 0");
         gestor.depositar(numero, monto);
    }
    
    public void retirar(String numero, double monto) throws Exception{
        validarRequeridos(numero);
         if (monto<=0) throw new Exception("El monto debe ser positivo o mayor a 0");
         gestor.retirar(numero, monto);
    }
    
    public void tranferir(String origen, String destino, double monto) throws Exception{
         validarRequeridos(origen, destino);
         if (origen.equals(destino)) throw new Exception("No se puede transferir a la misma cuenta de origen");
         if (monto<=0) throw new Exception("El monto debe ser positivo o mayor a 0");
         gestor.tranferir(origen, destino, monto);
    }

    private void validarRequeridos(String... campos) throws Exception{
        for (String campo : campos){
            if (campo == null || campo.isBlank()) throw new Exception("Faltan datos");
        }
    }
    
}
