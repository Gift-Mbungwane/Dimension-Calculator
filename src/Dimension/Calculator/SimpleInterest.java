package Dimension.Calculator;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SimpleInterest extends JFrame{
    private JTextField principal = new JTextField();
    private JTextField rate = new JTextField();
    private JTextField time = new JTextField();
    private JTextField simpleInterest = new JTextField();
    // calculate JButton
    private JButton clear = new JButton("Clear");
    private JButton calculate = new JButton("Calculate");
    //private JButton clear = new JButton("Clear");
    //create JTextArea
    JTextArea area = new JTextArea(1, 1);

    public SimpleInterest() {
        // panel panel to hold labels and text fields
        JPanel panel1 = new JPanel(new GridLayout(5, 2));
        panel1.add(new JLabel("Enter Principal"));
        panel1.add(principal);
        panel1.add(new JLabel("Enter Rate in percentage"));
        panel1.add(rate);
        panel1.add(new JLabel("Enter the number of year"));
        panel1.add(time);
        panel1.add(new JLabel("Simple Interest"));
        panel1.add(simpleInterest);
        panel1.setBorder(new TitledBorder(""));

        principal.setBorder(BorderFactory.createEtchedBorder());
        rate.setBorder(BorderFactory.createEtchedBorder());
        time.setBorder(BorderFactory.createEtchedBorder());
        simpleInterest.setBorder(BorderFactory.createEtchedBorder());
        simpleInterest.setEditable(false);
        simpleInterest.setForeground(Color.RED);

        // Panel p2 to hold the button
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        //panel2.add(clear);
        panel2.add(clear);
        panel2.add(calculate);

        // Add the panels to the frame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        area.setForeground(Color.BLACK);
        area.setBackground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                try {
                    double amount = Double.parseDouble(principal.getText());
                    double rateOfInterest = Double.parseDouble(rate.getText());
                    double year = Double.parseDouble(time.getText());



                    String interest = "R" + (amount * (1 + (rateOfInterest/100 * year)));
                    // Display simple interest
                    simpleInterest.setText((interest));
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR: " + (f.getMessage()));
                }

                String amountField = principal.getText();
                String rateOfInterestField = rate.getText();
                String yearField = time.getText();

                if (e.getSource() == calculate) {

                    if ("".equals(amountField) || "".equals(rateOfInterestField) || "".equals(yearField)) {
                        String emptyFieldWarning;
                        emptyFieldWarning = "One or more fields is/are empty!";
                        JOptionPane.showMessageDialog(rootPane, emptyFieldWarning);
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                try {
                    principal.setText("");
                    rate.setText("");
                    time.setText("");
                    simpleInterest.setText("");
                } catch (Exception f) {
                }
            }
        });
    }
}
