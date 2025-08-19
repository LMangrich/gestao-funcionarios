package com.empresa.funcionarios.servico;

import com.empresa.funcionarios.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioServico implements IFuncionarioServico {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final BigDecimal salarioMinimo = new BigDecimal("1212.00");

    @Override
    public void adicionarFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        boolean existe = funcionarios.stream()
                .anyMatch(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));

        if (existe) {
            System.out.println("Funcionário com o nome " + nome + " já existe!");
            return;
        }

        Funcionario funcionario = new Funcionario(nome, dataNascimento, salario, funcao);

        funcionarios.add(funcionario);
        System.out.println("Funcionário " + nome + " adicionado com sucesso!");
    }

    @Override
    public void removerFuncionario(String nome) {
        boolean removido = funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));

        if (!removido) {
            System.out.println("Nenhum funcionário encontrado com o nome: " + nome);
        } else {
            System.out.println("Funcionário " + nome + " removido com sucesso!");
        }
    }

    @Override
    public void imprimirFuncionarios() {
        funcionarios.forEach(funcionario -> System.out.println(formatarDadosFuncionario(funcionario, true)));
    }

    @Override
    public void atualizarSalarioFuncionarios(Double porcentagemValor) {
        if (porcentagemValor == null) {
            System.out.println("Porcentagem inválida.");
            return;
        }

        BigDecimal fator = BigDecimal.valueOf(porcentagemValor)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                .add(BigDecimal.ONE);

        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario()
                    .multiply(fator);

            funcionario.setSalario(novoSalario);
        });
    }

    @Override
    public Map<String, List<Funcionario>> funcionariosMAP() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    @Override
    public void imprimirFuncionariosMAP(Map<String, List<Funcionario>> funcionariosMap) {
        funcionariosMap.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> System.out.println("  " + formatarDadosFuncionario(funcionario, false)));
        });
    }

    @Override
    public void imprimirFuncionariosMesEspecifico(Month mes) {
        funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonth().equals(mes))
                .forEach(funcionario -> System.out.println(formatarDadosFuncionario(funcionario, true)));
    }

    @Override
    public void imprimirFuncionarioComAMaiorIdade() {
        funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(funcionario -> {
                    int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.println(funcionario.getNome() + " | Idade: " + idade);
                });
    }

    @Override
    public void imprimirFuncionariosOrdemAlfabetica() {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(formatarDadosFuncionario(funcionario, true)));
    }

    @Override
    public void imprimirValorTotalSalarios() {
        BigDecimal valorTotalSalario = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            valorTotalSalario = valorTotalSalario.add(funcionario.getSalario());
        }

        System.out.println("Valor total dos salários: " + valorTotalSalario);
    }

    @Override
    public void imprimirQntdSalarioMinimoPorFuncionario() {
        funcionarios.forEach(funcionario -> {
            BigDecimal qntdSalarios = funcionario.getSalario().divide(salarioMinimo, MathContext.DECIMAL64);

            qntdSalarios = qntdSalarios.setScale(4, RoundingMode.HALF_UP);

            System.out.println(funcionario.getNome() + " recebe " + qntdSalarios + " salários mínimos.");
        });
    }

    // FUNÇÃO AUXILIAR

    private String formatarDadosFuncionario(Funcionario funcionario, boolean incluirFuncao){
        String dataFormatada = funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

        String salarioFormatado = numberFormat.format(funcionario.getSalario());

        if (incluirFuncao) {
            return funcionario.getNome() + " | " + dataFormatada + " | " + salarioFormatado + " | " + funcionario.getFuncao();
        } else {
            return funcionario.getNome() + " | " + dataFormatada + " | " + salarioFormatado;
        }
    }
}
