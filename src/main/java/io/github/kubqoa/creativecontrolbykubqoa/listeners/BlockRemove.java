package io.github.kubqoa.creativecontrolbykubqoa.listeners;

import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeBlock;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockRemove implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(BlockBreakEvent event) {
        CreativeBlock block = new CreativeBlock(event.getBlock());
        if (!block.isCreative()) return;
        block.remove();
        if (!event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) return;
        block.physicalRemove();
        event.getPlayer().sendMessage("no drops from creative blocks");
    }
}
