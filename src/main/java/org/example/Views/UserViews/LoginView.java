package org.example.Views.UserViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView {
    private JPanel panel;
    private JTextField username;
    private JLabel usernameLabel;
    private JLabel validateUsername = new JLabel("");
    private JPasswordField password;
    private JLabel passwordLabel;
    private JLabel validatePassword = new JLabel("");
    private JButton loginButton;
    public LoginView(){
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        username = new JTextField(20);
        password = new JPasswordField(20);
        passwordLabel = new JLabel("Password");
        usernameLabel = new JLabel("User name");
        loginButton = new JButton("login");
        JPanel panelLoginButton = new JPanel();
        panelLoginButton.add(loginButton);


        loginButton.setPreferredSize(new Dimension(70, 50));
        loginButton.setMaximumSize(new Dimension(100, 70));

            JPanel userNamePanel = new JPanel(new FlowLayout());
            FlowLayout layoutUserName = (FlowLayout) userNamePanel.getLayout();
            layoutUserName.setHgap(10);
            layoutUserName.setVgap(10);
            userNamePanel.add(usernameLabel);
            userNamePanel.add(username);
            validateUsername.setForeground(Color.RED);

            JPanel passwordPanel = new JPanel(new FlowLayout());
            FlowLayout layoutPassword = (FlowLayout) passwordPanel.getLayout();
            layoutPassword.setHgap(10);
            layoutPassword.setVgap(10);
            passwordPanel.add(passwordLabel);
            passwordPanel.add(password);
            validatePassword.setForeground(Color.RED);

            JPanel loginPanel = new JPanel(new GridLayout(5,1));
            loginPanel.setPreferredSize(new Dimension(100, 400));
            loginPanel.add(userNamePanel);
            loginPanel.add(validateUsername);
            loginPanel.add(passwordPanel);
            loginPanel.add(validatePassword );


            loginPanel.add(panelLoginButton);

        panel.add(loginPanel, BorderLayout.CENTER);

    }


    public void actionListernerLogin(ActionListener action){
        this.loginButton.addActionListener(action);
    }
    public JPanel getPanel(){
        return  panel;
    }

    public JTextField getUsername() {
        return username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JLabel getValidateUsername() {
        return validateUsername;
    }

    public void setValidateUsername(String validateUsername) {
        this.validateUsername.setText(validateUsername);
    }

    public JLabel getValidatePassword() {
        return validatePassword;
    }

    public void setValidatePassword(String validatePassword) {
        this.validatePassword.setText(validatePassword);
    }
}
