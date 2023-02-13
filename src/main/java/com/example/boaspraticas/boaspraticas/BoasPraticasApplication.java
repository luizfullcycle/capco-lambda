package com.example.boaspraticas.boaspraticas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class BoasPraticasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BoasPraticasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Integer> numeros = Arrays.asList(1,1,2,3,4,5,8,7,10,9);
        List<String> nomes = Arrays.asList("Luiz","Fernandes","Oliveira","Neto","Cid","Moreira");
        Integer numero = null;
        List<Integer> add = new ArrayList<>();

		//*=============== SKIP =========================*/
		numeros.stream().skip(1).forEach((e) -> System.out.println(e));

		//*=============== LIMIT =========================*/
		numeros.stream().limit(2).forEach(e -> System.out.println(e));

		//*=============== DISTINCT =========================*/
		numeros.stream().distinct().forEach(e -> System.out.println(e));

		//*=============== FILTER =========================*/
		numeros.stream().filter(i -> i % 2 == 0).forEach(e -> System.out.println(e));


		// ================ AVG ==============================
		Double media = numeros.stream().collect(Collectors.averagingInt(n -> n.intValue()));

		// ====================== SUM ===============================
		Integer soma = numeros.stream().collect(Collectors.summingInt(n -> n.intValue()));

		IntSummaryStatistics summaryStatistics = numeros.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		summaryStatistics.getAverage();
		summaryStatistics.getCount();
		summaryStatistics.getMax();
		summaryStatistics.getMin();
		summaryStatistics.getSum();

		// *=============== COUNT =========================*/
        long count = numeros.stream().count();
		System.out.println(count);

		// *=============== MIN =========================*/
        Optional<Integer> min = numeros.stream().min(Comparator.naturalOrder());
		System.out.println(min.get());

		// *=============== MAX =========================*/
		Optional<Integer> max = numeros.stream().max(Comparator.naturalOrder());
		System.out.println(max.get());

		// *=============== JOIN =========================*/
        String nome =  nomes.stream().collect(Collectors.joining(","));
	  	System.out.println(nome);

		// *=============== SORT =========================*/
		List<String> name =  nomes.stream().sorted().collect(Collectors.toList());
		System.out.println(name);

		// *=============== NULLABLE - OPTIONAL =========================*/
		Optional<Integer> numeroOptional = Optional.ofNullable(numero);
		numeroOptional.ifPresent(e -> System.out.println(e));

		// *=============== NULLABLE - orElse =========================*/
		Optional<Integer> number = Optional.ofNullable(numero);
		number.orElse(2);

		// *=============== NULLABLE - orElseTrhow =========================*/
		Optional<Integer> numberThrow = Optional.ofNullable(numero);
		numberThrow.orElseThrow(()-> new NullPointerException("Numero vazio"));

	}


}
