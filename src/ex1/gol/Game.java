package ex1.gol;


public class Game {

    public boolean board[][] = new boolean[15][20];

    public void markAlive(int x, int y) {
        board[x][y] = true;
    }

    public boolean isAlive(int x, int y) {
        return board[x][y];
    }

    public void toggle(int x, int y) {
        if(board[x][y]){
            board[x][y] = false;
        }else {
            board[x][y] = true;
        }
    }

    public Integer getNeighbourCount(int x, int y) {
        Integer count = 0;

        if(x == 0 && y == 0){
            count += booleanToInt(board, x + 1, y);
            count += booleanToInt(board, x, y + 1);
            count += booleanToInt(board, x + 1, y + 1);
        }else if(x == 0){
            count += booleanToInt(board, x, y - 1);
            count += booleanToInt(board, x, y + 1);
            count += booleanToInt(board, x + 1, y - 1);
            count += booleanToInt(board, x + 1, y);
            count += booleanToInt(board, x + 1, y + 1);
        }else if(y == 0){
            count += booleanToInt(board, x + 1, y);
            count += booleanToInt(board, x - 1, y);
            count += booleanToInt(board, x, y + 1);
            count += booleanToInt(board, x + 1, y + 1);
            count += booleanToInt(board, x - 1, y + 1);
        }else if(x == 14 && y == 0){
            count += booleanToInt(board, x - 1, y);
            count += booleanToInt(board, x - 1, y + 1);
            count += booleanToInt(board, x, y + 1);
        }else if(y == 19 && x == 0){
            count += booleanToInt(board, x, y - 1);
            count += booleanToInt(board, x + 1, y);
            count += booleanToInt(board, x +1, y -1);
        }else if(y == 19){
            count += booleanToInt(board, x -1, y -1);
            count += booleanToInt(board, x - 1, y - 1);
            count += booleanToInt(board, x, y - 1);
            count += booleanToInt(board, x + 1, y - 1);
            count += booleanToInt(board, x + 1, y);
        }else if (y == 19 && x == 14){
            count += booleanToInt(board, x, y -1);
            count += booleanToInt(board, x -1, y);
            count += booleanToInt(board, x - 1, y -1);
        }else {
            count += booleanToInt(board, x - 1, y - 1);
            count += booleanToInt(board, x - 1, y);
            count += booleanToInt(board, x - 1, y + 1);

            count += booleanToInt(board, x, y - 1);
            count += booleanToInt(board, x, y + 1);

            count += booleanToInt(board, x + 1, y - 1);
            count += booleanToInt(board, x + 1, y);
            count += booleanToInt(board, x + 1, y + 1);

        }




        return count;

    }

    public void nextFrame() {
        boolean copyOfBoard[][] = new boolean[15][20];
        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 19; y++) {
                copyOfBoard[x][y] = nextState(isAlive(x,y), getNeighbourCount(x,y));
            }
        }

        board = copyOfBoard;

    }

    public void clear() {
        throw new RuntimeException("not implemented yet");
    }

    public boolean nextState(boolean isLiving, int neighborCount) {
        if(isLiving && neighborCount == 1 || neighborCount == 4){
            return false;
        }
        if(!isLiving && neighborCount == 3){
            return true;
        }
        return isLiving;
    }

    public Integer booleanToInt(boolean board[][], int x, int y) {
            if (board[x][y]) {
                return 1;
            } else {
                return 0;
            }
    }
}
