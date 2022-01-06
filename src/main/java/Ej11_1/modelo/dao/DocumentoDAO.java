/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dao;

import Ej11_1.modelo.conexion.Conexion;
import Ej11_1.modelo.dto.DocumentoDTO;
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
public class DocumentoDAO implements Obligacion<DocumentoDTO>{
    private static final String SQL_AGREGAR = 
            "INSERT INTO documentos (tipo, numero, id_cliente, fecha, importe) "
                    + "VALUES (?,?,?,?,?)";
    private static final String SQL_BORRAR =
            "DELETE FROM documentos WHERE id = ?";
    private static final String SQL_MODIFICAR =
            "UPDATE documentos SET tipo = ?, numero = ?, id_cliente = ?, "
                    + "fecha = ?, importe = ? WHERE id = ?";
    private static final String SQL_LEER =
            "SELECT * FROM documentos WHERE id = ?";  
//Ejercicio 11.35
    private static final String SQL_LEER_POR_CLIENTE = 
            "SELECT * FROM documentos WHERE id_cliente = ?";       
    private static final Conexion CON = Conexion.getInstanciaUnica();
//Ejercicio 11.27
    private static final String SQL_OBTENER_ID_GENERADO = 
                    "SELECT @@IDENTITY";
    private Long ultimoIdGenerado;
    
    public DocumentoDAO() {
    }
    
    
    @Override
    public boolean agregar(DocumentoDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_AGREGAR);
            ps.setString(1, cc.getTipo());
            ps.setInt(2, cc.getNumero());
            ps.setInt(3, Integer.parseInt(cc.getId_cliente().toString()));
            ps.setString(4, cc.getFecha());
            ps.setDouble(5, cc.getImporte());
            if (ps.executeUpdate() > 0) {
        //Ejercicio 11.27
                PreparedStatement ps2 = CON.getCnn().
                        prepareStatement(SQL_OBTENER_ID_GENERADO);
                ResultSet rs = ps2.executeQuery();
                if (rs != null && rs.next()) {
                    ultimoIdGenerado = rs.getLong(1);
                } else {
                    ultimoIdGenerado = null;
                } 
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean borrar(DocumentoDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_BORRAR);
            ps.setLong(1, cc.getId());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;
    }

    @Override
    public boolean modificar(DocumentoDTO cc) {
        PreparedStatement ps;
        try {
            ps = CON.getCnn().prepareStatement(SQL_MODIFICAR);
            ps.setString(1, cc.getTipo());
            ps.setInt(2, cc.getNumero());
            ps.setInt(3, Integer.parseInt(cc.getId_cliente().toString()));
            ps.setString(4, cc.getFecha());
            ps.setDouble(5, cc.getImporte());
            ps.setLong(6, cc.getId()); 
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        } 
        return false;    
    }

    @Override
    public DocumentoDTO leer(DocumentoDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        DocumentoDTO documentoDTO = null;
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER);
            ps.setLong(1, cc.getId());
            res = ps.executeQuery();
            documentoDTO = new DocumentoDTO();
            while (res.next()){
                documentoDTO.setId(res.getLong(1));
                documentoDTO.setTipo(res.getString(2));
                documentoDTO.setNumero(res.getInt(3));
                documentoDTO.setId_cliente(res.getLong(4));
                documentoDTO.setFecha(res.getString(5));
                documentoDTO.setImporte(res.getDouble(6));
            }
            return documentoDTO;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return documentoDTO;
    }
//Ejercicio 11.27    
     public Long getUltimoIdGenerado() {
        return ultimoIdGenerado;
    }
//Ejercicio 11.35     
    public ArrayList<DocumentoDTO> leerPorIdCliente(DocumentoDTO cc) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<DocumentoDTO> documentos = new ArrayList();
        try {
            ps = CON.getCnn().prepareStatement(SQL_LEER_POR_CLIENTE);
            ps.setLong(1, cc.getId_cliente());
            res = ps.executeQuery();
            while (res.next()){
                DocumentoDTO documentoDTO = new DocumentoDTO();
                documentoDTO.setId(res.getLong(1));
                documentoDTO.setTipo(res.getString(2));
                documentoDTO.setNumero(res.getInt(3));
                documentoDTO.setId_cliente(res.getLong(4));
                documentoDTO.setFecha(res.getString(5));
                documentoDTO.setImporte(res.getDouble(6));
                documentos.add(documentoDTO);
            }
            return documentos;
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CON.cerrarConexion();
        }
        return documentos;
    }     
}
