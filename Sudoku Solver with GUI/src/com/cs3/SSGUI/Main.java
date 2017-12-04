package com.cs3.SSGUI;

import java.util.Scanner;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static ChoiceBox[] choiceList = new ChoiceBox[81];
	
	//test inputs
		//easy//7 9 0 0 0 0 3 0 0 0 0 0 0 0 6 9 0 0 8 0 0 0 3 0 0 7 6 0 0 0 0 0 5 0 0 2 0 0 5 4 1 8 7 0 0 4 0 0 7 0 0 0 0 0 6 1 0 0 9 0 0 0 8 0 0 2 3 0 0 0 0 0 0 0 9 0 0 0 0 5 4
		//medium//2 5 0 0 0 3 0 9 1 3 0 9 0 0 0 7 2 0 0 0 1 0 0 6 3 0 0 0 0 0 0 6 8 0 0 3 0 1 0 0 4 0 0 0 0 6 0 3 0 0 0 0 5 0 1 3 2 0 0 0 0 7 0 0 0 0 0 0 4 0 6 0 7 6 4 0 1 0 0 0 0 
		//hard//0 0 7 0 0 0 3 0 2 2 0 0 0 0 5 0 1 0 0 0 0 8 0 1 4 0 0 0 1 0 0 9 6 0 0 8 7 6 0 0 0 0 0 4 9 0 0 0 0 0 0 0 0 0 0 0 0 1 0 3 0 0 0 8 0 1 0 6 0 0 0 0 0 0 0 7 0 0 0 6 3
		//hard//5 8 6 0 7 0 0 0 0 0 0 0 9 0 1 6 0 0 0 0 0 6 0 0 0 0 0 0 0 7 0 0 0 0 0 0 9 0 2 0 1 0 3 0 5 0 0 5 0 9 0 0 0 0 0 9 0 0 4 0 0 0 8 0 0 3 5 0 0 0 6 0 0 0 0 0 2 0 4 7 0
		//hard//0 0 0 0 6 8 0 3 0 1 9 0 0 0 0 0 0 0 8 0 3 1 0 0 2 0 0 4 0 0 0 5 1 0 6 0 7 0 0 0 2 0 0 0 4 0 0 0 0 7 0 8 0 0 0 1 0 0 0 5 0 0 7 0 0 4 0 0 0 0 0 0 0 5 0 0 3 0 1 0 0 
		//hard//0 0 4 8 6 0 0 3 0 0 0 1 0 0 0 0 9 0 8 0 0 0 0 9 0 6 0 5 0 0 2 0 6 0 0 1 0 2 7 0 0 1 0 0 0 0 0 0 0 4 3 0 0 6 0 5 0 0 0 0 0 0 0 0 0 9 0 0 0 4 0 0 0 0 0 4 0 0 0 1 5
		//expert//0 0 0 0 0 1 0 4 0 0 0 0 0 0 9 0 0 6 4 7 0 0 0 0 8 0 0 0 0 0 1 0 0 4 7 0 7 0 0 5 9 8 0 0 0 0 1 0 7 0 0 0 3 0 0 0 0 0 0 3 0 0 0 0 0 2 0 0 0 0 0 0 5 0 8 4 0 0 9 0 0
		//expert//0 7 0 0 0 1 9 0 0 0 0 0 0 6 0 0 5 0 0 0 9 0 0 0 0 0 3 0 0 5 6 0 0 0 0 0 0 2 8 0 3 0 0 0 0 7 0 3 0 0 5 0 0 0 1 0 7 9 0 0 0 0 2 2 0 0 0 0 0 0 0 6 3 0 0 1 0 0 0 0 0
		//expert//0 0 0 0 0 2 0 0 3 0 4 0 0 0 1 6 0 7 0 0 1 0 0 0 0 0 4 0 8 0 1 0 0 0 0 0 4 3 0 0 0 0 0 6 2 0 0 0 7 0 0 0 0 0 0 0 0 0 0 0 0 0 0 6 0 9 8 0 7 3 0 0 0 0 0 3 0 4 7 0 0

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
			
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group root = new Group();
		Scene scene = new Scene(root,600, 600);
		
		int[] manta = new int[81];
		
		
		
		
		for(int i = 0; i < 81; i++){
			ChoiceBox<Integer> choiceBox = new ChoiceBox<Integer>();
			
			choiceBox.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
			choiceBox.setValue(0);
		
			choiceBox.setLayoutX((i%9)*55);
			
			
			choiceBox.setLayoutY(Math.floor(i/9)*55);
			choiceList[i] = choiceBox;
		}
		for(int i = 0; i < 81; i++){
			root.getChildren().add(choiceList[i]);
		}
		
		//SOLVE BUTTON 
				Button solve = new Button();
				solve.setLayoutX(250);
				solve.setLayoutY(490);
				solve.setText("Solve");
				
				solve.setOnAction(new EventHandler<ActionEvent>() {
					 
				    @Override
				    public void handle(ActionEvent event) {
				      for(int i = 0; i < 81; i++){
				    	  manta[i] = (int) choiceList[i].getValue();
				      }
				      int[] solved = solve(manta);
				      
				      for(int x = 0; x < 81; x++){
				    	  System.out.println(solved[x]);
				      }
				      
				      for(int i = 0; i < 81; i++){
				    	  choiceList[i].setValue(solved[i]);
				      }
				      
				    }
				});
				root.getChildren().add(solve);
			//clear button
				Button clear = new Button();
				clear.setLayoutX(200);
				clear.setLayoutY(490);
				clear.setText("Clear");
				
				clear.setOnAction(new EventHandler<ActionEvent>() {
					 
				    @Override
				    public void handle(ActionEvent event) {
				      
				      
				      for(int i = 0; i < 81; i++){
				    	  choiceList[i].setValue(0);
				      }
				      
				    }
				});
				root.getChildren().add(clear);
				
		
		Rectangle gridline1 = new Rectangle(0, 150, 480, 15);
		root.getChildren().add(gridline1);
		Rectangle gridline2 = new Rectangle(0, 315, 480, 15);
		root.getChildren().add(gridline2);
		Rectangle gridline3 = new Rectangle(150, 0, 15, 480);
		root.getChildren().add(gridline3);
		Rectangle gridline4 = new Rectangle(315, 0, 15, 480);
		root.getChildren().add(gridline4);
		
		
		primaryStage.setTitle("Sudoku Solver");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static int[] solve(int[] intake){
		Linkedgrid grid = new Linkedgrid(9);
		Node board = grid.getRoot();
		//load onto the grid
		
		int[] manta;
		
		grid.loadBoard(intake);
		
		Solver solver = new Solver();
		
		board = solver.solve(grid.getRoot());
		
		if(Node.isSolved(board) == false){
		
			Guesser guesser = new Guesser(board);
		
			guesser.guess();
		
			board = guesser.getSolution();
		}
		
		return Node.toArray(board);		
		
		
		//grid.display();
		
		
	}

}
