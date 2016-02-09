package commands.fiberone;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;

import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
@Mod(modid=Fiberone.MODID, name=Fiberone.MODNAME, version=Fiberone.MODVER)
public class Fiberone {
	public static final String MODID = "fiberone";
	public static final String MODNAME = "Extra Commands Mod";
	public static final String MODVER = "0.2";
	@Instance(value= Fiberone.MODID)
	public static Fiberone instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new RandPass());
	}
}