package com.mrfti.erp.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrfti.erp.domain.Cargo;
import com.mrfti.erp.domain.CategoriaProduto;
import com.mrfti.erp.domain.Cliente;
import com.mrfti.erp.domain.Endereco;
import com.mrfti.erp.domain.Funcionario;
import com.mrfti.erp.domain.ItemOrcamento;
import com.mrfti.erp.domain.MarcaVeicular;
import com.mrfti.erp.domain.ModeloVeicular;
import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Orcamento;
import com.mrfti.erp.domain.Os;
import com.mrfti.erp.domain.Pagamento;
import com.mrfti.erp.domain.PagamentoComBoleto;
import com.mrfti.erp.domain.PagamentoComCartao;
import com.mrfti.erp.domain.Produto;
import com.mrfti.erp.domain.Servico;
import com.mrfti.erp.domain.ServicoOrcamento;
import com.mrfti.erp.domain.ServicoOs;
import com.mrfti.erp.domain.Setor;
import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.domain.UnidadeMedida;
import com.mrfti.erp.domain.Veiculo;
import com.mrfti.erp.domain.Zona;
import com.mrfti.erp.domain.enums.EstadoPagamento;
import com.mrfti.erp.domain.enums.StatusOs;
import com.mrfti.erp.domain.enums.TipoCliente;
import com.mrfti.erp.domain.enums.Turno;
import com.mrfti.erp.repositories.CargoRepository;
import com.mrfti.erp.repositories.CategoriaProdutoRepository;
import com.mrfti.erp.repositories.ClienteRepository;
import com.mrfti.erp.repositories.EnderecoRepository;
import com.mrfti.erp.repositories.FuncionarioRepository;
import com.mrfti.erp.repositories.ItemOrcamentoRepository;
import com.mrfti.erp.repositories.MarcaVeicularRepository;
import com.mrfti.erp.repositories.ModeloVeicularRepository;
import com.mrfti.erp.repositories.MunicipioRepository;
import com.mrfti.erp.repositories.OrcamentoRepository;
import com.mrfti.erp.repositories.OsRepository;
import com.mrfti.erp.repositories.PagamentoRepository;
import com.mrfti.erp.repositories.ProdutoRepository;
import com.mrfti.erp.repositories.ServicoOrcamentoRepository;
import com.mrfti.erp.repositories.ServicoOsRepository;
import com.mrfti.erp.repositories.ServicoRepository;
import com.mrfti.erp.repositories.SetorRepository;
import com.mrfti.erp.repositories.UfRepository;
import com.mrfti.erp.repositories.UnidadeMedidaRepository;
import com.mrfti.erp.repositories.VeiculoRepository;
import com.mrfti.erp.repositories.ZonaRepository;
import com.mrfti.erp.domain.enums.Perfil;

@Service
public class DBService {

	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private UfRepository ufRepository;
	@Autowired
	private CategoriaProdutoRepository categoriaRepository;
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
	private OrcamentoRepository orcamentoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemOrcamentoRepository itemOrcamentoRepository;
	@Autowired
	private ServicoOrcamentoRepository servicoOrcamentoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private ServicoOsRepository servicoOsRepository;
	@Autowired
	private OsRepository osRepository;
	@Autowired
	private ZonaRepository zonaRepository;
	
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
		
		Produto produ1 = new Produto(null,"TUBO DE COBRE 28MM CLASSE E 5 MTS", (double)238.50 , cat2, uni1);
		Produto produ2 = new Produto(null, "Papel A4", (double) 70.01 , cat3, uni4);
		Produto produ3 = new Produto(null, "Diesel", (double)4.17 , cat2, uni2);
		
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
		Cliente cl1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", LocalDate.now(),  "213361-3200" , null , null , "1234" ,"02343342741", TipoCliente.PESSOAFISICA);
		Cliente cl2 = new Cliente(null, "Jurema Santos", "jurema@hotmail.com", LocalDate.of(2022, 2, 10), "21-9987-4321" , null , null , "123" ,"623.689.620-85", TipoCliente.PESSOAFISICA);
		
		
		// criando registro na tabela endereço
		Endereco e1 = new Endereco(null, "Av dos Italianos", "1146", "casa 28", "Coelho Neto", "21510-105", null ,cl1, mun1);
		Endereco e2 = new Endereco(null, "Rua Uranos", "96", null, "Olaria", "21511-145", null ,cl2, mun1);
				
		//Relacionando o cliente aos endereços
		cl1.getEnderecos().addAll(Arrays.asList(e2));
		cl2.getEnderecos().addAll(Arrays.asList(e1));		
		
		//salvando no banco
		clienteRepository.saveAll(Arrays.asList(cl1,cl2));
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
		Cargo ca3 = new Cargo(null, "Técnoco Gasista Senior");
		
		Zona zo1 = new Zona(null, "Zona Oeste");
		Zona zo2 = new Zona(null, "Zona Sul");
		
		
		Funcionario func1 = new Funcionario(null, "Vagner Moura", "vagner@gmail.com", LocalDate.of(2022, 04, 14), null , null , null ,"1234" ,"1266" , 'S', 'S', LocalDate.of(2022, 03, 01), null, "02343342741", "541258922" , null ,set1, ca1);
		func1.addPerfil(Perfil.ADMIN);
		Funcionario func2 = new Funcionario(null, "João da Silva", "joao@gmail.com", LocalDate.of(2022, 03, 29),"219871.1525" , null , null, "123" ,"1265" , 'S', 'S', LocalDate.of(2022, 03, 01), null, "71677752076", "3265222666" , null ,set1, ca1);
		
		Endereco e3 = new Endereco(null, "Av dos Italianos", "1196", null, "Coelho Neto", "21511-105", func1 , null, mun1);
		Endereco e4 = new Endereco(null, "Rua dos Prazeres", "69", null, "Coelho Neto", "21511-105", func2 , null, mun1);
		
		
		setorRepository.saveAll(Arrays.asList(set1,set2));
		cargoRepository.saveAll(Arrays.asList(ca1,ca2, ca3));
		zonaRepository.saveAll(Arrays.asList(zo1,zo2));
		
		func1.getEnderecos().addAll(Arrays.asList(e3));
		func2.getEnderecos().addAll(Arrays.asList(e4));
		
		funcionarioRepository.saveAll(Arrays.asList(func1,func2));
		enderecoRepository.saveAll(Arrays.asList(e3,e4));
		
		Date dataOrc = new Date();
		
		Orcamento orc1 = new Orcamento(null, 1, dataOrc, 'S', (double) 15, "Teste de inserção Orçamento", "Sr José", "Agradecemos a pref.", e2, set2 , func2, cl1);
		Orcamento orc2 = new Orcamento(null, 2, dataOrc, 'S', (double) 10, "Orçamento dois", "Juca", "Obrigado pela pref.", e1, set1, func1, cl2);
		
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, orc1, 6);
		orc1.setPagamento(pagto1);
		
		Date dataVenc = new Date();
		
		
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, orc2, dataVenc , null);
		orc2.setPagamento(pagto2);
		
		//associar o cliente ao orçamento
		cl1.getOrcamentos().addAll(Arrays.asList(orc1));
		cl2.getOrcamentos().addAll(Arrays.asList(orc2));
		
		orcamentoRepository.saveAll(Arrays.asList(orc1,orc2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemOrcamento iorc1 = new ItemOrcamento(orc1, produ1, (double) 10, 134.50, 3, 1);
		ItemOrcamento iorc2 = new ItemOrcamento(orc2, produ3, (double) 15, 41.00, 1, 2);
		ItemOrcamento iorc3 = new ItemOrcamento(orc1, produ2, (double) 15, 15.31, 5, 1);
		
		
		
		Servico serv1 = new Servico(null,"Conversao de fogão", 340.00);
		Servico serv2 = new Servico(null,"Teste de Estanqueidade", 90.45);
		
		ServicoOrcamento serOrc1 = new ServicoOrcamento(orc1, serv1, (double) 5, (double) 240.00, 1, 1);
		ServicoOrcamento serOrc2 = new ServicoOrcamento(orc1, serv2, (double) 0, (double) 90.45, 2, 1);
		
		servicoRepository.saveAll(Arrays.asList(serv1,serv2));
		servicoOrcamentoRepository.saveAll(Arrays.asList(serOrc1, serOrc2));
		
		
		
		//Associar os itens ao orcamento
		orc1.getItens().addAll(Arrays.asList(iorc1,iorc3));
		orc2.getItens().addAll(Arrays.asList(iorc2));
		//associando itens aos ItemOrcamento
		produ1.getItens().addAll(Arrays.asList(iorc1));
		produ3.getItens().addAll(Arrays.asList(iorc2));
		produ2.getItens().addAll(Arrays.asList(iorc3));
		
		itemOrcamentoRepository.saveAll(Arrays.asList(iorc1,iorc2, iorc3));
		
		//OS
		
		Os os1 = new Os(null, 1, LocalDate.of(2022, 3, 12), LocalDate.of(2022, 3, 8), LocalDate.of(2022, 3, 8), "Minha primeira OS no H2", 
				null, Turno.TARDE, StatusOs.ABERTO, func2, cl1, e2, set2, zo2);
		
		ServicoOs servOs1 = new ServicoOs(os1, serv2, 0, new BigDecimal(90.45), 1, 1);
		ServicoOs servOs2 = new ServicoOs(os1, serv1, 5, new BigDecimal(340.00), 1 , 1);
		
		//associar os servicos a OS
		os1.getServicos().addAll(Arrays.asList(servOs1,servOs2));
		
		//associar o cliente a OS
		cl1.getOs().addAll(Arrays.asList(os1));
		osRepository.saveAll(Arrays.asList(os1));
		servicoOsRepository.saveAll(Arrays.asList(servOs1, servOs2));
		
		
		
	}
}
