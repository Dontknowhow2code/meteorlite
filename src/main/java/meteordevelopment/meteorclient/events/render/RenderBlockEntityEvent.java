/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.render;

import meteordevelopment.meteorclient.events.Cancellable;
import net.minecraft.block.entity.BlockEntity;

public class RenderBlockEntityEvent extends Cancellable {
    private static final RenderBlockEntityEvent INSTANCE = new RenderBlockEntityEvent();

    public BlockEntity blockEntity;

    public static RenderBlockEntityEvent get(BlockEntity blockEntity) {
        INSTANCE.setCancelled(false);
        INSTANCE.blockEntity = blockEntity;
        return INSTANCE;
    }
}
