package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class VideoPlayer extends Application {

    private static String videoPath; // Ruta del video a reproducir

    // Método para iniciar la aplicación JavaFX
    @Override
    public void start(Stage primaryStage) {
        // Crear un objeto Media con la ruta del archivo de video
        Media media = new Media(new File(videoPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        StackPane root = new StackPane();
        root.getChildren().add(mediaView); // Añadir el MediaView al contenedor

        Scene scene = new Scene(root, 800, 600); // Tamaño de la ventana
        primaryStage.setScene(scene);
        primaryStage.setTitle("Reproductor de Video");
        primaryStage.show();

        mediaPlayer.play(); // Reproducir el video
    }

    // Método para iniciar la reproducción del video desde el controlador.
    public static void playVideo(String filePath) {
        videoPath = filePath; // Establecer la ruta del video
        launch(); // Iniciar la aplicación JavaFX
    }
}