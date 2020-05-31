/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorAlertas.dto;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class IndicadorDTO implements Serializable {
    
    private int frecuenciaCardiaca;
    private int frecuenciaRespiratoria;
    private float temperatura;
    private PacienteDTO objPaciente;

    public IndicadorDTO(int frecuenciaCardiaca, int frecuenciaRespiratoria, float temperatura, PacienteDTO objPaciente) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperatura = temperatura;
        this.objPaciente = objPaciente;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public PacienteDTO getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(PacienteDTO objPaciente) {
        this.objPaciente = objPaciente;
    }
    
    
    
}
