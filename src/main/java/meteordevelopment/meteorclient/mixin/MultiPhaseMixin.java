/*
 * This file is part of the Meteorlite Client tribution based off of Meteor Client, which can be found at: https://github.com/MeteorDevelopment/meteor-client.
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.mixin;

import meteordevelopment.meteorclient.mixininterface.IMultiPhase;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RenderLayer.MultiPhase.class)
public abstract class MultiPhaseMixin implements IMultiPhase {
    @Shadow
    @Final
    private RenderLayer.MultiPhaseParameters phases;

    @Override
    public RenderLayer.MultiPhaseParameters meteor$getParameters() {
        return this.phases;
    }
}
