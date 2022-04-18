package com.mrfti.erp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.enums.Perfil;
import com.mrfti.erp.domain.enums.TipoCliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	//Atributos da entidade Pessoa
		protected Integer id;
		
		@NotNull(message = "Campo Nome é requerido")
		@Length(min=5, max=120, message="O nome deve ser entre 5 e 120 caracteres")
		protected String nome;
		
		@NotNull(message = "Campo EMAIL é requerido")
		protected String email;
		
		@NotNull(message = "Campo Telefone é requerido")
		protected String telefone1;
		protected String telefone2;
		protected String telefone3;
		
		@NotNull(message = "Campo Senha é requerido")
		@Length(min=3, max=15, message="A senha deve ser entre 3 e 15 caracteres")
		protected String senha;
		
		protected Set<Integer> perfis  = new HashSet<>(); 
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		protected LocalDate dataInclusao = LocalDate.now();
		
		//atributo cliente
		@NotNull(message = "Campo CPF/CNPJ é requerido")
		private String cpfOrCnpj;
		
		@NotNull(message = "Campo Tipo Cliente é requerido")
		private TipoCliente tipoCliente;
		
		//Atributos entidade endereço
		@NotEmpty(message="Preenchimento obrigatório")
		private String logradouro;
		@NotEmpty(message="Preenchimento obrigatório")
		private String numero;
		private String complemento;
		@NotEmpty(message="Preenchimento obrigatório")
		private String bairro;
		private String cep;
		
		private Integer enderecoId;
		
		private Integer municipioId;
		
		private Integer perfil1;
		
		private Integer perfil2;
		private Integer perfil3;
		private Integer perfil4;
		
		
		public ClienteDTO() {
			super();
			addPerfil(Perfil.CLIENTE);
		}


		public ClienteDTO(Cliente obj) {
			this.id = obj.getId();
			this.nome = obj.getNome();
			this.email = obj.getEmail();
			this.dataInclusao = obj.getDataInclusao();
			this.telefone1 = obj.getTelefone1();
			this.telefone2 = obj.getTelefone2();
			this.telefone3 = obj.getTelefone3();
			this.senha = obj.getSenha();
			this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
			this.cpfOrCnpj = obj.getCpfOrCnpj();
			this.tipoCliente = obj.getTipoCliente();
			addPerfil(Perfil.CLIENTE);
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


		public String getTelefone1() {
			return telefone1;
		}


		public void setTelefone1(String telefone1) {
			this.telefone1 = telefone1;
		}


		public String getTelefone2() {
			return telefone2;
		}


		public void setTelefone2(String telefone2) {
			this.telefone2 = telefone2;
		}


		public String getTelefone3() {
			return telefone3;
		}


		public void setTelefone3(String telefone3) {
			this.telefone3 = telefone3;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		
		public Set<Perfil> getPerfis() {
			return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
		}

		public void addPerfil(Perfil perfil) {
			this.perfis.add(perfil.getCodigo());
		}
		
		public String getCpfOrCnpj() {
			return cpfOrCnpj;
		}

		public void setCpfOrCnpj(String cpfOrCnpj) {
			this.cpfOrCnpj = cpfOrCnpj;
		}

		public String getLogradouro() {
			return logradouro;
		}


		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}


		public String getNumero() {
			return numero;
		}


		public void setNumero(String numero) {
			this.numero = numero;
		}


		public String getComplemento() {
			return complemento;
		}


		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}


		public String getBairro() {
			return bairro;
		}


		public void setBairro(String bairro) {
			this.bairro = bairro;
		}


		public String getCep() {
			return cep;
		}


		public void setCep(String cep) {
			this.cep = cep;
		}


		public Integer getEnderecoId() {
			return enderecoId;
		}


		public void setEnderecoId(Integer enderecoId) {
			this.enderecoId = enderecoId;
		}


		public Integer getMunicipioId() {
			return municipioId;
		}


		public void setMunicipioId(Integer municipioId) {
			this.municipioId = municipioId;
		}


		public Integer getPerfil1() {
			return perfil1;
		}


		public void setPerfil1(Integer perfil1) {
			this.perfil1 = perfil1;
		}


		public Integer getPerfil2() {
			return perfil2;
		}


		public void setPerfil2(Integer perfil2) {
			this.perfil2 = perfil2;
		}


		public Integer getPerfil3() {
			return perfil3;
		}


		public void setPerfil3(Integer perfil3) {
			this.perfil3 = perfil3;
		}


		public Integer getPerfil4() {
			return perfil4;
		}


		public void setPerfil4(Integer perfil4) {
			this.perfil4 = perfil4;
		}
		
		
		
		
}
