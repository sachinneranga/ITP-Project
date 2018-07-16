package Interface;

public class WelcomePage extends javax.swing.JInternalFrame {

    public WelcomePage() {

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1066, 628));
        getContentPane().setLayout(null);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1058, 598));
        background.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Welcomepage.jpg"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(1058, 598));
        background.add(jLabel5);
        jLabel5.setBounds(0, 0, 1058, 598);

        getContentPane().add(background);
        background.setBounds(0, 0, 1058, 598);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
