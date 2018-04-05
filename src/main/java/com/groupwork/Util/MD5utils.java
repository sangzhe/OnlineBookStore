package com.groupwork.Util;

/**
 * Created by sangzhe on 2018/4/5.
 */
import java.security.MessageDigest;

public class MD5utils {
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     *
     * @param origin to be transformed MD5 String
     * @param charsetname char set used for transforming
     * @return Capitalized MD5 string
     */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString.toUpperCase();
    }

    /***
     * asymetric encoding
     * @param origin String need to be encoded
     * @return call MD4Encode
     */
    public static String MD5EncodeUtf8(String origin) {
//        // prevent brute-force decode using MD5 dict
        origin = origin + "geelysdafaqj23ou89ZXcj@#$@#$#@KJdjklj;D../dSF.,";
        return MD5Encode(origin, "utf-8");
    }


    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}