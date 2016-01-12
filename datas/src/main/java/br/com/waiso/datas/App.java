package br.com.waiso.datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args) {
		GregorianCalendar gCalendar = new GregorianCalendar(2012, 8, 20);
		System.out.println("Data " + gCalendar.getTime());

		GregorianCalendar gCalendarAgora = new GregorianCalendar();
		System.out.println("Data " + gCalendarAgora.getTime());

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatador.format(gCalendar.getTime());
		System.out.println("Data Formatada " + dataFormatada);

		try {
			SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			GregorianCalendar gCalendar2 = new GregorianCalendar();
			gCalendar2.setTime(formatador.parse("10/10/2012 12:00"));
			System.out.println("Data " + gCalendar2.getTime());
			dataFormatada = formatador2.format(gCalendar2.getTime());
			System.out.println("Data Formatada " + dataFormatada);
		} catch (ParseException e) {
			// Try Catch Obrigatario
			System.out.println("Erro na convers\u00e3o.");
		}
	}
}