/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsudestemg.Model.DAO;

/**
 *
 * @author victorPC
 */
public class Validacoes {
       
    public static boolean validarCPF(String cpf){
        if(cpf.length()!=14)
            return false;
        int dig1=0, dig2=0, calc1=0, calc2=0, aux1=10, aux2=11;
        int [] arrayCPF;
        boolean repetido = true;
        arrayCPF = new int[9];
        dig1 = Integer.parseInt(cpf.substring(12,13));
        dig2 = Integer.parseInt(cpf.substring(13,14));
       
        cpf = cpf.substring(0,3) + cpf.substring(4,7) + cpf.substring(8,11);
        for(int i=0; i<arrayCPF.length; i++){
            arrayCPF[i] = Integer.parseInt(cpf.substring(i, i+1));
            
            calc1 += aux1 * arrayCPF[i];
            aux1--;
            calc2 += aux2 * arrayCPF[i];
            aux2--;
            
            if(arrayCPF[0] != arrayCPF[i] && repetido)
                repetido = false;
        }
        calc2 += dig1 * aux2;
        
        calc1 = (calc1 * 10) % 11;
        calc2 = (calc2 * 10) % 11;
        
        if(calc1 == 10)
            calc1 = 0;
        
        if(calc2 == 10)
            calc2 = 0;
                      
        if(calc1 == dig1 && calc2 == dig2 && !repetido)
            return true;
        else
            return false;
    }
    
        
    public static boolean validarTitulo(String titulo){
        int tamanho = titulo.length();
        if(tamanho < 12 || tamanho > 13)
            return false;
        String esquerda = titulo.substring(0, tamanho-4);
        String direita = titulo.substring(tamanho-4, tamanho);
        int verificadorUF = Integer.parseInt(direita.substring(0, 2));
        if(verificadorUF < 1 || verificadorUF > 28)
            return false;
        int dv1 = 0, fator = 9;
        for(int i = esquerda.length()-1; i >= 0; i--){
            dv1+=(fator*(esquerda.charAt(i)-48));
            fator--;
            if(fator < 2)
                fator = 9;
        }
        dv1 = dv1 % 11;
        if(dv1 == 0)
        {
            if(verificadorUF == 1 || verificadorUF == 2)
                dv1 = 1;
        }
        else if(dv1 > 9)
            dv1 = 0;
        if((direita.charAt(2)-48)!=dv1)
            return false;
        int dv2 = (direita.charAt(0)-48)*7+(direita.charAt(1)-48)*8+dv1*9;
        dv2 = dv2 % 11;
        if(dv2==0){
            if(verificadorUF==1 || verificadorUF==2)
                dv2 = 1;
        }
        else if(dv2 > 9)
                dv2 = 0;
        if((direita.charAt(3)-48)!=dv2)
            return false;
        
        return true;
    }
}
