package com.hwq.io;

import java.io.InputStream;

/**
 * @author HWQ
 * @date 2024/5/9 20:56
 * @description 根据配置文件的路径，加载配置文件成字节输入流，存到内存中
 */
public class Resources {
        public static InputStream getResourceAsStream(String path) {
            return Resources.class.getClassLoader().getResourceAsStream(path);
        }
}
