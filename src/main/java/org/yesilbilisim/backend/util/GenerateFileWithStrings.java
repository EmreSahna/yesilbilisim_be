package org.yesilbilisim.backend.util;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class GenerateFileWithStrings {
    public byte[] generateFile(String[] strings) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (String string : strings) {
                byteArrayOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
                byteArrayOutputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        byte[] dosyaIcerigi = byteArrayOutputStream.toByteArray();
        return dosyaIcerigi;
    }
}
