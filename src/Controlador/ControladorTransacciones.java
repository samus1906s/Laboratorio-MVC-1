/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.ServicioCuentas;
import Modelo.TipoTransaccion;
import Modelo.Transaccion;
import Vista.IVista;

public class ControladorTransacciones {
    private final ServicioCuentas servicio;
    private final IVista<Transaccion> vista;

    public ControladorTransacciones(ServicioCuentas servicio, IVista<Transaccion> vista) {
        this.servicio = servicio;
        this.vista = vista;
    }

    public void ejecutarTransaccion(String origen, String destino, double monto,boolean deposito, boolean retiro, boolean transferencia) {
        try {
            Transaccion tx = null;

            if (deposito) {
                servicio.depositar(origen, monto);
                tx = new Transaccion(origen, null, monto,servicio.buscarCuenta(origen).getSaldo(),TipoTransaccion.DEPOSITO);
            } else if (retiro) {
                servicio.retirar(origen, monto);
                tx = new Transaccion(origen, null, monto,servicio.buscarCuenta(origen).getSaldo(),TipoTransaccion.RETIRO);
            } else if (transferencia) {
                servicio.tranferir(origen, destino, monto);
                tx = new Transaccion(origen, destino, monto,servicio.buscarCuenta(origen).getSaldo(),TipoTransaccion.TRANSFERENCIA);
            }

            if (tx != null) {
                vista.mostrarDatos(tx);
                vista.mostrarMensaje("Transacción realizada con éxito", "Éxito");
            }

        } catch (Exception ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void buscarCuentaOrigen(String numero) {
        try {
               Cuenta c = servicio.buscarCuenta(numero);
               //vista.mostrarDatosCuentaOrigen(c);
        } catch (Exception e) {
               vista.mostrarError(e.getMessage());
        }
    }

    public void buscarCuentaDestino(String numero) {
        try {
               Cuenta c = servicio.buscarCuenta(numero);
               //vista.mostrarDatosCuentaDestino(c);
        } catch (Exception e) {
               vista.mostrarError(e.getMessage());
        }
    }
}


