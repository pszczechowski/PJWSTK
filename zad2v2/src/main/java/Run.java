import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        DBManager con = new DBManager();


        DataManager db = new DataManager(con.establishConnection());
        AddDataManager add = new AddDataManager(con.establishConnection());
        Scanner sc = new Scanner(System.in);
        TvSeries tv;
        int number = -1;

        while(number != 0) {
            System.out.println("Wybierz jedną z operacji");
            System.out.println("1. Dodaj serial");
            System.out.println("2. Wyświetl informacje o serialu");
            System.out.println("0. Koniec");
            number = sc.nextInt();
            switch (number) {
                case 1:
                    add.addTvSeries();
                    add.addDirecotr(db);
                    add.addActor();
                    add.addSeason();
                    break;
                case 2: {
                    System.out.println("Wybierz serial o którym chcesz się więcej dowiedzieć");
                    System.out.println("Podaj jego ID");
                    db.getSeasonName();
                    int chose = sc.nextInt();
                    sc.nextLine();

                    System.out.println(db.getTvSeriesInfo(chose));
                    System.out.println(db.getDirectorInfo(chose));
                    System.out.println("Aktorzy: " + db.getActirInfo(chose).getActors());
                    System.out.println("Sezony: " + db.getSeasonInfo().getSeasons());
                    tv = db.getSeasonInfo();
                    System.out.println("Odcinki: " + db.getEpisodInfo(tv).getEpisodes());
                    break;
                }
                case 0:{
                    System.out.println("Do zobaczenia!");
                    break;
                }
                default: {
                    System.out.println("Błędny wybór");
                }
            }
        }
    }
}
