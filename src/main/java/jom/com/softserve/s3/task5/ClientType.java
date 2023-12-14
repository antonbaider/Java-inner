package jom.com.softserve.s3.task5;

public enum ClientType {
    NEW(1) {
        @Override
        public double discount() {
            return 1.0;
        }
    },
    SILVER(12) {
        @Override
        public double discount() {
            return (100 - getMonths() * 0.25) / 100.0;
        }
    },
    GOLD(30) {
        @Override
        public double discount() {
            return (100 - getMonths() * 0.3) / 100.0;
        }
    },
    PLATINUM(60) {
        @Override
        public double discount() {
            return (100 - getMonths() * 0.35) / 100.0;
        }
    };

    private final int months;

    ClientType(int months) {
        this.months = months;
    }

    public int getMonths() {
        return months;
    }

    public abstract double discount();

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}