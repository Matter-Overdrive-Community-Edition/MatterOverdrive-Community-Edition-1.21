package matteroverdrive.registry;

import matteroverdrive.References;
import matteroverdrive.client.particle.replicator.ParticleOptionReplicator;
import matteroverdrive.client.particle.shockwave.ParticleOptionShockwave;
import matteroverdrive.client.particle.vent.ParticleOptionVent;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleRegistry {

	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, References.ID);

	public static final DeferredHolder<ParticleType<?>, ParticleOptionReplicator> PARTICLE_REPLICATOR = PARTICLES.register("replicator", ParticleOptionReplicator::new);
	public static final DeferredHolder<ParticleType<?>, ParticleOptionShockwave> PARTICLE_SHOCKWAVE = PARTICLES.register("shockwave", ParticleOptionShockwave::new);
	public static final DeferredHolder<ParticleType<?>, ParticleOptionVent> PARTICLE_VENT = PARTICLES.register("vent", ParticleOptionVent::new);
}
