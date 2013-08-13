package com.honchat.lib;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author _4Char
 */
public class Commons {

    public static String md5(String Input) throws java.security.NoSuchAlgorithmException {
        String Return = Input;
        MessageDigest MessageD = MessageDigest.getInstance("MD5");
        MessageD.update(Return.getBytes(), 0, Return.length());
        return new BigInteger(1, MessageD.digest()).toString(16);
    }

    public static String sha256(String Input) throws java.security.NoSuchAlgorithmException {
        String Return = Input;
        MessageDigest MessageD = MessageDigest.getInstance("SHA-256");
        MessageD.update(Return.getBytes(), 0, Return.length());
        return new BigInteger(1, MessageD.digest()).toString(16);
    }

    public static byte[] XOR(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return null;
        }

        byte[] c = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            c[ i] = (byte) ((a[ i] & 0xFF) ^ (b[ i] & 0xFF));
        }

        return c;
    }

    public static byte[] PAD(byte[] s, int toLength) {
        if (s.length == toLength) {
            return s;
        }

        byte[] b = new byte[toLength];
        int sizeDifference = b.length - s.length;
        System.arraycopy(s, 0, b, sizeDifference, s.length);

        return b;
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array).toLowerCase();
    }

    public static String toReadableHexString(byte[] array) {
        String hex = DatatypeConverter.printHexBinary(array).toUpperCase();
        String finalHex = "";

        int temp = 0;
        for (char current : hex.toCharArray()) {
            if (temp == 2) {
                finalHex += " ";
                temp = 0;
            }

            finalHex += current;

            temp++;
        }

        return finalHex;
    }

    public static byte[] toByteArray(String hex) {
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }

        return DatatypeConverter.parseHexBinary(hex);
    }
}
