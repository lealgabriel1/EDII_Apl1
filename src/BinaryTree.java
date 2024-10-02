/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494
*/

import java.util.Stack;

public class BinaryTree {
    private Node root; // referência para o nó raiz da árvore

    public BinaryTree() {
        this.root = null; // inicializa a árvore sem raiz
    }

    public void constroiArvore(String expression) {
        String[] tokens = expression.split("\\s+"); // separa a expressão por espaços
        Stack<Node> stack = new Stack<>(); // pilha para montar a árvore

        for (String token : tokens) {
            if (isOperator(token)) {
                // achou um operador, pega os dois últimos operandos da pilha
                Node right = stack.pop();
                Node left = stack.pop();
                Node operatorNode = new OperatorNode(token.charAt(0), left, right);
                stack.push(operatorNode); // coloca o nó operador na pilha
            } else {
                // achou um número, cria um nó operando e empilha
                float value = Float.parseFloat(token);
                Node operandNode = new OperandNode(value);
                stack.push(operandNode); // coloca o nó operando na pilha
            }
        }

        // no final, o único nó na pilha é a raiz da árvore
        root = stack.pop();
    }

    private boolean isOperator(String token) {
        // verifica se o token é um dos operadores aritméticos
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public void preOrdem() {
        preOrdem(root); // chama o método que faz o percurso pré-ordem
        System.out.println();
    }

    private void preOrdem(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " "); // visita o nó atual
            preOrdem(node.getLeft()); // percorre o lado esquerdo
            preOrdem(node.getRight()); // percorre o lado direito
        }
    }

    public void emOrdem() {
        emOrdem(root); // chama o método para o percurso em-ordem
        System.out.println();
    }

    private void emOrdem(Node node) {
        if (node != null) {
            emOrdem(node.getLeft()); // percorre o lado esquerdo
            System.out.print(node.getData() + " "); // visita o nó atual
            emOrdem(node.getRight()); // percorre o lado direito
        }
    }

    public void posOrdem() {
        posOrdem(root); // chama o método para o percurso pós-ordem
        System.out.println();
    }

    private void posOrdem(Node node) {
        if (node != null) {
            posOrdem(node.getLeft()); // percorre o lado esquerdo
            posOrdem(node.getRight()); // percorre o lado direito
            System.out.print(node.getData() + " "); // visita o nó atual
        }
    }

    public float calcular() {
        return root.visitar(); // realiza o cálculo da expressão a partir da raiz
    }

    public void print() {
        System.out.println("\nRepresentação visual da árvore:\n");
        printArvore(root, 0); // chama o método que imprime a árvore
    }

    private void printArvore(Node node, int level) {
        if (node != null) {
            printArvore(node.getRight(), level + 1); // percorre o lado direito
            System.out.println(" ".repeat(4 * level) + "-> " + node.getData()); // imprime o nó atual com indentação
            printArvore(node.getLeft(), level + 1); // percorre o lado esquerdo
        }
    }

    public static String repeat(String s, int n) { // metodo repeat implementado manualmente por conta de versoes incompativeis do Java
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
    
}
