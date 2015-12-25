package com.plus.WorldPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;

public class Copy extends Thread{
	//其实与cut几乎一模一样,哈哈
	private Main main;
	private String SenderName;

	public Copy(Main main, String SenderName) {
		this.main = main;
		this.SenderName = SenderName;
	}
	public void run(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		player.sendMessage("§b将以§9多线程§b复制方块!");
		this.CopyBlocks();
	}
	public void n(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		player.sendMessage("§b将以§a主线程§b复制方块!");
		this.CopyBlocks();
	}
	public void CopyBlocks(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		Map<String, Object> Pos1Info = this.main.GetPosInfo(1,this.SenderName);
		Map<String, Object> Pos2Info = this.main.GetPosInfo(2,this.SenderName);
		Level level = this.main.getServer().getLevelByName((String) Pos1Info.get("level"));
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
		ArrayList<HashMap<String,Object>> CutBlocks = new ArrayList<>();
		int SelectedBlocksAmount = 0;
		long starttime = System.currentTimeMillis();
        for(int nstartx=startx;nstartx <= stopx;nstartx++){
        	for(int nstartz=startz;nstartz <= stopz;nstartz++){
        		for(int nstarty=starty;nstarty <= stopy;nstarty++){
        			++SelectedBlocksAmount;
        			Block block = level.getBlock(new Vector3(nstartx,nstarty,nstartz));
        			HashMap<String,Object> Block = new HashMap<>();
        			Block.put("x",(nstartx-startx));
        			Block.put("y",(nstarty-starty));
        			Block.put("z",(nstartz-startz));
        			Block.put("block",block);
        			CutBlocks.add(Block);
        		}
        	}
        }
        long endtime = System.currentTimeMillis();
        this.main.CopiedOrCutBlocks.put(this.SenderName,CutBlocks);
        player.sendMessage("§b复制完毕!§c如无法完整显示方块,请重新加入服务器\n§b共复制"+SelectedBlocksAmount+"方块!耗时:"+(endtime-starttime)+"毫秒\n§e--创世神插件(v1.6)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
	}
}
