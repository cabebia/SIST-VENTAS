/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dao;

import Ej11_1.modelo.conexion.Conexion;
import Ej11_1.modelo.dto.ClienteDTO;
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
public class ClienteDAO implements Obligacion<ClienteDTO>{

    private static final String SQL_AGREGAR = 
      "INSERT INTO clientes (dni, apyn) VALUES (?,?)";
    private static final String SQL_BORRAR = 
            "DELETE FROM clientes WHERE id = ?";
    private static final String SQL_MODIFICAR = 
       "UPDATE clientes SET dni = ?, apyn = ? WHERE id = ?";
    private static final String SQL_LEER = 
            "SELECT * FROM clientes WHERE id = ?";  
    private static final Conexion CON =
			 Conexion.getInstanciaUnica();

    public ClienteDAO() {
    }
    
    @Override
    public boolean agregar(ClienteDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AGREGAR);
            ps.setInt(1, cc.getDni());
            ps.setString(2, cc.getApyn());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean borrar(ClienteDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_BORRAR);
            ps.setLong(1, cc.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;    }

    @Override
    public boolean modificar(ClienteDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_MODIFICAR);
            ps.setInt(1, cc.getDni());
            ps.setString(2, cc.getApyn());
            ps.setLong(3, cc.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;  
    }

    @Override
    public ClienteDTO leer(ClienteDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        ClienteDTO clienteDTO = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER);
            ps.setLong(1, cc.getId());
            res = ps.executeQuery();
            clienteDTO = new ClienteDTO();
            while (res.next()){
                clienteDTO.setId(res.getLong(1));
                clienteDTO.setDni(res.getInt(2));
                clienteDTO.setApyn(res.getString(3));
            }
            return clienteDTO;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return clienteDTO;
    }
    
}
