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
	
	

	/**
	 * Constructeur
	 */
	public Controller() {
		model = new Modele(false, false, false, false);
	}

	/**
	 * Méthode qui permet de creer un rectangle
	 * @param x
	 * @param y
	 * @param array
	 * @return rectangle
	 */
	private Rectangle creerRectangle(double x, double y, ArrayList<Rectangle> array) {
		Rectangle r = new Rectangle(x,y,100,100);
		r.setFill(colorpicker.getValue());
		r.setStroke(Color.BLACK);
		array.add(r);
		return r;
	}
	
	/**
	 * Méthode qui permet de creer une ellipse
	 * @param x
	 * @param y
	 * @param array
	 * @return ellipse
	 */
	private Ellipse creerEllipse(double x, double y, ArrayList<Ellipse> array) {
		Ellipse e = new Ellipse(x,y,100,50);
		e.setFill(colorpicker.getValue());
		e.setStroke(Color.BLACK);
		e.setStrokeWidth(5);
		array.add(e);
		return e;
	}
	
	/**
	 * Méthode qui permet de creer une ligne
	 * @param xi
	 * @param yi
	 * @param xf
	 * @param yf
	 * @param array
	 * @return line
	 */
	private Line creerLine(double xi, double yi, double xf, double yf, ArrayList<Line> array) {
		Line l = new Line(xi,yi,xf,yf);
		l.setStroke(colorpicker.getValue());
		array.add(l);
		return l;
	}
	
	
	/**
	 * Methode qui permet de tracer un rectangle
	 * @param r
	 * @param x
	 * @param y
	 * @return rectangle
	 */
	private Rectangle traceRectangle(Rectangle r,double x, double y) {
		r.setWidth(x);
		r.setHeight(y);
		return r;
	}
	
	/**
	 * Methode qui permet de tracer une ellipse
	 * @param e
	 * @param x
	 * @param y
	 * @return ellipse
	 */
	private Ellipse traceEllipse(Ellipse e,double x, double y) {
		e.setRadiusX(x);
		e.setRadiusY(y);
		return e;
	}
	
	/**
	 * Methode qui permet de tracer une ligne
	 * @param l
	 * @param x
	 * @param y
	 * @return line
	 */
	private Line traceLine(Line l, double x, double y) {
		l.setEndX(x);
		l.setEndY(y);
		return l;
	}
	
	/**
	 * Methode qui permet d'activer le radio bouton select/move  
	 * @param event
	 */
	private void clickS(MouseEvent event) {
		model.setSelectmoveBtn(true);
		model.setEllipseBtn(false);
		model.setRectangleBtn(false);
		model.setLineBtn(false);
	}
	
	/**
	 * Methode qui permet d'activer le radio bouton rectangle  
	 * @param event
	 */
	private void clickR(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(false);
		model.setRectangleBtn(true);
		model.setLineBtn(false);
	}
	
	/**
	 * Methode qui permet d'activer le radio bouton ellipse
	 * @param event
	 */
	private void clickE(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(true);
		model.setRectangleBtn(false);
		model.setLineBtn(false);
	}
	
	/**
	 * Methode qui permet d'activer le radio bouton ligne
	 * @param event
	 */
	private void clickL(MouseEvent event) {
		model.setSelectmoveBtn(false);
		model.setEllipseBtn(false);
		model.setRectangleBtn(false);
		model.setLineBtn(true);
	}
	
	
	
	@FXML
	public void initialize()
    {
		
		ArrayList<Rectangle> aR = new ArrayList<Rectangle>();
		ArrayList<Ellipse> aE = new ArrayList<Ellipse>();
		ArrayList<Line> aL = new ArrayList<Line>();
		
		ArrayList<Double> aX = new ArrayList<Double>();
		ArrayList<Double> aY = new ArrayList<Double>();
		
		ArrayList<Rectangle> stockR = new ArrayList<Rectangle>();
		ArrayList<Ellipse> stockE = new ArrayList<Ellipse>();
		ArrayList<Line> stockL = new ArrayList<Line>();
		
		//eventHandler pour les radio boutons
		
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
		
		selectmoveBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				clickS(mouseEvent);
			}
		});
		
		

		//eventHandler pour le pane
		//quand on presse la souris
		pane.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(model.getRectangleBtn() == true) {
					Rectangle r = creerRectangle(mouseEvent.getX(),mouseEvent.getY(),aR);
					traceRectangle(r,mouseEvent.getX(),mouseEvent.getY());
					aR.add(r);
					stockR.add(r);
					aX.add(mouseEvent.getX());
					aY.add(mouseEvent.getY());
					
					
					r.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							if (model.getSelectmoveBtn()) {
								r.setHeight(r.getHeight()*1.1);
								r.setWidth(r.getWidth()*1.1);
							}
						}
					});
					
					
					pane.getChildren().add(r);
					
				}
				if(model.getEllipseBtn() == true) {
					Ellipse e = creerEllipse(mouseEvent.getX(),mouseEvent.getY(),aE);
					traceEllipse(e,mouseEvent.getX(),mouseEvent.getY());
					aE.add(e);
					stockE.add(e);
					aX.add(mouseEvent.getX());
					aY.add(mouseEvent.getY());
					
					e.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							if (model.getSelectmoveBtn()) {
								e.setRadiusX(e.getRadiusX()*1.1);
								e.setRadiusY(e.getRadiusY()*1.1);
							}
						}
					});
										
					pane.getChildren().add(e);
					
				}
				if(model.getLineBtn() == true) {
					Line l = creerLine(mouseEvent.getX(),mouseEvent.getY()
							,mouseEvent.getX(),mouseEvent.getY(),aL);
					traceLine(l,mouseEvent.getX(),mouseEvent.getY());
					aL.add(l);
					stockL.add(l);
					aX.add(mouseEvent.getX());
					aY.add(mouseEvent.getY());
					
					l.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							if (model.getSelectmoveBtn()) {
								l.setStartX(l.getStartX()*1.1);
								l.setStartY(l.getStartY()*1.1);	
								l.setEndX(l.getEndX()*1.1);
								l.setEndY(l.getEndY()*1.1);
							}
						}
					});
					
					pane.getChildren().add(l);
				}
					
			}
		});
		
		//quand on drag & drop les figures
		pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent mouseEvent) {
				if(model.getRectangleBtn() == true) {
					traceRectangle(aR.get(aR.size()-1), mouseEvent.getX() - (aX.get(aX.size()-1) ),
							mouseEvent.getY() - (aY.get(aY.size()-1)));
					
					
					(aR.get(aR.size()-1)).addEventHandler(MouseEvent.MOUSE_DRAGGED, 
														new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
						if (model.getSelectmoveBtn()) {
							(aR.get(aR.size()-1)).setWidth(mouseEvent.getX());
							(aR.get(aR.size()-1)).setHeight(mouseEvent.getY());
						}
						}
					});
					
					
					deleteBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							pane.getChildren().remove(aR.get(aR.size()-1));
						}
					});
							
					
					cloneBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							//je n'ai pas reussi
						}
					});
					
				}
				if(model.getEllipseBtn() == true) {
					traceEllipse(aE.get(aE.size()-1), mouseEvent.getX(),
							mouseEvent.getY());
					
					(aE.get(aE.size()-1)).addEventHandler(MouseEvent.MOUSE_DRAGGED, 
							new EventHandler<MouseEvent>(){
							@Override
							public void handle(MouseEvent mouseEvent) {
								if (model.getSelectmoveBtn()) {
									(aE.get(aE.size()-1)).setCenterX(mouseEvent.getX());
									(aE.get(aE.size()-1)).setCenterY(mouseEvent.getY());
								}
							}
					});
					
					deleteBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							pane.getChildren().remove(aE.get(aE.size()-1));
						}
					});
					
					cloneBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							//je n'ai pas reussi
						}
					});
					
				}
				if(model.getLineBtn() == true) {
					traceLine(aL.get(aL.size()-1), mouseEvent.getX(),
							mouseEvent.getY());
					
					(aL.get(aL.size()-1)).addEventHandler(MouseEvent.MOUSE_DRAGGED, 
							new EventHandler<MouseEvent>(){
							@Override
							public void handle(MouseEvent mouseEvent) {
								if (model.getSelectmoveBtn()) {
									(aL.get(aL.size()-1)).setTranslateX(mouseEvent.getX());
									(aL.get(aL.size()-1)).setTranslateY(mouseEvent.getY());
								}
							}
					});
					
					deleteBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							pane.getChildren().remove(aL.get(aL.size()-1));
						}
					});
					
					cloneBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
						@Override
						public void handle(MouseEvent mouseEvent) {
							//je n'ai pas reussi
						}
					});
					
					
				}
				

			} 
		});
		
		
		}
}

