
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BillGeneration;

/**
 *
 * @author Bibhakta lamsal
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class NewClass extends JFrame {
    private JTextField userIDTextField;
    private JTextField customerNameTextField;
    private JTextField bookIDTextField;
    private JTextField bookNameTextField;
    private JTextField issueDateTextField;
    private JTextField dueDateTextField;
    private JTextArea billTextArea;

    public NewClass() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Bill Generator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the application window on the screen
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel userIDLabel = new JLabel("User ID:");
        userIDTextField = new JTextField(15);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameTextField = new JTextField(15);

        JLabel bookIDLabel = new JLabel("Book ID:");
        bookIDTextField = new JTextField(15);

        JLabel bookNameLabel = new JLabel("Book Name:");
        bookNameTextField = new JTextField(15);

        JLabel issueDateLabel = new JLabel("Issue Date:");
        issueDateTextField = new JTextField(15);

        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateTextField = new JTextField(15);

        JButton printButton = new JButton("Print");
        JButton printerButton = new JButton("Printer");

        billTextArea = new JTextArea(10, 30);
        billTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billTextArea);

        // Add components to the panel with appropriate constraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(userIDLabel, constraints);

        constraints.gridx = 1;
        panel.add(userIDTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(customerNameLabel, constraints);

        constraints.gridx = 1;
        panel.add(customerNameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(bookIDLabel, constraints);

        constraints.gridx = 1;
        panel.add(bookIDTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(bookNameLabel, constraints);

        constraints.gridx = 1;
        panel.add(bookNameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(issueDateLabel, constraints);

        constraints.gridx = 1;
        panel.add(issueDateTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(dueDateLabel, constraints);

        constraints.gridx = 1;
        panel.add(dueDateTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(printButton, constraints);

        constraints.gridx = 1;
        panel.add(printerButton, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 7;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, constraints);

        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });

        printerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void generateBill() {
        String userID = userIDTextField.getText();
        String customerName = customerNameTextField.getText();
        String bookID = bookIDTextField.getText();
        String bookName = bookNameTextField.getText();
        String issueDate = issueDateTextField.getText();
        String dueDate = dueDateTextField.getText();

        StringBuilder billBuilder = new StringBuilder();
        billBuilder.append("User ID: ").append(userID).append("\n");
        billBuilder.append("Customer Name: ").append(customerName).append("\n");
        billBuilder.append("Book ID: ").append(bookID).append("\n");
        billBuilder.append("Book Name: ").append(bookName).append("\n");
        billBuilder.append("Issue Date: ").append(issueDate).append("\n");
        billBuilder.append("Due Date: ").append(dueDate);

        billTextArea.setText(billBuilder.toString());
    }

    private void printBill() {
        try {
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            printerJob.setPrintable(new PrintableBill(billTextArea.getPrintable(null, null)));
            if (printerJob.printDialog()) {
                printerJob.print();
            }
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NewClass();
            }
        });
    }

    class PrintableBill implements java.awt.print.Printable {
        private Printable printable;

        public PrintableBill(Printable printable) {
            this.printable = printable;
        }

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            return printable.print(graphics, pageFormat, pageIndex);
        }
    }
}

