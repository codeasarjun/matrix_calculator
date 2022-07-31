import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class echelon {

    public static void calculateEch( int [][] mat,int row,int col,mainController obj)
    {
       
        int i,j,k,tem,r=row;

        	
	for(k=0;k<row;k++)
	{
		
		if( (mat[k][k]) != 1)
		{
			int temp = mat[k][k];
			if(temp == 0)
				continue; 
			for(j=0;j<col;j++)
			{
				mat[k][j] = ( (mat[k][j]) / temp );
			}
		}
		
		for(i=k+1;i<row;i++)
		{
			tem = mat[i][k];
			for(j=k;j<col;j++)
				{
					
					mat[i][j] = mat[i][j] - ( mat[k][j] * tem );
				}
		
		}


    }
    int rank=r;
    for(int a=0;a<row;a++)
    {
        int zeroInrows=0;
        for(int b=0;b<col;b++)
        {
            if(mat[a][b]==0)
            {
                zeroInrows++;
            }

        }
        if(zeroInrows==col)
        {
            rank=rank-1;
        }
        
    }
   // System.out.println(r);
    //System.out.println(rank);
    obj.lb_rank_of_matrix.setText("Rank is "+rank);
        printGrid(mat,row,col,obj);
    }
    public static void printGrid( int[][] mat,int row,int col,mainController obj)

    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)

            {
                String convertToString;
                convertToString=String.valueOf(mat[i][j]);
                TextField tf=new TextField();
                tf.setPrefWidth(50);
                tf.setPrefHeight(50);
                tf.setAlignment(Pos.CENTER);
                tf.setText(convertToString);

                tf.setDisable(true);
                
               
                GridPane.setRowIndex(tf, i);
            GridPane.setColumnIndex(tf,j);
           obj.resultGrid.getChildren().add(tf);
            }
            System.out.println();
        }
    }


}
