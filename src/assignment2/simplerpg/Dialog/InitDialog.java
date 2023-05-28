package assignment2.simplerpg.Dialog;

import javax.swing.*;
import java.awt.*;

public class InitDialog extends JDialog {

    private String name = "";

    public InitDialog (JFrame frame) {
        /*
         * @para 1 Parent object
         * @para 2 Dialog title
         * @para 3 Block parent window
         */
        super(frame, "Please enter your name", true);

        Container c = getContentPane();
        JLabel label = new JLabel("Please enter your name");
        c.add(label, BorderLayout.NORTH);

        JTextField nameField = new JTextField();
        c.add(nameField, BorderLayout.CENTER);

        JButton confirmButton = new JButton("Confirm");
        // Close value when click
        confirmButton.addActionListener(e -> {
            JButton b = (JButton) e.getSource();
            JDialog dialog = (JDialog) b.getRootPane().getParent();
            name = nameField.getText();
            dialog.dispose();
        });
        c.add(confirmButton, BorderLayout.SOUTH);

        setBounds(400, 300, 350, 200);
    }

    public String getName() {
        return name.trim();
    }
}
