package com.practice.java.number2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * copy from effective java
 */
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, CHEESE, PEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            Objects.requireNonNull(topping);
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
