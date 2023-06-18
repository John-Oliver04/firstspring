package com.firstspring.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);

	}

	@GetMapping("/greet")
	public GreetResponse greet(){
		GreetResponse response = new GreetResponse("Hello", List.of("Java","PHP","Javascript"));
		return response;
	}

	@GetMapping("/person")
	public Person persondetails(){
		return new Person("Jhon");
	}

	class Person{
		private final String name;

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return name.equals(person.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}

	 class GreetResponse{
		private final String greet;
		private final List<String> Languages;

		 public GreetResponse(String greet, List<String> languages) {
			 this.greet = greet;
			 Languages = languages;

		 }

		 public String getGreet() {
			 return greet;
		 }


		 public List<String> getLanguages() {
			 return Languages;
		 }

		 @Override
		 public boolean equals(Object o) {
			 if (this == o) return true;
			 if (o == null || getClass() != o.getClass()) return false;
			 GreetResponse that = (GreetResponse) o;
			 return Objects.equals(greet, that.greet) &&
					 Objects.equals(Languages, that.Languages);
		 }

		 @Override
		 public int hashCode() {
			 return Objects.hash(greet, Languages);
		 }
	 }



}

