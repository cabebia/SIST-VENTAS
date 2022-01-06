/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.consultas_especiales.Acumuladora;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.vista.VistaVentasPorArticulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ies
 */
public class ControladorVentasPorArticulo {
    private VistaVentasPorArticulo ventasPorArticulo = null;
    private ResultSet res;
    
    public ControladorVentasPorArticulo(VistaVentasPorArticulo ventasPorArticulo) {
       	this.ventasPorArticulo = ventasPorArticulo;
        accionesVistaVentasPorArticulo();
    }

    private void accionesVistaVentasPorArticulo() {
        ventasPorArticulo.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        ventasPorArticulo.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
    }

    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        ventasPorArticulo.dispose();
    }

    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        
        // Aqui buscar la fecha y hora actual y mostrarla en la vista
        ventasPorArticulo.setFecha(ModeloFechaHora.obtenerFechaActual());
        ventasPorArticulo.setHora(ModeloFechaHora.obtenerHoraActual());

        if (obtenerVentasPorArticulo()) {
            mostrarVentasPorArticulo();
        }
        else {
            System.out.println("No existen movimientos");
        }
    }

    private boolean obtenerVentasPorArticulo() {

        // Aqui invocar a un método que retorne un ResultSer con 
        // los totales por artículo
        res = Acumuladora.ventasPorArticulo();
        try {
            return res.next();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVentasPorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return false;  
    }

    private void mostrarVentasPorArticulo() {

        // Aqui recorrer el ResultSet y mostrarlo en la vista (tabla)
        try {
            res.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVentasPorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()){
                ventasPorArticulo.agregarFilaTablaVentas(
                        res.getString(1),
                        res.getInt(2),
                        res.getDouble(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVentasPorArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}