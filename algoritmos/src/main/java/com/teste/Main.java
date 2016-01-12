package com.teste;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		System.out.println("Informe a distância percorrida:\n");
		int distanciaPercorrida = Integer.parseInt(scanner.next());

//		System.out.println("Informe a quantidade de combustível gasto:\n ");
		double combustivelGasto = Double.parseDouble(scanner.next());

		double custoMedio = distanciaPercorrida / combustivelGasto;

		String pattern = "#0.###";
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
		df.setMaximumFractionDigits(3);
		String format = df.format(custoMedio);

		System.out.println(format + " km/l");
	}

}
