package br.usjt.javaweatherforecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.javaweatherforecast.model.Forecast;

public interface ForecastRepository extends JpaRepository<Forecast, Long>{

}
