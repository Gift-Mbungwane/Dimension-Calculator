package Dimension.Calculator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator extends JFrame implements ActionListener {
    double number = 0.0D;
    double total = 0.0D;
    boolean again = false;
    boolean change = false;
    boolean entered = false;
    String[] operation = new String[]{" ", " "};
    private JButton jButtonSeven;
    private JButton jButton10;
    private JButton jButtonNegative;
    private JButton jButtonSqrt;
    private JButton jButtonLog;
    private JButton jButtonMultiply;
    private JButton jButtonMinus;
    private JButton jButtonPlus;
    private JButton jButtonReciprocal;
    private JButton jButtonClearEntry;
    private JButton jButtonZero;
    private JButton jButtonEight;
    private JButton jButtonEqualsTO;
    private JButton jButtonPoint;
    private JButton jButtonClear;
    private JButton jButtonDelete;
    private JButton jButtonDevide;
    private JButton jButtonNine;
    private JButton jButtonFour;
    private JButton jButtonFive;
    private JButton jButtonSix;
    private JButton jButtonOne;
    private JButton jButtonTwo;
    private JButton jButtonThree;
    private JButton CInterest;
    private JButton SInterest;
    private JButton Currency;
    private JButton Bubble;
    private JButton MassConverter;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public Calculator() {
        super("DIMENSION CALCULATOR");
        this.initComponents();
        this.setAction();
    }

    private void setAction() {
        this.jButtonSeven.addActionListener(this);
        this.jButtonEight.addActionListener(this);
        this.jButtonNine.addActionListener(this);
        this.jButtonFour.addActionListener(this);
        this.jButtonFive.addActionListener(this);
        this.jButtonSix.addActionListener(this);
        this.jButtonOne.addActionListener(this);
        this.jButtonTwo.addActionListener(this);
        this.jButtonThree.addActionListener(this);
        this.jButton10.addActionListener(this);
        this.jButtonNegative.addActionListener(this);
        this.jButtonSqrt.addActionListener(this);
        this.jButtonLog.addActionListener(this);
        this.jButtonMultiply.addActionListener(this);
        this.jButtonMinus.addActionListener(this);
        this.jButtonPlus.addActionListener(this);
        this.jButtonReciprocal.addActionListener(this);
        this.jButtonClearEntry.addActionListener(this);
        this.jButtonZero.addActionListener(this);
        this.jButtonEqualsTO.addActionListener(this);
        this.jButtonPoint.addActionListener(this);
        this.jButtonClear.addActionListener(this);
        this.jButtonDelete.addActionListener(this);
        this.jButtonDevide.addActionListener(this);
        this.CInterest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CInterest();
                }catch (Exception el){
                    JOptionPane.showMessageDialog(rootPane,"ERROR");
                }

            }

        });
        this.SInterest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SInterest();
                }catch (NullPointerException a){
                    JOptionPane.showMessageDialog(rootPane,"ERROR");
                }
            }
        });
        this.Currency.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                try {

                    new Unit();

                } catch (NullPointerException w) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR");

                }
            }

        });
        this.MassConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    MassConverter massConverter = new MassConverter();

                }
                catch (NullPointerException m){
                    JOptionPane.showMessageDialog(rootPane, "ERROR");

                }
            }
        });
        this.Bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Bubble();
            }
        });


    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (!this.again) {
            this.number = Double.parseDouble(this.jTextField1.getText());
        }

        byte var4 = -1;
        switch(cmd.hashCode()) {
            case 42:
                if (cmd.equals("*")) {
                    var4 = 9;
                }
                break;
            case 43:
                if (cmd.equals("+")) {
                    var4 = 11;
                }
                break;
            case 45:
                if (cmd.equals("-")) {
                    var4 = 10;
                }
                break;
            case 47:
                if (cmd.equals("/")) {
                    var4 = 8;
                }
                break;
            case 61:
                if (cmd.equals("=")) {
                    var4 = 12;
                }
                break;
            case 67:
                if (cmd.equals("C")) {
                    var4 = 0;
                }
                break;
            case 77:
                if (cmd.equals("M")) {
                    var4 = 3;
                }
                break;
            case 2146:
                if (cmd.equals("CE")) {
                    var4 = 1;
                }
                break;
            case 42825:
                if (cmd.equals("+/-")) {
                    var4 = 4;
                }
                break;
            case 48666:
                if (cmd.equals("1/x")) {
                    var4 = 7;
                }
                break;
            case 99339:
                if (cmd.equals("del")) {
                    var4 = 2;
                }
                break;
            case 107332:
                if (cmd.equals("log")) {
                    var4 = 6;
                }
                break;
            case 3538208:
                if (cmd.equals("sqrt")) {
                    var4 = 5;
                }
        }

        switch(var4) {
            case 0:
                this.clearAll();
                break;
            case 1:
                this.clearEntry();
                break;
            case 2:
                try {
                    this.delete();
                } catch (BadLocationException var6) {
                    Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, (String)null, var6);
                }
                break;
            case 3:
                this.memory();
                break;
            case 4:
                this.posNeg();
                break;
            case 5:
                this.sqrt();
                break;
            case 6:
                this.log();
                break;
            case 7:
                this.reciprocal();
                break;
            case 8:
                this.operation[1] = "/";
                break;
            case 9:
                this.operation[1] = "*";
                break;
            case 10:
                this.operation[1] = "-";
                break;
            case 11:
                this.operation[1] = "+";
                break;
            case 12:
                this.operate(this.operation[0]);
                this.result();
                break;
            default:
                if (this.number == 0.0D) {
                    this.jTextField1.setText(cmd);
                } else if (this.change) {
                    if (this.again) {
                        this.clearAll();
                    }

                    this.checkPrevious(")");
                    this.jTextField1.setText(cmd);
                    this.change = false;
                } else {
                    this.jTextField1.setText(this.jTextField1.getText() + cmd);
                }
        }

        if (!" ".equals(this.operation[1])) {
            if (this.again) {
                this.again = false;
            } else if (!" ".equals(this.operation[0])) {
                this.checkPrevious(this.operation[0]);
                this.operate(this.operation[0]);
            } else {
                this.total = this.number;
            }

            this.afterNumber(this.operation[1]);
            this.operation[0] = this.operation[1];
            this.operation[1] = " ";
        }

    }

    private void clearAll() {
        this.jTextField1.setText("0");
        this.jTextField2.setText("");
        this.operation[0] = " ";
        this.operation[1] = " ";
        this.again = false;
        this.change = false;
        this.entered = false;
        this.total = 0.0D;
    }

    private void clearEntry() {
        this.jTextField1.setText("0");
        if (this.again) {
            this.total = 0.0D;
        }

        this.checkPrevious(")");
    }

    private void delete() throws BadLocationException {
        String text = this.jTextField1.getText();
        if (!this.change) {
            this.jTextField1.setText(this.jTextField1.getText(0, text.length() - 1));
            if (this.jTextField1.getText().equals("")) {
                this.jTextField1.setText("0");
            }
        }

    }
    private void memory() {

        if(jButton10.isSelected()){
            jButtonEqualsTO.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    checkNumber(total);
                }
            });
        }
    }


    private void posNeg() {
        this.number *= -1.0D;
        this.number -= -0.0D;
        this.checkNumber(this.number);
    }

    private void sqrt() throws ArithmeticException {
        try {
            this.number = Math.sqrt(this.number);
            this.beforeNumber("sqrt");
        } catch (Exception var2) {
            this.jTextField1.setText("Invalid Input");
            jTextField1.isShowing();
        }

    }

    private void log() {
        try {
            this.number = Math.log(this.number);
            this.beforeNumber("log");
        } catch (Exception var2) {
            this.jTextField1.setText("Invalid Input");
        }
    }
    private void CInterest() throws ArithmeticException {
        CInterest compoundInterest = new CInterest();
        compoundInterest.setSize(500,300);
        compoundInterest.setTitle(" Compound Interest Calculation");
        compoundInterest.setResizable(true);
        compoundInterest.setVisible(true);
        compoundInterest.setLayout(null);
    }
    private void SInterest(){
        //A = P(1 + in);
        SimpleInterest simpleInterest = new SimpleInterest();
        simpleInterest.setSize(500,500);
        simpleInterest.setTitle(" Simple Interest Calculation");
        simpleInterest.setResizable(true);
        simpleInterest.setVisible(true);
        simpleInterest.setLayout(null);

    }


    private void reciprocal() throws ArithmeticException {
        try {
            this.number = 1.0D / this.number;
            this.beforeNumber("reciproc");
        } catch (Exception var2) {
            this.jTextField1.setText("Cannot divide by zero");
            JOptionPane.showMessageDialog(rootPane,"Cannot divide by zero");
        }

    }

    private void operate(String operand) {
        byte var3 = -1;
        switch(operand.hashCode()) {
            case 42:
                if (operand.equals("*")) {
                    var3 = 1;
                }
                break;
            case 43:
                if (operand.equals("+")) {
                    var3 = 3;
                }
            case 44:
            case 46:
            default:
                break;
            case 45:
                if (operand.equals("-")) {
                    var3 = 2;
                }
                break;
            case 47:
                if (operand.equals("/")) {
                    var3 = 0;
                }
        }

        switch(var3) {
            case 0:
                try {
                    this.total /= this.number;
                } catch (ArithmeticException var5) {
                    this.jTextField1.setText("Cannot divide by zero");
                    JOptionPane.showMessageDialog(jTextField1, "ERROR: " + (jTextField1.getText()));
                }
                break;
            case 1:
                this.total *= this.number;
                break;
            case 2:
                this.total -= this.number;
                break;
            case 3:
                this.total += this.number;
        }

        System.out.println(this.total);
    }

    private void result() {
        this.checkNumber(this.total);
        if (this.total == 0.0D && this.number != 0.0D) {
            this.checkNumber(this.number);
        }

        this.again = true;
        this.change = true;
        this.entered = false;
        this.jTextField2.setText("");
    }

    private void afterNumber(String s) {
        if (this.entered) {
            this.jTextField2.setText(this.jTextField2.getText() + " " + s);
            this.entered = false;
        } else {
            this.jTextField2.setText(this.jTextField2.getText() + " " + this.jTextField1.getText() + " " + s);
        }

        this.checkNumber(this.total);
        this.change = true;
    }

    private void beforeNumber(String s) {
        String text = this.jTextField2.getText();
        if (text.endsWith(")")) {
            String inside = text.substring(text.lastIndexOf(" ") + 1);
            this.checkPrevious(")");
            this.jTextField2.setText(this.jTextField2.getText() + " " + s + "(" + inside + ")");
        } else {
            this.jTextField2.setText(this.jTextField2.getText() + " " + s + "(" + this.jTextField1.getText() + ")");
        }

        this.checkNumber(this.number);
        this.change = true;
        this.entered = true;
    }

    private void checkPrevious(String last) {
        if (this.change) {
            String text = this.jTextField2.getText();
            if (text.endsWith(last)) {
                this.jTextField2.setText(text.substring(0, text.lastIndexOf(" ")));
                this.entered = false;
                if (!last.equals(")")) {
                    this.operation[0] = " ";
                    this.entered = true;
                }
            }
        }

    }

    private void checkNumber(double toConvert) {
        int converted = (int)toConvert;
        if ((double)converted == toConvert) {
            this.jTextField1.setText(Integer.toString(converted));
        } else {
            this.jTextField1.setText(Double.toString(toConvert));
        }

    }

    private void initComponents() {
        this.jTextField1 = new JTextField();
        this.jButtonSeven = new JButton();
        this.jButtonEight = new JButton();
        this.jButtonNine = new JButton();
        this.jButtonFour = new JButton();
        this.jButtonFive = new JButton();
        this.jButtonSix = new JButton();
        this.jButtonOne = new JButton();
        this.jButtonTwo = new JButton();
        this.jButtonThree = new JButton();
        this.jButton10 = new JButton();
        this.jButtonNegative = new JButton();
        this.jButtonSqrt = new JButton();
        this.jButtonLog = new JButton();
        this.jButtonMultiply = new JButton();
        this.jButtonMinus = new JButton();
        this.jButtonPlus = new JButton();
        this.jButtonReciprocal = new JButton();
        this.jButtonClearEntry = new JButton();
        this.jButtonZero = new JButton();

        this.CInterest = new JButton();
        this.SInterest = new JButton();
        this.Currency = new JButton();
        this.MassConverter = new JButton();
        this.Bubble = new JButton();

        this.jButtonEqualsTO = new JButton();
        this.jButtonPoint = new JButton();
        this.jButtonClear = new JButton();
        this.jButtonDelete = new JButton();
        this.jButtonDevide = new JButton();
        this.jTextField2 = new JTextField();
        this.setDefaultCloseOperation(3);
        this.setAlwaysOnTop(true);
        this.setCursor(new Cursor(0));
        this.setResizable(true);
        this.jTextField1.setEditable(true);
        this.jTextField1.setFont(new Font("Consolas", 2, 24));
        this.jTextField1.setHorizontalAlignment(4);
        this.jTextField1.setText("0");
        this.jTextField1.setToolTipText("");
        this.jTextField1.setBorder(BorderFactory.createBevelBorder(1));
        this.jTextField1.setCursor(new Cursor(2));
        this.jTextField1.setEnabled(true);
        this.jButtonSeven.setText("7");
        this.jButtonEight.setText("8");
        this.jButtonNine.setText("9");
        this.jButtonFour.setText("4");
        this.jButtonFive.setText("5");
        this.jButtonSix.setText("6");
        this.jButtonOne.setText("1");
        this.jButtonTwo.setText("2");
        this.jButtonThree.setText("3");
        this.jButton10.setText("M");
        this.jButtonNegative.setText("+/-");
        this.jButtonSqrt.setText("sqrt");
        this.jButtonLog.setText("log");
        this.jButtonMultiply.setText("*");
        this.jButtonMinus.setText("-");
        this.jButtonPlus.setText("+");
        this.jButtonReciprocal.setText("1/x");
        this.jButtonClearEntry.setText("CE");
        this.jButtonZero.setText("0");

        this.CInterest.setText("CI");
        CInterest.setHideActionText(false);
        this.SInterest.setText("SI");
        this.Currency.setText("Currency");
        this.MassConverter.setText("Mass");
        this.Bubble.setText("Bubble");

        this.jButtonEqualsTO.setText("=");
        this.jButtonPoint.setText(".");
        this.jButtonClear.setText("C");
        this.jButtonDelete.setText("del");
        this.jButtonDevide.setText("/");
        this.jTextField2.setEditable(true);
        this.jTextField2.setFont(new Font("Courier New", 2, 15));
        this.jTextField2.setHorizontalAlignment(4);
        this.jTextField2.setBorder(BorderFactory.createBevelBorder(1));
        this.jTextField2.setCursor(new Cursor(2));
        this.jTextField2.setEnabled(true);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.jTextField1, -2, 267, -2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(this.jTextField2, -2, 267, -2)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(this.Currency,-2,51,-2)
                                                        .addComponent(this.jButtonReciprocal, -2, 51, -2)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(this.jButtonLog, -2, 51, -2)
                                                                .addComponent(this.jButtonSqrt)
                                                                .addComponent(this.jButtonNegative, -2, 51, -2)
                                                                .addComponent(this.jButton10, -2, 51, -2)))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(this.jButtonOne, GroupLayout.Alignment.TRAILING, -2, 47, -2)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(this.jButtonSeven, -2, 47, -2)
                                                                                .addComponent(this.jButtonClearEntry, -2, 47, -2)
                                                                                .addComponent(this.jButtonFour, -2, 47, -2)
                                                                                .addComponent(this.CInterest,-2,47,-2)))
                                                                .addGap(2, 2, 2)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(this.jButtonEight, -1, 47, 32767)
                                                                        .addComponent(this.jButtonClear, -1, -1, 32767)
                                                                        .addComponent(this.jButtonTwo, -1, -1, 32767)
                                                                        .addComponent(this.jButtonFive, -1, -1, 32767)
                                                                        .addComponent(this.SInterest,-1,-1,32767)))
                                                        .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
                                                                .addComponent(this.jButtonZero, -2, 96, -2)))
                                                .addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(this.jButtonNine, -1, -1, 32767)
                                                        .addComponent(this.jButtonThree, -1, -1, 32767)
                                                        .addComponent(this.jButtonPoint, -1, -1, 32767)
                                                        .addComponent(this.jButtonDelete, -1, -1, 32767)
                                                        .addComponent(this.jButtonSix, -1, -1, 32767)
                                                        .addComponent(this.MassConverter,-1,-1,32767))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(this.jButtonDevide, -2, 47, -2)
                                                        .addComponent(this.jButtonMultiply, -2, 47, -2)
                                                        .addComponent(this.jButtonMinus, -2, 47, -2)
                                                        .addComponent(this.jButtonPlus, -2, 47, -2)
                                                        .addComponent(this.jButtonEqualsTO, -2, 47, -2)
                                                        .addComponent(this.Bubble,-2,47,-2)))))
                        .addContainerGap(50, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(this.jTextField2, -2, 15, -2)
                        .addGap(0, 0, 0)
                        .addComponent(this.jTextField1, -2, 30, -2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jButton10)
                                        .addComponent(this.jButtonClearEntry))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(this.jButtonDelete)
                                        .addComponent(this.jButtonClear)
                                        .addComponent(this.jButtonDevide)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jButtonNegative)
                                .addComponent(this.jButtonEight)
                                .addComponent(this.jButtonSeven)
                                .addComponent(this.jButtonNine)
                                .addComponent(this.jButtonMultiply))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jButtonSqrt)
                                .addComponent(this.jButtonSix)
                                .addComponent(this.jButtonFour)
                                .addComponent(this.jButtonFive)
                                .addComponent(this.jButtonMinus))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jButtonLog)
                                .addComponent(this.jButtonOne)
                                .addComponent(this.jButtonTwo)
                                .addComponent(this.jButtonThree)
                                .addComponent(this.jButtonPlus))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.jButtonReciprocal)
                                .addComponent(this.jButtonZero)
                                .addComponent(this.jButtonPoint)
                                .addComponent(this.jButtonEqualsTO))
                        .addGap(2, 2,2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        //.addContainerGap(50, 32767)));
                                .addComponent(this.Currency)
                        .addComponent(this.CInterest)
                        .addComponent(this.SInterest)
                        .addComponent(this.MassConverter)
                        .addComponent(this.Bubble))
                        .addContainerGap(50,32767)));

        this.pack();
    }
}
