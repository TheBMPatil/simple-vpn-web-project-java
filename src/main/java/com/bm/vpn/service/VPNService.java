package com.bm.vpn.service;

public class VPNService {

	private static boolean connected = false; // To track the connection status

	public static boolean connectToServer(String location) {
		// Add VPN connection logic here
		System.out.println("Attempting to connect to VPN server at location: " + location);

		// Simulated result: Replace with actual connection logic
		if (location != null && !location.isEmpty()) {
			connected = true; // Simulate success
			return true;
		}
		return false; // Simulate failure
	}

	public static boolean disconnectFromServer() {
		if (connected) {
			// Simulated disconnection logic
			System.out.println("Disconnecting from VPN server...");
			connected = false; // Mark as disconnected
			return true;
		}
		return false; // Already disconnected
	}
}
