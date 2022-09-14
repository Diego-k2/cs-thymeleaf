package br.com.thymleaf.curso.model.dto;

import br.com.thymleaf.curso.model.entity.PedidoModel;

import javax.validation.constraints.NotBlank;

public class PedidoDto {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlImagem;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoModel toPedido(){
        PedidoModel pedidoModel = new PedidoModel();

        pedidoModel.setNomeProduto(this.nomeProduto);
        pedidoModel.setDescricao(this.descricao);
        pedidoModel.setUrlImagem(this.urlImagem);
        pedidoModel.setUrlProduto(this.urlProduto);

        return pedidoModel;
    }

}
