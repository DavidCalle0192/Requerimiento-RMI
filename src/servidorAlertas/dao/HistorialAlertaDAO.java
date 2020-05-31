/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorAlertas.dao;

import java.util.ArrayList;
import servidorAlertas.dto.HistorialDTO;

/**
 *
 * @author JhonMZ
 */
public class HistorialAlertaDAO {
    
    /**
     * @brief Se encarga de crear un archivo de historial de alertas para el paciente.
     * Se crea un archivo con extension txt y de nombre historialDeAlertas<idPaciente>
     * @param idPaciente 
     * @return retorna true si el archivo se crea o false si el 
     * archivo ya existe o ocurre un error
     */
    public static boolean crearHistorial(int idPaciente){
        boolean res = false;
        if(!existeHistorial(idPaciente))
            res = ArchivoDAO.crearArchivo("historialDeAlertas"+idPaciente+".txt");
        return res;
    }
    
    /**
     * @brief Comprueba si ya existe un historial de akertas para el paciente
     * @param idPaciente 
     * @return retorna true si el paciente ya tiene un historial o false no no lo tiene
     */
    public static boolean existeHistorial(int idPaciente){
        return ArchivoDAO.existeArchivo("historialDeAlertas"+idPaciente+".txt");
    }
    
    public static ArrayList<HistorialDTO> obtenerRegistros(){
        ArrayList<HistorialDTO> historial = new ArrayList<HistorialDTO>();
        return historial;
    }
    
    public static boolean agregarHistorial(HistorialDTO objHistorial, int idPaciente){
        if(!existeHistorial(idPaciente))crearHistorial(idPaciente);
        //Fecha;Hota;Puntuacion
        String linea = objHistorial.getFecha().toString()+";"+objHistorial.getHora().toString()+";"+objHistorial.getPuntuacion();
        return ArchivoDAO.agregarLinea("historialDeAlertas"+idPaciente+".txt", linea);
    }
}
