/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import inmobiliaria.Alquiler;
import inmobiliaria.AlquilerData;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class AlquilerTabla extends javax.swing.JInternalFrame {
  private  DefaultTableModel modelo;
   private AlquilerData alqd;
    /**
     * Creates new form AlquilerTabla
     */
    public AlquilerTabla() {
        initComponents();
        
        alqd = new AlquilerData();
        this.cargarTabla();
    }
    
        private void cargarTabla() {
        List<Alquiler> alquileres = alqd.obtenerAlquileres();
        
        if (alquileres == null || alquileres.isEmpty()) {   
      JOptionPane.showMessageDialog(null, "No hay alquileres cargados en la base de datos");
        } else {
            modelo = (DefaultTableModel) this.tablaAlquileres.getModel();
            
            
            modelo.setRowCount(0);
            Object[] fila = new Object[6];

            for (int i = 0; i < alquileres.size(); i++) {
                fila[0] =  new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(alquileres.get(i).getFechaInicio()));
                fila[1] =  new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(alquileres.get(i).getFechaFin()));
                fila[2] = alquileres.get(i).getPrecio();
                fila[3] = alquileres.get(i).getObservaciones().toUpperCase();
                fila[4] = alquileres.get(i).getInmueble().getDireccion();
                fila[5] = alquileres.get(i).getPersona().getNombreCompleto();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlquileres = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion alquileres");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        tablaAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha de Inicio", "Fecha de finalizacion", "Precio", "Observaciones", "Inmueble", "Persona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlquileres);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 30, 990, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlquileres;
    // End of variables declaration//GEN-END:variables
}
