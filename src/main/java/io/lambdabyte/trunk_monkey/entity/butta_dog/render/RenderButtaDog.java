package io.lambdabyte.trunk_monkey.entity.butta_dog.render;

import io.lambdabyte.trunk_monkey.entity.butta_dog.model.*;
import io.lambdabyte.trunk_monkey.Constants;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import io.lambdabyte.trunk_monkey.entity.butta_dog.EntityButtaDog;

public class RenderButtaDog extends MobRenderer<EntityButtaDog, ModelButtaDog>{
    public RenderButtaDog(EntityRendererManager render) {
		super(render, new ModelButtaDog(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityButtaDog entity) {
		return new ResourceLocation(Constants.MOD_ID, "textures/entity/butta_dog.png");
	}
}
