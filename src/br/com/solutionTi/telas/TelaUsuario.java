package br.com.solutionTi.telas;

/**
 * Wendesday, june 12 2019
 *
 * @author AlbertoRochaPinalli
 */
import java.sql.*;
import br.com.solutionsTi.dal.ConnectionBD;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ConnectionBD.getConnection();
    }

    private void read() {
        String sql = "Select * from tbusuarios where iduser = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsoId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUsoNome.setText(rs.getString(2)); //2 é o campo da tabela
                txtUsoFone.setText(rs.getString(3));
                txtUsoLogin.setText(rs.getString(4));
                txtUsoSenha.setText(rs.getString(5));
                cboUsoPerfil.setSelectedItem(rs.getString(6)); //especifico do combo box
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não Cadastrado!");

                txtUsoNome.setText(null);
                txtUsoFone.setText(null);
                txtUsoLogin.setText(null);
                txtUsoSenha.setText(null);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
        }

    }

    private void create() {
        String sql = "insert into tbusuarios (iduser,usuario, fone, login,senha, perfil)"
                + "values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsoId.getText());
            pst.setString(2, txtUsoNome.getText());
            pst.setString(3, txtUsoFone.getText());
            pst.setString(4, txtUsoLogin.getText());
            pst.setString(5, txtUsoSenha.getText());
            pst.setString(6, cboUsoPerfil.getSelectedItem().toString());

            if ((txtUsoId.getText().isEmpty()) || (txtUsoNome.getText().isEmpty()) || (txtUsoLogin.getText().isEmpty())
                    || (txtUsoSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                int adicionado = pst.executeUpdate(); //atualiza a tabela usuarios com  os dados inseridos no formulário
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    txtUsoId.setText(null);
                    txtUsoNome.setText(null);
                    txtUsoFone.setText(null);
                    txtUsoLogin.setText(null);
                    txtUsoSenha.setText(null);

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void update() {
        String sql = "update tbusuarios set usuario =?, fone=?, login=?,senha=?, perfil=? where iduser = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsoNome.getText());
            pst.setString(2, txtUsoFone.getText());
            pst.setString(3, txtUsoLogin.getText());
            pst.setString(4, txtUsoSenha.getText());
            pst.setString(5, cboUsoPerfil.getSelectedItem().toString());
            pst.setString(6, txtUsoId.getText());

            if ((txtUsoId.getText().isEmpty()) || (txtUsoNome.getText().isEmpty()) || (txtUsoLogin.getText().isEmpty())
                    || (txtUsoSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

            } else {

                int alterado = pst.executeUpdate(); //atualiza a tabela usuarios com  os dados inseridos no formulário
                if (alterado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usário alterados com sucesso");
                    txtUsoId.setText(null);
                    txtUsoNome.setText(null);
                    txtUsoFone.setText(null);
                    txtUsoLogin.setText(null);
                    txtUsoSenha.setText(null);

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void delete() {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?",
                    "ATENÇÂO", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION);
                String sql = "delete from tbusuarios where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsoId.getText());
                int delete = pst.executeUpdate();
                if (delete > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                    txtUsoId.setText(null);
                    txtUsoNome.setText(null);
                    txtUsoFone.setText(null);
                    txtUsoLogin.setText(null);
                    txtUsoSenha.setText(null);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
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

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsoId = new javax.swing.JTextField();
        txtUsoNome = new javax.swing.JTextField();
        txtUsoLogin = new javax.swing.JTextField();
        txtUsoSenha = new javax.swing.JTextField();
        cboUsoPerfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtUsoFone = new javax.swing.JTextField();
        btnUsoAdd = new javax.swing.JButton();
        btnUsoLeitura = new javax.swing.JButton();
        btnUsoEditar = new javax.swing.JButton();
        btnUsoExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setMaximumSize(new java.awt.Dimension(2147483, 2147483));
        setPreferredSize(new java.awt.Dimension(200, 100));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("*ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("*Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("*Login");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("*Senha");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("*Perfil");

        cboUsoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Fone");

        btnUsoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/solutionsTi/icons/create.png"))); // NOI18N
        btnUsoAdd.setToolTipText("Adicionar");
        btnUsoAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoAdd.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoAddActionPerformed(evt);
            }
        });

        btnUsoLeitura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/solutionsTi/icons/read.png"))); // NOI18N
        btnUsoLeitura.setToolTipText("Consultar");
        btnUsoLeitura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoLeitura.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsoLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoLeituraActionPerformed(evt);
            }
        });

        btnUsoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/solutionsTi/icons/update.png"))); // NOI18N
        btnUsoEditar.setToolTipText("Editar");
        btnUsoEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoEditar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoEditarActionPerformed(evt);
            }
        });

        btnUsoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/solutionsTi/icons/delete.png"))); // NOI18N
        btnUsoExcluir.setToolTipText("Excluir");
        btnUsoExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsoExcluir.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsoExcluirActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUsoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnUsoLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnUsoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUsoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsoSenha)
                                    .addComponent(txtUsoLogin)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUsoId, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtUsoFone, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cboUsoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUsoAdd, btnUsoEditar, btnUsoExcluir, btnUsoLeitura});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsoFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtUsoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboUsoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUsoLeitura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsoEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsoAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 639, 475);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoAddActionPerformed
        create();
    }//GEN-LAST:event_btnUsoAddActionPerformed

    private void btnUsoLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoLeituraActionPerformed
        read();
    }//GEN-LAST:event_btnUsoLeituraActionPerformed

    private void btnUsoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoEditarActionPerformed
        update();
    }//GEN-LAST:event_btnUsoEditarActionPerformed

    private void btnUsoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsoExcluirActionPerformed
        delete();
    }//GEN-LAST:event_btnUsoExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsoAdd;
    private javax.swing.JButton btnUsoEditar;
    private javax.swing.JButton btnUsoExcluir;
    private javax.swing.JButton btnUsoLeitura;
    private javax.swing.JComboBox<String> cboUsoPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtUsoFone;
    private javax.swing.JTextField txtUsoId;
    private javax.swing.JTextField txtUsoLogin;
    private javax.swing.JTextField txtUsoNome;
    private javax.swing.JTextField txtUsoSenha;
    // End of variables declaration//GEN-END:variables
}
