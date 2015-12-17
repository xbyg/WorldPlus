package com.plus.WorldPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;

public class Rotate extends Thread {
	private Main main;
	private String SenderName;
	public String RotateAngle = "0";

	public Rotate(Main main, String SenderName,String RotateAngle) {
		this.main = main;
		this.SenderName = SenderName;
		this.RotateAngle = RotateAngle;
	}

	public void run() {
		this.RotateBlocks();
	}

	public void n() {
		this.RotateBlocks();
	}

	public void RotateBlocks() { // 旋转90度
		if (!this.RotateAngle.equals("0")) {
			Player player = this.main.getServer().getPlayer(this.SenderName);
			player.sendMessage("§a准备旋转方块!");
			int RotateTime = (this.RotateAngle.equals("90")?1:(this.RotateAngle.equals("180")?2:3));
			HashMap<String, ArrayList<HashMap<String, Object>>> CopiedOrCutBlocks = this.main.CopiedOrCutBlocks;
			ArrayList<HashMap<String, Object>> Blocks = CopiedOrCutBlocks.get(this.SenderName);
			Map<String, Object> Pos1Info = this.main.GetPosInfo(1, this.SenderName);
			Map<String, Object> Pos2Info = this.main.GetPosInfo(2, this.SenderName);
			int p1x = (int) Pos1Info.get("x");
			int p2x = (int) Pos2Info.get("x");
			int MaxX = Math.max(p1x, p2x);
			int MinX = Math.min(p1x,p2x);
			long starttime = System.currentTimeMillis();
			for(int NowRotateTime=1;NowRotateTime <= RotateTime;NowRotateTime++){			
			for (int i = 0; i < Blocks.size(); i++) {
				HashMap<String, Object> NewBlock = new HashMap<>();
				HashMap<String, Object> Block = Blocks.get(i);
				int z = (MaxX - (MinX+(int) Block.get("x")));
				int x = (int)Block.get("z");
				NewBlock.put("x", x);
				NewBlock.put("z", z);
				Block.putAll(NewBlock);
			}
			}
			long endtime = System.currentTimeMillis();
			player.sendMessage("§a旋转完毕!§e耗时:" + (endtime - starttime)+ "毫秒\n§e--创世神插件(v1.5)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
		}
	}
}
