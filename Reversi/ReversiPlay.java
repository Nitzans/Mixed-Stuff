
public class ReversiPlay {
    /**
     * This class represents the creation, rulles, and different strategys of the game Reversi.
     * You should run ReversiGUI
     * @author Uri Berger and Nitzan Shpigel
     * @version 1/12/14
     */

    public static void printMatrix(int[] matrix) {//print a one dimensional array
        boolean notEmpty=(matrix!=null&&matrix.length>0);//verify that the given array has values
        if (notEmpty){
            for(int i=0; i<matrix.length;i=i+1){
                System.out.print(matrix[i]+" ");
            }
        }
    }

    public static void printMatrix(int[][] matrix) {//print a two dimensional array
        boolean notEmpty=(matrix!=null&&matrix.length>0);//verify that the given array has values
        if (notEmpty){
            for(int i=0; i<matrix.length;i=i+1){
                System.out.println();
                for(int j=0; j<matrix[i].length; j=j+1){
                    System.out.print(matrix[i][j]+" ");
                }
            }
        }
    }

    public static boolean isEqual(int[][] matrix1, int[][] matrix2) {//check if two given arrays are totally equal
        if (matrix1==null&&matrix2==null)//if both arrays are null, arrays are equal
            return true;

        else if (matrix1==null||matrix2==null||matrix1.length!=matrix2.length)//only one array is null,check if arrays size is the same
            return false;

        else{
            int p=0;
            boolean size=true;//arrays have the same length
            while(size&&p<matrix1.length){//check that each row in both arrays is the same length
                if (matrix1[p].length!=matrix2[p].length)
                    size=false;
                p=p+1;
            }
            boolean same=true;

            if (size==true)
                same=true;
            else 
                same=false;

            for(int i=0; i<matrix1.length&&same; i=i+1){//verify that the arrays have same values in same spots, if not return false
                for(int j=0; j<matrix1[i].length&&same; j=j+1){
                    if (matrix1[i][j]!=matrix2[i][j])
                        same=false;
                }
            }

            if (same){//arrays are the same
                return true;
            }
        }
        return false;//arrays are not the same
    }

    public static int[][] copyMatrix(int[][] matrix) {//return a new matrix with will be similar to the given matrix
        if (matrix!=null){//verify the given matrix is not null
            int[][]copy=new int[matrix.length][];
            int p=0;
            while(p<matrix.length){
                copy[p]=new int[matrix[p].length];//give the matrix copy the same row length as in the given matrix
                p=p+1;
            }

            for(int i=0; i<matrix.length; i=i+1){//give the matrix copy the same values as in the given matrix
                for(int j=0; j<matrix[i].length;j=j+1){
                    copy[i][j]=matrix[i][j];
                }
            }
            return copy;//return the copy matrix
        }

        return null;
    }

    public static int[][] createBoard(int size) {//create a new ReversiPlay board, min size 4*4, max size 40*40
        int [][] newBoard;
        if (size>=4 && size<=40 && size%2==0){
            newBoard = new int[size][size];

            //give the new play board the suitable values so it will be a legal ReversiPlay board
            newBoard[size/2-1][size/2-1]=2;
            newBoard[size/2-1][size/2]=1;
            newBoard[size/2][size/2-1]=1;
            newBoard[size/2][size/2]=2;

            return newBoard;    //return the created board
        }
        else 
            return null;//if the user give the board a size smaller than 4*4 or bigger than 40*40, than null will be returned
    }

    public static boolean isLegal(int[][] board, int player, int row, int column) {//check if a specific move[square] is legal
        boolean legal=false;
        if (board[row][column]==0){//verify that the given square is empty

            //check each one of the squares next to the given square to see if any of then is filled with the opponnent "soldiers"
            //if one of the squares is filled with the opponnent, we will check if afterwars(in the same direction) there is a  given player "soldier" 
            if (!legal&&column-1>=0&&board[row][column-1]!=player&&board[row][column-1]!=0){
                if (column-2>=0&&board[row][column-2]!=0){
                    if (board[row][column-2]==player)
                        legal=true;
                    else{

                        for(int j=column-3; j>=0&&board[row][j]!=0; j--)
                            if (board[row][j]==player){
                                legal=true;
                                column=-1;
                        }
                    }
                }
            }

            if (!legal&&column+1<board.length&&board[row][column+1]!=player&&board[row][column+1]!=0){
                if (column+2<board.length&&board[row][column+2]!=0){
                    if (board[row][column+2]==player)
                        legal=true;
                    else{

                        for(int j=column+3; j<board.length&&board[row][j]!=0; j++)
                            if (board[row][j]==player){
                                legal=true;
                                column=board.length;
                        }
                    }
                }
            }

            if (!legal&&row-1>=0&&column-1>=0&&board[row-1][column-1]!=player&&board[row-1][column-1]!=0){
                if (row-2>=0&&column-2>=0&&board[row-2][column-2]!=0){
                    if (board[row-2][column-2]==player)
                        legal=true;
                    else{

                        for(int i=row-3,j=column-3; j>=0&&i>=0&&board[i][j]!=0; j--,i--)
                            if (board[i][j]==player){
                                legal=true;
                                column=-1;
                        }
                    }
                }
            }

            if (!legal&&row-1>=0&&board[row-1][column]!=player&&board[row-1][column]!=0){
                if (row-2>=0&&board[row-2][column]!=0){
                    if (board[row-2][column]==player)
                        legal=true;
                    else{

                        for(int i=row-3; i>=0&&board[i][column]!=0; i--)
                            if (board[i][column]==player){
                                legal=true;
                                row=-1;
                        }
                    }
                }
            }

            if (!legal&&row-1>=0&&column+1<board.length&&board[row-1][column+1]!=player&&board[row-1][column+1]!=0){
                if (row-2>=0&&column+2<board.length&&board[row-2][column+2]!=0){
                    if (board[row-2][column+2]==player)
                        legal=true;
                    else{

                        for(int i=row-3,j=column+3; i>=0&&j<board.length&&board[i][j]!=0; i--,j++)
                            if (board[i][j]==player){
                                legal=true;
                                row=-1;
                        }
                    }
                }
            }

            if (!legal&&row+1<board.length&&column+1<board.length&&board[row+1][column+1]!=player&&board[row+1][column+1]!=0){
                if (row+2<board.length&&column+2<board.length&&board[row+2][column+2]!=0){
                    if (board[row+2][column+2]==player)
                        legal=true;
                    else{

                        for(int i=row+3,j=column+3; j<board.length&&i<board.length&&board[i][j]!=0; i++,j++)
                            if (board[i][j]==player){
                                legal=true;
                                column=board.length;
                        }
                    }
                }
            }

            if (!legal&&row+1<board.length&&board[row+1][column]!=player&&board[row+1][column]!=0){
                if (row+2<board.length&&board[row+2][column]!=0){
                    if (board[row+2][column]==player)
                        legal=true;
                    else{

                        for(int i=row+3; i<board.length&&board[i][column]!=0; i++)
                            if (board[i][column]==player){
                                legal=true;
                                row=board.length;
                        }
                    }
                }
            }

            if (!legal&&row+1<board.length&&column-1>=0&&board[row+1][column-1]!=player&&board[row+1][column-1]!=0){
                if (row+2<board.length&&column-2>=0&&board[row+2][column-2]!=0){
                    if (board[row+2][column-2]==player)
                        legal=true;
                    else{

                        for(int i=row+3,j=column-3; i<board.length&&j>=0&&board[i][j]!=0; i++,j--)
                            if (board[i][j]==player){
                                legal=true;
                                row=board.length;
                        }
                    }
                }
            }
        }

        if (legal==true)//the checked move is legal, return true 
            return legal;

        else
            return false;//the given move is not legal
    }

    public static int[][] play(int[][] board, int player, int row, int column) {//if the move is legal, chenge the board values 
        boolean check=isLegal(board, player,  row,  column);//verify that the move is legal 

        if (check){//move is legal 
            int i=-1;//will be used to check array index
            int j=-1;//same use as int i
            int replace=-1;//will sum the distance between the given move and the last index needed to be changed 

            //we will check every square next to the given move to make sure we won't miss a possible chenge to the board
            if (column+1<board.length&&board[row][column+1]!=player&&board[row][column+1]!=0){
                for(j=column+2; replace==-1&&j<board.length&&board[row][j]!=0; j++){
                    if (board[row][j]==player)
                        replace=j;
                }
                j--; //because at the end of the loop j's value is one above its appropiate value
                while(replace>-1&&column<=j){//if 'replace' has not chenged, no change is needed 
                    board[row][j]=player;
                    j--;
                }
                replace=-1;//return 'raplace' back to its original value before check another square
            }

            if (column-1>=0&&board[row][column-1]!=player&&board[row][column-1]!=0){
                for(j=column-2; replace==-1&&j>=0&&board[row][j]!=0; j--){
                    if (board[row][j]==player)
                        replace=j;

                }
                j++;//to return j to its appropiate value
                while(replace>-1&&column>=j){
                    board[row][j]=player;
                    j++;
                }
                replace=-1;
            }  

            if (row-1>=0&&column-1>=0&&board[row-1][column-1]!=player&&board[row-1][column-1]!=0){
                for(j=column-2,i=row-2;replace==-1&& j>=0&&i>=0&&board[i][j]!=0; j--,i--){
                    if (board[i][j]==player)
                        replace=j;
                }
                i++;
                j++;
                while(replace>-1&&column>=j&&row>=i){
                    board[i][j]=player;
                    j++;
                    i++;
                }
                replace=-1;
            }

            if (row-1>=0&&board[row-1][column]!=player&&board[row-1][column]!=0){
                for(i=row-2;replace==-1&&i>=0&&board[i][column]!=0; i--){
                    if (board[i][column]==player)
                        replace=i;

                }
                i++;
                while(replace>-1&&row>=i){
                    board[i][column]=player;
                    i++;
                }
                replace=-1;
            } 

            if (row-1>=0&&column+1<board.length&&board[row-1][column+1]!=player&&board[row-1][column+1]!=0){
                for( i=row-2,j=column+2;replace==-1&& i>=0&&j<board.length&&board[i][j]!=0; i--,j++){
                    if (board[i][j]==player)
                        replace=i;

                }
                i++;
                j--;
                while(replace>-1&&row>=i&&column<=j){
                    board[i][j]=player;
                    i++;
                    j--;
                }
                replace=-1;
            }

            if (row+1<board.length&&column+1<board.length&&board[row+1][column+1]!=player&&board[row+1][column+1]!=0){
                for( i=row+2,j=column+2; replace==-1&&i<board.length&&j<board.length&&board[i][j]!=0; i++,j++){
                    if (board[i][j]==player)
                        replace=i;

                }
                i--;
                j--;
                while(replace>-1&&row<=i&&column<=j){
                    board[i][j]=player;
                    i--;
                    j--;
                }
                replace=-1;
            }

            if (row+1<board.length&&board[row+1][column]!=player&&board[row+1][column]!=0){
                for( i=row+2; replace==-1&&i<board.length&&board[i][column]!=0; i++){
                    if (board[i][column]==player)
                        replace=i;

                }
                i--;
                while(replace>-1&&row<=i){
                    board[i][column]=player;
                    i--; 
                }
                replace=-1;
            }

            if (row+1<board.length&&column-1>=0&&board[row+1][column-1]!=player&&board[row+1][column-1]!=0){
                for( i=row+2,j=column-2;replace==-1&& i<board.length&&j>=0&&board[i][j]!=0; i++,j--){
                    if (board[i][j]==player)
                        replace=i;

                }
                i--;
                j++;
                while(replace>-1&&row<=i&&column>=j){
                    board[i][j]=player;
                    i--;
                    j++;
                }
                replace=-1;
            }

            return board;//return the new board with the new values
        }
        else if (board!=null)//board isn't null but the move isn't legal. the same board will be returned
            return board;

        else//board is null
            return null;
    }

    public static int benefit(int[][] board, int player, int row, int column) {//if move is legal, this function will calculate how many changes it cause to the board
        int benefit=0;
        int player1=0;
        int player2=0;
        int currentPlayer1=0;//will be used to count the number of '1' in the board after the move
        int currentPlayer2=0;//same as 'currentPlayer1', but for player2
        int [][]play=new int[board.length][board.length];
        boolean check=isLegal(board, player,  row,  column);//check if the move is legal or not
        if (check){//move is legal
            //check how much '1' and '2' are in the board before the move
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    if (board[i][j]==1)
                        player1++;
                    else if (board[i][j]==2)
                        player2++;
                }
            }

            //copy the array board to another board called 'play'
            for(int i=0;i<board.length; i++){
                for(int j=0;j<board.length;j++){
                    play[i][j]=board[i][j];
                }
            }

            play=play(play,player, row,  column);//make the given move to the board 'play'

            for(int i=0; i<board.length; i++){//count how many '1' and '2' are in the board after the move
                for(int j=0; j<board.length; j++){
                    if (play[i][j]==1)
                        currentPlayer1++;
                    else if (play[i][j]==2)
                        currentPlayer2++;
                }
            }

            if (currentPlayer2>player2){
                if (player==2)
                    benefit=currentPlayer2-player2-1;//the difference before the move and after the move is the benefit
            }

            else if (currentPlayer1>player1){
                if (player==1)
                    benefit=currentPlayer1-player1-1;
            }           
        }

        if (benefit>0)//means that the move is legal so the minimum benefit is 1 
            return benefit;

        else//move isn't legal-there is no benefit from ilegal move. -1 will be returned        
            return -1;
    }

    public static int[][] possibleMoves(int[][] board, int player) {//check if the given player has possible moves and return their indexes in a two dimensional array
        if (board!=null){//if board is null, we can't check possible moves
            int possibleMoves=0;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    boolean check=isLegal(board,player,i,j);
                    if (check) //move is legal
                        possibleMoves++;//we have one(or one more) possible move
                }
            }

            int [][] playerMoves=new int[possibleMoves][2];//creating a new two dimensional array that will have the indexes of the possible moves
            int n=0;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    boolean check=isLegal(board,player,i,j);
                    while (check){//move is legal
                        playerMoves[n][0]=i;//the index of i is the possible row in the board
                        playerMoves[n][1]=j;//the index of j is the possible column in the board
                        check=false;
                        n++;
                    }
                }
            }

            return playerMoves;/*return the created two dimensional array.
            if there are no possible moves, the first dimension length in the array will be 0, while its second will be 2*/
        }

        return null;//if the given board is null
    }

    public static boolean hasMoves(int[][] board, int player) {//check if a given player has possible moves
        boolean hasMoves=false;
        if (board!=null){
            int possibleMoves=0;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length&&!hasMoves; j++){
                    hasMoves=isLegal(board,player,i,j);//check every index if is legal or not
                    if (hasMoves)//player has moves
                        return hasMoves;
                }
            }
        }
        return false;//player has no moves
    }

    public static int findTheWinner(int[][] board) {/*check who is the current winner of the game(more '1' in the board means player1 is the winner.
        if opposite player2 is the cuurent winner. if the number of '1' and '2' is equal, the function will return 0 */
        if (board!=null){//verify that the given board isn't null
            int counterPlayer1=0;
            int counterPlayer2=0;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    if (board[i][j]==1)
                        counterPlayer1++;
                    else if (board[i][j]==2)
                        counterPlayer2++;
                }
            }
            if (counterPlayer1>counterPlayer2)
                return 1;//there are more '1' in the boardm return 1
            else if (counterPlayer2>counterPlayer1)
                return 2;//there are more '2' in the board

            else return 0;    //the number of '1' and '2' in the board is equal
        }    

        return -1;//the given board is null
    }

    public static boolean gameOver(int[][] board) {/*check if the game is over or not. If both players has no moves, or if the board is full
        or if it filled only with '2' or '1',game is over and return true, otherwise, game is still on and return false.*/
        int counterPlayer1=0;
        int counterPlayer2=0;
        boolean fullBoard=true;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if (board[i][j]==1)
                    counterPlayer1++;
                else if (board[i][j]==2)
                    counterPlayer2++;

                if (board[i][j]==0)
                    fullBoard=false;
            } 
        }

        boolean hasMoves1=hasMoves(board,1);
        boolean hasMoves2=hasMoves(board,2);
        boolean onePlayer=false;//will used to check if the board is filled with only one of the players "soldiers"

        if ((counterPlayer1!=counterPlayer2&&counterPlayer2==0)||(counterPlayer2!=counterPlayer1&&counterPlayer1==0))
            onePlayer=true;//the board has only '2' or only '1' in its index

        if((!hasMoves1&&!hasMoves2)||fullBoard||onePlayer)
            return true;//one of the above conditions is occur, game is over. 

        else
            return false;//game isn't over
    }

    //check if a given player has moves and if so returns a one dimensional array that will be filled  with one of the player's options randomally.
    public static int[] randomPlayer(int[][] board, int player) {
        int [] random=new int[2];

        if (board!=null){//verify that the given board isn't null
            int [][] possibleMoves=possibleMoves(board,player);//creating a two dimensional array filed with all of the player's legal moves
            double num=(int)(Math.random()*possibleMoves.length);//num is given a random value from 0 to possibleMoves.length
            for(int i=0; i<possibleMoves.length; i++){
                if (num==i){//num is equal to the index i,fill array 'random' with the i option in poosibleMoves array. 
                    random[0]=possibleMoves[i][0];
                    random[1]=possibleMoves[i][1];
                }
            }
            if (hasMoves(board,player))//check if player has moves. if so, return array 'random'
                return random;
        }

        return null;//board is null or the player has no possible moves
    }

    /*function check if a given player has possible moves and if so returns a one dimensional array filled with the the row and column that will have the highest benefit.
    If there is more than one legal move to have the highest benefit, the function will return randomally one of this oprtions.*/
    public static int[] greedyPlayer(int[][] board, int player) {
        int[][]possibleMoves=possibleMoves(board,player);//creating a two dimensional array filed with all of the player's legal moves

        boolean check=hasMoves(board,player);//check if the given player has possible moves
        if (check){//player has moves
            int counter=0;   
            int moveBenefit=-1;
            int maxBenefit=1;

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    moveBenefit=benefit(board,player,i,j);//check the benefit of every legal move

                    if (moveBenefit>maxBenefit)//maxBenefit's value will contain the highest benefit value at the end of the loop.
                        maxBenefit=moveBenefit;
                }
            }

            //count how mand best moves(all moves that have same highest benefit for the player) a player has.
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    moveBenefit=benefit(board,player,i,j);

                    if (moveBenefit==maxBenefit)
                        counter++;    
                }
            }

            //creating a new two dimensional array that will have the indexes of all possible moves that have the (same)highest benefit for the player.
            int [][]greedyPlayer=new int[counter][2];
            for(int m=0,i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    moveBenefit=benefit(board, player,i,j);

                    if (moveBenefit==maxBenefit){//a move is legal and have the highest benefit for the player.
                        greedyPlayer[m][0]=i;
                        greedyPlayer[m][1]=j;
                        m++;
                    }
                }
            }

            double num=(int)(Math.random()*greedyPlayer.length);//num is given a random value from 0 to greedyPlayer.length.
            int[]greedyRand=new int[2];//this new one dimensional array will have one of the best greedy options, if player has moves.

            for(int i=0; i<greedyPlayer.length; i++){
                if (num==i){
                    greedyRand[0]=greedyPlayer[i][0];
                    greedyRand[1]=greedyPlayer[i][1];   
                }
            }

            return greedyRand;  
        }

        return null;//player has no moves of the board is null
    }

    /*The function will return a one dimensional array with best defensive move for a given player.
    The best defensive move is represented as the best differnce between a player's legal move and a greedy action from the another player. 
    If there is more than one defensive option, the function will return one of these options randomally. */
    public static int[] defensivePlayer(int[][] board, int player) {

        if (board!=null){
            int benefit=0;//represent the benefit for a legal player's move
            int benefit2=0;//repersent the benefit for a greedy opponents move
            int [][]play=new int[board.length][board.length];
            int [] defensive=new int[2];
            int p=-50;
            int w=-50;
            int counter=0;

            if (hasMoves(board,player)){//the given player has possible moves
                //copy the board content to another two dimensional array.    
                for(int i=0;i<board.length; i++){
                    for(int j=0;j<board.length;j++){
                        play[i][j]=board[i][j];
                    }
                } 
                boolean check=false;

                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board.length; j++){
                        if (check){//the move was legal,restore the original values of 'play'
                            for(int k=0;k<board.length; k++){
                                for(int m=0;m<board.length;m++){
                                    play[k][m]=board[k][m];
                                }
                            }   
                        }
                        check=isLegal(play,player,i,j);
                        if (check){//a move is legal

                            benefit=benefit(board,player,i,j);  
                            play=play(play,player,i,j);//change the board with this given move.
                            int []greedyEnnemy=new int[2];

                            if (player==1){
                                benefit2=0;
                                if (hasMoves(play,2)){//if the given player is player1, check if player2 has possible moves.
                                    greedyEnnemy=greedyPlayer(play,2);

                                    benefit2=benefit(play,2,greedyEnnemy[0],greedyEnnemy[1]);

                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }
                            else{
                                benefit2=0;
                                greedyEnnemy=greedyPlayer(play,1);
                                if (hasMoves(play,1)){//if the given player is player2, check if player1 has possible moves.
                                    benefit2=benefit(play,1,greedyEnnemy[0],greedyEnnemy[1]);
                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }

                            p=benefit-benefit2;//reflects the benefit from the defensive move
                            if (p>=w)//'w' will have eventually the highest benefit for a defensive style player's move.
                                w=p;

                        }
                    }
                }

                //same loop as above, but now count how many ideal defensive moves the player have.
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board.length; j++){
                        if (check){
                            for(int k=0;k<board.length; k++){
                                for(int m=0;m<board.length;m++){
                                    play[k][m]=board[k][m];
                                }
                            }   
                        }
                        check=isLegal(play,player,i,j);

                        if (check){
                            benefit=benefit(board,player,i,j);   
                            play=play(play,player,i,j);
                            int []greedyEnnemy=new int[2];

                            if (player==1){
                                benefit2=0;
                                if (hasMoves(play,2)){
                                    greedyEnnemy=greedyPlayer(play,2);
                                    benefit2=benefit(play,2,greedyEnnemy[0],greedyEnnemy[1]);
                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }

                            else{
                                benefit2=0;
                                greedyEnnemy=greedyPlayer(play,1);
                                if (hasMoves(play,1)){
                                    benefit2=benefit(play,1,greedyEnnemy[0],greedyEnnemy[1]);
                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }
                            p=benefit-benefit2;

                            if (p==w)
                                counter++;

                        }
                    }
                }

                int d=0;
                int moveBenefit=-1;
                int [][]defensiveMoves=new int[counter][2];//this two dimensional array will have the indexes of all possible moves that will have the same highest benefit.

                //same loop again, but now we know how much best defensive moves we have, so it will let us fill defensiveMoves array with these moves.
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board.length; j++){
                        if (check){
                            for(int k=0;k<board.length; k++){
                                for(int m=0;m<board.length;m++){
                                    play[k][m]=board[k][m];
                                }
                            }   
                        }
                        check=isLegal(play,player,i,j);

                        if (check){
                            benefit=benefit(board,player,i,j);       
                            play=play(play,player,i,j);
                            int []greedyEnnemy=new int[2];

                            if (player==1){
                                benefit2=0;

                                greedyEnnemy=greedyPlayer(play,2);
                                if (hasMoves(play,2)){
                                    benefit2=benefit(play,2,greedyEnnemy[0],greedyEnnemy[1]);
                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }

                            else{
                                benefit2=0;
                                greedyEnnemy=greedyPlayer(play,1);
                                if (hasMoves(play,1)){
                                    benefit2=benefit(play,1,greedyEnnemy[0],greedyEnnemy[1]);
                                    if (benefit2==-1)
                                        benefit2=0;
                                }
                            }
                            p=benefit-benefit2;

                            if (p==w){//fill up the array with the best defensvie move. If there is more than 1 best defensive move, that array will fiiled with it as well.
                                defensiveMoves[d][0]=i;
                                defensiveMoves[d][1]=j;
                                d++;
                            }     
                        }
                    }
                }

                double num=(int)(Math.random()*defensiveMoves.length);//num will have a value between 0 and defensivemoves.length

                for(int i=0; i<defensiveMoves.length; i++){
                    if (num==i){//num is equal to i, fill the one dimensional array with this random best defensive move.
                        defensive[0]=defensiveMoves[i][0];
                        defensive[1]=defensiveMoves[i][1];   
                    }
                }
                return defensive;//return the array
            }

        }    

        return null;//the given board is null of the given player has no possible moves
    }

    /*If a given player has possible moves,The function will return a one dimensional array as follows: if one of the corners is an available move for a given player,
     *one of this index will be returned rendolmally. Else, the function will return randomally the move which is the most close to the center of the board. 
     */
    public static int[] byLocationPlayer(int[][] board, int player) {
        if (hasMoves(board,player)&&board!=null){//verify that the the player has possible moves and that the given board isn't null
            //check if one fo the corners is a possible move
            boolean corners=isLegal(board,player,0,0)||isLegal(board,player,0,board[0].length-1)||isLegal(board,player,board.length-1,0)||isLegal(board,player,board.length-1,board.length-1);
            if (corners){
                int possibleCorners=0;
                boolean check=isLegal(board,player,0,0);
                if (check) 
                    possibleCorners++;

                check=isLegal(board,player,0,board[0].length-1);
                if (check) 
                    possibleCorners++;

                check=isLegal(board,player,board.length-1,0);
                if (check) 
                    possibleCorners++;

                check=isLegal(board,player,board.length-1,board.length-1);
                if (check) 
                    possibleCorners++;

                int [][] allCorners=new int[possibleCorners][2];//two dimensional array with all possible corners move
                int m=0;
                if (possibleCorners>0){//at least one of the corners is a possible move

                    check=isLegal(board,player,0,0);
                    if (check) {
                        allCorners[m][0]=0;
                        allCorners[m][1]=0;
                        m++;
                    }

                    check=isLegal(board,player,0,board[0].length-1);
                    if (check) {
                        allCorners[m][0]=0;
                        allCorners[m][1]=board.length-1;
                        m++;
                    }

                    check=isLegal(board,player,board.length-1,0);
                    if (check) {
                        allCorners[m][0]=board.length-1;
                        allCorners[m][1]=0;
                        m++;
                    }

                    check=isLegal(board,player,board.length-1,board.length-1);
                    if (check){ 
                        allCorners[m][0]=board.length-1;
                        allCorners[m][1]=board.length-1;
                    }

                    double num=(int)(Math.random()*allCorners.length);//the value of num is a number between 0 and allCorners.length
                    int[]randCorner=new int[2];//this array content will be a random corner move
                    for(int i=0; i<allCorners.length; i++){
                        if (num==i){
                            randCorner[0]=allCorners[i][0];
                            randCorner[1]=allCorners[i][1];   
                        }
                    }
                    return randCorner;
                }
            }

            else{//player has moves but not one of the corners

                /*the board is divided to 4 equal squares and if every square the distance between a possible move to the center is being calculated.
                d1 and ahead d2,d3 and d4 will get the minimum distance between a possible move to the corner of the square which is actually
                one of 4 center points of the board of the check square.*/
                int d1=board.length;
                int temp=0;//will get a legal move distnace from the checked index to d1,d2,d3 and d4.

                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(j-column);
                            if (temp<d1)
                                d1=temp;
                        }
                    }
                }

                int d2=board.length;
                temp=board.length;
                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(column-j);
                            if (temp<d2)
                                d2=temp;
                        }
                    }
                }

                int d3=board.length;
                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(column-j);
                            if (temp<d3)
                                d3=temp;
                        }
                    }
                }

                int d4=board.length;
                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(j-column);
                            if (temp<d4)
                                d4=temp;
                        }
                    }
                }
                int min1=Math.min(d1,d2);
                int min2=Math.min(d3,d4);
                int minDistance=Math.min(min1,min2);//the minimum possible move's distance to the center of the board.

                temp=0;
                int counter=0;
                //for loops to check how minDistance moves are legal, using 'counter'
                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(j-column);
                            if (temp==minDistance)
                                counter++;
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(column-j);
                            if (temp==minDistance)
                                counter++;
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(column-j);
                            if (temp==minDistance)
                                counter++;
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(j-column);
                            if (temp==minDistance)
                                counter++;
                        }
                    }
                }

                int [][]allByLocation=new int[counter][2];//two dimensional array with all possible minDistance moves
                int n=0;
                //for loops to fill allByLocation two dimensional array with its siutable values
                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(j-column);
                            if (temp==minDistance){
                                allByLocation[n][0]=i;
                                allByLocation[n][1]=j;
                                n++;
                            }
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2,row=board.length/2; i<board.length; i++){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(i-row)+(column-j);
                            if (temp==minDistance){
                                allByLocation[n][0]=i;
                                allByLocation[n][1]=j;
                                n++;
                            }
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2-1,column=board.length/2-1; j>=0; j--){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(column-j);
                            if (temp==minDistance){
                                allByLocation[n][0]=i;
                                allByLocation[n][1]=j;
                                n++;
                            }
                        }
                    }
                }

                temp=board.length;
                for(int i=board.length/2-1,row=board.length/2-1; i>=0; i--){
                    for(int j=board.length/2,column=board.length/2; j<board.length; j++){
                        boolean check=isLegal(board,player,i,j);
                        if (check){
                            temp=(row-i)+(j-column);
                            if (temp==minDistance){
                                allByLocation[n][0]=i;
                                allByLocation[n][1]=j;
                                n++;
                            }
                        }
                    }
                }

                int []randByLocation=new int[2];//will get one of the indexes which are a possible move and most close to the center
                double num=(int)(Math.random()*allByLocation.length);//num will have a value between 0 and allByLocation.length

                for(int i=0; i<allByLocation.length; i++){
                    if (num==i){//num is equal to i, fill the one dimensional array with this random minDistance move.
                        randByLocation[0]=allByLocation[i][0];
                        randByLocation[1]=allByLocation[i][1];   
                    }
                }
                return randByLocation;//return the array
            }
        }

        return null;//the array is null or player has no possible moves
    }

    public static int[] myPlayer(int[][] board, int player) {
        // a default return statement has been provided. Complete the function's body as you see fit.
        return null;
    }

}
