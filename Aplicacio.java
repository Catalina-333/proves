// SNAILS - Tomeu, Alex, Vicenç, Catalina.

import java.util.Scanner; // Importar Scanner per poder llegir per teclat.

public class Aplicacio {
    static Aplicacio app = new Aplicacio(); // Crear objecte.
    // Inicialització de les variables.
    String txt_triar, txt_jugar, txt_idioma, txt_instruccions, txt_sortir, txt_jugador, txt_empat, txt_guanyar,
            txt_perdreta, txt_guanyarfinal, txt_perdrefinal, txt_ronda, txt_resultat, txt_tornarajugar, txt_tornarmenu,
            txt_continuar, txt_haselegit, txt_haelegit, txt_instrucciolinea1, txt_instrucciolinea2,
            txt_instrucciolinea3, txt_instrucciolinea4, txt_rondesjugades, resultat, txt_resultatfinal;
    String[] idiomes = { null, "CATALA", "ESPA\u00d1OL", "ENGLISH" }; // Crea un array pels texts d'idiomes.
    String[] seleccio = new String[4]; // Crea un array del 0 al 3. Utilitzam de l'1 al 3 per les variables de text "Pedra", "Paper" i "Tisora".
    int menu, instruccions, menujoc, victoriesjugador, victoriesmaquina, rondes, elecciojugador, elecciomaquina = 0;
    int idioma = 1;
    Scanner teclat;

    public static void main(String[] args) {
        app.iniciarMenu();
    }

    void clearScreen() { // Funció per rentar pantalla.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void iniciarMenu() { // Funció menú.
        switch (idioma) { // Comprova el valor de la variable idioma i selecciona l'idioma elegit o el seleccionat per defecte (1 - Català).
            case 1: { // Idioma català. Traducció del text de les variables a català (Per defecte).
                seleccio[1] = "PEDRA";
                seleccio[2] = "PAPER";
                seleccio[3] = "TISORA";
                txt_triar = "Elegeix una opcio: ";
                txt_jugar = "JUGAR";
                txt_idioma = "IDIOMA";
                txt_instruccions = "INSTRUCCIONS";
                txt_sortir = "SORTIR";
                txt_jugador = "Jugador";
                txt_empat = "Heu empatat.";
                txt_guanyar = "Has guanyat la ronda.";
                txt_perdre = "Has perdut la ronda.";
                txt_guanyarfinal = "HAS GUANYAT";
                txt_perdrefinal = "HAS PERDUT";
                txt_ronda = "RONDA";
                txt_resultat = "RESULTAT";
                txt_tornarajugar = "TORNAR A JUGAR";
                txt_tornarmenu = "TORNAR AL MENU";
                txt_continuar = "CONTINUAR";
                txt_haselegit = "Has elegit";
                txt_haelegit = "ha elegit";
                txt_rondesjugades = "Rondes jugades";
                txt_instrucciolinea1 = "Selecciona Pedra, Paper o Tisora.";
                txt_instrucciolinea2 = "La Pedra guanya a la Tisora - La Tisora guanya al Paper - El Paper guanya a la Pedra.";
                txt_instrucciolinea3 = "En cas d'empat es jugara de nou sense cap canvi en els resultats si encara no heu passat la 3a ronda.";
                txt_instrucciolinea4 = "Es juga al millor de 3, en cas de d'arribar a la tercera ronda, guanyara el primer en guanyar la proxima ronda.";
                break;
            }
            case 2: { // Idioma castellà. Traducció del text de les variables a castellà.
                seleccio[1] = "PIEDRA";
                seleccio[2] = "PAPEL";
                seleccio[3] = "TIJERA";
                txt_triar = "Elige una opcion: ";
                txt_jugar = "JUGAR";
                txt_idioma = "IDIOMA";
                txt_instruccions = "INSTRUCCIONES";
                txt_sortir = "SALIR";
                txt_jugador = "Jugador";
                txt_empat = "Has empatado.";
                txt_guanyar = "Has ganado la ronda.";
                txt_perdre = "Has perdido la ronda.";
                txt_guanyarfinal = "HAS GANADO";
                txt_perdrefinal = "HAS PERDIDO";
                txt_ronda = "RONDA";
                txt_resultat = "RESULTADO";
                txt_tornarajugar = "VOLVER A JUGAR";
                txt_tornarmenu = "VOLVER AL MENU";
                txt_continuar = "CONTINUAR";
                txt_haselegit = "Has elegido";
                txt_haelegit = "ha elegido";
                txt_rondesjugades = "Rondas jugadas";
                txt_instrucciolinea1 = "Selecciona Piedra, Papel o Tijera.";
                txt_instrucciolinea2 = "La Piedra gana a la Tijera - La Tijera gana al Papel - El Papel gana a la Piedra.";
                txt_instrucciolinea3 = "En caso de empate se jugara de nuevo sin cambios en los resultados si no habeis pasado la 3a ronda.";
                txt_instrucciolinea4 = "Se juega al mejor de 3, en caso de llegar a la tercera ronda, ganara el primero en ganar la proxima ronda.";
                break;
            }
            case 3: { // Idioma anglès. Traducció del text de les variables a anglès.
                seleccio[1] = "ROCK";
                seleccio[2] = "PAPER";
                seleccio[3] = "SCISSORS";
                txt_triar = "Choose an option: ";
                txt_jugar = "PLAY";
                txt_idioma = "LANGUAGE";
                txt_instruccions = "INSTRUCTIONS";
                txt_sortir = "EXIT";
                txt_jugador = "Player";
                txt_empat = "You tied.";
                txt_guanyar = "You won the round.";
                txt_perdre = "You've lost the round.";
                txt_guanyarfinal = "YOU WON";
                txt_perdrefinal = "YOU LOST";
                txt_ronda = "ROUND";
                txt_resultat = "SCORE";
                txt_tornarajugar = "PLAY AGAIN";
                txt_tornarmenu = "BACK TO MENU";
                txt_continuar = "CONTINUE";
                txt_haselegit = "You have chosen";
                txt_haelegit = "has chosen";
                txt_rondesjugades = "Played rounds";
                txt_instrucciolinea1 = "Choose Rock, Paper or Scissors.";
                txt_instrucciolinea2 = "Rock wins to Scissors - Scissors wins to Paper - Paper wins to Rock.";
                txt_instrucciolinea3 = "In case of a tie, it will continue without changes in the results if you haven't passed the 3rd round yet.";
                txt_instrucciolinea4 = "The best of 3 rounds will win, in case of reaching to the third round, the first to win the next round will win.";
                break;
            }
        }
        app.clearScreen();
        victoriesjugador = victoriesmaquina = rondes = 0;
        // Menú principal.
        System.out.println(seleccio[1] + " - " + seleccio[2] + " - " + seleccio[3] + "\n"); // '\n' crea un espai delínia. Al principi: crea un espai abans. Al final: crea un espai després.
        System.out.println("[1] " + txt_jugar);
        System.out.println("[2] " + txt_idioma + " (" + idiomes[idioma] + ")");
        System.out.println("[3] " + txt_instruccions);
        System.out.println("[9] " + txt_sortir);
        System.out.println("\n" + txt_triar);
        teclat = new Scanner(System.in); // Demana opció per teclat.
        if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
            app.iniciarMenu();
        }
        menu = teclat.nextInt(); // Inserta el valor de la opció en valor sencer dins la variable menu.
        switch (menu) { // Comprova el valor de la variable menu i executa el cas del nombre demanat.
            case 1:
                app.pantalla1Joc(); // Executa la funció pantalla1Joc() - (Línia 132).
            case 2:
                app.pantallaIdioma(); // Executa la funció pantallaIdioma() - (Línia 218).
            case 3:
                app.pantallaInstruccions(); // Executa la funció pantallaInstruccions() - (Línia 239).
            case 9:
                System.exit(0); // Surt de l'aplicació.
            default:
                app.iniciarMenu(); // Torna a executar el menú fins introduir una opció correcta. - (Línia 20).
            }
        }

        public void pantalla1Joc() { // Funció - Primera pantalla del Joc.
            app.clearScreen();
            System.out.println("(" + victoriesjugador + ") " + txt_jugador + " vs PC (" + victoriesmaquina + ")\n");
            System.out.println("1 - " + seleccio[1]); // Pedra.
            System.out.println("2 - " + seleccio[2]); // Paper.
            System.out.println("3 - " + seleccio[3]); // Tisora.
            System.out.println("\n" + txt_triar);
            teclat = new Scanner(System.in); // Demana opció per teclat.
            if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
                app.pantalla1Joc();
            }
            elecciojugador = teclat.nextInt(); // Inserta el valor de la opció en valor sencer dins la variable elecciojugador.
            switch (elecciojugador) { // Revisa si s'ha introduit un nombre correcte.
            case 1:
            case 2:
            case 3: {
                elecciomaquina = (int) (Math.random() * 3) + 1; // Crea un nombre aleatori de l'1 al 3.
                rondes++; // Augmenta la variable rondes.
                if (elecciojugador == elecciomaquina) { // Condiciona el resultat de la ronda i inserta text dins la
                                                        // variable resultat.
                    resultat = txt_empat;
                } else if (elecciojugador == 1 && elecciomaquina == 3 || elecciojugador == 2 && elecciomaquina == 1
                        || elecciojugador == 3 && elecciomaquina == 2) {
                    resultat = txt_guanyar;
                    victoriesjugador++; // Incrementa el resultat del guanyador (Jugador).
                } else {
                    resultat = txt_perdre;
                    victoriesmaquina++; // Incrementa el resultat del guanyador (PC).
                }
                if (victoriesjugador == 3 || victoriesjugador == 1 && victoriesmaquina == 0 && rondes >= 3
                        || victoriesjugador == 2 && victoriesmaquina == 1 || victoriesjugador == 2 && rondes >= 3) { // Si qualcú guanya, inserta dins la variable txt_resultatfinal el resultat final (Guanyat o perdut) i acaba el joc.
                    txt_resultatfinal = txt_guanyarfinal;
                    app.fiJoc();
                } else if (victoriesmaquina == 3 || victoriesjugador == 0 && victoriesmaquina == 1 && rondes >= 3
                        || victoriesjugador == 1 && victoriesmaquina == 2 || victoriesmaquina == 2 && rondes >= 3) {
                    txt_resultatfinal = txt_perdrefinal;
                    app.fiJoc();
                }
                app.pantalla2Joc(); // Executa la segona pantalla del joc.
            }
            default: { // Si no s'ha introduit 1, 2 o 3 (Pedra, paper o tisores) torna a la primera pantalla del joc, tornant a demanar l'opció.
                app.pantalla1Joc();
            }
        }
    }

    public void pantalla2Joc() { // Funció - Segona pantalla del joc. Mostra els resultats de la ronda i les eleccions.
        app.clearScreen(); // Renta pantalla.
        System.out.println(txt_ronda + " " + rondes);
        System.out.println(txt_resultat + ": (" + victoriesjugador + "-" + victoriesmaquina + ")");
        System.out.println("\n" + txt_haselegit + " " + seleccio[elecciojugador]);
        System.out.println("PC " + txt_haelegit + " " + seleccio[elecciomaquina]);
        System.out.println("\n" + seleccio[elecciojugador] + " vs " + seleccio[elecciomaquina]);
        System.out.println(resultat);
        System.out.println("\n[1] " + txt_continuar);
        System.out.println("[2] " + txt_tornarmenu);
        System.out.println("[9] " + txt_sortir);
        System.out.println("\n" + txt_triar);
        teclat = new Scanner(System.in); // Demana la opció per teclat.
        if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
            app.pantalla2Joc();
        }
        menujoc = teclat.nextInt(); // Inserta el valor de la opció dins la variable menujoc.
        switch (menujoc) {
            case 1:
                app.pantalla1Joc();
            case 2:
                app.iniciarMenu();
            case 9:
                System.exit(0);
            default:
                app.pantalla2Joc();
        }
    }

    public void fiJoc() { // Funció - Pantalla final del joc.
        app.clearScreen();
        System.out.println(txt_resultatfinal + "\n");
        System.out.println(txt_resultat + ": (" + victoriesjugador + "-" + victoriesmaquina + ")");
        System.out.println(txt_rondesjugades + ": " + rondes);
        System.out.println("\n[1] " + txt_tornarajugar);
        System.out.println("[2] " + txt_tornarmenu);
        System.out.println("[9] " + txt_sortir);
        System.out.println("\n" + txt_triar);
        teclat = new Scanner(System.in); // Demana una opció per teclat.
        if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
            app.fiJoc();
        }
        menujoc = teclat.nextInt(); // Inserta la opció introduida dins la variable menujoc.
        switch (menujoc) {
            case 1:
                victoriesjugador = victoriesmaquina = rondes = 0;
                app.pantalla1Joc();
            case 2:
                app.iniciarMenu();
            case 9:
                System.exit(0);
            default:
                app.fiJoc();
        }
    }

    public void pantallaIdioma() { // Funció - Pantalla d'idioma.
        app.clearScreen(); // Renta pantalla.
        System.out.println("IDIOMA - LANGUAGE \n");
        System.out.println("[1] " + idiomes[1]);
        System.out.println("[2] " + idiomes[2]);
        System.out.println("[3] " + idiomes[3]);
        System.out.println("[9] " + txt_sortir);
        System.out.println("\n" + txt_triar);
        teclat = new Scanner(System.in); // Demana una opció per teclat.
        if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
            app.pantallaIdioma();
        }
        idioma = teclat.nextInt(); // Inserta el valor de la opció dins la variable idioma.
        switch (idioma) {
            case 1:
            case 2:
            case 3:
                app.iniciarMenu();
            case 9:
                System.exit(0);
            default:
                app.pantallaIdioma();
        }
    }

    public void pantallaInstruccions() { // Funció - Pantalla d'instruccions.
        app.clearScreen(); // Renta pantalla.
        System.out.println(txt_instruccions);
        System.out.println("\n" + txt_instrucciolinea1);
        System.out.println(txt_instrucciolinea2);
        System.out.println(txt_instrucciolinea3);
        System.out.println(txt_instrucciolinea4);
        System.out.println("\n[1] " + txt_tornarmenu);
        System.out.println("[9] " + txt_sortir);
        System.out.println("\n" + txt_triar);
        teclat = new Scanner(System.in); // Demana una opció per teclat.
        if (!teclat.hasNextInt()) { // Comprovació: si no és un nombre sencer torna a demanar.
            app.pantallaInstruccions();
        }
        instruccions = teclat.nextInt(); // Inserta el valor de la opció dins la variable instruccions.
        switch (instruccions) {
            case 1:
                app.iniciarMenu();
            case 9:
                System.exit(0);
            default:
                app.pantallaInstruccions();
        }
    }
}