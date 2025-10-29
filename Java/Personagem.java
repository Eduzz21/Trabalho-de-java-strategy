import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vidaAtual, vidaMax;
    protected int manaAtual, manaMax;
    protected Arma armaAtual;
    public List<StatusEffect> efeitos = new ArrayList<>(); // Tornar público para AdagaSombria

    public Personagem(String nome, int f, int d, int i, int v, int m) {
        this.nome = nome; this.forca = f; this.destreza = d; this.inteligencia = i;
        this.vidaMax = v; this.vidaAtual = v; this.manaMax = m; this.manaAtual = m;
        System.out.println(nome + " (HP: " + vidaMax + ", Mana: " + manaMax + ") foi criado.");
    }
    
    public void equiparArma(Arma novaArma) {
        if (novaArma.podeUsar(this)) {
            this.armaAtual = novaArma;
            System.out.println("C " + nome + " equipou: " + novaArma.getNome());
        } else {
            System.out.println("X " + nome + " Nao pode equipar " + novaArma.getNome() + ". Requisitos nao atendidos.");
        }
    }

    public void atacar(Personagem alvo) {
        System.out.println("\n--- TURNO DE " + nome + " ---");

        if (efeitos.stream().anyMatch(e -> e instanceof Atordoado && e.getTurnosRestantes() > 0)) {
            System.out.println(nome + " esta atordoado e nao pode atacar!");
            return;
        }

        if (armaAtual != null) {
            if (manaAtual >= armaAtual.getCustoMana()) {
                // DELEGAÇÃO: Chamada à Estratégia
                armaAtual.atacar(this, alvo); 
                manaAtual -= armaAtual.getCustoMana();
                System.out.println("    Mana restante: " + manaAtual);
            } else {
                System.out.println(nome + " (Mana: " + manaAtual + ") sem Mana suficiente para usar " + armaAtual.getNome());
            }
        } else {
            System.out.println(nome + " nao tem arma equipada! Fazendo Dano Base Fraco.");
            alvo.receberDano(5);
        }
    }

    public void adicionarEfeito(StatusEffect efeito) {
        if (efeitos.stream().noneMatch(e -> e.getNome().equals(efeito.getNome()))) {
            efeitos.add(efeito);
        }
    }

    public void receberDano(int danoBruto) {
        int danoFinal = (int) (danoBruto * (1.0 - getReducaoDanoPassiva()));
        vidaAtual -= danoFinal;
        System.out.println("    " + nome + " recebeu " + danoFinal + " de dano. HP restante: " + vidaAtual + "/" + vidaMax);
        if (vidaAtual <= 0) {
            System.out.println("!!! " + nome + " foi derrotado! !!!");
        }
    }

    public void aplicarEfeitosDoTurno() {
        if (!efeitos.isEmpty()) {
            System.out.println("  [Status de " + nome + "]");
            List<StatusEffect> efeitosAtivos = new ArrayList<>(efeitos);
            
            for (StatusEffect efeito : efeitosAtivos) {
                efeito.aplicarEfeito(this);
            }
            // Remove efeitos que terminaram após a aplicação
            efeitos.removeIf(StatusEffect::isTerminado);
        }
    }
    
    public abstract double getReducaoDanoPassiva();
    public abstract boolean podeUsarTipo(Arma arma); 

    // Getters
    public String getNome() { return nome; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getInteligencia() { return inteligencia; }
    public int getVidaAtual() { return vidaAtual; }
    public boolean estaVivo() { return vidaAtual > 0; }
    public void regenerarMana(int quantidade) { this.manaAtual = Math.min(manaMax, manaAtual + quantidade); }
}