package com.trilha.back.financys;

import com.trilha.back.financys.entities.Category;
import com.trilha.back.financys.entities.Entry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancysApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinancysApplication.class, args);

		Category category = new Category(1, "Salário", "Recebimento de salário");

		Category category1 = new Category();
		category1.setId(2);
		category1.setDescription("Pagamento de Boletos");
		category1.setName("Pagamento");

		Entry entry = new Entry(1, 1,"Salário na Empresa X", "Adiantamento quinzenal",
				"revenue", "3.000", "15/09/2021",true);

		Entry entry1 = new Entry();
		entry1.setId(2);
		entry1.setCategoryId(2);
		entry1.setName("Salário da Empresa Y");
		entry1.setDescription("1° Parcela do salário do mês");
		entry1.setType("revenue");
		entry1.setAmount("3.000");
		entry1.setDate("01/09/2021");
		entry1.setPaid(true);

		System.out.println(category.toString());
		System.out.println(category1.toString());
		System.out.println(entry.toString());
		System.out.println(entry1.toString());
	}


}
