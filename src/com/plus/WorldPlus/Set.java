package com.plus.WorldPlus;

import java.util.ArrayList;
import java.util.Iterator;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;

public class Set extends Thread {
	private String sendername;
	private Main main;
	private String BlockId;
	private boolean SetWithP;

	public Set(Main main, String SenderName,String BlockId,boolean SetWithP) {
		this.main = main;
		this.sendername = SenderName;
		this.BlockId = BlockId;
		this.SetWithP = SetWithP;
	}

	public void run() {
		Player player = this.main.getServer().getPlayer(this.sendername);
		ArrayList<int[]> SelectedBlocks = this.main.getSelectedBlocks(this.sendername);
		int blocks = SelectedBlocks.size();
		player.sendMessage("§b将以§9多线程§b生成§e"+blocks+"§b个方块!");
		if(this.SetWithP){
			this.SetWithP(SelectedBlocks);
		}else{
			this.SetWithOutP(SelectedBlocks);
		}
	}
	public void n(){
		Player player = this.main.getServer().getPlayer(this.sendername);
		ArrayList<int[]> SelectedBlocks = this.main.getSelectedBlocks(this.sendername);
		int blocks = SelectedBlocks.size();
		player.sendMessage("§b将以§a主线程§b生成§e"+blocks+"§b个方块!");
		if(this.SetWithP){
			this.SetWithP(SelectedBlocks);
		}else{
			this.SetWithOutP(SelectedBlocks);
		}
	}
	public void SetWithP(ArrayList<int[]> SelectedBlocks){ //生成方块时显示百分比,较慢
		Player player = this.main.getServer().getPlayer(this.sendername);
		String levelname = (String) this.main.GetPosInfo(1, this.sendername, "level");
		Level level = this.main.getServer().getLevelByName(levelname);
		Iterator<int[]> iterator = SelectedBlocks.iterator(); 
        int SelectedBlocksAmount = SelectedBlocks.size();
        int BlockNo = 0;
        Block block = new BlocksName().Block(this.BlockId);
		long starttime = System.currentTimeMillis();
		while(iterator.hasNext()){
			int[] next = iterator.next();
			++BlockNo;
			if(BlockNo == (SelectedBlocksAmount/4)){
				player.sendMessage("§b进度...25%");
			}else if(BlockNo == (SelectedBlocksAmount/2)){
				player.sendMessage("§b进度...50%");
			}else if(BlockNo == ((SelectedBlocksAmount/4)*3)){
				player.sendMessage("§b进度...75%");
			}
			level.setBlock(new Vector3(next[0],next[1],next[2]),block);
		}
        long endtime = System.currentTimeMillis();
        player.sendMessage("§b进度...100%");
        player.sendMessage("§b生成完毕!§c如无法完整显示方块,请重新加入服务器\n"+"§b共处理"+SelectedBlocksAmount+"方块!耗时:"+(endtime-starttime)+"毫秒\n§e--创世神插件(v0.5)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
	}
	public void SetWithOutP(ArrayList<int[]> SelectedBlocks){ //生成方块时不显示百分比,较快
		Player player = this.main.getServer().getPlayer(this.sendername);
		String levelname = (String) this.main.GetPosInfo(1, this.sendername, "level");
		Level level = this.main.getServer().getLevelByName(levelname);
		Iterator<int[]> iterator = SelectedBlocks.iterator(); 
        int SelectedBlocksAmount = SelectedBlocks.size();
        Block block = new BlocksName().Block(this.BlockId);
		long starttime = System.currentTimeMillis();
		while(iterator.hasNext()){
			int[] next = iterator.next();
			level.setBlock(new Vector3(next[0],next[1],next[2]),block);
		}
        long endtime = System.currentTimeMillis();
        player.sendMessage("§b生成完毕!§c如无法完整显示方块,请重新加入服务器\n"+"§b共处理"+SelectedBlocksAmount+"方块!耗时:"+(endtime-starttime)+"毫秒\n§e--创世神插件(v0.5)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
	}
}
