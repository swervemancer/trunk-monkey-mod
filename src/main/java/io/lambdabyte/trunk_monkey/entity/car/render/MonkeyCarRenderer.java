package io.lambdabyte.trunk_monkey.entity.car.render;

import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.entity.car.EntityMonkeyCar;
import io.lambdabyte.trunk_monkey.entity.car.model.ModelMonkeyCar;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MonkeyCarRenderer extends MobRenderer<EntityMonkeyCar, ModelMonkeyCar>{

	public MonkeyCarRenderer(EntityRendererManager render) {
		super(render, new ModelMonkeyCar(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityMonkeyCar entity) {
		return new ResourceLocation(Constants.MOD_ID, "textures/entity/monkey_car.png");
	}
}
