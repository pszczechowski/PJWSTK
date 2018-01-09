package pl.edu.pjwstk.mpr.tvserials;


import pl.edu.pjwstk.mpr.tvserials.Director.Director;
import pl.edu.pjwstk.mpr.tvserials.Director.DirectorManager;

import java.util.Scanner;

public class appControl {

        public void controlLoop(){
            Scanner sc = new Scanner(System.in);
            DirectorManager dm = new DirectorManager();

            int controler = 0;
            boolean finish = false;

            while(!finish) {
                System.out.println("Określ co chcedsz zrobić");
                System.out.println("Dodaj reżysera - 1");
                System.out.println("Usuń wszystkich reżyserów - 2");
                System.out.println("Wyświetl wszystkich reżyserów - 3");
                System.out.println("Wyjście - 0");
                controler = sc.nextInt();
                sc.nextLine();


                switch (controler) {
                    case 0:
                        finish = true;
                        break;
                    case 1:
                        Director d = new Director();
                        System.out.println("Podaj Nazwisko reżysera");
                        d.setName(sc.nextLine());
                        System.out.println("Podaj rok urodzenia reżysera");
                        d.setDateOfBirth(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Opisz biografie");
                        d.setBiography(sc.nextLine());
                        dm.addDirector(d);
                        break;
                    case 2:
                        dm.clearPersons();
                        break;
                    case 3:
                        dm.getAllDirectors();
                        break;
                    default:
                        System.out.println("Błędna wartość");
                }
            }
        }
}
