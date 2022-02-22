package com.mrfti.erp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mrfti.erp.domain.Municipio;
import com.mrfti.erp.domain.Uf;
import com.mrfti.erp.repositories.MunicipioRepository;
import com.mrfti.erp.repositories.UfRepository;

@SpringBootApplication
public class MrftiOsApplication implements CommandLineRunner {

	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private UfRepository ufRepository;
	
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
		
		
	}

}
