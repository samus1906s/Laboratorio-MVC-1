/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ServicioCuentas;
import Modelo.Cuenta;
import Modelo.EstadoCuenta;
import Modelo.TipoCuenta;
import Vista.IVista;
import java.util.List;

/**
 *
 * @author samue
 */
public class ControladorCuentas {
    private final ServicioCuentas servicio;
    private final IVista vista;

    public ControladorCuentas(ServicioCuentas servicio, IVista vista) {
        this.servicio = servicio;
        this.vista = vista;
    }

    public void crearCuenta(String titularId, TipoCuenta tipo){
        try{
            servicio.crearCuenta(titularId, tipo);
            vista.deshabilitarCampos();
            vista.mostrarMensaje("Se a agregado una cuenta","Cuenta agregada");
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
    public void buscarCuenta(String numero){
        try{
            Cuenta cuenta = servicio.buscarCuenta(numero);
            vista.mostrarDatos(cuenta);
        }catch(Exception ex){
          vista.mostrarError(ex.getMessage());  
        }
    }
    
    public void eliminarCuenta(String numero){
    try{
        if(!vista.confirmar("¿Está seguro que desea eliminar la cuenta?", "Eliminar Cuenta")) return;
        servicio.eliminarCuenta(numero);
        vista.habilitarCampos();
        vista.limpiar();
        vista.mostrarMensaje("Cuenta eliminada con éxito", "Éxito");
    }catch(Exception e){
        vista.mostrarError(e.getMessage());
    }
   }
    
   public void listarCuentas(){
        try{
            List<Cuenta> cuentas = servicio.listarCuentas();
            for(Cuenta c : cuentas){
                vista.mostrarDatos(c);
            }
        }catch(Exception ex){
            vista.mostrarError( ex.getMessage());
        }
    }
   
   public void depositar(String numero, double monto){
        try{
            servicio.depositar(numero, monto);
            vista.mostrarMensaje("Depósito realizado", "Éxito");
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
    
   public void retirar(String numero, double monto){
        try{
            servicio.retirar(numero, monto);
            vista.mostrarMensaje("Retiro realizado", "Éxito");
        }catch(Exception ex){
            vista.mostrarError(ex.getMessage());
        }
    }
   
   public void transferir(String origen, String destino, double monto){
        try{
            servicio.tranferir(origen, destino, monto);
            vista.mostrarMensaje("Transferencia realizada con éxito", "Éxito");
        }catch(Exception e){
            vista.mostrarError("Error al transferir: " + e.getMessage());
        }
    }
   
   public void actualizarEstadoCuenta(String numero, EstadoCuenta estado) {
    try {
        servicio.actualizarCuenta(numero, estado);
        vista.mostrarMensaje("Estado actualizado", "Éxito");
    } catch (Exception ex) {
        vista.mostrarError(ex.getMessage());
    }
   }
}
