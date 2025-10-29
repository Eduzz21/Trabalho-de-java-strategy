public class Atordoado implements StatusEffect {
    private int turnos = 1;
    
    @Override public String getNome() { return "Atordoado"; }
    @Override public int getTurnosRestantes() { return turnos; }
    @Override public boolean isTerminado() { return turnos <= 0; }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        if (!isTerminado()) {
            System.out.println("    [EFEITO] " + alvo.getNome() + " está atordoado e perderá o próximo turno!");
            turnos--;
        }
    }
}