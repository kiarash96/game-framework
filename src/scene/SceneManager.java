package scene;

import scene.Nodes.EmptyNode;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiarash on 7/16/16.
 */
public class SceneManager {

    SceneNode root;
    List<SceneNode> nodes;
    Map<SceneNode, AffineTransform> transformMap;

    public SceneManager() {
        root = new EmptyNode();
        root.sm = this;

        nodes = new ArrayList<>();
        transformMap = new HashMap<>();
    }

    public SceneNode getRoot() {
        return root;
    }

    public void update(double dt) {
        root.update(dt);
    }

    public void render(Graphics2D g) {
        root.recursiveUpdateTransform(new AffineTransform());

        // TODO: sort nodes by layer
        nodes.forEach(node -> {
            g.setTransform(transformMap.get(node));
            node.drawSelf(g);
        });
    }
}
