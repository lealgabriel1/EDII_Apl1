/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494
*/

public class OperandNode extends Node {
    private float value;

    public OperandNode(float value) {
        this.value = value;
    }

    float getValue() {
    	return value;
    }
    
    @Override
    float visitar() {
        return value;
    }

    @Override
    Node getLeft() {
        return null;
    }

    @Override
    Node getRight() {
        return null;
    }

    @Override
    String getData() {
        return String.valueOf(value);
    }
}

