package br.com.andre.msscbeerinventoryservice.events;

import br.com.andre.msscbeerinventoryservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = 5769432483433890163L;

    private BeerDto beerDto;

}
