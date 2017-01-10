package com.todun.utils.requirement.three;

import java.math.BigDecimal;

/**
 * Builder for {@link RequirementThree}
 */
public class RequirementThreeBuilder {
    /**
     * {@link RequirementThree#sideA}
     */
    private BigDecimal sideA = BigDecimal.ZERO;

    /**
     * {@link RequirementThree#sideB}
     */
    private BigDecimal sideB = BigDecimal.ZERO;

    /**
     * {@link RequirementThree#sideC}
     */
    private BigDecimal sideC = BigDecimal.ZERO;

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #sideA}
     *
     * @param sideA {@link #sideA}
     * @return {@link RequirementThreeBuilder} with a {@link #sideA}
     */
    public RequirementThreeBuilder setSideA(BigDecimal sideA) {
        this.sideA = sideA;
        return this;
    }

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #sideB}
     *
     * @param sideB {@link #sideB}
     * @return {@link RequirementThreeBuilder} with a {@link #sideB}
     */
    public RequirementThreeBuilder setSideB(BigDecimal sideB) {
        this.sideB = sideB;
        return this;
    }

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #sideC}
     *
     * @param sideC {@link #sideC}
     * @return {@link RequirementThreeBuilder} with a {@link #sideC}
     */
    public RequirementThreeBuilder setSideC(BigDecimal sideC) {
        this.sideC = sideC;
        return this;
    }

    /**
     * Builds an instance of {@link RequirementThree}.
     * To be used only after {@link RequirementThree}'s instance variables have been initialised {@link #sideA},
     * {@link #sideB}, {@link #sideC}
     *
     * @return a built instance of {@link RequirementThree}
     */
    public RequirementThree build() {
        return new RequirementThree(sideA, sideB, sideC);
    }
}
