/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorNotificaciones.dto;

import java.io.Serializable;
import java.util.ArrayList;
import servidorAlertas.dto.HistorialDTO;
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.PacienteDTO;

/**
 *
 * @author JhonMZ
 */
public class AlertaDTO implements Serializable{
    private ArrayList<HistorialDTO> historial;
    private IndicadorDTO indicadores;
    private PacienteDTO paciente;

    public AlertaDTO(ArrayList<HistorialDTO> historial, IndicadorDTO indicadores, PacienteDTO paciente) {
        this.historial = historial;
        this.indicadores = indicadores;
        this.paciente = paciente;
    }

    public ArrayList<HistorialDTO> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<HistorialDTO> historial) {
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
    
    
}
