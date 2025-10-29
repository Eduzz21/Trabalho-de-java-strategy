import java.util.Random;

public class EspadaLonga implements Arma {
    @Override public String getNome() { return "Espada Longa"; }
    @Override public int getDanoBase() { return 15; }
    @Override public int getCustoMana() { return 0; }
    
    @Override 
    public boolean podeUsar(Personagem p) {
        // Requisito: Força ≥ 10 e ser da classe correta
        return p.getForca() >= 10 && p.podeUsarTipo(this);
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com a Espada Longa.");
        alvo.receberDano(getDanoBase());
        
        // Efeito Especial: Sangramento (30% de chance)
        if (new Random().nextDouble() < 0.30) {
            System.out.println("    [ESPECIAL] " + alvo.getNome() + " sofre Corte Profundo! (Sangramento aplicado)");
            alvo.adicionarEfeito(new Sangramento());
        }
    }
}