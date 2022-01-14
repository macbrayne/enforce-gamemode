package de.macbrayne.fabric.forcegamemode;

import com.google.common.collect.ImmutableBiMap;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameMode;

import java.util.*;

public final class GameModePermission {
	public static final String permissionRoot = "forcegamemode";
	public final String BYPASS = permissionRoot + ".bypass";
	public static final Map<GameMode, GameModePermission> PERMISSIONS;

	static {
		var tmpMap = new TreeMap<GameMode, GameModePermission>(Comparator.comparing(gameMode -> gameMode.getId()));

		for (GameMode gameMode : GameMode.values()) {
			tmpMap.put(gameMode, new GameModePermission(gameMode));
		}

		PERMISSIONS = ImmutableBiMap.copyOf(tmpMap);
	}

	private final String permission;

	public GameModePermission(GameMode gameMode) {
		permission = permissionRoot + ".force." + gameMode.getName().toLowerCase();
	}

	public String getPermission() {
		return permission;
	}

	public boolean check(Entity entity) {
		return Permissions.check(entity, getPermission()) && !Permissions.check(entity, BYPASS);
	}
}
