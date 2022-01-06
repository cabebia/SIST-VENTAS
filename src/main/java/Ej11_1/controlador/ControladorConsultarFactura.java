/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.dto.DetalleDTO;
import Ej11_1.modelo.negocio.ModeloFactura;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.vista.VistaConsultarFactura;

/**
 * Clase que permite visualizar los datos de una factura.
 * Representa el "controlador" e interactua con la clase
 * "VistaConsultarFactura", entre ambas forman
 * la "Interfaz de Usuario" para "Consultar Factura"
 * 
 * @author Ies
 */
public class ControladorConsultarFactura {
    private VistaConsultarFactura consultarFactura = null;
//Ejercicio 11.33.1
    private ModeloFactura modeloFactura = 
            new ModeloFactura(); 
    
    public ControladorConsultarFactura(VistaConsultarFactura consultarFactura) {
       	this.consultarFactura = consultarFactura;
        accionesVistaConsultarFactura();
    }
    /**
     * Metodo que registra a los objetos de la vista
     * como oyente de eventos
     */
    private void accionesVistaConsultarFactura() {
        //Registra al boton "Retornar" como oyente de
        //ActionListener
        consultarFactura.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        //Registra al boton "Confirmar" como oyente de
        //ActionListener
        consultarFactura.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
    }
    /**
     * Metodo que se ejecuta cuando se activa el boton
     * "Retornar" y su funcion es cerrar la ventana
     * @param evt El evento
     */
    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        consultarFactura.dispose();
    }
    /**
     * Metodo que se ejecuta cuando se activa el boton
     * "Confirmar" y su funcion coordinar todo lo necesario
     * entre la vista y el modelo para visualizar los
     * datos de una factura
     * 
     * @param evt El evento
     */
    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        if (datosValidos()) {
            if (armarFactura()){
                mostrarFactura();
            }
            else {
                System.out.println("Factura no encontrada");
            }
        }
        else {
            System.out.println("Debe ingresar un número de factura");
        }    
    }
    /**
     * Metodo destinado a realizar las validaciones de
     * los datos requeridos de la vista
     * 
     * @return boolean en verdadero si los datos son
     * validos, en caso contrario retorna falso
     */
    private boolean datosValidos() {
        boolean validos = true;
        //Solamente se valida que el metodo "getIdFactura"
        //retorne algun valor
        //Debe agregarse que el valor recibido pueda
        //ser convertido a un dato entero para tomarlo
        //como "Id" de la factura a consultar
        if (consultarFactura.getIdFactura().equals("")) {
            validos = false;
        }
        return validos;
    }
    /**
     * Metodo destinado a solicitar al modelo la
     * recuperacion de toda la informacion de una
     * factura desde la base de datos
     * 
     * @return boolean en verdadero si pudo recuperar
     * todos los datos de la base, en caso contrario
     * retorna falso
     */
    private boolean armarFactura() {
        Integer localNumeroFactura = 
                Integer.parseInt(consultarFactura.getIdFactura());

        // Aqui buscar los datos de la factura en la base de datos y almacenarlos
        // en el modelo
//Ejercicio 11.33.2
        return modeloFactura.obtenerUnaFacturaDeLaBase(localNumeroFactura);

    } 
    /**
     * Metodo destinado a enviar a la vista toda la
     * informacion de una factura
     */
    private void mostrarFactura() {
        System.out.println("Todo preparado para visualizar la factura..");

        // Aqui tomar los datos de la factura del modelo y mostrarlos en la vista
//Ejercicio 11.33.6
        consultarFactura.setNumeroFactura(modeloFactura.getDocumentoDTO().
                getNumero().toString());
//Ejercicio 11.33.7
        consultarFactura.setIdCliente(modeloFactura.getClienteDTO().
                getId().toString());
//Ejercicio 11.33.8
        consultarFactura.setDniCliente(modeloFactura.getClienteDTO().
                getDni().toString());
        consultarFactura.setNomCliente(modeloFactura.getClienteDTO().getApyn());
//Ejercicio 11.33.9
        consultarFactura.setFecha(ModeloFechaHora.convertirFormatoFecha(
                modeloFactura.getDocumentoDTO().getFecha()));
//Ejercicio 11.33.10
        consultarFactura.setFechaVencimiento(ModeloFechaHora.
                convertirFormatoFecha(modeloFactura.getFacturaDTO().
                        getFecha_vencimiento()));
//Ejercicio 11.33.11
        consultarFactura.setTotalFactura(modeloFactura.getDocumentoDTO().
                getImporte());
//Ejercicio 11.33.12
        consultarFactura.setTotalMercaderia(modeloFactura.getFacturaDTO().
                getImporte_mercaderia());
//Ejercicio 11.33.13
        consultarFactura.setIva(modeloFactura.getFacturaDTO().getIva());
        consultarFactura.setDescuento(modeloFactura.getFacturaDTO().
                getDescuento());
//Ejercicio 11.33.14
        for (DetalleDTO detalleDTO : modeloFactura.getDetallesDTO()) {
            consultarFactura.agregarFilaTablaDetalle(detalleDTO.getId_detalle(), 
                    detalleDTO.getArticulo(), detalleDTO.getCantidad(), 
                    detalleDTO.getPrecio_unitario(), detalleDTO.getImporte());
        }
    }

}

