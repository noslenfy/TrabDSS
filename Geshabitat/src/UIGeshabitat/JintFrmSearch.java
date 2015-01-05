/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGeshabitat;

import BLGeshabitat.Candidatura;
import BLGeshabitat.Doador;
import BLGeshabitat.Funcionario;
import BLGeshabitat.Material;
import BLGeshabitat.Projecto;
import BLGeshabitat.Voluntario;
import DAOGeshabitat.PersistableException;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nelson
 */
public class JintFrmSearch extends javax.swing.JInternalFrame {

    /**
     * Creates new form JintFrmFind
     */
    public JintFrmSearch() {
        initComponents();
        this.fillTableCandidatura();
        this.fillTableProjecto();
        this.fillTableVoluntarios();
        this.fillTableDoadores();
        this.fillTableFuncionarios();
        this.fillTableArtigos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPnlCandidaturas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblCand = new javax.swing.JTable();
        jPnlProjectos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblProjectos = new javax.swing.JTable();
        jPnlVoluntarios = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblVoluntarios = new javax.swing.JTable();
        jPnlDoadores = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTblDoadores = new javax.swing.JTable();
        jPnlFuncionarios = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTblFuncionarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTblArtigos = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("Pesquisar");

        jTblCand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Nif", "Localidade", "Estado", "Responsavel"
            }
        ));
        jScrollPane1.setViewportView(jTblCand);

        javax.swing.GroupLayout jPnlCandidaturasLayout = new javax.swing.GroupLayout(jPnlCandidaturas);
        jPnlCandidaturas.setLayout(jPnlCandidaturasLayout);
        jPnlCandidaturasLayout.setHorizontalGroup(
            jPnlCandidaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPnlCandidaturasLayout.setVerticalGroup(
            jPnlCandidaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jTabbedPane1.addTab("Candidaturas", jPnlCandidaturas);

        jTblProjectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Localidade", "Data Inicio", "Candidatura"
            }
        ));
        jTblProjectos.setColumnSelectionAllowed(true);
        jTblProjectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblProjectosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTblProjectos);
        jTblProjectos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPnlProjectosLayout = new javax.swing.GroupLayout(jPnlProjectos);
        jPnlProjectos.setLayout(jPnlProjectosLayout);
        jPnlProjectosLayout.setHorizontalGroup(
            jPnlProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPnlProjectosLayout.setVerticalGroup(
            jPnlProjectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Projectos", jPnlProjectos);

        jTblVoluntarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Localidade", "Profissao", "Nacionalidade", "Total Voluntariado"
            }
        ));
        jScrollPane3.setViewportView(jTblVoluntarios);
        if (jTblVoluntarios.getColumnModel().getColumnCount() > 0) {
            jTblVoluntarios.getColumnModel().getColumn(4).setMinWidth(70);
            jTblVoluntarios.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTblVoluntarios.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPnlVoluntariosLayout = new javax.swing.GroupLayout(jPnlVoluntarios);
        jPnlVoluntarios.setLayout(jPnlVoluntariosLayout);
        jPnlVoluntariosLayout.setHorizontalGroup(
            jPnlVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPnlVoluntariosLayout.setVerticalGroup(
            jPnlVoluntariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Voluntarios", jPnlVoluntarios);

        jTblDoadores.setAutoCreateRowSorter(true);
        jTblDoadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Localidade", "Tipo", "Total Doado", "Ultima Doacao", "Parceria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblDoadores.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(jTblDoadores);
        jTblDoadores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTblDoadores.getColumnModel().getColumnCount() > 0) {
            jTblDoadores.getColumnModel().getColumn(6).setMinWidth(70);
            jTblDoadores.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTblDoadores.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPnlDoadoresLayout = new javax.swing.GroupLayout(jPnlDoadores);
        jPnlDoadores.setLayout(jPnlDoadoresLayout);
        jPnlDoadoresLayout.setHorizontalGroup(
            jPnlDoadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPnlDoadoresLayout.setVerticalGroup(
            jPnlDoadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Doadores", jPnlDoadores);

        jTblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Localidade", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTblFuncionarios);

        javax.swing.GroupLayout jPnlFuncionariosLayout = new javax.swing.GroupLayout(jPnlFuncionarios);
        jPnlFuncionarios.setLayout(jPnlFuncionariosLayout);
        jPnlFuncionariosLayout.setHorizontalGroup(
            jPnlFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPnlFuncionariosLayout.setVerticalGroup(
            jPnlFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Funcionarios", jPnlFuncionarios);

        jTblArtigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descricao", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblArtigos.setDragEnabled(true);
        jTblArtigos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jTblArtigos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Artigos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Projectos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTblProjectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblProjectosMouseClicked
        boolean existing = false;
        JDesktopPane jDesktopPaneMain = this.getDesktopPane();
        
        for( JInternalFrame i : jDesktopPaneMain.getAllFrames() )
        {
            if(i instanceof JintFrmProject) { 
                /*
                try {
                    i.setSelected(true);
                } catch (PropertyVetoException ex) {  }
                existing=true;
                        */
                i.dispose(); // fecha a janela anterior caso esteja activa
            }
        }
        if(!existing){
            int id = (int)jTblProjectos.getValueAt(jTblProjectos.getSelectedRow(),0);
            JintFrmProject jfrmNewProject = new JintFrmProject(id);
            jfrmNewProject.addInternalFrameListener((InternalFrameListener)((JFrame)this.getTopLevelAncestor()));

            jDesktopPaneMain.add(jfrmNewProject);
             
            ((MDIDesktopPane)jDesktopPaneMain).checkDesktopSize();
            jfrmNewProject.setVisible(true);
        }        
    }//GEN-LAST:event_jTblProjectosMouseClicked

    
    private void fillTableDoadores() {
        List<Object> doadores = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblDoadores.getModel();
        try {
            doadores = JmdiMain.facadeBL.getAll(new Doador());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Doadores","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        int row =0;
        float totaldoado=0;
        for(Object obj : doadores) {
            Doador doador = (Doador) obj;
            try {
                totaldoado = JmdiMain.facadeBL.getTotalDoacoes(doador.getId());
            } catch (PersistableException ex) {
                JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obte o total doado de: " + doador.getNome() + " \n" + ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);                 
            }
            tableModel.addRow(doador.getRowData());
            tableModel.setValueAt(totaldoado, row++, 4);
        }
        
    }
    private void fillTableArtigos() {
        List<Object> artigos = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblArtigos.getModel();
        try {
            artigos = JmdiMain.facadeBL.getAll(new Material());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Artigos","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        for(Object obj : artigos) {
            Material artigo = (Material) obj;

            tableModel.addRow(artigo.getRowData());
        }
        
    }
        private void fillTableFuncionarios() {
        List<Object> funcionarios = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblFuncionarios.getModel();
        try {
            funcionarios = JmdiMain.facadeBL.getAll(new Funcionario());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Funcionarios","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        for(Object obj : funcionarios) {
            Funcionario funcionario = (Funcionario) obj;
            tableModel.addRow(funcionario.getRowData());
        }
        
    }
    private void fillTableVoluntarios() {
        List<Object> vols = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblVoluntarios.getModel();
        try {
            vols = JmdiMain.facadeBL.getAll(new Voluntario());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Voluntarios","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        for(Object obj : vols) {
            Voluntario vol = (Voluntario) obj;
            tableModel.addRow(vol.getRowData());
        }
        
    }
    
    private void fillTableCandidatura() {
        List<Object> cands = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblCand.getModel();
        try {
            cands = JmdiMain.facadeBL.getAll(new Candidatura());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Candidaturas","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        for(Object obj : cands) {
            Candidatura cand = (Candidatura) obj;
            tableModel.addRow(cand.getRowData());
        }
        
    }
    
    private void fillTableProjecto() {
        List<Object> projs = null;
        DefaultTableModel tableModel = (DefaultTableModel)jTblProjectos.getModel();
        try {
            projs = JmdiMain.facadeBL.getAll(new Projecto());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a lista de Projectos","Erro", JOptionPane.ERROR_MESSAGE);  
        }
        
        for(Object obj : projs) {
            Projecto proj = (Projecto) obj;
            tableModel.addRow(proj.getRowData());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnlCandidaturas;
    private javax.swing.JPanel jPnlDoadores;
    private javax.swing.JPanel jPnlFuncionarios;
    private javax.swing.JPanel jPnlProjectos;
    private javax.swing.JPanel jPnlVoluntarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTblArtigos;
    private javax.swing.JTable jTblCand;
    private javax.swing.JTable jTblDoadores;
    private javax.swing.JTable jTblFuncionarios;
    private javax.swing.JTable jTblProjectos;
    private javax.swing.JTable jTblVoluntarios;
    // End of variables declaration//GEN-END:variables
}
