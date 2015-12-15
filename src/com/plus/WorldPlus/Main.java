package com.plus.WorldPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {
	private HashMap<String, Object> pos1;
	private HashMap<String, Object> pos2;
	private int AxeSelectedPos=1;

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("§e创世神Plus插件加载完成!§b--By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player s = this.getServer().getPlayer(sender.getName());
		if(sender.isOp()){
		switch (command.getName()) {
		case "pos1":
			if (sender instanceof Player) {
				this.pos1 = new HashMap<String, Object>();
				HashMap<String, Object> SenderPosition = new HashMap<>();
				int x = (int)s.getX();
				int y = (int)s.getY();
				int z = (int)s.getZ();
				SenderPosition.put("x", x);
				SenderPosition.put("y", y);
				SenderPosition.put("z", z);
				SenderPosition.put("level", s.getLevel().getName());
				this.pos1.put(sender.getName(), SenderPosition);
				sender.sendMessage("§b点1设定完成(x:"+x+",y:"+y+",z:"+z+")");
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		case "pos2":
			if (sender instanceof Player) {
				if (this.IssetPos(1, sender.getName())) {
					String Pos1Level = (String) this.GetPosInfo(1, sender.getName(), "level");
					if (Pos1Level.equals(s.getLevel().getName())) {
						this.pos2 = new HashMap<String, Object>();
						HashMap<String,Object> SenderPosition = new HashMap<>();
						int x = (int)s.getX();
						int y = (int)s.getY();
						int z = (int)s.getZ();
						SenderPosition.put("x", x);
						SenderPosition.put("y", y);
						SenderPosition.put("z", z);
						SenderPosition.put("level", s.getLevel().getName());
						this.pos2.put(sender.getName(), SenderPosition);
						sender.sendMessage("§b点2设定完成(x:"+x+",y:"+y+",z:"+z+")");
					} else {
						sender.sendMessage("请在[" + Pos1Level + "]世界里使用/pos2");
					}
				} else {
					sender.sendMessage("§b请先设定/pos1");
				}
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		case "set":
			if (sender instanceof Player) {
				if (this.IssetPos(1, sender.getName()) && this.IssetPos(2, sender.getName())) {
					if (args.length == 3) {
						Set cut = new Set(this, sender.getName(), args[0],(args[2].equals("p")?true:false));
						if (args[1].equals("zxc")) {
							cut.n();
						}else if(args[1].equals("dxc")){
							sender.sendMessage("§b将以多线程生成方块!");
							cut.start();
						}
					}
				} else {
					sender.sendMessage("请先设定对角位置,/pos1  /pos2");
				}
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		}
		}
		return true;
	}
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onTouch(PlayerInteractEvent event){
    	Player player = event.getPlayer();
    	if(player.isOp()){
    	if(event.getPlayer().getInventory().getItemInHand().getId() == 258){
    		if (this.AxeSelectedPos == 2) {  			
    			--this.AxeSelectedPos;
				String Pos1Level = (String) this.GetPosInfo(1, player.getName(), "level");
				if (Pos1Level.equals(player.getLevel().getName())) {
					this.pos2 = new HashMap<String, Object>();
					HashMap<String,Object> playerPosition = new HashMap<>();
					int x = (int)player.getX();
					int y = (int)player.getY();
					int z = (int)player.getZ();
					playerPosition.put("x", x);
					playerPosition.put("y", y);
					playerPosition.put("z", z);
					playerPosition.put("level", player.getLevel().getName());
					this.pos2.put(player.getName(), playerPosition);
					player.sendMessage("§b点2设定完成(x:"+x+",y:"+y+",z:"+z+")");
				} else {
					player.sendMessage("请在[" + Pos1Level + "]世界里使用/pos2");
				}
			}else{
				++this.AxeSelectedPos;
	    		this.pos1 = new HashMap<String, Object>();
				HashMap<String, Object> SenderPosition = new HashMap<>();
				int x = (int)player.getX();
				int y = (int)player.getY();
				int z = (int)player.getZ();
				SenderPosition.put("x", x);
				SenderPosition.put("y", y);
				SenderPosition.put("z", z);
				SenderPosition.put("level", player.getLevel().getName());
				this.pos1.put(player.getName(), SenderPosition);
				player.sendMessage("§b点1设定完成(x:"+x+",y:"+y+",z:"+z+")");
	    	}
    	}
    	}
    }
	public boolean IssetPos(int PosNumber, String SenderName) {
		Map<String, Object> m = (PosNumber == 1 ? this.pos1 : this.pos2);
		if (m != null) {
			Map<String, Object> pos = (Map<String, Object>) m.get(SenderName);
			if (pos != null) {
				return true;
			}
		}
		return false;
	}

	public Object GetPosInfo(int PosNumber, String SenderName, String Type) {
		Map<String, Object> m = (PosNumber == 1 ? this.pos1 : this.pos2);
		Map<String, Object> pos = (Map<String, Object>) m.get(SenderName);
		return pos.get(Type);
	}
	public ArrayList<int[]> getSelectedBlocks(String sendername) {
		int p1x = (int) this.GetPosInfo(1, sendername, "x");
		int p1y = (int) this.GetPosInfo(1, sendername, "y");
		int p1z = (int) this.GetPosInfo(1, sendername, "z");
		int p2x = (int) this.GetPosInfo(2, sendername, "x");
		int p2y = (int) this.GetPosInfo(2, sendername, "y");
		int p2z = (int) this.GetPosInfo(2, sendername, "z");
		int startx = Math.min(p1x,p2x);
		int stopx = Math.max(p1x,p2x);
		int startz = Math.min(p1z,p2z);
		int stopz = Math.max(p1z,p2z);
		int starty = Math.min(p1y,p2y);
		int stopy = Math.max(p1y,p2y);
		ArrayList<int[]> SelectedBlocks = new ArrayList<>();
        for(int nstartx=startx;nstartx <= stopx;nstartx++){
        	for(int nstartz=startz;nstartz <= stopz;nstartz++){
        		for(int nstarty=starty;nstarty <= stopy;nstarty++){
        			SelectedBlocks.add(new int[]{nstartx,nstarty,nstartz});
        		}
        	}
        }
        return SelectedBlocks;
	}
}
