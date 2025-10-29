public class Mago extends Personagem {
    // Força 5, Destreza 7, Inteligência 18 | Vida 70, Mana 150
    public Mago() {
        super("Mago", 5, 7, 18, 70, 150);
    }
    @Override public double getReducaoDanoPassiva() { return 0.0; }
    
    // Habilidade Passiva: "Regeneração de Mana" +10 mana por turno
    public void regenerarManaTurno() { 
        regenerarMana(10); 
        System.out.println("    [PASSIVA] Regeneracao de Mana: +10 Mana. Atual: " + manaAtual); 
    }
    
    // Pode usar Cajados e Adagas
    @Override public boolean podeUsarTipo(Arma arma) {
        return arma instanceof CajadoArcano || arma instanceof AdagaSombria;
    }
}