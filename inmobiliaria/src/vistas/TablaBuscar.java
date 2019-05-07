/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import inmobiliaria.Inmueble;
import inmobiliaria.InmuebleData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vistas.GestionInmuebles.jDesktopPane1;

/**
 *
 * @author pedro
 */
public class TablaBuscar extends javax.swing.JInternalFrame {
    private  DefaultTableModel modelo;
    private InmuebleData inmd;
    /**
     * Creates new form TablaBuscar
     */
    public TablaBuscar() {
        initComponents();
        
        inmd = new InmuebleData();
        this.cargarTabla();
    }
    
    
    private void cargarTabla() {
        List<Inmueble> inm = inmd.obtenerInmuebles();
        
        if (inm == null || inm.isEmpty()) {   
      JOptionPane.showMessageDialog(null, "No hay inmuebles cargados en la base de datos");
        } else {
            modelo = (DefaultTableModel) tablaInmuebles.getModel();
            
            
            modelo.setRowCount(0);
            Object[] fila = new Object[4];

            for (int i = 0; i < inm.size(); i++) {
                fila[0] = inm.get(i).getDireccion().toUpperCase();
                fila[1] = inm.get(i).getCantAmbientes();
                fila[2] = inm.get(i).isDisponibilidad();
                fila[3] = inm.get(i).getpersona().getNombreCompleto().toUpperCase();
                modelo.addRow(fila);
            }
        }
    }
    
        private void buscarTabla(String direccion) {
        List<Inmueble> inm = inmd.obtenerInmuebles(direccion);
        
        if (inm == null || inm.isEmpty()) {   
      JOptionPane.showMessageDialog(null, "No hay inmuebles con esa direccion cargados en la base de datos");
        } else {
            modelo = (DefaultTableModel) tablaInmuebles.getModel();
            
            
            modelo.setRowCount(0);
            Object[] fila = new Object[4];

            for (int i = 0; i < inm.size(); i++) {
                fila[0] = inm.get(i).getDireccion().toUpperCase();
                fila[1] = inm.get(i).getCantAmbientes();
                fila[2] = inm.get(i).isDisponibilidad();
                fila[3] = inm.get(i).getpersona().getNombreCompleto().toUpperCase();
                modelo.addRow(fila);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        campoBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscarBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInmuebles = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));
        getContentPane().add(campoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 11, 519, 31));

        jLabel1.setText("Buscar por direccion del inmueble:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        buscarBoton.setText("Buscar");
        buscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 11, -1, 31));

        tablaInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Direccion", "Cantidad de Ambientes", "Disponibilidad", "Persona propietaria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaInmuebles);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 990, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
       jDesktopPane1.removeAll();
       jDesktopPane1.repaint();
       this.dispose();
       TablaDeInmueble ti = new TablaDeInmueble();
       jDesktopPane1.add(ti);
       ti.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void buscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBotonActionPerformed
       if(this.campoBusqueda.getText().trim().length() != 0){
        this.buscarTabla(this.campoBusqueda.getText().trim());
       } else {
           JOptionPane.showMessageDialog(null, "Debes llenar el campo direccion para continuar");
       }
    }//GEN-LAST:event_buscarBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton buscarBoton;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaInmuebles;
    // End of variables declaration//GEN-END:variables
}
