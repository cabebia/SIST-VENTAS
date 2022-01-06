/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej11_1.vista;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ies
 */
public class VistaConsultarMovimientosPorCliente extends javax.swing.JDialog {

    /**
     * Creates new form VistaSuma
     */
    public VistaConsultarMovimientosPorCliente() {
        initComponents();
        continuarInicializandoComponentes();
    }
    

    public String getIdCliente() {
        return etIdCliente.getText();
    }

    public void setDniCliente(String etDniCliente) {
        this.etDniCliente.setText(etDniCliente);
    }

    public void setNomCliente(String etNomCliente) {
        this.etNomCliente.setText(etNomCliente);
    }

    public void limpiarTablaDocumentos() {
        while (tablaDetalle.getRowCount()!=0){
            ((javax.swing.table.DefaultTableModel)tablaDetalle.getModel()).removeRow(0);
        }
    }
 
    public void agregarFilaTablaDocumentos(Long id, 
            String tipo, Integer numero, String fecha, Double importe) {
        String col1 = id.toString();
        String col2 = tipo;
        String col3 = numero.toString() + "  ";
        String col4 = fecha + "  ";
        String col5 = importe.toString() + "  ";
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
        jLabel2 = new javax.swing.JLabel();
        etIdCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        etDniCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etNomCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btRetornar = new java.awt.Button();
        btConfirmar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Movimientos por Cliente");
        setBounds(new java.awt.Rectangle(50, 50, 0, 0));
        setMinimumSize(new java.awt.Dimension(300, 200));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(858, 580));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(5, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Encabezado"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Id.Cliente:");
        jPanel1.add(jLabel2);

        etIdCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etIdCliente.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.add(etIdCliente);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("          DNI Cliente:");
        jPanel1.add(jLabel3);

        etDniCliente.setEditable(false);
        etDniCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etDniCliente.setFocusable(false);
        etDniCliente.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel1.add(etDniCliente);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("          Cliente:");
        jPanel1.add(jLabel4);

        etNomCliente.setEditable(false);
        etNomCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etNomCliente.setFocusable(false);
        etNomCliente.setPreferredSize(new java.awt.Dimension(250, 20));
        jPanel1.add(etNomCliente);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));
        jPanel8.setPreferredSize(new java.awt.Dimension(822, 390));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 400));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo", "Número", "Fecha", "Importe"
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
        jScrollPane2.setViewportView(tablaDetalle);

        jPanel8.add(jScrollPane2);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JTextField etDniCliente;
    private javax.swing.JTextField etIdCliente;
    private javax.swing.JTextField etNomCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDetalle;
    // End of variables declaration//GEN-END:variables

    private void continuarInicializandoComponentes() {
        javax.swing.table.TableColumn columna1 = tablaDetalle.getColumn("Id");
        columna1.setPreferredWidth(10); 
        javax.swing.table.TableColumn columna2 = tablaDetalle.getColumn("Tipo");
        columna2.setPreferredWidth(250); 
        javax.swing.table.TableColumn columna3 = tablaDetalle.getColumn("Número");
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