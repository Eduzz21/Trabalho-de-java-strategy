



public class Arqueiro extends Personagem {
    // Força 8, Destreza 15, Inteligência 7 | Vida 90, Mana 80
    public Arqueiro() {
        super("Arqueiro", 8, 15, 7, 90, 80);
    }
    // Habilidade Passiva: "Esquiva" (Não implementada aqui, ficaria na classe Batalha)
    @Override public double getReducaoDanoPassiva() { return 0.0; } 
    
    // Pode usar Arcos e Adagas
    @Override public boolean podeUsarTipo(Arma arma) {
        return arma instanceof ArcoElfico || arma instanceof AdagaSombria;
    }
}