/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixininterface;

public interface IRenderPipeline {
    void meteor$setLineSmooth(boolean lineSmooth);

    boolean meteor$getLineSmooth();
}
