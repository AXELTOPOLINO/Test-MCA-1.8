package main.testmca.renders;

import main.testmca.TestMCA;
import main.testmca.renders.models.ModelTestTile;
import mca.library.common.IMCAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileTestSpecialRenderer extends TileEntitySpecialRenderer
{
	public static final ResourceLocation Stuff_texture = new ResourceLocation(TestMCA.MODID + ":textures/models/Stuff.png");
	public final ModelTestTile modelTestTile;

	public TileTestSpecialRenderer()
	{
		modelTestTile = new ModelTestTile();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale, int b)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y - 1.0F, (float) z + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(Stuff_texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		if (te instanceof IMCAnimatedEntity)
		{
			modelTestTile.render((IMCAnimatedEntity) te, 0.0625F);
		}
		else
		{
			modelTestTile.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
