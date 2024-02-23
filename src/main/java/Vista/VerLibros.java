/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.LibrosControlador;
import Modelo.Libros;
import Modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Belial
 */
public class VerLibros extends javax.swing.JInternalFrame {
    
    ArrayList<Libros> listaLibros = new ArrayList<>();
    DefaultTableModel modelo = new DefaultTableModel();


    /**
     * Creates new form VerLibros
     */
    public VerLibros() {
        initComponents();
          setModelo();
        cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVerLibros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtParteTi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Ver Libros Represados");

        tblVerLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVerLibros);

        jLabel2.setText("Buscar por parte del titulo:");

        txtParteTi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParteTiKeyTyped(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtParteTi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParteTi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        this.limpiarTabla();
           cargarTabla();
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           LibrosControlador lc = new LibrosControlador();
        ArrayList<Object[]> lista = lc.buscarPorNombre(txtParteTi.getText());
        this.limpiarTabla();
        for (Object[] Filas : lista) {
            modelo.addRow(Filas);

        }
        tblVerLibros.setModel(modelo);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
         this.limpiarTabla();
        cargarTabla();
    }//GEN-LAST:event_formMouseClicked

    private void txtParteTiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParteTiKeyTyped
        // TODO add your handling code here:
//        LibrosControlador lc = new LibrosControlador();
//        ArrayList<Object[]> lista = lc.buscarPorNombre(txtParteTi.getText());
//        this.limpiarTabla();
//        for (Object[] Filas : lista) {
//            modelo.addRow(Filas);
//
//        }
//        tblVerLibros.setModel(modelo);
    }//GEN-LAST:event_txtParteTiKeyTyped


     public void setModelo() {
        String[] cabecera = {"Título", "Nombre del Autor", "Apellido del Autor", "ISBN", "Páginas", "Edición", "Editorial", "Ciudad", "País", "Fecha de Edición"};
        modelo.setColumnIdentifiers(cabecera);
        tblVerLibros.setModel(modelo);
    }

    
    
     private void setDatos() {

        Object[] filas = new Object[modelo.getColumnCount()];
        int contador = 1;
        for (Libros datos : listaLibros) {

            filas[0] = contador;
            filas[1] = datos.getPais();
            filas[2] = datos.getAutor().getNombres();
            filas[3] = datos.getAutor().getApellidos();
            filas[4] = datos.getISBN();
            filas[5] = datos.getPaginas();
            filas[6] = datos.getEdicion();
            filas[7] = datos.getEditorial();
            filas[8] = datos.getCiudad();
            filas[9] = datos.getPais();
            filas[10] = datos.getFechaEdicion();
            

            modelo.addRow(filas);
            contador++;
        }
        tblVerLibros.setModel(modelo);
    
    
}
     
 public void cargarTabla() {

        LibrosControlador lc = new LibrosControlador();
        ArrayList<Object[]> lista = lc.datosLibros();
        for (Object[] Filas : lista) {
            modelo.addRow(Filas);

        }
        tblVerLibros.setModel(modelo);
    }
    
    
        
    public void limpiarTabla() {
    int rowCount = modelo.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
        modelo.removeRow(i);
    }
}

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVerLibros;
    private javax.swing.JTextField txtParteTi;
    // End of variables declaration//GEN-END:variables
}
