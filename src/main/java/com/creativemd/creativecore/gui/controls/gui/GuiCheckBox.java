package com.creativemd.creativecore.gui.controls.gui;

import javax.vecmath.Vector4d;

import org.lwjgl.opengl.GL11;

import com.creativemd.creativecore.common.utils.ColorUtils;
import com.creativemd.creativecore.gui.GuiControl;
import com.creativemd.creativecore.gui.GuiRenderHelper;
import com.creativemd.creativecore.gui.client.style.Style;
import com.creativemd.creativecore.gui.event.ControlEvent;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;

public class GuiCheckBox extends GuiControl{
	
	public static final int checkBoxWidth = 7;
	
	public boolean value = false;
	public String title;
	
	public GuiCheckBox(String name, String title, int x, int y, boolean value) {
		super(name, x, y, checkBoxWidth + GuiRenderHelper.instance.getStringWidth(title) + 3, 15);
		this.value = value;
		this.title = title;
	}
	
	public GuiCheckBox(String title, int x, int y, boolean value) {
		this(title, title, x, y, value);
	}
	
	@Override
	protected void renderContent(GuiRenderHelper helper, Style style, int width, int height) {
		int yoffset = 3;
		
		style.getBorder(this).renderStyle(0, yoffset, helper, checkBoxWidth, checkBoxWidth);
		
		style.getBackground(this).renderStyle(1, yoffset+1, helper, checkBoxWidth-2, checkBoxWidth-2);
		
		if(value)
			helper.font.drawString("x", 1, yoffset-1, ColorUtils.WHITE);
		
		helper.font.drawStringWithShadow(title, checkBoxWidth+3, 3, ColorUtils.WHITE);
	}
	
	@Override
	public boolean hasBorder()
	{
		return false;
	}
	
	@Override
	public boolean hasBackground()
	{
		return false;
	}
	
	@Override
	public boolean mousePressed(int posX, int posY, int button){
		playSound(SoundEvents.UI_BUTTON_CLICK);
		this.value = !value;
		return true;
	}
	
}