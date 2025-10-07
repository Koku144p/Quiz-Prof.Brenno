import java.util.Scanner;

/**
 * Classe que representa uma questão de múltipla escolha.
 */
public class Questao {
    String pergunta;
    String opcaoA;
    String opcaoB;
    String opcaoC;
    String opcaoD;
    String opcaoE;
    String correta;

    // Construtor para facilitar a criação das questões
    public Questao(String pergunta, String a, String b, String c, String d, String e, String correta) {
        this.pergunta = pergunta;
        this.opcaoA = "A) " + a;
        this.opcaoB = "B) " + b;
        this.opcaoC = "C) " + c;
        this.opcaoD = "D) " + d;
        this.opcaoE = "E) " + e;
        this.correta = correta.toUpperCase(); // Letra da alternativa correta
    }

    // Exibe a questão no console
    public void escrevaQuestao() {
        System.out.println(pergunta);
        System.out.println(opcaoA);
        System.out.println(opcaoB);
        System.out.println(opcaoC);
        System.out.println(opcaoD);
        System.out.println(opcaoE);
        System.out.println();
    }

    // Verifica se a resposta está correta
    public boolean isCorreta(String resposta) {
        if (resposta.equalsIgnoreCase(this.correta)) {
            System.out.println("✅ Parabéns! Resposta correta.\n");
            return true;
        } else {
            System.out.println(" Resposta errada.");
            System.out.println(" A opção correta era: " + this.correta + "\n");
            return false;
        }
    }

    // ler o a resposta
    public String leiaResposta(Scanner ler) {
        String resp;
        do {
            System.out.print("Digite a resposta (A, B, C, D ou E): ");
            resp = ler.nextLine().trim().toUpperCase();
        } while (!respostaValida(resp));
        return resp;
    }

    // Verifica a validez
    private boolean respostaValida(String resp) {
        return resp.equalsIgnoreCase("A") ||
               resp.equalsIgnoreCase("B") ||
               resp.equalsIgnoreCase("C") ||
               resp.equalsIgnoreCase("D") ||
               resp.equalsIgnoreCase("E");
    }

    // Codigo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 15 Questões
        Questao[] questoes = new Questao[] {
            new Questao("Qual a frase clássica do Pernalonga?",
                "Olá, tudo bem?", "E ai, tudo em cima?", "O que que há, velhinho?", "Oi, sou pernalonga", "Isso é tudo pe-pe-pessoal", "C"),

            new Questao("Em que pais o pintor Picasso nasceu?",
                "Espanha", "Africa", "Holanda", "França", "Belgica", "A"),

            new Questao("Qual desses musicos nunca integrou o grupo dos Beatles?",
                "George Harrison", "Paul Mccartney", "Ringo Starr", "Eric Clapton", "Mick Jagger", "D"),

            new Questao("Qual elemento químico tem o símbolo H?",
                "Hidrogênio", "Hélio", "Mercúrio", "Háfnio", "Hidroxila", "A"),

            new Questao("Qual a sigla da Iduntância?",
                "L", "P", "K", "O", "M", "A"),

            new Questao("Qual unico jogo citado que tem uma bola pequena?",
                "Badminton", "Futebol", "Basquete", "Volei", "Ping Pong", "E"),

            new Questao("Quem é a mulher do Tarzan?",
                "Chita", "Chiquinha", "Jane", "Lane", "Dina", "C"),

            new Questao("Qual orgão do corpo humano representa o sentimento de amor?",
                "Pulmão", "Intestino", "Estômago", "Coração", "Mão", "D"),

            new Questao("Como se chamava a cangaceira e companheira de Lampião??",
                "Maria Bela", "Maria Linda", "Maria Elegante", "Maria Bonita", "Maria Maravilhosa", "D"),

            new Questao("Qual a cor que resulta da mistura do amarelo com azull?",
                "Roxo", "1Laranja", "Verde", "Anil", "Pink", "C"),

            new Questao("Qual destes jogadores jamais foi campeão da copa du mundonjogando pela seleção brasileira?",
                "Ronaldo Fenômeno", "Vampeta", "Zico", "Edmilson", "Ronaldinho Gaúcho", "C"),

            new Questao("Ao comprar três duzias e meia de ovos você estará levanto quantos ovos?",
                "26 ovos", "32 ovos", "36 ovos", "40 ovos", "42 ovos", "E"),

            new Questao("Quem foi o primeiro imperador de Roma?",
                "Constantino", "Augusto", "Nero", "Trajano", "Julio", "B"),

            new Questao("Eu fiz, tu fizeste, ele fez, nos fizemos e vós...?",
                "Fizeis", "Fizestes", "Fissamo", "Fizais", "Fizéreis", "B"),

            new Questao("Um carro que possui tração nas 4 rodas pode ser chamado de:",
                "Tração traseira", "Tração 2x2", "Tração 4x4", "Tração dianteira", "Tração 4x2", "C")
        };

        int acertos = 0;

        // Codigo para passar por todas perguntas
        for (int i = 0; i < questoes.length; i++) {
            System.out.println("🔹 Questão " + (i + 1) + " de " + questoes.length);
            questoes[i].escrevaQuestao();

            String resposta = questoes[i].leiaResposta(scanner);

            if (questoes[i].isCorreta(resposta)) {
                acertos++;
            }
        }

        // Porcentagem
        double porcentagem = (double) acertos / questoes.length * 100;

        // Final
        System.out.println("Você acertou " + acertos + " de " + questoes.length + " questões.");
        System.out.printf("Porcentagem de acertos: %.2f%%\n", porcentagem);

        scanner.close();
    }
}
