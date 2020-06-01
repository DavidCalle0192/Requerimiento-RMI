package clienteHabitacion.dto;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author David Calle
 */
public class PacienteDTO {
    
    private int id;
    private String tipo_id;
    private String nombres;
    private String apellidos;
    private String Direccion;
    //private IndicadorDTO indicadores;
    
    public PacienteDTO(int id, String tipo_id, String nombres, String apellidos, String Direccion){//,IndicadorDTO listaIndicadores) {
        this.id = id;
        this.tipo_id = tipo_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Direccion = Direccion;
        //this.indicadores=null;
    }
/*
    public IndicadorDTO getListaIndicadores() {
        return indicadores;
    }

    public void setListaIndicadores(IndicadorDTO listaIndicadores) {
        this.indicadores = listaIndicadores;
    }
*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
}
