//****Project 5/Towers of Hanoi****
//
//Author: Scott Tabaka
//Instructor: Steve Riegerix
//Class: CMPSCI 2700(Fall 2018)
//Due Date: November 11, 2018

package project5;

import java.util.Stack;

public class TowerofHanoiPuzzle
{
	final static int numofDiscs = 7;
	private static int moveCount = 0;
	private static int topofTower = 0;
	private static int top1 = 0;
	private static int top2 = 0;
	private static int top3 = 0;
	
	static Stack<Object> pole1 = new Stack<Object>();
	static Stack<Object> pole2 = new Stack<Object>();
	static Stack<Object> pole3 = new Stack<Object>();
	
	public static int getTopofTower()
	{
		return topofTower;
	}

	public static void setTopofTower(int topofTower)
	{
		TowerofHanoiPuzzle.topofTower = topofTower;
	}
	
	public static void findTopofTower(int x)
	{
		setTopofTower(x);
	}
	
	public static int getTop(int i)
	{
		int temptop = 0;
		switch (i) 
	    { 
	        case 1: 
	        	temptop = top1;
	            break; 
	        case 2: 
	        	temptop = top2;
	            break; 
	        case 3: 
	        	temptop = top3;
	            break;
	    }
		return temptop;
	}

	public static void setTop1(int top1)
	{
		TowerofHanoiPuzzle.top1 = top1;
	}

	public static void setTop2(int top2)
	{
		TowerofHanoiPuzzle.top2 = top2;
	}

	public static void setTop3(int top3)
	{
		TowerofHanoiPuzzle.top3 = top3;
	}
	
	public static int getMoveCount()
	{
		return moveCount;
	}

	public static void increaseMoveCount()
	{
		moveCount++;
	}
	
	public static void identifyTops()
	{
		if(!pole1.empty())
		{
			int temp = ((Disc) pole1.peek()).getDiscSize();
			setTop1(temp);
			if(temp == 1)
			{
				setTopofTower(1);
			}
		}
		else
		{
			top1 = 55;
		}
		if(!pole2.empty())
		{
			int temp = ((Disc) pole2.peek()).getDiscSize();
			setTop2(temp);
			if(temp == 1)
			{
				setTopofTower(2);
			}
		}
		else
		{
			top2 = 55;
		}
		if(!pole3.empty())
		{
			int temp = ((Disc) pole3.peek()).getDiscSize();
			setTop3(temp);
			if(temp == 1)
			{
				setTopofTower(3);
			}
		}
		else
		{
			top3 = 55;
		}
//		System.out.println(getTop(1) + "	" + getTop(2) + "	" + getTop(3));
//		System.out.println("");
	}
	
	public static void puzzlelogic(int n)
	{
	    int i, x, a, b, c;
	    for (i = 0; i < (Math.pow(2,n)-1); i++)
	    {
	        x = getTopofTower();
	        if (i % 2 == 0)
	        {
	            if (x == 1)
	            {
	            	MoveDisc(Int_Stack(1),Int_Stack(3));
	            }
	            else if (x == 2)
	            {
	            	MoveDisc(Int_Stack(2),Int_Stack(1));
	            }
	            else if (x == 3)
	            {
	            	MoveDisc(Int_Stack(3),Int_Stack(2));
	            }
	        }
	        else
	        {
	            if (x == 1)
	            {
	            	b = getTop(2);
	                c = getTop(3);
	                
	                if (b < c && !pole3.empty())
	                {
	                	MoveDisc(Int_Stack(2),Int_Stack(3));
	                }
	                else if (b > c && !pole2.empty())
	                {
	                	MoveDisc(Int_Stack(3),Int_Stack(2));
	                }
	                else if (pole3.empty())
	                {
	                	MoveDisc(Int_Stack(2),Int_Stack(3));
	                }
	                else if (pole2.empty())
	                {
	                	MoveDisc(Int_Stack(3),Int_Stack(2));
	                }
	            }
	            else if (x == 2)
	            {
	            	a = getTop(1);
	                c = getTop(3);
	                
	                if (a < c && !pole3.empty())
	                {
	                	MoveDisc(Int_Stack(1),Int_Stack(3));
	                }
	                else if (a > c && !pole1.empty())
	                {
	                	MoveDisc(Int_Stack(3),Int_Stack(1));
	                }
	                else if (pole3.empty())
	                {
	                	MoveDisc(Int_Stack(1),Int_Stack(3));
	                }
	                else if (pole1.empty())
	                {
	                	MoveDisc(Int_Stack(3),Int_Stack(1));
	                }
	            }
	            else if (x == 3)
	            {
	            	a = getTop(1);
	            	b = getTop(2);
	            	
	            	if (a < b && !pole2.empty())
	            	{
	            		MoveDisc(Int_Stack(1),Int_Stack(2));
	            	}
	            	else if (a > b && !pole1.empty())
	                {
	            		MoveDisc(Int_Stack(2),Int_Stack(1));
	                }
	                else if (pole2.empty())
	                {
	                	MoveDisc(Int_Stack(1),Int_Stack(2));
	                }
	                else if (pole1.empty())
	                {
	                	MoveDisc(Int_Stack(2),Int_Stack(1));
	                }
	            }
	        }
	    }
	}

	public static Stack<Object> Int_Stack(int i)
	{
		Stack<Object> tempPole=null;
		switch (i) 
	    { 
	        case 1: 
	        	tempPole = pole1;
	            break; 
	        case 2: 
	        	tempPole = pole2;
	            break; 
	        case 3: 
	        	tempPole = pole3;
	            break;
	    }
		return tempPole;
	}
	
	public static int Stack_Int(Stack<Object> stackObject)
	{
		int tempInt=0;
		
		if(stackObject == pole1)
		{
			tempInt = 1;
		}
		else if(stackObject == pole2)
		{
			tempInt = 2;
		}
		else
		{
			tempInt = 3;
		}
		return tempInt;
	}
	
	public static void MoveDisc(Stack<Object> fromPole,Stack<Object> toPole)
	{
		
		int tempsize = ((Disc) fromPole.peek()).getDiscSize();
		Disc tempDisc = new Disc(tempsize);	
		toPole.push(tempDisc);
		fromPole.pop();
		DisplayMove(Stack_Int(fromPole),Stack_Int(toPole));
	}
	
	public static void DisplayMove(int fromPole,int toPole)
	{
		increaseMoveCount();
		System.out.print("Disc " + getTop(fromPole) + " moved from pole " + fromPole + " to " + toPole);
		System.out.println(" :: Move count: " + getMoveCount());
		displayPoles();
		identifyTops();
	}

	public static void displayPoles()
	{
		
		int[] temparray1;
		int[] temparray2;
		int[] temparray3;
    	temparray1 = new int[numofDiscs];
    	temparray2 = new int[numofDiscs];
    	temparray3 = new int[numofDiscs];
		
		if(!pole1.empty())
		{
			int i=0;
			
			Object[] array2 = pole1.toArray();
	        for (Object obj : array2)
	        { 	
	        	temparray1[i] = ((Disc) obj).getDiscSize();
	        	i++;
	        }  
		}
		
		if(!pole2.empty())
		{
			int i=0;
			
			Object[] array2 = pole2.toArray();
	        for (Object obj : array2)
	        { 	
	        	temparray2[i] = ((Disc) obj).getDiscSize();
	        	i++;
	        }
		}

		if(!pole3.empty())
		{
			int i=0;

			Object[] array2 = pole3.toArray();
	        for (Object obj : array2)
	        { 	
	        	temparray3[i] = ((Disc) obj).getDiscSize();
	        	i++;
	        }
		}
		
		System.out.println("Pole 1	Pole2	Pole3");
        for(int j=numofDiscs-1;j>=0;j--)
    	{
        		System.out.println(temparray1[j] + "	" + temparray2[j]+ "	" + temparray3[j]);
    	}
        System.out.println("");
	}
	
	public static void CreateDisks()
	{
		for(int i = numofDiscs;i>0;i--)
		{
			pole1.push(new Disc(i));
		}
		System.out.println("Starting Position");
	}
	

	public static void main(String[] args)
	{
		CreateDisks();
		displayPoles();
		identifyTops();
		puzzlelogic(numofDiscs);
	}
}
