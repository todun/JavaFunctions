package com.todun.utils.requirement.three;

/**
 * Builder for {@link RequirementThree}
 */
public class RequirementThreeBuilder {
    /**
     * {@link RequirementThree#base}
     */
    private int base = 0;

    /**
     * {@link RequirementThree#height}
     */
    private int height = 0;

    /**
     * {@link RequirementThree#hypotenuse}
     */
    private int hypotenuse = 0;

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #base}
     *
     * @param base {@link #base}
     * @return {@link RequirementThreeBuilder} with a {@link #base}
     */
    public RequirementThreeBuilder setBase(int base) {
        this.base = base;
        return this;
    }

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #height}
     *
     * @param height {@link #height}
     * @return {@link RequirementThreeBuilder} with a {@link #height}
     */
    public RequirementThreeBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * Create a {@link RequirementThreeBuilder} with a {@link #hypotenuse}
     *
     * @param hypotenuse {@link #hypotenuse}
     * @return {@link RequirementThreeBuilder} with a {@link #hypotenuse}
     */
    public RequirementThreeBuilder setHypotenuse(int hypotenuse) {
        this.hypotenuse = hypotenuse;
        return this;
    }

    /**
     * Builds an instance of {@link RequirementThree}.
     * To be used only after {@link RequirementThree}'s instance variables have been initialised {@link #base},
     * {@link #height}, {@link #hypotenuse}
     *
     * @return a built instance of {@link RequirementThree}
     */
    public RequirementThree build() {
        return new RequirementThree(base, height, hypotenuse);
    }
}