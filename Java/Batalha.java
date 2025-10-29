public class Batalha {
    private Personagem jogador1;
    private Personagem jogador2;
    private int turno = 0;

    public Batalha(Personagem p1, Personagem p2) {
        this.jogador1 = p1;
        this.jogador2 = p2;
        System.out.println("\n<<< BATALHA INICIADA: " + p1.getNome() + " vs " + p2.getNome() + " >>>");
    }

    public void proximoTurno() {
        if (!jogador1.estaVivo() || !jogador2.estaVivo()) {
            encerrarBatalha();
            return;
        }
        
        turno++;
        System.out.println("\n\n=============== TURNO " + turno + " ===============");

        // Turno do Jogador 1
        gerenciarTurno(jogador1, jogador2);
        
        if (!jogador2.estaVivo()) {
            encerrarBatalha();
            return;
        }

        // Turno do Jogador 2
        gerenciarTurno(jogador2, jogador1);
    }
    
    private void gerenciarTurno(Personagem atacante, Personagem alvo) {
        if (!atacante.estaVivo()) return;

        // 1. Aplicar Efeitos e Passivas
        atacante.aplicarEfeitosDoTurno();
        if (atacante instanceof Mago) ((Mago) atacante).regenerarManaTurno();

        // 2. Ação de Ataque
        if (atacante.estaVivo()) {
            atacante.atacar(alvo);
        }
    }

    private void encerrarBatalha() {
        String vencedor = jogador1.estaVivo() ? jogador1.getNome() : (jogador2.estaVivo() ? jogador2.getNome() : "Ninguém");
        System.out.println("\n\n<<< BATALHA ENCERRADA! Vencedor: " + vencedor + " >>>");
    }
}