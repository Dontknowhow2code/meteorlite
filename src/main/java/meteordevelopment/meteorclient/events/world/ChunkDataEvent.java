/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.world;

import net.minecraft.world.chunk.WorldChunk;

/**
 * @implNote Shouldn't be put in a {@link meteordevelopment.meteorclient.utils.misc.Pool} to avoid a race-condition, or in a {@link ThreadLocal} as it is shared between threads.
 * @author Crosby
 */
public record ChunkDataEvent(WorldChunk chunk) {}
