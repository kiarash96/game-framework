import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Created by kiarash on 7/16/16.
 */
public class GamePanel extends JPanel {
    public static final int WIDTH = 1280, HEIGHT = 960;
    public static final int FPS = 60;

    Image buffer;

    boolean running;

    public GamePanel() {
        super();

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        running = true;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void mainLoop() {
        while (running) {
            processInput();
            update();
            render();
        }
    }

    private void processInput() {
        // TODO
    }

    private void update() {
        // TODO
    }

    private void render() {
        // TODO
    }
}
