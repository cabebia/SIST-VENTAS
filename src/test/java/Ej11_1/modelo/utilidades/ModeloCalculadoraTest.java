/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.modelo.utilidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ies
 */
public class ModeloCalculadoraTest {
    
    public ModeloCalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularUnDetalle method, of class ModeloCalculadora.
     */
    @Test
    public void testCalcularUnDetalle() {
        System.out.println("calcularUnDetalle");
        Integer cantidad = 5;
        Double precioUnitario = 111.11;
        ModeloCalculadora instance = new ModeloCalculadora();
        Double expResult = 555.55;
        Double result = instance.calcularUnDetalle(cantidad, precioUnitario);
        assertEquals(expResult, result);

    }

    /**
     * Test of calcularTotalFactura method, of class ModeloCalculadora.
     */
    @Test
    public void testCalcularTotalFactura() {
        System.out.println("calcularTotalFactura");
        Integer cantidad = 5;
        Double precioUnitario = 111.11;
        ModeloCalculadora instance = new ModeloCalculadora();
        instance.calcularUnDetalle(cantidad, precioUnitario);
        Double expResult = 672.21;
        Double result = instance.calcularTotalFactura();
        assertEquals(expResult, result);

    }

    /**
     * Test of getTotalMercaderia method, of class ModeloCalculadora.
     */
    @Test
    public void testGetTotalMercaderia() {
        System.out.println("getTotalMercaderia");
        Integer cantidad = 5;
        Double precioUnitario = 111.11;
        ModeloCalculadora instance = new ModeloCalculadora();
        instance.calcularUnDetalle(cantidad, precioUnitario);
        instance.calcularUnDetalle(cantidad, precioUnitario);
        Double expResult = 1111.10;
        Double result = instance.getTotalMercaderia();
        assertEquals(expResult, result);

    }

    /**
     * Test of calcularIva method, of class ModeloCalculadora.
     */
    @Test
    public void testCalcularIva() {
        System.out.println("calcularIva");
        Integer cantidad = 5;
        Double precioUnitario = 111.11;
        ModeloCalculadora instance = new ModeloCalculadora();
        instance.calcularUnDetalle(cantidad, precioUnitario);

        Double expResult = 116.66;
        Double result = instance.calcularIva();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDescuento method, of class ModeloCalculadora.
     */
    @Test
    public void testGetDescuento() {
        System.out.println("getDescuento");
        ModeloCalculadora instance = new ModeloCalculadora();
        Double expResult = 10.0;
        instance.setDescuento(10.0);
        Double result = instance.getDescuento();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescuento method, of class ModeloCalculadora.
     */
    @Test
    public void testSetDescuento() {
        System.out.println("setDescuento");
        Double descuento = 10.0;
        ModeloCalculadora instance = new ModeloCalculadora();
        instance.setDescuento(descuento);
    }
    
}
