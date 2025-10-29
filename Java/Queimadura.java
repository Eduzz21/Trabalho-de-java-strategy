public class Queimadura implements StatusEffect {
    private int turnos = 2;
    private final int danoPorTurno = 10;
    
    @Override public String getNome() { return "Queimadura"; }
    @Override public int getTurnosRestantes() { return turnos; }
    @Override public boolean isTerminado() { return turnos <= 0; }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        if (!isTerminado()) {
            System.out.println("    [EFEITO] " + alvo.getNome() + " sofre dano de Queimadura: -" + danoPorTurno + " HP. Turnos restantes: " + (turnos-1));
            alvo.receberDano(danoPorTurno);
            turnos--;
        }
    }
}