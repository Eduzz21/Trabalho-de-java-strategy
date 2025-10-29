public interface StatusEffect {
    String getNome();
    int getTurnosRestantes();
    
    // Aplica o dano ou efeito ao alvo
    void aplicarEfeito(Personagem alvo);
    
    // Verifica se o efeito terminou
    boolean isTerminado();
}