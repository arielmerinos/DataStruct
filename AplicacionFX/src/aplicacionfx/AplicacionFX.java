/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionfx;

import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author kamerinop
 */
public class AplicacionFX extends Application {
    
    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(40,40,30);
        /*Point2D punto = new Point2D(10, 15);
        BoundingBox box = new BoundingBox(200,200,200,200);*/

        Line linea = new Line(0, 0, 50, 50);
        Line linea2 = new Line(50, 250, 2,5);
        Collection<Node> nodos = new ArrayList <Node>();
        nodos.add(linea);
        nodos.add(circle);
        nodos.add(linea2);
        Group root = new Group(nodos);
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Arielín está en JavaFX");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

