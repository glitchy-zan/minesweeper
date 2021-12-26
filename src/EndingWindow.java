import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndingWindow {

    JFrame frame;
    int length = 16;
    JPanel panel;
    JButton[][] buttons = new JButton[length][length];
    JMenuBar menuBar = new JMenuBar();
    JMenu game = new JMenu("game");
    JMenu settings = new JMenu("settings");
    JMenu results = new JMenu("results");
    JMenuItem startGame = new JMenuItem("start game");

    public EndingWindow() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridLayout(length, length));

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(new Color(218, 92, 92));
                buttons[i][j].setBorder(new LineBorder(Color.BLACK));
                buttons[i][j].setPreferredSize(new Dimension(20, 20));
                panel.add(buttons[i][j]);
                if (i == 6) {
                    if (j == 6) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("g");
                    } else if (j == 7) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("a");
                    } else if (j == 8) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("m");
                    } else if (j == 9) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("e");
                    }
                } else if (i == 7) {
                    if (j == 6) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("o");
                    } else if (j == 7) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("v");
                    } else if (j == 8) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("e");
                    } else if (j == 9) {
                        buttons[i][j].setBorder(new LineBorder(new Color(218, 92, 92)));
                        buttons[i][j].setText("r");
                    }
                }
            }
        }
        menuBar.add(game);
        menuBar.add(settings);
        menuBar.add(results);

        game.add(startGame);

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Game_GUI();
                frame.dispose();
            }
        });

        frame.add(panel);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("MineSweeper");
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        StartingWindow gui = new StartingWindow();
    }
}
