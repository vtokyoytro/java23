import java.util.Objects;

/**
 * Автор класы. Set<Author> ішінде қайталануды болдырмау үшін
 * equals() және hashCode() әдістері іске асырылған.
 */
public class Author {
    private final String name;
    private final String country;

    public Author(String name, String country) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Автордың аты бос болмауы керек!");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Ел аты бос болмауы керек!");
        }
        this.name = name.trim();
        this.country = country.trim();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    // Екі автор аты мен елі бірдей болса, тең деп саналады
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author other = (Author) o;
        return name.equalsIgnoreCase(other.name) && country.equalsIgnoreCase(other.country);
    }

    // equals() қолданған өрістер бойынша ғана hashCode есептеледі
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), country.toLowerCase());
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}
