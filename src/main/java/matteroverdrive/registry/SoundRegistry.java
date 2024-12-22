package matteroverdrive.registry;

import matteroverdrive.References;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundRegistry {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, References.ID);

	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_CRATE_OPEN = sound("crate_open");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_CRATE_CLOSE = sound("crate_close");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_DECOMPOSER = sound("matter_decomposer");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MACHINE = sound("machine");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MACHINE_ELECTRIC = sound("machine_electric");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_TRANSPORTER = sound("transporter");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_TRANSPORTER_ARRIVE = sound("transporter_arrive");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_REPLICATOR = sound("matter_replicator");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_ANALYZER = sound("matter_analyzer");

	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BUTTON_EXPAND = sound("button_expand");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BUTTON_SOFT0 = sound("button_soft0");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BUTTON_SOFT1 = sound("button_soft1");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BUTTON_LOUD3 = sound("button_loud3");

	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_SCANNER_RUNNING = sound("matter_scanner_running");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_SCANNER_BEEP = sound("matter_scanner_beep");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_SCANNER_FAIL = sound("matter_scanner_fail");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_MATTER_SCANNER_SUCCESS = sound("matter_scanner_success");
	
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_COMMUNICATOR_SUCCESS = sound("communicator_success");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_COMMUNICATOR_FAIL = sound("communicator_fail");

	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_ELECTRIC_ARC_0 = sound("electric_arc_0");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_ELECTRIC_ARC_1 = sound("electric_arc_1");
	
	public static final DeferredHolder<SoundEvent, SoundEvent> KUNAI_THUD = sound("kunai_thud");
	public static final DeferredHolder<SoundEvent, SoundEvent> ANDROID_TELEPORT = sound("android_teleport");
	public static final DeferredHolder<SoundEvent, SoundEvent> GLITCH = sound("gui.glitch");
	public static final DeferredHolder<SoundEvent, SoundEvent> PERK_UNLOCK = sound("perk_unlock");
	public static final DeferredHolder<SoundEvent, SoundEvent> NIGHT_VISION = sound("night_vision");

	private static DeferredHolder<SoundEvent, SoundEvent> sound(String name) {
		return SOUNDS.register(name, () -> SoundEvent.createFixedRangeEvent(ResourceLocation.tryParse(References.ID + ":" + name), 16.0F));
	}

}
