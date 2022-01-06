/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.consultas_especiales.Acumuladora;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.vista.VistaTotalesPorCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ies
 */
public class ControladorTotalesPorCliente {
    private VistaTotalesPorCliente totalesPorCliente = null;
    private ResultSet res;
    
    public ControladorTotalesPorCliente(VistaTotalesPorCliente totalesPorCliente) {
       	this.totalesPorCliente = totalesPorCliente;
        accionesVistaTotalesPorCliente();
    }

    private void accionesVistaTotalesPorCliente() {
        totalesPorCliente.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        totalesPorCliente.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
    }

    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        totalesPorCliente.dispose();
    }

    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        
        // Aqui buscar la fecha y hora actual y mostrarla en la vista
        totalesPorCliente.setFecha(ModeloFechaHora.obtenerFechaActual());
        totalesPorCliente.setHora(ModeloFechaHora.obtenerHoraActual());

        if (obtenerTotalesPorCliente()) {
            mostrarTotalesPorCliente();
        }
        else {
            System.out.println("No existen movimientos");
        }
    }

    private boolean obtenerTotalesPorCliente() {

        // Aqui invocar a un método que retorne un ResultSet con 
        // los totales por cliente
        res = Acumuladora.totalesPorCliente();
        try {
            return res.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTotalesPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;

    }

    private void mostrarTotalesPorCliente() {

        // Aqui recorrer el ResultSet y mostrarlo en la vista (tabla)
        try {
            res.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTotalesPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (res.next()){
                totalesPorCliente.agregarFilaTablaTotales( 
                     res.getInt(1),
                     res.getString(2),
                     res.getDouble(3),
                     res.getDouble(4),
                     res.getDouble(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTotalesPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
