package io.lambdabyte.trunk_monkey.entity.butta_dog.model;

import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.entity.butta_dog.EntityButtaDog;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ModelButtaDog extends AnimatedEntityModel<EntityButtaDog> {

    private final AnimatedModelRenderer wolf;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer leg3;
	private final AnimatedModelRenderer leg2;
	private final AnimatedModelRenderer leg1;
	private final AnimatedModelRenderer leg0;
	private final AnimatedModelRenderer upperBody;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer butter_piece;

    public ModelButtaDog()
    {
        textureWidth = 64;
    	textureHeight = 64;
    	wolf = new AnimatedModelRenderer(this);
		wolf.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		wolf.setModelRendererName("wolf");
		this.registerModelRenderer(wolf);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(1.0F, -12.0F, 7.0F);
		wolf.addChild(tail);
		setRotationAngle(tail, 0.6545F, 0.0F, 0.0F);
		tail.setTextureOffset(0, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		tail.setModelRendererName("tail");
		this.registerModelRenderer(tail);

		leg3 = new AnimatedModelRenderer(this);
		leg3.setRotationPoint(-0.5F, -8.0F, -4.0F);
		wolf.addChild(leg3);
		leg3.setTextureOffset(8, 29).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leg3.setModelRendererName("leg3");
		this.registerModelRenderer(leg3);

		leg2 = new AnimatedModelRenderer(this);
		leg2.setRotationPoint(2.5F, -8.0F, -4.0F);
		wolf.addChild(leg2);
		leg2.setTextureOffset(16, 29).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leg2.setModelRendererName("leg2");
		this.registerModelRenderer(leg2);

		leg1 = new AnimatedModelRenderer(this);
		leg1.setRotationPoint(-0.5F, -8.0F, 7.0F);
		wolf.addChild(leg1);
		leg1.setTextureOffset(30, 5).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leg1.setModelRendererName("leg1");
		this.registerModelRenderer(leg1);

		leg0 = new AnimatedModelRenderer(this);
		leg0.setRotationPoint(2.5F, -8.0F, 7.0F);
		wolf.addChild(leg0);
		leg0.setTextureOffset(32, 14).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leg0.setModelRendererName("leg0");
		this.registerModelRenderer(leg0);

		upperBody = new AnimatedModelRenderer(this);
		upperBody.setRotationPoint(1.0F, -10.0F, 2.0F);
		wolf.addChild(upperBody);
		upperBody.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);
		upperBody.setModelRendererName("upperBody");
		this.registerModelRenderer(upperBody);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, -10.0F, 6.0F);
		wolf.addChild(body);
		setRotationAngle(body, -1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 14).addBox(-2.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(1.0F, -10.5F, -7.0F);
		wolf.addChild(head);
		head.setTextureOffset(24, 24).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 3).addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(18, 14).addBox(-1.5F, -0.02F, -5.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(23, 0).addBox(-1.5F, 1.98F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		butter_piece = new AnimatedModelRenderer(this);
		butter_piece.setRotationPoint(0.0F, 0.0F, 0.0F);
		wolf.addChild(butter_piece);
		butter_piece.setTextureOffset(0, 14).addBox(0.5F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		butter_piece.setModelRendererName("butter_piece");
		this.registerModelRenderer(butter_piece);

    this.rootBones.add(wolf);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
		return new ResourceLocation(Constants.MOD_ID, "animations/butta_dog.json");
    }
}