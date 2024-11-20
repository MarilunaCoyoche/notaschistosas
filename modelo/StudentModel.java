package modelo;

public class StudentModel {
    // Variables para almacenar las notas de los estudiantes.
    private int nota1;
    private int nota2;
    private int nota3;

    // Método para establecer las notas.
    public void setGrades(int nota1, int nota2, int nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Método para calcular el promedio de las notas.
    public double calculateAverage() {
        return (nota1 + nota2 + nota3) / 3.0; // Promedio simple.
    }

    // Método para obtener las notas como un arreglo.
    public int[] getGrades() {
        return new int[]{nota1, nota2, nota3};
    }
}