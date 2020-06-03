/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorNotificaciones.dto;

import java.io.Serializable;
import java.util.Stack;
import servidorAlertas.dto.HistorialDTO;
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.PacienteDTO;

/**
 *
 * @author JhonMZ
 */
public class AlertaDTO implements Serializable{
    private Stack<HistorialDTO> historial;
    private IndicadorDTO indicadores;
    private PacienteDTO paciente;
    private int puntuacion;

    public AlertaDTO(Stack<HistorialDTO> historial, IndicadorDTO indicadores, PacienteDTO paciente, int puntuacion) {
        this.historial = historial;
        this.indicadores = indicadores;
        this.paciente = paciente;
        this.puntuacion = puntuacion;
    }

    public Stack<HistorialDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(Stack<HistorialDTO> historial) {
        this.historial = historial;
    }

    public IndicadorDTO getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(IndicadorDTO indicadores) {
        this.indicadores = indicadores;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}
