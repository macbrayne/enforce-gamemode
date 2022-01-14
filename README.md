# Enforce Gamemode
<a href="https://modrinth.com/mod/enforce-gamemode"><img src="https://modrinth-utils.vercel.app/api/badge/versions?id=F39sgYmY&logo=true" alt="Supported Versions"></a>
<a href="https://modrinth.com/mod/enforce-gamemode"><img src="https://img.shields.io/badge/dynamic/json?color=5da545&label=modrinth&suffix=%20downloads&query=downloads&url=https://api.modrinth.com/api/v1/mod/F39sgYmY&style=flat&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMSAxMSIgd2lkdGg9IjE0LjY2NyIgaGVpZ2h0PSIxNC42NjciICB4bWxuczp2PSJodHRwczovL3ZlY3RhLmlvL25hbm8iPjxkZWZzPjxjbGlwUGF0aCBpZD0iQSI+PHBhdGggZD0iTTAgMGgxMXYxMUgweiIvPjwvY2xpcFBhdGg+PC9kZWZzPjxnIGNsaXAtcGF0aD0idXJsKCNBKSI+PHBhdGggZD0iTTEuMzA5IDcuODU3YTQuNjQgNC42NCAwIDAgMS0uNDYxLTEuMDYzSDBDLjU5MSA5LjIwNiAyLjc5NiAxMSA1LjQyMiAxMWMxLjk4MSAwIDMuNzIyLTEuMDIgNC43MTEtMi41NTZoMGwtLjc1LS4zNDVjLS44NTQgMS4yNjEtMi4zMSAyLjA5Mi0zLjk2MSAyLjA5MmE0Ljc4IDQuNzggMCAwIDEtMy4wMDUtMS4wNTVsMS44MDktMS40NzQuOTg0Ljg0NyAxLjkwNS0xLjAwM0w4LjE3NCA1LjgybC0uMzg0LS43ODYtMS4xMTYuNjM1LS41MTYuNjk0LS42MjYuMjM2LS44NzMtLjM4N2gwbC0uMjEzLS45MS4zNTUtLjU2Ljc4Ny0uMzcuODQ1LS45NTktLjcwMi0uNTEtMS44NzQuNzEzLTEuMzYyIDEuNjUxLjY0NSAxLjA5OC0xLjgzMSAxLjQ5MnptOS42MTQtMS40NEE1LjQ0IDUuNDQgMCAwIDAgMTEgNS41QzExIDIuNDY0IDguNTAxIDAgNS40MjIgMCAyLjc5NiAwIC41OTEgMS43OTQgMCA0LjIwNmguODQ4QzEuNDE5IDIuMjQ1IDMuMjUyLjgwOSA1LjQyMi44MDljMi42MjYgMCA0Ljc1OCAyLjEwMiA0Ljc1OCA0LjY5MSAwIC4xOS0uMDEyLjM3Ni0uMDM0LjU2bC43NzcuMzU3aDB6IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiM1ZGE0MjYiLz48L2c+PC9zdmc+" alt="Modrinth Download Count"></a>
<a href="https://www.curseforge.com/minecraft/mc-mods/enforce-gamemode"><img src="http://cf.way2muchnoise.eu/full_495153_downloads(E04E14-555-fff-010101-1C1C1C).svg" alt="CurseForge Download Count"></a>
<a href="https://github.com/macbrayne/enforce-gamemode"><img src="https://img.shields.io/badge/side-client--only-5da545" alt="Side: Client-Only"></a>
<a href="https://github.com/macbrayne/enforce-gamemode/blob/main/LICENSE.md"><img src="https://img.shields.io/github/license/macbrayne/enforce-gamemode?style=flat&color=0C8E8E" alt="License"></a>
---
## Enables server owners to enforce your players' game mode using permissions.

This mod is __server-side only__ and won't be active in LAN worlds or on clients.

Current versions:
- 1.18.1: 0.1

## [Releases](https://github.com/macbrayne/enforce-gamemode/releases)

The mod is licensed under the [MIT License](LICENSE)

## Permissions

The order the mod checks for the applicable game mode is from top to bottom.
That means if a player has both ``enforcegamemode.force.survival`` and ``enforcegamemode.force.creative`` set
they'll be put into survival mode.

- ``enforcegamemode.bypass``: Bypass forced game mode changes
- ``enforcegamemode.force.survival``: Enforce game mode survival (id 0)
- ``enforcegamemode.force.creative``: Enforce game mode creative (id 1)
- ``enforcegamemode.force.adventure``: Enforce game mode adventure (id 2)
- ``enforcegamemode.force.spectator``: Enforce game mode spectator (id 3)

You can also set dimension specific game mode enforcements by adding ``.namespace:dimension`` to the permissons.
Note that these do _not_ overwrite the order above.

Example: if you wanted to enforce adventure mode in the end the syntax would be:
``enforcegamemode.force.adventure.minecraft:the_end``