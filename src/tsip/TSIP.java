package tsip;
import java.awt.*;
import java.awt.image.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class TSIP {
	static int x = 10;
	static int y = 10;
	public static void main(String[] args) throws IOException, InterruptedException{
		
		JFrame frame = new JFrame();
		frame.setTitle("Test");
		frame.setSize(1200, 900);
		Container panel = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TSIPPanel label = new TSIPPanel();
		label.setBackground(Color.BLACK);
		panel.setBackground(Color.CYAN);
		
		panel.add(label);
		panel.setVisible(true);
		frame.setVisible(true);
		Random rand = new Random();
		
		BufferedImage img = ImageIO.read(new FileInputStream("test.jpg"));
		label.img = img;
		label.w = 1200;
		label.h = 900;
		while(true){
			label.x = rand.nextInt(1200);
			label.y = rand.nextInt(900);
		    label.repaint();
		    Thread.sleep(3);
		}
	}
}
