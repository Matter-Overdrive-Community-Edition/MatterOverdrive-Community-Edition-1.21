package matteroverdrive.core.event.handler.server;

import net.minecraft.server.MinecraftServer;
import net.neoforged.neoforge.event.TickEvent.Phase;

public abstract class AbstractServerTickHandler {

	public AbstractServerTickHandler() {

	}

	public abstract void handleTick(MinecraftServer server, Phase phase, boolean enoughTime);

}
