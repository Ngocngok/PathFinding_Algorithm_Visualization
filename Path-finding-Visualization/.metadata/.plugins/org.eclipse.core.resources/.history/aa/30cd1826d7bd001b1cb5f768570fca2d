package back_end;

public class Cell 
{
	private int row;
	private int col;
	
	
	public int getRow() 
	{
		return row;
	}

	public int getCol() 
	{
		return col;
	}

	
	private int status;
	
	public Cell()
	{
		this.row = 0;
		this.col = 0;
		this.status = 0;
	}
	
	public Cell(Cell cell)
	{
		this.row = cell.row;
		this.col = cell.col;
		this.status = cell.status;
	}
	
	public Cell(int row, int col, int status)
	{
		this.row = row;
		this.col = col;
		this.status = status;
	}
	
	public boolean isChanged(Cell tmp)
	{
		return (this.row == tmp.row && this.col == tmp.col && this.status != tmp.status);
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}

}
