/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DetalleDTO;
import Ej11_1.modelo.negocio.ModeloFactura;
import Ej11_1.modelo.utilidades.ModeloCalculadora;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.modelo.utilidades.ModeloRedondeoDecimal;
import Ej11_1.vista.VistaIngresarFactura;
import java.awt.event.FocusEvent;

/**
 *
 * @author Ies
 */
public class ControladorIngresarFactura {
    private VistaIngresarFactura ingresarFactura = null;
    private ModeloCalculadora calculadora = new ModeloCalculadora();
    private Integer cantDetalles = 0;
//Ejercicio 11.41.6
    private ModeloFactura modeloFactura = new ModeloFactura();
    
    public ControladorIngresarFactura(VistaIngresarFactura ingresarFactura) {
       	this.ingresarFactura = ingresarFactura;
        String fechaActual = ModeloFechaHora.obtenerFechaActual();
        this.ingresarFactura.setFecha(fechaActual);
        this.ingresarFactura.setFechaVencimiento(fechaActual);
    //Ejercicio 11.41.7
        modeloFactura.getDocumentoDTO().setId(null);
        String fechaHoraActual = ModeloFechaHora.obtenerFechaHoraActual();
        modeloFactura.getDocumentoDTO().setFecha(fechaHoraActual);
        modeloFactura.getFacturaDTO().setFecha_vencimiento(fechaHoraActual);
        accionesVistaIngresarFactura();
    }

    private void accionesVistaIngresarFactura() {
        ingresarFactura.btAgregar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btAgregarActionPerformed(evt);
        }
        });
        ingresarFactura.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        ingresarFactura.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        ingresarFactura.etDescuento.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent evt) {
            }
            @Override
            public void focusLost(FocusEvent evt) {
                etDescuentoFocusLost(evt);
            }
        });
        ingresarFactura.etIdCliente.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent evt) {
            }
            @Override
            public void focusLost(FocusEvent evt) {
                etIdClienteFocusLost(evt);
            }
        });
    }

    private void btAgregarActionPerformed
        (java.awt.event.ActionEvent evt) {
        String etArticulo = ingresarFactura.getArticulo();
//        ingresarFactura.setArticulo(etArticulo);
        Integer etCantidad = ingresarFactura.getCantidad();
        Double etPrecioUnitario = ModeloRedondeoDecimal.getDecimal(2,
                    ingresarFactura.getPrecioUnitario(),true);
        
        if (!etArticulo.equals("") && etCantidad != 0 && etPrecioUnitario != 0) {
            cantDetalles = cantDetalles + 1;
            Double total = calculadora.calcularUnDetalle(etCantidad,
                    etPrecioUnitario);
            ingresarFactura.agregarFilaTablaDetalle(cantDetalles,
                    etArticulo, etCantidad, etPrecioUnitario, total);
            Double etTotalMercaderia = calculadora.getTotalMercaderia();
            ingresarFactura.setTotalMercaderia(etTotalMercaderia);
            Double etIva = calculadora.calcularIva();
            ingresarFactura.setIva(etIva);
            Double etTotalFactura = ModeloRedondeoDecimal.getDecimal(2,
                    calculadora.calcularTotalFactura(),true);
            ingresarFactura.setTotalFactura(etTotalFactura);
            
            // Aqui agregar un detalle al modelo
        //Ejercicio 11.41.16
            DetalleDTO detalleDTO = new DetalleDTO();
        //Ejercicio 11.41.17
            detalleDTO.setId_documento(null);
            detalleDTO.setId_detalle(cantDetalles);
            detalleDTO.setArticulo(etArticulo);
            detalleDTO.setCantidad(etCantidad);
            detalleDTO.setPrecio_unitario(etPrecioUnitario);
            detalleDTO.setImporte(total);
        //Ejercicio 11.41.18
            modeloFactura.agregarDetalleDTO(detalleDTO);

        } 
     }


    private void etIdClienteFocusLost(FocusEvent evt) {
        if (ingresarFactura.etIdCliente.getText().equals("")) {
            System.out.println("Debe ingresar un número de Cliente");
        }
        else {
            // Aqui obtener los datos del cliente de la tabla, almacenarlo en
            // el modelo y mostrarlo en la vista
        //Ejercicio 11.41.10
            ClienteDAO clienteDAO = new ClienteDAO();
        //Ejercicio 11.41.11
            ClienteDTO clienteDTO = new ClienteDTO();
        //Ejercicio 11.41.12
            clienteDTO.setId(Long.parseLong(ingresarFactura.etIdCliente.getText()));
        //Ejercicio 11.41.13            
            modeloFactura.setClienteDTO(clienteDAO.leer(clienteDTO));
        //Ejercicio 11.41.14
            if (modeloFactura.getClienteDTO().getApyn() == null) {
                ingresarFactura.setDniCliente(null);
            }
            else {
                ingresarFactura.setDniCliente(modeloFactura.
                    getClienteDTO().getDni().toString());
            }
            ingresarFactura.setNomCliente(modeloFactura.
                    getClienteDTO().getApyn());
        //Ejercicio 11.41.15            
            modeloFactura.getDocumentoDTO().setId_cliente(clienteDTO.getId());

        }

    }

    private void etDescuentoFocusLost
        (java.awt.event.FocusEvent evt) {
        Double etDescuento = ingresarFactura.getDescuento();
        calculadora.setDescuento(etDescuento);
        Double etTotalFactura = calculadora.calcularTotalFactura();
        ingresarFactura.setDescuento(calculadora.getDescuento());
        ingresarFactura.setTotalFactura(etTotalFactura);
    }

    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        ingresarFactura.dispose();
    }

    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        if (datosValidos()) {
            System.out.println("Todo preparado para confeccionar la factura..");
            armarFactura();
        }
    }

    private boolean datosValidos() {
        boolean validos = true;
        if (ingresarFactura.getNomCliente().equals("")) {
            validos = false;
        }
        if (ingresarFactura.getNumeroFactura().equals("")) {
            validos = false;
        }
        if (ingresarFactura.getCantidadFilasTablaDetalle() == 0) {
            validos = false;
        }
        return validos;
    }

    private void armarFactura() {

        // Aqui completar todos los datos del modelo excepto el "id" del
        // documento
    //Ejercicio 11.41.20
        modeloFactura.getDocumentoDTO().setTipo("FACT");
        Integer localNumeroFactura = Integer.parseInt(ingresarFactura.getNumeroFactura());
        modeloFactura.getDocumentoDTO().setNumero(localNumeroFactura);
        modeloFactura.getDocumentoDTO().setImporte(calculadora.calcularTotalFactura());
        modeloFactura.getFacturaDTO().setImporte_mercaderia(calculadora.getTotalMercaderia());
        modeloFactura.getFacturaDTO().setDescuento(calculadora.getDescuento());
        modeloFactura.getFacturaDTO().setIva(calculadora.calcularIva());

        grabarBD();
    }

    private void grabarBD() {

        // Aqui solicitar al modelo que grabe una factura completa en la base
        // (tablas documentos, facturas y detalles)
    //Ejercicio 11.41.22
        if (modeloFactura.datosCorrectos()) {
            if (modeloFactura.guardarUnaFacturaEnLaBase()) {
    //Ejercicio 11.41.23
                System.out.println("La factura " 
                    + modeloFactura.getDocumentoDTO().getId() 
                    + " fue grabada correctamente");
            } else {
                System.out.println("Se produjo un error, la factura no fue grabada");
            };
        } else {
            System.out.println("Faltan datos, no se puede grabar la factura");
        }
    }
}