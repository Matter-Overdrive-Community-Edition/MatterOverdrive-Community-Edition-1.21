package matteroverdrive.compatibility.jei.utils.gui.arrows.animated;

import matteroverdrive.compatibility.jei.utils.gui.arrows.stat.ArrowRightBigStaticWrapper;
import mezz.jei.api.gui.drawable.IDrawableAnimated.StartDirection;

public class ArrowRightBigAnimatedWrapper extends ArrowAnimatedWrapper {

	public ArrowRightBigAnimatedWrapper(int xStart, int yStart) {
		super(JeiTexture.PROGRESS_BARS, xStart, yStart, 0, 59, 64, 15, new ArrowRightBigStaticWrapper(xStart, yStart));
	}

	@Override
	public StartDirection getStartDirection() {
		return StartDirection.LEFT;
	}

}
