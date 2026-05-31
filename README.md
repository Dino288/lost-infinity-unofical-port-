# Lost Infinity unofficial 1.20.1 Forge port

This repository contains an unofficial reconstruction/port scaffold for Lost Infinity Stones targeting Minecraft 1.20.1 and Forge 47.4.10.

The original jar provided for the port was named `lostinfinity-1.16.4.jar`, but its metadata identifies it as a Forge 1.12.2 mod. Because no original source tree was available, this repo keeps the recovered legacy decompile in `legacy-decompiled-src/` and a modern Forge 1.20.1 workspace in `forge-1.20.1-port/`.

## Current state

- Forge 1.20.1 workspace builds successfully.
- Original recovered assets and textures are included in the modern project.
- 831 blocks are registered from recovered blockstates.
- 2,284 items are registered, including block items and generated spawn eggs.
- 4,589 texture files are present under the modern asset namespace.
- 460 entity type IDs are registered with placeholder entity classes.
- 296 spawn egg item models were generated.
- 8 recovered dimension IDs have data-driven dimension scaffolding.
- A dedicated server smoke test reached `Done` with the mod loaded.

## Build

From the Forge workspace:

```powershell
cd forge-1.20.1-port
.\gradlew.bat build
```

The built jar is also copied at the repo root as:

```text
lostinfinity-1.20.1-forge-47.4.10-content-bootstrap.jar
```

## Important limitations

This is a content-registration bootstrap, not a finished gameplay-perfect port. Blocks, items, textures, entity IDs, spawn eggs, and dimension keys are present, but the original AI, bosses, attacks, animations, custom renderers, block entities, GUIs, networking, machines, portal logic, terrain, structures, and dimension worldgen still need deliberate manual 1.20.1 rewrites.

See `MOD_PORT_STATUS.md` for the detailed port status and next engineering steps.
