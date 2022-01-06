/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.utilidades;

import java.util.Calendar;

/**
 * Clase destinada a obtener fecha y hora del sistema
 * y convertir a diferentes formatos las mismas.
 * 
 * Todos sus metodos son estaticos, por lo tanto no
 * se necesita crear instancias.
 *
 * @author Ies
 * @version 1.0.0
 */
public class ModeloFechaHora {
    /**
     * Constructor definido solamente para documentacion
     */
    private ModeloFechaHora(){        
    }
    /**
     * Metodo para obtener la fecha actual del sistema.
     * 
     * Ejercicio: Proyecto Original
     * 
     * @return La fecha actual en formato DD/MM/AAAA
     */
    public static String obtenerFechaActual() {
        Calendar fecha = Calendar.getInstance();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        mes = mes + 1;
        String mesString;
        if (mes < 10){
            mesString = "0" + mes;
        }
        else {
            mesString = "" + mes;
        }
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String diaString;
        if (dia < 10){
            diaString = "0" + dia;
        }
        else {
            diaString = "" + dia;
        }
        return diaString + "/" + mesString + "/" + anio;
    }

    /**
     * Metodo para obtener la hora actual del sistema.
     * 
     * Ejercicio: Proyecto Original
     * 
     * @return La hora actual en formato HH.mm.SS
     */
    public static String obtenerHoraActual() {
        Calendar fecha = Calendar.getInstance();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        String horaString;
        if (hora < 10){
            horaString = "0" + hora;
        }
        else {
            horaString = "" + hora;
        }
        int minutos = fecha.get(Calendar.MINUTE);
        String minutosString;
        if (minutos < 10){
            minutosString = "0" + minutos;
        }
        else {
            minutosString = "" + minutos;
        }
        int segundos = fecha.get(Calendar.SECOND);
        String segundosString;
        if (segundos < 10){
            segundosString = "0" + segundos;
        }
        else {
            segundosString = "" + segundos;
        }
        return horaString + "." + minutosString + "." + segundosString;
    }
    
    /**
     * Metodo para convertir formato de fecha.
     * 
     * Ejercicio: Proyecto Original
     * 
     * @param fecha La fecha en formato AAAA/MM/DD
     * @return La fecha en formato DD/MM/AAAA
     */
    public static String convertirFormatoFecha(String fecha) {
        return fecha.substring(8,10) + "/" + fecha.substring(5,7)
                + "/" + fecha.substring(0,4);
    }
    
    /**
     * Metodo para obtener la fecha y hora actual
     * del sistema.
     * 
     * Ejercicio: 11.41
     * 
     * @return La fecha en formato AAAA-MM-DD HH:mm:SS 
     */
    public static String obtenerFechaHoraActual() {
        String fechaActual = obtenerFechaActual();
        String horaActual = obtenerHoraActual();      
        String fechaHoraActual = convertirFormatoFechaHora(fechaActual, horaActual);
        return fechaHoraActual;
    }
    /**
     * Metodo privado para agregar caracteres separadores
     * entre los diferentes datos que forman la fecha y
     * la hora. 
     * 
     * Ejercicio: 11.41
     * 
     * @param fechaActual La fecha con formato DD/MM/AAAA
     * @param horaActual La hora con formato HH.mm.SS
     * @return La fecha en formato AAAA-MM-DD HH:mm:SS
     */
    private static String convertirFormatoFechaHora(String fechaActual, String horaActual) {
        return fechaActual.substring(6,10) + '-' + fechaActual.substring(3,5) + '-' 
                + fechaActual.substring(0,2) + ' ' + horaActual.substring(0,2) + ':'
                + horaActual.substring(3,5) + ':' + horaActual.substring(6,8);
    }    
    
}