package com.zeekofox.tectocraft;

import org.apache.logging.log4j.Level;

import com.zeekofox.tectocraft.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_WORLDGEN = "worldGen";

    public static boolean generateTungstenInOverworld = true;
    public static boolean generateTungstenInNether = true;
    public static boolean generateTungstenInEnd = true;
    public static boolean generateTungstenInNonVanillaDimensions = true;
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initOreConfig(cfg);
        } catch (Exception e1) {
            Tectocraft.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initOreConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WORLDGEN, "World generation configuration");
        generateTungstenInOverworld = cfg.getBoolean("createTungstenOverworld", CATEGORY_WORLDGEN, generateTungstenInOverworld, "Generate Tungsten Ore in the Overworld");
        generateTungstenInNether = cfg.getBoolean("createTungstenNether", CATEGORY_WORLDGEN, generateTungstenInNether, "Generate Tungsten Ore in the Nether");
        generateTungstenInEnd = cfg.getBoolean("createTungstenEnd", CATEGORY_WORLDGEN, generateTungstenInEnd, "Generate Tungsten Ore in the End");
        generateTungstenInNonVanillaDimensions = cfg.getBoolean("createTungstenModDims", CATEGORY_WORLDGEN, generateTungstenInNonVanillaDimensions, "Generate Tungsten Ore in Modded Dimensions");

    }
}

