package com.kodilla.stream.sand;

import java.math.BigDecimal;

public final class Africa implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity(){
        BigDecimal sandQuantity = new BigDecimal("9999999990123456789");
        return sandQuantity;
    }
}
