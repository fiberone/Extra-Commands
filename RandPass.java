package commands.fiberone;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.command.CommandHelp;
public class RandPass implements ICommand {
	private final List aliases;
	static final String[] mobspassive = {"Chicken", "Cow", "Bat", "Pig", "Sheep", "MushroomCow", "Squid", "SnowMan", "Wolf", "Ozelot", "VillagerGolem", "ThrownExpBottle", "EntityHorse"};
	static final String[] mobshostile = {"Creeper","Giant", "Skeleton", "Spider", "Zombie", "Slime", "LavaSlime", "Ghast", "PigZombie", "Enderman", "Blaze", "Silverfish", "Witch", "CaveSpider"};
	protected String fullEntityName;
	protected Entity conjuredEntity;
	
	public RandPass()
	{
		aliases = new ArrayList();
		aliases.add("randmob");
		aliases.add("randmob");
		aliases.add("rmb");
	}

	@Override
	public String getCommandName() {
		return "randommob";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "commands.fiberone.RandPass";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] astring) {
		World world = sender.getEntityWorld();
		if (world.isRemote)
		{
			System.out.println("not processing on client");
		}
		else
		{
			if(astring.length == 0) {
				sender.addChatMessage(new ChatComponentText("Invalid Arguments, use /randommob passive or hostile"));
			}
			else{
					if (astring[0].equals(new String("passive"))) {
						
						System.out.println("executing on server side");
						Random random = new Random();
						int index = random.nextInt(mobspassive.length);
						conjuredEntity = EntityList.createEntityByName(mobspassive[index] , world);
						conjuredEntity.setPosition(sender.getPlayerCoordinates().posX, sender.getPlayerCoordinates().posY, sender.getPlayerCoordinates().posZ);
						world.spawnEntityInWorld(conjuredEntity);
						sender.addChatMessage(new ChatComponentText("Spawned in a " + mobspassive[index] + "."));
					}
					else if (astring[0].equals(new String("hostile"))) {
						System.out.println("executing on server side");
						Random random = new Random();
						int index = random.nextInt(mobshostile.length);
						conjuredEntity = EntityList.createEntityByName(mobshostile[index] , world);
						conjuredEntity.setPosition(sender.getPlayerCoordinates().posX, sender.getPlayerCoordinates().posY, sender.getPlayerCoordinates().posZ);
						world.spawnEntityInWorld(conjuredEntity);
						sender.addChatMessage(new ChatComponentText("Spawned in a " + mobshostile[index] + "."));
					}
					else {
						sender.addChatMessage(new ChatComponentText(astring[0]+ " : report to mod developer"));
					}
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
