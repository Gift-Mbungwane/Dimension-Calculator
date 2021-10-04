package Dimension.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorter extends JPanel implements ActionListener {
    private static final long serialVersionUID = -5548803322850070957L;
    private static final String BUBBLE_SORT = "bubble sort";
    private static final String INSERTION_SORT = "insertion sort";
    private static final String QUICK_SORT = "quick sort";
    private static final String SEPARATOR = ",";
    private static final String NO_RESULT = "no result";

    private static final Dimension TEXT_INPUT_DIM = new Dimension(200, 30);

    private static final JMenuBar MENU = new JMenuBar();
    private static final JMenu SORT = new JMenu("Sorting Algorithms");
    private static final JMenuItem BUBBLE = new JMenuItem(BUBBLE_SORT);
    private static final JMenuItem INSERTION = new JMenuItem(INSERTION_SORT);
    private static final JMenuItem QUICK_S = new JMenuItem(QUICK_SORT);

    private final JTextField textfieldInput = new JTextField();
    private final JCheckBox checkbox = new JCheckBox();
    private final JLabel orderLabel = new JLabel("sort in ascending order");

    private final JLabel labRes = new JLabel("sorted result : ");
    private final JLabel res = new JLabel(NO_RESULT);

    private static String selectedMenu;

    public Sorter() {
        setLayout(new GridLayout(2, 1));
        textfieldInput.setPreferredSize(TEXT_INPUT_DIM);

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(10));
        top.add(textfieldInput);
        top.add(createPanelCheckbox());
        top.add(createSortButton());
        add(top);

        add(createPanelResult());
    }

    private Component createSortButton() {
        JButton sortButton = new JButton("Launch");
        sortButton.addActionListener(this);
        return sortButton;
    }

    private final JPanel createPanelResult() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(labRes, BorderLayout.WEST);
        p.add(res, BorderLayout.CENTER);
        return p;
    }

    private final JPanel createPanelCheckbox() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(10));
        p.add(checkbox);
        p.add(orderLabel);
        return p;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.add(new Sorter());
        f.setJMenuBar(createMenu());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static JMenuBar createMenu() {
        BUBBLE.addActionListener(new MenuItemListener());
        SORT.add(BUBBLE);
        INSERTION.addActionListener(new MenuItemListener());
        SORT.add(INSERTION);
        QUICK_S.addActionListener(new MenuItemListener());
        SORT.add(QUICK_S);
        MENU.add(SORT);
        return MENU;
    }

    static class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedMenu = e.getActionCommand();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String content = textfieldInput.getText();
        String[] parsedNumbers = content.split(SEPARATOR);
        if (isSortable(parsedNumbers) && parsedNumbers.length < 10) {
            int[] result = null;

            if(selectedMenu==null)
                selectedMenu = BUBBLE_SORT;

            switch (selectedMenu) {
                case BUBBLE_SORT:
                    result = bubbleSort(checkbox.isSelected());
                    break;
                case INSERTION_SORT:
                    result = insertionSort(checkbox.isSelected());
                    break;
                case QUICK_SORT:
                    result = quickSort(checkbox.isSelected());
                    break;

            }
            res.setText(result == null ? NO_RESULT : fillResultLabel(result));
        }
    }

    private String fillResultLabel(int[] result) {
        StringBuilder res = new StringBuilder();
        for (int nb : result) {
            res.append(nb + " ");
        }
        return res.toString();
    }

    private final boolean isSortable(String[] numbers) {
        return true;
    }

    private int[] bubbleSort(boolean sortAscending) {
        return new int[]{1,2,3,4};
    }

    private int[] insertionSort(boolean sortAscending) {
        return new int[]{5,6,7,8};
    }

    private int[] quickSort(boolean sortAscending) {
        return new int[]{9,10,11,12};
    }
}
