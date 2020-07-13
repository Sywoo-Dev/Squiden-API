package fr.sywoo.api.socket;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.spigot.LionSpigot;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

public class Reception implements Runnable {

	private BufferedReader in;
	private Socket socket;
	private String message;

	public Reception(BufferedReader in, Socket socket) {
		this.in = in;
		this.socket = socket;
	}

	@SuppressWarnings("resource")
	private String streamToString(InputStream inputStream) {
		String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
		return text;
	}

	private String uuidConverter(String uuid) {
		String newuuid = "";
		for (int i = 0; i < uuid.length(); i++) {
			newuuid += uuid.charAt(i);
			if (i == 7) {
				newuuid += "-";
			}

			if (i == 11) {
				newuuid += "-";
			}

			if (i == 15) {
				newuuid += "-";
			}

			if (i == 19) {
				newuuid += "-";
			}
		}
		return newuuid;
	}

	private JsonObject jsonGetRequest(String urlQueryString) {
		JsonObject json = null;
		try {
			URL url = new URL(urlQueryString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = new JsonParser().parse(streamToString(inStream)).getAsJsonObject();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return json;
	}

	@Override
	public void run() {
		boolean running = true;
		if (!socket.getRemoteSocketAddress().toString().split(":")[0].contains("127.0.0.1")) {
			System.out.println("UN FDP A ESSAYER DE SE CO A VOS SOCKETS " + socket.getRemoteSocketAddress());
			return;
		}
		while (running) {
			try {
				message = in.readLine();
				if (message == null) {
					System.out.println("Le message Socket envoyer est null");
					return;
				}
				if (message.equalsIgnoreCase("shutdown")) {
					running = false;
					LionBungee.get().socketList.remove(socket);
					socket.close();
				}
				if (message.contains("money:")) {
					int quantity = Integer.valueOf(message.split(":")[2]);
					String username = message.split(":")[1];
					ProxiedPlayer pp = LionBungee.get().getProxy().getPlayer(username);
					if (pp != null) {
						ByteArrayOutputStream bb = new ByteArrayOutputStream();
						DataOutputStream outt = new DataOutputStream(bb);

						outt.writeUTF("money");
						outt.writeUTF(pp.getUniqueId().toString());
						outt.writeUTF(username);
						outt.writeUTF(quantity + "");

						System.out.println("Server adress of player = " + pp.getServer().getAddress());
						pp.getServer().sendData("BungeeCord", bb.toByteArray());
					} else {
						String uuid = uuidConverter(
								jsonGetRequest("https://api.mojang.com/users/profiles/minecraft/" + username).get("id")
										.getAsString());
						System.out.println(
								username + " Avec l'identifiant " + uuid + " la somme de " + quantity + " Coins !");
						int money = 0;
						money = LionSpigot.get().getAccountManager().get(UUID.fromString(uuid)).getCoins();
						System.out.println("Somme récupérer en BDD = " + money);
						money += quantity;
						System.out.println("Somme après ajout = " + money);

						LionSpigot.get().getAccountManager().update(LionSpigot.get().getAccountManager()
								.get(UUID.fromString(uuid)).addCoins(money));
					}
				}

			} catch (IOException e) {
				running = false;
				e.printStackTrace();
				new IOException("THE SOCKET ARE CLOSED BEACAUSE " + e.getCause());
			}
		}
	}
}
