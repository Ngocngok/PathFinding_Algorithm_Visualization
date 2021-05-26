package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import back_end.Cell;
import back_end.SearchingAlgo;
import front_end.GridGenerator;
import front_end.Painter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import utils.Constant;

public class Controller implements Initializable
{
	Map<Integer, StackPane> gridMap;
	ArrayList<Cell> cellList;
	
	
	
	GridGenerator gridGenerator = new GridGenerator();
	Painter painter = new Painter();
	SearchingAlgo searchingAlgo;
	
	private String algoChoosing = ""; 
	
	public static boolean choosingStartPoint = false;
	public static boolean choosingEndPoint = false;
	public static boolean addWeight = false;
	public static boolean buildWall = false;
	
	//Task for autorun visualization??
	public static Timer taskTimer;
	AutorunTask autoTask;
	
	
	
	@FXML
	private HBox gridRegion;
	@FXML
	private Button _spButton;
	@FXML
	private Button _epButton;
	@FXML
	private Button _startButton;
	@FXML
	private Button _stopButton;
	@FXML
	private Button _resumeButton;
	@FXML
	private Button _nextButton;
	@FXML
	private Button _backButton;
	@FXML
	private Button _resetButton;
	@FXML
	private Button _wallButton;
	@FXML
	private Button _mazeButton;
	@FXML
	public void chooseStartPoint()
	{
		choosingStartPoint = true;
		choosingEndPoint = false;
		buildWall = false;
	}
	@FXML
	private void chooseEndPoint()
	{
		choosingEndPoint = true;
		choosingStartPoint = false;
		buildWall = false;
	}
	@FXML 
	private void buildWall()
	{
		if(buildWall == false)
		{
			buildWall = true;
			choosingEndPoint = false;
			choosingStartPoint = false;
		}
		
		else
		{
			buildWall = false;
		}
		
	}
	@FXML
	private void onStart()
	{
		boolean invalid = false;
		if(algoChoosing == "")
		{
			new Alert(Alert.AlertType.WARNING, "Please choose an algorithm first!").showAndWait();
			invalid = true;
		}
		
		if(gridGenerator.getStartPoint() == -1)
		{
			new Alert(Alert.AlertType.WARNING, "Please choose the start point first!").showAndWait();
			invalid = true;
		}
		
		if(gridGenerator.getEndPoint() == -1)
		{
			new Alert(Alert.AlertType.WARNING, "Please choose the end point first!").showAndWait();
			invalid = true;
		}
		
		if(invalid)
		{
			return;
		}
		
		//debugPrint();
		
		cellList = gridGenerator.getCellList();
		searchingAlgo = new SearchingAlgo();
		
		if(algoChoosing == "AStar")
		{
			searchingAlgo.AStarAlgo(cellList);
		}
		
		else if(algoChoosing == "Dijkstra")
		{	
			searchingAlgo.DijkstraAlgo(cellList);
		}
		else if(algoChoosing == "BreadthFirst")
		{
			searchingAlgo.BreadthFirst(cellList);
		}
		else if(algoChoosing == "DepthFirst")
		{
			searchingAlgo.DepthFirst(cellList);
		}
		
		_startButton.setDisable(true);
		_nextButton.setDisable(true);
		_backButton.setDisable(true);
		_wallButton.setDisable(true);
		_spButton.setDisable(true);
		_epButton.setDisable(true);
		_mazeButton.setDisable(true);
		
		this.autoTask = new AutorunTask();
		Controller.taskTimer = new Timer();
		Controller.taskTimer.schedule(autoTask, 0, Constant.RUN_SPEED);
		
		
	}
	@FXML
	private void onStop()
	{
		_nextButton.setDisable(true);
		_backButton.setDisable(true);
		
		Controller.taskTimer.cancel();
	}
	@FXML 
	private void onNext()
	{
		ArrayList<Cell> step = searchingAlgo.getStepManager().getNextStep();
		painter.paint(gridMap, step);
		
	}
	@FXML
	private void onBack()
	{
		_resumeButton.setDisable(false);
		
		ArrayList<Cell> step = searchingAlgo.getStepManager().getPreviousStep();
		painter.paint(gridMap, step);
	}
	@FXML
	private void onResume()
	{
		_nextButton.setDisable(false);
		_backButton.setDisable(false);
		
		this.autoTask = new AutorunTask();
		Controller.taskTimer = new Timer();
		Controller.taskTimer.schedule(autoTask, 0, Constant.RUN_SPEED);
		
	}
	@FXML
	private void onReset()
	{
		gridGenerator = new GridGenerator();
		gridRegion.getChildren().remove(0);
		gridRegion.getChildren().add(gridGenerator.getGridPane());
		gridMap = gridGenerator.getMap();
		
		_startButton.setDisable(false);
		_nextButton.setDisable(true);
		_backButton.setDisable(true);
		_resumeButton.setDisable(true);
		_wallButton.setDisable(false);
		_spButton.setDisable(false);
		_epButton.setDisable(false);
		_mazeButton.setDisable(false);
		
		Controller.taskTimer.cancel();
	}
	@FXML
	private void aStarSearch()
	{
		algoChoosing = "AStar";
	}
	@FXML
	private void dijkstraAlgorithm()
	{
		algoChoosing = "Dijkstra";
	}
	@FXML
	private void breadthFirstSearch()
	{
		algoChoosing = "BreadthFirst";
	}
	@FXML
	private void depthFirstSearch()
	{
		algoChoosing = "DepthFirst";
	}
	@FXML
	private void generateMaze()
	{
		_spButton.setDisable(true);
		_epButton.setDisable(true);
		gridGenerator.generateMaze();
		painter.paintMatrix(gridMap, gridGenerator.getCellList());
		
		_mazeButton.setDisable(true);
	}
	
	public void initialize(URL location, ResourceBundle resources) 
	{
		gridRegion.getChildren().add(gridGenerator.getGridPane());
		gridMap = gridGenerator.getMap();
	}
	
	
	/*
	public void debugPrint()
	{
		ArrayList<Cell> tmp = gridGenerator.getCellList();
		for(int i = 0; i < tmp.size(); i++)
		{
			System.out.print(tmp.get(i).getStatus() + "\t");
			if(i%7 == 6)
			{
				System.out.print("\n");
			}
		}
	}
	*/
	public void disableButton(ArrayList<Button> list)
	{
		for(Button button : list)
		{
			button.setDisable(true);
		}
	}
	
	
	private class AutorunTask extends TimerTask
	{
		
		
		public  void run()
		{
			
			ArrayList<Cell> step = searchingAlgo.getStepManager().getNextStep();
			
			if(step == null)
			{
				//_startButton.setDisable(false);
				_nextButton.setDisable(false);
				_backButton.setDisable(false);
				//_wallButton.setDisable(false);
				//_spButton.setDisable(false);
				//_epButton.setDisable(false);
				//_mazeButton.setDisable(false);
				//_stopButton.setDisable(false);
				//_resumeButton.setDisable(false);
				_resetButton.setDisable(false);
				Controller.taskTimer.cancel();
				
			}
			painter.paint(gridMap, step);
			
			
		}
		
		
		
		
	}
	
	

}
