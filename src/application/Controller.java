package application;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Controller 
{
	
	private Modele model;
	
	@FXML
	private Pane pane;
	
	//RadioButton
	
	@FXML
	private RadioButton selectmoveBtn;
	
	@FXML
	private RadioButton ellipseBtn;
	
	@FXML
	private RadioButton rectangleBtn;
	
	@FXML
	private RadioButton lineBtn;
	
	
	ToggleGroup btn;
	
	
	//Colorpicker
	@FXML
	private ColorPicker colorpicker;
	
	
	//Buttons
	@FXML
	private Button deleteBtn;
	
	@FXML
	private Button cloneBtn;
	
	
	private Color couleur;
	
	

	
	
	public Controller() {
		model = new Modele(this, false, false, false, false);
	}

	
	private Rectangle creerRectangle(double x, double y, ArrayList<Rectangle> array) {
		Rectangle r = new Rectangle(x,y,100,100);
		r.setFill(colorpicker.getValue());
		r.setStroke(Color.BLACK);
		array.add(r);
		return r;
	}
	
	private Ellipse creerEllipse(double x, double y, ArrayList<Ellipse> array) {
		Ellipse e = new Ellipse(x,y,100,50);
		e.setFill(colorpicker.getValue());
		e.setStroke(Color.BLACK);
		e.setStrokeWidth(5);
		
		array.add(e);
		return e;
	}
	
	private Line creerLine(double xi, double yi, double xf, double yf) {
		Line l = new Line();
		l.setStartX(xi);
		l.setStartY(yi);
		l.setEndX(xf);
		l.setEndY(yf);
		return l;
	}
	
	private Rectangle traceRectangle(Rectangle r,double x, double y) {
		r.setWidth(x);
		r.setHeight(y);
		return r;
	}
	
	private Ellipse traceEllipse(Ellipse e,double x, double y) {
		e.setCenterX(x);
		e.setCenterY(y);
		return e;
	}
	
	private void clickS(MouseEvent event) {
		model.setSelectmoveBtn(true);
		model.setEllipseBtn(false);
		model.setRectangleBtn(false);
		model.setLineBtn(false);
	}
	
	private void clickR(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(false);
		model.setRectangleBtn(true);
		model.setLineBtn(false);
	}
	
	private void clickE(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(true);
		model.setRectangleBtn(false);
		model.setLineBtn(false);
	}
	
	private void clickL(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(false);
		model.setRectangleBtn(false);
		model.setLineBtn(true);
	}
	
	
	
	@FXML
	public void initialize()
    {
		btn = new ToggleGroup();
		
		selectmoveBtn.setToggleGroup(btn);
		ellipseBtn.setToggleGroup(btn);
		rectangleBtn.setToggleGroup(btn);
		lineBtn.setToggleGroup(btn);
		

		selectmoveBtn.setSelected(true);
		
		ArrayList<Rectangle> aR = new ArrayList<Rectangle>();
		ArrayList<Ellipse> aE = new ArrayList<Ellipse>();
		ArrayList<Line> aL = new ArrayList<Line>();
		
		ArrayList<Double> aX = new ArrayList<Double>();
		ArrayList<Double> aY = new ArrayList<Double>();
		
		ellipseBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				clickE(mouseEvent);
			}
		});
		
		rectangleBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				clickR(mouseEvent);
			}
		});
		
		lineBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				clickL(mouseEvent);
			}
		});
		
		colorpicker.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				//clickC(mouseEvent);
			}
		});

		//setOnMouseDragged(new EventHandler<MouseEvent>()
		pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(model.getRectangleBtn() == true) {
					Rectangle r = creerRectangle(mouseEvent.getX(),mouseEvent.getY(),aR);
					traceRectangle(r,mouseEvent.getX(),mouseEvent.getY());
					aR.add(r);
					aX.add(mouseEvent.getX());
					aY.add(mouseEvent.getY());
					pane.getChildren().add(r);
				}
				if(model.getEllipseBtn() == true) {
					Ellipse e = creerEllipse(mouseEvent.getX(),mouseEvent.getY(),aE);
					traceEllipse(e,mouseEvent.getX(),mouseEvent.getY());
					aE.add(e);
					pane.getChildren().add(e);
				}
					
			}
		});
		
		
		pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
								
				traceRectangle(aR.get(aR.size()-1), mouseEvent.getX() - (aX.get(aX.size()-1) ),
						mouseEvent.getY() - (aY.get(aY.size()-1)));
			}
		});
		
			
		
		
		}
}
