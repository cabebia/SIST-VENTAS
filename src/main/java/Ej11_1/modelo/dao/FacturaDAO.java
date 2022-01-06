/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ej11_1.modelo.conexion.Conexion;
import Ej11_1.modelo.dto.FacturaDTO;
import Ej11_1.modelo.interfaces.Obligacion;

/**
 *
 * @author Ies
 */
public class FacturaDAO implements Obligacion<FacturaDTO> {
    private static final String SQL_AGREGAR = 
            "INSERT INTO facturas (id_documento, fecha_vencimiento, "
                    + "importe_mercaderia, iva, descuento) VALUES (?,?,?,?,?)";
    private static final String SQL_BORRAR = 
            "DELETE FROM facturas WHERE id_documento = ?";
    private static final String SQL_MODIFICAR = 
            "UPDATE facturas SET fecha_vencimiento = ?, "
                    + "importe_mercaderia = ?, iva = ?, descuento= ? "
                    + "WHERE id_documento = ?";
    private static final String SQL_LEER = 
            "SELECT * FROM facturas WHERE id_documento = ?";
    private static final Conexion CON = Conexion.getInstanciaUnica();
    
    public FacturaDAO() {
    }
    
    @Override
    public boolean agregar(FacturaDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AGREGAR);
            ps.setLong(1, cc.getId_documento());
            ps.setString(2, cc.getFecha_vencimiento());
            ps.setDouble(3, cc.getImporte_mercaderia());
            ps.setDouble(4, cc.getIva());
            ps.setDouble(5, cc.getDescuento());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean borrar(FacturaDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_BORRAR);
                        ps.setLong(1, cc.getId_documento());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean modificar(FacturaDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_MODIFICAR);
            ps.setString(1, cc.getFecha_vencimiento());
            ps.setDouble(2, cc.getImporte_mercaderia());
            ps.setDouble(3, cc.getIva());
            ps.setDouble(4, cc.getDescuento());
            ps.setLong(5, cc.getId_documento());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;    
    }

    @Override
    public FacturaDTO leer(FacturaDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        FacturaDTO facturaDTO = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER);
            ps.setLong(1, cc.getId_documento());
            res = ps.executeQuery();
            facturaDTO = new FacturaDTO();
            while (res.next()){
                facturaDTO.setId_documento(res.getLong(1));
                facturaDTO.setFecha_vencimiento(res.getString(2));
                facturaDTO.setImporte_mercaderia(res.getDouble(3));
                facturaDTO.setIva(res.getDouble(4));
                facturaDTO.setDescuento(res.getDouble(5));
            }
            return facturaDTO;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return facturaDTO;
    }
}