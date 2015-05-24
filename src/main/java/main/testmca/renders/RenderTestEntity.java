package main.testmca.renders;

import main.testmca.TestMCA;
import main.testmca.renders.models.ModelTestEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class RenderTestEntity extends RenderLiving 
{
	public static final ResourceLocation texture = new ResourceLocation(TestMCA.MODID, "textures/entities/test_entity.png");
	
	public RenderTestEntity() 
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelTestEntity(), 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}
