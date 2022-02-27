package com.mrfti.erp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.domain.UnidadeMedida;
import com.mrfti.erp.domain.enums.TipoCliente;
import com.mrfti.erp.repositories.CategoriaRepository;
import com.mrfti.erp.repositories.ClienteRepository;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.repositories.MunicipioRepository;
import com.mrfti.erp.repositories.ProdutoRepository;
import com.mrfti.erp.repositories.UfRepository;
import com.mrfti.erp.repositories.UnidadeMedidaRepository;

@SpringBootApplication
public class MrftiOsApplication implements CommandLineRunner {

	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private UfRepository ufRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MrftiOsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// instanciando para popular o banco para teste
		Uf u1 = new Uf(null, "Rio de Janeiro", "RJ");
		Uf u2 = new Uf(null, "São Paulo", "SP");
		Uf u3 = new Uf(null, "Rio Grande do Sul", "RS");
		
		Municipio mun1 = new Municipio(null, "Santa Cruz", u1);
		Municipio mun2 = new Municipio(null, "Cajamar", u2);
		Municipio mun3 = new Municipio(null, "Curitiba", u3);
		Municipio mun4 = new Municipio(null, "Jandira", u2);
		
		u1.getMunicipios().addAll(Arrays.asList(mun1));
		u2.getMunicipios().addAll(Arrays.asList(mun2, mun4));
		u3.getMunicipios().addAll(Arrays.asList(mun3));
		
		// para salvar no banco
		
		ufRepository.saveAll(Arrays.asList(u1,u2,u3));
		municipioRepository.saveAll(Arrays.asList(mun1,mun2,mun3,mun4));
		
		
		// instanciar dados de Produto, Categoria e Unidade de medida
		
		UnidadeMedida uni1 = new UnidadeMedida(null, "Peça");
		UnidadeMedida uni2 = new UnidadeMedida(null, "Litro");
		UnidadeMedida uni3 = new UnidadeMedida(null, "Metro");
		UnidadeMedida uni4 = new UnidadeMedida(null, "Unidade");
		
		CategoriaProduto cat1 = new CategoriaProduto(null, "Ferramental");
		CategoriaProduto cat2 = new CategoriaProduto(null, "Gas");
		CategoriaProduto cat3 = new CategoriaProduto(null, "Escritório");
		
		Produto produ1 = new Produto(null,"TUBO DE COBRE 28MM CLASSE E 5 MTS", new BigDecimal(238.50) , cat2, uni1);
		Produto produ2 = new Produto(null, "Papel A4", new BigDecimal(70.01) , cat3, uni4);
		Produto produ3 = new Produto(null, "Diesel", new BigDecimal(4.17) , cat2, uni2);
		
		cat2.getProdutos().addAll(Arrays.asList(produ1));
		cat3.getProdutos().addAll(Arrays.asList(produ2));
		
		uni1.getProdutos().addAll(Arrays.asList(produ1));
		uni2.getProdutos().addAll(Arrays.asList(produ3));
		uni4.getProdutos().addAll(Arrays.asList(produ2));
				
		
		//salvar no banco
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		unidadeMedidaRepository.saveAll(Arrays.asList(uni1,uni2,uni3,uni4));
		produtoRepository.saveAll(Arrays.asList(produ1, produ2, produ3));
		
		// criando o CLiente
		Cliente cl1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", LocalDate.now() , "02343342741", TipoCliente.PESSOAFISICA.getCodigo());
		
		cl1.getTelefones().addAll(Arrays.asList("219814.5821", "219741.2129"));
		
		// criando registro na tabela endereço
		Endereco e1 = new Endereco(null, "Av dos Italianos", "1146", "casa 28", "Coelho Neto", "21510-105", cl1, mun1);
		Endereco e2 = new Endereco(null, "Rua Uranos", "96", null, "Olaria", "21511-145", cl1, mun1);
				
		//Relacionando o cliente aos endereços
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		//salvando no banco
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
