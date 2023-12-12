# SimpleWorldDefender
My first Minecraft plugin! It helps you prevent players from breaking and placing blocks!

## Example config.yml

```yaml
disabled:
  placing-blocks:
    - "world"
  breaking-blocks:
    - "world_nether"
    - "world"
```

In this `config.yml` example, players in gamemode survival can't place and break blocks on a world named `world`. And a world named `world_nether`.
