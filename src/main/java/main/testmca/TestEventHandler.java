package main.testmca;

import main.testmca.renders.models.BakedTestTileModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TestEventHandler
{
	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event)
	{
		//ModelResourceLocation, IBakedModel
		event.modelRegistry.putObject(TestMCA.instance.loc, new BakedTestTileModel());
	}

	@SubscribeEvent
	public void onTextureStich(TextureStitchEvent.Pre event)
	{
		event.map.setTextureEntry(TestMCA.MODID + ":models/Stuff", event.map.registerSprite(new ResourceLocation(TestMCA.MODID + ":models/Stuff")));
	}
}
