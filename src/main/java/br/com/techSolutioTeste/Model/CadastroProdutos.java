package br.com.techSolutioTeste.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_produtos", sequenceName = "seq_produtos", allocationSize = 1, initialValue = 1)
public class CadastroProdutos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produtos")
	private Long idProduto;
	
	private String nomeProduto;
	private String fornecedorProduto;
	private float valorProduto;
	
	
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getFornecedorProduto() {
		return fornecedorProduto;
	}
	public void setFornecedorProduto(String fornecedorProduto) {
		this.fornecedorProduto = fornecedorProduto;
	}
	public float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	
}
