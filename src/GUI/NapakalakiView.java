/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author DiegoJesús
 */
import napakalaki.CombatResult;
import napakalaki.Napakalaki;

public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;

    public NapakalakiView() {
        initComponents();
    }

    public void setNapakalaki(Napakalaki napakalaki) {

        this.napakalakiModel = napakalaki;

        //Actualizamos las vistas de Player y Monster
        playerView.setNapakalaki(napakalaki);
        playerView.setPlayer(napakalaki.getCurrentPlayer());
        monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        
        //Ponemos el panel de monstruo, y los botones a NO visibles
        monsterView1.setVisible(false);
        BCombat.setEnabled(false);
        BNextTurn.setEnabled(false);

        JResultado.setText("????");

        repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monsterView1 = new GUI.MonsterView();
        BMeetTheMonster = new javax.swing.JButton();
        BCombat = new javax.swing.JButton();
        BNextTurn = new javax.swing.JButton();
        ResultadoEnum = new javax.swing.JLabel();
        JResultado = new javax.swing.JLabel();
        playerView = new GUI.PlayerView();
        JInformacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        monsterView1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)), "Monstruo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Virtual DJ", 2, 14))); // NOI18N

        BMeetTheMonster.setText("MeetMonster");
        BMeetTheMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMeetTheMonsterActionPerformed(evt);
            }
        });

        BCombat.setText("Combat");
        BCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCombatActionPerformed(evt);
            }
        });

        BNextTurn.setText("NextTurn");
        BNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNextTurnActionPerformed(evt);
            }
        });

        ResultadoEnum.setText("Resultado del combate:");

        JResultado.setText("????");

        playerView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 0)), "Jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Virtual DJ", 2, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BCombat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BMeetTheMonster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                    .addComponent(ResultadoEnum))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JResultado)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(JInformacion)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(BMeetTheMonster)
                        .addGap(18, 18, 18)
                        .addComponent(BCombat)
                        .addGap(18, 18, 18)
                        .addComponent(BNextTurn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JInformacion)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ResultadoEnum)
                            .addComponent(JResultado))
                        .addGap(18, 18, 18)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BMeetTheMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMeetTheMonsterActionPerformed
        //Activamos Boton de combate y la vista del mostruo
        monsterView1.setVisible(true);
        BCombat.setEnabled(true);
        
        //Activamos botones de la clase Player
        playerView.disableEquiparTesoros();
        playerView.disableRobarTesoros();
        repaint();
    }//GEN-LAST:event_BMeetTheMonsterActionPerformed

    private void BCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCombatActionPerformed
        CombatResult result;
        result = napakalakiModel.developCombat();

        JResultado.setText(result + "");
        
        //Activamos botones de SiguienteMonstruo y desactivamos conocerMonstruo y Combatir
        BNextTurn.setEnabled(true);
        BMeetTheMonster.setEnabled(false);
        BCombat.setEnabled(false);
        
        //Desactivamos los botones de la vista Player
        playerView.enableEquiparTesoros();
        playerView.enableRobarTesoros();

        repaint();

        //playerView.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_BCombatActionPerformed

    private void BNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNextTurnActionPerformed

        boolean sigTurn = napakalakiModel.nextTurn();

        if (sigTurn) //Si hemos podido pasar el turno
        {
            //Actualizamos el jugador por el nuevo y el monstruo por el nuevo
            playerView.setPlayer(napakalakiModel.getCurrentPlayer());
            monsterView1.setMonster(napakalakiModel.getCurrentMonster());
            BNextTurn.setEnabled(false); //Volvemos a ocultar el boton de siguente turno
            BMeetTheMonster.setEnabled(true); //Ponemos el meet monster button a true para el siguiente jugador
            monsterView1.setVisible(false); // Si seguimos el turno ocultamos el monstruo
            BCombat.setEnabled(false);
            JResultado.setText("????");
            JInformacion.setText("");
        } else {
            if (JResultado.getText() == "Win") { //Corregir
                JInformacion.setText("Solo puedes tener 4 tesoros ocultos.");
            } else {
                JInformacion.setText("¡Debes cumplir el mal royo!");
            }
        }
        repaint();
    }//GEN-LAST:event_BNextTurnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCombat;
    private javax.swing.JButton BMeetTheMonster;
    private javax.swing.JButton BNextTurn;
    private javax.swing.JLabel JInformacion;
    private javax.swing.JLabel JResultado;
    private javax.swing.JLabel ResultadoEnum;
    private GUI.MonsterView monsterView1;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
