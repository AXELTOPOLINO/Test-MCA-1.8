package mca.library.client;

import java.util.Arrays;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** Coords values are set following a right-handed system with no transformations(ie. a default one, with +Z which goes out of the screen). */
public class MCAModelBox extends ModelBox
{

	/** Same as superclass, but it was PRIVATE. */
	private final TexturedQuad[] MCAquadList;
	public Vec3 beginning, end;

	public MCAModelBox(ModelRenderer par1ModelRenderer, int textureX, int textureY, float posX, float posY, float posZ, int sizeX, int sizeY, int sizeZ, float scaleFactor)
	{
		super(par1ModelRenderer, textureX, textureY, posX, posY, posZ, sizeX, sizeY, sizeZ, scaleFactor);

		MCAquadList = new TexturedQuad[6];

		float endX = posX + sizeX;
		float endY = posY + sizeY;
		float endZ = posZ + sizeZ;
		posX -= scaleFactor;
		posY -= scaleFactor;
		posZ -= scaleFactor;
		endX += scaleFactor;
		endY += scaleFactor;
		endZ += scaleFactor;

		if (par1ModelRenderer.mirror)
		{
			float tempValueForSwitch = endX;
			endX = posX;
			posX = tempValueForSwitch;
		}
		beginning = new Vec3(posX, posY, posZ);
		end = new Vec3(endX, endY, endZ);

		/** Create PTV with RANDOM UV values (0 and 8). They will be set correctly later. */
		PositionTextureVertex PTV_back_left_bottom = new PositionTextureVertex(posX, posY, posZ, 0.0F, 0.0F);
		PositionTextureVertex PTV_back_right_bottom = new PositionTextureVertex(endX, posY, posZ, 0.0F, 8.0F);
		PositionTextureVertex PTV_back_right_top = new PositionTextureVertex(endX, endY, posZ, 8.0F, 8.0F);
		PositionTextureVertex PTV_back_left_top = new PositionTextureVertex(posX, endY, posZ, 8.0F, 0.0F);
		PositionTextureVertex PTV_front_left_bottom = new PositionTextureVertex(posX, posY, endZ, 0.0F, 0.0F);
		PositionTextureVertex PTV_front_right_bottom = new PositionTextureVertex(endX, posY, endZ, 0.0F, 8.0F);
		PositionTextureVertex PTV_front_right_top = new PositionTextureVertex(endX, endY, endZ, 8.0F, 8.0F);
		PositionTextureVertex PTV_front_left_top = new PositionTextureVertex(posX, endY, endZ, 8.0F, 0.0F);
		//...
		/** Create the TexturedQuads. The constructor of each quad defines the order of the PTV (counterclockwise) and fixes their UV. */
		//East quad (TODO fix texture)
		MCAquadList[0] = new TexturedQuad(new PositionTextureVertex[] { PTV_back_right_top, PTV_front_right_top, PTV_front_right_bottom, PTV_back_right_bottom }, textureX + sizeZ + sizeX, textureY + sizeZ, textureX + sizeZ + sizeX + sizeZ, textureY + sizeZ + sizeY, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
		//West quad (TODO fix texture)
		MCAquadList[1] = new TexturedQuad(new PositionTextureVertex[] { PTV_front_left_top, PTV_back_left_top, PTV_back_left_bottom, PTV_front_left_bottom }, textureX, textureY + sizeZ, textureX + sizeZ, textureY + sizeZ + sizeY, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
		//Down quad
		MCAquadList[2] = new TexturedQuad(new PositionTextureVertex[] { PTV_front_right_bottom, PTV_front_left_bottom, PTV_back_left_bottom, PTV_back_right_bottom }, textureX + sizeZ + sizeX, textureY, textureX + sizeZ + sizeX + sizeX, textureY + sizeZ, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
		//Up quad
		MCAquadList[3] = new TexturedQuad(new PositionTextureVertex[] { PTV_back_right_top, PTV_back_left_top, PTV_front_left_top, PTV_front_right_top }, textureX + sizeZ, textureY, textureX + sizeZ + sizeX, textureY + sizeZ, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
		//South quad 
		MCAquadList[4] = new TexturedQuad(new PositionTextureVertex[] { PTV_back_left_top, PTV_back_right_top, PTV_back_right_bottom, PTV_back_left_bottom }, textureX + sizeZ + sizeX + sizeZ, textureY + sizeZ, textureX + sizeZ + sizeX + sizeZ + sizeX, textureY + sizeZ + sizeY, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);
		//North quad 
		MCAquadList[5] = new TexturedQuad(new PositionTextureVertex[] { PTV_front_right_top, PTV_front_left_top, PTV_front_left_bottom, PTV_front_right_bottom }, textureX + sizeZ, textureY + sizeZ, textureX + sizeZ + sizeX, textureY + sizeZ + sizeY, par1ModelRenderer.textureWidth, par1ModelRenderer.textureHeight);

		if (par1ModelRenderer.mirror)
		{
			for (int j1 = 0; j1 < MCAquadList.length; ++j1)
			{
				MCAquadList[j1].flipFace();
			}
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(WorldRenderer par1WorldRenderer, float textureX)
	{
		for (int i = 0; i < MCAquadList.length; ++i)
		{
			MCAquadList[i].draw(par1WorldRenderer, textureX);
		}
	}

	public TexturedQuad[] getQuads()
	{
		return Arrays.copyOf(MCAquadList, MCAquadList.length);
	}
}
