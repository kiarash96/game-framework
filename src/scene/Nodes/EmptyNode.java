package scene.Nodes;

import scene.SceneNode;

import java.awt.Graphics2D;

/**
 * Created by kiarash on 7/19/16.
 */
public class EmptyNode extends SceneNode {
    @Override
    public void drawSelf(Graphics2D g) { }

    @Override
    public void updateSelf(double dt) { }
}
