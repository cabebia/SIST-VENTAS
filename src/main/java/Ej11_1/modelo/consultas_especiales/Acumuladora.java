/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.consultas_especiales;

import Ej11_1.modelo.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ies
 */
public class Acumuladora {
    private static final String SQL_TOTALES_POR_CLIENTE =
        "select id_cliente, apyn,"
            + " sum(iif(tipo='FACT',importe,0)) as total_facturas,"
            + " sum(iif(tipo='RECI',importe,0)) as total_recibos,"
            + " sum(iif(tipo='FACT',importe,0)) - sum(iif(tipo='RECI',importe,0)) as saldo"
            + " from Documentos as d, Clientes as c"
            + " where d.id_cliente = c.id"
            + " group by id_cliente, apyn"
            + " order by id_cliente";
    
    private static final String SQL_VENTAS_POR_ARTICULO =
        "select articulo, sum(cantidad) as cantidad_total,"
            + " sum(importe) as importe_total"
            + " from Detalles"
            + " group by articulo"
            + " order by articulo";
    
    private static final Conexion CON = Conexion.getInstanciaUnica();

    public static ResultSet totalesPorCliente() {
        
        PreparedStatement ps;
        ResultSet res = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_TOTALES_POR_CLIENTE, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = ps.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Acumuladora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return res;
    } 

    public static ResultSet ventasPorArticulo() {
        
        PreparedStatement ps;
        ResultSet res = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_VENTAS_POR_ARTICULO, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            res = ps.executeQuery();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Acumuladora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return res;
    }    
   
}