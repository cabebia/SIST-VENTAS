/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.negocio.ModeloRecibo;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.modelo.utilidades.ModeloRedondeoDecimal;
import Ej11_1.vista.VistaIngresarRecibo;
import java.awt.event.FocusEvent;

/**
 *
 * @author Ies
 */
public class ControladorIngresarRecibo {
    private VistaIngresarRecibo ingresarRecibo = null;
//Ejercicio 11.42.1    
    private ModeloRecibo modeloRecibo = new ModeloRecibo();
    
    public ControladorIngresarRecibo(VistaIngresarRecibo ingresarRecibo) {
       	this.ingresarRecibo = ingresarRecibo;
        String fechaActual = ModeloFechaHora.obtenerFechaActual();
        this.ingresarRecibo.setFecha(fechaActual);
    //Ejercicio 11.42.2  
        modeloRecibo.getDocumentoDTO().setId(null);
        String fechaHoraActual = ModeloFechaHora.obtenerFechaHoraActual();
        modeloRecibo.getDocumentoDTO().setFecha(fechaHoraActual);

        accionesVistaIngresarRecibo();
    }

    private void accionesVistaIngresarRecibo() {
        ingresarRecibo.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        ingresarRecibo.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        ingresarRecibo.etIdCliente.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent evt) {
            }
            @Override
            public void focusLost(FocusEvent evt) {
                etIdClienteFocusLost(evt);
            }
        });
    }


    private void etIdClienteFocusLost(FocusEvent evt) {
        if (ingresarRecibo.etIdCliente.getText().equals("")) {
            System.out.println("Debe ingresar un número de Cliente");
        }
        else {
            ingresarRecibo.setDniCliente("10000000");
            ingresarRecibo.setNomCliente("Juan Perez");

        // Aqui obtener los datos del cliente de la tabla, almacenarlo en
        // el modelo y mostrarlo en la vista
    //Ejercicio 11.42.5
            ClienteDAO clienteDAO = new ClienteDAO();
    //Ejercicio 11.42.6            
            ClienteDTO clienteDTO = new ClienteDTO();
    //Ejercicio 11.42.7            
            clienteDTO.setId(Long.parseLong(ingresarRecibo.etIdCliente.getText()));
    //Ejercicio 11.42.8            
            modeloRecibo.setClienteDTO(clienteDAO.leer(clienteDTO));
    //Ejercicio 11.42.9
            if (modeloRecibo.getClienteDTO().getApyn() == null) {
                ingresarRecibo.setDniCliente(null);
            }
            else {
                ingresarRecibo.setDniCliente(modeloRecibo.
                    getClienteDTO().getDni().toString());
            }
            ingresarRecibo.setNomCliente(modeloRecibo.
                    getClienteDTO().getApyn());
    //Ejercicio 11.42.10            
            modeloRecibo.getDocumentoDTO().setId_cliente(clienteDTO.getId());
        }    
    }

    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        ingresarRecibo.dispose();
    }

    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        if (datosValidos()) {
            System.out.println("Todo preparado para confeccionar el recibo..");
            armarRecibo();
        }
    }

    private boolean datosValidos() {
        boolean validos = true;
        ingresarRecibo.setImporte(ModeloRedondeoDecimal.getDecimal(2,
                ingresarRecibo.getImporte(), true));
        if (ingresarRecibo.getCliente().equals("")) {
            validos = false;
        }
        if (ingresarRecibo.getNumeroRecibo().equals("")) {
            validos = false;
        }
        if (ingresarRecibo.getImporte() == 0) {
            validos = false;
        }
        if (ingresarRecibo.getMedioDePago().equals("")) {
            validos = false;
        }
        return validos;
    }

    private void armarRecibo() {

        // Aqui completar todos los datos del modelo excepto el "id" del
        // documento
    //Ejercicio 11.42.12        
        modeloRecibo.getDocumentoDTO().setTipo("RECI");
        Integer localNumeroRecibo = Integer.parseInt(ingresarRecibo.
                getNumeroRecibo());
        modeloRecibo.getDocumentoDTO().setNumero(localNumeroRecibo);
        modeloRecibo.getDocumentoDTO().setImporte(ingresarRecibo.
                getImporte());
        modeloRecibo.getReciboDTO().setMedio_de_pago(ingresarRecibo.
                getMedioDePago());
        modeloRecibo.getReciboDTO().setInformacion_adicional(ingresarRecibo.
                getInformacionAdicional());
        
        grabarBD();
    }

    private void grabarBD() {

        // Aqui solicitar al modelo que grabe un recibo completo en la base
        // (tablas documentos y recibos)
    //Ejercicio 11.42.14        
        if (modeloRecibo.datosCorrectos()) {
            if (modeloRecibo.guardarUnReciboEnLaBase()) {
    //Ejercicio 11.42.15                
                System.out.println("El recibo " 
                    + modeloRecibo.getDocumentoDTO().getId() 
                    + " fue grabado correctamente");
            } else {
                System.out.println("Se produjo un error, el recibo no fue grabado");
            };
        } else {
            System.out.println("Faltan datos, no se puede grabar el recibo");
        }
    }
}