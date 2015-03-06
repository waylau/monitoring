package com.waylau.monitoring.sample;

import java.util.Timer;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import com.waylau.monitoring.timertask.CpuInfoTimerTask;
import com.waylau.monitoring.util.SigarUtil;

public class sigarTest {

 
	public static void main(String[] args) throws SigarException {
		// TODO Auto-generated method stub

		Sigar sigar = SigarUtil.sigar;
		CpuPerc cpuPerc = sigar.getCpuPerc();
 
        
   		System.out.println("User Time....." + CpuPerc.format(cpuPerc.getUser()));
   		System.out.println("Sys Time......" + CpuPerc.format(cpuPerc.getSys()));
   		System.out.println("Idle Time....." + CpuPerc.format(cpuPerc.getIdle()));
   		System.out.println("Wait Time....." + CpuPerc.format(cpuPerc.getWait()));
   		System.out.println("Nice Time....." + CpuPerc.format(cpuPerc.getNice()));
   		System.out.println("Combined......" + CpuPerc.format(cpuPerc.getCombined()));
   		System.out.println("Irq Time......" + CpuPerc.format(cpuPerc.getIrq()));
   		
   		
   		Timer timer = new Timer();
   		timer.scheduleAtFixedRate(new CpuInfoTimerTask(), 1000,2000); 
	}

}
