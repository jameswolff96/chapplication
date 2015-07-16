/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapplication.gui;

import chapplication.util.FrameController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author james.wolff
 * @date Sep 11, 2013
 */
public class ChapplicationGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212505495157869751L;
	public Thread waitingThread;
    /**
     * Creates new form ChapplicationGUI
     */
    public ChapplicationGUI() {
        preInit();
        initComponents();
        postInit();
    }

    private void preInit(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChapplicationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        username="Guest";
    }
    
    private void postInit(){
        inputTextField.setVisible(false);
        sendJoinButton.setVisible(false);
        userListArray=new ArrayList<>();
        userListArray.add(userListTextArea.getText());
        setLoggedIn(false);
        fileMenu.remove(changePassMenuItem);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        inputTextField = new javax.swing.JTextField();
        statusButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        sendJoinButton = new javax.swing.JButton();
        userListTextAreaScrollPane = new javax.swing.JScrollPane();
        userListTextArea = new javax.swing.JTextArea();
        chatBoxTextAreaScrollPane = new javax.swing.JScrollPane();
        chatBoxTextArea = new javax.swing.JTextArea();
        quitButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        changePassMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chapplication");
        setForeground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(153, 153, 153));

        inputTextField.setBackground(new java.awt.Color(102, 102, 102));
        inputTextField.setForeground(new java.awt.Color(204, 204, 204));
        inputTextField.setText("Say something...");
        inputTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTextFieldFocusLost(evt);
            }
        });
        inputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputTextFieldKeyReleased(evt);
            }
        });

        statusButton.setBackground(new java.awt.Color(51, 51, 51));
        statusButton.setText("Sign In");
        statusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                statusButtonMouseReleased(evt);
            }
        });

        usernameLabel.setText(username);

        sendJoinButton.setBackground(new java.awt.Color(51, 51, 51));
        sendJoinButton.setText("Join");
        sendJoinButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseReleased(java.awt.event.MouseEvent evt) {
        		sendJoinButtonMouseReleased(evt);
        	}
        });

        userListTextAreaScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        userListTextArea.setEditable(false);
        userListTextArea.setBackground(new java.awt.Color(102, 102, 102));
        userListTextArea.setColumns(20);
        userListTextArea.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        userListTextArea.setForeground(new java.awt.Color(153, 0, 0));
        userListTextArea.setRows(5);
        userListTextArea.setText("User List:");
        userListTextArea.setWrapStyleWord(true);
        userListTextArea.setName("User List: "); // NOI18N
        userListTextAreaScrollPane.setViewportView(userListTextArea);

        chatBoxTextAreaScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        chatBoxTextArea.setEditable(false);
        chatBoxTextArea.setBackground(new java.awt.Color(102, 102, 102));
        chatBoxTextArea.setColumns(20);
        chatBoxTextArea.setForeground(new java.awt.Color(96, 233, 37));
        chatBoxTextArea.setRows(5);
        chatBoxTextArea.setText("Something");
        chatBoxTextArea.setWrapStyleWord(true);
        chatBoxTextAreaScrollPane.setViewportView(chatBoxTextArea);

        quitButton.setBackground(new java.awt.Color(51, 51, 51));
        quitButton.setText("Quit");
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                quitButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userListTextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatBoxTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameLabel)
                        .addComponent(statusButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(quitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sendJoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chatBoxTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userListTextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(235, 235, 235)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(statusButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(quitButton)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(inputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(sendJoinButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        fileMenu.setText("File");

        helpMenuItem.setText("Help");
        fileMenu.add(helpMenuItem);

        changePassMenuItem.setText("Change Password");
        changePassMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changePassMenuItemMouseReleased(evt);
            }
        });
        fileMenu.add(changePassMenuItem);

        quitMenuItem.setText("Quit");
        quitMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                quitMenuItemMouseReleased(evt);
            }
        });
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(100, 100, 515, 392);
    }// </editor-fold>//GEN-END:initComponents
    public static void setUsername(String name){
        username=name;
    }
    public static void setLoggedIn(boolean b){
        loggedIn=b;
    }
    public static void joinServer(String server){
        
    }
    private void statusButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusButtonMouseReleased
        if(usernameLabel.getText().equalsIgnoreCase("guest")){
            FrameController.getLg().setVisible(true);
            waitingThread = new Thread(new Runnable(){
                 @Override
                 public void run(){
                	 try {
                         synchronized(waitingThread){
                             waitingThread.wait();
                         }
                     } catch (InterruptedException ex) {
                     }
                     if(loggedIn){
                         inputTextField.setVisible(true);
                         sendJoinButton.setVisible(true);
                         usernameLabel.setText(username);
                         FrameController.getLg().setVisible(false);
                         statusButton.setText("Sign Out");
                         userListArray.add("\n"+username);
                         userListTextArea.append("\n"+username);
                     }
                 }
            });
            waitingThread.start();
        }else{
            inputTextField.setVisible(false);
            sendJoinButton.setVisible(false);
            userListArray.remove("\n"+username);
            userListTextArea.setText("");
            for(String s:userListArray){
                userListTextArea.append(s);
            }
            setUsername("Guest");
            setLoggedIn(false);
            usernameLabel.setText(username);
            statusButton.setText("Sign In");
            toggleCPMI(false);
        }
    }//GEN-LAST:event_statusButtonMouseReleased

    private void quitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitButtonMouseReleased
        int confirm = JOptionPane.showOptionDialog(null,"Are You Sure to Close this Application?","Exit Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }//GEN-LAST:event_quitButtonMouseReleased

    private void inputTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTextFieldFocusGained
        if(inputTextField.getText().equals("Say something...")){
            inputTextField.setText(null);
        }
    }//GEN-LAST:event_inputTextFieldFocusGained

    private void inputTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputTextFieldFocusLost
        if(inputTextField.getText().equals("")){
            inputTextField.setText("Say something...");
        }
    }//GEN-LAST:event_inputTextFieldFocusLost

    private void quitMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitMenuItemMouseReleased
        int confirm = JOptionPane.showOptionDialog(null,"Are You Sure to Close this Application?","Exit Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }//GEN-LAST:event_quitMenuItemMouseReleased

    private void changePassMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMenuItemMouseReleased
        FrameController.getCpg().setVisible(true);
    }//GEN-LAST:event_changePassMenuItemMouseReleased

    private void inputTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextFieldKeyReleased
        if(evt.getKeyChar()=='\n'){
            if(!(inputTextField.getText().equals(new String()))){
                if(chatBoxTextArea.getText().equals("Something")){
                    chatBoxTextArea.setText(username+": "+inputTextField.getText());
                }else{
                    chatBoxTextArea.append("\n"+username+": "+inputTextField.getText());
                }
            }
            inputTextField.setText(null);
        }
    }//GEN-LAST:event_inputTextFieldKeyReleased
    
    private void sendJoinButtonMouseReleased(java.awt.event.MouseEvent evt) {
    	if(sendJoinButton.getText().equalsIgnoreCase("join")) {
    		
    	}
    }

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        int confirm = JOptionPane.showOptionDialog(null,"Are You Sure to Close this Application?","Exit Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }//GEN-LAST:event_quitMenuItemActionPerformed
 
    private boolean post(String message){
        //chatArea.append(username+": "+message);
        return false;
    }
    
    public static String getCurrentUser(){
        return username;
    }
    
    public void toggleCPMI(boolean b){
        if(b){
            fileMenu.remove(quitMenuItem);
            fileMenu.add(changePassMenuItem);
            fileMenu.add(quitMenuItem);
        }else{
            fileMenu.remove(changePassMenuItem);
        }
    }
    
    private static String username;
    private static boolean loggedIn;
    private static ArrayList<String> userListArray;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changePassMenuItem;
    private javax.swing.JTextArea chatBoxTextArea;
    private javax.swing.JScrollPane chatBoxTextAreaScrollPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton quitButton;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JButton sendJoinButton;
    private javax.swing.JButton statusButton;
    private javax.swing.JTextArea userListTextArea;
    private javax.swing.JScrollPane userListTextAreaScrollPane;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
