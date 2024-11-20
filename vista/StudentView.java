package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentView {
    private JFrame frame; // Ventana principal.
    private JTextField txtGrade1, txtGrade2, txtGrade3; // Campos para ingresar las notas.
    private JButton btnSubmit; // Botón para enviar las notas.

    public StudentView() {
        // Configuración de la ventana principal.
        frame = new JFrame("Notas del Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Aumentar el tamaño de la ventana

        JPanel panel = new JPanel(); // Panel para organizar los componentes.
        panel.setLayout(new GridLayout(5, 2)); // Diseño en cuadrícula.

        // Etiqueta y campo para la primera nota.
        panel.add(new JLabel("Nota 1:"));
        txtGrade1 = new JTextField();
        panel.add(txtGrade1);

        // Etiqueta y campo para la segunda nota.
        panel.add(new JLabel("Nota 2:"));
        txtGrade2 = new JTextField();
        panel.add(txtGrade2);

        // Etiqueta y campo para la tercera nota.
        panel.add(new JLabel("Nota 3:"));
        txtGrade3 = new JTextField();
        panel.add(txtGrade3);

        // Botón para enviar las notas.
        btnSubmit = new JButton("Enviar Notas");
        
        // Establecer tamaño preferido para el botón
        btnSubmit.setPreferredSize(new Dimension(200, 50)); // Aumentar el tamaño del botón
        panel.add(btnSubmit);

        frame.add(panel); // Añadir el panel a la ventana.
        frame.setVisible(true); // Hacer visible la ventana.
    }

    // Métodos para obtener las notas ingresadas por el usuario.
    public String getGrade1() {
        return txtGrade1.getText();
    }

    public String getGrade2() {
        return txtGrade2.getText();
    }

    public String getGrade3() {
        return txtGrade3.getText();
    }

    public void addSubmitListener(ActionListener listener) {
        btnSubmit.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void close() {
        frame.dispose();
    }
}