/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.negocio;

import Ej11_1.modelo.dao.DocumentoDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DocumentoDTO;
import java.util.ArrayList;

/**
 *
 * @author Ies
 */
public class ModeloMovimientosPorCliente {
    private ClienteDTO clienteDTO = new ClienteDTO();
    private ArrayList<DocumentoDTO> documentosDTO = 
            new ArrayList<DocumentoDTO>();

    public ModeloMovimientosPorCliente() {
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public ArrayList<DocumentoDTO> getDocumentos() {
        return documentosDTO;
    }
    
    public boolean obtenerLosMovimientosDeUnCliente() {
        DocumentoDAO documentoDAO = new DocumentoDAO();
        DocumentoDTO documentoDTO = new DocumentoDTO();
        documentoDTO.setId_cliente(clienteDTO.getId());
        documentosDTO = documentoDAO.leerPorIdCliente(documentoDTO);
        return !documentosDTO.isEmpty();
    }
    
}