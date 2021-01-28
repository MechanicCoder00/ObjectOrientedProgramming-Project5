package project5;

class Disc
{
	private int discSize;

	public int getDiscSize()
	{
		return discSize;
	}

	public void setDiscSize(int discSize)
	{
		this.discSize = discSize;
	}
	
	public Disc(int i)
	{ 
		setDiscSize(i);
	}
	
	public int toArray()  
	{ 
		return(getDiscSize());
	}


	
}
	
