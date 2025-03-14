/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.events.game;

public class ResourcePacksReloadedEvent {
    private static final ResourcePacksReloadedEvent INSTANCE = new ResourcePacksReloadedEvent();

    public static ResourcePacksReloadedEvent get() {
        return INSTANCE;
    }
}
