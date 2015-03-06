package com.waylau.monitoring.timertask;
import java.util.TimerTask;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.waylau.monitoring.util.SigarUtil;


public class CpuInfoTimerTask extends TimerTask {

	private CpuPerc[] cpus;
	private CpuInfo[] infos;
	
	public CpuInfoTimerTask() throws SigarException {
		
        cpus =  SigarUtil.sigar.getCpuPercList();
        infos = SigarUtil.sigar.getCpuInfoList();
	}

	@Override
	public void run() {
		System.out.println("++++++++CpuPerc++++++++");
        for(CpuPerc cpuPerc : cpus){
        	
       		System.out.println("User Time....." + CpuPerc.format(cpuPerc.getUser()));
       		System.out.println("Sys Time......" + CpuPerc.format(cpuPerc.getSys()));
       		System.out.println("Idle Time....." + CpuPerc.format(cpuPerc.getIdle()));
       		System.out.println("Wait Time....." + CpuPerc.format(cpuPerc.getWait()));
       		System.out.println("Nice Time....." + CpuPerc.format(cpuPerc.getNice()));
       		System.out.println("Combined......" + CpuPerc.format(cpuPerc.getCombined()));
       		System.out.println("Irq Time......" + CpuPerc.format(cpuPerc.getIrq()));
        }
        
        System.out.println("++++++++CpuInfo++++++++");
        for(int i=0; i<cpus.length; i++){
        	
            CpuInfo info = infos[i];
            long cacheSize = info.getCacheSize();
            System.out.println("Vendor........." + info.getVendor());
            System.out.println("Model.........." + info.getModel());
            System.out.println("Mhz............" + info.getMhz());
            System.out.println("Total CPUs....." + info.getTotalCores());
            if ((info.getTotalCores() != info.getTotalSockets()) ||
                (info.getCoresPerSocket() > info.getTotalCores()))
            {
            	System.out.println("Physical CPUs.." + info.getTotalSockets());
            	System.out.println("Cores per CPU.." + info.getCoresPerSocket());
            }

            if (cacheSize != Sigar.FIELD_NOTIMPL) {
            	System.out.println("Cache size...." + cacheSize);
            }
        }
	}

}
