package org.example.Views.UserViews;

import org.example.Models.Entities.UserEntity;
import org.example.Models.Enumes.EnergyLables;
import org.example.Rules.RulesUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterEditView {
    private JPanel panel;
    JTextField username = new JTextField(10);
    JLabel usernameLabel = new JLabel("Username");
    JLabel usernameValidate = new JLabel("");


    JTextField email = new JTextField(10);
    JLabel emailLabel = new JLabel("Email");
    JLabel emailValidate = new JLabel("");

    JTextField phoneNumber = new JTextField(10);
    JLabel phoneNumberLabel = new JLabel("Phone");
    JLabel numberValidate = new JLabel("");

    JTextField password = new JTextField(10);
    JLabel passwordLabel =new JLabel("Password");
    JLabel passwordValidate = new JLabel("");

    JTextField idCard = new JTextField(10);
    JLabel idCardLabel = new JLabel("Id Card");
    JLabel idCardValidate = new JLabel("");


    JTextField bankName = new JTextField(10);
    JLabel bankNameLabel= new JLabel("Bank Name");
    JLabel bankNameValidate = new JLabel("");

    JTextField inventory = new JTextField(10);
    JLabel inventoryLabel = new JLabel("Inventory");
    JLabel inventoryValidate = new JLabel();

    JComboBox<String> rules;
    JLabel rulesLabel = new JLabel("Rule");

    JLabel cardBankTitle = new JLabel("Card  bank");

    JButton registerButton = new JButton("submit");
    public RegisterEditView(){
        panel = new JPanel(new BorderLayout());
        panel.setSize(new Dimension(500, 700));
        panel.setMaximumSize(new Dimension(200, 200));

        RulesUser[] energiesLabel = RulesUser.values();
        String[] StringEnergyLabels = new String[energiesLabel.length];
        for (int i = 0; i < energiesLabel.length; i++) {
            StringEnergyLabels[i] = energiesLabel[i].getStringValue();
        }
        rules = new JComboBox<>(StringEnergyLabels);

        JPanel formPanel = new JPanel(new GridLayout(11 ,2));
        formPanel.add(usernameLabel);
        formPanel.add(username);
        formPanel.add(usernameValidate);
        usernameValidate.setForeground(Color.RED);

        formPanel.add(emailLabel);
        formPanel.add(email);
        formPanel.add(emailValidate);
        emailValidate.setForeground(Color.RED);

        formPanel.add(phoneNumberLabel);
        formPanel.add(phoneNumber);
        formPanel.add(numberValidate);
        numberValidate.setForeground(Color.RED);


        formPanel.add(passwordLabel);
        formPanel.add(password);
        formPanel.add(passwordValidate);
        passwordValidate.setForeground(Color.RED);


        formPanel.add(cardBankTitle);
        formPanel.add(new JLabel());
        formPanel.add(new JLabel());

        formPanel.add(idCardLabel);
        formPanel.add(idCard);
        formPanel.add(idCardValidate);
        idCardValidate.setForeground(Color.RED);


        formPanel.add(bankNameLabel);
        formPanel.add(bankName);
        formPanel.add(bankNameValidate);
        bankNameValidate.setForeground(Color.RED);


        formPanel.add(inventoryLabel);
        formPanel.add(inventory);
        formPanel.add(inventoryValidate);
        inventoryValidate.setForeground(Color.RED);

        formPanel.add(rulesLabel);
        formPanel.add(rules);

        JPanel registerButtonPanel = new JPanel();
        registerButtonPanel.add(registerButton);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(registerButtonPanel, BorderLayout.SOUTH);
    }
    public RegisterEditView(UserEntity user){
        this();

        username.setText(user.getUserName());
        email.setText(user.getEmail());
        phoneNumber.setText(user.getNumberPhone());
        password.setText(user.getPassword());
        idCard.setText(Integer.toString(user.getCardBank().getIdCard()));
        bankName.setText(user.getCardBank().getBank());
        inventoryLabel.setText(Integer.toString(user.getCardBank().getInventory()) + "$ is and to Increase: ");
        inventory.setText("0");
        rules.setSelectedItem(user.getUserRule());
    }
    public JPanel getPanel(){
        System.out.println(panel);
        return panel;
    }

    public JComboBox<String> getRules() {
        return rules;
    }

    public void setRules(JComboBox<String> rules) {
        this.rules = rules;
    }

    public void setRegisterButton(ActionListener action)
    {
        registerButton.addActionListener(action);
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public JTextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(JTextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JTextField password) {
        this.password = password;
    }

    public JTextField getIdCard() {
        return idCard;
    }

    public void setIdCard(JTextField idCard) {
        this.idCard = idCard;
    }

    public JTextField getBankName() {
        return bankName;
    }

    public void setBankName(JTextField bankName) {
        this.bankName = bankName;
    }

    public JTextField getInventory() {
        return inventory;
    }

    public void setInventory(JTextField inventory) {
        this.inventory = inventory;
    }

    public void setUsernameValidate(String usernameValidate) {
        this.usernameValidate.setText(usernameValidate);
    }

    public void setEmailValidate(String emailValidate) {
        this.emailValidate.setText(emailValidate);
    }

    public void setNumberValidate(String  numberValidate) {
        this.numberValidate.setText(numberValidate);
    }

    public void setPasswordValidate(String passwordValidate) {
        this.passwordValidate.setText(passwordValidate);
    }

    public void setIdCardValidate(String idCardValidate) {
        this.idCardValidate.setText(idCardValidate);
    }

    public void setBankNameValidate(String bankNameValidate) {
        this.bankNameValidate.setText(bankNameValidate);
    }

    public void setInventoryValidate(String inventoryValidate) {
        this.inventoryValidate.setText(inventoryValidate);
    }
    public void clearTextFeilds (){
        usernameValidate.setText("");
        emailValidate.setText("");
        passwordValidate.setText("");
        numberValidate.setText("");
        idCardValidate.setText("");
        bankNameValidate.setText("");
        inventoryValidate.setText("");
        rules.setSelectedItem("");
    }
}
