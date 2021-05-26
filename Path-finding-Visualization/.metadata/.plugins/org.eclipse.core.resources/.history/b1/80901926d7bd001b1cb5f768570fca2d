package front_end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.Controller;
import back_end.Cell;
import back_end.MazeGenerator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import utils.Constant;

public class GridGenerator 
{
	private GridPane gp = new GridPane();
	private MazeGenerator mazeGenerator = new MazeGenerator();
	private Map<Integer, StackPane> gridMap = new HashMap<Integer, StackPane>();
    
	private ArrayList<Cell> cellList = new ArrayList<Cell>();
    private int startPoint = -1;
    private int endPoint = -1;
    
    public GridGenerator()
    {
    	
    	
    	for(int i = 0; i < Constant.ROW_COUNT; i++)
    	{
    		for(int j = 0 ; j < Constant.COLUMN_COUNT; j++)
    		{
    			StackPane tmp = new StackPane();
    			tmp.setMinSize(20, 20);
    			tmp.setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                gp.add(tmp, j, i);
                cellList.add(new Cell(i, j, Constant.NULL));

                final int rowFinal = i;
                final int columnFinal = j;
                tmp.setOnMouseEntered(evt -> {
                	
                    
                    
                });
                
                tmp.setOnMouseClicked(evt ->{
                	if(Controller.choosingStartPoint)
                	{
                		if(startPoint != -1)
                		{
                			gridMap.get(startPoint).setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                    		cellList.set(startPoint, new Cell(rowFinal, columnFinal, Constant.NULL));
                		}
                		
                		startPoint = rowFinal*Constant.COLUMN_COUNT + columnFinal;
                		tmp.setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                		cellList.set(startPoint, new Cell(rowFinal, columnFinal, Constant.STARTING_POINT));
                		Controller.choosingStartPoint = false;
                		
                	}
                	
                	if(Controller.choosingEndPoint)
                	{
                		if(endPoint != -1)
                		{
                			gridMap.get(endPoint).setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                    		cellList.set(endPoint, new Cell(rowFinal, columnFinal, Constant.NULL));
                		}
                		
                		endPoint = rowFinal*Constant.COLUMN_COUNT + columnFinal;
                		tmp.setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                		cellList.set(endPoint, new Cell(rowFinal, columnFinal, Constant.END_POINT));
                		Controller.choosingEndPoint = false;
                	}
                	
                	if(Controller.buildWall)
                	{
                		tmp.setStyle("-fx-background-color: black; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
                		cellList.set(rowFinal*Constant.COLUMN_COUNT + columnFinal, new Cell(rowFinal, columnFinal, Constant.BLOCKED));
                		
                	}
                	
            	   
               
               });
                
                gridMap.put(i*Constant.COLUMN_COUNT + j, tmp);
    		}
    	}
    	
    }
    
    public Map<Integer, StackPane> getMap()
    {
    	return gridMap;
    }
    
    public GridPane getGridPane()
    {
    	return gp;
    }
    
    public ArrayList<Cell> getCellList()
    {
    	return cellList;
    }
    
    
    public void generateMaze()
    {
    	mazeGenerator.backTrackMaze(startPoint, endPoint);
    	cellList = new ArrayList<Cell>(mazeGenerator.getMaze());
    	this.startPoint = mazeGenerator.getStartPoint();
    	this.endPoint = mazeGenerator.getEndPoint();
    	
    }
    
    public int getStartPoint()
    {
    	return this.startPoint;
    }

    public int getEndPoint()
    {
    	return this.endPoint;
    }
}
