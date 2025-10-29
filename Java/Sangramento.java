public class Sangramento implements StatusEffect {
    private int turnos = 3;
    private final int danoPorTurno = 5;
    
    @Override public String getNome() { return "Sangramento"; }
    @Override public int getTurnosRestantes() { return turnos; }
    @Override public boolean isTerminado() { return turnos <= 0; }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        if (!isTerminado()) {
            System.out.println("    [EFEITO] " + alvo.getNome() + " sofre dano de Sangramento: -" + danoPorTurno + " HP. Turnos restantes: " + (turnos-1));
            alvo.receberDano(danoPorTurno);
            turnos--;
        }
    }
}