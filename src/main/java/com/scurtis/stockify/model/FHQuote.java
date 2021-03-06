package com.scurtis.stockify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FHQuote {

    @JsonProperty("o")
    private Double open;

    @JsonProperty("c")
    private Double close;

    @JsonProperty("h")
    private Double high;

    @JsonProperty("l")
    private Double low;

    @JsonProperty("pc")
    private Double previousClose;

    @JsonProperty("t")
    private Integer total;

}
