package com.empresa.funcionarios.principal;

import com.empresa.funcionarios.dados.DadosFuncionarios;
import com.empresa.funcionarios.servico.FuncionarioServico;
import java.time.Month;


public class Principal {
    public static void main(String[] args) {
        FuncionarioServico funcionarioServico = new FuncionarioServico();

        System.out.println("3.1 - Inserir todos os funcionários.");

        DadosFuncionarios.listaDeFuncionarios()
                .forEach(funcionario -> funcionarioServico.adicionarFuncionario(
                        funcionario.getNome(),
                        funcionario.getDataNascimento(),
                        funcionario.getSalario(),
                        funcionario.getFuncao()
                ));

        System.out.println("\nApós inserção:\n");

        funcionarioServico.imprimirFuncionarios();

        System.out.println("\n3.2 - Remover o funcionário 'João' da lista:");

        funcionarioServico.removerFuncionario("João");

        System.out.println("\nApós remoção:\n");

        funcionarioServico.imprimirFuncionarios();

        System.out.println("\n3.4 - Atualizar salário dos funcionários com 10% de aumento:");

        funcionarioServico.atualizarSalarioFuncionarios(10.0);

        System.out.println("\nApós aumento de salário:\n");

        funcionarioServico.imprimirFuncionarios();

        System.out.println("\n3.5 - Agrupar os funcionários por função (MAP):");

        funcionarioServico.funcionariosMAP();

        System.out.println("\n3.6 - Imprimir funcionários agrupados por função:\n");

        funcionarioServico.imprimirFuncionariosMAP(funcionarioServico.funcionariosMAP());

        System.out.println("\n3.8 - Imprimir funcionários que fazem aniversário em outubro e em dezembro:\n");

        funcionarioServico.imprimirFuncionariosMesEspecifico(Month.OCTOBER);
        funcionarioServico.imprimirFuncionariosMesEspecifico(Month.DECEMBER);

        System.out.println("\n3.9 - Imprimir o funcionário com a maior idade:\n");

        funcionarioServico.imprimirFuncionarioComAMaiorIdade();

        System.out.println("\n3.10 - Imprimir a lista de funcionários por ordem alfabética:\n");

        funcionarioServico.imprimirFuncionariosOrdemAlfabetica();

        System.out.println("\n3.11 - Imprimir o total de salários dos funcionários:\n");

        funcionarioServico.imprimirValorTotalSalarios();

        System.out.println("\n3.12 - Imprimir quantos salários mínimos ganha cada funcionário:\n");

        funcionarioServico.imprimirQntdSalarioMinimoPorFuncionario();
    }
}
