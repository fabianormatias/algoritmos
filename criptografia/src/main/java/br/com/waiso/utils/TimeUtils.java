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
//		Calendar data = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		String dataFormatada = sdf.format(data.getTime()); 
//		System.out.println("Data: " + dataFormatada);
		return System.nanoTime();
	}
	
	public Long timeCalculado(Long timeInicio, Long timeFinal) {
		return timeFinal - timeInicio;
	}
	
	public Long timeConvert(Long timeCalculado) {
		return TimeUnit.NANOSECONDS.convert(timeCalculado, TimeUnit.NANOSECONDS);
	}

}
