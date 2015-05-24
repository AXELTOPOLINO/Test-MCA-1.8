package main.testmca.renders.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTestEntity extends ModelBase 
{
	public ModelRenderer box;
	
	public ModelTestEntity() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		box = new ModelRenderer(this, 0, 0);
		box.addBox(-8.0F, 3.0F, -8.0F, 16, 16, 16);
	}
	
    public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6) 
    {
    	box.render(f6);
    }
}
