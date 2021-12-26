import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game_GUI implements MouseListener {

    JFrame frame;
    JPanel firstPanel;
    JPanel panel;
    int length = 16;
    JButton[][] buttons = new JButton[length][length];
    Board board = new Board();

    public Game_GUI() {
        frame = new JFrame();
        firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(length, length));
        firstPanel.add(panel, BorderLayout.CENTER);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(new Color(218, 92, 92));
                buttons[i][j].setBorder(new LineBorder(Color.BLACK));
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                buttons[i][j].addMouseListener(this);
                panel.add(buttons[i][j]);
            }
        }

        frame.add(firstPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("MineSweeper");
        frame.pack();
        frame.setVisible(true);
    }

    public String setText(Board board, int i, int j) {
        if (board.mineBoard[i][j].uncovered) {
            if (board.mineBoard[i][j].mine) {
                return "B";
            } else return "" + board.mineBoard[i][j].number;
        } else if (board.mineBoard[i][j].marked) {
            return "?";
        } else return "";
    }

    public boolean isOver(Board board) {
        boolean res = true;
        for (int i = 0; i < board.mineBoard.length; i++) {
            for (int j = 0; j < board.mineBoard.length; j++) {
                if (board.mineBoard[i][j].mine && board.mineBoard[i][j].uncovered) {
                    return true;
                } else if (!board.mineBoard[i][j].uncovered && !board.mineBoard[i][j].mine) res = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Game_GUI gui = new Game_GUI();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (mouseEvent.getSource() == buttons[i][j]) {
                        board.uncoverTile(i, j);
                        if (isOver(board)) {
                            new EndingWindow();
                            frame.dispose();
                        }
                    }
                }
            }
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    buttons[i][j].setText(setText(board, i, j));
                }
            }
        } else if (SwingUtilities.isRightMouseButton(mouseEvent)) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (mouseEvent.getSource() == buttons[i][j]) {
                        board.markTile(i, j);
                    }
                    buttons[i][j].setText(setText(board, i, j));
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
