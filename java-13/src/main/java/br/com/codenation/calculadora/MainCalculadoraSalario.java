package br.com.codenation.calculadora;

public class MainCalculadoraSalario {
    public static void main(String[] args) {
    	CalculadoraSalario sal = new CalculadoraSalario();
        double salario = 10000.0;
        
        double t = sal.calcularSalarioLiquido(salario);
        
        System.out.println(t);
    }    
}