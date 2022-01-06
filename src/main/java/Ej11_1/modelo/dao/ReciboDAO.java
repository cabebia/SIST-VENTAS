/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dao;

import Ej11_1.modelo.conexion.Conexion;
import Ej11_1.modelo.dto.ReciboDTO;
import Ej11_1.modelo.interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ies
 */
public class ReciboDAO implements Obligacion<ReciboDTO> {
    private static final String SQL_AGREGAR = 
            "INSERT INTO recibos (id_documento, medio_de_pago, informacion_adicional) "
                        + "VALUES (?,?,?)";
    private static final String SQL_BORRAR = 
            "DELETE FROM recibos WHERE id_documento = ?";
    private static final String SQL_MODIFICAR = 
            "UPDATE recibos SET medio_de_pago = ?, informacion_adicional = ? "
                        + "WHERE id_documento = ?";
    private static final String SQL_LEER = 
            "SELECT * FROM recibos WHERE id_documento = ?";
    private static final Conexion CON = Conexion.getInstanciaUnica();
    
    public ReciboDAO() {
    }
    
    @Override
    public boolean agregar(ReciboDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AGREGAR);
            ps.setLong(1, cc.getId_documento());
            ps.setString(2, cc.getMedio_de_pago());
            ps.setString(3, cc.getInformacion_adicional());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean borrar(ReciboDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_BORRAR);
            ps.setLong(1, cc.getId_documento());
            if (ps.executeUpdate() > 0) {
                return true;
                            }
        } catch (SQLException ex) {
            Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean modificar(ReciboDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_MODIFICAR);
            ps.setString(1, cc.getMedio_de_pago());
            ps.setString(2, cc.getInformacion_adicional());
            ps.setLong(3, cc.getId_documento());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;    
    }

    @Override
    public ReciboDTO leer(ReciboDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        ReciboDTO reciboDTO = null;
        try {            ps = CON.getCnn().prepareStatement(SQL_LEER);
            ps.setLong(1, cc.getId_documento());
            res = ps.executeQuery();
            reciboDTO = new ReciboDTO();
            while (res.next()){
                reciboDTO.setId_documento(res.getLong(1));
                reciboDTO.setMedio_de_pago(res.getString(2));
                reciboDTO.setInformacion_adicional(res.getString(3));
            }
            return reciboDTO;
        } catch (SQLException ex) {
            Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return reciboDTO;
    }
}