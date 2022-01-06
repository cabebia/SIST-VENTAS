/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DocumentoDTO;
import Ej11_1.modelo.negocio.ModeloMovimientosPorCliente;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import Ej11_1.vista.VistaConsultarMovimientosPorCliente;

/**
 *
 * @author Ies
 */
public class ControladorConsultarMovimientosPorCliente {
    private VistaConsultarMovimientosPorCliente consultarMovimientosPorCliente = null;
    private  ModeloMovimientosPorCliente modeloMovimientosPorCliente =
                new ModeloMovimientosPorCliente();
    public ControladorConsultarMovimientosPorCliente(VistaConsultarMovimientosPorCliente consultarMovimientosPorCliente) {
       	this.consultarMovimientosPorCliente = consultarMovimientosPorCliente;
        accionesVistaConsultarMovimientosPorCliente();
    }

    private void accionesVistaConsultarMovimientosPorCliente() {
        consultarMovimientosPorCliente.btRetornar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        consultarMovimientosPorCliente.btConfirmar.addActionListener (new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
    }

    private void btRetornarActionPerformed
        (java.awt.event.ActionEvent evt) {
        consultarMovimientosPorCliente.dispose();
    }

    private void btConfirmarActionPerformed
        (java.awt.event.ActionEvent evt) {
        if (datosValidos()) {
            if (obtenerDatosDelCliente()) {
                if (armarMovimientosPorCliente()) {
                    mostrarMovimientosPorCliente();
                }
                else {
                    System.out.println("No existen movimientos para ese cliente");
                }
            }    
            else {
                System.out.println("Cliente no existente");
            }
        }
        else {
            System.out.println("Debe ingresar un número de cliente");
        }    
    }

    private boolean datosValidos() {
        boolean validos = true;
        if (consultarMovimientosPorCliente.getIdCliente().equals("")) {
            validos = false;
        }
        return validos;
    }

    private boolean obtenerDatosDelCliente() {
        // Aqui obtener los datos de un cliente de la base y almacenarlo en 
        // el modelo
        ClienteDTO clienteDTO = new ClienteDTO();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDTO.setId(Long.parseLong(consultarMovimientosPorCliente.
                getIdCliente()));
        clienteDTO = clienteDAO.leer(clienteDTO);
        modeloMovimientosPorCliente.setClienteDTO(clienteDTO);
        return clienteDTO.getId() != null;
        
        
    }

    private boolean armarMovimientosPorCliente() {
        Integer localNumeroCliente = 
                Integer.parseInt(consultarMovimientosPorCliente.getIdCliente());
        
        // Aqui obtener los movimientos de un cliente de la base y almacenarlos en 
        // el modelo
        return modeloMovimientosPorCliente.obtenerLosMovimientosDeUnCliente();

        
    }

    private void mostrarMovimientosPorCliente() {
        System.out.println("Todo preparado para visualizar los movimientos..");

        // Aqui mostrar los datos del modelo en la vista
        consultarMovimientosPorCliente.setDniCliente(
                modeloMovimientosPorCliente.getClienteDTO().getDni().toString());
        consultarMovimientosPorCliente.setNomCliente(
                modeloMovimientosPorCliente.getClienteDTO().getApyn());

        consultarMovimientosPorCliente.limpiarTablaDocumentos();
        for (DocumentoDTO documento : modeloMovimientosPorCliente.getDocumentos()) {
            consultarMovimientosPorCliente.agregarFilaTablaDocumentos(
                    documento.getId(), documento.getTipo(),
                    documento.getNumero(), 
                    ModeloFechaHora.convertirFormatoFecha(documento.getFecha()),
                    documento.getImporte());
        }        
    }

}