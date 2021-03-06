/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.vista;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase que permite visualizar los datos de una factura.
 * Representa la "vista" e interactua con la clase
 * "ControladorConsultarFactura", entre ambas forman
 * la "Interfaz de Usuario" para "Consultar Factura"
 * 
 * @author Ies
 */
public class VistaConsultarFactura extends javax.swing.JDialog {

    /**
     * Creates new form VistaSuma
     */
    public VistaConsultarFactura() {
        initComponents();
        continuarInicializandoComponentes();
    }
    /**
     * Metodo que retorna el contenido almacenado en
     * el objeto "etIdFactura".
     * 
     * @return El dato que se visualiza en "Id Factura"
     */
    public String getIdFactura() {
        return etIdFactura.getText();
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etDniCliente"
     * 
     * @param etDniCliente El Dni del cliente que se desea
     * visualizar
     */
    public void setDniCliente(String etDniCliente) {
        this.etDniCliente.setText(etDniCliente);
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etNumeroFactura"
     * 
     * @param etNumeroFactura El Numero de factura que se
     * desea visualizar
     */
    public void setNumeroFactura(String etNumeroFactura) {
        this.etNumeroFactura.setText(etNumeroFactura);
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etIdCliente"
     * 
     * @param etIdCliente El "Id" del cliente que se desea
     * visualizar
     */
    public void setIdCliente(String etIdCliente) {
        this.etIdCliente.setText(etIdCliente);
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etNomCliente"
     * 
     * @param etNomCliente El nombre del cliente que se desea
     * visualizar
     */
    public void setNomCliente(String etNomCliente) {
        this.etNomCliente.setText(etNomCliente);
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etTotalFactura"
     * 
     * @param etTotalFactura El total de la factura que se desea
     * visualizar
     */
    public void setTotalFactura(Double etTotalFactura) {
        this.etTotalFactura.setText(etTotalFactura.toString());
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etTotalMercaderia"
     * 
     * @param etTotalMercaderia El total correspondiente
     * a mercaderia que se desea visualizar
     */
    public void setTotalMercaderia(Double etTotalMercaderia) {
        this.etTotalMercaderia.setText(etTotalMercaderia.toString());
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etDescuento"
     * 
     * @param etDescuento El descuento que se desea
     * visualizar
     */
    public void setDescuento(Double etDescuento) {
        this.etDescuento.setText(etDescuento.toString());
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etIva"
     * 
     * @param etIva El importe de Iva que se desea
     * visualizar
     */
    public void setIva(Double etIva) {
        this.etIva.setText(etIva.toString());
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etFecha"
     * 
     * @param etFecha La fecha que se desea visualizar
     */
    public void setFecha(String etFecha) {
        this.etFecha.setText(etFecha);
    }

    /**
     * Metodo que asigna el valor recibido como parametro
     * al objeto "etFechaVencimiento"
     * 
     * @param etFechaVencimiento La fecha de vencimiento
     * que se desea visualizar
     */
    public void setFechaVencimiento(String etFechaVencimiento) {
        this.etFechaVencimiento.setText(etFechaVencimiento);
    }

    /**
     * Metodo que permite borrar todo el contenido
     * de la grilla de detalles de la factura
     */
    public void limpiarTablaDetalle() {
        while (tablaDetalle.getRowCount()!=0){
            ((javax.swing.table.DefaultTableModel)tablaDetalle
                    .getModel()).removeRow(0);
        }
    }
    
    /**
     * Metodo que agrega los datos recibidos como 
     * parametro a una fila de la grilla de articulos 
     * 
     * @param cantDetalles El numero de detalle
     * @param articulo La descripcion del articulo
     * @param cantidad La cantidad de unidades de ese articulo
     * @param precioUnitario El precio unitario del articulo
     * @param total El total de ese articulo
     */
    public void agregarFilaTablaDetalle(Integer cantDetalles,
            String articulo, Integer cantidad, Double precioUnitario,
            Double total) {
        String col1 = cantDetalles.toString();
        String col2 = articulo;
        String col3 = cantidad.toString() + "  ";
        String col4 = precioUnitario.toString() + "  ";
        String col5 = total.toString() + "  ";
        javax.swing.table.DefaultTableModel modeloTablaDetalle =
                (javax.swing.table.DefaultTableModel) tablaDetalle.getModel();
        String[] datos = {col1, col2, col3, col4, col5};
        modeloTablaDetalle.addRow(datos);
    }
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etIdFactura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        etNumeroFactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        etIdCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        etDniCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etNomCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        etFecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        etFechaVencimiento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        etTotalMercaderia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        etIva = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        etDescuento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        etTotalFactura = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btRetornar = new java.awt.Button();
        btConfirmar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Factura");
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Encabezado"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("Id.Factura");
        jPanel1.add(jLabel1);

        etIdFactura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etIdFactura.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel1.add(etIdFactura);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("Nro.Factura");
        jPanel1.add(jLabel6);

        etNumeroFactura.setEditable(false);
        etNumeroFactura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etNumeroFactura.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel1.add(etNumeroFactura);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Id.Cliente:");
        jPanel1.add(jLabel2);

        etIdCliente.setEditable(false);
        etIdCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etIdCliente.setFocusable(false);
        etIdCliente.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel1.add(etIdCliente);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("DNI Cliente:");
        jPanel1.add(jLabel3);

        etDniCliente.setEditable(false);
        etDniCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etDniCliente.setFocusable(false);
        etDniCliente.setPreferredSize(new java.awt.Dimension(65, 20));
        jPanel1.add(etDniCliente);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel1.add(jLabel4);

        etNomCliente.setEditable(false);
        etNomCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etNomCliente.setFocusable(false);
        etNomCliente.setPreferredSize(new java.awt.Dimension(130, 20));
        jPanel1.add(etNomCliente);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5);

        etFecha.setEditable(false);
        etFecha.setBackground(new java.awt.Color(255, 255, 102));
        etFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etFecha.setFocusable(false);
        etFecha.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel1.add(etFecha);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        jPanel8.setPreferredSize(new java.awt.Dimension(822, 390));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 350));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Art??culo", "Cantidad", "Precio Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalle.setFocusable(false);
        tablaDetalle.setRowHeight(20);
        jScrollPane1.setViewportView(tablaDetalle);

        jPanel8.add(jScrollPane1);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Fecha Vencimiento:");
        jPanel9.add(jLabel8);

        etFechaVencimiento.setEditable(false);
        etFechaVencimiento.setBackground(new java.awt.Color(255, 255, 102));
        etFechaVencimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etFechaVencimiento.setFocusable(false);
        etFechaVencimiento.setPreferredSize(new java.awt.Dimension(90, 21));
        jPanel9.add(etFechaVencimiento);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Total Mercader??a:");
        jPanel9.add(jLabel11);

        etTotalMercaderia.setEditable(false);
        etTotalMercaderia.setBackground(new java.awt.Color(204, 204, 204));
        etTotalMercaderia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etTotalMercaderia.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        etTotalMercaderia.setFocusable(false);
        etTotalMercaderia.setPreferredSize(new java.awt.Dimension(90, 21));
        jPanel9.add(etTotalMercaderia);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("IVA:");
        jPanel9.add(jLabel12);

        etIva.setEditable(false);
        etIva.setBackground(new java.awt.Color(204, 204, 204));
        etIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etIva.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        etIva.setFocusable(false);
        etIva.setPreferredSize(new java.awt.Dimension(90, 21));
        jPanel9.add(etIva);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setText("Descuento:");
        jPanel9.add(jLabel13);

        etDescuento.setEditable(false);
        etDescuento.setBackground(new java.awt.Color(204, 204, 204));
        etDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etDescuento.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        etDescuento.setFocusable(false);
        etDescuento.setMinimumSize(new java.awt.Dimension(100, 21));
        etDescuento.setPreferredSize(new java.awt.Dimension(90, 21));
        jPanel9.add(etDescuento);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setText("Total Factura:");
        jPanel9.add(jLabel14);

        etTotalFactura.setEditable(false);
        etTotalFactura.setBackground(new java.awt.Color(153, 255, 255));
        etTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etTotalFactura.setForeground(new java.awt.Color(255, 0, 0));
        etTotalFactura.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        etTotalFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        etTotalFactura.setFocusable(false);
        etTotalFactura.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel9.add(etTotalFactura);

        jPanel2.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btRetornar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btRetornar.setLabel("Retornar");
        jPanel3.add(btRetornar);

        btConfirmar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btConfirmar.setLabel("Confirmar");
        jPanel3.add(btConfirmar);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.Button btConfirmar;
    public java.awt.Button btRetornar;
    private javax.swing.JTextField etDescuento;
    private javax.swing.JTextField etDniCliente;
    private javax.swing.JTextField etFecha;
    private javax.swing.JTextField etFechaVencimiento;
    private javax.swing.JTextField etIdCliente;
    private javax.swing.JTextField etIdFactura;
    private javax.swing.JTextField etIva;
    private javax.swing.JTextField etNomCliente;
    private javax.swing.JTextField etNumeroFactura;
    private javax.swing.JTextField etTotalFactura;
    private javax.swing.JTextField etTotalMercaderia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDetalle;
    // End of variables declaration//GEN-END:variables

    private void continuarInicializandoComponentes() {
        javax.swing.table.TableColumn columna1 = tablaDetalle.getColumn("Id");
        columna1.setPreferredWidth(10); 
        javax.swing.table.TableColumn columna2 = tablaDetalle.getColumn("Art??culo");
        columna2.setPreferredWidth(250); 
        javax.swing.table.TableColumn columna3 = tablaDetalle.getColumn("Cantidad");
        columna3.setPreferredWidth(50); 
        DefaultTableCellRenderer tcrr = new DefaultTableCellRenderer();
        tcrr.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer tcrc = new DefaultTableCellRenderer();
        tcrc.setHorizontalAlignment(SwingConstants.CENTER);
        tablaDetalle.getColumnModel().getColumn(0).setCellRenderer(tcrc);
        tablaDetalle.getColumnModel().getColumn(2).setCellRenderer(tcrr);
        tablaDetalle.getColumnModel().getColumn(3).setCellRenderer(tcrr);
        tablaDetalle.getColumnModel().getColumn(4).setCellRenderer(tcrr);
    }
}
