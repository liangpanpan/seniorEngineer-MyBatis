package com.pp.maven;

import java.io.File;

/**
 * 删除Maven中无用下载失败的文件夹。需要修改，会误删除maven依赖的包。不建议使用
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/2/13       create this file
 * </pre>
 */
public class MavenFailFileDelete {

    public static String root = "D:\\share\\.m2\\repository";

    public static void main(String[] args) {

        File file = new File(root);

        File[] childFile = file.listFiles();
        if (childFile == null || childFile.length <= 0) {
            return;
        }

        for (File file1 : childFile) {
            validate(file1);
        }

    }

    public static boolean validate(File file) {
        boolean isHaveJar = false;

        File[] _files = file.listFiles();

        // 判断是否存在*jar文件
        if (_files != null && _files.length >= 0) {
            for (File _file : _files) {
                if (_file.getName().endsWith(".jar")) {
                    isHaveJar = true;
                    continue;
                }

                if (_file.isDirectory()) {
                    boolean isNextHaveJar = validate(_file);
                    if (isNextHaveJar) {
                        isHaveJar = true;
                    }
                }
            }
        }

        if (!isHaveJar) {
            delete(file);
        }

        return isHaveJar;
    }

    public static void delete(File file) {
        File[] _files = file.listFiles();

        if (_files != null && _files.length > 0) {
            for (File _file : _files) {
                if (_file.isDirectory()) {
                    delete(_file);
                }
                _file.delete();
            }
        }
        file.delete();
    }

}
