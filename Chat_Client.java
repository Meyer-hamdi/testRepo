/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author EGYPT
 */
public class Chat_Client extends javax.swing.JFrame {

    /**
     * Creates new form Chat_Client
     * mfesh server socket hena 3alashan mfesh 7aga htst2blha hna 
     */static Socket client;
       static DataInputStream din;//yst2ble 
       
       static DataOutputStream dout;//yb3t
     
    public Chat_Client() { 
        initComponents();  //iniilazation l kol el componants el fe code 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Msg_Area = new javax.swing.JTextArea();
        Msg_Text = new javax.swing.JTextField();
        Msg_Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Msg_Area.setColumns(20);
        Msg_Area.setRows(5);
        jScrollPane1.setViewportView(Msg_Area);

        Msg_Text.setText("jTextField1");
        Msg_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Msg_TextActionPerformed(evt);
            }
        });

        Msg_Send.setText("jButton1");
        Msg_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Msg_SendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Msg_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Msg_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Msg_Send, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(Msg_Text)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Msg_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Msg_SendActionPerformed
try { 
    String Msgout = "";       
    Msgout = Msg_Text.getText().trim(); 
    dout.writeUTF(Msgout);// 3alashan tktb ay kalam b2y lo8a 
    
}
catch (Exception e)
{        }
// TODO add your handling code here:
    }//GEN-LAST:event_Msg_SendActionPerformed

    private void Msg_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Msg_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Msg_TextActionPerformed

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(Chat_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat_Client().setVisible(true);
            }
        });
        try
        { client = new Socket("192.168.1.9",1201); //ip num of gehaz and port
         din = new DataInputStream(client.getInputStream());
         dout = new DataOutputStream(client.getOutputStream());
         String Msgin = " ";
        while(!Msgin.equals("Exit"))
        { Msgin= din.readUTF();
        Msg_Area.setText(Msg_Area.getText().trim()+"\n Server : \t" +Msgin);
        }
        }catch(Exception e)
                {
                }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea Msg_Area;
    private javax.swing.JButton Msg_Send;
    private javax.swing.JTextField Msg_Text;
    private javax.swing.JScrollPane jScrollPane1;
    
// End of variables declaration//GEN-END:variables
}
