/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kaleb
 */
public class Session {

    private static int currentUserId;
    private static String currentUsername;
    private static String currentRole;

    // Getter and Setter for currentUserId
    public static int getCurrentUserId() {
        return currentUserId;
    }

    public static void setCurrentUserId(int currentUserId) {
        Session.currentUserId = currentUserId;
    }

    // Getter and Setter for currentUsername
    public static String getCurrentUsername() {
        return currentUsername;
    }

    public static void setCurrentUsername(String currentUsername) {
        Session.currentUsername = currentUsername;
    }

    // Getter and Setter for currentRole
    public static String getCurrentRole() {
        return currentRole;
    }

    public static void setCurrentRole(String currentRole) {
        Session.currentRole = currentRole;
    }
}