/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteHabitacion;


import clienteHabitacion.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.UsuarioDTO;
import servidorAlertas.sop_rmi.GestionPacienteInt;

/**
 *
 * @author usuario
 */
public class ClienteMedico {
    
    public static IndicadorDTO inidicador;
    public static GestionPacienteInt objRemoto;
    private static int cont = 0;
    /**
     * @param args the command line arguments
     */
    public  void iniciarSesion( String direccionIpRMIRegistry, int numPuertoRMIRegistry)throws RemoteException {
        // TODO code application logic here
        objRemoto = (GestionPacienteInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoAsintomatico");
        System.out.println("valor: "+objRemoto.obtenerMaxPacientes());
    }
    
    /*
    public GestionPacienteInt obtenerObjRemoto(){
        return objRemoto;
    }*/
    
     public boolean validarPacientesExistentes() throws RemoteException{
            if(objRemoto.listarPacientes().size()==0){
                return false;
            }else{
                return true;
            }
        }
     
     public boolean existeId(int id, GestionPacienteInt objRemoto) throws RemoteException{
         for(int i=0;i<objRemoto.listarPacientes().size();i++){
             if(objRemoto.listarPacientes().get(i).getId()==id){
                 return true;
            }
         }
         return false;
     }
     
     public IndicadorDTO iniciarSeguimiento(int id) throws RemoteException {
            inidicador = new IndicadorDTO(0,0,0,id);
                    
                    Random fcr = new Random();
                    inidicador.setFrecuenciaCardiaca((int) (50 + fcr.nextFloat() * (90 - 50)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);
                    
                    Random frr = new Random();
                    inidicador.setFrecuenciaRespiratoria((int) (60 + frr.nextFloat() * (100 - 60)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);
                    
                    Random ter = new Random();
                    inidicador.setTemperatura((float) (35.2 + ter.nextFloat() * (38.2 - 35.2)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);
     
                    
                    //objRemoto.enviarIndicadores(indicador);
                    return inidicador;
    }
     
    public void enviarinfo() throws RemoteException{
    
        IndicadorDTO aux=new IndicadorDTO(0, 0, 0, 1);
        objRemoto.enviarIndicadores(aux);
    }
}
