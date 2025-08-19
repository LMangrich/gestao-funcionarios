package com.empresa.funcionarios.servico;

import com.empresa.funcionarios.modelo.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

public interface IFuncionarioServico {
    void adicionarFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao);

    void removerFuncionario(String nome);

    void imprimirFuncionarios();

    void atualizarSalarioFuncionarios(Double porcentagemValor);

    Map<String, List<Funcionario>> funcionariosMAP();

    void imprimirFuncionariosMAP(Map<String, List<Funcionario>> funcionariosMap);

    void imprimirFuncionariosMesEspecifico(Month mes);

    void imprimirFuncionarioComAMaiorIdade();

    void imprimirFuncionariosOrdemAlfabetica();

    void imprimirValorTotalSalarios();

    void imprimirQntdSalarioMinimoPorFuncionario();
}
