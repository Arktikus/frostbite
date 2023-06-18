/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.entity.client;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import me.arktikus.frostbite.entity.custom.TigerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PinguinModel extends GeoModel<PinguinEntity> {
    @Override
    public Identifier getModelResource(PinguinEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "geo/pinguin.geo.json");
    }

    @Override
    public Identifier getTextureResource(PinguinEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "textures/entity/pinguin.png");
    }

    @Override
    public Identifier getAnimationResource(PinguinEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "animations/pinguin.animation.json");
    }

    @Override
    public void setCustomAnimations(PinguinEntity animatable, long instanceId, AnimationState<PinguinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }

}