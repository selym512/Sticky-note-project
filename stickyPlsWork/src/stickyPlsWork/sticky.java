package stickyPlsWork;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;




public class sticky extends Application{
	
	Button button;

	public static void main(String[] args) {
		launch(args);
	}
	
	 @Override
	    public void start(Stage primaryStage) throws Exception {
		 	//Instantiates scene, layouts, stage
	        VBox layout = new VBox();
		 	Scene scene = new Scene(layout, 200, 150);
	        primaryStage.setScene(scene);
	        HBox buttons = new HBox();
	        primaryStage.setTitle("Sticky");
	        
	        //Instantiates buttons and text area
	        Button NewStickyB = new Button();
	        NewStickyB.setText("New Sticky");
	        Button SaveStickyB = new Button();
	        SaveStickyB.setText("Save");
	        TextArea UserNotes = new TextArea();
	        
	        //populate layouts and adjusts
	        buttons.getChildren().addAll(NewStickyB, SaveStickyB);
	        layout.getChildren().addAll(buttons, UserNotes);
	        UserNotes.setWrapText(true);
	        UserNotes.wrapTextProperty();
	        UserNotes.setPrefRowCount((int) scene.getHeight());
	        
	        //scans in saved note at start
	        File file = new File("the-file-name.txt");
	        Scanner scanner = new Scanner(file);
	        int i = 0;
	        while(scanner.hasNextLine()){
	        UserNotes.insertText(i, (scanner.nextLine() + '\n'));
	        i = UserNotes.getCaretPosition();
	        }
	        
	        
	        //save button pressed
	        SaveStickyB.setOnAction(new EventHandler<ActionEvent>(){
	        	@Override public void handle(ActionEvent e){
	        		//look into try catch block, test git
					try {
		        		PrintWriter writer;
						writer = new PrintWriter("the-file-name.txt", "UTF-8");
						for(int i = 0; i < UserNotes.getParagraphs().size(); i++){
						writer.println(UserNotes.getParagraphs().get(i));
						}
		        		writer.close();
		        		
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

	        		
	        	}
	        });
	        
	        
	        primaryStage.show();
	    }

}
