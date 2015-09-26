/*
 * Amogh Lale
 * Assignment 9
 * May 10,2015
 * 
 * */

import java.util.Scanner;

public class p09 {
	
	boolean verifyValSol = false;
	static int numVar, numclauses;
	static int[] truthTableRow;
	static int data[][];
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		p09 obj = new p09();
	
		//accept number of variables
		numVar=sc.nextInt();
		
		//accept number of clauses
		numclauses=sc.nextInt();
		
		if(numVar==0 || numclauses==0)
			System.exit(0);

		//Accept values of variables in the clauses in a 2D array 
		data = new int[numclauses][3];
		for(int i =0; i< numclauses;i++){
			
            // since 3CNF inner for loop will run thrice
			for(int j = 0; j<3;j++){
				data[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		truthTableRow = new int[numVar];
		obj.EvaluateResult(truthTableRow,0);
		if(!obj.verifyValSol){
			System.out.println("can’t satisfy the equation");
		}
	}
	
	//evaluate a generic solution
	public void EvaluateResult(int[]truthTableRow,int currentDepth)
	{
		if (currentDepth==numVar)
		{
			for(int i=0;i<numclauses;i++)
			{
				int verifyClause=0;
				for(int j=0;j<3;j++)
				{	
					int currentLiteral;
					currentLiteral = data[i][j];
					
					//if literal is negative
					if(currentLiteral<0)
					{	
						int k=(-1*(currentLiteral))-1;
						if(truthTableRow[k]==0){
							verifyClause=verifyClause+1;
							break;
						}
						else
							verifyClause=verifyClause+0;
					}
					//else if literal is not negative
					else{
						if(truthTableRow[currentLiteral-1] == 1){
							verifyClause=verifyClause+truthTableRow[currentLiteral-1];
							break;
						}else
							verifyClause=verifyClause+truthTableRow[currentLiteral-1];
					}
				}
				//if verifyclause ==0, current truth table row is not a solution
				if(verifyClause==0)
				{
					verifyValSol=false;
					break; 	// if we use return instead of break, time would be increased
					       	// I tried return for sat5.txt. It took 435 sec. But when I 
							//used break, overall time required was 425 second
				}
				else if (verifyClause>0)
					verifyValSol=true;
			}
			if(verifyValSol)
			{
				//print result
				for(int i=0;i<truthTableRow.length;i++)
				{
					System.out.println(truthTableRow[i]);
				}
				
				//exit after first satisfiable solution
				System.exit(0);			
			}
		    return;
		}//return when we reach the max depth of the tree
		
		    // I am starting truth table from all 0's just because 
			//we are concerned only with first solution which is 
			//closer to all 0's end of the truth table (as in case of sat5.txt) 
			truthTableRow[currentDepth]=0;
			EvaluateResult(truthTableRow,currentDepth+1);
			
			truthTableRow[currentDepth]=1;
			EvaluateResult(truthTableRow,currentDepth+1);
	}
}