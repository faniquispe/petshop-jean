package br.edu.ifms.lojapets.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.lojapets.model.Cliente;
import br.edu.ifms.lojapets.model.Pet;
import br.edu.ifms.lojapets.model.Petshop;
import br.edu.ifms.lojapets.model.Servico;
import br.edu.ifms.lojapets.repository.ClienteRepository;
import br.edu.ifms.lojapets.repository.PetRepository;
import br.edu.ifms.lojapets.repository.PetshopRepository;
import br.edu.ifms.lojapets.repository.ServicoRepository;

@Service
public class DBService {

	@Autowired
	private ClienteRepository cliente;
	
	@Autowired
	private PetRepository pet;
	
	@Autowired
	private PetshopRepository petshop;
	
	@Autowired
	private ServicoRepository servico;
	
	public void instantiateTestDatabase() throws ParseException{
		
		Petshop petshop1 = new Petshop(null, "Petshop chows", "27.846.457/0001-78");
		Petshop petshop2 = new Petshop(null, "Clinica veterinaria", "68.415.568/0001-07");
		Petshop petshop3 = new Petshop(null, "Grol pets", "87.428.376/0001-80");
		Petshop petshop4 = new Petshop(null, "Petshop Bem-Estar", "32.927.192/0001-72");
		Petshop petshop5 = new Petshop(null, "Petshop lar dos pets", "57.451.279/0001-47");
		
		Cliente cli1 = new Cliente(null, "185.287.159-74", "Fani", petshop1);
		Cliente cli2 = new Cliente(null, "257.258.974-85", "Mario", petshop3);
		Cliente cli3 = new Cliente(null, "999.580.002-85", "Ana Paula", petshop2);
		Cliente cli4 = new Cliente(null, "758.258.287-74", "Octavio", petshop5);
		Cliente cli5 = new Cliente(null, "178.577.999-14", "Jose Luis", petshop4);
		Cliente cli6 = new Cliente(null, "222.145.330-75", "Fernando", petshop5);
		Cliente cli7 = new Cliente(null, "111.252.353-01", "Joao Luis", petshop2);
		Cliente cli8 = new Cliente(null, "002.359.387-01", "Paulo Cesar", petshop1);
		Cliente cli9 = new Cliente(null, "248.695.478-30", "Barbara", petshop3);
		Cliente cli10 = new Cliente(null, "994.330.961-37", "Karina", petshop4);
		
		Pet pet1 = new Pet(null, "Thor", "ChowChow", "25/05/2020", "Cao", "Macho", cli1);//
		Pet pet2 = new Pet(null, "Skipe", "Beagle", "15/01/2017", "Cao", "Macho", cli5);//
		Pet pet3 = new Pet(null, "Linda", "Bichon frisé", "01/02/2015", "Cao", "Femea", cli2);//
		Pet pet4 = new Pet(null, "Pretinha", "Bobtail Japones", "25/02/2017", "Gato", "Femea", cli6);//
		Pet pet5 = new Pet(null, "Suicida", "Bobtail Japones", "15/07/2021", "Gato", "Femea", cli1);//
		Pet pet6 = new Pet(null, "Hulk", "Bulmastife", "28/05/2020", "Cao", "Macho", cli4);
		Pet pet7 = new Pet(null, "Diana", "Poodle", "06/03/2018", "Cao", "Femea", cli10); //
		Pet pet8 = new Pet(null, "Lua", "Shihtzu", "30/03/2021", "Cao", "Femea", cli7);//
		Pet pet9 = new Pet(null, "Flor", "Rottweiler", "29/07/2020", "Cao", "Femea", cli3);//
		Pet pet10 = new Pet(null, "Pele", "Chihuahua", "11/02/2020", "Cao", "Macho", cli9);//
		Pet pet11 = new Pet(null, "Felix", "Dobermann", "31/09/2022", "Cao", "Macho", cli8);//
		Pet pet12 = new Pet(null, "Nicky", "Balines", "17/06/2015", "Gato", "Macho", cli4);//
		Pet pet13 = new Pet(null, "Cinderela", "Persa", "20/05/2019", "Gato", "Femea", cli8);//
		
		
		Servico serv1 = new Servico(null, "Banho e Tosa", "20/07/2022", 160.0f, pet1, cli1); 
		Servico serv2 = new Servico(null, "Banho e Tosa Máquina", "15/06/2022", 151.0f, pet3, cli5); 
		Servico serv3 = new Servico(null, "Banho e Hidratação", "10/05/2022", 121.0f, pet11, cli8);  
		Servico serv4 = new Servico(null, "Banho e Tosa Tesoura", "05/05/2022", 170.0f, pet8, cli7 ); 
		Servico serv5 = new Servico(null, "Banho e Hidratação", "11/04/2022", 121.0f, pet12, cli4);  
		Servico serv6 = new Servico(null, "Banho e Corte de Unhas", "06/04/2022", 151.0f, pet2, cli5); 
		Servico serv7 = new Servico(null, "Banho e Tosa Tesoura", "01/04/2022", 170.0f, pet13, cli8); 
		Servico serv8 = new Servico(null, "Banho", "29/03/2022", 110.0f, pet5, cli1);
		Servico serv9 = new Servico(null, "Banho e Tosa Tesoura", "26/03/2022", 170.0f, pet7, cli10); 
		Servico serv10 = new Servico(null, "Banho e Hidratação", "25/03/2022", 121.0f, pet10, cli9); 
		Servico serv11 = new Servico(null, "Banho e Hidratação", "23/03/2022", 121.0f, pet9, cli3); 
		Servico serv12 = new Servico(null, "Banho e Hidratação", "21/03/2022", 121.0f, pet4, cli6); 
		Servico serv13 = new Servico(null, "Banho e Corte de Unhas", "20/03/2022", 151.0f, pet6, cli4);

		
		//lista
		petshop1.getClientes().addAll(Arrays.asList(cli1,cli5, cli7));
		petshop2.getClientes().addAll(Arrays.asList(cli4, cli2, cli6));
		petshop3.getClientes().addAll(Arrays.asList(cli9, cli8, cli3));
		petshop4.getClientes().addAll(Arrays.asList(cli10, cli1, cli6));
		petshop5.getClientes().addAll(Arrays.asList(cli4, cli8, cli5));
		
		
		
		//imprimir
		petshop.saveAll(Arrays.asList(petshop1,petshop2,petshop3,petshop4,petshop5));
		cliente.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9,cli10));
		pet.saveAll(Arrays.asList(pet1,pet2,pet3,pet4,pet5,pet6,pet7,pet8,pet9,pet10,pet11,pet12,pet13));
		servico.saveAll(Arrays.asList(serv1,serv2,serv3,serv4,serv5,serv6,serv7,serv8,serv9,serv10,serv11,serv12,serv13));
		


		
	}
}
