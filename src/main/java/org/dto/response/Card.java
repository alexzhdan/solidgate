package org.dto.response;

import lombok.Data;

@Data
public class Card {
    private String bank;
    private String bin;
    private String brand;
    private String card_exp_month;
    private int card_exp_year;
    private String card_holder;
    private String card_type;
    private String card_id;
    private String country;
    private String number;
    private CardToken card_token;
}
