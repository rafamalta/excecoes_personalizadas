package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservas;
import exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);

			System.out.println();
			System.out.println("Informe a data para atualizar a reserva:");
			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservas.datasAtualizadas(checkIn, checkOut);
			System.out.println("Reservas: " + reservas);
		} 
		
		catch (ParseException e) {
			System.out.println("Formato de data invalido!");
		}
		
		catch (DomainExceptions e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

		sc.close();
	}
}