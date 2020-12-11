package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import exceptions.DomainExceptions;

public class Reservas {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions ("a data de check-out deve ser posterior à data de check-in");
		}	
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		// verifica a diferença em milissegundos
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		// converte os milissegundos para dias
	}

	public void datasAtualizadas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainExceptions ("as datas de reserva para atualização devem ser datas futuras");
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions ("a data de check-out deve ser posterior à data de check-in");

		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)	
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+" noites";
	}	

}
