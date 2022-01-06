/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.dto;

/**
 *
 * @author Ies
 */
public class ReciboDTO {
    private Long id_documento;
    private String medio_de_pago;
    private String informacion_adicional;

    public ReciboDTO() {
    }

    public Long getId_documento() {
        return id_documento;
    }

    public void setId_documento(Long id_documento) {
        this.id_documento = id_documento;
    }

    public String getMedio_de_pago() {
        return medio_de_pago;
    }

    public void setMedio_de_pago(String medio_de_pago) {
        this.medio_de_pago = medio_de_pago;
    }

    public String getInformacion_adicional() {
        return informacion_adicional;
    }

    public void setInformacion_adicional(String informacion_adicional) {
        this.informacion_adicional = informacion_adicional;
    }
    
    
}
