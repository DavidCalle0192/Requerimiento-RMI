/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteHabitacion;

import static clienteHabitacion.ClienteHabitacion.objRemoto;
import clienteHabitacion.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.Scanner;
import servidorAlertas.dto.UsuarioDTO;
import servidorAlertas.sop_rmi.GestionPacienteInt;

/**
 *
 * @author usuario
 */
public class ClientePruebas {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
    
        UsuarioDTO objAdminstrador = new UsuarioDTO(1,"CC","David","Calle","sdf54634");
        UsuarioDTO objMedico = new UsuarioDTO(2,"CC","willian","Ortega","sdf54635");
        
        Scanner reader = new Scanner(System.in);
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = reader.nextLine();

        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = reader.nextInt();

        //objeto remoto incorrecto para bruebas  
        objRemoto = (GestionPacienteInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoAsintomatico");
        //MenuPrincipal();
        objRemoto.establecerMaxPacientes(2);
        System.out.println("numero "+objRemoto.obtenerMaxPacientes());
        objRemoto.registrarPaciente(objAdminstrador);
        objRemoto.registrarPaciente(objMedico);
    
        int n = objRemoto.listarPacientes().size();
        System.out.println("tamañote"+n);
        for(int i=0;i<objRemoto.listarPacientes().size();i++){
            System.out.println(objRemoto.listarPacientes().get(i).getId());
        }
    }
    
    
    
}
