/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.renderer;

public enum ShapeMode {
    Lines,
    Sides,
    Both;

    public boolean lines() {
        return this == Lines || this == Both;
    }

    public boolean sides() {
        return this == Sides ||this == Both;
    }
}
