package com.grepp.coffeemanager.domain.multilingual.payment;

import java.util.List;

public class Multilingual {
    
    private static final List<Language> languages =
        List.of(Language.CHINA, Language.SPAIN);
    
    public static List<Language> languages(){
        return languages;
    }
}
