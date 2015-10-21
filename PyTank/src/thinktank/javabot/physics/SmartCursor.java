package thinktank.javabot.physics;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;

	public class SmartCursor {
	
	public DTank moving_object;
	private boolean active;
	
	
	public void setTank ( DTank moving_object ){      
		this.moving_object=moving_object;
		activate();
	}
	
	public DTank getTank(){
	    return moving_object;
	}
	
	public boolean isActive(){  
		return active;
	}
	
	public void activate(){  
		active=true;
	}
	
	public void desactivate(){  
		active=false;
	}
	
	public void setCoordMovingObj(int x, int y){
		moving_object.setCoordX(x);
		moving_object.setCoordY(y);
	}
	
	public void paint (Graphics2D g, int x, int y){
		Graphics2D g2 = g;
		Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.5);
		g2.setComposite(comp);
		moving_object.paint(g2, x, y);
	}
}

	
