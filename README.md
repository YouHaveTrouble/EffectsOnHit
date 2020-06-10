# EffectsOnHit
Apply potion effects on your foes! On Hit!

Spigot page: https://www.spigotmc.org/resources/effectsonhit.75892/


Via config you can add unlimited amount of item lores, that will apply an effect on a victim of an attack with said item.

What you need to do, is simply make sure that item lore matches the string in the config.
You can have multiple lore lines, plugin will simply scan through them and check if there is a match.

Example:

Line in config: "Slowness"
What will work:
Lore line 1: "Something"
Lore line 2: "Slowness"

What will NOT work:
Lore line 1: "Something Slowness"


You can also have multiple effects on the same item


Example
Line in config: "Slowness"
Line in config: "Poison"

What will work:
Lore line 1: "Poison"
Lore line 2: "Slowness"

Both effects will apply in this case.


Config can be reloaded via /effectsonhitreload command. This requires effectsonhit.reload permission.

You can precise what lore you want to apply the effect, what level of effect should be applied and it's duration in ticks (20 ticks = 1 second), and of course the effect itself. Plugin works with all potion effects.

Plugin should work fine on versions 1.8+
I will NOT add 1.7 and lower support.

If you have any questions, issues or suggestions, leave them in the discussion tab on spigot on the issues tab here.
