package back_end;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import utils.Constant;

public class SearchingAlgo 
{
	
	StepManager stepManager;
	Node[][] nodeGraph = new Node[Constant.ROW_COUNT][Constant.COLUMN_COUNT]; 
	Node startNode;
	Node endNode;
	
	public StepManager getStepManager()
	{
		return stepManager;
	}
	
	
	
	
	
	public void AStarAlgo(ArrayList<Cell> cellList)
	{
		
		stepManager = new StepManager(cellList);
		for(int i = 0; i < Constant.ROW_COUNT; i++)
		{
			for(int j = 0; j < Constant.COLUMN_COUNT; j++)
			{
				Node tmp = new Node();
				tmp.setI(i);
				tmp.setJ(j);
				
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.STARTING_POINT)
				{
					//?
					this.startNode = tmp;
					this.startNode.setG(0);
					this.startNode.setF(0);
					
				}
				else if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.END_POINT)
				{
					this.endNode = tmp;
				}
				
				else if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.BLOCKED)
				{
					tmp.isBlocked = true;
				}
				
				
				
				else
				{
					//for blocked and so on..
				}
				
				nodeGraph[i][j] = tmp;
			}
		}
		
		for(int x = 0; x < Constant.ROW_COUNT; x++)
		{
			for(int y = 0; y < Constant.COLUMN_COUNT; y++)
			{
				if(y>0) nodeGraph[x][y].addNeighbor(nodeGraph[x][y-1]);
				if(y<Constant.COLUMN_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x][y+1]);
				if(x>0) nodeGraph[x][y].addNeighbor(nodeGraph[x-1][y]);
				if(x<Constant.ROW_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x+1][y]);
			}
		}
		
		
		
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closedList = new ArrayList<Node>();
		openList.add(startNode);
		
		
		
		Node currentNode;
		
		
		while(!openList.isEmpty())
		{
			//get smallest F in open list
			currentNode = openList.get(0);
			for(Node node : openList)
			{
				if(node.getF() < currentNode.getF())
				{
					currentNode = node;
				}
			}
			
			//add steps
			ArrayList<Cell> tmpList = new ArrayList<Cell>();
			tmpList.add(new Cell(currentNode.getI(), currentNode.getJ(), Constant.EVALUATING));
			stepManager.addStep(tmpList);
			
			
			
			
			openList.remove(currentNode);
			closedList.add(currentNode);
			
			if(currentNode == endNode)
			{
				Node tmp = endNode;
				ArrayList<Cell> path = new ArrayList<Cell>();
				
				
				while(tmp.getParent() != null)
				{
					path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
					tmp = tmp.getParent();
				}
				path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
				
				stepManager.addStep(path);
				
				return;
			}
			
			for(Node neighbor : currentNode.getNeighbor())
			{
				
				if(neighbor.isBlocked || closedList.contains(neighbor)) continue;
				
				
				if(!openList.contains(neighbor))
				{
					openList.add(0, neighbor);
					neighbor.setParent(currentNode);
					neighbor.setG(currentNode.getG() + 1);
					//neighbor.setH((int)Math.pow(neighbor.getJ() - endNode.getJ(), 2) + (int)Math.pow(neighbor.getG() - endNode.getG(), 2) );
					neighbor.setH(Math.abs(neighbor.getJ() - endNode.getJ()) + Math.abs(neighbor.getI() - endNode.getI()) );
					neighbor.setF(neighbor.getG() + neighbor.getH());
					
				}
				
				else
				{
					if(neighbor.getG() > currentNode.getG() + 1)
					{
						neighbor.setParent(currentNode);
						neighbor.setG(currentNode.getG() + 1);
						neighbor.setF(neighbor.getG() + neighbor.getH());
					}
				}
				
			}
			
			

		}
	}
	
	
	
	public void DijkstraAlgo(ArrayList<Cell> cellList)
	{
		//F for cost from start point.
		//G for cost to travel across this point.
		
		stepManager = new StepManager(cellList);
		
		ArrayList<Node> openList = new ArrayList<Node>();
		
		for(int i = 0; i < Constant.ROW_COUNT; i++)
		{
			for(int j = 0; j < Constant.COLUMN_COUNT; j++)
			{
				Node tmp = new Node();
				tmp.setI(i);
				tmp.setJ(j);
				
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.STARTING_POINT)
				{
					//?
					this.startNode = tmp;
					this.startNode.setG(0);
					this.startNode.setF(0);
					
				}
				else if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.END_POINT)
				{
					this.endNode = tmp;
					this.endNode.setG(1);
					this.endNode.setF(Constant.INFINITY);
				}
				
				else if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.BLOCKED)
				{
					tmp.isBlocked = true;
					tmp.setG(1);
					tmp.setF(Constant.INFINITY);
				}
				
				/*
				else if(false)
				{
					for blocked and so on..
				}
				*/
				
				else
				{
					tmp.setF(Constant.INFINITY);
					tmp.setG(1);
				}
				
				nodeGraph[i][j] = tmp;
				if(!tmp.isBlocked)
				{
					openList.add(tmp);
				}
				
			}
		}
		
		for(int x = 0; x < Constant.ROW_COUNT; x++)
		{
			for(int y = 0; y < Constant.COLUMN_COUNT; y++)
			{
				if(y>0) nodeGraph[x][y].addNeighbor(nodeGraph[x][y-1]);
				if(y<Constant.COLUMN_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x][y+1]);
				if(x>0) nodeGraph[x][y].addNeighbor(nodeGraph[x-1][y]);
				if(x<Constant.ROW_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x+1][y]);
			}
		}
		
		Node currentNode;
		
		while(!openList.isEmpty())
		{
			//get node with smallest dist
			currentNode = openList.get(0);
			for(Node node : openList)
			{
				if(node.getF() < currentNode.getF())
				{
					currentNode = node;
				}
			}
			//add steps
			ArrayList<Cell> tmpList = new ArrayList<Cell>();
			tmpList.add(new Cell(currentNode.getI(), currentNode.getJ(), Constant.EVALUATING));
			stepManager.addStep(tmpList);
			
			openList.remove(currentNode);
			//trace path
			if(currentNode == endNode)
			{
				Node tmp = endNode;
				ArrayList<Cell> path = new ArrayList<Cell>();
				
				
				while(tmp.getParent() != null)
				{
					path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
					tmp = tmp.getParent();
				}
				path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
				
				stepManager.addStep(path);
				
				return;
			}
			
			for(Node neighbor : currentNode.getNeighbor())
			{
				if(neighbor.isBlocked)
				{
					continue;
				}
				
				int alt = currentNode.getF() + neighbor.getG();
				if(alt < neighbor.getF())
				{
					neighbor.setF(alt);
					neighbor.setParent(currentNode);
				}
			}
			
			
		}
		
		
	}
	
	public void BreadthFirst(ArrayList<Cell> cellList)
	{
		//F for checking visited node : 0-unvisited, 1-visited
		
		stepManager = new StepManager(cellList);
		
		Queue<Node> closedList = new LinkedList<Node>();
		
		for(int i = 0; i < Constant.ROW_COUNT; i++)
		{
			for(int j = 0; j < Constant.COLUMN_COUNT; j++)
			{
				Node tmp = new Node();
				tmp.setI(i);
				tmp.setJ(j);
				tmp.setF(0);
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.STARTING_POINT)
				{
					this.startNode = tmp;
					
				}
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.END_POINT)
				{
					this.endNode = tmp;
				}
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.BLOCKED)
				{
					tmp.isBlocked = true;
				}
				
				
				nodeGraph[i][j] = tmp;
				
			}
		}
		
		for(int x = 0; x < Constant.ROW_COUNT; x++)
		{
			for(int y = 0; y < Constant.COLUMN_COUNT; y++)
			{
				if(y>0) nodeGraph[x][y].addNeighbor(nodeGraph[x][y-1]);
				if(y<Constant.COLUMN_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x][y+1]);
				if(x>0) nodeGraph[x][y].addNeighbor(nodeGraph[x-1][y]);
				if(x<Constant.ROW_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x+1][y]);
			}
		}
		
		Node currentNode = startNode;
		currentNode.setF(1);
		
		closedList.offer(currentNode);
		
		while(!closedList.isEmpty())
		{
			currentNode = closedList.poll();
			//add steps
			ArrayList<Cell> tmpList = new ArrayList<Cell>();
			tmpList.add(new Cell(currentNode.getI(), currentNode.getJ(), Constant.EVALUATING));
			stepManager.addStep(tmpList);
			
			if(currentNode == endNode)
			{
				//trace path
				Node tmp = endNode;
				ArrayList<Cell> path = new ArrayList<Cell>();
				
				
				while(tmp.getParent() != null)
				{
					path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
					tmp = tmp.getParent();
				}
				path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
				
				stepManager.addStep(path);
				
				return;
			}
			for(Node neighbor : currentNode.getNeighbor())
			{
				if(neighbor.isBlocked)
				{
					continue;
				}
				
				if(neighbor.getF() == 0)
				{
					neighbor.setF(1);
					neighbor.setParent(currentNode);
					closedList.offer(neighbor);
				}
				
			}
		}
		
	}
	
	
	public void DepthFirst(ArrayList<Cell> cellList)
	{
		//F for checking visited node : 0-unvisited, 1-visited
		
		stepManager = new StepManager(cellList);
		
		Stack<Node> closedList = new Stack<Node>();
		
		for(int i = 0; i < Constant.ROW_COUNT; i++)
		{
			for(int j = 0; j < Constant.COLUMN_COUNT; j++)
			{
				Node tmp = new Node();
				tmp.setI(i);
				tmp.setJ(j);
				tmp.setF(0);
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.STARTING_POINT)
				{
					this.startNode = tmp;
					
				}
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.END_POINT)
				{
					this.endNode = tmp;
				}
				
				if(cellList.get(i*Constant.COLUMN_COUNT + j).getStatus() == Constant.BLOCKED)
				{
					tmp.isBlocked = true;
					
				}
				
				
				nodeGraph[i][j] = tmp;
				
			}
		}
		
		for(int x = 0; x < Constant.ROW_COUNT; x++)
		{
			for(int y = 0; y < Constant.COLUMN_COUNT; y++)
			{
				if(y>0) nodeGraph[x][y].addNeighbor(nodeGraph[x][y-1]);
				if(y<Constant.COLUMN_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x][y+1]);
				if(x>0) nodeGraph[x][y].addNeighbor(nodeGraph[x-1][y]);
				if(x<Constant.ROW_COUNT-1) nodeGraph[x][y].addNeighbor(nodeGraph[x+1][y]);
			}
		}
		
		Node currentNode = startNode;
		
		closedList.push(currentNode);
		
		while(!closedList.isEmpty())
		{
			//
			currentNode = closedList.pop();
			
			
			if(currentNode == endNode)
			{
				//trace path
				Node tmp = endNode;
				ArrayList<Cell> path = new ArrayList<Cell>();
				
				
				while(tmp.getParent() != null)
				{
					path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
					tmp = tmp.getParent();
					System.out.println(tmp.getI() + " " + tmp.getJ());
				}
				path.add(new Cell(tmp.getI(), tmp.getJ(), Constant.PATH));
				
				stepManager.addStep(path);
				
				return;
			}
			
			
			if(currentNode.getF() == 0)
			{
				//add steps
				ArrayList<Cell> tmpList = new ArrayList<Cell>();
				tmpList.add(new Cell(currentNode.getI(), currentNode.getJ(), Constant.EVALUATING));
				stepManager.addStep(tmpList);
				
				
				currentNode.setF(1);
				for(Node neighbor : currentNode.getNeighbor())
				{
					if(neighbor.isBlocked)
					{
						continue;
					}
					if(neighbor.getF() == 0)
					{
						neighbor.setParent(currentNode);
					}
					closedList.push(neighbor);
					
					
				}
			}
		}
		
	}

}
