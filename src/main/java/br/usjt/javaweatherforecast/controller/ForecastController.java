package br.usjt.javaweatherforecast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.javaweatherforecast.model.Forecast;
import br.usjt.javaweatherforecast.repository.ForecastRepository;
import br.usjt.javaweatherforecast.service.ForecastService;

@Controller
public class ForecastController {

	@Autowired
	private ForecastService forecastService;
	
	@GetMapping("/weather")
	public ModelAndView listForecast() {
		
		// no construtor: nome da página
		ModelAndView mv = new ModelAndView("weather");
		
		List<Forecast> forecasts = forecastService.listarTodos();
		
		mv.addObject("forecasts", forecasts);
		mv.addObject(new Forecast());
		
		// retorno de ModelAndView obrigatório
		return mv;
	}
	
	@PostMapping("/weather")
	public String saveForecast (Forecast forecast) {
		forecastService.salvar(forecast);
		return "redirect:/weather";
	}
}
