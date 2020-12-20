package pojo;

import com.google.gson.annotations.SerializedName;


//ovo nam je POJO klasa koja u sebi sadrzi sve podatke koji su
//bitni za film, a to su naslov i ime direktora, ova klasa sadrzi
//dvije instance varijable koje su pod anotacijom @SerijlizedName
public class Film {

    //@SerialzedName --> podaci unutar ove aplikacije ce biti skinunti sa neta u
    //                   obliku JSON-a, a znamo vec kako izgleda JSON zapis, i onda
    //                   si zamislimo kako su zapisani objekti te svi ti objekti u
    //                   sebi sadrzavaju instance varijable, upravo ova anotacija nam
    //                   omogucava da upravljamo time kako ce se zvati te instance varijable
    //                   unutar JSON zapisa.Proces skidanja informacija objekt s neta i
    //                   prebacijavanje tih informacija u JSON zapis se naziva serijalizacija
    @SerializedName("title")
    public String title;

    @SerializedName("director")
    public String director;

}
