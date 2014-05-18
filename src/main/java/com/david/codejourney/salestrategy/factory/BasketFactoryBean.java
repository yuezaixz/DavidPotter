package com.david.codejourney.salestrategy.factory;

import com.david.codejourney.salestrategy.basket.IBasketFactory;
import com.david.codejourney.salestrategy.basket.PotterBasketFactory;

public class BasketFactoryBean {
    
    
    private static IBasketFactory potterBasketFactory;
    
    public static IBasketFactory getPotterBasketFactoryInstance(){
        if(potterBasketFactory == null){
            synchronized (BasketFactoryBean.class) {
                if(potterBasketFactory == null){
                    potterBasketFactory = new PotterBasketFactory();
                }
            }
        }
        return potterBasketFactory;
    }

}
