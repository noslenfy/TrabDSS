/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGeshabitat;

import javax.swing.JTable;

/**
 *
 * @author nelson
 */
public class JinternalFrameMain extends javax.swing.JInternalFrame {

    /**
     * Creates new form JinternalFrameMain
     */
    public JinternalFrameMain() {
        initComponents();
        createSeparators();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ecrâ principal");

        jTabbedPane.setAutoscrolls(true);
        jTabbedPane.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JScrollPane jScrollPane1Cand;
    private javax.swing.JScrollPane jScrollPane1Proj;
    private javax.swing.JScrollPane jScrollPane1Dona;
    
    private void createSeparators() {
        jScrollPane1Cand = new javax.swing.JScrollPane();
        jScrollPane1Proj = new javax.swing.JScrollPane();
        jScrollPane1Dona = new javax.swing.JScrollPane();
        
        JTable jtabelaCandidaturas = new javax.swing.JTable();

        jtabelaCandidaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1","Manuel Fernandes","456231876","Pendente"},
                {"2","Joaquim Manuel","254631879","Concluida"},
                {"3","Maria Joaquina","528461379","Aprovada"},
                {"4","Antonio Manuel","225897172","Em execução"}
            },
            new String [] {
                "Id", "Nome", "Nif", "Estado"
            }) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
                

        
        if (jtabelaCandidaturas.getColumnModel().getColumnCount() > 0) {
            jtabelaCandidaturas.getColumnModel().getColumn(0).setMinWidth(40);
            jtabelaCandidaturas.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtabelaCandidaturas.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jtabelaCandidaturas.setColumnSelectionAllowed(false);

        jScrollPane1Cand.setViewportView(jtabelaCandidaturas);

        jTabbedPane.addTab("Candidaturas", jScrollPane1Cand);
        jTabbedPane.addTab("Projectos", jScrollPane1Proj);
        jTabbedPane.addTab("Donativos", jScrollPane1Dona);


    }                      
                   


}
