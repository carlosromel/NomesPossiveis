/*
 * Copyleft (2014) Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
package br.eti.romel.lounge.nomespossiveis.gui;

import br.eti.romel.lounge.nomespossiveis.NomesPossiveis;
import br.eti.romel.lounge.nomespossiveis.Parametros;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Romel Pereira da Silva <carlos.romel@gmail.com>
 */
public class NomesPossiveisGUI extends javax.swing.JFrame {

    private static final String ESTADO = "NomesPossiveis.xml";
    List<String> nomes;
    List<String> nomesMaternos;
    List<String> nomesPaternos;
    Parametros parametros;

    public NomesPossiveisGUI() {
        initComponents();

        final File arquivoParametro = new File(ESTADO);

        this.parametros = new Parametros();

        if (arquivoParametro.canRead()) {
            try {
                this.parametros = (Parametros) new XStream().fromXML(arquivoParametro);

                String nomesParametros = this.parametros.getNomes().toString().replaceAll(", ", "\n");
                String nomesMaternosParametros = this.parametros.getNomesMaternos().toString().replaceAll(", ", "\n");
                String nomesPaternosParametros = this.parametros.getNomesPaternos().toString().replaceAll(", ", "\n");
                jepNomes.setText(nomesParametros.substring(1, nomesParametros.length() - 1));
                jepNomesMaternos.setText(nomesMaternosParametros.substring(1, nomesMaternosParametros.length() - 1));
                jepNomesPaternos.setText(nomesPaternosParametros.substring(1, nomesPaternosParametros.length() - 1));
                contarNomes();
            } catch (XStreamException | NullPointerException e) {
                String estado = e instanceof XStreamException ? "inconsistente" : "vazio";
                String mensagem = String.format("O arquivo de estado (%s) está %s e será removido.", ESTADO, estado);
                Logger.getLogger(NomesPossiveisGUI.class.getName()).log(Level.SEVERE, mensagem);

                arquivoParametro.deleteOnExit();
            }
        }

        jcbmiClassico.setSelected(true);
        jcbmiSingular.setSelected(false);
        jcbmiSingularPaterno.setSelected(false);
        jcbmiConservador.setSelected(false);
        jcbmiConservadorPaterno.setSelected(false);
        jlOpcaoGeracao.setText(jcbmiClassico.getText());
    }

    private void povoarParametros() {
        this.nomes = Arrays.asList(jepNomes.getText().split("\n"));
        this.nomesMaternos = Arrays.asList(jepNomesMaternos.getText().split("\n"));
        this.nomesPaternos = Arrays.asList(jepNomesPaternos.getText().split("\n"));

        this.parametros = new Parametros(this.nomes, this.nomesMaternos, this.nomesPaternos);
    }

    private void contarNomes() {
        jlQtdNomes.setText(Integer.toString(this.nomes.size()));
        jlQtdNomesMaternos.setText(Integer.toString(this.nomesMaternos.size()));
        jlQtdNomesPaternos.setText(Integer.toString(this.nomesPaternos.size()));
        jlQtdNomesGerados.setText(Integer.toString(jtaNomesGerados.getLineCount()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jbCombinar = new javax.swing.JButton();
        jlOpcoesNomes = new javax.swing.JLabel();
        jlFamiliaMaterna = new javax.swing.JLabel();
        jlFamiliaPaterna = new javax.swing.JLabel();
        jspOpcoesNomes = new javax.swing.JScrollPane();
        jepNomes = new javax.swing.JEditorPane();
        jspFamiliaMaterna = new javax.swing.JScrollPane();
        jepNomesMaternos = new javax.swing.JEditorPane();
        jspFamiliaPaterna = new javax.swing.JScrollPane();
        jepNomesPaternos = new javax.swing.JEditorPane();
        jspResultado = new javax.swing.JScrollPane();
        jtaNomesGerados = new javax.swing.JTextArea();
        jlOpcaoGeracao = new javax.swing.JLabel();
        jlOpcaoGeracaoSelecionado = new javax.swing.JLabel();
        jlQtdNomes = new javax.swing.JLabel();
        jlQtdNomesMaternos = new javax.swing.JLabel();
        jlQtdNomesPaternos = new javax.swing.JLabel();
        jlQtdNomesGerados = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jcbmiClassico = new javax.swing.JCheckBoxMenuItem();
        jcbmiSingular = new javax.swing.JCheckBoxMenuItem();
        jcbmiSingularPaterno = new javax.swing.JCheckBoxMenuItem();
        jcbmiConservador = new javax.swing.JCheckBoxMenuItem();
        jcbmiConservadorPaterno = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nomes possíveis");
        setResizable(false);

        jbCombinar.setText("Combinar!");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jepNomes, org.jdesktop.beansbinding.ObjectProperty.create(), jbCombinar, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        jbCombinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCombinarActionPerformed(evt);
            }
        });

        jlOpcoesNomes.setText("Opções de nomes");

        jlFamiliaMaterna.setText("Família materna");

        jlFamiliaPaterna.setText("Família paterna");

        jepNomes.setToolTipText("Informe os nomes para os quais desejaria trocar.");
        jepNomes.setFocusTraversalPolicy(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jepNomesMaternos, org.jdesktop.beansbinding.ObjectProperty.create(), jepNomes, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        jspOpcoesNomes.setViewportView(jepNomes);
        jepNomes.getAccessibleContext().setAccessibleName("");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jlFamiliaPaterna, org.jdesktop.beansbinding.ObjectProperty.create(), jepNomesMaternos, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        jspFamiliaMaterna.setViewportView(jepNomesMaternos);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtaNomesGerados, org.jdesktop.beansbinding.ObjectProperty.create(), jepNomesPaternos, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        jspFamiliaPaterna.setViewportView(jepNomesPaternos);

        jtaNomesGerados.setColumns(20);
        jtaNomesGerados.setRows(5);
        jtaNomesGerados.setFocusCycleRoot(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jbCombinar, org.jdesktop.beansbinding.ObjectProperty.create(), jtaNomesGerados, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        jspResultado.setViewportView(jtaNomesGerados);

        jlOpcaoGeracao.setText(" ");

        jlOpcaoGeracaoSelecionado.setText("Opção de geração de nomes:");

        jlQtdNomes.setText("0");

        jlQtdNomesMaternos.setText("0");

        jlQtdNomesPaternos.setText("0");

        jlQtdNomesGerados.setText("0");

        fileMenu.setMnemonic('f');
        fileMenu.setText("Arquivo");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("Opções");

        jcbmiClassico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jcbmiClassico.setSelected(true);
        jcbmiClassico.setText("Clássico");
        jcbmiClassico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmiClassicoActionPerformed(evt);
            }
        });
        jMenu1.add(jcbmiClassico);

        jcbmiSingular.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jcbmiSingular.setSelected(true);
        jcbmiSingular.setText("Singular (materno)");
        jcbmiSingular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmiSingularActionPerformed(evt);
            }
        });
        jMenu1.add(jcbmiSingular);

        jcbmiSingularPaterno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jcbmiSingularPaterno.setSelected(true);
        jcbmiSingularPaterno.setText("Singular paterno");
        jcbmiSingularPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmiSingularPaternoActionPerformed(evt);
            }
        });
        jMenu1.add(jcbmiSingularPaterno);

        jcbmiConservador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jcbmiConservador.setSelected(true);
        jcbmiConservador.setText("Conservador (materno, paterno)");
        jcbmiConservador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmiConservadorActionPerformed(evt);
            }
        });
        jMenu1.add(jcbmiConservador);

        jcbmiConservadorPaterno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jcbmiConservadorPaterno.setSelected(true);
        jcbmiConservadorPaterno.setText("Conservador (paterno, materno)");
        jcbmiConservadorPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmiConservadorPaternoActionPerformed(evt);
            }
        });
        jMenu1.add(jcbmiConservadorPaterno);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ajuda");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Sobre...");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jspResultado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlOpcoesNomes)
                                        .addGap(100, 100, 100)
                                        .addComponent(jlFamiliaMaterna)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlFamiliaPaterna))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlQtdNomes)
                                            .addComponent(jspOpcoesNomes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jspFamiliaMaterna, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlQtdNomesMaternos))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jspFamiliaPaterna, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 1, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jlQtdNomesPaternos))))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlOpcaoGeracaoSelecionado)
                                .addGap(18, 18, 18)
                                .addComponent(jlOpcaoGeracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbCombinar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlQtdNomesGerados)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlOpcoesNomes)
                    .addComponent(jlFamiliaMaterna)
                    .addComponent(jlFamiliaPaterna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jspFamiliaMaterna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jspOpcoesNomes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspFamiliaPaterna))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlQtdNomes)
                    .addComponent(jlQtdNomesMaternos)
                    .addComponent(jlQtdNomesPaternos))
                .addGap(1, 1, 1)
                .addComponent(jspResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlQtdNomesGerados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlOpcaoGeracao)
                    .addComponent(jlOpcaoGeracaoSelecionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCombinar)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        povoarParametros();
        try {
            new XStream().toXML(this.parametros, new FileWriter(ESTADO));
        } catch (IOException ex) {
            String mensagem = String.format("O arquivo (%s) não pode ser salvo.", ESTADO);
            Logger.getLogger(NomesPossiveisGUI.class.getName()).log(Level.SEVERE, mensagem, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jbCombinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCombinarActionPerformed
        povoarParametros();

        NomesPossiveis nomesPossiveis = new NomesPossiveis(this.nomes, this.nomesMaternos, this.nomesPaternos);
        nomesPossiveis.setClassico(jcbmiClassico.isSelected());
        nomesPossiveis.setSingular(jcbmiSingular.isSelected());
        nomesPossiveis.setSingularPaterno(jcbmiSingularPaterno.isSelected());
        nomesPossiveis.setConservador(jcbmiConservador.isSelected());
        nomesPossiveis.setConservadorPaterno(jcbmiConservadorPaterno.isSelected());

        jtaNomesGerados.setText(nomesPossiveis.obterPossibilidadesConcatenadas());

        contarNomes();
    }//GEN-LAST:event_jbCombinarActionPerformed

    private void jcbmiClassicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmiClassicoActionPerformed
        if (!jcbmiClassico.isSelected()) {
            jcbmiClassico.setSelected(true);
        }

        jcbmiSingular.setSelected(false);
        jcbmiSingularPaterno.setSelected(false);
        jcbmiConservador.setSelected(false);
        jcbmiConservadorPaterno.setSelected(false);

        jlOpcaoGeracao.setText(jcbmiClassico.getText());
        jbCombinarActionPerformed(evt);
    }//GEN-LAST:event_jcbmiClassicoActionPerformed

    private void jcbmiSingularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmiSingularActionPerformed
        jcbmiClassico.setSelected(false);

        if (!jcbmiSingular.isSelected()) {
            jcbmiSingular.setSelected(true);
        }

        jcbmiSingularPaterno.setSelected(false);
        jcbmiConservador.setSelected(false);
        jcbmiConservadorPaterno.setSelected(false);

        jlOpcaoGeracao.setText(jcbmiSingular.getText());
        jbCombinarActionPerformed(evt);
    }//GEN-LAST:event_jcbmiSingularActionPerformed

    private void jcbmiSingularPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmiSingularPaternoActionPerformed
        jcbmiClassico.setSelected(false);
        jcbmiSingular.setSelected(false);

        if (!jcbmiSingularPaterno.isSelected()) {
            jcbmiSingularPaterno.setSelected(true);
        }

        jcbmiConservador.setSelected(false);
        jcbmiConservadorPaterno.setSelected(false);

        jlOpcaoGeracao.setText(jcbmiSingularPaterno.getText());
        jbCombinarActionPerformed(evt);
    }//GEN-LAST:event_jcbmiSingularPaternoActionPerformed

    private void jcbmiConservadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmiConservadorActionPerformed
        jcbmiClassico.setSelected(false);
        jcbmiSingular.setSelected(false);
        jcbmiSingularPaterno.setSelected(false);

        if (!jcbmiConservador.isSelected()) {
            jcbmiConservador.setSelected(true);
        }

        jcbmiConservadorPaterno.setSelected(false);

        jlOpcaoGeracao.setText(jcbmiConservador.getText());
        jbCombinarActionPerformed(evt);
    }//GEN-LAST:event_jcbmiConservadorActionPerformed

    private void jcbmiConservadorPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmiConservadorPaternoActionPerformed
        jcbmiClassico.setSelected(false);
        jcbmiSingular.setSelected(false);
        jcbmiSingularPaterno.setSelected(false);
        jcbmiConservador.setSelected(false);

        if (!jcbmiConservadorPaterno.isSelected()) {
            jcbmiConservadorPaterno.setSelected(true);
        }

        jlOpcaoGeracao.setText(jcbmiConservadorPaterno.getText());
        jbCombinarActionPerformed(evt);
    }//GEN-LAST:event_jcbmiConservadorPaternoActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed

        Sobre sobre = new Sobre(new JFrame(), true);
        sobre.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                this.windowDeactivated(null);
            }
        });

        sobre.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NomesPossiveisGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NomesPossiveisGUI().setVisible(true);
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc=" Variables declaration - do not modify ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JButton jbCombinar;
    private javax.swing.JCheckBoxMenuItem jcbmiClassico;
    private javax.swing.JCheckBoxMenuItem jcbmiConservador;
    private javax.swing.JCheckBoxMenuItem jcbmiConservadorPaterno;
    private javax.swing.JCheckBoxMenuItem jcbmiSingular;
    private javax.swing.JCheckBoxMenuItem jcbmiSingularPaterno;
    private javax.swing.JEditorPane jepNomes;
    private javax.swing.JEditorPane jepNomesMaternos;
    private javax.swing.JEditorPane jepNomesPaternos;
    private javax.swing.JLabel jlFamiliaMaterna;
    private javax.swing.JLabel jlFamiliaPaterna;
    private javax.swing.JLabel jlOpcaoGeracao;
    private javax.swing.JLabel jlOpcaoGeracaoSelecionado;
    private javax.swing.JLabel jlOpcoesNomes;
    private javax.swing.JLabel jlQtdNomes;
    private javax.swing.JLabel jlQtdNomesGerados;
    private javax.swing.JLabel jlQtdNomesMaternos;
    private javax.swing.JLabel jlQtdNomesPaternos;
    private javax.swing.JScrollPane jspFamiliaMaterna;
    private javax.swing.JScrollPane jspFamiliaPaterna;
    private javax.swing.JScrollPane jspOpcoesNomes;
    private javax.swing.JScrollPane jspResultado;
    private javax.swing.JTextArea jtaNomesGerados;
    private javax.swing.JMenuBar menuBar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
