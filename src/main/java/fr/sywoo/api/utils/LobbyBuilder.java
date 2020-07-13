package fr.sywoo.api.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import fr.sywoo.api.spigot.LionSpigot;
import net.minecraft.server.v1_8_R3.NBTCompressedStreamTools;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class LobbyBuilder {

	private short width, height, lenght;
	private int offSetX, offSetZ;
	private byte[] blocks, blocksData;
	private NBTTagList entities, tileEntities;
	private Location middle;
	private List<Location> blocs = new ArrayList<>();

	public LobbyBuilder(Location loc) throws IOException {
		NBTTagCompound nbtData =  NBTCompressedStreamTools.a(LionSpigot.get().getClass().getClassLoader().getResourceAsStream("Lobby.schematic"));

		this.width = nbtData.getShort("Width");
		this.height = nbtData.getShort("Height");
		this.lenght = nbtData.getShort("Length");

		this.offSetX = nbtData.getInt("WEOffsetX");
		this.offSetZ = nbtData.getInt("WEOffsetZ");
		
		this.blocks = nbtData.getByteArray("Blocks");
		this.blocksData = nbtData.getByteArray("Data");

		this.entities = nbtData.getList("Entities", 0);
		this.tileEntities = nbtData.getList("TileEntities", 0);
		
		this.middle = loc;
	}

	@SuppressWarnings("deprecation")
	public void build() {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				for(int z = 0; z < lenght; z++) {
					int index = y*width*lenght+z*width+x;
					final Location loc = new Location(middle.getWorld(), middle.getX()+x, middle.getY()+y, middle.getZ()+z);
					int b = blocks[index] & 0xFF;
					final Block block = loc.getBlock();
					block.setType(Material.getMaterial(b));
					block.setData(blocksData[index]);
					blocs.add(loc);
				}
			}
		}
	}
	
	public void delete() {
		this.blocs.forEach(loc -> {
			loc.getBlock().setType(Material.AIR);
		});
		this.blocs.clear();
	}
	
	public Location getCenter() {
		return new Location(middle.getWorld(), middle.getX()-this.offSetX, middle.getY()+2, middle.getZ()-this.offSetZ);
	}

	public NBTTagList getEntities() {
		return entities;
	}

	public NBTTagList getTileEntities() {
		return tileEntities;
	}


}