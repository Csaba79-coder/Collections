package hu.sourcescode;

import java.io.*;

/**
 * Ez a program egy megadott mappát töröl, és a helyére egy másik megadott mappát másol.
 * @Author Robert Gergely
 */

public class MapCopy {

    // Source (Build server): /var/lib/pterodactyl/volumes/1e4bbae0-319b-4004-87e5-f19e98162866/Mineheroes/
    // Destination (Dev server): /var/lib/pterodactyl/volumes/2d19a843-7659-49fa-b244-5a2fb93b0128/Mineheroes/



    public static void main(String[] args) throws IOException {
        String source = "/var/lib/pterodactyl/volumes/1e4bbae0-319b-4004-87e5-f19e98162866/Mineheroes/";
        String target = "/var/lib/pterodactyl/volumes/2d19a843-7659-49fa-b244-5a2fb93b0128/Mineheroes/";
        System.out.println("===========================================");
        System.out.println("Map másolása...");
        deleteDirRecursive(new File(target));
        copy(new File(source), new File(target));
        System.out.println("Map másolása kész!");
        System.out.println("===========================================");
    }

    public static void deleteDirRecursive(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File temp : files) {
                deleteDirRecursive(temp);
            }
        }
        if (file.delete()) {
            System.out.println("Delete : " + file.getName());
        } else {
            System.err.println("Unable to delete file or directory : " + file.getName());
        }
    }

    public static void copy(File source, File target) throws IOException {
        if (source.isDirectory()) {
            copyDirectory(source, target);
        } else {
            copyFile(source, target);
        }
    }

    private static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
            System.out.println("Copy : " + f);
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}
