/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.entity.player;

import meteordevelopment.meteorclient.events.Cancellable;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class PlaceBlockEvent extends Cancellable {
    private static final PlaceBlockEvent INSTANCE = new PlaceBlockEvent();

    public BlockPos blockPos;
    public Block block;

    public static PlaceBlockEvent get(BlockPos blockPos, Block block) {
        INSTANCE.setCancelled(false);
        INSTANCE.blockPos = blockPos;
        INSTANCE.block = block;
        return INSTANCE;
    }
}
