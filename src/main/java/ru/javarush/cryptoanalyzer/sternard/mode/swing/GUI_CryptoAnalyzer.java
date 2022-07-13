package ru.javarush.cryptoanalyzer.sternard.mode.swing;

import ru.javarush.cryptoanalyzer.sternard.application.EActions;
import ru.javarush.cryptoanalyzer.sternard.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ru.javarush.cryptoanalyzer.sternard.constant.Settings.*;
import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.*;

public class GUI_CryptoAnalyzer extends JFrame {
    private final JTextField inputSourceFileName = new JTextField(SOURCE_FILENAME, 25);
    private final JTextField inputDestinationFileName = new JTextField(ENCRYPTED_FILENAME, 25);
    private final JTextField inputKey = new JTextField("3", 5);
    private final JLabel labelKey = new JLabel(ENTER_KEY);
    private final JRadioButton radioEncrypt = new JRadioButton(ENCRYPT_WITH_KEY);
    private final JRadioButton radioDecrypt = new JRadioButton(DECRYPT_WITH_KEY);

    public GUI_CryptoAnalyzer() {
        super(PROJECT_NAME);
        super.setBounds(600, 200, 200, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(11, 1, 3, 3));

        JRadioButton radioBruteForceDec = new JRadioButton(BRUTE_FORCE_DECRYPTION);
        JLabel labelSourceFileName = new JLabel(SOURCE_FILE_NAME);
        JLabel labelDestinationFileName = new JLabel(DESTINATION_FILE_NAME);
        JButton button = new JButton(BUTTON_NAME);

        ButtonGroup group = new ButtonGroup();
        group.add(radioEncrypt);
        group.add(radioDecrypt);
        group.add(radioBruteForceDec);

        container.add(labelSourceFileName);
        container.add(inputSourceFileName);
        container.add(labelDestinationFileName);
        container.add(inputDestinationFileName);
        container.add(labelKey);
        container.add(inputKey);
        container.add(radioEncrypt);
        container.add(radioDecrypt);
        container.add(radioBruteForceDec);
        container.add(button);

        RadioEventListener radioEventListener = new RadioEventListener();
        ButtonEventListener buttonEventListener = new ButtonEventListener();

        radioEncrypt.setSelected(true);
        radioEncrypt.addActionListener(radioEventListener);
        radioDecrypt.addActionListener(radioEventListener);
        radioBruteForceDec.addActionListener(radioEventListener);
        button.addActionListener(buttonEventListener);

        pack();
    }


    class RadioEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (radioEncrypt.isSelected()) {
                inputSourceFileName.setText(SOURCE_FILENAME);
                inputDestinationFileName.setText(ENCRYPTED_FILENAME);
                inputKey.setVisible(true);
                labelKey.setVisible(true);
            } else if (radioDecrypt.isSelected()) {
                inputSourceFileName.setText(ENCRYPTED_FILENAME);
                inputDestinationFileName.setText(DECRYPTED_FILENAME);
                inputKey.setVisible(true);
                labelKey.setVisible(true);
            } else {
                inputSourceFileName.setText(ENCRYPTED_FILENAME);
                inputDestinationFileName.setText(DECRYPTED_FILENAME);
                inputKey.setVisible(false);
                labelKey.setVisible(false);
            }
        }
    }


    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String action;
            String sourceFileName = inputSourceFileName.getText();
            String destinationFileName = inputDestinationFileName.getText();
            String[] args;

            if (radioEncrypt.isSelected() || radioDecrypt.isSelected()) {
                String key = inputKey.getText();
                action = (radioEncrypt.isSelected()) ? EActions.ENCRYPTION.name() : EActions.KEY_DECRYPTION.name();
                args = new String[]{action, sourceFileName, destinationFileName, key};
            } else {
                action = EActions.BRUTE_FORCE_DECRYPTION.name();
                args = new String[]{action, sourceFileName, destinationFileName};
            }

            Controller controller = new Controller();
            JOptionPane.showMessageDialog(null, controller.execute(
                            controller.checkParameters(args)).getMessage(),
                    PROJECT_NAME, JOptionPane.PLAIN_MESSAGE);
        }
    }


}