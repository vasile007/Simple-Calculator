
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // Labels for input fields and output
    Label label = new Label("Enter first number");
    Label label1 = new Label("Choose one operation");
    Label label2 = new Label("Enter second number");
    Label label3 = new Label("Result is");

    // Input fields for user data
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textResult = new TextField();

    // Button for calculation
    Button button = new Button("Calculate");

    // Choice (dropdown) for operation selection
    Choice choice = new Choice();

    // Constants for operations
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    Calculator() {

        // Frame setup
        Frame frame = new Frame("Simple Calculator");
        Panel panel = new Panel();
        frame.setLayout(null);
        frame.add(panel);

        // Adding operations to the Choice dropdown
        choice.add(ADD);
        choice.add(SUBTRACT);
        choice.add(DIVIDE);
        choice.add(MULTIPLY);

        // Setting bounds for UI components
        label.setBounds(50, 100, 150, 30);
        label1.setBounds(50, 200, 150, 30);
        label2.setBounds(50, 300, 150, 30);
        label3.setBounds(50, 500, 150, 30);

        // Background colors for aesthetics
        frame.setBackground(Color.GRAY);
        label.setBackground(Color.LIGHT_GRAY);
        label1.setBackground(Color.LIGHT_GRAY);
        label2.setBackground(Color.LIGHT_GRAY);
        label3.setBackground(Color.LIGHT_GRAY);

        // Setting bounds for the input fields, button, and dropdown
        textField1.setBounds(250, 100, 200, 30);
        choice.setBounds(250, 200, 200, 30);
        textField2.setBounds(250, 300, 200, 30);
        button.setBounds(250, 400, 200, 30);
        textResult.setBounds(250, 500, 200, 30);
        textResult.setEnabled(false);

        // Adding ActionListener to the button
        button.addActionListener(this);

        // Adding components to the frame
        frame.add(textField1);
        frame.add(textField2);
        frame.add(button);
        frame.add(textResult);
        frame.add(choice);
        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        // Setting frame size and visibility
        frame.setSize(500, 600);
        frame.setVisible(true);

        // Adding window close listener
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Check if both input fields are filled
            if (textField1.getText().trim().isEmpty() || textField2.getText().trim().isEmpty()) {
                textResult.setText("Fill up all the fields");
                return;
            }

            // Parse the input values
            float a = Float.parseFloat(textField1.getText());
            float b = Float.parseFloat(textField2.getText());

            // Get the selected operation
            String selectedOperation = choice.getSelectedItem();

            // Perform the selected operation
            switch (selectedOperation) {
                case ADD:
                    textResult.setText("" + add(a, b));

                    break;
                case SUBTRACT:
                    textResult.setText("" + subtract(a, b));

                    break;
                case MULTIPLY:
                    textResult.setText("" + multiply(a, b));

                    break;
                case DIVIDE:
                    divide(a, b);  // Call the divide method
                    return;  // Prevent further action since divide already updates the textResult
            }

        } catch (NumberFormatException ex) {
            // If the input is not a valid number, display an error
         
            textResult.setText("Invalid input.");
        }
    }

    // Method for addition
    private float add(float a, float b) {
        return a + b;
    }

    // Method for subtraction
    private float subtract(float a, float b) {
        return a - b;
    }

    // Method for multiplication
    private float multiply(float a, float b) {
        return a * b;
    }

    // Method for division with error handling
    private void divide(float a, float b) {
        if (b == 0) {

            textResult.setText("You can't divide by 0!");  // Display the error message
            return;  // Exit the method to prevent further operations
        }
        // Perform division and show the result if no division by zero
        textResult.setForeground(Color.BLACK);  // Reset the text color to black for valid result
        textResult.setText("" + (a / b));  // Display the result of division
    }
}




