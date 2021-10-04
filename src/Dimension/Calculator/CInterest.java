package Dimension.Calculator;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CInterest extends JFrame {
    private JTextField principal = new JTextField();
    private JTextField rate = new JTextField();
    private JTextField time = new JTextField();
    private JTextField compoundInterest = new JTextField();
    // calculate JButton
    private JButton clear = new JButton("Clear");
    private JButton calculate = new JButton("Calculate");
    //create JTextArea
    JTextArea area = new JTextArea(1, 1);

    public CInterest() {
        // panel panel to hold labels and text fields
        JPanel panel1 = new JPanel(new GridLayout(5, 2));
        panel1.add(new JLabel("Enter Principal"));
        panel1.add(principal);
        panel1.add(new JLabel("Enter Rate in percentage"));
        panel1.add(rate);
        panel1.add(new JLabel("Enter the number of year"));
        panel1.add(time);
        panel1.add(new JLabel("Compound Interest"));
        panel1.add(compoundInterest);
        panel1.setBorder(new TitledBorder(""));

        principal.setBorder(BorderFactory.createEtchedBorder());
        rate.setBorder(BorderFactory.createEtchedBorder());
        time.setBorder(BorderFactory.createEtchedBorder());
        compoundInterest.setBorder(BorderFactory.createEtchedBorder());
        compoundInterest.setEditable(false);
        compoundInterest.setForeground(Color.RED);

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

                    // CI = P(1 + Rate(R)/100)^T(time);
                    //CI =principle *((1 + R/100), T);
                    //CI = P(1 + i)^n;

                    String interest = "R" + amount  * Math.pow(1 + rateOfInterest/100, year);
                    // Display simple interest
                    compoundInterest.setText((interest));
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
                    compoundInterest.setText("");
                } catch (Exception f) {
                }
            }
        });
    }
    public static void main(String[] args) {
       /* double PAmount, ROI, TimePeriod;
        sc = new Scanner(System.in);

        System.out.print(" Please Enter the Principal Amount : ");
        PAmount = sc.nextDouble();

        System.out.print(" Please Enter the Rate Of Interest : ");
        ROI = sc.nextDouble();

        System.out.print(" Please Enter the Time Period in Years : ");
        TimePeriod = sc.nextDouble() ;

        calCompoundInterest(PAmount, ROI, TimePeriod);*/

        CInterest compoundInterest = new CInterest();
        compoundInterest.setSize(500,300);
        compoundInterest.setTitle(" Simple Interest Calculation");
        compoundInterest.setResizable(true);
        compoundInterest.setVisible(true);
        compoundInterest.getContentPane().setLayout(null);
    }
}
