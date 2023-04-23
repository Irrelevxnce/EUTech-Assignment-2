package com.irrelevxnce;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

enum Days {
    Monday, Tuesday, Wednesday, Thursday, Friday
}

public class appMainWindow {

    private JFrame frmEutechStudentReporting;
    private JTextField nameField;
    private JTextField dateField;
    int elementNumber;
    public String nameToParse;
    public String mondayToParse = "";
    public String tuesdayToParse = "";
    public String wednesdayToParse = "";
    public String thursdayToParse = "";
    public String fridayToParse = "";
    public String dateToParse;
    private Days daySelected;
    public int width;

    public int height;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                appMainWindow window = new appMainWindow();
                window.frmEutechStudentReporting.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public appMainWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmEutechStudentReporting = new JFrame();
        frmEutechStudentReporting.getContentPane().setBounds(new Rectangle(5, 0, 0, 0));
        frmEutechStudentReporting.getContentPane().setBackground(new Color(51, 51, 51));
        frmEutechStudentReporting.setResizable(false);
        frmEutechStudentReporting.setTitle("EUTech Student Reporting Tool");
        frmEutechStudentReporting.setIconImage(Toolkit.getDefaultToolkit().getImage(appMainWindow.class.getResource("/EuTech_logo.png")));
        frmEutechStudentReporting.setBounds(120, 120, 850, 550);
        frmEutechStudentReporting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        frmEutechStudentReporting.getContentPane().setLayout(springLayout);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmEutechStudentReporting.getContentPane().setLocation(dim.width / 2 - frmEutechStudentReporting.getContentPane().getSize().width / 2, dim.height / 2 - frmEutechStudentReporting.getContentPane().getSize().height / 2);

        JLabel lblName = new JLabel("Enter your name and surname(s):");
        springLayout.putConstraint(SpringLayout.WEST, lblName, 300, SpringLayout.WEST, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, lblName, -422, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        lblName.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
        lblName.setForeground(Color.WHITE);
        frmEutechStudentReporting.getContentPane().add(lblName);

        nameField = new RoundedJTextField(1);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 10, SpringLayout.SOUTH, lblName);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, lblName);
        springLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, lblName);
        lblName.setLabelFor(nameField);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
        PromptSupport.setPrompt("Enter your name and surname here", nameField);
        frmEutechStudentReporting.getContentPane().add(nameField);
        nameField.setColumns(12);

        JLabel lblDate = new JLabel("Enter date period (dd/mm/yyyy - dd/mm/yyyy):");
        springLayout.putConstraint(SpringLayout.WEST, lblDate, -45, SpringLayout.WEST, nameField);
        springLayout.putConstraint(SpringLayout.SOUTH, lblDate, 30, SpringLayout.SOUTH, nameField);
        lblDate.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
        lblDate.setForeground(Color.WHITE);
        frmEutechStudentReporting.getContentPane().add(lblDate);

        dateField = new RoundedJTextField(1);
        springLayout.putConstraint(SpringLayout.NORTH, dateField, 10, SpringLayout.SOUTH, lblDate);
        springLayout.putConstraint(SpringLayout.WEST, dateField, 0, SpringLayout.WEST, lblDate);
        springLayout.putConstraint(SpringLayout.EAST, dateField, 0, SpringLayout.EAST, lblDate);
        springLayout.putConstraint(SpringLayout.SOUTH, dateField, 50, SpringLayout.SOUTH, lblDate);
        lblDate.setLabelFor(dateField);
        dateField.setHorizontalAlignment(JTextField.CENTER);
        dateField.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
        PromptSupport.setPrompt("Enter date period", dateField);
        frmEutechStudentReporting.getContentPane().add(dateField);
        dateField.setColumns(12);

        ButtonGradient btnSaveReport = new ButtonGradient();
        btnSaveReport.setText("Save Report");
        width = btnSaveReport.getWidth();
        height = btnSaveReport.getHeight();
        springLayout.putConstraint(SpringLayout.NORTH, btnSaveReport, -57, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnSaveReport, 700, SpringLayout.WEST, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnSaveReport, -22, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        btnSaveReport.setActionCommand("Save Report");
        btnSaveReport.setBackground(new Color(204, 255, 153));
        btnSaveReport.setForeground(Color.BLACK);
        btnSaveReport.setFocusPainted(false);
        btnSaveReport.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnSaveReport.addActionListener(e -> saveReport());
        frmEutechStudentReporting.getContentPane().add(btnSaveReport);


        ButtonGradient btnMonday = new ButtonGradient();
        btnMonday.setText("Modify Monday");
        springLayout.putConstraint(SpringLayout.NORTH, btnMonday, 282, SpringLayout.NORTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnMonday, 26, SpringLayout.WEST, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnMonday, -161, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnMonday, -675, SpringLayout.EAST, frmEutechStudentReporting.getContentPane());
        btnMonday.setForeground(Color.BLACK);
        btnMonday.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnMonday.setFocusPainted(false);
        btnMonday.setBackground(new Color(204, 255, 153));
        btnMonday.setActionCommand("Write to Monday");
        btnMonday.addActionListener(e -> {
            daySelected = Days.Monday;
            openTextEditor(daySelected);
        });
        frmEutechStudentReporting.getContentPane().add(btnMonday);

        ButtonGradient btnTuesday = new ButtonGradient();
        btnTuesday.setText("Modify Tuesday");
        springLayout.putConstraint(SpringLayout.SOUTH, nameField, -146, SpringLayout.NORTH, btnTuesday);
        springLayout.putConstraint(SpringLayout.NORTH, btnTuesday, 282, SpringLayout.NORTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnTuesday, -161, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnTuesday, 26, SpringLayout.EAST, btnMonday);
        springLayout.putConstraint(SpringLayout.EAST, btnTuesday, -514, SpringLayout.EAST, frmEutechStudentReporting.getContentPane());
        btnTuesday.setForeground(Color.BLACK);
        btnTuesday.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnTuesday.setFocusPainted(false);
        btnTuesday.setBackground(new Color(204, 255, 153));
        btnTuesday.setActionCommand("Write to Tuesday");
        btnTuesday.addActionListener(e -> {
            daySelected = Days.Tuesday;
            openTextEditor(daySelected);
        });
        frmEutechStudentReporting.getContentPane().add(btnTuesday);

        ButtonGradient btnWednesday = new ButtonGradient();
        btnWednesday.setText("Modify Wednesday");
        springLayout.putConstraint(SpringLayout.NORTH, btnWednesday, 146, SpringLayout.SOUTH, nameField);
        springLayout.putConstraint(SpringLayout.WEST, btnWednesday, 26, SpringLayout.EAST, btnTuesday);
        springLayout.putConstraint(SpringLayout.SOUTH, btnWednesday, -161, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnWednesday, -353, SpringLayout.EAST, frmEutechStudentReporting.getContentPane());
        btnWednesday.setForeground(Color.BLACK);
        btnWednesday.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnWednesday.setFocusPainted(false);
        btnWednesday.setBackground(new Color(204, 255, 153));
        btnWednesday.setActionCommand("Write to Wednesday");
        btnWednesday.addActionListener(e -> {
            daySelected = Days.Wednesday;
            openTextEditor(daySelected);
        });
        frmEutechStudentReporting.getContentPane().add(btnWednesday);

        ButtonGradient btnThursday = new ButtonGradient();
        btnThursday.setText("Modify Thursday");
        springLayout.putConstraint(SpringLayout.NORTH, btnThursday, 146, SpringLayout.SOUTH, nameField);
        springLayout.putConstraint(SpringLayout.WEST, btnThursday, 26, SpringLayout.EAST, btnWednesday);
        springLayout.putConstraint(SpringLayout.SOUTH, btnThursday, -161, SpringLayout.SOUTH, frmEutechStudentReporting.getContentPane());
        btnThursday.setForeground(Color.BLACK);
        btnThursday.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnThursday.setFocusPainted(false);
        btnThursday.setBackground(new Color(204, 255, 153));
        btnThursday.setActionCommand("Write to Thursday");
        btnThursday.addActionListener(e -> {
            daySelected = Days.Thursday;
            openTextEditor(daySelected);
        });
        frmEutechStudentReporting.getContentPane().add(btnThursday);

        ButtonGradient btnFriday = new ButtonGradient();
        btnFriday.setText("Modify Friday");
        springLayout.putConstraint(SpringLayout.EAST, btnThursday, -26, SpringLayout.WEST, btnFriday);
        springLayout.putConstraint(SpringLayout.NORTH, btnFriday, 282, SpringLayout.NORTH, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, btnFriday, 670, SpringLayout.WEST, frmEutechStudentReporting.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, btnFriday, -104, SpringLayout.NORTH, btnSaveReport);
        springLayout.putConstraint(SpringLayout.EAST, btnFriday, -30, SpringLayout.EAST, frmEutechStudentReporting.getContentPane());
        btnFriday.setForeground(Color.BLACK);
        btnFriday.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
        btnFriday.setFocusPainted(false);
        btnFriday.setActionCommand("Write to Friday");
        btnFriday.addActionListener(e -> {
            daySelected = Days.Friday;
            openTextEditor(daySelected);
        });
        frmEutechStudentReporting.getContentPane().add(btnFriday);
    }

    private void saveReport() {
        if (!nameField.getText().isBlank() && !dateField.getText().isBlank()) {
            nameToParse = nameField.getText();
            dateToParse = dateField.getText();
            Report r = new Report(nameToParse, mondayToParse, tuesdayToParse, wednesdayToParse, thursdayToParse, fridayToParse, dateToParse);
            r.saveReport();
        } else {
            JFrame frame = new JFrame("Error!");
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(appMainWindow.class.getResource("/EuTech_logo.png")));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel errLabel;
            if (nameField.getText().isBlank()) {
                errLabel = new JLabel("You must enter a name!");
            } else {
                errLabel = new JLabel("You must enter a date!");
            }
            errLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
            errLabel.setForeground(Color.WHITE);
            frame.add(errLabel);
            errLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
            errLabel.setForeground(Color.BLACK);
            errLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.setPreferredSize(new Dimension(250, 100));
            frame.pack();
            frame.setLocationRelativeTo(frmEutechStudentReporting);
            frame.setVisible(true);
            frame.setResizable(false);
        }
    }

    private void openTextEditor(Days daySelected) {
        String [] tasks = new String[0];
        if (mondayToParse != null || tuesdayToParse != null || wednesdayToParse != null || thursdayToParse != null || fridayToParse != null) {
            switch (daySelected) {
                case Monday -> {
                    assert mondayToParse != null;
                    tasks = mondayToParse.split("\n");
                }
                case Tuesday -> {
                    assert tuesdayToParse != null;
                    tasks = tuesdayToParse.split("\n");
                }
                case Wednesday -> {
                    assert wednesdayToParse != null;
                    tasks = wednesdayToParse.split("\n");
                }
                case Thursday -> {
                    assert thursdayToParse != null;
                    tasks = thursdayToParse.split("\n");
                }
                case Friday -> tasks = fridayToParse.split("\n");
            }
        }
        elementNumber = tasks.length - 1;
        String[] finalTasks = tasks;
        EventQueue.invokeLater(() -> {
            JFrame frame1 = new JFrame(daySelected.toString());
            frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(appMainWindow.class.getResource("/EuTech_logo.png")));
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            panel1.setOpaque(true);
            JTextArea textArea1 = new JTextArea(15, 50);
            textArea1.setWrapStyleWord(true);
            textArea1.setEditable(false);
            textArea1.setFont(Font.getFont(Font.SANS_SERIF));
            JScrollPane scroller = new JScrollPane(textArea1);
            scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            JPanel inputpanel = new JPanel();
            inputpanel.setLayout(new FlowLayout());
            JTextField input = new JTextField(20);
            JButton button = new JButton("Enter");
            frame1.getRootPane().setDefaultButton(button);
            button.addActionListener(e -> {
                String toWrite = input.getText();
                if (!toWrite.equalsIgnoreCase("")) {
                    switch (daySelected) {
                        case Monday -> mondayToParse = mondayToParse.concat("\n" + toWrite);
                        case Tuesday -> tuesdayToParse = tuesdayToParse.concat("\n" + toWrite);
                        case Wednesday -> wednesdayToParse = wednesdayToParse.concat("\n" + toWrite);
                        case Thursday -> thursdayToParse = thursdayToParse.concat("\n" + toWrite);
                        case Friday -> fridayToParse = fridayToParse.concat("\n" + toWrite);
                    }
                    elementNumber++;
                    textArea1.append(elementNumber + ". " + input.getText() + "\n");
                    input.setText("");
                } else {
                    JFrame frame = new JFrame("Error!");
                    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(appMainWindow.class.getResource("/Release1/EuTech_logo.png")));
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JLabel errLabel = new JLabel("The text box is empty!");
                    errLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
                    errLabel.setForeground(Color.WHITE);
                    frame.add(errLabel);
                    errLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
                    errLabel.setForeground(Color.BLACK);
                    errLabel.setHorizontalAlignment(JLabel.CENTER);
                    frame.setPreferredSize(new Dimension(250, 100));
                    frame.pack();
                    frame.setLocationRelativeTo(frame1);
                    frame.setVisible(true);
                    frame.setResizable(false);
                }
            });
            DefaultCaret caret = (DefaultCaret) textArea1.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            panel1.add(scroller);
            inputpanel.add(input);
            inputpanel.add(button);
            panel1.add(inputpanel);
            frame1.getContentPane().add(BorderLayout.CENTER, panel1);
            frame1.pack();
            frame1.setLocationByPlatform(true);
            frame1.setVisible(true);
            frame1.setResizable(false);
            input.requestFocus();
            if (mondayToParse != null || tuesdayToParse != null || wednesdayToParse != null || thursdayToParse != null || fridayToParse != null) {
                for (int i = 0; i < finalTasks.length; i++) {
                    if (i != 0) {
                        textArea1.append((i) + ". " + finalTasks[i] + "\n");
                    }
                }
            }
        });
    }
}