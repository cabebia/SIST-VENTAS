/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dao;

import Ej11_1.modelo.conexion.Conexion;
import Ej11_1.modelo.dto.DetalleDTO;
import Ej11_1.modelo.interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ies
 */
public class DetalleDAO implements Obligacion<DetalleDTO> {
    private static final String SQL_AGREGAR = 
            "INSERT INTO detalles (id_documento, id_detalle, articulo, "
                    + "cantidad, precio_unitario, importe) VALUES (?,?,?,?,?,?)";
    private static final String SQL_BORRAR = 
            "DELETE FROM detalles WHERE id_documento = ? and id_detalle = ?";
    private static final String SQL_MODIFICAR = 
            "UPDATE detalles SET articulo = ?, cantidad = ?, "
                    + "precio_unitario = ?, importe = ? WHERE id_documento = ? "
                    + "and id_detalle = ?";
    private static final String SQL_LEER = 
            "SELECT * FROM detalles WHERE id_documento = ? and id_detalle = ?";
    private static final String SQL_LEER_POR_DOCUMENTO = 
            "SELECT * FROM detalles WHERE id_documento = ?";
    private static final Conexion CON = Conexion.getInstanciaUnica();
    
    public DetalleDAO() {
    }
    
    @Override
    public boolean agregar(DetalleDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AGREGAR);
            ps.setLong(1, cc.getId_documento());
            ps.setLong(2, cc.getId_detalle());
            ps.setString(3, cc.getArticulo());
            ps.setInt(4, cc.getCantidad());
            ps.setDouble(5, cc.getPrecio_unitario());
            ps.setDouble(6, cc.getImporte());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean borrar(DetalleDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_BORRAR);
            ps.setLong(1, cc.getId_documento());
            ps.setLong(2, cc.getId_detalle());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean modificar(DetalleDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_MODIFICAR);
            ps.setString(1, cc.getArticulo());
            ps.setInt(2, cc.getCantidad());
            ps.setDouble(3, cc.getPrecio_unitario());
            ps.setDouble(4, cc.getImporte());
            ps.setLong(5, cc.getId_documento());
            ps.setLong(6, cc.getId_detalle());            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;    
    }

    @Override
    public DetalleDTO leer(DetalleDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        DetalleDTO detalleDTO = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER);
            ps.setLong(1, cc.getId_documento());
            ps.setLong(2, cc.getId_detalle());            
            res = ps.executeQuery();
            detalleDTO = new DetalleDTO();
            while (res.next()){
                detalleDTO.setId_documento(res.getLong(1));
                detalleDTO.setId_detalle(res.getInt(2));
                detalleDTO.setArticulo(res.getString(3));
                               detalleDTO.setCantidad(res.getInt(4));
                detalleDTO.setPrecio_unitario(res.getDouble(5));
                detalleDTO.setImporte(res.getDouble(6));
            }
            return detalleDTO;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return detalleDTO;
    }
    public ArrayList<DetalleDTO> leerPorIdDocumento(DetalleDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<DetalleDTO> detalles = new ArrayList();
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER_POR_DOCUMENTO);
            ps.setLong(1, cc.getId_documento());
            res = ps.executeQuery();
            while (res.next()){
                DetalleDTO detalle = new DetalleDTO();
                detalle.setId_documento(res.getLong(1));
                detalle.setId_detalle(res.getInt(2));
                detalle.setArticulo(res.getString(3));
                detalle.setCantidad(res.getInt(4));
                detalle.setPrecio_unitario(res.getDouble(5));
                detalle.setImporte(res.getDouble(6));
                detalles.add(detalle);
            }
            return detalles;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
            CON.cerrarConexion();
        }
        return detalles;
    }    
}