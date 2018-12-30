# CreativeControl

[![Build Status](https://img.shields.io/travis/KubqoA/CreativeControlByKubqoA.svg)](https://travis-ci.org/KubqoA/CreativeControlByKubqoA)

## Work in progress!

This is a complete ground-up rewrite of the plugin, which aims to increase performance. The goal is to move the majority of database calls to asynchronous calls to not bother the server with database calls in the main thread. The main idea so far is to load chunks from database as they load in game. So when a chunk in a game gets loaded, the plugin should load all it's creative blocks into the memory for fast access. When the chunk unloads all it's blocks will unload with it. Performance-wise this model should be fairly efficient, as none (or very minimum) operations with blocks should happen in unloaded chunks. The only problem might be with memory.

The main focus for now is to get the block loading and writing optimised and then work on additional features will begin.

## Security

If you discover any security related issues, please email jakub.arbet@protonmail.com instead of using the issue tracker.

## Credits

- [Jakub Arbet](https://github.com/KubqoA)

## License

The GNU GPLv3 (GNU General Public License v3.0). Please see [License File](LICENSE.md) for more information.
