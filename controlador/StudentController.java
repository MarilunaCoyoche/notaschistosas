package controlador;

import modelo.StudentModel;
import vista.BarChartPanel;
import vista.StudentView;
import vista.VideoPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    private StudentModel modelo; // Referencia al modelo de datos.
    private StudentView vista; // Referencia a la vista.

    public StudentController(StudentModel modelo, StudentView vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Agregar un listener al botón de envío en la vista.
        this.vista.addSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtener las notas ingresadas por el usuario y convertirlas a enteros.
                int grado1 = Integer.parseInt(vista.getGrade1());
                int grado2 = Integer.parseInt(vista.getGrade2());
                int grado3 = Integer.parseInt(vista.getGrade3());

                // Validar que las notas estén entre 1 y 20.
                if (isValidGrade(grado1) && isValidGrade(grado2) && isValidGrade(grado3)) {
                    modelo.setGrades(grado1, grado2, grado3); // Establecer las notas en el modelo.
                    double promedio = modelo.calculateAverage(); // Calcular el promedio.

                    vista.showMessage("Promedio: " + promedio); // Mostrar el promedio al usuario.

                    if (promedio >= 12) { 
                        playVideo("recursos/aprobado.mp4"); 
                        vista.showMessage("Felicitaciones inge :)"); // Mensaje al aprobar
                    } else { 
                        playVideo("recursos/desaprobado.mp4"); 
                        vista.showMessage("Esfuerzate más xd"); // Mensaje al desaprobar
                    }
                    vista.close(); // Cerrar la ventana después de mostrar el resultado.
                    displayBarChart(modelo.getGrades()); // Mostrar gráfico de barras con las notas ingresadas.
                } else {
                    vista.showMessage("Las notas deben estar entre 1 y 20."); // Mensaje de error si las notas son inválidas.
                }
            } catch (NumberFormatException ex) { 
                vista.showMessage("Por favor ingrese solo números."); // Mensaje de error si hay formato incorrecto.
            }
        }

        private boolean isValidGrade(int grade) { 
            return grade >= 1 && grade <= 20; // Validar que la nota esté dentro del rango permitido (1-20).
        }

        private void playVideo(String filePath) { 
            try {
                VideoPlayer.playVideo(filePath); // Llamar al método estático para reproducir el video.
            } catch (Exception ex) { 
                ex.printStackTrace(); 
            }
        }

        private void displayBarChart(int[] grades) { 
            JFrame chartFrame = new JFrame("Gráfico de Barras"); 
            chartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            chartFrame.setSize(400, 300); 
            chartFrame.add(new BarChartPanel(grades)); 
            chartFrame.setVisible(true); 
            // Mostrar gráfico de barras con las calificaciones ingresadas por el usuario.
        }
    }
}