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

        JTextField nameField = new JTextField();
        c.add(nameField, BorderLayout.CENTER);
        nameField.setPreferredSize(new Dimension(300, 80));

        JButton confirmButton = new JButton("Confirm");
        // Close value when click
        confirmButton.addActionListener(e -> {
            JButton b = (JButton) e.getSource();
            JDialog dialog = (JDialog) b.getRootPane().getParent();
            name = nameField.getText();
            dialog.dispose();
        });
        c.add(confirmButton, BorderLayout.SOUTH);
        confirmButton.setPreferredSize(new Dimension(300, 60));

        setBounds(400, 300, 350, 200);
    }

    public String getName() {
        return name.trim();
    }
}
