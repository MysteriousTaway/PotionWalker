package com.company.alp_minecraftprojekt;

import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class Event implements Listener {
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
//        event.getPlayer().sendMessage(event.getTo().getBlock().getRelative(BlockFace.DOWN).getType().toString().toLowerCase());
        EffectManager.doStuff(event.getPlayer(), Objects.requireNonNull(event.getTo()).getBlock().getRelative(BlockFace.DOWN).getType().toString());
    }
}
