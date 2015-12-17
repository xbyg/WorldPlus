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
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener {
	private HashMap<String, Object> pos1;
	private HashMap<String, Object> pos2;
	private HashMap<String, String> AxeSelectedPos = new HashMap<>();
	protected HashMap<String,ArrayList<HashMap<String,Object>>> CopiedOrCutBlocks = new HashMap<>();

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("§e创世神Plus(v1.5)插件加载完成!§b--By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)");
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
					String Pos1Level = (String) this.GetPosInfo(1, sender.getName()).get("level");
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
						sender.sendMessage("§c请在[" + Pos1Level + "]世界里使用/pos2");
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
					if (args.length == 2) {
						Set set = new Set(this, sender.getName(), args[0]);
						if (args[1].equals("zxc")) {
							set.n();
						}else if(args[1].equals("dxc")){
							set.start();
						}
					}
				} else {
					sender.sendMessage("§b请先设定对角位置,/pos1  /pos2");
				}
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		case "cut":
			if (sender instanceof Player) {
				if (this.IssetPos(1, sender.getName()) && this.IssetPos(2, sender.getName())) {
					if (args.length == 1) {
						Cut cut = new Cut(this, sender.getName());
						if (args[0].equals("zxc")) {
							cut.n();
						}else if(args[0].equals("dxc")){
							cut.start();
						}
					}
				} else {
					sender.sendMessage("§b请先设定对角位置,/pos1  /pos2");
				}
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		case "copy":
			if (sender instanceof Player) {
				if (this.IssetPos(1, sender.getName()) && this.IssetPos(2, sender.getName())) {
					if (args.length == 1) {
						Copy copy = new Copy(this, sender.getName());
						if (args[0].equals("zxc")) {
							copy.n();
						}else if(args[0].equals("dxc")){
							copy.start();
						}
					}
				} else {
					sender.sendMessage("§b请先设定对角位置,/pos1  /pos2");
				}
			} else {
				sender.sendMessage("§c请不要在后台运行!");
			}
			break;
		case "paste":
			if (sender instanceof Player) {
				if (this.IssetPos(1, sender.getName()) && this.IssetPos(2, sender.getName())) {
					if (args.length == 2) {
						Paste paste = new Paste(this, sender.getName(),new Vector3((int)s.getX(),(int)s.getY(),(int)s.getZ()),args[1]);
						if (args[0].equals("zxc")) {
							paste.n();
						}else if(args[0].equals("dxc")){
							paste.start();
						}
					}
				} else {
					sender.sendMessage("§b请先复制或剪下方块!");
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
    		if ((this.AxeSelectedPos.get(player.getName()) == null) || (this.AxeSelectedPos.get(player.getName()).equals("pos1"))) {
    			this.AxeSelectedPos.put(player.getName(),"pos2");
    			this.pos1 = new HashMap<String, Object>();
				HashMap<String, Object> SenderPosition = new HashMap<>();
				int x = (int)event.getBlock().getX();
				int y = (int)event.getBlock().getY();
				int z = (int)event.getBlock().getZ();
				SenderPosition.put("x", x);
				SenderPosition.put("y", y);
				SenderPosition.put("z", z);
				SenderPosition.put("level", player.getLevel().getName());
				this.pos1.put(player.getName(), SenderPosition);
				player.sendMessage("§b点1设定完成(x:"+x+",y:"+y+",z:"+z+")");
			}else{
				this.AxeSelectedPos.put(player.getName(),"pos1");
				String Pos1Level = (String) this.GetPosInfo(1, player.getName()).get("level");
				if (Pos1Level.equals(player.getLevel().getName())) {
					this.pos2 = new HashMap<String, Object>();
					HashMap<String,Object> playerPosition = new HashMap<>();
					int x = (int)event.getBlock().getX();
					int y = (int)event.getBlock().getY();
					int z = (int)event.getBlock().getZ();
					playerPosition.put("x", x);
					playerPosition.put("y", y);
					playerPosition.put("z", z);
					playerPosition.put("level", player.getLevel().getName());
					this.pos2.put(player.getName(), playerPosition);
					player.sendMessage("§b点2设定完成(x:"+x+",y:"+y+",z:"+z+")");
				} else {
					player.sendMessage("请在[" + Pos1Level + "]世界里使用/pos2");
				}
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

	public Map<String, Object> GetPosInfo(int PosNumber, String SenderName) {
		Map<String, Object> m = (PosNumber == 1 ? this.pos1 : this.pos2);
		Map<String, Object> pos = (Map<String, Object>) m.get(SenderName);
		return pos;
	}
	public ArrayList<int[]> getSelectedBlocks(String sendername) {
		Map<String, Object> Pos1Info = this.GetPosInfo(1,sendername);
		Map<String, Object> Pos2Info = this.GetPosInfo(2,sendername);
		int p1x = (int) Pos1Info.get("x");
		int p1y = (int) Pos1Info.get("y");
		int p1z = (int) Pos1Info.get("z");
		int p2x = (int) Pos2Info.get("x");
		int p2y = (int) Pos2Info.get("y");
		int p2z = (int) Pos2Info.get("z");
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
