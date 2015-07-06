package br.com.waiso.utils;

import java.util.concurrent.TimeUnit;


public class TimeUtils {
	
	private static TimeUtils instance = new TimeUtils();

	public TimeUtils() {
	}

	public static TimeUtils getInstance() {
		return instance;
	}
	
	public Long time() {
		return System.nanoTime();
	}
	
	public Long timeCalculado(Long timeInicio, Long timeFinal) {
		return timeFinal - timeInicio;
	}
	
	public Long timeResultado(Long timeCalculado) {
		return TimeUnit.NANOSECONDS.convert(timeCalculado, TimeUnit.NANOSECONDS);
	}

}
