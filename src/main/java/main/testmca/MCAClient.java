package main.testmca;

import main.testmca.entities.EntityTestEntity;
import main.testmca.renders.RenderTestEntity;
import main.testmca.renders.TileTestSpecialRenderer;
import main.testmca.tiles.TileTestTile;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class MCAClient extends MCACommon
{
	@Override
	public void registerRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileTestTile.class, new TileTestSpecialRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityTestEntity.class, new RenderTestEntity());
	}
}
