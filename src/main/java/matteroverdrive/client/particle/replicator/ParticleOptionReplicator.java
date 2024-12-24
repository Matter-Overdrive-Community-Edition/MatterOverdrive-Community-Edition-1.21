package matteroverdrive.client.particle.replicator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import matteroverdrive.core.utils.CodecUtils;
import matteroverdrive.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

public class ParticleOptionReplicator extends ParticleType<ParticleOptionReplicator> implements ParticleOptions {

	public float gravity;
	public float scale;
	public int maxAge;
	public int r;
	public int g;
	public int b;
	public int a;

	public static final MapCodec<ParticleOptionReplicator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
			.group(Codec.FLOAT.fieldOf("scale").forGetter(instance0 -> instance0.scale),
					Codec.FLOAT.fieldOf("gravity").forGetter(instance0 -> instance0.gravity),
					Codec.INT.fieldOf("maxage").forGetter(instance0 -> instance0.maxAge),
					Codec.INT.fieldOf("r").forGetter(instance0 -> instance0.r),
					Codec.INT.fieldOf("g").forGetter(instance0 -> instance0.g),
					Codec.INT.fieldOf("b").forGetter(instance0 -> instance0.b),
					Codec.INT.fieldOf("a").forGetter(instance0 -> instance0.a))
			.apply(instance, (scale, gravity, age, r, g, b, a) -> new ParticleOptionReplicator().setParameters(scale,
					gravity, age, r, g, b, a)));

	public static final StreamCodec<RegistryFriendlyByteBuf, ParticleOptionReplicator> STREAM_CODEC = CodecUtils
			.composite(ByteBufCodecs.FLOAT, instance0 -> instance0.scale, ByteBufCodecs.FLOAT,
					instance0 -> instance0.gravity, ByteBufCodecs.INT, instance0 -> instance0.maxAge, ByteBufCodecs.INT,
					instance0 -> instance0.r, ByteBufCodecs.INT, instance0 -> instance0.g, ByteBufCodecs.INT,
					instance0 -> instance0.b, ByteBufCodecs.INT, instance0 -> instance0.a, (scale, gravity, age, r, g,
							b, a) -> new ParticleOptionReplicator().setParameters(scale, gravity, age, r, g, b, a));

	public ParticleOptionReplicator() {
		super(false);
	}

	public ParticleOptionReplicator setParameters(float scale, float gravity, int maxAge, Integer r2, Integer g2,
			Integer b2, Integer a2) {
		this.scale = scale;
		this.gravity = gravity;
		this.maxAge = maxAge;
		return this;
	}

	@Override
	public ParticleType<?> getType() {
		return ParticleRegistry.PARTICLE_REPLICATOR.get();
	}

	@Override
	public String toString() {
		return BuiltInRegistries.PARTICLE_TYPE.getKey(getType()).toString() + ", scale: " + scale + ", gravity: "
				+ gravity + ", maxage: " + maxAge + ", r: " + r + ", g: " + g + ", b: " + b + ", a: " + a;
	}

	@Override
	public MapCodec<ParticleOptionReplicator> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<? super RegistryFriendlyByteBuf, ParticleOptionReplicator> streamCodec() {
		return STREAM_CODEC;
	}
}
