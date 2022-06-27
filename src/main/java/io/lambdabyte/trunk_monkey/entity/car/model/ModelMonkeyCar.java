package io.lambdabyte.trunk_monkey.entity.car.model;

import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.entity.car.EntityMonkeyCar;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelMonkeyCar extends AnimatedEntityModel<EntityMonkeyCar> {

	private final AnimatedModelRenderer car;
	private final AnimatedModelRenderer wheels;
	private final AnimatedModelRenderer rims;
	private final AnimatedModelRenderer bumper;
	private final AnimatedModelRenderer trunk;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer trunk_cover;
	private final AnimatedModelRenderer car_top;
	private final AnimatedModelRenderer windsheld;
	private final AnimatedModelRenderer bipedHead;
	private final AnimatedModelRenderer bipedBody;

	public ModelMonkeyCar()
	{
		textureWidth = 256;
		textureHeight = 256;
		car = new AnimatedModelRenderer(this);
		car.setRotationPoint(0.0F, 24.0F, 0.0F);

		car.setModelRendererName("car");
		this.registerModelRenderer(car);

		wheels = new AnimatedModelRenderer(this);
		wheels.setRotationPoint(0.0F, 0.0F, 0.0F);
		car.addChild(wheels);
		wheels.setTextureOffset(16, 40).addBox(-11.48F, -7.0F, -17.38F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		wheels.setTextureOffset(22, 24).addBox(9.06F, -7.0F, -17.38F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		wheels.setTextureOffset(0, 40).addBox(-11.48F, -7.0F, 11.06F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		wheels.setTextureOffset(0, 52).addBox(9.06F, -7.0F, 11.06F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		wheels.setModelRendererName("wheels");
		this.registerModelRenderer(wheels);

		rims = new AnimatedModelRenderer(this);
		rims.setRotationPoint(0.0F, 0.0F, 0.0F);
		car.addChild(rims);
		rims.setTextureOffset(0, 80).addBox(9.06F, -13.32F, -17.38F, 2.0F, 7.0F, 35.0F, 0.0F, false);
		rims.setTextureOffset(73, 73).addBox(-11.48F, -12.32F, -17.38F, 2.0F, 6.0F, 35.0F, 0.0F, false);
		rims.setModelRendererName("rims");
		this.registerModelRenderer(rims);

		bumper = new AnimatedModelRenderer(this);
		bumper.setRotationPoint(0.0F, 0.0F, -3.16F);
		car.addChild(bumper);
		bumper.setTextureOffset(39, 77).addBox(-11.94F, -12.74F, -22.12F, 23.0F, 8.0F, 8.0F, 0.0F, false);
		bumper.setTextureOffset(73, 53).addBox(-11.94F, -12.74F, 20.54F, 23.0F, 8.0F, 8.0F, 0.0F, false);
		bumper.setModelRendererName("bumper");
		this.registerModelRenderer(bumper);

		trunk = new AnimatedModelRenderer(this);
		trunk.setRotationPoint(0.0F, 0.0F, 0.0F);
		car.addChild(trunk);

		trunk.setModelRendererName("trunk");
		this.registerModelRenderer(trunk);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		trunk.addChild(bone);
		bone.setTextureOffset(82, 0).addBox(9.06F, -25.64F, 0.0F, 2.0F, 13.0F, 24.0F, 0.0F, false);
		bone.setTextureOffset(82, 0).addBox(-11.94F, -25.64F, 0.0F, 2.0F, 13.0F, 24.0F, 0.0F, false);
		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		car.addChild(body);
		body.setTextureOffset(74, 115).addBox(-9.52F, -25.32F, 0.0F, 19.0F, 19.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 40).addBox(-9.52F, -6.74F, -17.38F, 19.0F, 2.0F, 35.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		trunk_cover = new AnimatedModelRenderer(this);
		trunk_cover.setRotationPoint(-1.58F, 3.16F, -1.58F);
		car.addChild(trunk_cover);
		trunk_cover.setTextureOffset(39, 93).addBox(-10.36F, -28.8F, 25.28F, 23.0F, 13.0F, 1.0F, 0.0F, false);
		trunk_cover.setModelRendererName("trunk_cover");
		this.registerModelRenderer(trunk_cover);

		car_top = new AnimatedModelRenderer(this);
		car_top.setRotationPoint(0.0F, 0.0F, 0.0F);
		car.addChild(car_top);
		car_top.setTextureOffset(0, 0).addBox(-11.94F, -27.28F, -12.64F, 23.0F, 2.0F, 38.0F, 0.0F, false);
		car_top.setModelRendererName("car_top");
		this.registerModelRenderer(car_top);

		windsheld = new AnimatedModelRenderer(this);
		windsheld.setRotationPoint(0.0F, 9.48F, -12.64F);
		car.addChild(windsheld);
		setRotationAngle(windsheld, -0.5672F, 0.0F, 0.0F);
		windsheld.setTextureOffset(112, 69).addBox(-11.94F, -30.4834F, -19.4973F, 23.0F, 17.0F, 2.0F, 0.0F, false);
		windsheld.setModelRendererName("windsheld");
		this.registerModelRenderer(windsheld);

		bipedHead = new AnimatedModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -37.92F, 0.0F);
		car.addChild(bipedHead);
		bipedHead.setTextureOffset(0, 0).addBox(-1.68F, 15.7F, -12.64F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		bipedHead.setModelRendererName("bipedHead");
		this.registerModelRenderer(bipedHead);

		bipedBody = new AnimatedModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, -37.92F, 0.0F);
		car.addChild(bipedBody);
		bipedBody.setTextureOffset(0, 16).addBox(-1.68F, 23.6F, -11.06F, 8.0F, 8.0F, 6.0F, 0.0F, false);
		bipedBody.setModelRendererName("bipedBody");
		this.registerModelRenderer(bipedBody);

		this.rootBones.add(car);
	}

	@Override
	public ResourceLocation getAnimationFileLocation()
	{
		return new ResourceLocation(Constants.MOD_ID + ":" + "animations/monkey_car.json");
	}
}