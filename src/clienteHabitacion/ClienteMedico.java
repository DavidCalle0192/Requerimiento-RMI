/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteHabitacion;

import static clienteHabitacion.ClienteAdministrador.objRemoto;
import clienteHabitacion.utilidades.UtilidadesRegistroC;
import java.rmi.RemoteException;
import java.util.Scanner;
import servidorAlertas.sop_rmi.GestionPacienteInt;

/**
 *
 * @author usuario
 */
public class ClienteMedico {

    public static GestionPacienteInt objRemoto;
    /**
     * @param args the command line arguments
     */
    public  void iniciarSesion( String direccionIpRMIRegistry, int numPuertoRMIRegistry)throws RemoteException {
        // TODO code application logic here
        /*Scanner reader = new Scanner(System.in);
        int numPuertoRMIRegistry = 2020;
        String direccionIpRMIRegistry = "localhost";
/*
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = reader.nextLine();

        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = reader.nextInt();
*/
        objRemoto = (GestionPacienteInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoAsintomatico");
        
        System.out.println("valor: "+objRemoto.obtenerMaxPacientes());
    }
    
    public GestionPacienteInt obtenerObjRemoto(){
        return objRemoto;
    }
}
