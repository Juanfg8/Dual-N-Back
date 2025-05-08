import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    private final int gridSize = 3;
    private final int cellSize = 200;
    private final Timer timer;
    private final GameLogic logic;

    public GamePanel() {
        setPreferredSize(new Dimension(gridSize * cellSize, gridSize * cellSize));
        setBackground(Color.WHITE);
        setFocusable(true);

        logic = new GameLogic();
        timer = new Timer(2000, this);
        timer.start();

        // Captura a tecla espaço para verificar se o jogador acertou
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (logic.isAguardandoResposta()) {
                        if (logic.isEraMatch()) {
                            System.out.println("Você Acertou!");
                        } else {
                            System.out.println("Você Errou!");
                        }
                        logic.setAguardandoResposta(false); // Jogador já respondeu
                    }
                }
            }
        }); // <-- Parêntese e ponto-e-vírgula que estavam faltando
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logic.addRandomPosition();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a grade
        for (int i = 0; i < 9; i++) {
            int x = (i % 3) * cellSize;
            int y = (i / 3) * cellSize;
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, cellSize, cellSize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cellSize, cellSize);
        }

        // Desenha a bolinha azul na posição atual
        Integer pos = logic.getCurrentPosition();
        if (pos != null) {
            int zeroIndexedPos = pos - 1;
            int x = (zeroIndexedPos % 3) * cellSize;
            int y = (zeroIndexedPos / 3) * cellSize;
            g.setColor(Color.BLUE);
            g.fillOval(x + 50, y + 50, 100, 100); // O offset e tamanho da bolinha podem ser mantidos
        }
    }
}
