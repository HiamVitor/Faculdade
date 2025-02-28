/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author leona
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        frameVendas = new javax.swing.JMenuItem();
        frameCliente = new javax.swing.JMenuItem();
        frameVendedor = new javax.swing.JMenuItem();
        frameVendas1 = new javax.swing.JMenuItem();
        frameVeiculo = new javax.swing.JMenuItem();
        frameMarcas = new javax.swing.JMenuItem();
        frameModelo = new javax.swing.JMenuItem();
        framePagamentos = new javax.swing.JMenuItem();
        frameCidade = new javax.swing.JMenuItem();
        frameAcessorios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jMenu1.setText("Arquivos");

        frameVendas.setText("Vendas");
        frameVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameVendasActionPerformed(evt);
            }
        });
        jMenu1.add(frameVendas);

        frameCliente.setText("Cliente");
        frameCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameClienteActionPerformed(evt);
            }
        });
        jMenu1.add(frameCliente);

        frameVendedor.setText("Vendedor");
        frameVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameVendedorActionPerformed(evt);
            }
        });
        jMenu1.add(frameVendedor);

        frameVendas1.setText("Acessorios do Veiculo");
        frameVendas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameVendas1ActionPerformed(evt);
            }
        });
        jMenu1.add(frameVendas1);

        frameVeiculo.setText("Veiculo");
        frameVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameVeiculoActionPerformed(evt);
            }
        });
        jMenu1.add(frameVeiculo);

        frameMarcas.setText("Marcas");
        frameMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameMarcasActionPerformed(evt);
            }
        });
        jMenu1.add(frameMarcas);

        frameModelo.setText("Modelo");
        frameModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameModeloActionPerformed(evt);
            }
        });
        jMenu1.add(frameModelo);

        framePagamentos.setText("Formas Pagto");
        framePagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                framePagamentosActionPerformed(evt);
            }
        });
        jMenu1.add(framePagamentos);

        frameCidade.setText("Cidade");
        frameCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameCidadeActionPerformed(evt);
            }
        });
        jMenu1.add(frameCidade);

        frameAcessorios.setText("Acessorios");
        frameAcessorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frameAcessoriosActionPerformed(evt);
            }
        });
        jMenu1.add(frameAcessorios);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void frameClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameClienteActionPerformed
        new dialogCliente(this, true).setVisible(true);
    }//GEN-LAST:event_frameClienteActionPerformed

    private void frameVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameVendedorActionPerformed
        new dialogVendedor(this, true).setVisible(true);
    }//GEN-LAST:event_frameVendedorActionPerformed

    private void frameMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameMarcasActionPerformed
        new dialogMarca(this, true).setVisible(true);
    }//GEN-LAST:event_frameMarcasActionPerformed

    private void frameModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameModeloActionPerformed
        new dialogModelo(this, true).setVisible(true);
    }//GEN-LAST:event_frameModeloActionPerformed

    private void framePagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_framePagamentosActionPerformed
        new dialogPagamentos(this, true).setVisible(true);
    }//GEN-LAST:event_framePagamentosActionPerformed

    private void frameVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameVendasActionPerformed
        new dialogVenda(this, true).setVisible(true);
    }//GEN-LAST:event_frameVendasActionPerformed

    private void frameCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameCidadeActionPerformed
        new dialogCidade(this, true).setVisible(true);
    }//GEN-LAST:event_frameCidadeActionPerformed

    private void frameVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameVeiculoActionPerformed
        new dialogVeiculo(this, true).setVisible(true);
    }//GEN-LAST:event_frameVeiculoActionPerformed

    private void frameAcessoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameAcessoriosActionPerformed
        new dialogAcessorios(this, true).setVisible(true);
    }//GEN-LAST:event_frameAcessoriosActionPerformed

    private void frameVendas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frameVendas1ActionPerformed
        // TODO add your handling code here:
        new dialogItensVeiculo(this, true).setVisible(true);
    }//GEN-LAST:event_frameVendas1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem frameAcessorios;
    private javax.swing.JMenuItem frameCidade;
    private javax.swing.JMenuItem frameCliente;
    private javax.swing.JMenuItem frameMarcas;
    private javax.swing.JMenuItem frameModelo;
    private javax.swing.JMenuItem framePagamentos;
    private javax.swing.JMenuItem frameVeiculo;
    private javax.swing.JMenuItem frameVendas;
    private javax.swing.JMenuItem frameVendas1;
    private javax.swing.JMenuItem frameVendedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
