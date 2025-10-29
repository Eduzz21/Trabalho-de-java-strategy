
public class ArcoElfico implements Arma {
    @Override public String getNome() { return "Arco Elfico"; }
    @Override public int getDanoBase() { return 12; }
    @Override public int getCustoMana() { return 15; }
    
    @Override 
    public boolean podeUsar(Personagem p) {
        // Requisito: Destreza ≥ 8 e ser da classe correta
        return p.getDestreza() >= 8 && p.podeUsarTipo(this);
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        // Ataque em Área: Simplificado para dano maior no alvo único
        int dano = (int) (getDanoBase() * 1.5);
        System.out.println(atacante.getNome() + " dispara uma Chuva de Flechas contra " + alvo.getNome() + " (Dano em área simulado).");
        alvo.receberDano(dano);
    }
}