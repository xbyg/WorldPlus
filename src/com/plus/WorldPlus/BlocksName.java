package com.plus.WorldPlus;

import cn.nukkit.block.AcaciaWoodStairs;
import cn.nukkit.block.Air;
import cn.nukkit.block.Bedrock;
import cn.nukkit.block.BirchWoodStairs;
import cn.nukkit.block.Block;
import cn.nukkit.block.Bookshelf;
import cn.nukkit.block.BrickStairs;
import cn.nukkit.block.Bricks;
import cn.nukkit.block.BrownMushroom;
import cn.nukkit.block.BurningFurnace;
import cn.nukkit.block.Cactus;
import cn.nukkit.block.Clay;
import cn.nukkit.block.CoalOre;
import cn.nukkit.block.Cobblestone;
import cn.nukkit.block.CobblestoneStairs;
import cn.nukkit.block.DarkOakWoodStairs;
import cn.nukkit.block.Diamond;
import cn.nukkit.block.DiamondOre;
import cn.nukkit.block.Dirt;
import cn.nukkit.block.DoubleSlab;
import cn.nukkit.block.EmeraldOre;
import cn.nukkit.block.EndStone;
import cn.nukkit.block.Farmland;
import cn.nukkit.block.Furnace;
import cn.nukkit.block.Glass;
import cn.nukkit.block.GlassPane;
import cn.nukkit.block.GlowingObsidian;
import cn.nukkit.block.Glowstone;
import cn.nukkit.block.Gold;
import cn.nukkit.block.GoldOre;
import cn.nukkit.block.Grass;
import cn.nukkit.block.GrassPath;
import cn.nukkit.block.Gravel;
import cn.nukkit.block.HardenedClay;
import cn.nukkit.block.HayBale;
import cn.nukkit.block.Ice;
import cn.nukkit.block.Iron;
import cn.nukkit.block.IronBars;
import cn.nukkit.block.IronOre;
import cn.nukkit.block.JungleWoodStairs;
import cn.nukkit.block.Lapis;
import cn.nukkit.block.LapisOre;
import cn.nukkit.block.Lava;
import cn.nukkit.block.Leaves;
import cn.nukkit.block.MossStone;
import cn.nukkit.block.Obsidian;
import cn.nukkit.block.Planks;
import cn.nukkit.block.Podzol;
import cn.nukkit.block.Pumpkin;
import cn.nukkit.block.Quartz;
import cn.nukkit.block.QuartzStairs;
import cn.nukkit.block.RedstoneOre;
import cn.nukkit.block.Sandstone;
import cn.nukkit.block.SandstoneStairs;
import cn.nukkit.block.Slab;
import cn.nukkit.block.Sponge;
import cn.nukkit.block.SpruceWoodStairs;
import cn.nukkit.block.StainedClay;
import cn.nukkit.block.StillLava;
import cn.nukkit.block.StillWater;
import cn.nukkit.block.Stone;
import cn.nukkit.block.StoneBricks;
import cn.nukkit.block.Stonecutter;
import cn.nukkit.block.TNT;
import cn.nukkit.block.Water;
import cn.nukkit.block.Wood;
import cn.nukkit.block.WoodStairs;
import cn.nukkit.block.Wool;
import cn.nukkit.block.NetherBrick;
import cn.nukkit.block.NetherBrickStairs;
/*
 * 作者:plus
 * 下面的全部东西都是一手写的...累死了...不停的查英文找方块..QAQ
 */
public class BlocksName {
   public Block Block(String BlockId){
	   switch(BlockId){
	      case "0":
	    	  return new Air();
	      case "1":
	    	  return new Stone();
	      case "2":
	          return new Grass(0);
	      case "3":
	    	  return new Dirt();
	      case "4":
	    	  return new Cobblestone();
	      case "5":
	    	  return new Planks(0);
	      case "7":
	    	  return new Bedrock();
	      case "8":
	    	  return new Water();
	      case "9":
	    	  return new StillWater();
	      case "10":
	    	  return new Lava();
	      case "11":
	    	  return new StillLava();
	      //case "12":
	      //  return null;
	      case "13":
	    	  return new Gravel();
	      case "14":
	    	  return new GoldOre();
	      case "15":
	    	  return new IronOre();
	      case "16":
	    	  return new CoalOre();
	      case "17":
	    	  return new Wood();
	      case "18":
	    	  return new Leaves();
	      case "19":
	    	  return new Sponge();
	      case "20":
	    	  return new Glass();
	      case "21":
	    	  return new LapisOre();
	      case "22":
	        return new Lapis();
	      case "24":
	    	  return new Sandstone();
	      //case "25":
	      //  return null;
	      case "35":
	    	  return new Wool();
	      case "41":
	    	  return new Gold();
	      case "42":
	    	  return new Iron();
	      case "43":
	    	  return new DoubleSlab(0);
	      case "45":
	    	  return new Bricks();
	      case "46":
	    	  return new TNT();
	      case "47":
	    	  return new Bookshelf();
	      case "48":
	    	  return new MossStone();
	      case "49":	  
	    	  return new Obsidian();
	      case "53":
	    	  return new WoodStairs(0);
	      case "56":
	    	  return new DiamondOre();
	      case "57":
	    	  return new Diamond();
	      //case "58":
	      //  return new crafting table
	      case "60":
	    	  return new Farmland();
	      case "61":
	    	  return new Furnace();
	      case "62":
	    	  return new BurningFurnace();
	      case "67":
	    	  return new CobblestoneStairs();
	      case "73":
	    	  return new RedstoneOre();
	      case "74":
	    	  return new RedstoneOre();
	      case "79":
	    	  return new Ice();
	      //case "80":
	      //  return new snow
	      case "81":
	    	  return new Cactus();
	      case "82":
	    	  return new Clay();
	      case "86":
	    	  return new Pumpkin();
	      case "87":
	    	  return new NetherBrick();
	      //case "88":
	      //  return new soul sand
	      case "89":
	    	  return new Glowstone();
	      //case "91":
	      // return new 
	      case "98":
	    	  return new StoneBricks();
	      case "99":
	    	  return new BrownMushroom();
	      case "100":
	    	  return new BrownMushroom(); //red
	      case "101":
	    	  return new IronBars();
	      case "102":
	    	  return new GlassPane();
	      //case "103":
	      //  return new Melons
	      case "108":
	    	  return new BrickStairs();
	      case "109":
	    	  return new Stone();
	      //case "110":
	      //  return new Mycelium
	      case "112":
	    	  return new NetherBrick();
	      case "114":
	    	  return new NetherBrickStairs();
	      case "121":
	    	  return new EndStone();
	      //case "122":
	      //  return new redstonelamp
	      case "128":
	    	  return new SandstoneStairs();
	      case "129":
	    	  return new EmeraldOre();
	      case "133":
	    	  return new EmeraldOre();
	      case "134":
	    	  return new SpruceWoodStairs();
	      case "135":
	    	  return new BirchWoodStairs();
	      case "136":
	    	  return new JungleWoodStairs();
	      case "152":
	    	  return new RedstoneOre();
	      //case "153":
	      //  return new NetherQuartzOre
	      case "155":
	    	  return new Quartz();
	      case "156":
	          return new QuartzStairs();
	      case "157":
	    	  return new DoubleSlab();
	      case "158":
	    	  return new Slab();
	      case "159":
	    	  return new StainedClay();
	      //case "161":
	      //  return new acacia leaves
	      case "162":
	    	  return new Wood(4); //acacia wood
	      case "163":
	    	  return new AcaciaWoodStairs();
	      case "164":
	    	  return new DarkOakWoodStairs();
	      case "170":
	    	  return new HayBale();
	      case "172":
	    	  return new HardenedClay();
	      case "173":
	    	  return new CoalOre();
	      //case "174":
	      //  return new Packed Ice
	      case "198":
	    	  return new GrassPath();
	      case "243":
	    	  return new Podzol();
	      case "245":
	    	  return new Stonecutter();
	      case "246":
	    	  return new GlowingObsidian();
	      //case "247":
	      //  return new Nether Reactor Core
	   }
	   return null;
   }
}
