package application;

import javafx.scene.paint.Color;

public class Modele {

	private boolean selectmoveBtn;
	private boolean ellipseBtn;
	private boolean rectangleBtn;
	private boolean lineBtn;
		
	private Color couleur;
	
	public Modele(boolean selectmoveBtn, boolean ellipseBtn, 
					boolean rectangleBtn, boolean lineBtn) {

		this.selectmoveBtn = selectmoveBtn;
		this.ellipseBtn = ellipseBtn;
		this.rectangleBtn = rectangleBtn;
		this.lineBtn = lineBtn;
	}
	
	//color
	
	public Color getColor() {
		return this.couleur;
	}
	
	public void setColor(Color c) {
		this.couleur = c;
	}
	
	//select/move
	
	public boolean getSelectmoveBtn() {
		return this.selectmoveBtn;
	}
	
	public void setSelectmoveBtn(boolean smBtn) {
		this.selectmoveBtn = smBtn;
	}
	
	//ellipse
	
	public boolean getEllipseBtn() {
		return this.ellipseBtn;
	}
	
	public void setEllipseBtn(boolean eBtn) {
		this.ellipseBtn = eBtn;
	}
	
	//rectangle
	
	public boolean getRectangleBtn() {
		return this.rectangleBtn;
	}
	
	public void setRectangleBtn(boolean rBtn) {
		this.rectangleBtn = rBtn;
	}
	
	//ligne
	
	public boolean getLineBtn() {
		return this.lineBtn;
	}
	
	public void setLineBtn(boolean lBtn) {
		this.lineBtn = lBtn;
	}
	
	
	
}
