/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorAlertas.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author JhonMZ
 */
public class HistorialDTO {
    LocalDate fecha;
    LocalTime Hora;
    int puntuacion;

    public HistorialDTO(LocalDate fecha, LocalTime Hora, int puntuacion) {
        this.fecha = fecha;
        this.Hora = Hora;
        this.puntuacion = puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return Hora;
    }

    public void setHora(LocalTime Hora) {
        this.Hora = Hora;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}