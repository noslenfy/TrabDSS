/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIGeshabitat;
import BLGeshabitat.Familias.Candidatura;
import BLGeshabitat.Projectos.Fase;
import BLGeshabitat.Utilizadores.Funcionario;
import BLGeshabitat.Projectos.Projecto;
import BLGeshabitat.Projectos.RegistoMaterial;
import BLGeshabitat.Fundos.RegistoVoluntariado;
import BLGeshabitat.Projectos.Tarefa;
import BLGeshabitat.Fundos.Voluntario;
import DAOGeshabitat.PersistableException;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class JintFrmProject extends ModalJinternalFrame implements Observer{

    public Projecto projecto;
    /**
     * Creates new form JintFrmNewProjecto
     */
    public JintFrmProject(Projecto projecto) {
        JmdiMain.facadeBL.addObserver(this);
        this.projecto = projecto;
        initComponents();
        this.getInfo();
        this.getTarefasNRealizadas();
        this.getTarefasConcluidas();
        this.getMateriaisUtilizados();
        this.getVoluntariado();
    }
    
    private void getVoluntariado() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) this.jTblVoluntariado.getModel();
            tableModel.setRowCount(0);
            for ( Object obj : JmdiMain.facadeBL.getAll(new RegistoVoluntariado())) {
                RegistoVoluntariado reg = (RegistoVoluntariado)obj;
                Voluntario v = (Voluntario) JmdiMain.facadeBL.get(new Voluntario(), reg.getVoluntario_Id());
                Tarefa t = (Tarefa)  JmdiMain.facadeBL.get(new Tarefa(), reg.getTarefa_Id());
                Funcionario f = (Funcionario) JmdiMain.facadeBL.get(new Funcionario(), reg.getFuncionario_Id());
                tableModel.addRow(new Object[] {reg.getId(),v.getNome(),reg.getEquipa(), t.getDescricao(), reg.getTempo(), f.getNome()});
            }
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter os voluntarios!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }
    
    private void getTarefasNRealizadas() {
        
        try {
            DefaultTableModel tableModel = (DefaultTableModel) this.jTblTarefasNRealizadas.getModel();
            tableModel.setRowCount(0);
            for(Tarefa t : JmdiMain.facadeBL.getTarefasNRealizadas(projecto.getId())) {
                String Descricao = t.getDescricao();
                String fase = JmdiMain.facadeBL.getField(new Fase(), "Descricao", "Id", t.getFase_Id());
                tableModel.addRow(new Object[] { Descricao, fase });
            }
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter as tarefas por realizar!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }
    
    private void getTarefasConcluidas() {
        try {
            Map tarefas = JmdiMain.facadeBL.getTarefasConcluidas(projecto.getId());
            DefaultTableModel tableModel = (DefaultTableModel) this.jTblTarefasConcluidas.getModel();
            tableModel.setRowCount(0);            
            for(Object t : tarefas.entrySet()) {
                Map.Entry<Tarefa,Integer> pair = (Map.Entry<Tarefa,Integer>)t;
            

                String Descricao = pair.getKey().getDescricao();
                String fase = JmdiMain.facadeBL.getField(new Fase(), "Descricao", "Id", pair.getKey().getFase_Id());
                Integer duracao = pair.getValue();
                
                tableModel.addRow(new Object[] { Descricao, fase, duracao });
        }
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter as terafas realizadas!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    private void getInfo()  {

        jLblProjectNo.setText(String.valueOf(projecto.getId()));
        jLblDescricao.setText(projecto.getDescricao());
        jLblRua.setText(projecto.getRua());
        jLblCpLocalidade.setText(projecto.getCp() + " - " + projecto.getLocalidade());
        jLblDtCriado.setText(projecto.getDtInicioProjecto().toString());
        String criadoPor = null;
        try {
            Candidatura c = (Candidatura) JmdiMain.facadeBL.get(new Candidatura(), projecto.getCandidatura_Id());
            criadoPor = JmdiMain.facadeBL.getField(new Funcionario(), "Nome", "Id", c.getFuncionario_Id());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a informação do projecto!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        jLblCriadoPor.setText(criadoPor);

        
        
        if(projecto.getOrcamento()==-1)  jLblOrcamento.setText("Não definido");
        else  jLblOrcamento.setText(String.valueOf(projecto.getOrcamento()));
        if(projecto.getCustoFinal()==-1)  jLblCustoFinal.setText("Não definido");
        else  jLblCustoFinal.setText(String.valueOf(projecto.getCustoFinal()));
        
        try {
            String responsavel = JmdiMain.facadeBL.getNomeFuncionario(projecto.getFuncionario_Id());
            jLblResponsavel.setText(responsavel);
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro ao obter a informação do projecto!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
    }
    
    private void getMateriaisUtilizados() {
        jTblMateriaisUtilizados.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) this.jTblMateriaisUtilizados.getModel();
        try {
            for(RegistoMaterial r : JmdiMain.facadeBL.getMateriaisUtilizados(projecto.getId())) {
                tableModel.addRow(r.getRow());
            }
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro os materiais utilizados!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
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

        jPanel1 = new javax.swing.JPanel();
        jLblRua = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLblDtCriado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLblDescricao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLblProjectNo = new javax.swing.JLabel();
        jLblCpLocalidade = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLblCriadoPor = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLblOrcamento = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jBtOrcamento = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jBtResponsavel = new javax.swing.JButton();
        jBtCustoFinal = new javax.swing.JButton();
        jLblCustoFinal = new javax.swing.JLabel();
        jLblResponsavel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMateriaisUtilizados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblVoluntariado = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTblTarefasConcluidas = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTblTarefasNRealizadas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestão de Projecto");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Info Projecto"));

        jLblRua.setText("Rua das laranjinhas N.º 4 ");

        jLabel5.setText("Criado em:");

        jLblDtCriado.setText("12 Outubro 2013");

        jLabel4.setText("Localização:");

        jLblDescricao.setText("Habitação para o Ze Manel");

        jLabel2.setText("Descrição:");

        jLabel1.setText("Projecto Número:");

        jLblProjectNo.setText("13");

        jLblCpLocalidade.setText("4142-315");

        jLabel8.setText("Criado por:");

        jLblCriadoPor.setText("nunescf3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblDescricao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblProjectNo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblDtCriado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblCpLocalidade)
                            .addComponent(jLblRua)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblCriadoPor)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLblProjectNo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLblDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLblRua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblCpLocalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLblDtCriado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLblCriadoPor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true)));

        jLblOrcamento.setText("80000.00");

        jLabel15.setText("Custo final:");

        jLabel14.setText("€");

        jBtOrcamento.setText("jButton1");
        jBtOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOrcamentoActionPerformed(evt);
            }
        });

        jLabel12.setText("Orçamento:");

        jBtResponsavel.setText("jButton1");
        jBtResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtResponsavelActionPerformed(evt);
            }
        });

        jBtCustoFinal.setText("jButton1");
        jBtCustoFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCustoFinalActionPerformed(evt);
            }
        });

        jLblCustoFinal.setText("Não definido");

        jLblResponsavel.setText("Joaquim Fernandes");

        jLabel20.setText("Responsável Obra:");

        jLabel17.setText("Execução iniciada em:");

        jLabel18.setText("15 Outubro 2013");

        jLabel19.setText("Execução terminada em:");

        jLabel26.setText("Ainda em execução");

        jLabel3.setText("€");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblResponsavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLblOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLblCustoFinal)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtCustoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLblOrcamento)
                    .addComponent(jLabel14)
                    .addComponent(jBtOrcamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtCustoFinal)
                    .addComponent(jLblCustoFinal)
                    .addComponent(jLabel15)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLblResponsavel)
                    .addComponent(jBtResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel19))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Material Utilizado"));

        jTblMateriaisUtilizados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Quantidade", "Fase"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblMateriaisUtilizados.setCellSelectionEnabled(false);
        jTblMateriaisUtilizados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTblMateriaisUtilizados);
        jTblMateriaisUtilizados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Voluntariado Utilizado"));

        jTblVoluntariado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr", "Nome", "Equipa", "Tarefa", "Tempo", "Responsavel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblVoluntariado.setColumnSelectionAllowed(true);
        jTblVoluntariado.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTblVoluntariado);
        jTblVoluntariado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Tarefas por realizar / Realizadas"));

        jSplitPane1.setDividerLocation(500);

        jTblTarefasConcluidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Fase", "Duração(dias)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblTarefasConcluidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTblTarefasConcluidas);

        jSplitPane1.setRightComponent(jScrollPane3);

        jTblTarefasNRealizadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Fase"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblTarefasNRealizadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTblTarefasNRealizadas);

        jSplitPane1.setLeftComponent(jScrollPane4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtResponsavelActionPerformed
        ImageIcon icon = new ImageIcon("");
        List<Object> funcionarios = null;
        try {
            funcionarios = JmdiMain.facadeBL.getAll(new Funcionario());
        } catch (PersistableException ex) {
            Logger.getLogger(JintFrmProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object s = JOptionPane.showInputDialog(
                    this    ,
                    "Responsavel obra",
                    "Escolha o Encarregado de Obra\n",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    funcionarios.toArray(),
                    "");
        
        try {
            JmdiMain.facadeBL.update(new Projecto(), "Funcionario_Id",String.valueOf(((Funcionario)s).getId()) , projecto.getId());
        } catch (PersistableException ex) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro registar o Responsavel!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.getInfo();

    }//GEN-LAST:event_jBtResponsavelActionPerformed

    private void jBtCustoFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCustoFinalActionPerformed
        ImageIcon icon = new ImageIcon("");
       
        String s = (String)JOptionPane.showInputDialog(
        this    ,
        "Custo Final",
        "Defina custo final",
        JOptionPane.PLAIN_MESSAGE,
        icon,
        null,
        "");
        if(s!=null) {
            try {
                Float valor = Float.valueOf(s); // apesar de fornecer como dados uma string testa aqui se é convertivel para float
                JmdiMain.facadeBL.update(new Projecto(), "CustoFinal", s, projecto.getId());
              //  Custo = JmdiMain.facadeBL.getField(new Projecto(), "CustoFinal", "Id", this.Project_Id);
            } catch (PersistableException ex) {
                JOptionPane.showMessageDialog(this,"Ocorreu um erro registar o Custo Final!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"O valor que inseriu não é válido!\n","Erro", JOptionPane.ERROR_MESSAGE);
                
            }
            this.getInfo();
        }
    }//GEN-LAST:event_jBtCustoFinalActionPerformed

    private void jBtOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOrcamentoActionPerformed
        ImageIcon icon = new ImageIcon("");
       
        String s = (String)JOptionPane.showInputDialog(
        this    ,
        "Valor Orcamentado",
        "Valor Orcamentado:",
        JOptionPane.PLAIN_MESSAGE,
        icon,
        null,
        "");

        if(s!=null) {

            try {
                Float valor = Float.valueOf(s);
                JmdiMain.facadeBL.update(new Projecto(), "Orcamento", s, projecto.getId());
                //Orcamento = JmdiMain.facadeBL.getField(new Projecto(), "Orcamento", "Id", this.Project_Id);

            } catch (PersistableException ex) {
                JOptionPane.showMessageDialog(this,"Ocorreu um erro registar o Orcamento!\n"+ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"O valor que inseriu não é válido!\n","Erro", JOptionPane.ERROR_MESSAGE);
                
            }
            this.getInfo();
        }
    }//GEN-LAST:event_jBtOrcamentoActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCustoFinal;
    private javax.swing.JButton jBtOrcamento;
    private javax.swing.JButton jBtResponsavel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLblCpLocalidade;
    private javax.swing.JLabel jLblCriadoPor;
    private javax.swing.JLabel jLblCustoFinal;
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblDtCriado;
    private javax.swing.JLabel jLblOrcamento;
    private javax.swing.JLabel jLblProjectNo;
    private javax.swing.JLabel jLblResponsavel;
    private javax.swing.JLabel jLblRua;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTblMateriaisUtilizados;
    private javax.swing.JTable jTblTarefasConcluidas;
    private javax.swing.JTable jTblTarefasNRealizadas;
    private javax.swing.JTable jTblVoluntariado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.getInfo();
        this.getTarefasNRealizadas();
        this.getTarefasConcluidas();
        this.getMateriaisUtilizados();
        this.getVoluntariado();
    }
}
