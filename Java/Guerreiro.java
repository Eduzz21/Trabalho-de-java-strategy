public class Guerreiro extends Personagem {
    // Força 15, Destreza 8, Inteligência 5 | Vida 120, Mana 50
    public Guerreiro() {
        super("Guerreiro", 15, 8, 5, 120, 50);
    }
    // Habilidade Passiva: "Pele Dura" - Reduz dano recebido em 20%
    @Override public double getReducaoDanoPassiva() { return 0.20; } 
    
    // Pode usar Espadas e Machados
    @Override public boolean podeUsarTipo(Arma arma) {
        return arma instanceof EspadaLonga || arma instanceof MachadodeGuerra;
    }
}