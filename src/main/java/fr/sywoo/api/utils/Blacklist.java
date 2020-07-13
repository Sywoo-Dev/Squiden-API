package fr.sywoo.api.utils;

import java.util.ArrayList;

public class Blacklist {
	
	public static boolean contain(String name) {
		boolean contain = false;
		for(String bully : get()) {
			if(name.contains(bully)) {
				contain = true;
			}
		}
		return contain;
	}
	
	public static ArrayList<String> get(){
		ArrayList<String> bl = new ArrayList<String>();
		bl.add("hitler");
		bl.add("admin");
		bl.add("gay");
		bl.add("homo");
		bl.add("hommo");
		bl.add("suce");
		bl.add("bite");
		bl.add("fdp");
		bl.add("fils");
		bl.add("mere");
		bl.add("fuck");
		bl.add("ez");
		bl.add("nazi");
		bl.add("poutine");
		bl.add("race");
		bl.add("epicube");
		bl.add("epikube");
		bl.add("erisium");
		bl.add("erisiium");
		bl.add("hypixel");
		bl.add("staline");
		bl.add("pd");
		bl.add("connard");
		bl.add("putain");
		bl.add("youtube");
		bl.add("alboche");
		bl.add("boche");
		bl.add("chleuh");
		bl.add("doryphore");
		bl.add("fridolin");
		bl.add("frisé");
		bl.add("frisou");
		bl.add("prussien");
		bl.add("amerlo");
		bl.add("ricain");
		bl.add("yankee");
		bl.add("rosbif");
		bl.add("bougnoule");
		bl.add("bougnoul");
		bl.add("chinetoque");
		bl.add("manouche");
		bl.add("rital");
		bl.add("bamboula");
		bl.add("nègre");
		bl.add("negre");
		bl.add("ruskoff");
		bl.add("aucune");
		bl.add("niaque");
		return bl;
	}

}
