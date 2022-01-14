package de.macbrayne.fabric.enforcegamemode.mixin;

import de.macbrayne.fabric.enforcegamemode.GameModePermission;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
	@Unique
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerPlayerEntityMixin.class);

	@Unique
	@Inject(method = "playerTick", at = @At("HEAD"))
	private void forceGamemode$onPlayerTick(CallbackInfo ci) {
		ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

		GameMode gameMode = GameModePermission.getGameModeOrNull(player);
		if (gameMode != null) {
			if(player.changeGameMode(gameMode)) {
				LOGGER.error("Updated {}'s game mode to {}", player.getName().asString(), gameMode.getName());
			}
		}
	}
}
