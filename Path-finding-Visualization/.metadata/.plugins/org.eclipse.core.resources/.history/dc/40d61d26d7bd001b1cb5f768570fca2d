package front_end;

import java.util.ArrayList;
import java.util.Map;

import back_end.Cell;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.StackPane;
import utils.Constant;

public class Painter 
{
	public void paint(Map<Integer, StackPane> map, ArrayList<Cell> step)
	{
		if(step == null)
		{
			System.out.println("No");
			return;
		}
		for(Cell cell : step)
		{
			if(cell.getStatus() == Constant.EVALUATING)
			{
				getTileFromMap(map, cell).setStyle("-fx-background-color: red; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
				AnimationTimer myTimer = new MyTimer(getTileFromMap(map, cell), 0.05);
				myTimer.start();
			}
			
			if(cell.getStatus() == Constant.PATH)
			{
				getTileFromMap(map, cell).setStyle("-fx-background-color: blue; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
			}
			
			if(cell.getStatus() == Constant.NULL)
			{
				getTileFromMap(map, cell).setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
				
			}
			
			if(cell.getStatus() == Constant.STARTING_POINT)
			{
				getTileFromMap(map, cell).setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
			}
			
			if(cell.getStatus() == Constant.END_POINT)
			{
				getTileFromMap(map, cell).setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
			}
			
			
		}
		
	}
	
	public void paintMatrix(Map<Integer, StackPane> map, ArrayList<Cell> matrix)
	{
		for(Cell cell : matrix)
		{
			if(cell.getStatus() == Constant.BLOCKED)
			{
							
				int index = matrix.indexOf(cell);
				map.get(index).setStyle("-fx-background-color: black; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
				AnimationTimer myTimer = new MyTimer(map.get(index), 0.05);
				myTimer.start();
							
			}
			else if(cell.getStatus() == Constant.NULL)
			{
				int index = matrix.indexOf(cell);
				map.get(index).setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
			}
			else
			{
				int index = matrix.indexOf(cell);
				map.get(index).setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
			}
			
		}
	}
	
	/*
	private class paintMatrixThread extends Thread
	{
		public void run(Map<Integer, StackPane> map, ArrayList<Cell> matrix)
		{
			for(Cell cell : matrix)
			{
				if(cell.getStatus() == Constant.BLOCKED)
				{
					int index = matrix.indexOf(cell);
					map.get(index).setStyle("-fx-background-color: black; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
					AnimationTimer myTimer = new MyTimer(map.get(index), 0.05);
					myTimer.start();
					try 
					{
						Thread.sleep(10);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				else if(cell.getStatus() == Constant.NULL)
				{
					int index = matrix.indexOf(cell);
					map.get(index).setStyle("-fx-background-color: white; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
				}
				else
				{
					int index = matrix.indexOf(cell);
					map.get(index).setStyle("-fx-background-color: yellow; -fx-border-width: 2; -fx-border-color: black; -fx-border-style: solid");
				}
				
			}
		}
	}
	*/
	
	private class MyTimer extends AnimationTimer
	{
		private StackPane stackPane;
		private double opacity = 0;
		private double rate = 0;
		
		
		private MyTimer(StackPane stackPane, double rateOfChange)
		{
			this.stackPane = stackPane;
			this.rate = rateOfChange;
		}
		
		
		public void handle(long now)
		{
			doHandle();
		}
		
		private void doHandle()
		{
			opacity += rate;
			stackPane.opacityProperty().set(opacity);
			if(opacity >= 1)
			{
				stop();
			}
			
			
		}
	}
	
	public StackPane getTileFromMap(Map<Integer, StackPane> map, Cell cell)
	{
		return map.get(cell.getRow() * Constant.COLUMN_COUNT + cell.getCol());
	}

}
