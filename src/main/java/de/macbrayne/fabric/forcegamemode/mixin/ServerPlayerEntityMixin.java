package de.macbrayne.fabric.forcegamemode.mixin;

import de.macbrayne.fabric.forcegamemode.GameModePermission;
import net.minecraft.server.network.ServerPlayerEntity;
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
	private static final Logger LOGGER = LoggerFactory.getLogger("ForceGamemode");

	@Unique
	@Inject(method = "playerTick", at = @At("HEAD"))
	private void forceGamemode$onPlayerTick(CallbackInfo ci) {
		ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;

		for (var entry : GameModePermission.PERMISSIONS.entrySet()) {
			GameModePermission permission = entry.getValue();
			if (permission.check(player)) {
				if(player.changeGameMode(entry.getKey())) {
					LOGGER.debug("Updated {}'s game mode to {} due to {}", player.getName().asString(), entry.getKey().getName(), permission.getPermission());
				}
				break;
			}
		}
	}
}
