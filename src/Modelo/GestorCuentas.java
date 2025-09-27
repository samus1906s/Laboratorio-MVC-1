/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author josep
 */
public class GestorCuentas implements IGestorCuentas{
    private final List<Cuenta> cuentas;
    private static final String DIGITOS = "123";
    private long consec;

    public GestorCuentas() {
        this.cuentas = new ArrayList<>();
        this.consec = 1;
    }
    
    
    private String generarNumeros(){
        String numConsec = String.format("%017d", consec++);
        return DIGITOS + numConsec;
    }
    @Override
    public void crearCuenta(String titularId, TipoCuenta tipo) {
        String numero = generarNumeros();
        Cuenta cuenta = new Cuenta(numero, titularId, tipo);
        cuentas.add(cuenta);
    }

    @Override
    public void eliminar(String numero) throws Exception{
        Objects.requireNonNull(numero, "Numero de cuenta requerido");
        Cuenta cuenta = buscar(numero);
        if (cuenta == null) throw new Exception("Cuenta no encontrada");
        if (cuenta.getSaldo()!=0) throw new Exception("Solo se puede eliminar una cuenta cuando su saldo es 0");
        cuentas.remove(cuenta);
    }

    @Override
    public void actualizar(String numero, EstadoCuenta estado) throws Exception{
        Objects.requireNonNull(numero, "Numero de cuenta requerido");
        Cuenta cuenta = buscar(numero);
        if (cuenta == null) throw new Exception("Cuenta no encontrada");
        cuenta.setEstado(estado);
    }

    @Override
    public Cuenta buscar(String numero) throws Exception{
        Objects.requireNonNull(numero, "Numero de cuenta requerido");
        for (Cuenta c : cuentas){
            if (c.getNumero().equals(numero)) return c;
        }
        throw new Exception("Cuenta no encontrada");
    }

    @Override
    public List<Cuenta> listar() {
        return new ArrayList<>(cuentas);
    }

    @Override
    public void depositar(String numero, double monto) throws Exception{
       Objects.requireNonNull(numero, "Ingrese numero de cuenta a depositar"); 
       Cuenta cuenta = buscar(numero);
       if (cuenta.getEstado()!= EstadoCuenta.ACTIVA) throw new Exception("Cuenta no activa");
       if (monto <=0) throw new Exception("El monto no puede ser menos de 0 o negativo");
       cuenta.setSaldo(cuenta.getSaldo()+monto);
    }

    @Override
    public void retirar(String numero, double monto) throws Exception{
       Objects.requireNonNull(numero, "Ingrese numero de cuenta a retirar"); 
       Cuenta cuenta = buscar(numero); 
       if (cuenta.getEstado()!= EstadoCuenta.ACTIVA) throw new Exception("Cuenta no activa");
       if (monto <=0) throw new Exception("El monto debe ser positivo");
       if (cuenta.getSaldo()<monto) throw new Exception("Saldo insuficiente");
       cuenta.setSaldo(cuenta.getSaldo()-monto);
    }

    @Override
    public void tranferir(String origen, String destino, double monto) throws Exception{
        if (origen.equals(destino)) throw new Exception("No se puede transferir a la misma cuenta de origen");
        retirar(origen, monto);
        depositar(destino, monto);
    }
}
