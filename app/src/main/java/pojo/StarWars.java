package pojo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

//ova klasa nam je zapravo POJO klasa u kojoj imamo neke podatke koji su nam
//potrebni za aplikaciju, unutar nje imamo jos jednu inner(nested) klasu naziva
//People u koju pohranjujemo instance varijable
public class StarWars {

    //ovdje smo napravili objekt result tipa List u koji ce se pohranjivati oni
    //podaci koji su tipa People, odnosno oni koji se nalaze unutar People klase
    public List<People> results = null;

    //@SerializedName --> ovu anotaciju koristimo ako zelimo da prikazemo ime instance
    //                    varijable unutar serijaliziranog podatka na drugaciji nacin od
    //                    onoga kojeg smo mi naveli.Parametar kod ove anotacije
    //                    nam predstavlja ono ime koje ce biti u JSON zapisu.Zamislimo si
    //                    kako izgleda JSON zapis i svaki atribut unutar tog JSON zapisa
    //                    mora biti predan kao parametar ove anotacije.Zbog toga sto ove
    //                    podatke uzimamo s neta oni moraju biti serijalizirani pa zatim
    //                    deserijalizirani
    //ovo nam je inner(nested) klasa People unutar koje imamo instance varijable
    //koje nam predstavljaju podatke koje pojedina osoba iz StarWars-a ima
    public class People{
        @SerializedName("name")
        public String name;
        @SerializedName("height")
        public String height;
        @SerializedName("mass")
        public String mass;
        @SerializedName("birth_year")
        public String birthYear;
        @SerializedName("gender")
        public String gender;
        @SerializedName("homeworld")
        public String homeworld;
        @SerializedName("films")
        public List<String> films = null;
    }

}
