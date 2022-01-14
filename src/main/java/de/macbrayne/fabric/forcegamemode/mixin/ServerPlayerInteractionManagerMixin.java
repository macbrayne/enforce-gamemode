package de.macbrayne.fabric.forcegamemode.mixin;

import de.macbrayne.fabric.forcegamemode.GameModePermission;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.world.GameMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {
	@Unique
	private static final Logger LOGGER = LoggerFactory.getLogger("ForceGamemode");

	@Final
	@Shadow
	protected ServerPlayerEntity player;

	@Inject(method = "setGameMode", at = @At("HEAD"), cancellable = true)
	private void forceGamemode$setGameMode(GameMode gameMode, GameMode previousGameMode, CallbackInfo ci) {
		if (GameModePermission.PERMISSIONS.get(gameMode).check(player, ((WorldAccessor) player.getWorld()).getRegistryKey().getValue())) {
			ci.cancel();
			LOGGER.info("Stopped {} from changing game mode from {} to {} due to {}", player.getName().asString(),
					previousGameMode.getName(), gameMode.getName(), GameModePermission.PERMISSIONS.get(gameMode).getPermission());
		}
	}
}
