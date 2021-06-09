package com.company.alp_minecraftprojekt;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectManager {

    // I have no fucking idea how to call this method:
    public static void doStuff(Player player, String block) {
        int position = GetIndexFromName(block);
        int duration = ConfigManager.Duration[position];
        String effect = ConfigManager.Effect[position];
        if(duration != 0 && effect != null) {
            PotionEffect potionEffect = ConvertPositionToEffect(position, duration);
            AddEffect(player, potionEffect);
        }
    }

    private static PotionEffect ConvertPositionToEffect(int position, int duration) {
        String name = ConfigManager.Effect[position];
        switch (name.toUpperCase()) {
            case("ABSORPTION") -> {
                return new PotionEffect(PotionEffectType.ABSORPTION, duration, 2);
            }
            case("BAD_OMEN") -> {
                return new PotionEffect(PotionEffectType.BAD_OMEN, duration, 2);
            }
            case("BLINDNESS") -> {
                return new PotionEffect(PotionEffectType.BLINDNESS, duration, 2);
            }
            case("CONDUIT_POWER") -> {
                return new PotionEffect(PotionEffectType.CONDUIT_POWER, duration, 2);
            }
            case("CONFUSION") -> {
                return new PotionEffect(PotionEffectType.CONFUSION, duration, 2);
            }
            case("DAMAGE_RESISTANCE") -> {
                return new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 2);
            }
            case("DOLPHINS_GRACE") -> {
                return new PotionEffect(PotionEffectType.DOLPHINS_GRACE, duration, 2);
            }
            case("FAST_DIGGING") -> {
                return new PotionEffect(PotionEffectType.FAST_DIGGING, duration, 2);
            }
            case("FIRE_RESISTANCE") -> {
                return new PotionEffect(PotionEffectType.FIRE_RESISTANCE, duration, 2);
            }
            case("GLOWING") -> {
                return new PotionEffect(PotionEffectType.GLOWING, duration, 2);
            }
            case("HARM") -> {
                return new PotionEffect(PotionEffectType.HARM, duration, 2);
            }
            case("HEAL") -> {
                return new PotionEffect(PotionEffectType.HEAL, duration, 2);
            }
            case("HEALTH_BOOST") -> {
                return new PotionEffect(PotionEffectType.HEALTH_BOOST, duration, 2);
            }
            case("HERO_OF_THE_VILLAGE") -> {
                return new PotionEffect(PotionEffectType.HERO_OF_THE_VILLAGE, duration, 2);
            }
            case("HUNGER") -> {
                return new PotionEffect(PotionEffectType.HUNGER, duration, 2);
            }
            case("INCREASE_DAMAGE") -> {
                return new PotionEffect(PotionEffectType.INCREASE_DAMAGE, duration, 2);
            }
            case("INVISIBILITY") -> {
                return new PotionEffect(PotionEffectType.INVISIBILITY, duration, 2);
            }
            case("JUMP") -> {
                return new PotionEffect(PotionEffectType.JUMP, duration, 2);
            }
            case("LEVITATION") -> {
                return new PotionEffect(PotionEffectType.LEVITATION, duration, 2);
            }
            case("LUCK") -> {
                return new PotionEffect(PotionEffectType.LUCK, duration, 2);
            }
            case("NIGHT_VISION") -> {
                return new PotionEffect(PotionEffectType.NIGHT_VISION, duration, 2);
            }
            case("POISON") -> {
                return new PotionEffect(PotionEffectType.POISON, duration, 2);
            }
            case("REGENERATION") -> {
                return new PotionEffect(PotionEffectType.REGENERATION, duration, 2);
            }
            case("SATURATION") -> {
                return new PotionEffect(PotionEffectType.SATURATION, duration, 2);
            }
            case("SLOW") -> {
                return new PotionEffect(PotionEffectType.SLOW, duration, 2);
            }
            case("SLOW_DIGGING") -> {
                return new PotionEffect(PotionEffectType.SLOW_DIGGING, duration, 2);
            }
            case("SLOW_FALLING") -> {
                return new PotionEffect(PotionEffectType.SLOW_FALLING, duration, 2);
            }
            case("SPEED") -> {
                return new PotionEffect(PotionEffectType.SPEED, duration, 2);
            }
            case("UNLUCK") -> {
                return new PotionEffect(PotionEffectType.UNLUCK, duration, 2);
            }
            case("WATER_BREATHING") -> {
                return new PotionEffect(PotionEffectType.WATER_BREATHING, duration, 2);
            }
            case("WEAKNESS") -> {
                return new PotionEffect(PotionEffectType.WEAKNESS, duration, 2);
            }
            case("WITHER") -> {
                return new PotionEffect(PotionEffectType.WITHER, duration, 2);
            }
            default -> {
                Bukkit.getLogger().warning("INVALID POTION EFFECT!: " + name);
            }
        }
        return null;
    }

    private static int GetIndexFromName(String block) {
        int position = 0;
        for(String name : ConfigManager.Item) {
            if (name.equalsIgnoreCase(block)) {
                return position;
            }
            position++;
        }
        return 0;
    }

    private static void AddEffect(Player player, PotionEffect effect) {
        player.addPotionEffect(effect);
    }
}
