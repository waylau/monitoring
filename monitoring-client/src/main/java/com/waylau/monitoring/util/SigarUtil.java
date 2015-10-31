package com.waylau.monitoring.util;

import java.io.File;

import org.hyperic.sigar.Sigar;

import com.google.common.io.Resources;

/**
 * 将 sigar 资源包放到 classpath 下
 * @author waylau.com
 * 2015年3月6日
 */
public class SigarUtil {

	public final static Sigar sigar = initSigar();

    private static Sigar initSigar() {
        try {	

        	 
            //String file =  new File("sigar/.sigar_shellrc").getCanonicalPath();
        	String file = Resources.getResource("sigar/.sigar_shellrc").getFile();
            System.out.println("---java.library.path"+ file);
            
            File classPath = new File(file).getParentFile();

            String path = System.getProperty("java.library.path");
            if (OsCheckUtil.getOperatingSystemType() == OsCheckUtil.OSType.Windows) {
                path += ";" + classPath.getCanonicalPath();
            } else {
                path += ":" + classPath.getCanonicalPath();
            }
            System.setProperty("java.library.path", path);

            return new Sigar();
        } catch (Exception e) {
            return null;
        }
    }
}
