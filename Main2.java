package RegistrandoVendas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    private static Scanner read = new Scanner(System.in);
    private static Scanner texto = new Scanner(System.in);
    private static Vendedor [] vendedores = new Vendedor[10];
    private static Produto [] produtos = new Produto[10];
    private static Venda [] vendas = new Venda[10];
    private static int vendedorcount = 0;
    private static int produtocount = 0;
    private static int vendacount=0;
    private static double vendaValor;
    public static void cadastrarVendedor(){
        try {
            int z = vendedorcount;
            Scanner read = new Scanner(System.in);
            System.out.println("Digite o nome do vendedor a ser cadastrado: ");
            String name = texto.nextLine();
            System.out.println("Digite o endereço do vendedor a ser cadastrado: ");
            String adress = texto.nextLine();
            System.out.println("Digite o codigo do vendedor a ser cadastrado: ");
            int code = read.nextInt();
            vendedores [z] = new Vendedor(name,adress,code);
            vendedorcount ++;
            vendedores[z].setComissao(10);
            System.out.println("Vendedor cadastrado!");
        }catch(Exception e){
            System.out.println("Digite as informações corretamente!\n");

        }


    };

    public static void cadastrarProduto(){
        try {
            int f = produtocount;
            System.out.println("Informe o código do produto: ");
            int code = Integer.parseInt(texto.nextLine());
            System.out.println("Descrição do produto: ");
            String desc = texto.nextLine();
            System.out.println("Valor de venda: ");
            vendaValor = Double.parseDouble(texto.nextLine().replaceAll( "," , "."));
            System.out.println("Valor de custo: ");
            double valorCusto = Double.parseDouble(texto.nextLine().replaceAll( "," , "."));

            produtos[f] = new Produto(code, desc, vendaValor, valorCusto);
            produtocount ++;
            System.out.println("Produto cadastrado!");
        }catch(Exception e){
            System.out.println("Digite as informações corretamente!\n");
        }
    }
    public static void cadastrarVenda() {
        try {
            int y = vendacount;
            vendas[y] = new Venda();
            vendas[y].setVendedor(vendedores[y]);
            vendas[y].setProduto(produtos[y]);
            System.out.println("Quantidade do produto: ");
            int quant = Integer.parseInt(texto.nextLine());
            System.out.println("Digite 1 se o produto ESTÁ em promoção e 2 se NÃO está em promoção");
            int prom = read.nextInt();
            double d = 0;
            if (prom == 1) {
                System.out.println("% de desconto:");
                d = read.nextDouble();
                vendas[y].setDesconto(d);
                if (d > 0) {
                    vendas[y].efetuarDesconto(d);
                    System.out.println("Venda registrada!");
                }
            }
            else if(prom == 2){}
            else{
                System.out.println("Digite um valor válido!");
            }
            vendas[y].setQuantidadedeItens(quant);
            vendas[y].calcularValor();
            vendacount++;
        }catch (Exception e){
            System.out.println("Digite as informações corretamente!\n");}
    }
    public static void imprimirVenda(){
        try{
            System.out.println("-_-_-_-_-_-_Registros de vendas-_-_-_-_-_-_");
            for (int a = 0; a <= vendacount; a++) {
                System.out.println("\nVendedor: " + (vendedores[a].getNome()));
                System.out.println("Endereço: " + (vendedores[a].getEndereco()));
                System.out.println("Comissão da venda: R$" + ((vendedores[a].getComissao()/100) * vendas[a].getValor()));
                System.out.println("Código do vendedor: " + (vendedores[a].getCodigo()));
                System.out.println("\nProduto vendido:\n");
                System.out.println("Código do produto:" + (produtos[a].getCodigo()));
                System.out.println("Descrição: " + (produtos[a].getDescricao()));
                System.out.println("Valor do produto(UNI): R$" + (vendaValor));
                System.out.println("Valor da venda: R$" + (vendas[a].getValor()));
                System.out.println("Valor do desconto: R$" + ((vendaValor*vendas[a].getQuantidadedeItens())-vendas[a].getValor()));
                System.out.println("Quantidade de itens: " + (vendas[a].getQuantidadedeItens()));
                System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            }
        }catch(Exception e){
            System.out.println();
        }
    }


    public static void main(String[] args) {

        while (true) {

            try {
                System.out.println("-_-_-_-_-_-_ Menu Registrando Vendas _-_-_-_-_-_-");
                System.out.println("\n Digite 1 para cadastrar um vendedor\n Digite 2 para cadastrar um produto\n Digite 3 para cadastrar venda\n Digite 4 para imprimir a venda\n Para encerrar o programa digite 100");
                int option = Integer.parseInt(texto.nextLine());
                switch (option) {
                    case 1:
                        cadastrarVendedor();
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        cadastrarVenda();
                        break;
                    case 4:
                        imprimirVenda();
                        break;
                    case 100:
                        System.exit(0);
                    default:
                        System.out.println("\n|    Opção inválida! Tente novamente!    |\n");
                }
            }catch(Exception e){
                System.out.println("Ops algo deu errado!");

            }
        }
    }
}







