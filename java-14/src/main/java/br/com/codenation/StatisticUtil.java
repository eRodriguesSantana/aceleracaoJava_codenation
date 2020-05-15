package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;

		for (int i = 0; i < elements.length; i++) {
			soma += elements[i];
		}

		return (soma / (elements.length));
	}

	public static int mode(int[] elements) {
		int max = 0;
		int n = 0;
		int pos = 0;		
		
		Arrays.sort(elements);

		for (int i = 0; i < elements.length; i++) {
			int cont = 0;
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] == elements[i]) {
					cont++;
					pos = cont;
				} else
					continue;
			}
			if (cont > max) {
				max = cont;
				n = elements[i];
			}
		}
		if (pos == 0) {
			n = (elements.length / 2);
			
			return elements[2];
		}
		return n;
	}

	public static int median(int[] elements) {
		int maior = 0;

		for (int i = 0; i < elements.length; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] < elements[i]) {
					maior = elements[i];
					elements[i] = elements[j];
					elements[j] = maior;
				}
			}
		}

		if (elements.length % 2 == 0) {
			int div = elements.length / 2;
			int pt1 = elements[div];
			int pt2 = elements[(elements.length - div) + 1];
			int median = (pt1 + pt2) / 2;
			return median;
		} else {
			int div = elements.length / 2;
			return elements[div];
		}

	}

}