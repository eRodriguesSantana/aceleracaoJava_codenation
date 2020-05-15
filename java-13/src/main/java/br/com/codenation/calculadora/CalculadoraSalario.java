package br.com.codenation.calculadora;


public class CalculadoraSalario {
	
	private double salarioBruto;
	private double salarioLiquido;
	
	 public Double getSalarioBruto() {
        return salarioBruto;
    }
	 
    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    
    public Double getSalarioLiquido() {
    	return salarioLiquido;
    }
    
    public void setSalarioLiquido(Double salarioLiquido) {
    	this.salarioLiquido = salarioLiquido;
    }

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		
		setSalarioBruto(this.calcularInss(salarioBase));
		setSalarioLiquido(getSalarioBruto());
		this.calcularIRRF();
		
		return Math.round(getSalarioLiquido());
	}
	
	private boolean faixaSalarial(Double salarioBase, int menorValor){
        return salarioBase <= menorValor;
    }
	
	//Example de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		 if(faixaSalarial(salarioBase,1500))
			setSalarioBruto (salarioBase - (salarioBase * 8 / 100));
		 else if(faixaSalarial(salarioBase,4000))
        	setSalarioBruto (salarioBase - (salarioBase * 9 / 100));
        else
        	setSalarioBruto (salarioBase - (salarioBase * 11 / 100));
		
		return getSalarioBruto();
	}
	
	private double calcularIRRF(){   
		
		if(faixaSalarial(getSalarioBruto(), 1039))
			setSalarioLiquido(0.0);
		else if(faixaSalarial(getSalarioBruto(), 3000))
            setSalarioLiquido(getSalarioBruto() * 1);
        else if(faixaSalarial(getSalarioBruto(), 6000))
        	setSalarioLiquido(getSalarioBruto() - (getSalarioBruto() * 7.5 / 100));
        else
        	setSalarioLiquido(getSalarioBruto() - (getSalarioBruto() * 15 / 100));
        return getSalarioLiquido();
    }

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/