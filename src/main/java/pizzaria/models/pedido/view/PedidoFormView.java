/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pizzaria.models.pedido.view;

import pizzaria.models.cliente.Cliente;
import pizzaria.models.valores.ValorController;
import pizzaria.models.valores.ValorDAO;

/**
 *
 * @author chris
 */
public class PedidoFormView extends javax.swing.JFrame {

    private final Cliente cliente;
    private final ValorController valorController;
    private final ValorDAO valorDAO;

    /**
     * Creates new form PedidoForm
     */
    public PedidoFormView(Cliente cliente,ValorController valorController,ValorDAO valorDAO) {
        this.cliente = cliente;
        this.valorController = valorController;
        this.valorDAO= valorDAO;
        initComponents();
        initComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    
    private void initComboBox(){
        
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        circulotp = new javax.swing.JRadioButton();
        quadradotp = new javax.swing.JRadioButton();
        triangulotp = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        quantidadetf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AdicionarPedido = new javax.swing.JButton();
        fecharBtn = new javax.swing.JButton();
        lbErroQuantidade = new javax.swing.JLabel();
        lbErroDimensao = new javax.swing.JLabel();
        dimensaotf = new javax.swing.JTextField();
        labelForma = new javax.swing.JLabel();
        lbErroItem = new javax.swing.JLabel();
        sabor2Cb = new javax.swing.JComboBox<>();
        sabor1Cb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lbErroSabor = new javax.swing.JLabel();
        ValorTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buscaItens = new javax.swing.JTextField();
        excluir = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        msgGenerica = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 350));
        jPanel1.setLayout(null);

        circulotp.setText("CIRCULO");
        circulotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circulotpActionPerformed(evt);
            }
        });
        jPanel1.add(circulotp);
        circulotp.setBounds(10, 30, 150, 21);

        quadradotp.setText("QUADRADO");
        quadradotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quadradotpActionPerformed(evt);
            }
        });
        jPanel1.add(quadradotp);
        quadradotp.setBounds(10, 60, 140, 21);

        triangulotp.setText("TRIÂNGULO");
        triangulotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangulotpActionPerformed(evt);
            }
        });
        jPanel1.add(triangulotp);
        triangulotp.setBounds(10, 90, 150, 21);

        jLabel1.setText("Forma:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 140, 16);

        jLabel2.setText("Quantidade (cm²):");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 70, 320, 16);
        jPanel1.add(quantidadetf);
        quantidadetf.setBounds(170, 90, 510, 22);

        jLabel3.setText("Sabor 2:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 220, 480, 16);

        AdicionarPedido.setText("ADICIONAR");
        AdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(AdicionarPedido);
        AdicionarPedido.setBounds(350, 310, 330, 23);

        fecharBtn.setText("CANCELAR");
        fecharBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharBtnActionPerformed(evt);
            }
        });
        jPanel1.add(fecharBtn);
        fecharBtn.setBounds(10, 310, 330, 23);

        lbErroQuantidade.setForeground(new java.awt.Color(255, 0, 0));
        lbErroQuantidade.setText("Valor inválido");
        jPanel1.add(lbErroQuantidade);
        lbErroQuantidade.setBounds(170, 110, 510, 16);

        lbErroDimensao.setForeground(new java.awt.Color(255, 0, 0));
        lbErroDimensao.setText("Valor inválido");
        jPanel1.add(lbErroDimensao);
        lbErroDimensao.setBounds(170, 50, 510, 16);
        jPanel1.add(dimensaotf);
        dimensaotf.setBounds(170, 30, 510, 22);

        labelForma.setText("Entre com o raio (cm):");
        jPanel1.add(labelForma);
        labelForma.setBounds(170, 10, 310, 16);

        lbErroItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbErroItem.setForeground(new java.awt.Color(255, 0, 0));
        lbErroItem.setText("POR FAVOR, SELECIONE UM ITEM CLICANDO NA LINHA");
        jPanel1.add(lbErroItem);
        lbErroItem.setBounds(10, 680, 370, 16);

        sabor2Cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sabor2CbActionPerformed(evt);
            }
        });
        jPanel1.add(sabor2Cb);
        sabor2Cb.setBounds(10, 240, 670, 22);

        sabor1Cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sabor1CbActionPerformed(evt);
            }
        });
        jPanel1.add(sabor1Cb);
        sabor1Cb.setBounds(10, 170, 670, 22);

        jLabel5.setText("Sabor 1:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 150, 480, 16);

        lbErroSabor.setForeground(new java.awt.Color(255, 0, 0));
        lbErroSabor.setText("Valor inválido");
        jPanel1.add(lbErroSabor);
        lbErroSabor.setBounds(10, 200, 480, 16);

        ValorTotal.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ValorTotal.setText("0.00");
        jPanel1.add(ValorTotal);
        ValorTotal.setBounds(430, 260, 250, 40);

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "ID", "SABOR 1", "TIPO", "SABOR 2", "TIPO", "FORMA", "VALOR ITEM"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 380, 550, 290);

        jLabel4.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jLabel4.setText("LISTAGEM DOS ITENS DO PEDIDO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 360, 270, 16);

        jLabel6.setText("BUSCA:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(300, 350, 60, 16);

        buscaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaItensActionPerformed(evt);
            }
        });
        jPanel1.add(buscaItens);
        buscaItens.setBounds(350, 350, 210, 22);

        excluir.setText("EXCLUIR");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        jPanel1.add(excluir);
        excluir.setBounds(570, 410, 110, 23);

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(570, 350, 110, 23);

        editar.setText("EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel1.add(editar);
        editar.setBounds(570, 380, 110, 23);

        msgGenerica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        msgGenerica.setForeground(new java.awt.Color(255, 0, 51));
        msgGenerica.setText("POR FAVOR, PREENCHA O CAMPO (RAIO/LADO) OU QUANTIDADE");
        jPanel1.add(msgGenerica);
        msgGenerica.setBounds(250, 140, 370, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(-3, -4, 700, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 59, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void circulotpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_circulotpActionPerformed
        dimensaotf.setText("");
        if (circulotp.isSelected())
            labelForma.setText("Entre com o raio (cm)");
    }// GEN-LAST:event_circulotpActionPerformed

    private void quadradotpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_quadradotpActionPerformed
        dimensaotf.setText("");
        if (quadradotp.isSelected())
            labelForma.setText("Entre com o lado (cm)");
    }// GEN-LAST:event_quadradotpActionPerformed

    private void triangulotpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_triangulotpActionPerformed
        dimensaotf.setText("");
        if (triangulotp.isSelected())
            labelForma.setText("Entre com o lado (cm)");
    }// GEN-LAST:event_triangulotpActionPerformed

    private void AdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AdicionarPedidoActionPerformed

    }// GEN-LAST:event_AdicionarPedidoActionPerformed

    private void fecharBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fecharBtnActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_fecharBtnActionPerformed

    private void sabor2CbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sabor2CbActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_sabor2CbActionPerformed

    private void sabor1CbActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sabor1CbActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_sabor1CbActionPerformed

    private void buscaItensActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscaItensActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_buscaItensActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_excluirActionPerformed

    }// GEN-LAST:event_excluirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarActionPerformed

    }// GEN-LAST:event_buscarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editarActionPerformed

    }// GEN-LAST:event_editarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoFormView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoFormView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoFormView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoFormView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // new PedidoFormView().setVisible(true);
        // }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarPedido;
    private javax.swing.JLabel ValorTotal;
    private javax.swing.JTextField buscaItens;
    private javax.swing.JButton buscar;
    private javax.swing.JRadioButton circulotp;
    private javax.swing.JTextField dimensaotf;
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton fecharBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelForma;
    private javax.swing.JLabel lbErroDimensao;
    private javax.swing.JLabel lbErroItem;
    private javax.swing.JLabel lbErroQuantidade;
    private javax.swing.JLabel lbErroSabor;
    private javax.swing.JLabel msgGenerica;
    private javax.swing.JRadioButton quadradotp;
    private javax.swing.JTextField quantidadetf;
    private javax.swing.JComboBox<String> sabor1Cb;
    private javax.swing.JComboBox<String> sabor2Cb;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JRadioButton triangulotp;
    // End of variables declaration//GEN-END:variables
}
