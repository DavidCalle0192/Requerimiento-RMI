/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorAlertas.sop_rmi;

import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.PacienteDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import servidorAlertas.dao.HistorialAlertaDAO;
import servidorAlertas.dto.HistorialDTO;

/**
 *
 * @author JhonMZ
 */
public class ClsGestionPaciente extends UnicastRemoteObject implements GestionPacienteInt{

    private ArrayList<PacienteDTO> pacientes;
    private int MAX_PACIENTES;

    public ClsGestionPaciente() throws RemoteException {
        super();
        this.pacientes = new ArrayList<PacienteDTO>();
    }
    
    @Override
    public String registrarPaciente(PacienteDTO objPaciente) throws RemoteException {
        System.out.println("Ejecutando registrarPaciente...");
        String respuesta = "";
        
        if(!pacienteRegistrado(objPaciente)){
            if(pacientes.size()<MAX_PACIENTES){
                if(pacientes.add(objPaciente)){
                    respuesta = "Se registro el paciente";
                }else{
                    respuesta = "Error al registrar paciente";
                }
            }else{
                respuesta = "No se pueden registrar mas pacientes";
            }
        }else{
            respuesta = "El paciente ya estaba registrado";
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public String enviarIndicadores(IndicadorDTO objIndicador) throws RemoteException {
        System.out.println("Ejecutando enviarIndicadores...");
        
        String respuesta = "";
        
        int puntuacion = obtenerPuntuacion(objIndicador);
        
        if(puntuacion > 1){
            HistorialDTO objHistorial = new HistorialDTO(LocalDate.now(), LocalTime.now(), puntuacion);
            respuesta = "Se genera alerta";
            HistorialAlertaDAO.agregarHistorial(objHistorial, puntuacion);
        }else{
            respuesta = "Continuar monitorización";
        }
        
        System.out.println(respuesta);
        return respuesta;
    }
    
    private int obtenerPuntuacion(IndicadorDTO objIndicadores){
        int puntuacion = 0;
        
        if(objIndicadores != null){
            if(objIndicadores.getFrecuenciaCardiaca() < 60 
                    || objIndicadores.getFrecuenciaCardiaca() > 80)puntuacion++;

            if(objIndicadores.getFrecuenciaRespiratoria() < 70 
                    || objIndicadores.getFrecuenciaRespiratoria() > 90)puntuacion++;

            if(objIndicadores.getTemperatura() < 36.2 
                    || objIndicadores.getTemperatura() > 37.2)puntuacion++;
        }
        return puntuacion;
    }   
    

    @Override
    public String alertaDomicilio(String mensaje) throws RemoteException {
        return "";
    }

    @Override
    public boolean establecerMaxPacientes(int num) throws RemoteException {
        System.out.println("Ejecutando establecerMaxPacientes...");
        this.MAX_PACIENTES = num;
        return true;
    }

    @Override
    public int obtenerMaxPacientes() throws RemoteException {
        System.out.println("Ejecutando obtenerMaxPacientes...");
        return this.MAX_PACIENTES;
    }
    
    /**
     * @brief permite saber si un paciente ya se encuentra registrado
     * @param objPaciente objeto que contiene la informacion del paciente
     * @return retorna true si el paciente ya esta registrado o false si no lo esta
     */
    private boolean pacienteRegistrado(PacienteDTO objPaciente){
        //System.out.println("Buscando paciente...");
        boolean res = false;
        if(objPaciente != null){
            for (PacienteDTO pacienteDTO : pacientes) {
                if(pacienteDTO.getId() == objPaciente.getId()){
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
