import java.util.Random;

public class Board {

    Tile[][] mineBoard = new Tile[16][16];

    Board() {
        for (int i = 0; i < mineBoard.length; i++) {
            for (int j = 0; j < mineBoard.length; j++) {
                mineBoard[i][j] = new Tile(i, j);
            }
        }
        fillWithMines(mineBoard);
        computeNumbers(mineBoard);
    }

    public void uncoverTile(int x, int y) {
        if (mineBoard[x][y].marked) System.out.println("cant uncover marked tile");
        else if (mineBoard[x][y].uncovered) System.out.println("tile already uncovered");
        else {
            mineBoard[x][y].setUncovered(true);
            if (mineBoard[x][y].number == 0) uncoverAdjacent(x, y);
        }
    }

    public void uncoverAdjacent(int x, int y) {
        for (int i = 0; i < mineBoard.length; i++) {
            for (int j = 0; j < mineBoard.length; j++) {
                if (x == 0 && y == 0) {
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                    if (!mineBoard[x + 1][y + 1].marked && !mineBoard[x + 1][y + 1].uncovered && mineBoard[x + 1][y + 1].number < 2)
                        uncoverTile(x + 1, y + 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                } else if (x == mineBoard.length - 1 && y == 0) {
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x - 1][y + 1].marked && !mineBoard[x - 1][y + 1].uncovered && mineBoard[x - 1][y + 1].number < 2)
                        uncoverTile(x - 1, y + 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                } else if (x == 0 && y == mineBoard.length - 1) {
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                    if (!mineBoard[x + 1][y - 1].marked && !mineBoard[x + 1][y - 1].uncovered && mineBoard[x + 1][y - 1].number < 2)
                        uncoverTile(x + 1, y - 1);
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                } else if (x == mineBoard.length - 1 && y == mineBoard.length - 1) {
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x - 1][y - 1].marked && !mineBoard[x - 1][y - 1].uncovered && mineBoard[x - 1][y - 1].number < 2)
                        uncoverTile(x - 1, y - 1);
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                } else if (x == 0) {
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                    if (!mineBoard[x + 1][y - 1].marked && !mineBoard[x + 1][y - 1].uncovered && mineBoard[x + 1][y - 1].number < 2)
                        uncoverTile(x + 1, y - 1);
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                    if (!mineBoard[x + 1][y + 1].marked && !mineBoard[x + 1][y + 1].uncovered && mineBoard[x + 1][y + 1].number < 2)
                        uncoverTile(x + 1, y + 1);
                } else if (x == mineBoard.length - 1) {
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                    if (!mineBoard[x - 1][y - 1].marked && !mineBoard[x - 1][y - 1].uncovered && mineBoard[x - 1][y - 1].number < 2)
                        uncoverTile(x - 1, y - 1);
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x - 1][y + 1].marked && !mineBoard[x - 1][y + 1].uncovered && mineBoard[x - 1][y + 1].number < 2)
                        uncoverTile(x - 1, y + 1);
                } else if (y == 0) {
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                    if (!mineBoard[x - 1][y + 1].marked && !mineBoard[x - 1][y + 1].uncovered && mineBoard[x - 1][y + 1].number < 2)
                        uncoverTile(x - 1, y + 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                    if (!mineBoard[x + 1][y + 1].marked && !mineBoard[x + 1][y + 1].uncovered && mineBoard[x + 1][y + 1].number < 2)
                        uncoverTile(x + 1, y + 1);
                } else if (y == mineBoard.length - 1) {
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                    if (!mineBoard[x - 1][y - 1].marked && !mineBoard[x - 1][y - 1].uncovered && mineBoard[x - 1][y - 1].number < 2)
                        uncoverTile(x - 1, y - 1);
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                    if (!mineBoard[x + 1][y - 1].marked && !mineBoard[x + 1][y - 1].uncovered && mineBoard[x + 1][y - 1].number < 2)
                        uncoverTile(x + 1, y - 1);
                } else {
                    if (!mineBoard[x - 1][y - 1].marked && !mineBoard[x - 1][y - 1].uncovered && mineBoard[x - 1][y - 1].number < 2)
                        uncoverTile(x - 1, y - 1);
                    if (!mineBoard[x - 1][y].marked && !mineBoard[x - 1][y].uncovered && mineBoard[x - 1][y].number < 2)
                        uncoverTile(x - 1, y);
                    if (!mineBoard[x - 1][y + 1].marked && !mineBoard[x - 1][y + 1].uncovered && mineBoard[x - 1][y + 1].number < 2)
                        uncoverTile(x - 1, y + 1);
                    if (!mineBoard[x][y - 1].marked && !mineBoard[x][y - 1].uncovered && mineBoard[x][y - 1].number < 2)
                        uncoverTile(x, y - 1);
                    if (!mineBoard[x][y + 1].marked && !mineBoard[x][y + 1].uncovered && mineBoard[x][y + 1].number < 2)
                        uncoverTile(x, y + 1);
                    if (!mineBoard[x + 1][y - 1].marked && !mineBoard[x + 1][y - 1].uncovered && mineBoard[x + 1][y - 1].number < 2)
                        uncoverTile(x + 1, y - 1);
                    if (!mineBoard[x + 1][y].marked && !mineBoard[x + 1][y].uncovered && mineBoard[x + 1][y].number < 2)
                        uncoverTile(x + 1, y);
                    if (!mineBoard[x + 1][y + 1].marked && !mineBoard[x + 1][y + 1].uncovered && mineBoard[x + 1][y + 1].number < 2)
                        uncoverTile(x + 1, y + 1);
                }
            }
        }
    }

    public void markTile(int x, int y) {
        if (mineBoard[x][y].marked) mineBoard[x][y].setMarked(false);
        else mineBoard[x][y].setMarked(true);
    }

    public void fillWithMines(Tile[][] board) {
        int mineCount = 40;
        Random rand = new Random();
        while (mineCount > 0) {
            int x = rand.nextInt(16);
            int y = rand.nextInt(16);

            if (!board[x][y].mine) {
                board[x][y].mine = true;
                board[x][y].number = 100;
                mineCount--;
            }
        }
    }

    public void computeNumbers(Tile[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].mine) {
                    if (i == 0 && j == 0) {
                        board[i][j].number = -1;
                        board[i + 1][j].number++;
                        board[i + 1][j + 1].number++;
                        board[i][j + 1].number++;
                    } else if (i == 0 && j == board.length - 1) {
                        board[i][j - 1].number++;
                        board[i + 1][j - 1].number++;
                        board[i + 1][j].number++;
                    } else if (i == board.length - 1 && j == 0) {
                        board[i - 1][j].number++;
                        board[i - 1][j + 1].number++;
                        board[i][j + 1].number++;
                    } else if (i == board.length - 1 && j == board.length - 1) {
                        board[i - 1][j].number++;
                        board[i - 1][j - 1].number++;
                        board[i][j - 1].number++;
                    } else if (i == 0) {
                        board[i][j - 1].number++;
                        board[i][j + 1].number++;
                        board[i + 1][j - 1].number++;
                        board[i + 1][j].number++;
                        board[i + 1][j + 1].number++;
                    } else if (i == board.length - 1) {
                        board[i][j - 1].number++;
                        board[i][j + 1].number++;
                        board[i - 1][j - 1].number++;
                        board[i - 1][j].number++;
                        board[i - 1][j + 1].number++;
                    } else if (j == 0) {
                        board[i - 1][j].number++;
                        board[i + 1][j].number++;
                        board[i - 1][j + 1].number++;
                        board[i][j + 1].number++;
                        board[i + 1][j + 1].number++;
                    } else if (j == board.length - 1) {
                        board[i - 1][j].number++;
                        board[i + 1][j].number++;
                        board[i - 1][j - 1].number++;
                        board[i][j - 1].number++;
                        board[i + 1][j - 1].number++;
                    } else {
                        board[i - 1][j - 1].number++;
                        board[i - 1][j].number++;
                        board[i - 1][j + 1].number++;
                        board[i][j - 1].number++;
                        board[i][j + 1].number++;
                        board[i + 1][j - 1].number++;
                        board[i + 1][j].number++;
                        board[i + 1][j + 1].number++;
                    }
                }
            }
        }
    }
}
