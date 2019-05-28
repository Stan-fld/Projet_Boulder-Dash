package model;

import model.asset.AssetBlocks;

import java.awt.*;

public class Rock extends AnimatedBlock {
    public Rock(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(3 * 16, 16, 3, 1), 3, 0);
    }

}
