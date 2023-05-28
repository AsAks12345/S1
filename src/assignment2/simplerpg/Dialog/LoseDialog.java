package assignment2.simplerpg.Dialog;

import javax.swing.*;
import java.awt.*;

public class LoseDialog extends JDialog {
    public LoseDialog (JFrame frame) {
        /*
         * @para 1 Parent object
         * @para 2 Dialog title
         * @para 3 Block parent window
         */
        super(frame, "Sorry", true);

        Container c = getContentPane();
        JLabel label = new JLabel("YOU Lost !!!");
        c.add(label, BorderLayout.NORTH);

        JButton confirmButton = new JButton("Confirm");
        // Close value when click
        confirmButton.addActionListener(e -> {
            JButton b = (JButton) e.getSource();
            JDialog dialog = (JDialog) b.getRootPane().getParent();
            dialog.dispose();
        });
        c.add(confirmButton, BorderLayout.SOUTH);

        setBounds(400, 300, 300, 160);
    }
}
