package application;

import javafx.scene.paint.Color;

public class Modele {

	private boolean selectmoveBtn;
	private boolean ellipseBtn;
	private boolean rectangleBtn;
	private boolean lineBtn;
		
	private Controller ctrl;
	private Color couleur;
	
	public Modele(Controller ctrl, boolean selectmoveBtn, boolean ellipseBtn, 
					boolean rectangleBtn, boolean lineBtn) {
		this.ctrl = ctrl;
		this.selectmoveBtn = selectmoveBtn;
		this.ellipseBtn = ellipseBtn;
		this.rectangleBtn = rectangleBtn;
		this.lineBtn = lineBtn;
	}
	
	public Color getColor() {
		return this.couleur;
	}
	
	public void setColor(Color c) {
		this.couleur = c;
	}
	
	public boolean getSelectmoveBtn() {
		return this.selectmoveBtn;
	}
	
	public void setSelectmoveBtn(boolean smBtn) {
		this.selectmoveBtn = smBtn;
	}
	
	public boolean getEllipseBtn() {
		return this.ellipseBtn;
	}
	
	public void setEllipseBtn(boolean eBtn) {
		this.ellipseBtn = eBtn;
	}
	
	public boolean getRectangleBtn() {
		return this.rectangleBtn;
	}
	
	public void setRectangleBtn(boolean rBtn) {
		this.rectangleBtn = rBtn;
	}
	
	public boolean getLineBtn() {
		return this.lineBtn;
	}
	
	public void setLineBtn(boolean lBtn) {
		this.lineBtn = lBtn;
	}
	
	
	
}
