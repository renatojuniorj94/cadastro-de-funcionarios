import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarios {

    static double salarioBase = 2000.0;

    static ArrayList<String> tipos = new ArrayList<>();
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> matriculas = new ArrayList<>();

    static ArrayList<Double> vendas = new ArrayList<>();
    static ArrayList<Double> percentuais = new ArrayList<>();

    static ArrayList<Integer> quantidadesPecas = new ArrayList<>();
    static ArrayList<Double> valoresPeca = new ArrayList<>();

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {

            exibirMenu();

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarPadrao();
                    break;

                case 2:
                    cadastrarComissionado();
                    break;

                case 3:
                    cadastrarProducao();
                    break;

                case 4:
                    exibirFuncionarios();
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static void exibirMenu() {

        System.out.println("\n===== MENU =====");
        System.out.println("1 - Funcionário Padrão");
        System.out.println("2 - Funcionário Comissionado");
        System.out.println("3 - Funcionário de Produção");
        System.out.println("4 - Exibir Funcionários");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static boolean matriculaExiste(int matricula) {

        int i = 0;

        while (i < matriculas.size()) {

            if (matriculas.get(i) == matricula) {
                return true;
            }

            i++;
        }

        return false;
    }

    public static void cadastrarPadrao() {

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        int matricula = entrada.nextInt();
        entrada.nextLine();

        if (matriculaExiste(matricula)) {
            System.out.println("\nERRO: Matrícula já cadastrada.");
            return;
        }

        tipos.add("PADRAO");
        nomes.add(nome);
        matriculas.add(matricula);

        vendas.add(0.0);
        percentuais.add(0.0);
        quantidadesPecas.add(0);
        valoresPeca.add(0.0);

        System.out.println("Funcionário padrão cadastrado.");
    }

    public static void cadastrarComissionado() {

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        int matricula = entrada.nextInt();

        if (matriculaExiste(matricula)) {
            System.out.println("\nERRO: Matrícula já cadastrada.");
            entrada.nextLine();
            return;
        }

        System.out.print("Valor total de vendas: ");
        double venda = entrada.nextDouble();

        System.out.print("Percentual de comissão: ");
        double percentual = entrada.nextDouble();

        entrada.nextLine();

        tipos.add("COMISSIONADO");
        nomes.add(nome);
        matriculas.add(matricula);

        vendas.add(venda);
        percentuais.add(percentual);

        quantidadesPecas.add(0);
        valoresPeca.add(0.0);

        System.out.println("Funcionário comissionado cadastrado.");
    }

    public static void cadastrarProducao() {

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Matrícula: ");
        int matricula = entrada.nextInt();

        if (matriculaExiste(matricula)) {
            System.out.println("\nERRO: Matrícula já cadastrada.");
            entrada.nextLine();
            return;
        }

        System.out.print("Quantidade de peças produzidas: ");
        int quantidade = entrada.nextInt();

        System.out.print("Valor por peça: ");
        double valorPeca = entrada.nextDouble();

        entrada.nextLine();

        tipos.add("PRODUCAO");
        nomes.add(nome);
        matriculas.add(matricula);

        quantidadesPecas.add(quantidade);
        valoresPeca.add(valorPeca);

        vendas.add(0.0);
        percentuais.add(0.0);

        System.out.println("Funcionário de produção cadastrado.");
    }

    public static void exibirFuncionarios() {

        System.out.println("\n===== RELATÓRIO =====");
        System.out.println("Quantidade de funcionários cadastrados: "
                + nomes.size());

        if (nomes.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        int i = 0;

        while (i < nomes.size()) {

            double salarioFinal = salarioBase;

            System.out.println("\n------------------------");
            System.out.println("Nome: " + nomes.get(i));
            System.out.println("Matrícula: " + matriculas.get(i));
            System.out.println("Salário Base: R$ " + salarioBase);

            if (tipos.get(i).equals("PADRAO")) {

                System.out.println("Tipo: Funcionário Padrão");

            } else if (tipos.get(i).equals("COMISSIONADO")) {

                double comissao = vendas.get(i) * percentuais.get(i) / 100;

                salarioFinal += comissao;

                System.out.println("Tipo: Funcionário Comissionado");
                System.out.println("Comissão: R$ " + comissao);

            } else if (tipos.get(i).equals("PRODUCAO")) {

                double produtividade = quantidadesPecas.get(i)
                        * valoresPeca.get(i);

                salarioFinal += produtividade;

                System.out.println("Tipo: Funcionário de Produção");
                System.out.println("Produtividade: R$ "
                        + produtividade);
            }

            System.out.println("Salário Final: R$ "
                    + salarioFinal);

            i++;
        }
    }
}