package gui;


import java.awt.event.ActionListener;
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
        frame = new JFrame("Xo so");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(50, 150, 400, 400);
        textPane.setEditable(false);
        panel.add(scrollPane);

        input = new JTextField();
        input.setBounds(100, 50, 200, 30);
        panel.add(input);

        btnConfirm = new JButton("Xac nhan");
        btnConfirm.setBounds(350, 50, 100, 30);
        btnConfirm.setBackground(Color.cyan);
        panel.add(btnConfirm);

        JLabel label = new JLabel("Con so may man:");
        label.setBounds(0, 50, 100, 30);
        panel.add(label);

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

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Thong bao", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showFrame() {
        frame.setVisible(true);
    }
}
