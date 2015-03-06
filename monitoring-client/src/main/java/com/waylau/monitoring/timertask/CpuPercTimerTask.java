package com.waylau.monitoring.timertask;
import java.util.TimerTask;

import org.hyperic.sigar.CpuPerc;


public class CpuPercTimerTask extends TimerTask {

	private CpuPerc cpuPerc;
	
	public CpuPercTimerTask(CpuPerc cpuPerc ) {
		this.cpuPerc = cpuPerc;
	}

	@Override
	public void run() {
   		System.out.println("User Time....." + CpuPerc.format(cpuPerc.getUser()));
   		System.out.println("Sys Time......" + CpuPerc.format(cpuPerc.getSys()));
   		System.out.println("Idle Time....." + CpuPerc.format(cpuPerc.getIdle()));
   		System.out.println("Wait Time....." + CpuPerc.format(cpuPerc.getWait()));
   		System.out.println("Nice Time....." + CpuPerc.format(cpuPerc.getNice()));
   		System.out.println("Combined......" + CpuPerc.format(cpuPerc.getCombined()));
   		System.out.println("Irq Time......" + CpuPerc.format(cpuPerc.getIrq()));
	}

}
