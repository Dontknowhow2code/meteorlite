/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixininterface;

import net.minecraft.client.gl.Framebuffer;

public interface IMinecraftClient {
    void meteor$rightClick();

    void meteor$setFramebuffer(Framebuffer framebuffer);
}
