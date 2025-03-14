/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.gui.widgets;

public abstract class WHorizontalSeparator extends WWidget {
    protected String text;
    protected double textWidth;

    public WHorizontalSeparator(String text) {
        this.text = text;
    }

    @Override
    protected void onCalculateSize() {
        if (text != null) textWidth = theme.textWidth(text);

        width = 1;
        height = text != null ? theme.textHeight() : theme.scale(3);
    }
}
