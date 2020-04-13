package br.usjt.javaweatherforecast.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.javaweatherforecast.model.Forecast;
import br.usjt.javaweatherforecast.repository.ForecastRepository;

@Service
public class ForecastService {
	@Autowired
	private ForecastRepository forecastRepository;

	public void salvar(Forecast forecast) {
		forecastRepository.save(forecast);
	}

	public List<Forecast> listarTodos() {
		List<Forecast> forecasts = forecastRepository.findAll();
		DateFormat fromDatabase = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss");
		DateFormat toUser = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");		
		for(Forecast forecast: forecasts) {
			try {				
				forecast.setDateTime(toUser.format(fromDatabase.parse(forecast.getDateTime())));
			} catch(Exception e) {
				System.out.println("Conversion error on ForecastService, dude: " + e.getMessage());
			}
		}
		return forecasts;
	}
}