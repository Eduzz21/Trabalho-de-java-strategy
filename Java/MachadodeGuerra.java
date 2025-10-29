import java.util.Random;

public class MachadodeGuerra implements Arma {
    @Override public String getNome() { return "Machado de Guerra"; }
    @Override public int getDanoBase() { return 18; }
    @Override public int getCustoMana() { return 5; }
    
    @Override 
    public boolean podeUsar(Personagem p) {
        // Requisito: Força ≥ 15 e ser da classe correta
        return p.getForca() >= 15 && p.podeUsarTipo(this);
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " desfere um Golpe Esmagador em " + alvo.getNome() + ".");
        alvo.receberDano(getDanoBase());
        
        // Efeito Especial: Atordoamento (25% de chance)
        if (new Random().nextDouble() < 0.25) {
            System.out.println("    [ESPECIAL] " + alvo.getNome() + " foi atordoado! Perderá o próximo turno.");
            alvo.adicionarEfeito(new Atordoado());
        }
    }
}