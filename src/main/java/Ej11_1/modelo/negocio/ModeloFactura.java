/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.negocio;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dao.DetalleDAO;
import Ej11_1.modelo.dao.DocumentoDAO;
import Ej11_1.modelo.dao.FacturaDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DetalleDTO;
import Ej11_1.modelo.dto.DocumentoDTO;
import Ej11_1.modelo.dto.FacturaDTO;
import java.util.ArrayList;

/**
 *
 * @author Ies
 */
public class ModeloFactura {
    private ClienteDTO clienteDTO = new ClienteDTO();
    private DocumentoDTO documentoDTO = new DocumentoDTO();
    private FacturaDTO facturaDTO = new FacturaDTO();
    private ArrayList<DetalleDTO> detallesDTO = new ArrayList();

    public ModeloFactura() {
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public DocumentoDTO getDocumentoDTO() {
        return documentoDTO;
    }

    public FacturaDTO getFacturaDTO() {
        return facturaDTO;
    }

    public ArrayList<DetalleDTO> getDetallesDTO() {
        return detallesDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public void setDocumentoDTO(DocumentoDTO documentoDTO) {
        this.documentoDTO = documentoDTO;
    }

    public void setFacturaDTO(FacturaDTO facturaDTO) {
        this.facturaDTO = facturaDTO;
    }
    
    public void setDetallesDTO(ArrayList<DetalleDTO> detallesDTO) {
        this.detallesDTO = detallesDTO;
    }

    public void agregarDetalleDTO(DetalleDTO detalleDTO) {
        detallesDTO.add(detalleDTO);
    }  

    public boolean obtenerUnaFacturaDeLaBase(long numeroFactura) {
    //Ejercicio 11.26.1
        DocumentoDAO documentoDAO = new DocumentoDAO();
    //Ejercicio 11.26.2
        documentoDTO.setId(numeroFactura);
    //Ejercicio 11.26.3
        documentoDTO = documentoDAO.leer(documentoDTO);
    //Ejercicio 11.26.4
        if (documentoDTO.getId() != null && 
                documentoDTO.getTipo().equals("FACT")) {
    //Ejercicio 11.26.5
            ClienteDAO clienteDAO = new ClienteDAO();
    //Ejercicio 11.26.6
            clienteDTO.setId(documentoDTO.getId_cliente());
    //Ejercicio 11.26.7
            clienteDTO = clienteDAO.leer(clienteDTO);
    //Ejercicio 11.26.8
            if (clienteDTO.getId() == null) {
                System.out.println("No existe el cliente...");
            }
    //Ejercicio 11.26.9
            FacturaDAO facturaDAO = new FacturaDAO();
    //Ejercicio 11.26.10
            facturaDTO.setId_documento(documentoDTO.getId());
    //Ejercicio 11.26.11
            facturaDTO = facturaDAO.leer(facturaDTO);
    //Ejercicio 11.26.12
            if (facturaDTO.getId_documento() == null) {
                System.out.println("No existe la factura...");
            }
    //Ejercicio 11.26.13
            DetalleDAO detalleDAO = new DetalleDAO();
    //Ejercicio 11.26.14
            DetalleDTO detalleDTO = new DetalleDTO();
    //Ejercicio 11.26.15
            detalleDTO.setId_documento(documentoDTO.getId());
    //Ejercicio 11.26.16
            detallesDTO = detalleDAO.leerPorIdDocumento(detalleDTO);
    //Ejercicio 11.26.17
            if (detallesDTO.isEmpty()) {
                System.out.println("No existen detalles para esa factura...");
            }
            return true;
        } else {
            System.out.println("No existe la factura...");
        }
        return false;
    }
//Ejercicio 11.28    
    public boolean datosCorrectos() {
        return (datosValidos() && datosDeAcuerdoConReglas());
    }    
//Ejercicio 11.28    
    private boolean datosValidos() {
        boolean resultado = true;
        // Validacion 1
        if (documentoDTO.getId_cliente() == null) {
            resultado = false;
        }
        // Validacion 2
        if (!documentoDTO.getTipo().equals("FACT")) {
            resultado = false;            
        }
        // Validacion 3
        if (documentoDTO.getImporte() != 
                facturaDTO.getImporte_mercaderia() + 
                facturaDTO.getIva() -
                facturaDTO.getDescuento()) {
            resultado = false; 
        }
        // Validacion 4
        for (DetalleDTO detalleDTO : detallesDTO) {
            if (detalleDTO.getImporte() != 
                    detalleDTO.getCantidad() *
                    detalleDTO.getPrecio_unitario()) {
                resultado = false;
            }
        }
        return resultado;
    }
//Ejercicio 11.28    
    private boolean datosDeAcuerdoConReglas() {
        boolean resultado = true;
        // Regla 1
        if (documentoDTO.getImporte() <= 10) {
            resultado = false;
        }
        // Regla 2
        if (detallesDTO.size() < 1 || detallesDTO.size() > 14) {
            resultado = false;
        }
        return resultado;
    }
//Ejercicio 11.29    
    public boolean guardarUnaFacturaEnLaBase() {
        boolean resultado = true;
        if (datosCorrectos()) {
//Ejercicio 11.29.1
            DocumentoDAO documentoDAO = new DocumentoDAO();
//Ejercicio 11.29.2
            if (documentoDAO.agregar(documentoDTO)) {
//Ejercicio 11.29.5
                long idDocumento = documentoDAO.getUltimoIdGenerado();
//Ejercicio 11.29.6
                facturaDTO.setId_documento(idDocumento);
                documentoDTO.setId(idDocumento);
//Ejercicio 11.29.7
                FacturaDAO facturaDAO = new FacturaDAO();
//Ejercicio 11.29.8
                if (facturaDAO.agregar(facturaDTO)) {
//Ejercicio 11.29.11
                    DetalleDAO detalleDAO = new DetalleDAO();
//Ejercicio 11.29.12
                    for (DetalleDTO detalleDTO : detallesDTO) {
//Ejercicio 11.29.13
                        detalleDTO.setId_documento(idDocumento);
//Ejercicio 11.29.14
                        if (!detalleDAO.agregar(detalleDTO)) {
//Ejercicio 11.29.15
                            System.out.println("Error al grabar tabla DETALLES");
                            resultado = false;
                        }
                    } 
                } else {
//Ejercicio 11.29.9
                    System.out.println("Error al grabar tabla FACTURAS");
                    resultado = false;
                }
            } else {
//Ejercicio 11.29.3
                System.out.println("Error al grabar tabla DOCUMENTOS");
                resultado = false;
            }
        }
        return resultado;
    }    
}
