## List of all relevant chunk events

* ChunkLoadEvent
* ChunkUnloadEvent

## How to handle insert, update and remove
All changes should happen on the CreativeChunk object and should be written when this object gets unloaded.
This means all changes should be done in memory and only when the chunk is no longer needed they will get persisted in the database.
This ensures that there won't be many small writes to the database, instead there will be mass inserts.

## List of all relevant block events
All the block events that need to be handled in order to prevent any creative - survival interaction.

### Insert events
* BlockFertilizeEvent
* BlockMultiPlaceEvent
* BlockPlaceEvent

### Update events
* BlockFromToEvent
* BlockPistonExtendEvent
* BlockPistonRetractsEvent

### Remove events
* BlockBreakEvent
* BlockBurnEvent
* BlockExplodeEvent
* BlockFadeEvent
* LeavesDecayEvent