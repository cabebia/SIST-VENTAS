/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.controlador;

import Ej11_1.modelo.dao.ClienteDAO;
import Ej11_1.modelo.dao.DetalleDAO;
import Ej11_1.modelo.dao.DocumentoDAO;
import Ej11_1.modelo.dao.FacturaDAO;
import Ej11_1.modelo.dao.ReciboDAO;
import Ej11_1.modelo.dto.ClienteDTO;
import Ej11_1.modelo.dto.DetalleDTO;
import Ej11_1.modelo.dto.DocumentoDTO;
import Ej11_1.modelo.dto.FacturaDTO;
import Ej11_1.modelo.dto.ReciboDTO;
import Ej11_1.modelo.negocio.ModeloFactura;
import Ej11_1.modelo.negocio.ModeloRecibo;
import Ej11_1.modelo.utilidades.ModeloFechaHora;
import java.util.ArrayList;

import Ej11_1.vista.VistaMenu;


/**
 *
 * @author Ies
 */
public class Principal {
    //variables para utilizar en diferentes 
    //momentos de las pruebas
    private static long id;
    private static long id_cliente;
    private static boolean resp;
    //
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaMenu menu = new VistaMenu();
        ControladorMenu controlador = new ControladorMenu(menu);
        menu.setVisible(true);
//////Ejercicio 11.11        
//        //-------------------------------------
//        //  Para probar accesos a tabla "clientes"
//        //-------------------------------------
//        //Leer una fila de la tabla clientes
//        System.out.println("\n---------------------"
//                + "\nPrueba tabla CLIENTES "
//                + "\n---------------------");
//        ClienteDAO cdao = new ClienteDAO();
//        ClienteDTO cdto1 = new ClienteDTO();
//        id =  2;
//        cdto1.setId(id);
//        ClienteDTO cdto2 = cdao.leer(cdto1);
//        System.out.println("El cliente 2 tiene DNI: " + cdto2.getDni() + 
//                " y su nombre es: " + cdto2.getApyn()); 
//////Ejercicio 11.12
//        //Agregar una fila a la tabla clientes
//        cdto1.setId(null);
//        cdto1.setDni(50000000);
//        cdto1.setApyn("Garcia Andrea");
//        resp = cdao.agregar(cdto1);
//        if (resp) {
//            System.out.println("La fila fue agregada correctamente");
//        } else {
//            System.out.println("La fila NO fue agregada");
//        }
//////Ejercicio 11.13
//        //Modificar una fila de la tabla clientes
//        id =  12; // número de id agregado en el punto anterior
//        cdto1.setId(id);
//        cdto1.setDni(60000000);
//        cdto1.setApyn("Garcia Andres");
//        resp = cdao.modificar(cdto1);
//        if (resp) {
//            System.out.println("La fila fue modificada correctamente");
//        } else {
//            System.out.println("La fila NO fue modificada");
//        }
//////Ejercicio 11.14
//        //Eliminar una fila de la tabla clientes
//	  id =  12; // número de id agregado en el punto anterior
//        cdto1.setId(id);
//        resp = cdao.borrar(cdto1);
//        if (resp) {
//            System.out.println("La fila fue eliminada correctamente");
//        } else {
//            System.out.println("La fila NO fue eliminada");
//        }
//////Ejercicio 11.17
//        //-------------------------------------------
//        //  Para probar accesos a tabla "documentos"
//        //-------------------------------------------
//        //Leer una fila de la tabla documentos
//        System.out.println("\n------------------------"
//                + "\nPrueba tabla DOCUMENTOS "
//                + "\n------------------------");
//        DocumentoDAO ddao = new DocumentoDAO();
//        DocumentoDTO ddto1 = new DocumentoDTO();
//        id =  2;
//        ddto1.setId(id);
//        DocumentoDTO ddto2 = ddao.leer(ddto1);
//        System.out.println("El Documento 2 es tipo: " + ddto2.getTipo() +
//                " número: " + ddto2.getNumero() + 
//                " id_cliente: " + ddto2.getId_cliente() +
//                " fecha: " + ddto2.getFecha() +
//                " importe: " + ddto2.getImporte());
//////Ejercicio 11.18
//        //Agregar una fila a la tabla documentos
//        ddto1.setId(null);
//        ddto1.setTipo("RECI");
//        ddto1.setNumero(9999);
//        id_cliente = 9;
//        ddto1.setId_cliente(id_cliente);
//        ddto1.setFecha("2021-01-01 00:00:00");
//        ddto1.setImporte(9999.99);
//        resp = ddao.agregar(ddto1);
//        if (resp) {
//            System.out.println("La fila fue agregada correctamente");
//        } else {
//            System.out.println("La fila NO fue agregada");
//        }
//////Ejercicio 11.19
//        //Modificar una fila de la tabla documentos
//	  id = 9; //id agregado en el punto anterior
//        ddto1.setId(id);
//        ddto1.setTipo("RECI");
//        ddto1.setNumero(9999);
//        id_cliente = 4;
//        ddto1.setId_cliente(id_cliente);
//        ddto1.setFecha("2021-01-01 00:00:00");
//        ddto1.setImporte(9999.99);
//        resp = ddao.modificar(ddto1);
//        if (resp) {
//            System.out.println("La fila fue modificada correctamente");
//        } else {
//            System.out.println("La fila NO fue modificada");
//        }
//////Ejercicio 11.20
//        //Eliminar una fila de la tabla documentos
//        id = 9; // número de id agregado en el punto anterior
//        ddto1.setId(id);
//        resp = ddao.borrar(ddto1);
//        if (resp) {
//            System.out.println("La fila fue eliminada correctamente");
//        } else {
//            System.out.println("La fila NO fue eliminada");
//        }
//////Ejercicio 11.22
//        //----------------------------------------
//        //  Para probar accesos a tabla "recibos"
//        //----------------------------------------
//        //Leer una fila de la tabla recibos
//        System.out.println("\n---------------------"
//                + "\nPrueba tabla RECIBOS "
//                + "\n---------------------");
//        ReciboDAO rdao = new ReciboDAO();
//        ReciboDTO rdto1 = new ReciboDTO();
//        id =  5;
//        rdto1.setId_documento(id);
//        ReciboDTO rdto2 = rdao.leer(rdto1);
//        System.out.println("El Recibo 5 tiene medio de pago: " + 
//                rdto2.getMedio_de_pago() +
//                " Informacion adicional: " + rdto2.getInformacion_adicional()); 
//        //Agregar una fila a la tabla recibos
//        id = 9;
//        rdto1.setId_documento(id);
//        rdto1.setMedio_de_pago("C");
//        rdto1.setInformacion_adicional("Prueba para agregar recibo");
//        resp = rdao.agregar(rdto1);
//        if (resp) {
//            System.out.println("La fila fue agregada correctamente");
//        } else {
//            System.out.println("La fila NO fue agregada");
//        }
//        //Modificar una fila de la tabla recibos
//	  id = 9; //id agregado en el punto anterior
//        rdto1.setId_documento(id);
//        rdto1.setMedio_de_pago("R");
//        rdto1.setInformacion_adicional("Prueba para modificar recibo");       
//        resp = rdao.modificar(rdto1);
//        if (resp) {
//            System.out.println("La fila fue modificada correctamente");
//        } else {
//            System.out.println("La fila NO fue modificada");
//        }
//        //Eliminar una fila de la tabla recibos
//	  id = 9; // número de id agregado en el punto anterior
//        rdto1.setId_documento(id);
//        resp = rdao.borrar(rdto1);
//        if (resp) {
//            System.out.println("La fila fue eliminada correctamente");
//        } else {
//            System.out.println("La fila NO fue eliminada");
//        }
//////Ejercicio 11.23
//        //-----------------------------------------
//        //  Para probar accesos a tabla "facturas"
//        //-----------------------------------------
//        //Leer una fila de la tabla facturas
//        System.out.println("\n----------------------"
//                + "\nPrueba tabla FACTURAS "
//                + "\n----------------------");
//        FacturaDAO fdao = new FacturaDAO();
//        FacturaDTO fdto1 = new FacturaDTO();
//        id = 2;
//        fdto1.setId_documento(id);
//        FacturaDTO fdto2 = fdao.leer(fdto1);
//        System.out.println("La factura 2 es: " + fdto2.getFecha_vencimiento() +
//                " Importe mercaderia: " + fdto2.getImporte_mercaderia() +
//                " Iva: " + fdto2.getIva() + " Descuento: " + fdto2.getDescuento()); 
//        //Agregar una fila a la tabla facturas
//        id = 9;
//        fdto1.setId_documento(id);
//        fdto1.setFecha_vencimiento("2021-01-01 01:01:01");
//        fdto1.setImporte_mercaderia(9999.9);
//        fdto1.setIva(999.9);
//        fdto1.setDescuento(99.9);
//        resp = fdao.agregar(fdto1);
//        if (resp) {
//            System.out.println("La fila fue agregada correctamente");
//        } else {
//            System.out.println("La fila NO fue agregada");
//        }
//        //Modificar una fila de la tabla facturas
//	  id = 9; //id agregado en el punto anterior
//        fdto1.setId_documento(id);
//        fdto1.setFecha_vencimiento("2021-02-02 02:02:02");
//        fdto1.setImporte_mercaderia(9999.0);
//        fdto1.setIva(999.0);
//        fdto1.setDescuento(99.0);
//        resp = fdao.modificar(fdto1);
//        if (resp) {
//            System.out.println("La fila fue modificada correctamente");
//        } else {
//            System.out.println("La fila NO fue modificada");
//        }
//        //Eliminar una fila de la tabla facturas
//	  id = 9; // número de id agregado en el punto anterior
//        fdto1.setId_documento(id);
//        resp = fdao.borrar(fdto1);
//        if (resp) {
//            System.out.println("La fila fue eliminada correctamente");
//        } else {
//            System.out.println("La fila NO fue eliminada");
//        }
//////Ejercicio 11.24
//        //-----------------------------------------
//        //  Para probar accesos a tabla "detalles"
//        //-----------------------------------------
//        Leer una fila de la tabla detalles
//        System.out.println("\n----------------------"
//                + "\nPrueba tabla DETALLES "
//                + "\n----------------------");
//        DetalleDAO dtdao = new DetalleDAO();
//        DetalleDTO dtdto1 = new DetalleDTO();
//	  id = 4;
//        dtdto1.setId_documento(id);
//        dtdto1.setId_detalle(2);
//        DetalleDTO dtdto2 = dtdao.leer(dtdto1);        
//        System.out.println("El detalle 2 de la factura 4 es: " + dtdto2.getArticulo() +
//                " Cantidad: " + dtdto2.getCantidad() +
//                " Precio unitario: " + dtdto2.getPrecio_unitario() +
//                " Importe: " + dtdto2.getImporte()); 
//        //Agregar una fila a la tabla detalles
//        id = 9;
//        dtdto1.setId_documento(id);
//        dtdto1.setId_detalle(9);
//        dtdto1.setArticulo("Articulo nueve detalle 9");
//        dtdto1.setCantidad(9);
//        dtdto1.setPrecio_unitario(9999.9);
//        dtdto1.setImporte(99999.9);
//        resp = dtdao.agregar(dtdto1);
//        if (resp) {
//            System.out.println("La fila fue agregada correctamente");
//        } else {
//            System.out.println("La fila NO fue agregada");
//        }
//        //Modificar una fila de la tabla detalles
//        id = 9;
//        dtdto1.setId_documento(id);
//        dtdto1.setId_detalle(9);
//        dtdto1.setArticulo("Articulo nueve detalle 9");
//        dtdto1.setCantidad(4);
//        dtdto1.setPrecio_unitario(4444.4);
//        dtdto1.setImporte(44444.4);
//        resp = dtdao.modificar(dtdto1);
//        if (resp) {
//            System.out.println("La fila fue modificada correctamente");
//        } else {
//            System.out.println("La fila NO fue modificada");
//        }
//        //Eliminar una fila de la tabla detalles
//        id = 9;
//        dtdto1.setId_documento(id);
//        dtdto1.setId_detalle(9);
//        resp = dtdao.borrar(dtdto1);
//        if (resp) {
//            System.out.println("La fila fue eliminada correctamente");
//        } else {
//            System.out.println("La fila NO fue eliminada");
//        }
//        //Leer todos los detalles de un documento
//        id = 4;
//        dtdto1.setId_documento(id);
//        ArrayList<DetalleDTO> detalles = dtdao.leerPorIdDocumento(dtdto1);
//        for (DetalleDTO detalle : detalles) {
//            System.out.println("Detalle : " + detalle.getId_documento() +
//                " " + detalle.getId_detalle() +
//                " Articulo:"    + detalle.getArticulo() +
//                " Cantidad: " + detalle.getCantidad() +
//                " Precio unitario: " + detalle.getPrecio_unitario() +
//                " Importe: " + detalle.getImporte()); 
//        }
//////Ejercicio 11.30
//        //----------------------------------------------
//        //  Para probar accesos a una "factura completa"
//        //----------------------------------------------
//        //Leer una factura "completa" (documento,
//        //factura y detalles) usando una instancia
//        //de "ModeloFactura"
//        System.out.println("\n----------------------"
//                + "\nPrueba MODELO FACTURA "
//                + "\n----------------------");
//        ModeloFactura modeloFactura = new ModeloFactura();
//        if (modeloFactura.obtenerUnaFacturaDeLaBase(4)){
//            System.out.println("La factura existe, verifique con el "
//                    + "depurador la información que contiene");
//        } else {
//            System.out.println("La factura no existe");
//        }
//////Ejercicio 11.31
//        //Guardar una factura "completa" (documento, factura y detalles) usando
//        //una instancia de "ModeloFactura"
//        //Para facilitar la carga de los datos en las dto se lee una factura 
//        //existente y se guarda nuevamente (con otro id)
//        ModeloFactura modeloFactura = new ModeloFactura();
//        if (modeloFactura.obtenerUnaFacturaDeLaBase(4)){
//            if (modeloFactura.guardarUnaFacturaEnLaBase()) {
//                System.out.println("La factura fue grabada correctamente");
//            } else {
//                System.out.println("La factura no fue grabada");
//            }
//        }
//////Ejercicio 11.32
//        //--------------------------------------------
//        //  Para probar accesos a un "recibo completo"
//        //--------------------------------------------
//        //Leer un recibo "completo" (documento y recibo) usando
//        //una instancia de "ModeloRecibo"
//        System.out.println("\n---------------------"
//                + "\nPrueba MODELO RECIBO "
//                + "\n---------------------");
//        ModeloRecibo modeloRecibo = new ModeloRecibo();
//        if (modeloRecibo.obtenerUnReciboDeLaBase(7)){
//            System.out.println("El recibo existe, verifique con el "
//                    + "depurador la información que contiene");
//        } else {
//            System.out.println("El recibo no existe");
//        }
//        //Guardar un recibo "completo" (documento y recibo) usando
//        //una instancia de "ModeloRecibo"
//        //Para facilitar la carga de los datos en las dto se lee un recibo 
//        //existente y se guarda nuevamente (con otro id)
//        ModeloRecibo modeloRecibo = new ModeloRecibo();
//        if (modeloRecibo.obtenerUnReciboDeLaBase(7)){
//            if (modeloRecibo.guardarUnReciboEnLaBase()) {
//                System.out.println("El recibo fue grabado correctamente");
//            } else {
//                System.out.println("El recibo no fue grabado");
//            }
//        }
//////Ejercicio 11.41
//        System.out.println("\n-------------------------"
//                + "\nPrueba FECHA HORA ACTUAL "
//                + "\n-------------------------");
//        //Verifica el formato de la fecha y hora
//        //actual para grabar en la base (formato "Date")
//        System.out.println("Ejercicio 11.41");
//        System.out.println(ModeloFechaHora.obtenerFechaHoraActual());
    }
}
