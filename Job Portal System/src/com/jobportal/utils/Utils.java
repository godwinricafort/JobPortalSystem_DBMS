package com.jobportal.utils;

public class Utils {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds); 
        } catch (InterruptedException e) {
            System.out.println("The delay was interrupted.");
        }
    }

    public static void headerDesign(){
        System.out.println("\n+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.print("""
                         |     _____   ___   ______      _______     ___   _______   _________     _       _____        ______  ____  ____   ______   _________  ________  ____    ____  |\r
                         """);
        System.out.print("""
                         |    |_   _|.'   `.|_   _ \\    |_   __ \\  .'   `.|_   __ \\ |  _   _  |   / \\     |_   _|     .' ____ \\|_  _||_  _|.' ____ \\ |  _   _  ||_   __  ||_   \\  /   _| |\r
                         """);
        System.out.print("""
                         |      | | /  .-.  \\ | |_) |     | |__) |/  .-.  \\ | |__) ||_/ | | \\_|  / _ \\      | |       | (___ \\_| \\ \\  / /  | (___ \\_||_/ | | \\_|  | |_ \\_|  |   \\/   |   |\r
                         """);
        System.out.print("""
                         |  _   | | | |   | | |  __'.     |  ___/ | |   | | |  __ /     | |     / ___ \\     | |   _    _.____`.   \\ \\/ /    _.____`.     | |      |  _| _   | |\\  /| |   |\r
                         """);
        System.out.print("""
                         | | |__' | \\  `-'  /_| |__) |   _| |_    \\  `-'  /_| |  \\ \\_  _| |_  _/ /   \\ \\_  _| |__/ |  | \\____) |  _|  |_   | \\____) |   _| |_    _| |__/ | _| |_\\/_| |_  |\r
                         """);
        System.out.print("""
                         | `.____.'  `.___.'|_______/   |_____|    `.___.'|____| |___||_____||____| |____||________|   \\______.' |______|   \\______.'  |_____|  |________||_____||_____| |\r
                         """);
        System.out.print("""
                         |                                                                                                                                                               |\r
                         """);
        System.out.print("""
                         +---------------------------------------------------------------------------------------------------------------------------------------------------------------+                                                                                                                                                           \r
                         """);
    }
}
