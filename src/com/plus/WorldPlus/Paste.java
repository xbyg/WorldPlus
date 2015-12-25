package com.plus.WorldPlus;

import java.util.ArrayList;
import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.level.Level;
import cn.nukkit.math.Vector3;

public class Paste extends Thread{
	private Main main;
	private String SenderName;
    private Vector3 v3;
    private String RotateAngle = "0";
    
	public Paste(Main main, String SenderName,Vector3 v3,String RotateAngle) {
		this.main = main;
		this.SenderName = SenderName;
		this.v3 = v3;
		this.RotateAngle = RotateAngle;
	}
	public void run(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		player.sendMessage("§b将以§9多线程§b贴上方块!");
		Rotate rotate = new Rotate(this.main,this.SenderName,this.RotateAngle);
		rotate.start();
		this.PasteBlocks();
	}
	public void n(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		player.sendMessage("§b将以§a主线程§b贴上方块!");
		Rotate rotate = new Rotate(this.main,this.SenderName,this.RotateAngle);
		rotate.n();
		this.PasteBlocks();
	}
	public void PasteBlocks(){
		Player player = this.main.getServer().getPlayer(this.SenderName);
		HashMap<String,ArrayList<HashMap<String,Object>>> CopiedOrCutBlocks = this.main.CopiedOrCutBlocks;
		Vector3 SenderV3 = this.v3;
		Level level = this.main.getServer().getLevelByName((String)this.main.GetPosInfo(1, this.SenderName).get("level"));
		this.main.getServer().getPlayer(this.SenderName).teleport(new Vector3(((int)SenderV3.x-5),((int)SenderV3.y+5),((int)SenderV3.z-5)));
		ArrayList<HashMap<String,Object>> Blocks = CopiedOrCutBlocks.get(this.SenderName);
		long starttime = System.currentTimeMillis();
        for(int i=0;i<Blocks.size();i++){
        	HashMap<String,Object> Block = Blocks.get(i);
        	int x = (int) (SenderV3.x+(int)Block.get("x"));
        	int y = (int) (SenderV3.y+(int)Block.get("y"));
        	int z = (int) (SenderV3.z+(int)Block.get("z"));
        	level.setBlock(new Vector3(x,y,z),(Block)Block.get("block"));
        }
        long endtime = System.currentTimeMillis();
        player.sendMessage("§b贴上完毕!§c如无法完整显示方块,请重新加入服务器\n§b耗时:"+(endtime-starttime)+"毫秒\n§e--创世神插件(v1.6)By Plus(http://tieba.baidu.com/p/4212029014?pid=80628659576)--");
	}
}
