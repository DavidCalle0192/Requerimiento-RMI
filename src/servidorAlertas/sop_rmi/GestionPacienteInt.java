/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorAlertas.sop_rmi;

import clienteHabitacion.dto.IndicadorDTO;
import clienteHabitacion.dto.PacienteDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author usuario
 */
public interface GestionPacienteInt extends Remote{
    
    public String registrarPaciente(PacienteDTO objPaciente) throws RemoteException;  
    public String enviarIndicadores(IndicadorDTO objIndicador) throws RemoteException; 
    public String alertaDomicilio(String mensaje) throws RemoteException; 
    public boolean establecerMaxPacientes(int num)throws RemoteException;
    public int obtenerMaxPacientes()throws RemoteException;
    
}
