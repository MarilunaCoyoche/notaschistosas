import modelo.StudentModel;
import vista.StudentView;
import controlador.StudentController;

public class AppEstudianteMVC {
    public static void main(String[] args) {
        // Crear instancias del modelo, vista y controlador.
        StudentModel modelo = new StudentModel();
        StudentView vista = new StudentView();
        StudentController controlador = new StudentController(modelo, vista);
    }
}