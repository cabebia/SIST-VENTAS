/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.interfaces;

/**
 *
 * @author Ies
 */
public interface Obligacion<Cualquiercosa> {
    public boolean agregar(Cualquiercosa cc);
    public boolean borrar(Cualquiercosa cc);
    public boolean modificar(Cualquiercosa cc);
    public Cualquiercosa leer(Cualquiercosa cc);
}
