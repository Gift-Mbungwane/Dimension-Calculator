package Dimension.Calculator;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;

public class SplashScreen  extends Calculator {

    private JDialog dialog;
    private JProgressBar progress;

    protected void initUI() throws MalformedURLException {
        showSplashScreen();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);// Simulate loading
                    publish(i);// Notify progress
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                progress.setValue(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                showFrame();
                hideSplashScreen();
            }

        };
        worker.execute();
    }

    protected void hideSplashScreen() {
        dialog.setVisible(false);
        dialog.dispose();
    }

    protected void showSplashScreen() throws MalformedURLException {
        dialog = new JDialog((Frame) null);
        dialog.setModal(false);
        dialog.setUndecorated(true);
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("x.png")));
        background.setLayout(new BorderLayout());
        dialog.setBounds(100,100,140,100);
        dialog.add(background);
        JLabel text = new JLabel("Loading Dimension Calculator, please wait...");
        text.setFont(Font.getFont(Font.SANS_SERIF));
        text.setForeground(Color.RED);
        text.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
        background.add(text);
        progress = new JProgressBar();
        progress.setVisible(true);
        background.add(progress, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    protected void showFrame() {

        Calculator calculator = new Calculator();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.pack();
        calculator.setVisible(true);
        calculator.setResizable(true);
        calculator.setBounds(350,100,500,500);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new SplashScreen().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
        }
    }
}
