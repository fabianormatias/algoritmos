package consumo1014;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int distanciaPercorrida;
		double combustivelGasto;

		String txtDistancia = "Informe a distância percorrida:\n";
		System.out.printf(txtDistancia);
		distanciaPercorrida = scanner.nextInt();

		System.out.printf("Informe a quantidade de combustível gasto:\n ");
		combustivelGasto = scanner.nextInt();
		
		double custoMedio = distanciaPercorrida / combustivelGasto;
		
		String pattern = "#0.###";
		DecimalFormat df = new DecimalFormat(pattern);
		String format = df.format(custoMedio);
		
		System.out.println(format + " km/l");

	}

}
