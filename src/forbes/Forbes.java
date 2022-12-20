package forbes;

public class Forbes {
    private final int rank;
    private final String name;
    private final float networth;
    private final int age;
    private final String country;
    private final String source;
    private final String industry;

    public Forbes(int rank, String name, float networth, int age, String country, String source, String industry) {
        this.rank = rank;
        this.name = name;
        this.networth = networth;
        this.age = age;
        this.country = country;
        this.source = source;
        this.industry = industry;
    }

    public int getRank(){
        return rank;
    }

    public String getName(){
        return name;
    }

    public float getNetworth(){
        return networth;
    }

    public int getAge(){
        return age;
    }

    public String getCountry(){
        return country;
    }

    public String getSource(){
        return source;
    }

    public String getIndustry(){
        return industry;
    }

    @Override
    public String toString(){
        return "Forbes{" +
                "rank=" + rank +
                ", name='" + name.substring(0, name.length() - 1)+ '\'' +
                ", networth=" + networth +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", source='" + source + '\'' +
                ", industry='" + industry.substring(0, industry.length() - 1) + '\'' +
                '}';
    }
}
