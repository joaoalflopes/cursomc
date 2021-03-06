package com.example.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Cidade;
import com.example.cursomc.domain.Cliente;
import com.example.cursomc.domain.Endereco;
import com.example.cursomc.domain.Estado;
import com.example.cursomc.domain.ItemPedido;
import com.example.cursomc.domain.Pagamento;
import com.example.cursomc.domain.PagamentoComBoleto;
import com.example.cursomc.domain.PagamentoComCartao;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.domain.enums.EstadoPagamento;
import com.example.cursomc.domain.enums.TipoCliente;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.repositories.EnderecoRepository;
import com.example.cursomc.repositories.EstadoRepository;
import com.example.cursomc.repositories.ItemPedidoRepository;
import com.example.cursomc.repositories.PagamentoRepository;
import com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Escolar");
		Categoria cat4 = new Categoria(null, "Embalagens");
		Categoria cat5 = new Categoria(null, "Coffee Break");
		Categoria cat6 = new Categoria(null, "Equipamentos para Rede");
		Categoria cat7 = new Categoria(null, "Higiene e Limpeza");
		Categoria cat8 = new Categoria(null, "Gamers");
		Categoria cat9 = new Categoria(null, "Organizacao");
		Categoria cat10 = new Categoria(null, "Automacao");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		
		Produto p1 = new Produto(null, "Impressora", 1200.00);
		Produto p2 = new Produto(null, "Notebook Asus i3", 1900.00);
		Produto p3 = new Produto(null, "Grampeador Mappe mini", 35.00);
		Produto p4 = new Produto(null, "Agendas Semanais", 18.00);
		Produto p5 = new Produto(null, "Tonner HP3450", 395.00);
		Produto p6 = new Produto(null, "Caderno Universitario 20Mat", 65.00);
		Produto p7 = new Produto(null, "Lapis Preto B2", 3.50);
		Produto p8 = new Produto(null, "Caneta Esferografica 1.0 Preta", 6.75);
		Produto p9 = new Produto(null, "Marca Texto VerdeLim", 9.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p5));
		cat2.getProdutos().addAll(Arrays.asList(p3,p4,p5,p9));
		cat3.getProdutos().addAll(Arrays.asList(p6,p7,p8,p9));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat3));
		p9.getCategorias().addAll(Arrays.asList(cat2,cat3));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
		
		Estado est1 = new Estado(null, "São Paulo", "SP");
		Estado est2 = new Estado(null, "Minas Gerais", "MG");
		Estado est3 = new Estado(null, "Rio de Janeiro", "RJ");
		
		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "São Vicente", est1);
		Cidade c3 = new Cidade(null, "Belo Horizonte", est2);
		Cidade c4 = new Cidade(null, "Rio de Janeiro", est3);
		Cidade c5 = new Cidade(null, "Santos", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1,c2,c5));
		est2.getCidades().addAll(Arrays.asList(c3));
		est3.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
		Cliente cli1 = new Cliente(null, "Maria Helena P.Lopes", "mariahelen@gmail.com", "07210559488", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Joao Alfredo P.Lopes", "joaoalfredo_lopes@yahoo.com.br", "08769488835", TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Simoes & Barreira SC Ltda", "simoesbarra@gmail.com", "05755751000131", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("13991138797", "1332281406"));
		cli2.getTelefones().addAll(Arrays.asList("13991236336", "13981328480"));
		cli3.getTelefones().addAll(Arrays.asList("1332281809", "1332281810"));
		
		Endereco end1 = new Endereco(null, "Rua Anadir Dias de Carvalho", "586", "Casa", "Joquei Clube", "11450-515", cli1, c2);
		Endereco end2 = new Endereco(null, "Rua Governador Pedro de Toledo", "56", "Apto 95", "Boqueirao", "11045-550", cli2, c5);
		Endereco end3 = new Endereco(null, "Rua Anadir Dias de Carvalho", "586", "-", "Joquei Clube", "11450-515", cli2, c2);
		Endereco end4 = new Endereco(null, "Avenida Dona Ana Costa", "413", "Conj.45", "Gonzaga", "11230-101", cli3, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		cli2.getEnderecos().addAll(Arrays.asList(end2,end3));
		cli3.getEnderecos().addAll(Arrays.asList(end4));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("31/03/2020 11:40"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/04/2020 22:35"), cli2, end2);
		Pedido ped3 = new Pedido(null, sdf.parse("02/04/2020 13:15"), cli3, end4);
		Pedido ped4 = new Pedido(null, sdf.parse("03/04/2020 09:23"), cli2, end3);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 4);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("06/04/2020 00:00"), null);
		ped2.setPagamento(pagto2);
		
		Pagamento pagto3 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped3, sdf.parse("06/04/2020 00:00"), sdf.parse("07/04/2020 00:00"));
		ped3.setPagamento(pagto3);
		
		Pagamento pagto4 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped4, 6);
		ped4.setPagamento(pagto4);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		cli2.getPedidos().addAll(Arrays.asList(ped2,ped4));
		cli3.getPedidos().addAll(Arrays.asList(ped3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3, pagto4));
		
		ItemPedido iped1 = new ItemPedido(ped1, p1, 15.00, 1, 1200.00);
		ItemPedido iped2 = new ItemPedido(ped1, p5, 0.00, 2, 395.00);
		ItemPedido iped3 = new ItemPedido(ped3, p7, 0.00, 3, 3.50);
		ItemPedido iped4 = new ItemPedido(ped3, p8, 0.30, 5, 6.75);
		ItemPedido iped5 = new ItemPedido(ped3, p9, 0.00, 2, 9.00);
		ItemPedido iped6 = new ItemPedido(ped2, p2, 0.00, 1, 1900.00);
		ItemPedido iped7 = new ItemPedido(ped4, p4, 0.00, 1, 18.00);
		ItemPedido iped8 = new ItemPedido(ped4, p8, 0.30, 6 , 6.75);
		
		ped1.getItens().addAll(Arrays.asList(iped1, iped2));
		ped2.getItens().addAll(Arrays.asList(iped6));
		ped3.getItens().addAll(Arrays.asList(iped3, iped4, iped5));
		ped4.getItens().addAll(Arrays.asList(iped7, iped8));
	
		itemPedidoRepository.saveAll((Arrays.asList(iped1, iped2, iped3, iped4, iped5, iped6, iped7, iped8)));
		
	}
	

}
