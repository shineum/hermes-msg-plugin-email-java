package hermesmsg.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class DataConverter {

    static Logger logger = LoggerFactory.getLogger(DataConverter.class);

    //
    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    //
    public static byte[] base64Decode(String base64Str) {
        return Base64.getDecoder().decode(base64Str);
    }

    //
    public static byte[] getCompressedData(byte[] bytes) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DeflaterOutputStream dos = new DeflaterOutputStream(baos);
            dos.write(bytes);
            dos.close();
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error("[COMPRESS]\n", e);
        }
        return null;
    }

    //
    public static byte[] getDecompressedData(byte[] bytes) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InflaterOutputStream ios = new InflaterOutputStream(baos);
            ios.write(bytes);
            ios.close();
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            logger.error("[DECOMPRESS]\n", e);
        }
        return null;
    }
}
