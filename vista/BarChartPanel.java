package vista;

import javax.swing.*;
import java.awt.*;

public class BarChartPanel extends JPanel {
    private int[] grades; 

    public BarChartPanel(int[] grades) { 
        this.grades = grades; 
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g; 
        
        int maxHeight = 200; 
        int barWidth = 50; 
        
        for (int i = 0; i < grades.length; i++) { 
            int height = (int)((grades[i] / 20.0) * maxHeight); 
            g2d.fillRect(i * (barWidth + 10), maxHeight - height, barWidth, height); 
            g2d.drawString(String.valueOf(grades[i]), i * (barWidth + 10), maxHeight - height - 5); 
            g2d.drawString("Nota " + (i + 1), i * (barWidth + 10), maxHeight + 15); 
            // Dibujar cada barra y su respectiva etiqueta con la calificación correspondiente.
         }
        
         g2d.drawLine(0, maxHeight, getWidth(), maxHeight); 
         // Dibujar línea del eje X en el gráfico.    
     }
}