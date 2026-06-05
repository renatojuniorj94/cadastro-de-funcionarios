import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarios {

    static final double SALARIO_BASE = 2000.0;

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

    public static void cadastrarPadrao() {

        tipos.add("PADRAO");

        System.out.print("Nome: ");
        nomes.add(entrada.nextLine());

        System.out.print("Matrícula: ");
        matriculas.add(entrada.nextInt());
        entrada.nextLine();

        vendas.add(0.0);
        percentuais.add(0.0);
        quantidadesPecas.add(0);
        valoresPeca.add(0.0);

        System.out.println("Funcionário padrão cadastrado.");
    }

    public static void cadastrarComissionado() {

        tipos.add("COMISSIONADO");

        System.out.print("Nome: ");
        nomes.add(entrada.nextLine());

        System.out.print("Matrícula: ");
        matriculas.add(entrada.nextInt());

        System.out.print("Valor total de vendas: ");
        vendas.add(entrada.nextDouble());

        System.out.print("Percentual de comissão: ");
        percentuais.add(entrada.nextDouble());

        entrada.nextLine();

        quantidadesPecas.add(0);
        valoresPeca.add(0.0);

        System.out.println("Funcionário comissionado cadastrado.");
    }

    public static void cadastrarProducao() {

        tipos.add("PRODUCAO");

        System.out.print("Nome: ");
        nomes.add(entrada.nextLine());

        System.out.print("Matrícula: ");
        matriculas.add(entrada.nextInt());

        System.out.print("Quantidade de peças produzidas: ");
        quantidadesPecas.add(entrada.nextInt());

        System.out.print("Valor por peça: ");
        valoresPeca.add(entrada.nextDouble());

        entrada.nextLine();

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

            double salarioFinal = SALARIO_BASE;

            System.out.println("\n------------------------");
            System.out.println("Nome: " + nomes.get(i));
            System.out.println("Matrícula: " + matriculas.get(i));
            System.out.println("Salário Base: R$ " + SALARIO_BASE);

            if (tipos.get(i).equals("PADRAO")) {

                System.out.println("Tipo: Funcionário Padrão");

            } else if (tipos.get(i).equals("COMISSIONADO")) {

                double comissao =
                        vendas.get(i) * percentuais.get(i) / 100;

                salarioFinal += comissao;

                System.out.println("Tipo: Funcionário Comissionado");
                System.out.println("Comissão: R$ " + comissao);

            } else if (tipos.get(i).equals("PRODUCAO")) {

                double produtividade =
                        quantidadesPecas.get(i)
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