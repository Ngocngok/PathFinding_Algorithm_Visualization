package back_end;

import java.util.ArrayList;

public class Node 
{
	private int f, g, h;
	
	private int i, j;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	private ArrayList<Node> neighbor = new ArrayList<Node>();
	
	boolean isBlocked = false;
	
	private Node parent;
	
	public Node()
	{
		this.f = 0;
		this.g = 0;
		this.h = 0;
	}
	
	public void setBlocked()
	{
		this.isBlocked = true;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getNeighbor() {
		return neighbor;
	}
	
	public void addNeighbor(Node neighbor)
	{
		this.neighbor.add(neighbor);
	}
	
	
	

}
