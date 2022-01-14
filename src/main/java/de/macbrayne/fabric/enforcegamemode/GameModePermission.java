package de.macbrayne.fabric.enforcegamemode;

import com.google.common.collect.ImmutableBiMap;
import de.macbrayne.fabric.enforcegamemode.mixin.WorldAccessor;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public final class GameModePermission {
	public static final String permissionRoot = "enforcegamemode";
	public static final String BYPASS = permissionRoot + ".bypass";
	public static final Map<GameMode, GameModePermission> PERMISSIONS;

	static {
		var tmpMap = new TreeMap<GameMode, GameModePermission>(Comparator.comparing(gameMode -> gameMode.getId()));

		for (GameMode gameMode : GameMode.values()) {
			tmpMap.put(gameMode, new GameModePermission(gameMode));
		}

		PERMISSIONS = ImmutableBiMap.copyOf(tmpMap);
	}

	private final String permission;

	private GameModePermission(final GameMode gameMode) {
		permission = permissionRoot + ".force." + gameMode.getName().toLowerCase();
	}

	private String getPermission() {
		return permission;
	}

	private String getPermission(final Identifier dimensionType) {
		return getPermission() + "." + dimensionType.toString();
	}

	public static GameMode getGameModeOrNull(Entity entity) {
		if(Permissions.check(entity, BYPASS)) {
			return null;
		}
		WorldAccessor worldAccessor = (WorldAccessor) entity.getWorld();
		for(Map.Entry<GameMode, GameModePermission> permission : PERMISSIONS.entrySet()) {
			if(Permissions.check(entity, permission.getValue().getPermission(worldAccessor.getRegistryKey().getValue()))) {
				return permission.getKey();
			}
		}
		for(Map.Entry<GameMode, GameModePermission> permission : PERMISSIONS.entrySet()) {
			if(Permissions.check(entity, permission.getValue().getPermission())) {
				return permission.getKey();
			}
		}

		return null;
	}
}
