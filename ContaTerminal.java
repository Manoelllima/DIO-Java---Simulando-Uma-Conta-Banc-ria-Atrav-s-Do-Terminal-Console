import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            Conta conta = null;
            String opcao = "0";
            boolean login = false;
            String cpfConsulta = "";
            while (true) {
                if (opcao.equals("0")) {
                    System.out.println("Por favor, digite uma opcao: ");
                    System.out.println("1 - Criar conta");
                    System.out.println("2 - Consultar");
                    opcao = scanner.nextLine();                    
                }

                switch (opcao) {
                    case "1":
                        System.out.println("Por favor, digite o seu nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Por favor, digite o seu CPF: ");
                        String CPF = scanner.nextLine();

                        conta = new Conta(nome, CPF);
                        System.out.println("Ola " + conta.nomeCliente
                                + ", obrigado por criar uma conta em nosso banco, sua agencia e " + conta.agencia
                                + ", conta " + conta.numero + " e seu saldo " + conta.getSaldo()
                                + " ja esta disponivel para saque");
                        opcao = "0";
                        break;

                    case "2":
                        if (login == false) {
                            System.out.println("Por favor, digite o seu CPF para consulta: ");
                            cpfConsulta = scanner.nextLine();
                            login = true;

                        }
                        if (conta == null || !conta.CPF.equals(cpfConsulta)) {
                            System.out.println("Conta nao encontrada para o CPF informado.");
                            opcao = "0";
                            login = false;

                        } else {
                            System.out.println("Bem-vindo, " + conta.nomeCliente + "!");
                            System.out.println("Por favor, digite uma opcao: ");
                            System.out.println("1 - Depositar");
                            System.out.println("2 - Consultar saldo");
                            System.out.println("3 - Sair");
                            String opcaoConsulta = scanner.nextLine();
                            if (opcaoConsulta.equals("1")) {
                                System.out.println("Por favor, digite o valor a ser depositado: ");
                                double valor = scanner.nextDouble();
                                conta.depositar(valor);
                            } else if (opcaoConsulta.equals("2")) {
                                System.out.println("Seu saldo e: " + conta.getSaldo());
                            } else if (opcaoConsulta.equals("3")) {
                                System.out.println("Obrigado por usar nosso banco!");
                                login = false;
                                opcao = "0";
                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        }

    }
}

class Conta {
    final int numero;
    final String agencia = "067-8";
    final String nomeCliente;
    final String CPF;
    private double saldo = 0;

    public Conta(String nomeCliente, String CPF) {
        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.numero = (int) (Math.random() * 9000) + 1000;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

}