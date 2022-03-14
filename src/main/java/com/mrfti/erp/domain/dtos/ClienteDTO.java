package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.enums.TipoCliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	
	//Atributos da entidade Pessoa
		protected Integer id;
		protected String nome;
		
		protected String email;
		
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate dataInclusao = LocalDate.now();
	
		//atributo cliente
		private TipoCliente tipoCliente;
		
		
		public ClienteDTO() {
		}


		public ClienteDTO(Cliente obj) {
			this.id = obj.getId();
			this.nome = obj.getNome();
			this.email = obj.getEmail();
			this.dataInclusao = obj.getDataInclusao();
			this.tipoCliente = obj.getTipoCliente();
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public LocalDate getDataInclusao() {
			return dataInclusao;
		}


		public void setDataInclusao(LocalDate dataInclusao) {
			this.dataInclusao = dataInclusao;
		}


		public TipoCliente getTipoCliente() {
			return tipoCliente;
		}


		public void setTipoCliente(TipoCliente tipoCliente) {
			this.tipoCliente = tipoCliente;
		}
		
		
}
