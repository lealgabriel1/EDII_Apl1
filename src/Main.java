/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494


LINK DO YOUTUBE: <https://youtu.be/IUVxZtQzSpM>

REFÊRENCIAS:

1. <https://en.wikipedia.org/wiki/Shunting_yard_algorithm>
2. <https://www.guj.com.br/t/conversao-calculo-de-infixa-para-posfixa-ajuda-por-favor/44705/8>
3. <https://github.com/Guillhermegpp/Arvore-Binaria-JAVA/tree/master/Arvore>
4. <https://www.geeksforgeeks.org/java-program-to-implement-shunting-yard-algorithm/>
5. <https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/>
6. <https://algs4.cs.princeton.edu/32bst/BST.java.html>
7. <https://www.geeksforgeeks.org/expression-tree/>

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        String exprInfixa = null; // vai guardar a expressão aritmética infixa
        boolean treeCreated = false; // flag pra saber se a árvore já foi criada

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Entrada da expressão aritmética na notação infixa.");
            System.out.println("2. Criação da árvore binária de expressão aritmética.");
            System.out.println("3. Exibição da árvore binária de expressão aritmética.");
            System.out.println("4. Cálculo da expressão (realizando o percurso da árvore).");
            System.out.println("5. Encerramento do programa.");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // quebra de linha

            switch (option) {
                case 1:
                    System.out.print("\nDigite a expressão aritmética na notação infixa: ");
                    exprInfixa = scanner.nextLine();
                    break;
                case 2:
                    if (exprInfixa != null) {
                    	String exprPosfix = Parser.Conversor(exprInfixa);
                        tree.constroiArvore(exprPosfix);
                        treeCreated = true;
                        System.out.println("\nÁrvore binária de expressão aritmética criada com sucesso!");
                    } else {
                        System.out.println("\nErro: Expressão infixa não fornecida.");
                    }
                    break;
                case 3:
                    if (treeCreated) {
                        tree.print();
                        System.out.println("\nPercorrendo a árvore em Pos-Ordem:");
                        tree.posOrdem();
                        System.out.println("\nPercorrendo a árvore em Em-Ordem:");
                        tree.emOrdem();
                        System.out.println("\nPercorrendo a árvore em Pre-Ordem:");
                        tree.preOrdem();
                    } else {
                        System.out.println("\nErro: Árvore binária não criada.");
                    }
                    break;
                case 4:
                    if (treeCreated) {
                        float resultado = tree.calcular();
                        System.out.println("\nResultado da expressão: " + resultado);
                    } else {
                        System.out.println("Erro: Árvore binária não criada.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
