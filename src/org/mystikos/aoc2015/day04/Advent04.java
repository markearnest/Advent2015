package org.mystikos.aoc2015.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Advent04 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String key = "bgvyzdsv";
        boolean needP1 = true;
        for(int x = 0; x < Integer.MAX_VALUE; x++) {
            md.update((key.concat(Integer.toString(x)).getBytes()));
            if(needP1 && toHex(md.digest()).startsWith("00000")) {
                System.out.println("p1: " + x);
                needP1 = false;
            }
            if(toHex(md.digest()).startsWith("000000")) {
                System.out.println("p2: " + x);
                break;
            }
        }
    }
    public static String toHex(byte[] md) {
        char[] hArray = "0123456789ABCDEF".toCharArray();
        char[] c = new char[md.length * 2];
        StringBuilder sb = new StringBuilder(c.length);
        for (int x = 0; x < md.length; x++) {
            int v = md[x] & 0xFF;
            c[x * 2] = hArray[v >>> 4];
            c[x * 2 + 1] = c[v & 0x0F];
            sb.append(c[x * 2]).append(c[x * 2 + 1]);
        }
        return sb.toString();
    }
}
