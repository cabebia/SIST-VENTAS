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
public class ClienteDTO {
    private Long id;
    private Integer dni;
    private String apyn;

    public ClienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getApyn() {
        return apyn;
    }

    public void setApyn(String apyn) {
        this.apyn = apyn;
    }
    
}
