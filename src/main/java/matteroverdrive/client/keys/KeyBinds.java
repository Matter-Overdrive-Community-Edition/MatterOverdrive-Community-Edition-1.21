package matteroverdrive.client.keys;

import com.mojang.blaze3d.platform.InputConstants;

import matteroverdrive.References;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class KeyBinds {

	// Category
	private static final String CATEGORY_MAIN = "keycategory.matteroverdrive.main";

	// KEYS
	public static final KeyMapping TOGGLE_MATTER_SCANNER = registerKey("togglematterscanner", CATEGORY_MAIN,
			InputConstants.KEY_O);

	private KeyBinds() {
	}

	private static KeyMapping registerKey(String name, String category, int keyCode) {
		return new KeyMapping("key." + References.ID + "." + name, keyCode, category);
	}

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		event.register(TOGGLE_MATTER_SCANNER);
	}

}
