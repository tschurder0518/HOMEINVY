package inventory;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import inventory.Inventory;
import items.Item;

public class HOMEINVYApp extends Application {
	/* INTENT: The Main app class that loads and displays the HOMEINVY GUI
	* Allows user to browse through menu's in GUI format.
	*
	* POSTCONDITION1: Display Main Menu in JavaFx window with radio buttons
	* for options.
	* POST2: Navigate to next sub menu based on the users radio button selection
	* and selecting "Get Started!" button.
	* POST3: Display view items sub menu with radio buttons for selections.
	*/ 
	
	// CONSTANT for file name
	static String INVENTORY_FILE = "src/inventory/InventoryFile.txt";
	
	// CONSTANT for all items created from the file
	public static ArrayList<Item> theItems = new ArrayList<Item>();
	
	
    @Override
    public void start(Stage primaryStage) {
    	// POSTCONDITION1
    	// Make primary stage, set with a gridgpane
        primaryStage.setTitle("HOMEINVY: Home Inventory App");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add title to scene
        Text scenetitle = new Text("Welcome to HOMEINVY!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        // Add main menu text
        Text mainMenuText = new Text("Main Menu");
        mainMenuText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        GridPane.setHalignment(mainMenuText, HPos.CENTER);
        grid.add(mainMenuText, 0, 1, 2, 1);

        // Create toggle group for grouping radio buttons
        final ToggleGroup group = new ToggleGroup();

        // Create radio buttons, add to groups, add to gridpane locations
        RadioButton viewItemsBtn = new RadioButton("View items");
        viewItemsBtn.setToggleGroup(group);
        viewItemsBtn.setSelected(true);
        grid.add(viewItemsBtn, 0, 2, 2, 1);

        RadioButton searchBtn = new RadioButton("Search for an item");
        searchBtn.setToggleGroup(group);
        grid.add(searchBtn, 0, 3, 2, 1);
      
        RadioButton addBtn = new RadioButton("Add an item");
        addBtn.setToggleGroup(group);
        grid.add(addBtn, 0, 4, 2, 1);
      
        RadioButton removeBtn = new RadioButton("Remove an item");
        removeBtn.setToggleGroup(group);
        grid.add(removeBtn, 0, 5, 2, 1);
        
        RadioButton reportsBtn = new RadioButton("View reports");
        reportsBtn.setToggleGroup(group);
        grid.add(reportsBtn, 0, 6, 2, 1);
      
        // Create submit button w/text
        Button getStartedBtn = new Button("GET STARTED!");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(getStartedBtn);
        grid.add(hbBtn, 1, 7);

        // Create new scene, set scene settings
        Scene scene = new Scene(grid, 450, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // POST2
        // Set action on clicking the get started button using lambda
        // Creates and takes you to a new scene
        getStartedBtn.setOnAction(e->{
        	// POST3
        	// Create and name new gridpane for this scene
            GridPane grid1 = new GridPane();	
            grid1.setAlignment(Pos.CENTER);
            grid1.setHgap(10);
            grid1.setVgap(10);
            grid1.setPadding(new Insets(25, 25, 25, 25));
            
            // Set title for this scene
            Text viewItemsSceneTitle = new Text("HOMEINVY");
            viewItemsSceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            GridPane.setHalignment(viewItemsSceneTitle, HPos.CENTER);
            grid1.add(viewItemsSceneTitle, 0, 0, 2, 1);
            
            // Add menu text for this scene
            Text viewItemsMenuText = new Text("View Items");
            viewItemsMenuText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
            GridPane.setHalignment(viewItemsMenuText, HPos.CENTER);
            grid1.add(viewItemsMenuText, 0, 1, 2, 1);

            // Create new toggle group for this scene
            final ToggleGroup viewItemsGroup = new ToggleGroup();

            // Create all radio buttons and group together
            RadioButton allItemsBtn = new RadioButton("View all items in inventory");
            allItemsBtn.setToggleGroup(viewItemsGroup);
            allItemsBtn.setSelected(true);
            grid1.add(allItemsBtn, 0, 2, 2, 1);

            RadioButton allToolsBtn = new RadioButton("View all tools");
            allToolsBtn.setToggleGroup(viewItemsGroup);
            grid1.add(allToolsBtn, 0, 3, 2, 1);
            
            RadioButton allElectronicsBtn = new RadioButton("View all electronics");
            allElectronicsBtn.setToggleGroup(viewItemsGroup);
            grid1.add(allElectronicsBtn, 0, 4, 2, 1);
            
            RadioButton allBooksBtn = new RadioButton("View all books");
            allBooksBtn.setToggleGroup(viewItemsGroup);
            grid1.add(allBooksBtn, 0, 5, 2, 1);
            
            RadioButton mainMenuBtn = new RadioButton("Exit to main menu");
            mainMenuBtn.setToggleGroup(viewItemsGroup);
            grid1.add(mainMenuBtn, 0, 6, 2, 1);       	

            // Create and apply new scene for this page
        	Scene viewItemsScene = new Scene(grid1, 450, 400);
        	primaryStage.setScene(viewItemsScene);
        	primaryStage.show();
        	
        	// Create submit button
            Button viewItemsSubmitBtn = new Button("SUBMIT");
            HBox hBoxViewItemsBtn = new HBox(10);
            hBoxViewItemsBtn.setAlignment(Pos.CENTER);
            hBoxViewItemsBtn.getChildren().add(viewItemsSubmitBtn);
            grid1.add(hBoxViewItemsBtn, 1, 7);
            
            // Create TextArea for eventual output of selected content
            TextArea resultText = new TextArea("");
            resultText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
            GridPane.setHalignment(resultText, HPos.CENTER);
            resultText.setPrefRowCount(10);
            resultText.setPrefColumnCount(20);
            resultText.setWrapText(true);
            grid1.add(resultText, 1, 8, 2, 1);
            
            // Testing selectin of radio buttons
            viewItemsSubmitBtn.setOnAction(f->{
        	   if (allItemsBtn.isSelected()) {  
        		   resultText.setText("View all items selected");
        	   }
        	   else if (allToolsBtn.isSelected()) {
        	      resultText.setText("View all tools selected");
        	   }
        	   else if (allElectronicsBtn.isSelected()) {
        		   resultText.setText("View all electronics selected");
        	   }
        	   else if (allBooksBtn.isSelected()) {
        		   resultText.setText("View all books selected");
        	   }
        	   else if (mainMenuBtn.isSelected()) {
        		   resultText.setText("Exit to main menu selected");
        	   }
            	
            }); // End of View Items sub menu scene
        }); // End of main menu scene
    }
	
	
	public static void main(String[] args) {
		// create a HOMEINVY object and call its start method
		 try {
			 theItems = Inventory.readInventory(INVENTORY_FILE);
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		
		launch(args);
	
	}
}
