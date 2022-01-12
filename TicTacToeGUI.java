import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton[][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    //    konstruktorius
    public TicTacToeGUI() {
        super();
        pane = this.getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Kryžiukai vs nuliukai");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer = "x";
        board = new JButton[3][3];
        hasWinner = false;
        initializeBoard();
        initializeMenuBar();
    }

    //-------------------------------------------------------------------------------------
    //    metodai
    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        newGame = new JMenuItem("Naujas žaidimas");
//        sukuriam newgame mygtuką
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
//sukuriam quit mygtuką
        quit = new JMenuItem("Baigti žaidimą");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//        pridedam mygtukus i meniu
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    //-------------------------------------------------------------------------------------
//metodas grizta i pradine padeti
    private void resetBoard() {
        currentPlayer = "x";
        hasWinner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
    }
    //-------------------------------------------------------------------------------------

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                board[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") &&
                                hasWinner == false) {
                            button.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                    }
                });
                pane.add(button);
            }
        }
    }

    //    metodas keiciantis zaidejus kas ejima
    private void togglePlayer() {
        if (currentPlayer.equals("x"))
            currentPlayer = "o";
        else
            currentPlayer = "x";
    }

    //    metodas, tikrinantis, ar yra laimetojas
    private void hasWinner() {
        if (board[0][0].getText().equals(currentPlayer) &&
                board[1][0].getText().equals(currentPlayer) &&
                board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, currentPlayer + " laimėjo");
            hasWinner = true;
        } else if (board[0][1].getText().equals(currentPlayer) &&
                board[1][1].getText().equals(currentPlayer) &&
                board[2][1].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, currentPlayer + " laimėjo");
            hasWinner = true;
        } else if (board[0][1].getText().equals(currentPlayer) &&
                board[1][1].getText().equals(currentPlayer) &&
                board[2][1].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, currentPlayer + " laimėjo");
            hasWinner = true;
        }
    }
}
