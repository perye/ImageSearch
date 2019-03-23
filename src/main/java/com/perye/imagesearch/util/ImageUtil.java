package com.perye.imagesearch.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author: Perye
 * @Date: 2019-03-23
 */
public class ImageUtil { public static String getImageFormatByFile(String filePath) {
    ImageInputStream input = null;
    try {
        input = ImageIO.createImageInputStream(new File(filePath));
        return getImageFormat(input);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return "unknown";
}

    public static String getImageFormatByBytes(byte[] content) {
        ImageInputStream input = null;
        try {
            input = new MemoryCacheImageInputStream(new ByteArrayInputStream(content));
            return getImageFormat(input);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // this function will not close input, need caller to close it.
    public static String getImageFormat(ImageInputStream input) {
        Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
        String format = "unknown";
        if (readers.hasNext()) {
            ImageReader reader = readers.next();
            try {
                format = reader.getFormatName();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                reader.dispose();
            }
        }

        return format;
    }


    public static HashMap<String, Integer> getImageInfoByFile(String filePath) {
        ImageInputStream input;
        try {
            input = ImageIO.createImageInputStream(new File(filePath));
            return getImageInfo(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Integer> getImageInfoByBytes(byte[] content) {
        ImageInputStream input = new MemoryCacheImageInputStream(new ByteArrayInputStream(content));
        return getImageInfo(input);
    }

    // this function will not close input, need caller to close it.
    public static HashMap<String, Integer> getImageInfo(ImageInputStream input) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(2);

        BufferedImage buff = null;
        try {
            buff = ImageIO.read(input);
            map.put("width", buff.getWidth());
            map.put("height", buff.getHeight());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}