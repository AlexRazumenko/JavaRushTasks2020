package task3702;

import task3702.female.FemaleFactory;
import task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory (HumanFactoryType type) {
        switch (type) {
            case FEMALE: return new FemaleFactory();
            case MALE:return new MaleFactory();
            default: return null;
        }
    }
}
