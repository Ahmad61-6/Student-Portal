import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// StudentPortal class
class StudentPortal extends JFrame implements ActionListener {

    private JLabel nameLabel, ageLabel, addressLabel, departmentLabel;
    private JTextField nameTextField, ageTextField, addressTextField, departmentTextField;
    private JButton addButton, deleteButton, searchButton, exitButton;
    private JTextArea outputTextArea;
    private ArrayList<Student> studentList;

    public StudentPortal() {
        // Initialize JFrame
        setTitle("Student Portal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame
        setLayout(new BorderLayout());

        // Initialize JPanel for adding student inputs and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2)); // 5 rows, 2 columns

        // Initialize name input components
        nameLabel = new JLabel("Name: ");
        nameTextField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);

        // Initialize
        // Initialize age input components
        ageLabel = new JLabel("Age: ");
        ageTextField = new JTextField();
        inputPanel.add(ageLabel);
        inputPanel.add(ageTextField);

        // Initialize address input components
        addressLabel = new JLabel("Address: ");
        addressTextField = new JTextField();
        inputPanel.add(addressLabel);
        inputPanel.add(addressTextField);

        // Initialize department input components
        departmentLabel = new JLabel("Department: ");
        departmentTextField = new JTextField();
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentTextField);

        // Initialize buttons
        addButton = new JButton("Add Student");
        deleteButton = new JButton("Delete Student");
        searchButton = new JButton("Search Student");
        exitButton = new JButton("Exit");

        // Add ActionListeners to buttons
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add buttons to inputPanel
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(searchButton);
        inputPanel.add(exitButton);

        // Initialize JTextArea for displaying student information
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false); // Prevent user editing

        // Add inputPanel and outputTextArea to JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(outputTextArea, BorderLayout.CENTER);

        // Initialize ArrayList for storing students
        studentList = new ArrayList<Student>();

        setVisible(true); // Show JFrame
    }

    // Implementation of ActionListener method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Extract inputs from the text fields
            String name = nameTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            String address = addressTextField.getText();
            String department = departmentTextField.getText();

            // Create a new Student object with the extracted inputs
            Student student = new Student(name, age, address, department);

            // Add the new Student object to the studentList ArrayList
            studentList.add(student);

            // Display the added student's information in the JTextArea
            outputTextArea.setText("Student added successfully!\n\n" + student.toString());
        } else if (e.getSource() == deleteButton) {
            // Extract name input from the text field
            String name = nameTextField.getText();

            // Initialize index variable
        } else if (e.getSource() == deleteButton) {
            // Extract name input from the text field
            String name = nameTextField.getText();

            // Initialize index variable to -1
            int index = -1;

            // Search for the student with the matching name in the ArrayList
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equalsIgnoreCase(name)) {
                    index = i; // Set index to the position of the matching student
                    break; // Exit loop
                }
            }

            // If a matching student was found, remove the student from the ArrayList and display success message
            if (index != -1) {
                studentList.remove(index);
                outputTextArea.setText("Student " + name + " has been removed successfully!");
            } else {
                outputTextArea.setText("No student found with the name " + name);
            }
        } else if (e.getSource() == searchButton) {
            // Extract name input from the text field
            String name = nameTextField.getText();

            // Initialize index variable to -1
            int index = -1;

            // Search for the student with the matching name in the ArrayList
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getName().equalsIgnoreCase(name)) {
                    index = i; // Set index to the position of the matching student
                    break; // Exit loop
                }
            }

            // If a matching student was found, display the student's information in the JTextArea
            if (index != -1) {
                outputTextArea.setText(studentList.get(index).toString());
            } else {
                outputTextArea.setText("No student found with the name " + name);
            }
        } else if (e.getSource() == exitButton) {
            // Exit the program
            System.exit(0);
        }
    }
}