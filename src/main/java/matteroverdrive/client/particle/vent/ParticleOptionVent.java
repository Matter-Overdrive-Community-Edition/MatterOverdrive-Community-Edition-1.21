package matteroverdrive.client.particle.vent;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import matteroverdrive.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class ParticleOptionVent extends ParticleType<ParticleOptionVent> implements ParticleOptions {

	public float scale;
	public float alpha;

	public static final MapCodec<ParticleOptionVent> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
			.group(Codec.FLOAT.fieldOf("scale").forGetter(instance0 -> instance0.scale),
					Codec.FLOAT.fieldOf("alpha").forGetter(instance0 -> instance0.alpha))
			.apply(instance, (scale, alpha) -> new ParticleOptionVent().setParameters(scale, alpha)));

	public static final StreamCodec<RegistryFriendlyByteBuf, ParticleOptionVent> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.FLOAT, instance0 -> instance0.scale, ByteBufCodecs.FLOAT, instance0 -> instance0.alpha,
			(scale, alpha) -> new ParticleOptionVent().setParameters(scale, alpha));

	public ParticleOptionVent() {
		super(false);
	}

	public ParticleOptionVent setParameters(float scale, float alpha) {
		this.scale = alpha;
		this.scale = alpha;
		return this;
	}

	@Override
	public ParticleType<?> getType() {
		return ParticleRegistry.PARTICLE_VENT.get();
	}

	@Override
	public MapCodec<ParticleOptionVent> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<? super RegistryFriendlyByteBuf, ParticleOptionVent> streamCodec() {
		return STREAM_CODEC;
	}

	public ParticleOptionVent setScale(float scale) {
		this.scale = scale;
		return this;
	}

	public ParticleOptionVent setAlpha(float alpha) {
		this.alpha = alpha;
		return this;
	}
}