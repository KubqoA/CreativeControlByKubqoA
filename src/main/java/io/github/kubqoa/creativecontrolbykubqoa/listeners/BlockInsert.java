package io.github.kubqoa.creativecontrolbykubqoa.listeners;

import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeBlock;
import org.bukkit.GameMode;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockInsert implements Listener {
    @EventHandler (priority = EventPriority.MONITOR)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        new CreativeBlock(event.getBlock()).insert();
    }

    @EventHandler (priority = EventPriority.MONITOR)
    public void onBlockMultiplePlace(BlockMultiPlaceEvent event) {
        if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        for (BlockState replacedBlockState : event.getReplacedBlockStates()) {
            if (!replacedBlockState.equals(event.getBlockReplacedState())) {
                new CreativeBlock(event.getBlock()).insert();
            }
        }
    }
}
