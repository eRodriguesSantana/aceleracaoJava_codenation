package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {
    
    public static void main(String[] args){
        System.out.println(fibonacci());
        System.out.println(isFibonacci(233));
    }
    
    public static List<Integer> fibonacci() {
        Integer[] fibonacci = new Integer[15];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        
        setupFibonacci(14, fibonacci);
        
        return new ArrayList<>(Arrays.asList(fibonacci));
    }

    public static Boolean isFibonacci(Integer a) {
        return fibonacci().contains(a);
    }
    
    public static Integer setupFibonacci(Integer start, Integer[] list){
        if(list[start] == null){
            list[start] = setupFibonacci(start - 1, list) + setupFibonacci(start - 2, list);
        }
        
        return list[start];
    }

}