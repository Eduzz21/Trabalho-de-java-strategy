
public class AdagaSombria implements Arma {
    @Override public String getNome() { return "Adaga Sombria"; }
    @Override public int getDanoBase() { return 10; }
    @Override public int getCustoMana() { return 10; }
    
    @Override 
    public boolean podeUsar(Personagem p) {
        // Requisito: Destreza ≥ 12 e ser da classe correta
        return p.getDestreza() >= 12 && p.podeUsarTipo(this);
    }

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        
        // Condição: Alvo desprevenido (com atordoado, queimadura ou sangramento)
        boolean desprevenido = alvo.efeitos.stream().anyMatch(e -> e instanceof Atordoado || e instanceof Queimadura || e instanceof Sangramento);
        
        if (desprevenido) {
            dano *= 3; // Dano triplo
            System.out.println("    [ESPECIAL] Ataque Furtivo em alvo desprevenido! Dano Triplo!");
        }
        
        System.out.println(atacante.getNome() + " apunhala " + alvo.getNome() + " com a Adaga Sombria.");
        alvo.receberDano(dano);
    }
}