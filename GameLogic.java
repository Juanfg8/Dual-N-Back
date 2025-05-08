import java.util.Random;

public class GameLogic {
    private final LinkedListInt sequence = new LinkedListInt();
    private final Random random = new Random();
    private final int nBack = 2; // Jogo 1-back
    private boolean aguardandoResposta = false;
    private boolean eraMatch = false;
    private int stimuliSinceLastMatch = 0; // Contador de estímulos desde o último match
    private final int MAX_STIMULI_WITHOUT_MATCH = 4; // Garante match até o 4º estímulo

    public void addRandomPosition() {
        // Verifica se houve omissão (não respondeu quando deveria)
        if (aguardandoResposta && eraMatch) {
            System.out.println("Errou! Você deveria ter apertado a barra de espaço.");
        }

        stimuliSinceLastMatch++; // Incrementa para cada novo estímulo apresentado

        // Gera nova posição aleatória
        int pos;
        // LÓGICA PARA FORÇAR MATCH (PONTO 2)
        // Só podemos forçar um match se já houver itens suficientes para comparar com nBack.
        // E se o contador atingiu o limite.
        if (sequence.size() >= nBack && stimuliSinceLastMatch >= MAX_STIMULI_WITHOUT_MATCH) {
            pos = sequence.get(sequence.size() - nBack); // Pega o valor que estava N posições atrás
                                                        // sequence.size() aqui é ANTES de adicionar o novo 'pos'
        } else {
            // Gera nova posição aleatória (1 a 9, conforme PONTO 1)
            pos = random.nextInt(9) + 1;
        }

        
        sequence.add(pos);

        // Exibe a sequência (debug)
        System.out.print("Sequência atualizada: ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();

        // Define se esta rodada será um match
        int size = sequence.size();
        if (size > nBack) { // Só pode haver match se houver pelo menos nBack+1 elementos
            int atual = sequence.get(size - 1);
            int anterior = sequence.get(size - 1 - nBack);
            eraMatch = (atual == anterior);

            if (eraMatch) {
                stimuliSinceLastMatch = 0; // Reseta o contador porque um match acabou de acontecer
            }
            aguardandoResposta = true; // Sempre aguarda resposta se um match é possível
        } else {
            eraMatch = false;
            aguardandoResposta = false; // Não aguarda se não há itens suficientes para N-Back
        }
    }

    // Não usamos mais essa função no pressionar da tecla, mas pode ser útil para testes
    public boolean checkMatch() {
        int size = sequence.size();
        if (size > nBack) {
            int atual = sequence.get(size - 1);
            int anterior = sequence.get(size - 1 - nBack);
            System.out.println("Posição atual: " + atual);
            System.out.println("Posição anterior (" + nBack + "-back): " + anterior);
            return atual == anterior;
        }
        return false;
    }

    public Integer getCurrentPosition() {
        if (sequence.size() == 0) return null;
        return sequence.getLast();
    }

    public boolean isAguardandoResposta() {
        return aguardandoResposta;
    }

    public void setAguardandoResposta(boolean aguardandoResposta) {
        this.aguardandoResposta = aguardandoResposta;
    }

    public boolean isEraMatch() {
        return eraMatch;
    }
}
