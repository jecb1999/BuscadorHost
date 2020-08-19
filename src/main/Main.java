package main;

import java.net.InetAddress;
import java.net.NetworkInterface;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		try {
			InetAddress myAddress;
			myAddress = InetAddress.getLocalHost();
			NetworkInterface net = NetworkInterface.getByInetAddress(myAddress);
			int mascara = net.getInterfaceAddresses().get(0).getNetworkPrefixLength();
			String getIp = myAddress.getHostAddress();
			String parts[] = getIp.split("\\.");
			if(mascara == 8) {
				for(int i=1;i<255;i++) {
					for(int j=1;j<255;j++) {
						for(int l=1;l<255;l++) {
							String ip = parts[0]+"."+i+"."+j+"."+l;
							InetAddress equipo = InetAddress.getByName(ip);
							if(equipo.isReachable(100)) {
								System.out.println(ip);
							}
						}
					}
				}
			}
			if(mascara == 16) {
				for(int i=1;i<255;i++) {
					for(int j=1;j<255;j++) {
						String ip = parts[0]+"."+parts[1]+"."+i+"."+j;
						InetAddress equipo = InetAddress.getByName(ip);
						if(equipo.isReachable(100)) {
							System.out.println(ip);
					}
					}
				}
			}
			if(mascara == 24) {
				for(int i=1;i<255;i++) {
					String ip = parts[0]+"."+parts[1]+"."+parts[2]+"."+i;
					InetAddress equipo = InetAddress.getByName(ip);
					if(equipo.isReachable(100)) {
						System.out.println(ip);
				}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
