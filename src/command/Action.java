package command;

import scene.SceneNode;

/**
 * Created by kiarash on 7/19/16.
 */
public interface Action {
     void execute(SceneNode node, double dt);
}
