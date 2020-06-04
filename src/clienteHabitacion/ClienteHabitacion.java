package clienteHabitacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import servidorAlertas.dto.IndicadorDTO;
import servidorAlertas.dto.UsuarioDTO;
import clienteHabitacion.utilidades.UtilidadesRegistroC;
import clienteHabitacion.utilidades.UtilidadesConsola;
import servidorAlertas.sop_rmi.GestionPacienteInt;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Calle
 */
public class ClienteHabitacion {

    public static GestionPacienteInt objRemoto;
    private static ArrayList listadoId = new ArrayList(5);
    private static int cont = 0;
    public static String direccionIp;
    public static int puerto;

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public GestionPacienteInt devolverObjRemoto() {

        return objRemoto;
    }

    /**
     * @param args the command line arguments
     */
    //atributos
    public void principal() throws RemoteException {

        Scanner reader = new Scanner(System.in);
        int numPuertoRMIRegistry = puerto;
        String direccionIpRMIRegistry = direccionIp;
        objRemoto = (GestionPacienteInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoAsintomatico");
        //MenuPrincipal();
    }

    private static void MenuPrincipal() throws RemoteException {

        ArrayList<UsuarioDTO> listaPaciente = new ArrayList<UsuarioDTO>();
        int aux = 0;//variable para validar la opción 2
        int opcion = 0;
        do {
            System.out.println("========Menu==========");
            System.out.println("1. Registrar Paciente ");
            System.out.println("2. Iniciar seguimiento");
            System.out.println("3. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    aux = 1;

                    System.out.println("Validando Existencia de un paciente con el mismo ID");
                    System.out.println("Ingrese el id: ");
                    Scanner leer = new Scanner(System.in);
                    int dni = leer.nextInt();
                    if (listadoId.contains(dni)) {
                        System.out.println("Existe un paciente con ese id, por favor ingrese otro valor.");
                    } else {
                        listadoId.add(dni);
                        System.out.println("No existen pacientes con ese ID, se procedera a la creación del nuevo registro con este ID.");
                        System.out.println();
                        Opcion1(dni, listaPaciente);

                        cont++;

                    }

                    break;
                case 2:
                    if (aux == 1) {
                        Opcion2(listaPaciente);

                    } else {
                        System.out.println("No existen pacientes registrados.");
                    }

                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 3);
    }

    private static void Opcion1(int id, ArrayList<UsuarioDTO> listaPaciente) throws RemoteException {

        UsuarioDTO objPAciente = new UsuarioDTO(id, " ", " ", " ", " ");

        if (cont <= 5) {

            System.out.println("==Registro del Paciente==");

            //SOLICITAR DATOS DEL PACIENTE
            System.out.println("Ingrese el tipo de id ");
            String tipo_id = UtilidadesConsola.leerCadena();
            objPAciente.setTipo_id(tipo_id);

            System.out.println("Ingrese el nombre del paciente ");
            String nombres = UtilidadesConsola.leerCadena();
            objPAciente.setNombres(nombres);

            System.out.println("Ingrese el apellido del paciente ");
            String apellidos = UtilidadesConsola.leerCadena();
            objPAciente.setApellidos(apellidos);

            System.out.println("Ingrese la dirección del paciente");
            String direccion = UtilidadesConsola.leerCadena();
            objPAciente.setDireccion(direccion);
            System.out.println();

            listaPaciente.add(objPAciente);
            objRemoto.registrarPaciente(objPAciente);
            //System.out.println(cont);
            System.out.println("Paciente registrado exitosamente.");
        } else {
            System.out.println("A excedido el limite de pacientes registrados");
        }

    }

    private static void Opcion2(ArrayList<UsuarioDTO> listaPaciente) {

        IndicadorDTO objIndicador = new IndicadorDTO(0, 0, 0, listaPaciente.get(listaPaciente.size() - 1).getId());
        System.out.println("desde la opcion 2");
        System.out.println(listaPaciente.size());
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                for (int i = 0; i < listaPaciente.size(); i++) {

                    Random fcr = new Random();
                    objIndicador.setFrecuenciaCardiaca((int) (50 + fcr.nextFloat() * (90 - 50)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);

                    Random frr = new Random();
                    objIndicador.setFrecuenciaRespiratoria((int) (60 + frr.nextFloat() * (100 - 60)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);

                    Random ter = new Random();
                    objIndicador.setTemperatura((float) (35.2 + ter.nextFloat() * (38.2 - 35.2)));
                    //listaPaciente.get(i).setListaIndicadores(objIndicador);

                    //objPAciente.agregarIndicador(objIndicador);
                    System.out.println("ID del paciente: " + listaPaciente.get(i).getId());

                    //System.out.println("Tipo ID: " +  listaPaciente.get(i).getTipo_id());
                    //System.out.println("Nombres: " + listaPaciente.get(i).getNombres());
                    //System.out.println("Apellidos: " + listaPaciente.get(i).getApellidos());
                    //System.out.println("Dirección: " + listaPaciente.get(i).getDireccion());
                    //System.out.println("Frecuencia cardiaca: " + listaPaciente.get(i).getListaIndicadores().getFrecuenciaCardiaca() + " latidos por minuto");
                    System.out.println("Frecuencia cardiaca: " + objIndicador.getFrecuenciaCardiaca() + " latidos por minuto");
                    //System.out.println("Frecuencia respiratoria: " + listaPaciente.get(i).getListaIndicadores().getFrecuenciaRespiratoria() + " ventilaciones por minuto");
                    System.out.println("Frecuencia cardiaca: " + objIndicador.getFrecuenciaRespiratoria() + " latidos por minuto");
                    //System.out.println("Temperatura: " + listaPaciente.get(i).getListaIndicadores().getTemperatura() + " grados centigrados");
                    System.out.println("Frecuencia cardiaca: " + objIndicador.getTemperatura() + " latidos por minuto");

                    try {
                        objRemoto.enviarIndicadores(objIndicador);
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClienteHabitacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };

        timer.schedule(task, 0, 8000);

    }
}
