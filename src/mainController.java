import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

public class mainController {

    @FXML
    private Button btn_create_matrix;

    @FXML
    private TextField tf_number0fcols;

    @FXML
    private TextField tf_numberofrows;
    @FXML
    private GridPane gridpane;
    @FXML
    public GridPane resultGrid;
    @FXML
    public Label lb_echlonform;

    @FXML
    public Label lb_rank_of_matrix; // will show rank of matirx 
    
    int row;
    int col;
    
    String mat[][]=new String [5][5];
    @FXML
    void clicked_createMatrix(ActionEvent event) {
        String r=tf_numberofrows.getText();
        String c=tf_number0fcols.getText();

         row=Integer.parseInt(r);
         col=Integer.parseInt(c);  
          resultGrid.setVisible(false);
          resultGrid.getChildren().clear();  // will clear reuslt grid 
        
        
        for(int i=0;i<row;i++)
        {
            final int a=i;
            for(int j=0;j<col;j++)
            {
               final int b=j;
              
                TextField tf=new TextField();
                tf.setPrefWidth(50);
            tf.setPrefHeight(50);
            tf.setAlignment(Pos.CENTER);
            
           
           tf.setOnKeyReleased(e->
           {
        String retrData=tf.getText();
        
               mat[a][b]=retrData;
               
           });
           
            GridPane.setRowIndex(tf, i);
            GridPane.setColumnIndex(tf,j);
            gridpane.getChildren().add(tf);
            }
        }
        
       
    }
    
    @FXML
    void btn_calculate_matrix(ActionEvent e)

    {
        resultGrid.setVisible(true);
        lb_echlonform.setVisible(true);
         lb_echlonform.setText("Echelon form of the matrix");
         lb_rank_of_matrix.setVisible(true);
        int matrixA[][]=new int[row][col];
        
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)

            {
                String s; // to hold the value from first matrix for conversion
                int a; // to hold the int value 
                s=mat[i][j];
                a=Integer.parseInt(s);
                matrixA[i][j]=a;
               // System.out.print(matrixA[i][j]+" ");
                
            }
           // System.out.println();
        }
        
        echelon.calculateEch(matrixA,row,col,this);

    }
   
    
    
}
