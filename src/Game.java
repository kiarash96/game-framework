import javax.swing.JFrame;

/**
 * Created by kiarash on 7/16/16.
 */
public class Game {

    JFrame window;
    GamePanel panel;

    public void run() {
        panel = new GamePanel();

        window = new JFrame("My Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.mainLoop();
    }

    public static void main(String[] args) {
        new Game().run();
    }
}
