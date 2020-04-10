package it.vkod.woo.product.service.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class IpFromUrl {
    // Returns the IP address of an URL
    public static String getIp(String hostname) {
        try {
            InetAddress ipAddress = InetAddress.getByName(hostname);
            return ipAddress.getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage() + "Host name: " + hostname);
        }

        return "";
    }
}