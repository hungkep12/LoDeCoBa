package gui;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

public class LoDeCoBaGUI {
    private final JFrame frame;
    private final JTextPane textPane;
    private final JTextField input;
    private final JButton btnConfirm;

    public LoDeCoBaGUI() {
        frame = new JFrame("Xổ số");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(100, 150, 400, 400);
        textPane.setEditable(false);
        panel.add(scrollPane);

        input = new JTextField();
        input.setBounds(150, 50, 200, 30);
        panel.add(input);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setBounds(400, 50, 100, 30);
        btnConfirm.setBackground(Color.cyan);
        panel.add(btnConfirm);
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnConfirm.doClick();
                }
            }
        });

        JLabel label = new JLabel("Con số may mắn:");
        label.setBounds(50, 50, 100, 30);
        panel.add(label);

        displayLabelPrize(panel);

        frame.add(panel);
    }

    public void addConfirmButtonListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
    }

    public String getInputText() {
        return input.getText();
    }

    public void clearTextPane() {
        textPane.setText("");
    }

    public void displayResult(List<List<String>> data) {
        StyledDocument doc = textPane.getStyledDocument();

        for (List<String> row : data) {
            String rowText = String.join(" - ", row);
            int rowLength = rowText.length();

            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_CENTER);
            StyleConstants.setFontFamily(attributes, "Serif");
            StyleConstants.setFontSize(attributes, 16);

            doc.setParagraphAttributes(doc.getLength(), rowLength, attributes, false);
            try {
                doc.insertString(doc.getLength(), rowText + "\n", null);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    private void displayLabelPrize(JPanel panel) {

        JLabel label0 = new JLabel("Giải đặc biệt:");
        label0.setBounds(20, 150, 100, 30);
        panel.add(label0);

        JLabel label1 = new JLabel("Giải nhất:");
        label1.setBounds(20, 173, 100, 30);
        panel.add(label1);

        JLabel label2 = new JLabel("Giải nhì:");
        label2.setBounds(20, 196, 100, 30);
        panel.add(label2);

        JLabel label3 = new JLabel("Giải ba:");
        label3.setBounds(20, 219, 100, 30);
        panel.add(label3);

        JLabel label4 = new JLabel("Giải tư:");
        label4.setBounds(20, 242, 100, 30);
        panel.add(label4);

        JLabel label5 = new JLabel("Giải năm:");
        label5.setBounds(20, 265, 100, 30);
        panel.add(label5);

        JLabel label6 = new JLabel("Giải sáu:");
        label6.setBounds(20, 288, 100, 30);
        panel.add(label6);

        JLabel label7 = new JLabel("Giải bảy:");
        label7.setBounds(20, 311, 100, 30);
        panel.add(label7);

    }
}
