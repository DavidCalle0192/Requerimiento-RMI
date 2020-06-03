/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorNotificaciones.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
import servidorAlertas.dto.HistorialDTO;
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.PacienteDTO;
import servidorNotificaciones.dto.AlertaDTO;

/**
 *
 * @author JhonMZ
 */
public class ClsNotificaciones extends UnicastRemoteObject implements NotificacionesInt{

    public ClsNotificaciones() throws RemoteException {
        super();
    }
    
    @Override
    public void enviarAlerta(AlertaDTO objAlerta) throws RemoteException {
        PacienteDTO objPaciente = objAlerta.getPaciente();
        
        System.out.println("Nombre:"+objPaciente.getNombres()+" "+objPaciente.getApellidos());
        System.out.println("Identificacion: "+objPaciente.getTipo_id()+" "+objPaciente.getId());
        System.out.println("Direccion:"+objPaciente.getDireccion());
        
        IndicadorDTO objIndicador = objAlerta.getIndicadores();
        System.out.println("Indicadores del paciente con id "+objIndicador.getIdPaciente());
        System.out.println("FC:"+objIndicador.getFrecuenciaCardiaca());
        System.out.println("FR:"+objIndicador.getFrecuenciaRespiratoria());
        System.out.println("ToC:"+objIndicador.getTemperatura());
        System.out.println("Puntuacion:"+objAlerta.getPuntuacion());
        Stack<HistorialDTO> historial = objAlerta.getHistorial();
        System.out.println("***Historial***");
        while(!historial.empty()){
            System.out.println(historial.pop().getHora().toString());
        }
    }
    
}
