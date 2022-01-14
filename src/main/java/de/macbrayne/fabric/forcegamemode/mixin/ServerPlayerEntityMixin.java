package de.macbrayne.fabric.forcegamemode.mixin;

import de.macbrayne.fabric.forcegamemode.GameModePermission;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
	@Inject(method = "playerTick", at = @At("HEAD"))
	private void onPlayerTick(CallbackInfo ci) {
		ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
		for(GameModePermission permission : GameModePermission.PERMISSIONS.values()) {
			if(permission.check(player)) {
				player.changeGameMode(permission.getGameMode());
			}
		}
	}
}
