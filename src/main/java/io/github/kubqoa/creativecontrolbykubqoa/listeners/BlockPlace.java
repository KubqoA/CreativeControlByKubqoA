package io.github.kubqoa.creativecontrolbykubqoa.listeners;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    @EventHandler (priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        CreativeControlByKubqoA.database.database.blockStore(event.getBlock());
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onBlockMultiplePlace(BlockMultiPlaceEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        for (BlockState replacedBlockState : event.getReplacedBlockStates()) {
            if (!replacedBlockState.equals(event.getBlockReplacedState())) {
                CreativeControlByKubqoA.database.database.blockStore(replacedBlockState.getBlock());
            }
        }
    }
}
