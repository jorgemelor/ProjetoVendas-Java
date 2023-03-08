package RegistrandoVendas;

public class Venda {
    private Vendedor vendedor;
    private Produto produto;
    private double desconto, valor;
    private int quantidadedeItens;


    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadedeItens() {
        return quantidadedeItens;
    }

    public void setQuantidadedeItens(int quantidadedeItens) {
        this.quantidadedeItens = quantidadedeItens;
    }

    public void efetuarDesconto(double desconto) {
        this.desconto += valor * (desconto / 100);
        if ((this.produto.getValorVenda() - this.desconto) < produto.getValorCusto()) {
            System.out.println("XXXXX Impossível dar esse desconto pois irá causar um prejuízo XXXXX");
        } else {
            this.produto.setValorVenda(this.produto.getValorVenda() -(this.produto.getValorVenda() * this.desconto / 100));

        }
    }

    public void calcularValor() {
        valor = (produto.getValorVenda() * quantidadedeItens);
    }

    public void calcularComissao() {
        if (this.desconto != 0) {
            vendedor.setComissao(produto.getValorVenda() * vendedor.getComissao()/2);
        } else {
            vendedor.setComissao(produto.getValorVenda() * (vendedor.getComissao()));
        }
    }

    public void imprimir(){
        System.out.println("Vendedor: " + "\n Nome: "+ vendedor.getNome() + "\n Código: " + vendedor.getCodigo() + " \n Comissão: 5%");
        System.out.println("A quantidade de itens vendidos foi: " + quantidadedeItens);
        System.out.println("Produto: " + " \n Código: " + produto.getCodigo() + "\n Descrição: " + produto.getDescricao());
        System.out.println("O valor de venda do produto: " + produto.getValorVenda());
        System.out.println("O valor do desconto do produto é de: R$" + getDesconto());
        System.out.println("Valor total da venda será: " + valor);
        System.out.println("-----------------------------------------------------------------------");
    }
}