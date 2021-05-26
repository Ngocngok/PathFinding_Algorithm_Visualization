package back_end;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import utils.Constant;

public class MazeGenerator 
{
	
	
	
	private ArrayList<Cell> maze = new ArrayList<Cell>();
	
	//stack for backtracking
	private Stack<Integer> mazeStack = new Stack<Integer>();
	
	private Cell intToCell(int index)
	{
		return this.maze.get(index);
	}
	
	private void addToStack(Cell cell)
	{
		mazeStack.push(cell.getRow()*Constant.COLUMN_COUNT + cell.getCol());
	}
	
	private Cell explore(Cell cell, ArrayList<Cell> maze)
	{
		//neighbor list
		ArrayList<Cell> tmp = new ArrayList<Cell>();
		
		//add neighbor
		if(cell.getRow() + 2 <= Constant.ROW_COUNT - 1)
		{
			if(maze.get((cell.getRow()+ 2)*Constant.COLUMN_COUNT + cell.getCol()).getStatus() != Constant.NULL)
			{
				tmp.add(maze.get((cell.getRow()+ 2)*Constant.COLUMN_COUNT + cell.getCol()));
			}
		}
		
		if(cell.getRow() - 2 >= 0)
		{
			if(maze.get((cell.getRow()- 2)*Constant.COLUMN_COUNT + cell.getCol()).getStatus() != Constant.NULL)
			{
				tmp.add(maze.get((cell.getRow()- 2)*Constant.COLUMN_COUNT + cell.getCol()));
			}
		}
		
		if(cell.getCol() + 2 <= Constant.COLUMN_COUNT - 1)
		{
			if(maze.get(cell.getRow()*Constant.COLUMN_COUNT + cell.getCol() + 2).getStatus() != Constant.NULL)
			{
				tmp.add(maze.get(cell.getRow()*Constant.COLUMN_COUNT + cell.getCol() + 2));
			}
		}
		
		if(cell.getCol() - 2 >= 0)
		{
			if(maze.get(cell.getRow()*Constant.COLUMN_COUNT + cell.getCol() - 2).getStatus() != Constant.NULL)
			{
				tmp.add(maze.get(cell.getRow()*Constant.COLUMN_COUNT + cell.getCol() - 2));
			}
		}
		
		
		if(tmp.size() == 0)
		{
			return null;
		}
		
		//random explore a neighbor
		
		Random rd = new Random();
		int index = rd.nextInt(tmp.size());
		
		//assign traversable tile
		maze.get(tmp.get(index).getRow()*Constant.COLUMN_COUNT + tmp.get(index).getCol()).setStatus(Constant.NULL);
		maze.get((tmp.get(index).getRow() - (tmp.get(index).getRow() - cell.getRow())/2)*Constant.COLUMN_COUNT + (tmp.get(index).getCol() - (tmp.get(index).getCol() - cell.getCol())/2)).setStatus(Constant.NULL);;
		
		
		return tmp.get(index);
		
	}
	private int startPoint;
	private int endPoint;
	
	public void backTrackMaze(int startPoint, int endPoint)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		//initialize all blocked tile maze
		for(int i = 0; i < Constant.ROW_COUNT; i++)
		{
			for(int j = 0; j < Constant.COLUMN_COUNT; j++)
			{
				maze.add(new Cell(i,j,Constant.BLOCKED));
			}
		}
		
		
		//procedure
		if(startPoint == -1)
		{
			Random rd = new Random();
			startPoint = rd.nextInt(Constant.ROW_COUNT*Constant.COLUMN_COUNT);
			this.startPoint = startPoint;
		}
		
		Cell currentCell = maze.get(startPoint);
		addToStack(currentCell);
		
		while(!mazeStack.isEmpty())
		{
			currentCell = explore(currentCell, maze);
			if(currentCell == null)
			{
				currentCell = intToCell(mazeStack.pop());
				continue;
			}
			
			
			addToStack(currentCell);
		}
		
		
		
		
		if(endPoint == -1)
		{
			Random rd = new Random();
			endPoint = rd.nextInt(Constant.ROW_COUNT*Constant.COLUMN_COUNT);
			this.endPoint = endPoint;
		}
		
		maze.get(startPoint).setStatus(Constant.STARTING_POINT);
		maze.get(endPoint).setStatus(Constant.END_POINT);
		
		
	
		
	}
	
	public int getStartPoint()
	{
		return this.startPoint;
	}
	
	public int getEndPoint()
	{
		return this.endPoint;
	}
	
	public ArrayList<Cell> getMaze()
	{
		return this.maze;
	}
	
	
	

}
