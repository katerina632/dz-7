public enum Planet {
    MERCURY(1,0,2439.7,null),
    VENUS(2,51.23E6,4612.97,MERCURY),
    EARTH(3,41.4E6,6378,VENUS),
    MARS(4,79.63E6,9773,EARTH),
    JUPITER(5,548.77E6,33169.03,MARS),
    SATURN(6,591.79,58410,JUPITER),
    URANUS(7,1499.53E6,122330.15,SATURN),
    NEPTUNE(8,1618.68,191340.2,URANUS);

    private final int  ordinalNumberFromSun;

    private final double distanceFromPreviousPlanet;

    private final double distanceFromSun;

    private final double radius;

    private final Planet previousPlanet;

    public int getOrdinalNumberFromSun() {
        return ordinalNumberFromSun;
    }

    public double getDistanceFromPreviousPlanet() {
        return distanceFromPreviousPlanet;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public double getRadius() {
        return radius;
    }

    public Planet getPreviousPlanet() {
        return previousPlanet;
    }

    Planet(int ordinalNumberFromSun, double distanceFromPreviousPlanet, double radius, Planet previousPlanet) {
        this.ordinalNumberFromSun = ordinalNumberFromSun;
        this.distanceFromPreviousPlanet = distanceFromPreviousPlanet;
        this.distanceFromSun = previousPlanet != null ? previousPlanet.distanceFromSun + distanceFromPreviousPlanet : distanceFromPreviousPlanet;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
    }

    @Override
    public String toString() {
        return String.format("""
                        ~~~%s~~~
                        Ordinal number from Sun: %d
                        Distance from previous planet: %.0f km
                        Distance from Sun: %.0f km
                        Radius: %.0f km
                        Previous planet: %s
                        """, this.name(),ordinalNumberFromSun, distanceFromPreviousPlanet,
                distanceFromSun, radius, this.previousPlanet != null? this.previousPlanet.name():"None");
    }
}
