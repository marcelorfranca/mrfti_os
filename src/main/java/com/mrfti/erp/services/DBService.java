package com.mrfti.erp.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Cargo;
import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.Habilitacao;
import com.mrfti.erp.domain.MarcaVeicular;
import com.mrfti.erp.domain.ModeloVeicular;
import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.domain.UnidadeMedida;
import com.mrfti.erp.domain.Veiculo;
import com.mrfti.erp.domain.enums.CategoriaCnh;
import com.mrfti.erp.domain.enums.TipoCliente;
import com.mrfti.erp.repositories.CargoRepository;
import com.mrfti.erp.repositories.CategoriaRepository;
import com.mrfti.erp.repositories.ClienteRepository;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.repositories.FuncionarioRepository;
import com.mrfti.erp.repositories.HabilitacaoRepository;
import com.mrfti.erp.repositories.MarcaVeicularRepository;
import com.mrfti.erp.repositories.ModeloVeicularRepository;
import com.mrfti.erp.repositories.MunicipioRepository;
import com.mrfti.erp.repositories.ProdutoRepository;
import com.mrfti.erp.repositories.SetorRepository;
import com.mrfti.erp.repositories.UfRepository;
import com.mrfti.erp.repositories.UnidadeMedidaRepository;
import com.mrfti.erp.repositories.VeiculoRepository;

@Service
public class DBService {

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
	@Autowired
	private MarcaVeicularRepository marcaVeicularRepository;
	@Autowired
	private ModeloVeicularRepository  modeloVeicularRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private SetorRepository setorRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private HabilitacaoRepository habilitacaoRepository;
	
	
	public void instanciaDB() {
		
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
		Cliente cl1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", LocalDate.now() , "02343342741", TipoCliente.PESSOAFISICA);
		
		cl1.getTelefones().addAll(Arrays.asList("219814.5821", "219741.2129"));
		
		// criando registro na tabela endereço
		Endereco e1 = new Endereco(null, "Av dos Italianos", "1146", "casa 28", "Coelho Neto", "21510-105", cl1, mun1);
		Endereco e2 = new Endereco(null, "Rua Uranos", "96", null, "Olaria", "21511-145", cl1, mun1);
				
		//Relacionando o cliente aos endereços
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		//salvando no banco
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	
		
		// criando instancia veiculares até funcionario
		MarcaVeicular marca1 = new MarcaVeicular(null,"Fiat");
		MarcaVeicular marca2 = new MarcaVeicular(null,"Honda");
		
		ModeloVeicular modelo1 = new ModeloVeicular(null, "Fiat Uno 1.0", marca1);
		ModeloVeicular modelo2 = new ModeloVeicular(null, "Honda Civic 2.0", marca2);
		ModeloVeicular modelo3 = new ModeloVeicular(null, "Fiorino 1.0", marca1);
		
		Veiculo veic1 = new Veiculo(null,"DLC1254", "PRATA", 2018, "54125428632654" , "111452998887222", 11268, 'S', "Carro recebido sem problemas", modelo1, null);
		Veiculo veic2 = new Veiculo(null,"FRT1254", "BRANCO", 2015, "511115428632654" , "854452992117222", 31268, 'S', "Carro batido e recuperado", modelo2, null);
		
		
		marcaVeicularRepository.saveAll(Arrays.asList(marca1, marca2));
		modeloVeicularRepository.saveAll(Arrays.asList(modelo1, modelo2, modelo3));
		veiculoRepository.saveAll(Arrays.asList(veic1, veic2));
		
		
		Setor set1 = new Setor(null, "Operacional");
		Setor set2 = new Setor(null, "Almoxarifado");
		
		Cargo ca1 = new Cargo(null, "Analista de Suporte");
		Cargo ca2 = new Cargo(null, "Programador");
		
		//Habilitacao hab1 = new Habilitacao(null, "ETC215214", LocalDate.of(2025, 8, 25), null, CategoriaCnh.A);
		//Habilitacao hab2 = new Habilitacao(null, "SAA2111", LocalDate.of(2026, 3, 16), null, CategoriaCnh.E);
		Habilitacao hab1 = new Habilitacao(null, "ATC62369D", LocalDate.of(2024, 9, 28), null, CategoriaCnh.C);
		
		
		setorRepository.saveAll(Arrays.asList(set1,set2));
		cargoRepository.saveAll(Arrays.asList(ca1,ca2));
		habilitacaoRepository.saveAll(Arrays.asList(hab1, hab1));
		
		
		
		//Funcionario func1 = new Funcionario(null, "João da Silva", "joao@gmail.com", "01/03/2022", "1265", 'S', 'S', "15/03/2022", null, "02343342741", null, null, null);
		Funcionario func2 = new Funcionario(null, "João da Silva", "joao@gmail.com", LocalDate.of(2022, 03, 29), "1265" , 'S', 'S', LocalDate.of(2022, 03, 01), null, "02343342741", set1, ca1, hab1);
		
		funcionarioRepository.saveAll(Arrays.asList(func2));
		
	}
}
