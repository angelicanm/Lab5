package lab5;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private TextField plainTextTextField;
	private Label plainTextLabel;
	private Button b1, b2, b3, b4, b5, b6;
	//  declare two HBoxes
	
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		
		Insets inset = new Insets(10);
		
		//student Task #2:
		
		//  instantiate the buttons, label, and textfield
		plainTextTextField = new TextField();
		plainTextLabel = new Label("Feedback");
		b1 = new Button("Hello");
		b2 = new Button("Howdy");
		b3 = new Button("Chinese");
		b4 = new Button("Clear");
		b5 = new Button("Exit");
		b6 = new Button("Ola!");
		//  instantiate the HBoxes
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		
		//  set margins and set alignment of the components
		HBox.setMargin(b1, inset);
		HBox.setMargin(b2, inset);
		HBox.setMargin(b3, inset);
		HBox.setMargin(b4, inset);
		HBox.setMargin(b5, inset);
		HBox.setMargin(b6, inset);
		
		box1.setAlignment(Pos.CENTER); 
		box2.setAlignment(Pos.CENTER); 
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		
		box2.getChildren().addAll(plainTextTextField, plainTextLabel);
		//  add the buttons to the other HBox
		box1.getChildren().addAll(b1, b2, b3, b4, b5, b6);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1, box2);
		
		b1.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());
		b6.setOnAction(new ButtonHandler());
		
		
		
		
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		
		public void handle(ActionEvent event) {
			
			if (event.getTarget() == b1) {
	            plainTextTextField.setText(dataManager.getHello());
	        }
	        else if (event.getTarget() == b2) {
	        	plainTextTextField.setText(dataManager.getHowdy());
	        }
	        else if (event.getTarget() == b3) {
	        	plainTextTextField.setText(dataManager.getChinese());
	        }
	        else if (event.getTarget() == b6) {
	        	plainTextTextField.setText(dataManager.getOla());
	        }
	        else if (event.getTarget() == b4) {
	        	plainTextTextField.setText("");
	        }
	        else if (event.getTarget() == b5) {
	            Platform.exit();
	            System.exit(0);
	        }
	    }
	}
}
	
