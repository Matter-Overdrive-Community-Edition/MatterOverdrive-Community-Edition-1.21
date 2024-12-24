package matteroverdrive.core.event.handler.client;

import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent.Stage;

public abstract class AbstractRenderLevelStageHandler {

	public abstract boolean shouldRender(Stage stage);

	public abstract void render(Camera camera, Frustum frustum, LevelRenderer renderer, PoseStack stack, Matrix4f projectionMatrix, Minecraft minecraft, int renderTick, DeltaTracker deltaTracker);

	public void clear() {

	}
}