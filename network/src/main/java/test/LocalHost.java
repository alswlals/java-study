package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress= InetAddress.getLocalHost();
			
			/*HostName 뽑기*/
			String hostName = inetAddress.getHostName();
			
			/*주소뽑기*/
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetAddress.getAddress();
			for(byte IpAddress:IpAddresses) {
//				System.out.println((int)IpAddress);
				System.out.println(IpAddress & 0x000000ff);
				System.out.println(".");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
