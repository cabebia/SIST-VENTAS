/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.negocio;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dao.DocumentoDAO;
import Ej11_1.modelo.dao.ReciboDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DocumentoDTO;
import Ej11_1.modelo.dto.ReciboDTO;

/**
 *
 * @author Ies
 */
public class ModeloRecibo {
    private ClienteDTO clienteDTO = new ClienteDTO();
    private DocumentoDTO documentoDTO = new DocumentoDTO();
    private ReciboDTO reciboDTO = new ReciboDTO();

    public ModeloRecibo() {
    }
    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public DocumentoDTO getDocumentoDTO() {
        return documentoDTO;
    }

    public ReciboDTO getReciboDTO() {
        return reciboDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public void setDocumentoDTO(DocumentoDTO documentoDTO) {
        this.documentoDTO = documentoDTO;
    }

    public void setReciboDTO(ReciboDTO reciboDTO) {
        this.reciboDTO = reciboDTO;
    }

    public boolean obtenerUnReciboDeLaBase(long numeroRecibo) {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        documentoDTO.setId(numeroRecibo);
        documentoDTO = documentoDAO.leer(documentoDTO);
        if (documentoDTO.getId() != null && 
                documentoDTO.getTipo().equals("RECI")) {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDTO.setId(documentoDTO.getId_cliente());
            clienteDTO = clienteDAO.leer(clienteDTO);
            if (clienteDTO.getId() == null) {
                System.out.println("No existe el cliente...");
                }
            ReciboDAO reciboDAO = new ReciboDAO();
            reciboDTO.setId_documento(documentoDTO.getId());
            reciboDTO = reciboDAO.leer(reciboDTO);
            if (reciboDTO.getId_documento() == null) {
                System.out.println("No existe el recibo...");
            }
            return true;
        } else {
            System.out.println("No existe el recibo...");
        }
        return false;
    }

    public boolean guardarUnReciboEnLaBase() {
        boolean resultado = true;
        if (datosCorrectos()) {
            DocumentoDAO documentoDAO = new DocumentoDAO();
            if (documentoDAO.agregar(documentoDTO)) {
                long idDocumento = documentoDAO.getUltimoIdGenerado();
                reciboDTO.setId_documento(idDocumento);
                documentoDTO.setId(idDocumento);
                ReciboDAO reciboDAO = new ReciboDAO();
                if (!reciboDAO.agregar(reciboDTO)) {
                    System.out.println("Error al grabar tabla RECIBOS");
                    resultado = false;
                }
            } else {
                System.out.println("Error al grabar tabla DOCUMENTOS");
                resultado = false;
            }
        }
        return resultado;
        }

    
    public boolean datosCorrectos() {
        if (datosValidos() && datosDeAcuerdoConReglas()) {
            return true;
        }
        return false;
    }    
    
    private boolean datosValidos() {
        boolean resultado = true;
        // Validacion 1
        if (documentoDTO.getId_cliente() == null) {
            resultado = false;
        }
        // Validacion 2
        if (!documentoDTO.getTipo().equals("RECI")) {
            resultado = false;            
        }
        // Validacion 3
        if (!reciboDTO.getMedio_de_pago().equals("E") &&
            !reciboDTO.getMedio_de_pago().equals("T")) {
            resultado = false; 
        }
        return resultado;
    }
    
    private boolean datosDeAcuerdoConReglas() {
        boolean resultado = true;
        // Regla 1
        if (documentoDTO.getImporte() <= 10) {
            resultado = false;
        }
        return resultado;
    }
}