package matteroverdrive.client.particle.shockwave;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import matteroverdrive.core.utils.CodecUtils;
import matteroverdrive.registry.ParticleRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class ParticleOptionShockwave extends ParticleType<ParticleOptionShockwave> implements ParticleOptions {
	
	public float maxScale;
	public float gravity;
	public int maxAge;
	public int r;
	public int g;
	public int b;
	public int a;

	public static final MapCodec<ParticleOptionShockwave> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
			.group(Codec.FLOAT.fieldOf("maxScale").forGetter(instance0 -> instance0.maxScale),
					Codec.FLOAT.fieldOf("gravity").forGetter(instance0 -> instance0.gravity),
					Codec.INT.fieldOf("maxage").forGetter(instance0 -> instance0.maxAge),
					Codec.INT.fieldOf("r").forGetter(instance0 -> instance0.r),
					Codec.INT.fieldOf("g").forGetter(instance0 -> instance0.g),
					Codec.INT.fieldOf("b").forGetter(instance0 -> instance0.b),
					Codec.INT.fieldOf("a").forGetter(instance0 -> instance0.a))
			.apply(instance, (maxScale, gravity, age, r, g, b, a) -> new ParticleOptionShockwave().setParameters(maxScale,
					gravity, age, r, g, b, a)));

	public static final StreamCodec<RegistryFriendlyByteBuf, ParticleOptionShockwave> STREAM_CODEC = CodecUtils
			.composite(ByteBufCodecs.FLOAT, instance0 -> instance0.maxScale, ByteBufCodecs.FLOAT,
					instance0 -> instance0.gravity, ByteBufCodecs.INT, instance0 -> instance0.maxAge, ByteBufCodecs.INT,
					instance0 -> instance0.r, ByteBufCodecs.INT, instance0 -> instance0.g, ByteBufCodecs.INT,
					instance0 -> instance0.b, ByteBufCodecs.INT, instance0 -> instance0.a, (maxScale, gravity, age, r, g,
							b, a) -> new ParticleOptionShockwave().setParameters(maxScale, gravity, age, r, g, b, a));

	public ParticleOptionShockwave() {
		super(false);
	}

	public ParticleOptionShockwave setParameters(float maxScale, float gravity, int maxAge, int r, int g, int b, int a) {
		this.maxScale = maxScale;
		this.gravity = gravity;
		this.maxAge = maxAge;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		return this;
	}

	@Override
	public ParticleType<?> getType() {
		return ParticleRegistry.PARTICLE_SHOCKWAVE.get();
	}

	@Override
	public String toString() {
		return BuiltInRegistries.PARTICLE_TYPE.getKey(getType()).toString() + ", maxScale: " + maxScale + ", gravity: "
				+ gravity + ", maxage: " + maxAge + ", r: " + r + ", g: " + g + ", b: " + b + ", a: " + a;
	}

	@Override
	public MapCodec<ParticleOptionShockwave> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<? super RegistryFriendlyByteBuf, ParticleOptionShockwave> streamCodec() {
		return STREAM_CODEC;
	}
}