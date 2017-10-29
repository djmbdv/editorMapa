
package editor.mapa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
/**
 *
 * @author djmbdv
 */
public class Lienzo extends JPanel implements MouseListener,MouseMotionListener{
    private int matriz [][];
    BufferedImage img;
    int pincel;
    int ancho;
    int alto;
    public void setPincel(int i){
        pincel = i;
    }
    public int [][] getMatriz(){
        return matriz;
    }
    public Lienzo(){
        ancho = 20;
        alto = 16;
        pincel  = 1;
        matriz =  new int[24][32];
        img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\alixo\\Documents\\NetBeansProjects\\Editor Mapa\\src\\muro.png"));
        } catch (IOException e) {
            System.err.println(e);
        }
        addMouseListener(this);
        addMouseMotionListener(this);
        
    }
    
    private void setCasilla(Point p, int n){
        try{
            matriz[p.y/32][p.x/32] = n;
        }catch(Exception e){
         
        }
    }
    public String matrizString(){
        String s = "";
        for(int j = 0; j < alto; j++){
            for(int i = 0; i < ancho; i++){
                s+= matriz[j][i] + " ";
            }
            s+="\r\n";
        }
        return s;
    }
    @Override
    public void paintComponent(Graphics g){
        this.getParent().repaint();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        for(int j = 0; j < alto; j++){
            for(int i = 0; i < ancho; i++){
                switch(matriz[j][i]){
                    case 0:
                    g.fillRect(i*32, j*32, 32, 32);
                    break;
                    case 1:
                    g.drawImage(img, i*32, j*32, 32, 32, this);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setCasilla(e.getPoint(), pincel);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        setCasilla(e.getPoint(), pincel);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
