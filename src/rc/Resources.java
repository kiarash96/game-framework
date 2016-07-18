package rc;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiarash on 7/18/16.
 */
public class Resources {

    public enum TextureID {

    }

    private static Map<TextureID, Image> textureHolder;

    {
        textureHolder = new HashMap<>();
    }

    public static Map<TextureID, Image> getTextureHolder() {
        return textureHolder;
    }
}
