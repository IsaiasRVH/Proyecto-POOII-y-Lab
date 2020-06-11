/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class Imagen extends javax.swing.JPanel{
    public String URL;
    
    public Imagen(int width, int height, String URL) {
        this.setSize(width, height);
        this.URL = URL;
    }

    
    public void paint(Graphics grafico) {
        Dimension size = getSize();
        
        //Se seleccina la imagen
        ImageIcon img = new ImageIcon(getClass().getResource(URL));
        
        //Se dibuja la imagen
        grafico.drawImage(img.getImage(), 0, 0, size.width, size.height, null);
        
        setOpaque(false);
        super.paintComponent(grafico);
    }
}
