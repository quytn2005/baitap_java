package View;
import javax.swing.*;
import java.awt.*;
import Controller.Controller;
import java.io.File;

public class View extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4460320136526408452L;
	private static final Object GridLayout = null;
	private JTextArea textArea;
    private JFileChooser fileChooser;
    private JButton openButton, saveButton; 
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Text Editor");
        setSize(800, 600);
        setLayout(new GridLayout());
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, GridLayout);

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, GridLayout);

        openButton.addActionListener(e -> controller.openButtonClicked());
        saveButton.addActionListener(e -> controller.saveButtonClicked());
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public File showOpenDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File showSaveDialog() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}