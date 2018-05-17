/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Estudiante
 */
public class Events extends Application {
    
    private Stage primaryStage;
    private Scene escena1;
    private Scene escena2;
    
    //private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        //primaryStage = this.primaryStage;
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Label label1 = new Label("Nombre: ");
        TextField textFieldNombre = new TextField();
        Label label2 = new Label("Apellido: ");
        TextField textFieldApellido = new TextField();
        Button buttonInsert = new Button("Insertar");
        Label mensajeLb = new Label();
        
        MenuBar menuBar1 = new MenuBar();
        Menu menu = new Menu("Menu 1");
        MenuItem menuItem = new MenuItem("item 1");
        menu.getItems().add(menuItem);
        menuBar1.getMenus().add(menu);
        
        
        GridPane grid1 = new GridPane();
        grid1.add(label1, 0, 0);
        grid1.add(textFieldNombre, 1, 0);
        grid1.add(label2, 0, 1);
        grid1.add(textFieldApellido, 1, 1);
        grid1.add(buttonInsert, 1, 2);
        grid1.add(mensajeLb, 0, 3, 3,3);
        
        buttonInsert.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (textFieldNombre.getText().equals("") ) {
                    mensajeLb.setText("No hay nada");
                }
                mensajeLb.setText("Hola "+ textFieldNombre.getText() + " " + textFieldApellido.getText() );
                
            }
        });
        
        class JustRight implements EventHandler<ActionEvent>{
            @Override
            public void handle(ActionEvent t) {
                mensajeLb.setText("No soy un virus :^]");
            }
        }
        
        class ItemMenuHandler implements EventHandler<ActionEvent>{
            @Override
            public void handle(ActionEvent event){
                
            }
        }
        
        Button buttonTst = new  Button("No soy un virus :^]");
        buttonTst.setOnAction(new JustRight());
        
        BorderPane bpane1 = new BorderPane();
        bpane1.setTop(menuBar1);
        bpane1.setCenter(grid1);
        bpane1.setBottom(buttonTst);
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(bpane1, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
