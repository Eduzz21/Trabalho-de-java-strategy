
public class CajadoArcano implements Arma {
    @Override public String getNome() { return "Cajado Arcano"; }
    @Override public int getDanoBase() { return 8; }
    @Override public int getCustoMana() { return 25; }
    
    @Override 
    public boolean podeUsar(Personagem p) {
        // Requisito: Inteligência ≥ 12 e ser da classe correta
        return p.getInteligencia() >= 12 && p.podeUsarTipo(this);
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " conjura Magia com o Cajado Arcano.");
        alvo.receberDano(getDanoBase());
        
        // Efeito Especial: Queimadura
        System.out.println("    [ESPECIAL] Bola de Fogo atinge " + alvo.getNome() + "! (Queimadura aplicada)");
        alvo.adicionarEfeito(new Queimadura());
    }
}