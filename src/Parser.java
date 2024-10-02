/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494
*/

import java.util.Stack;
import java.lang.Character;

public class Parser {

    private static int Precede(char c) {
		switch (c) { //flags para definir a precedencia
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
		}
		return -1; // caso nao seja operador
	}
    
    public static String Conversor(String expr) {
	    String saida = new String("");
	    Stack<Character> stack = new Stack<>();
	    
	    for (int i = 0; i < expr.length(); i++) {
	        char c = expr.charAt(i);
	        
	        if (expr.charAt(i) == ' ') {
	            continue; // tratamento de espaços em branco
	        }
	        
	        if (Character.isLetterOrDigit(c)) {
	            // tratmento nros de vários dígitos
	            StringBuilder numero = new StringBuilder();
	            while (i < expr.length() && (Character.isLetterOrDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
	                numero.append(expr.charAt(i));
	                i++;
	            }
	            saida += numero.toString() + " ";
	            i--; // volta um char para que o prox caractere seja lido corretamente
	        } else if (c == '(') {
	            stack.push(c); // empilhando parenteses aberto 
	        } else if (c == ')') {
	            while (!stack.isEmpty() && stack.peek() != '(') { // desempilha ate encontrar o parenteses aberto 
	                saida += stack.peek() + " ";
	                stack.pop();
	            }
	            stack.pop();
	        }
	        else
	        {
	            while (!stack.isEmpty() && Precede(c) <= Precede(stack.peek())) {  // para realizar o stack de acordo com a precedencia correta dos operadores
	                saida += stack.peek() + " ";
	                stack.pop();
	            }
	            stack.push(c);
	        }
	    }
	    while (!stack.isEmpty()) {
	        if (stack.peek() == '(')
	            return "Expressão inválida."; // tratamento para parenteses aberto
	        saida += stack.peek() + " "; 
	        stack.pop();
	    }
	    return saida;
	}
}
