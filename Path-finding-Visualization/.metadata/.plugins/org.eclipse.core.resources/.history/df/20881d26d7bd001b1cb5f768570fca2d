package back_end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StepManager 
{
	
	public StepManager(ArrayList<Cell> cellList)
	{
		this.currentStep = cellList;
	}
	
	
	LinkedList<Map<String, ArrayList<Cell>>> steps = new LinkedList<Map<String, ArrayList<Cell>>>();
	
	ArrayList<Cell> currentStep = new ArrayList<Cell>();
	public int currentIndex = 0;
	
	
	public void addStep(ArrayList<Cell> tmp)
	{
		ArrayList<Cell> tmpList = new ArrayList<Cell>();
		Map<String, ArrayList<Cell>> step = new HashMap<String, ArrayList<Cell>>();
		
		
		step.put("new", tmp);
		
		//System.out.println("NEW :");
		
		for(Cell newCell : tmp)
		{
			//System.out.print(newCell.getStatus() + " ");
			for(Cell oldCell : currentStep)
			{
				if(newCell.isChanged(oldCell))
				{
					//System.out.print("OLD : " + oldCell.getStatus());
					tmpList.add(new Cell(oldCell));
					int i = currentStep.indexOf(oldCell);
					currentStep.set(i, new Cell(newCell));
				}
			}
		}
		
		
		
		
		step.put("old", tmpList);
		steps.add(step);
		
		
		
	}
	
	public ArrayList<Cell> getNextStep()
	{
		if(currentIndex == steps.size())
		{
			System.out.println("Yes");
			return null;
		}
		
		currentIndex++;
		return steps.get(currentIndex-1).get("new");
		
	}
	
	public ArrayList<Cell> getPreviousStep()
	{
		currentIndex--;
		return steps.get(currentIndex).get("old");
	}
	
	
	

}
