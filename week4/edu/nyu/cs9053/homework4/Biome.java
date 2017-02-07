package edu.nyu.cs9053.homework4;

public enum Biome{

Equatorial("always moist, little temperature seasonality"),
Tropical("summer rainy season and cooler “winter” dry season"),
Subtropical("highly seasonal, arid climate"),
Mediterranean("winter rainy season and summer draught"),
Warmtemperate("occasional frost, often with summer rainfall maximum"),
Nemoral("moderate climate with winter freezing"),
Continental("arid, with warm or hot summers and cold winters"),
Boreal("cold temperate with cool summers and longer winters"),
Polar("short, cool summers and long, cold winters");

private final String description;

Biome(String cons_Description){
    this.description=cons_Description;
}

public String getDescription(){
    return description;
}

public static void printBiome(Biome ... objs){
    int count=0;
    for(Biome obj:Biome.values()){
        if(count<objs.length && objs[count]==obj){
            System.out.println(obj.getDescription());
            count++;

        }
    }
}
}
