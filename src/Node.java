/*
APL1 - ÁRVORE BINÁRIA DE EXPRESSÃO ARITMETICA
ESTRUTURA DE DADOS II

ALUNO: GABRIEL LEAL LEONE
TURMA: 04N11
RA: 10402494
*/

public abstract class Node {
    float visitar() {
        return Float.NaN; // valor padrão, os nós operadores vão sobrescrever isso
    }

    abstract Node getLeft();
    abstract Node getRight();
    abstract String getData();
}

