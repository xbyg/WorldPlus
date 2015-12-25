package com.plus.WorldPlus;

import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.level.Level;

public class Set extends Thread {
	private String sendername;
	private Main main;
	private int BlockId;

	public Set(Main main, String SenderName,String BlockId) {
		this.main = main;
		this.sendername = SenderName;
		this.BlockId = Integer.parseInt(BlockId);
	}

	public void run() {
		Player player = main.getServer().getPlayer(sendername);
		player.sendMessage("§b将以§9多线程§b生成方块!");
		SetBlocks();
	}
	public void n(){
		Player player = main.getServer().getPlayer(sendername);
		player.sendMessage("§b将以§a主线程§b生成方块!");
		SetBlocks();
	}
	public void SetBlocks(){
		Player player = main.getServer().getPlayer(sendername);
		Level level = main.getServer().getLevelByName((String)main.GetPosInfo(1,sendername).get("level"));
		Map<String, Object> Pos1Info = main.GetPosInfo(1,sendername);
		Map<String, Object> Pos2Info = main.GetPosInfo(2,sendername);
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
		int Blocks=0;
		long starttime = System.currentTimeMillis();
        for(int nstartx=startx;nstartx <= stopx;nstartx++){
        	for(int nstartz=startz;nstartz <= stopz;nstartz++){
        		for(int nstarty=starty;nstarty <= stopy;nstarty++){
        			++Blocks;
        			level.setBlockIdAt(nstartx,nstarty,nstartz,BlockId);
        		}
        	}
        }
        long endtime = System.currentTimeMillis();
        player.sendMessage("§b生成完毕!§c如无法完整显示方块,请重新加入服务器\n§b共处理"+Blocks+"方块!耗时:"+(endtime-starttime)+"毫秒\n§e--创世神插件(v1.6)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
	}
}
