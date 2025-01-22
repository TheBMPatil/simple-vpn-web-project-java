package com.bm.vpn.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.bm.vpn.service.VPNService;

@WebServlet("/disconnect")
public class DisconnectServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call the VPN disconnection logic
        boolean isDisconnected = VPNService.disconnectFromServer();

        // Send response back to the frontend
        response.setContentType("application/json");
        response.getWriter().write("{\"status\": \"" + (isDisconnected ? "Disconnected" : "Failed to disconnect") + "\"}");
    }
}
