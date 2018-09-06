package com.lamaknyo.api.common.security;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5 {
    public static final String generate(String val) {
        String out = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(val.getBytes());
            byte[] digest = md.digest();
            out = DatatypeConverter.printHexBinary(digest).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return out;
    }
}
