package com.bm.vpn.controller;

import java.io.IOException;

import com.bm.vpn.service.VPNService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connect")
public class ConnectServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String location = request.getParameter("location");

		// Call the VPN connection logic
		boolean isConnected = VPNService.connectToServer(location);

		// Send response back to frontend
		response.setContentType("application/json");
		response.getWriter().write("{\"status\": \"" + (isConnected ? "Connected" : "Failed") + "\"}");
	}
}