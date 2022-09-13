package br.com.thymleaf.curso.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PEDIDOS")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private double valorProduto;

    @Column(nullable = false)
    private LocalDate dtEntrega;

    @Column(nullable = false)
    private String urlProduto;

    @Column(nullable = false)
    private String urlImagem;

    @Column(nullable = false)
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public LocalDate getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(LocalDate dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}