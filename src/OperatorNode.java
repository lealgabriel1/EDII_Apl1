/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494
*/

public class OperatorNode extends Node {
    private char operator; // operador do nó (+, -, *, /)
    private Node left;
    private Node right;

    public OperatorNode(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    // ** metodo para o calculo **
    float visitar() {
        float leftValue = left.visitar(); //visita os filhos esq e dir para obter os valores
        float rightValue = right.visitar();

        switch (operator) { // realiza a operação com os valores com base no operador guardado
            case '+':
                return leftValue + rightValue; // soma
            case '-':
                return leftValue - rightValue; // subtrai
            case '*':
                return leftValue * rightValue; // multiplica
            case '/':
                if (rightValue == 0) {
                    // divisão por zero
                    throw new ArithmeticException("Divisão por zero!");
                }
                return leftValue / rightValue; // divisao valida
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator); // -> o tratamento havia sido feito, entretanto na parte do calculo apenas;
        }                                                                             // para melhorar, implementar o tratamento na construçao da árvore, onde o codigo crasha
    }

    @Override
    Node getLeft() {
        return left;
    }

    @Override
    Node getRight() {
        return right;
    }

    @Override
    String getData() {
        return String.valueOf(operator);
    }
}
