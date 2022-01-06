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
public class FacturaDTO {
    private Long id_documento;
    private String fecha_vencimiento;
    private Double importe_mercaderia;
    private Double iva;
    private Double descuento;

    public FacturaDTO() {
    }

    public Long getId_documento() {
        return id_documento;
    }

    public void setId_documento(Long id_documento) {
        this.id_documento = id_documento;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Double getImporte_mercaderia() {
        return importe_mercaderia;
    }

    public void setImporte_mercaderia(Double importe_mercaderia) {
        this.importe_mercaderia = importe_mercaderia;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    
}
