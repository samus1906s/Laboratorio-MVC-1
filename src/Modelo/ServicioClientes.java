/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Cliente;
import Modelo.IGestorClientes;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author jprod
 */
public class ServicioClientes {
    private final IGestorClientes gestor;
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public ServicioClientes(IGestorClientes gestor) {
        this.gestor = gestor;
    }
    
    public void guardar(String id, String nombre, String correo, String telefono, boolean preferente) {
        validarRequeridos(id, nombre, correo, telefono);
        if (gestor.existe(id)) throw new IllegalArgumentException("Ya existe un registro con id=" + id);
        if (!EMAIL.matcher(correo).matches()) throw new IllegalArgumentException("Formato de correo inválido");
        nombre = nombrePropio(nombre);
        Cliente cliente = new Cliente(id, nombre, correo, telefono);
        cliente.setPreferente(preferente);
        gestor.guardar(cliente);
    }
    
    public void actualizar(String id, String correo, String telefono, boolean preferente) {
        Objects.requireNonNull(ultimoRegistro(), "No se ha cargado ningun registro");
        validarRequeridos(id, correo, telefono);
        if(!hayCambios(id, correo, telefono, preferente)) return;
        if (!gestor.existe(id)) throw new IllegalArgumentException("No existe un registro con id=" + id);
        if (!EMAIL.matcher(correo).matches()) throw new IllegalArgumentException("Formato de correo inválido");
        Cliente cliente=gestor.buscar(id);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setPreferente(preferente);
        gestor.actualizar(cliente);
    }
    
    public void eliminar(String id) {
        if (!gestor.existe(id)) throw new IllegalArgumentException("No existe ningun registro con id=" + id);
        gestor.eliminar(id);
    }
    
    public Cliente buscar(String id) {
        validarRequeridos(id);
        if(!gestor.existe(id)) throw new IllegalArgumentException("No existe ningun registro con id=" + id);
        return gestor.buscar(id);
    }
    
    public Cliente ultimoRegistro() {
        Cliente cliente = gestor.ultimoRegistro();
        Objects.requireNonNull(cliente, "No se ha cargado ningun registro");
        return cliente;
    }
    
    public boolean validarIdDisponible(String id){
        if(id==null||id.isBlank()) throw new IllegalArgumentException("Faltan datos requeridos");
        return !gestor.existe(id);
    }
    
    public List<Cliente> listar() {
        return gestor.listar();
    }
    
    private void validarRequeridos(String... datos){
        for(String dato:datos){
            if (dato==null || dato.isBlank())
                throw new IllegalArgumentException("Faltan datos requeridos");
        }
    }
    
    private boolean hayCambios(String id,String correo,String telefono, boolean preferente){
        Cliente cliente = gestor.buscar(id);
        Objects.requireNonNull(cliente, "No se ha cargado ningun registro");
        validarRequeridos(correo,telefono);
        return !(cliente.getCorreo().equals(correo) && cliente.getTelefono().equals(telefono) && cliente.isPreferente() == preferente);
    }
    
    private String nombrePropio(String nombre){
        if (nombre == null || nombre.isBlank()) return nombre;
        String[] letras = nombre.trim().toLowerCase().split("\\s+");
        StringBuilder ie = new StringBuilder();
        for (String letra : letras){
            if (letra.length() > 0){
            ie.append(Character.toUpperCase(letra.charAt(0)));
            if (letra.length()>1){
                ie.append(letra.substring(1));
            }
            ie.append(" ");
        }
        }
        return ie.toString().trim();
    }
}
