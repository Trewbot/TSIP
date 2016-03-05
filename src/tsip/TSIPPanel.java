package tsip;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public class TSIPPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public int x = 10, y = 10, w, h;
	public BufferedImage img;
	@Override
	public void paintComponent(Graphics g){
		if(img != null){
			boolean useImage = true;
			if(useImage){
				Color tmp = new Color(
					img.getRGB(
						(int)((double)x*((double)img.getWidth()/(double)w)),
						(int)((double)y*((double)img.getHeight()/(double)h)))
				);
				g.setColor(new Color(tmp.getRed(),tmp.getGreen(),tmp.getBlue(),30));
			}else{
				double dist = Math.abs((int)Math.sqrt(Math.pow(x - 640, 2) + Math.pow(y - 360, 2))),
					   max  = 500;
				int[] clr = hue(dist / max);
				g.setColor(new Color(clr[0],clr[1],clr[2],30));
			}
			g.fillRect(x - 4, y - 4, 9, 9);
		}
	}
	public int[] hue(double h){
		double r = 0, g = 0, b = 0,
			m = Math.floor(h*6),
			f = h*6-m,
			q = 1-f,
			t = 1-q;
		switch((int)(m%6)){
			case 0:r=1;g=t;b=0;break;
			case 1:r=q;g=1;b=0;break;
			case 2:r=0;g=1;b=t;break;
			case 3:r=0;g=q;b=1;break;
			case 4:r=t;g=0;b=1;break;
			case 5:r=1;g=0;b=q;break;
		}
		return new int[]{
			(int)Math.floor(r*255),
			(int)Math.floor(g*255),
			(int)Math.floor(b*255)
		};
	}
}
