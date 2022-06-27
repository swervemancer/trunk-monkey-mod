package io.lambdabyte.trunk_monkey.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.entity.EntityTrunkMonkey;
import io.lambdabyte.trunk_monkey.entity.model.TrunkMonkeyModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TrunkMonkeyRenderer extends MobRenderer<EntityTrunkMonkey, TrunkMonkeyModel>{

	public TrunkMonkeyRenderer(EntityRendererManager manager) {
		super(manager, new TrunkMonkeyModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTrunkMonkey entity) {
		return new ResourceLocation(Constants.MOD_ID, "textures/entity/trunk_monkey.png");
	}

	@Override
	protected void applyRotations(EntityTrunkMonkey entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}
